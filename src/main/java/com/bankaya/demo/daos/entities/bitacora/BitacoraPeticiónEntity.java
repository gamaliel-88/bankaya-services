package com.bankaya.demo.daos.entities.bitacora;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="bitacora_servicios")
public class BitacoraPeticiónEntity implements Serializable{

	private static final long serialVersionUID = -1689864003626904313L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@NotNull
	private Long id;
	
	@NotNull
	private String ip_origen;
	
	@NotNull
	private String endpoint;

	@NotNull
	private Date fecha_request;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIp_origen() {
		return ip_origen;
	}

	public void setIp_origen(String ip_origen) {
		this.ip_origen = ip_origen;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public Date getFecha_request() {
		return fecha_request;
	}

	public void setFecha_request(Date fecha_request) {
		this.fecha_request = fecha_request;
	}
}
