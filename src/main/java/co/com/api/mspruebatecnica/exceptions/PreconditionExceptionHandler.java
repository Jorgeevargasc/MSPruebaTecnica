package co.com.api.mspruebatecnica.exceptions;

import co.com.api.mspruebatecnica.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class PreconditionExceptionHandler {


	@ExceptionHandler
	public ResponseEntity<ResponseDto> exceptionHandler(PreconditionException ex) {
		var error = new ResponseDto();
		error.setResponseCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessage(ex.getMessage());
		return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(error);
	}

}
