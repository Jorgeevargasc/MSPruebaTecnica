package co.com.api.mspruebatecnica.dto;

import lombok.Data;

@Data
public class ResponseDto {

    private int responseCode;
    private String message;
    private Object data;
}
