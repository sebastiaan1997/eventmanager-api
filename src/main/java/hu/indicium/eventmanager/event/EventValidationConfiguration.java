package hu.indicium.eventmanager.event;

import hu.indicium.eventmanager.event.validation.DateValidator;
import hu.indicium.eventmanager.util.Validator;
import hu.indicium.eventmanager.util.ValidatorGroup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class EventValidationConfiguration {
    @Bean
    public Validator<Event> eventValidator() {
        return new ValidatorGroup<>(Arrays.asList(new DateValidator()));
    }
}
