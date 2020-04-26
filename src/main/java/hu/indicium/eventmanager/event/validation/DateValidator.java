package hu.indicium.eventmanager.event.validation;

import hu.indicium.eventmanager.event.Event;
import hu.indicium.eventmanager.event.exceptions.EndDateBeforeStartDateException;
import hu.indicium.eventmanager.util.Validator;

public class DateValidator implements Validator<Event> {
    @Override
    public void validate(Event event) {
        if (event.getEndDate().before(event.getStartDate())) {
            throw new EndDateBeforeStartDateException();
        }
    }
}
