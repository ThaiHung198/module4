package com.codegym.baitap1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Bean để mã hóa mật khẩu, rất quan trọng cho bảo mật
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Bean cung cấp thông tin người dùng.
    // Tạm thời, chúng ta tạo người dùng trong bộ nhớ để kiểm thử.
    // Trong dự án thực tế, bạn sẽ lấy thông tin từ database ở đây.
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("12345")) // Mật khẩu là "12345"
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin")) // Mật khẩu là "admin"
                .roles("ADMIN", "USER") // Admin có cả 2 vai trò
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    // Bean cấu hình các quy tắc bảo mật cho các request HTTP
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .antMatchers("/").permitAll()
                        .antMatchers("/category/**").hasRole("ADMIN")
                        .antMatchers("/blogs","blogs/create","blogs/edit","blogs/delete").hasRole("USER")
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        // THÊM DÒNG NÀY VÀO:
                        // Chuyển hướng đến "/blogs" sau khi đăng nhập thành công.
                        // tham số 'true' để luôn luôn chuyển hướng về đây.
                        .defaultSuccessUrl("/blogs", true)
                        .permitAll()
                )
                .logout((logout) -> logout
                        // Bạn cũng có thể cấu hình trang sẽ đến sau khi logout
                        .logoutSuccessUrl("/blogs")
                        .permitAll()
                );

        return http.build();
    }
}