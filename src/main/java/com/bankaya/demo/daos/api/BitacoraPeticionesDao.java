package com.bankaya.demo.daos.api;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankaya.demo.daos.entities.bitacora.BitacoraPeticiónEntity;

public interface BitacoraPeticionesDao extends JpaRepository<BitacoraPeticiónEntity, Long>  {

}
