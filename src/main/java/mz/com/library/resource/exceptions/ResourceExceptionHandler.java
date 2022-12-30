package mz.com.library.resource.exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.ServletRequest;
import mz.com.library.service.exceptions.ObjectNotFoundException;
import mz.com.library.service.exceptions.DataIntegrityViolationException;

@ControllerAdvice
public class ResourceExceptionHandler {

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss");
	ZonedDateTime now = ZonedDateTime.now();
	ZonedDateTime zone = now.withZoneSameInstant(ZoneId.of("Africa/Cairo"));
	String time = "Africa/Cairo " + dtf.format(zone);

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, ServletRequest request) {
		StandardError error = new StandardError(time, HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> DataIntegrityViolationException(DataIntegrityViolationException e,
			ServletRequest request) {
		StandardError error = new StandardError(dtf.format(zone), HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validationError(MethodArgumentNotValidException e, ServletRequest request) {
		ValidationError error = new ValidationError(dtf.format(zone), HttpStatus.BAD_REQUEST.value(),
				" Erro na validação dos campos");

		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			error.addErrors(x.getField(), x.getDefaultMessage());

		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
