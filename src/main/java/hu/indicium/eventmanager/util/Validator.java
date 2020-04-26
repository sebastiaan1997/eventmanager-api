package hu.indicium.eventmanager.util;

public interface Validator<T> {
    void validate(T entity);
}
