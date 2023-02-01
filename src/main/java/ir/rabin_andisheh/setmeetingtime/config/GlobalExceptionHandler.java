package ir.rabin_andisheh.setmeetingtime.config;

import ir.rabin_andisheh.setmeetingtime.exception.DuplicateUsernameException;
import ir.rabin_andisheh.setmeetingtime.exception.QueuingNotFoundException;
import ir.rabin_andisheh.setmeetingtime.exception.VisitorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = DuplicateUsernameException.class)
    public ResponseEntity<Object> duplicateUsernameExceptionHandler(Exception ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(value = QueuingNotFoundException.class)
    public ResponseEntity<Object> queuingNotFoundExceptionHandler(Exception ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(value = VisitorNotFoundException.class)
    public ResponseEntity<Object> visitorNotFoundExceptionHandler(Exception ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ResponseEntity<Object> usernameNotFoundExceptionHandler(Exception ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
