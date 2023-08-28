package com.cbb.common.swagger;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 测试一下提交
 */

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI OpenAPI() {
        return new OpenAPI()
                .info(getInfo())
                .externalDocs(getExternalDocumentation());
    }

    private License getLicense() {
        return new License()
                .name("Apache 2.0")
                .url("http://springdoc.org");
    }

    private Info getInfo() {
        return new Info()
                .title("树洞API文档")
                .description("树洞项目API文档")
                .version("v1.0.0")
                .license(getLicense());
    }

    private ExternalDocumentation getExternalDocumentation() {
        return new ExternalDocumentation()
                .description("树洞API导出文档")
                .url("https://springdoc.org/v2");
    }


}
