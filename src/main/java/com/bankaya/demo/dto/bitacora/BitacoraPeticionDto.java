package com.bankaya.demo.dto.bitacora;

import java.io.Serializable;
import java.util.Date;

public class BitacoraPeticionDto implements Serializable{

	private static final long serialVersionUID = -6947600776332458565L;

	private String ip_origen;
	private String endpoint;
	private Date fecha_request;
	
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
