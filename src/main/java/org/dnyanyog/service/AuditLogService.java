package org.dnyanyog.service;

import java.util.List;
import org.dnyanyog.dto.AuditLog;
import org.dnyanyog.dto.AuditLogResponse;
import org.dnyanyog.entity.AuditLogEntity;
import org.dnyanyog.repo.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AuditLogService {

  @Autowired private AuditLogRepository auditLogRepository;

  public AuditLogResponse saveAuditLog(AuditLog auditLogRequest) {
    try {

      AuditLogEntity savedAuditLog =
          AuditLogEntity.getInstance()
              .setClientIp(auditLogRequest.getClientIp())
              .setEndpoint(auditLogRequest.getEndpoint())
              .setErrorMessage(auditLogRequest.getErrorMessage())
              .setHttpMethod(auditLogRequest.getHttpMethod())
              .setId(auditLogRequest.getId())
              .setMicroservice(auditLogRequest.getMicroservice())
              .setRequestBody(auditLogRequest.getRequestBody())
              .setRequestHeaders(auditLogRequest.getRequestHeaders())
              .setRequestId(auditLogRequest.getRequestId())
              .setStackTrace(auditLogRequest.getStackTrace())
              .setStatusCode(auditLogRequest.getStatusCode())
              .setTimestamp(auditLogRequest.getTimestamp())
              .setUserAgent(auditLogRequest.getUserAgent());

      savedAuditLog = auditLogRepository.save(savedAuditLog);

      AuditLogResponse auditLogResponse =
          AuditLogResponse.getInstance()
              .setStatus("Success")
              .setMessage("Audit log saved successfully");

      return auditLogResponse;
    } catch (Exception e) {

      AuditLogResponse auditLogResponse =
          AuditLogResponse.getInstance().setStatus("Error").setMessage("Failed to save audit log");
      return auditLogResponse;
    }
  }

  public ResponseEntity<List<AuditLog>> getAllAuditLogs() {
    try {
      List<AuditLogEntity> auditLogs = auditLogRepository.findAll();
      return new ResponseEntity<>(AuditLog.fromEntityList(auditLogs), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  public ResponseEntity<List<AuditLog>> findByRequestId(String requestId) {
    try {

      return new ResponseEntity<>(
          AuditLog.fromEntityList(auditLogRepository.findByRequestId(requestId)), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
