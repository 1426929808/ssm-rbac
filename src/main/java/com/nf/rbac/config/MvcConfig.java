package com.nf.rbac.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.nf.rbac.interceptor.PrivilegeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author cj
 * @date 2019/11/25
 */

@Configuration
@EnableWebMvc
@ComponentScan({"com.nf.rbac.controller", "com.nf.rbac.interceptor"})
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    private PrivilegeInterceptor privilegeInterceptor;

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistry = registry.addInterceptor(privilegeInterceptor);
        interceptorRegistry.addPathPatterns("/admin/**");
        interceptorRegistry.excludePathPatterns("/static/**")
                .excludePathPatterns("/login/**") //显示视图(/login)与处理登录(/login/query)
                .excludePathPatterns("/unauthorized");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        ResourceHandlerRegistration registration
                = registry.addResourceHandler("/static/**");
        registration.addResourceLocations("classpath:/static/");
    }

    /**
     * 这里添加的转换器不会添加默认转换器,
     * 如果想在保留默认转换器的情况下添加消息转换器,可以重写extendMessageConverters方法
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(sdf);
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(objectMapper);
        converters.add(converter);
    }


}
