package ru.phones.book.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Collections;

@Data
@AllArgsConstructor
@Builder
class Response {

    @SuppressWarnings("UnusedAssignment")
    @Builder.Default
    private int status = HttpStatus.OK.value();

    @SuppressWarnings("UnusedAssignment")
    @Builder.Default
    private Object data = Collections.EMPTY_LIST;

    @SuppressWarnings("UnusedAssignment")
    @Builder.Default
    private Object error = "";

    private String message;

    private LocalDateTime timestamp;

}
