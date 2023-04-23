package by.vsu.bank.api;

import by.vsu.bank.exception.ResourceAlreadyExistsException;
import by.vsu.bank.exception.ResourceNotFoundException;
import by.vsu.bank.model.dto.ErrorModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ResourceNotFoundException.class, ResourceAlreadyExistsException.class})
    public ResponseEntity<ErrorModel> handleResourceNotFoundException(ResourceNotFoundException e) {
        ErrorModel error = new ErrorModel(e.getClass().getSimpleName(), e.getMessage());
        return new ResponseEntity<>(error, e.getClass().getAnnotation(ResponseStatus.class).value());
    }

}
