package mk.edesc;

import mk.edesc.core.exception.MessageResolver;
import mk.edesc.module.exception.ModuleUnsupportedCode;
import mk.edesc.module.exception.ModuleUnsupportedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorCodeApp {

  private static final Logger log = LoggerFactory.getLogger(ErrorCodeApp.class);

  public static void main(String[] args) {
    var messageResolver = new MessageResolver();
    var exception = new ModuleUnsupportedException("generator1",
        ModuleUnsupportedCode.POWER_CONTROL);

    // default locale
    log.error("ModuleUnsupportedException: '{}', '{}'",
        exception.getMessage(),
        messageResolver.resolve(exception),
        exception);
  }

}
