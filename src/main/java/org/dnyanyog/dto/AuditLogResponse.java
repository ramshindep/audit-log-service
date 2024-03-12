package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class AuditLogResponse {
	
	private String status;

	private String message;
	
	private AuditLog data;

	public static AuditLogResponse getInstance() {
		return new AuditLogResponse();
	}

	public String getStatus() {
		return status;
	}

	public AuditLogResponse setStatus(String status) {
		this.status = status;
		return this;
		
	}

	public String getMessage() {
		return message;
	}

	public AuditLogResponse setMessage(String message) {
		this.message = message;
		return this;
	}

	public AuditLog getData() {
		return data;
	}

	public AuditLogResponse setData(AuditLog data) {
		this.data = data;
		return this;
	}
	

}
