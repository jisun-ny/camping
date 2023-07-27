package com.camping.site.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class LayoutConfig {

    /*
        Thymeleaf Layout Dialect 를 사용하여 레이아웃 기능을 활성화하기 위한 Java Config 설정
        Spring Boot 프로젝트에서 Thymeleaf 레이아웃 기능을 사용하려면 Thymeleaf Dialect 와 템플릿 리졸버를 설정
     */

    @Bean // Thymeleaf 에 레이아웃 기능을 추가하는 Dialect
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

    @Bean // 템플릿 리졸버를 생성하여 반환하는 메서드
    public ClassLoaderTemplateResolver templateResolver() {
        // classpath 에서 템플릿 파일을 찾을 때 사용
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        // 템플릿 파일이 위치하는 디렉토리를 지정
        templateResolver.setPrefix("templates/");
        // 템플릿 파일의 확장자를 지정
        templateResolver.setSuffix(".html");
        // 템플릿 파일의 모드를 지정
        templateResolver.setTemplateMode(TemplateMode.HTML);
        // 템플릿 파일의 문자 인코딩을 지정
        templateResolver.setCharacterEncoding("UTF-8");
        // 템플릿 리졸버의 우선순위를 지정
        // 여러 개의 템플릿 리졸버가 있을 경우 우선순위를 통해 사용할 리졸버를 결정
        // 0이 가장 높은 우선순위를 의미
        templateResolver.setOrder(0);
        // 템플릿 파일의 존재 여부를 확인할 지 여부를 지정
        // 템플릿 파일의 존재 여부를 확인하고, 없을 경우 에러를 발생
        templateResolver.setCheckExistence(true);
        // 생성된 템플릿 리졸버는 Spring Template Engine 에서 템플릿 파일을 찾는 데 사용
        return templateResolver;
    }

    @Bean // Spring Template Engine 을 생성하여 반환하는 메서드
    public SpringTemplateEngine templateEngine() {
        // Spring Template Engine 을 생성
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        // 생성한 템플릿 리졸버를 설정
        // 설정된 템플릿 리졸버는 템플릿 파일의 위치, 확장자 등을 결정하는 데 사용
        templateEngine.setTemplateResolver(templateResolver());
        // templateEngine 에 앞서 정의한 layoutDialect() 메서드에서 생성한 Thymeleaf Layout Dialect 를 추가
        // Thymeleaf Layout Dialect 는 Thymeleaf 에 레이아웃 기능을 추가하여 템플릿을 레이아웃과 컨텐츠 페이지로 나눌 수 있다
        templateEngine.addDialect(layoutDialect());
        // 생성된 Template Engine 은 Thymeleaf 템플릿을 처리하는 데 사용
        return templateEngine;
    }
}
