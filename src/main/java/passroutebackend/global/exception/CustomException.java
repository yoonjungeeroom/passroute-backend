package passroutebackend.global.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

  private final ErrorCode errorCode;

  private CustomException(ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }

  private CustomException(ErrorCode errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }

  private CustomException(ErrorCode errorCode, Throwable cause) {
    super(errorCode.getMessage(), cause);
    this.errorCode = errorCode;
  }

  private CustomException(ErrorCode errorCode, String message, Throwable cause) {
    super(message, cause);
    this.errorCode = errorCode;
  }

  public static CustomException of(ErrorCode errorCode) {
    return new CustomException(errorCode);
  }

  public static CustomException of(ErrorCode errorCode, String message) {
    return new CustomException(errorCode, message);
  }

  public static CustomException of(ErrorCode errorCode, Throwable cause) {
    return new CustomException(errorCode, cause);
  }

  public static CustomException of(ErrorCode errorCode, String message, Throwable cause) {
    return new CustomException(errorCode, message, cause);
  }
}