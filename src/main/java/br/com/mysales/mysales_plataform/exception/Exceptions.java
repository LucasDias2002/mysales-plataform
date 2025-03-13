package br.com.mysales.mysales_plataform.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Exceptions {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400(MethodArgumentNotValidException err){
        var error = err.getFieldErrors();
        return ResponseEntity.badRequest().body(error.stream().map(errorMethodArgumentNotValidException::new).toList());
    }

    private record errorMethodArgumentNotValidException(String data, String message){
        public errorMethodArgumentNotValidException(FieldError err){
            this(err.getField(), err.getDefaultMessage());
        }
    }
}
