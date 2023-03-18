//package com.tus.athlone.hotel;
//
//import java.util.Locale;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.LocaleResolver;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
//import org.springframework.web.servlet.i18n.SessionLocaleResolver;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
//@Configuration
//public class HotelConfig {
//	
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(localeChangeInterceptor());
//    }
//	
//    @Bean
//    public LocaleResolver localeResolver() {
//        SessionLocaleResolver slr = new SessionLocaleResolver();
//        slr.setDefaultLocale(Locale.US);
//        return slr;
//    }
//
//    @Bean
//    public LocaleChangeInterceptor localeChangeInterceptor() {
//        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
//        lci.setParamName("lang");
//        return lci;
//    }
//
//	@Bean
//	public ViewResolver viewResolver() {
//		
//		InternalResourceViewResolver bean= new InternalResourceViewResolver();
//		bean.setPrefix("/WEB-INF/");
//		bean.setSuffix(".jsp");
//		bean.setOrder(0);
//		return bean;
//	}
//	
//
//
//}
