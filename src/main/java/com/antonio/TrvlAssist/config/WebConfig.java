package  com.antonio.TrvlAssist.config;

import  com.antonio.TrvlAssist.converter.StringToGenderConverter;
import  com.antonio.TrvlAssist.converter.StringToRoleConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {

        registry.addConverter(new StringToGenderConverter());
        registry.addConverter(new StringToRoleConverter());

    }
}
