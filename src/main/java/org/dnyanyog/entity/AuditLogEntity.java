package org.dnyanyog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Map;
import org.dnyanyog.converter.MapToJsonConverter;

@Entity
@Table(name = "audit_log")
public class AuditLogEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long auditCode;

  @Column(name = "id")
  private String id;

  @Column(name = "timestamp")
  private LocalDateTime timestamp;

  @Column(name = "request_id")
  private String requestId; // ClientId

  @Column(name = "client_ip")
  private String clientIp;

  @Column(name = "user_agent")
  private String userAgent;

  @Column(name = "http_method")
  private String httpMethod;

  @Column(name = "request_url")
  private String requestUrl;

  @Convert(converter = MapToJsonConverter.class)
  @Column(name = "request_headers", columnDefinition = "TEXT")
  private Map<String, String> requestHeaders;

  @Column(name = "request_body", columnDefinition = "TEXT")
  private String requestBody;

  @Column(name = "status_code")
  private int statusCode;

  @Convert(converter = MapToJsonConverter.class)
  @Column(name = "response_headers", columnDefinition = "TEXT")
  private Map<String, String> responseHeaders;

  @Column(name = "response_body", columnDefinition = "TEXT")
  private String responseBody;

  @Column(name = "microservice")
  private String microservice;

  @Column(name = "endpoint")
  private String endpoint;

  @Column(name = "error_message", columnDefinition = "TEXT")
  private String errorMessage;

  @Column(name = "stack_trace", columnDefinition = "TEXT")
  private String stackTrace;

  public static AuditLogEntity getInstance() {
    return new AuditLogEntity();
  }

  // Getters and setters
  public Long getAuditCode() {
    return auditCode;
  }

  public AuditLogEntity setAuditCode(Long auditCode) {
    this.auditCode = auditCode;
    return this;
  }

  public String getId() {
    return id;
  }

  public AuditLogEntity setId(String id) {
    this.id = id;
    return this;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public AuditLogEntity setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  public String getRequestId() {
    return requestId;
  }

  public AuditLogEntity setRequestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

  public String getClientIp() {
    return clientIp;
  }

  public AuditLogEntity setClientIp(String clientIp) {
    this.clientIp = clientIp;
    return this;
  }

  public String getUserAgent() {
    return userAgent;
  }

  public AuditLogEntity setUserAgent(String userAgent) {
    this.userAgent = userAgent;
    return this;
  }

  public String getHttpMethod() {
    return httpMethod;
  }

  public AuditLogEntity setHttpMethod(String httpMethod) {
    this.httpMethod = httpMethod;
    return this;
  }

  public String getRequestUrl() {
    return requestUrl;
  }

  public AuditLogEntity setRequestUrl(String requestUrl) {
    this.requestUrl = requestUrl;
    return this;
  }

  public Map<String, String> getRequestHeaders() {
    return requestHeaders;
  }

  public AuditLogEntity setRequestHeaders(Map<String, String> requestHeaders) {
    this.requestHeaders = requestHeaders;
    return this;
  }

  public String getRequestBody() {
    return requestBody;
  }

  public AuditLogEntity setRequestBody(String requestBody) {
    this.requestBody = requestBody;
    return this;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public AuditLogEntity setStatusCode(int statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  public Map<String, String> getResponseHeaders() {
    return responseHeaders;
  }

  public AuditLogEntity setResponseHeaders(Map<String, String> responseHeaders) {
    this.responseHeaders = responseHeaders;
    return this;
  }

  public String getResponseBody() {
    return responseBody;
  }

  public AuditLogEntity setResponseBody(String responseBody) {
    this.responseBody = responseBody;
    return this;
  }

  public String getMicroservice() {
    return microservice;
  }

  public AuditLogEntity setMicroservice(String microservice) {
    this.microservice = microservice;
    return this;
  }

  public String getEndpoint() {
    return endpoint;
  }

  public AuditLogEntity setEndpoint(String endpoint) {
    this.endpoint = endpoint;
    return this;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public AuditLogEntity setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

  public String getStackTrace() {
    return stackTrace;
  }

  public AuditLogEntity setStackTrace(String stackTrace) {
    this.stackTrace = stackTrace;
    return this;
  }
}
