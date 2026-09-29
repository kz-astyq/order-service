package kz.astyq.orderservice.core.i18n.impl;

import kz.astyq.orderservice.core.i18n.MessageService;
import kz.astyq.orderservice.core.model.AppSetting;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageSource messageSource;
    private final AppSetting appSetting;

    @Override
    public String getMessage(String messageCode, Object... args) {
        return messageSource.getMessage(messageCode, args, messageCode, Locale.forLanguageTag(appSetting.getDefaultLocale()));
    }

    @Override
    public String getMessage(String messageCode) {
        return this.getMessage(messageCode, (Object) null);
    }
}
