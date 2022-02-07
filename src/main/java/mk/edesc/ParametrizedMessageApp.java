package mk.edesc;

import mk.edesc.core.exception.MessageResolver;
import mk.edesc.serial.exception.SyncException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParametrizedMessageApp {

  private static final Logger log = LoggerFactory.getLogger(ParametrizedMessageApp.class);

  public static void main(String[] args) {
    var messageResolver = new MessageResolver();
    var exception = new SyncException(4000, 10);

    // default locale
    log.error("SyncException: '{}', '{}'",
        exception.getMessage(),
        messageResolver.resolve(exception),
        exception);
  }

}
