package Socials.SpringBootReddit.Configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI RedditApiConfiguration(){
        return new OpenAPI().info(apInfo());
    }

    private Info apInfo() {
        Info info = new Info();
        info
                .title("Reddit Code API")
                .description("Reddit with springboot and angular");
        return info;
    }

}
