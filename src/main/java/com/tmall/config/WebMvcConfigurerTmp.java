
package com.tmall.config;

import com.tmall.interceptor.LoginInterceptor;
import com.tmall.interceptor.OtherInterceptor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.config.annotation.*;



@Configuration
class WebMvcConfigurerTmp implements WebMvcConfigurer {

	@Bean
	public OtherInterceptor getOtherIntercepter() {
		return new OtherInterceptor();
	}
	@Bean
	public LoginInterceptor getLoginIntercepter() {
		return new LoginInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(getOtherIntercepter())
				.addPathPatterns("/**");
		registry.addInterceptor(getLoginIntercepter())
				.addPathPatterns("/**");
	}


	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//所有请求都允许跨域
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("*")
				.allowedHeaders("*");
	}


}


