package co.com.api.mspruebatecnica.util;

import co.com.api.mspruebatecnica.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtil {

    public ResponseDto createResponseDto(Object data){
        var responseDto = new ResponseDto();
        responseDto.setMessage("OK");
        responseDto.setResponseCode(HttpStatus.OK.value());
        responseDto.setData(data);
        return responseDto;
    }
}
