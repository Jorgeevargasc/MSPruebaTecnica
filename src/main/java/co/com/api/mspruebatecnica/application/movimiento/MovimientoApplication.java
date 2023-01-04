package co.com.api.mspruebatecnica.application.movimiento;

import co.com.api.mspruebatecnica.entity.Movimiento;
import co.com.api.mspruebatecnica.dto.ResponseDto;
import co.com.api.mspruebatecnica.service.movimiento.IMovimientoService;
import co.com.api.mspruebatecnica.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class MovimientoApplication implements IMovimientoApplication{

    @Autowired
    IMovimientoService movimientoService;

    @Autowired
    private ResponseUtil responseUtil;

    ResponseDto responseDto;

    @Override
    public ResponseDto consultarMovimientos() {
        responseDto = new ResponseDto();
        var movimientos = movimientoService.consultarMovimientos();
        if(movimientos.isEmpty()) {
            responseDto.setMessage("No existen movimientos");
            responseDto.setResponseCode(HttpStatus.NOT_FOUND.value());
            responseDto.setData(null);
            return responseDto;
        }
        responseDto = responseUtil.createResponseDto(movimientos);
        return responseDto;
    }

    @Override
    public ResponseDto consultarMovimiento(int id) {
        responseDto = new ResponseDto();
        var movimiento = movimientoService.consultarMovimiento(id);
        if(movimiento == null ) {
            responseDto.setMessage("movimiento no existe");
            responseDto.setResponseCode(HttpStatus.NOT_FOUND.value());
            responseDto.setData(null);
            return responseDto;
        }
        responseDto = responseUtil.createResponseDto(movimiento);
        return responseDto;
    }

    @Override
    public ResponseDto crearMovimientos(Movimiento movimiento) {
        responseDto = new ResponseDto();
        var movimientoLegacy = movimientoService.crearMovimiento(movimiento);
        responseDto = responseUtil.createResponseDto(movimientoLegacy);
        return responseDto;
    }

    @Override
    public ResponseDto actualizarMovimiento(Movimiento movimiento) {
        responseDto = new ResponseDto();
        var movimientoLegacy = movimientoService.actualizarMovimiento(movimiento);
        responseDto = responseUtil.createResponseDto(movimientoLegacy);
        return responseDto;
    }

    @Override
    public ResponseDto eliminarMovimiento(int id) {
        responseDto = new ResponseDto();
        var movimientoLegacy = movimientoService.eliminarMovimiento(id);
        responseDto = responseUtil.createResponseDto(movimientoLegacy);
        return responseDto;
    }
}
