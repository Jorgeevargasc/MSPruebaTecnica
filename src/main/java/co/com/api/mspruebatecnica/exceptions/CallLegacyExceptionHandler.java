package co.com.api.mspruebatecnica.exceptions;

import co.com.api.mspruebatecnica.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Manejo de la excepcion CallLegacy
 */
@ControllerAdvice
public class CallLegacyExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ResponseDto> handlerException(co.com.api.mspruebatecnica.exceptions.CallLegacyException ex) {
        var responseDto = new ResponseDto();
        responseDto.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseDto.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto);
    }

}
