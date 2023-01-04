package co.com.api.mspruebatecnica.application.cuenta;

import co.com.api.mspruebatecnica.dto.ResponseDto;
import co.com.api.mspruebatecnica.entity.Cuenta;
import co.com.api.mspruebatecnica.service.cuenta.ICuentaService;
import co.com.api.mspruebatecnica.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CuentaApplication implements ICuentaApplication{

    @Autowired
    ICuentaService cuentaService;

    @Autowired
    private ResponseUtil responseUtil;

    ResponseDto responseDto;

    @Override
    public ResponseDto consultarCuentas() {
        responseDto = new ResponseDto();
        var cuentas = cuentaService.consultarCuentas();
        if(cuentas.isEmpty()) {
            responseDto.setMessage("No existen cuentas");
            responseDto.setResponseCode(HttpStatus.NOT_FOUND.value());
            responseDto.setData(null);
            return responseDto;
        }
        responseDto = responseUtil.createResponseDto(cuentas);
        return responseDto;
    }

    @Override
    public ResponseDto consultarCuenta(int id) {
        responseDto = new ResponseDto();
        var cuenta = cuentaService.consultarCuenta(id);
        if(cuenta == null ) {
            responseDto.setMessage("Cuenta no existe");
            responseDto.setResponseCode(HttpStatus.NOT_FOUND.value());
            responseDto.setData(null);
            return responseDto;
        }
        responseDto = responseUtil.createResponseDto(cuenta);
        return responseDto;
    }

    @Override
    public ResponseDto crearCuentas(Cuenta cuenta) {
        responseDto = new ResponseDto();
        var cuentaLegacy = cuentaService.crearCuenta(cuenta);
        responseDto = responseUtil.createResponseDto(cuentaLegacy);
        return responseDto;
    }

    @Override
    public ResponseDto actualizarCuenta(Cuenta cuenta) {
        responseDto = new ResponseDto();
        var cuentaLegacy = cuentaService.actualizarCuenta(cuenta);
        responseDto = responseUtil.createResponseDto(cuentaLegacy);
        return responseDto;
    }

    @Override
    public ResponseDto eliminarCuenta(int id) {
        responseDto = new ResponseDto();
        var cuentaLegacy = cuentaService.eliminarCuenta(id);
        responseDto = responseUtil.createResponseDto(cuentaLegacy);
        return responseDto;
    }
}
