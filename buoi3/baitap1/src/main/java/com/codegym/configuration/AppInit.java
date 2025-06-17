package com.codegym.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit  extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // Để trống vì chúng ta không có tầng service riêng biệt trong cấu hình này
        return new Class[]{};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // Đặt AppConfiguration vào đây
        return new Class[]{AppConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}