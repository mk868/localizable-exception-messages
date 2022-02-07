package mk.edesc.module.exception;

import mk.edesc.core.exception.AppException;
import mk.edesc.core.exception.ExceptionCode;

public class ModuleUnsupportedException extends AppException implements ExceptionCode<ModuleUnsupportedCode> {

  private final String moduleId;
  private final ModuleUnsupportedCode code;

  public ModuleUnsupportedException(String moduleId, ModuleUnsupportedCode code) {
    this.moduleId = moduleId;
    this.code = code;
  }

  @Override
  public ModuleUnsupportedCode getCode() {
    return code;
  }
}
