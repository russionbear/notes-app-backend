package com.russionbear.notesapp.backend.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GlobalCorsConfig {

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")// 对所有请求路径
////                        .allowedOrigins("*")// 允许所有域名
//                        .allowedOriginPatterns("*")// 允许所有域名
//                        .allowCredentials(true)// 允许cookie等凭证
//                        .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH")// 允许所有方法
//                        .maxAge(3600);
//            }
//        };
//    }


    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addExposedHeader("*");
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        //3. 返回新的CorsFilter
        return new CorsFilter( corsConfigurationSource);
    }


//    @Bean
//    public CorsFilter corsFilter() {
//        //1. 添加 CORS配置信息
//        CorsConfiguration config = new CorsConfiguration();
//        //放行哪些原始域
//        config.addAllowedOrigin("*");
//        //是否发送 Cookie
//        config.setAllowCredentials(true);
//        //放行哪些请求方式
//        config.addAllowedMethod("*");
//        //放行哪些原始请求头部信息
//        config.addAllowedHeader("*");
//        //暴露哪些头部信息
//        config.addExposedHeader("*");
//        //2. 添加映射路径
//        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
//        corsConfigurationSource.registerCorsConfiguration("/**",config);
//        //3. 返回新的CorsFilter
//        return new CorsFilter((CorsConfigurationSource) corsConfigurationSource);
//    }
}
