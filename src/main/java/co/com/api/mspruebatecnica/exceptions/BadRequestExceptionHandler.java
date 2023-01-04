package co.com.api.mspruebatecnica.exceptions;

import co.com.api.mspruebatecnica.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class BadRequestExceptionHandler {


	@ExceptionHandler
	public ResponseEntity<ResponseDto> exceptionHandler(co.com.api.mspruebatecnica.exceptions.BadRequestException ex) {
		var error = new ResponseDto();
		error.setResponseCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}
