package mk.edesc;

import mk.edesc.core.exception.AppException;
import mk.edesc.serial.exception.SyncException;
import mk.edesc.module.exception.ModuleUnsupportedCode;
import mk.edesc.module.exception.ModuleUnsupportedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

  private static final Logger log = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) {
    try {
      makeAppException();
    } catch (Exception e) {
      log.error("AppException: {}", e.getLocalizedMessage(), e);
    }
    try {
      makeSyncException();
    } catch (Exception e) {
      log.error("SyncException: {}", e.getLocalizedMessage(), e);
    }
    try {
      makeUnsupportedException();
    } catch (Exception e) {
      log.error("UnsupportedException: {}", e.getLocalizedMessage(), e);
    }
  }

  public static void makeAppException() throws AppException {
    throw new AppException();
  }

  public static void makeSyncException() throws AppException {
    throw new SyncException(4000, 10);
  }

  public static void makeUnsupportedException() throws AppException {
    throw new ModuleUnsupportedException("module1", ModuleUnsupportedCode.POWER_CONTROL);
  }
}
