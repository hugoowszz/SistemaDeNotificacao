package org.example.config.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ReciboNaoEncontradoException.class)
    public ResponseEntity<ErrorEntity> reciboNaoEncontradoHandler(ReciboNaoEncontradoException exception) {
        ErrorEntity body = new ErrorEntity(HttpStatus.NOT_FOUND, LocalDateTime.now(), "Recibo não encontrado!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorEntity> methodArgumentNotValidHandler(MethodArgumentNotValidException exception) {
        ErrorEntity body = new ErrorEntity(HttpStatus.BAD_REQUEST, LocalDateTime.now(), "Argumentos inválidos!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorEntity> HttpMessageNotReadbleHandler(HttpMessageNotReadableException exception) {
        ErrorEntity body = new ErrorEntity(HttpStatus.BAD_REQUEST, LocalDateTime.now(), "Argumentos inválidos!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
