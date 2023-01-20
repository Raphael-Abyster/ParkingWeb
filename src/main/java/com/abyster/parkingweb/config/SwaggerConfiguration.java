package com.abyster.parkingweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.abyster.parkingweb.utils.Contants.APP_ROOT;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .description("Gestion de Ticket et de parking")
                                .title("Gestion de Parking")
                                .build()
                )
                .groupName("Parking web")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.abyster.parkingweb"))
                .paths(PathSelectors.any())
                .build();
    }
}


