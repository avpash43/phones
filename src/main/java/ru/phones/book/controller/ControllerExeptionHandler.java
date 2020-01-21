package ru.phones.book.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.phones.book.exeptions.SomeBadExampleExeption;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class ControllerExeptionHandler {
    @ExceptionHandler(SomeBadExampleExeption.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response handleManualTestException(HttpServletRequest request, SomeBadExampleExeption e) {
        log.error(e.getLocalizedMessage());
        return Response.builder()
                .httpStatusCode(HttpStatus.BAD_REQUEST.value())
                .errorMessage(e.getMessage() != null
                        ? e.getMessage()
                        : "SomeBad: ")
                .build();
    }
}
