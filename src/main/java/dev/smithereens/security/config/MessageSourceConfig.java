package dev.smithereens.security.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@Configuration
public class MessageSourceConfig {

    public static final MessageSourceConfig messages = new MessageSourceConfig();

    @Bean
    MessageSource messageSource() {
        var source = new ReloadableResourceBundleMessageSource();
        source.setBasename("classpath:messages");
        return source;
    }

    public String get(String message, String... dynamicValues) {
        return messageSource().getMessage(message, dynamicValues, Locale.getDefault());
    }
}
