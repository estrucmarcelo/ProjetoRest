package br.com.senac.exceptions;

import lombok.Data;

@Data
public class StandardError {

	private Long timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
	public StandardError() {
		super();
	}
	
	public StandardError(Long timestamp,Integer status,String error,String message,String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
	
	
	
}
