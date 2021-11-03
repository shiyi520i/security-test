package com.example.testdemo.config;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;

/**
 * swaggerui配置类
 *
 * @author ：ShiYI
 * @date ：Created in 2021/9/23
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                //分组名称，可以通过配置多个bean来达到分组效果
                .groupName("")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.testdemo.controller"))
                //.paths(PathSelectors.ant("/*")) 过滤mapping为"/"的所有路径
                .build()
                .securityContexts(Arrays.asList(securityContext()))
                // ApiKey的name需与SecurityReference的reference保持一致
                .securitySchemes(Arrays.asList(new ApiKey("token", "token", SecurityScheme.In.HEADER.name())));
    }
    /**
     *  信息类
     * @author ShiYi
     * @return springfox.documentation.service.ApiInfo
     * @date 2021/9/23 14:38
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Api V1")
                .contact(new Contact("", "", ""))
                .version("1")
                .build();
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                //.forPaths(PathSelectors.regex("/*.*"))
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return singletonList(
                new SecurityReference("token", authorizationScopes));
    }

}

