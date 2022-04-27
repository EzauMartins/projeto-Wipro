package com.wipro.gama.bankapp.exceptionhandler;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MessageExceptionHandler {
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date data;
	private int status;
	private String mensagem;
	
	public MessageExceptionHandler(Date data, int status, String mensagem) {
		this.data = data;
		this.status = status;
		this.mensagem = mensagem;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	

}
