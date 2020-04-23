package ru.phones.book.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.phones.book.exeptions.SomeBadExampleExeption;
import ru.phones.book.exeptions.SomeForbiddenExampleExeption;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class ControllerExeptionHandler {
    @ExceptionHandler(SomeBadExampleExeption.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response handleSomeBadExeption(HttpServletRequest request, SomeBadExampleExeption e) {
        log.error(e.getLocalizedMessage());
        return Response.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(SomeForbiddenExampleExeption.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public Response handleSomeForbiddenExeption(SomeForbiddenExampleExeption e) {
        log.error(e.getLocalizedMessage());
        return Response.builder()
                .status(HttpStatus.FORBIDDEN.value())
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Response handleException(Exception e) {
        log.error(e.getLocalizedMessage());
        return Response.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(e.getLocalizedMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
