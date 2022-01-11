package com.bankaya.demo.services;

import static org.mockito.Mockito.verify;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.bankaya.demo.daos.api.BitacoraPeticionesDao;
import com.bankaya.demo.daos.entities.bitacora.BitacoraPeticiónEntity;
import com.bankaya.demo.dto.bitacora.BitacoraPeticionDto;
import com.bankaya.demo.services.api.BitacoraServices;
import com.bankaya.demo.services.impl.BitacoraServicesImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BitacoraServicesImplTest {

    @InjectMocks
    private final BitacoraServices bitacoraServices = new BitacoraServicesImpl();

    @Mock
    private BitacoraPeticionesDao bitacoraPeticionesDao;

    @Spy
    private final ModelMapper modelMapper = new ModelMapper();

    @Test
    public void abilities() {

        final Date fecha_request = new Date();

        final BitacoraPeticionDto bitacoraPeticionDto = createBitacoraPeticionDto(fecha_request);

        bitacoraServices.createRegister(bitacoraPeticionDto);

        verify(bitacoraPeticionesDao).save(org.mockito.ArgumentMatchers.any());
        verify(modelMapper).map(bitacoraPeticionDto, BitacoraPeticiónEntity.class);

    }

    private BitacoraPeticionDto createBitacoraPeticionDto(final Date fecha_request) {
        final BitacoraPeticionDto bitacoraPeticionDto = new BitacoraPeticionDto();
        bitacoraPeticionDto.setEndpoint("/abilities");
        bitacoraPeticionDto.setFecha_request(fecha_request);
        bitacoraPeticionDto.setIp_origen("127.0.0.1");
        return bitacoraPeticionDto;
    }
}
