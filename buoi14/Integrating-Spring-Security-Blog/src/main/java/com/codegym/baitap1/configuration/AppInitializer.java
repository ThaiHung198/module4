package com.codegym.baitap1.configuration;

import com.codegym.baitap1.security.SecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // Để trống hoặc trả về null
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // Load CẢ HAI file cấu hình ở đây
        return new Class[]{AppConfiguration.class, SecurityConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}