package ru.makarovie.jarSoftDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoContentException extends Throwable{

    public NoContentException(String message) {
        super(message);
    }

    public NoContentException() {

    }
}
