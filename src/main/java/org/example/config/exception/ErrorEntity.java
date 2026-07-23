package org.example.config.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter @Setter
public class ErrorEntity {

    private HttpStatusCode statusCode;

    private LocalDateTime timestamp;

    private String message;
}
