package com.bankaya.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankaya.demo.daos.api.BitacoraPeticionesDao;
import com.bankaya.demo.daos.entities.bitacora.BitacoraPeticiónEntity;
import com.bankaya.demo.dto.bitacora.BitacoraPeticionDto;
import com.bankaya.demo.services.api.BitacoraServices;

@Service
public class BitacoraServicesImpl implements BitacoraServices {

	@Autowired
	private BitacoraPeticionesDao bitacoraPeticionesDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void createRegister(BitacoraPeticionDto bitacoraPeticionDto) {

		BitacoraPeticiónEntity bitacoraPeticiónEntity = modelMapper.map(bitacoraPeticionDto,
				BitacoraPeticiónEntity.class);

		bitacoraPeticionesDao.save(bitacoraPeticiónEntity);

	}

}
