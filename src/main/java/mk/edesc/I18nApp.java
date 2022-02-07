package mk.edesc;

import java.util.Locale;
import mk.edesc.core.exception.MessageResolver;
import mk.edesc.module.exception.ModuleNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class I18nApp {

  private static final Logger log = LoggerFactory.getLogger(I18nApp.class);

  public static void main(String[] args) {
    var messageResolver = new MessageResolver();
    var exception = new ModuleNotFoundException("some dev message");

    // default locale
    log.error("ModuleNotFoundException: '{}', '{}'",
        exception.getMessage(),
        messageResolver.resolve(exception),
        exception);

    // de
    log.error("ModuleNotFoundException: '{}', '{}'",
        exception.getMessage(),
        messageResolver.resolve(exception, Locale.GERMANY),
        exception);
  }

}
