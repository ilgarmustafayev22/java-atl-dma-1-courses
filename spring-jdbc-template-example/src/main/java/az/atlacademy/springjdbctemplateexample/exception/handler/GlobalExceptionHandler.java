package az.atlacademy.springjdbctemplateexample.exception.handler;

import az.atlacademy.springjdbctemplateexample.exception.StudentNotFoundException;
import az.atlacademy.springjdbctemplateexample.model.dto.ErrorDto;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

//@RestControllerAdvice
public class GlobalExceptionHandler {

 // }


}
