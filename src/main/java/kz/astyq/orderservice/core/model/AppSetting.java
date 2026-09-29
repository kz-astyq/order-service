package kz.astyq.orderservice.core.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.List;

@Getter
@Setter
@ConfigurationProperties(prefix = "application")
public class AppSetting {

    private String defaultLocale;
    private static final List<String> locales = List.of("en", "ru", "kk");

    public String getDefaultLocale() {
        String locale = LocaleContextHolder.getLocale().getLanguage();
        if (locales.contains(locale)) {
            return locale;
        }
        return defaultLocale;
    }
}
