package com.codegym.baitap1.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    // Không cần viết thêm bất cứ dòng code nào vào đây.
    // Sự tồn tại của class này, kế thừa từ AbstractSecurityWebApplicationInitializer,
    // sẽ tự động đăng ký bộ lọc springSecurityFilterChain cho mọi URL trong ứng dụng của bạn.
}