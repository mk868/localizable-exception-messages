package mk.edesc.core.exception;

/**
 * Base class for all custom exceptions in application
 */
public class AppException extends Exception {

  public AppException() {
  }

  public AppException(String message) {
    super(message);
  }

  public AppException(String message, Throwable cause) {
    super(message, cause);
  }

  public AppException(Throwable cause) {
    super(cause);
  }
}
