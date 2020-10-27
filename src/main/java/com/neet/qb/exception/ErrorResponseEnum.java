package com.neet.qb.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Phaninder
 * @purpose Exception / Error messages repository.
 */
public enum ErrorResponseEnum {
  GENERAL_ERROR(100, "An exception has occured while processing your request.",
      HttpStatus.INTERNAL_SERVER_ERROR),
  VALIDATION_ERROR(101, "There was one or more validation error(s)", HttpStatus.BAD_REQUEST),
  INVALID_URL(102, "Invalid url, request not found", HttpStatus.NOT_FOUND),
  ENTITY_NOT_FOUND(103, "The requested entity could not be found", HttpStatus.BAD_REQUEST),
  FILE_UPLOAD_ERROR(104, "An exception has occured while uploading file.", HttpStatus.BAD_REQUEST),
  ENTITY_EXISTS(105, "An entity already exists.", HttpStatus.BAD_REQUEST),
  PAGINATION_LIMIT_ERROR(106, "Limit field is more than what is allowed.", HttpStatus.BAD_REQUEST),
  ORGANIZATION_INACTIVE_ERROR(107, "Organization is not active anymore.", HttpStatus.BAD_REQUEST),
  PROJECT_INACTIVE_ERROR(108, "Project is not active anymore.", HttpStatus.BAD_REQUEST),
  DUPLICATE_REFERENCE_NAME_ERROR(109, "Reference is already used by organization.",
      HttpStatus.BAD_REQUEST);

  private int code;
  private String errorText;
  private HttpStatus httpStatus;

  private ErrorResponseEnum(int code, String errorText, HttpStatus httpStatus) {
    this.code = code;
    this.errorText = errorText;
    this.httpStatus = httpStatus;
  }

  public int getCode() {
    return code;
  }

  public String getErrorText() {
    return errorText;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }
}
