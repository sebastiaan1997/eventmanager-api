package hu.indicium.eventmanager.event.exceptions;

public class EndDateBeforeStartDateException extends RuntimeException {
    public EndDateBeforeStartDateException() {
        super("De eindddatum van het evenement ligt voor de begindatum.");
    }
}
