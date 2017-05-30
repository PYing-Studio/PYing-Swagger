package yay.apidoc.swagger;

import org.springframework.context.annotation.Bean;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by yuananyun on 2015/11/24.
 */
@EnableSwagger2
public class ApplicationSwaggerConfig {

    @Bean
    public Docket addUserDocket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        ApiInfo apiInfo = new ApiInfo(
                "泡影 API",
                "",
                "V3.8.0",
                "www.baidu.com",
                "",
                "",
                "");
        docket.apiInfo(apiInfo);
        return docket;
    }
}
