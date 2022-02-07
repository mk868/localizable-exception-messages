package mk.edesc.module.exception;

import mk.edesc.core.exception.AppException;

public class ModuleNotFoundException extends AppException {

  public ModuleNotFoundException() {
  }

  public ModuleNotFoundException(String message) {
    super(message);
  }
}
