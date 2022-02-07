package mk.edesc.serial.exception;

import mk.edesc.core.exception.AppException;

/**
 * Problem with syncing with resource
 */
public class SyncException extends AppException {

  private final int timeout;
  private final int timing;

  public SyncException(int timeout, int timing) {
    this.timeout = timeout;
    this.timing = timing;
  }

  public SyncException(String message, int timeout, int timing) {
    super(message);
    this.timeout = timeout;
    this.timing = timing;
  }
}
