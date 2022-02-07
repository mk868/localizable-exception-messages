package mk.edesc.core.exception;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import org.apache.commons.text.StringSubstitutor;

public class MessageResolver {

  private static final String BUNDLE_NAME = "message";
  private final Map<Locale, ResourceBundle> bundles = new HashMap<>();

  protected ResourceBundle getResourceBundle(Locale locale) {
    return bundles.computeIfAbsent(locale, locale1 ->
        ResourceBundle.getBundle(BUNDLE_NAME, locale)
    );
  }

  /**
   * Get localization key used to get message translation
   *
   * @return exception key
   */
  protected String getLocalizationKey(Exception exception) {
    var key = exception.getClass().getSimpleName();
    if (exception instanceof ExceptionCode<?> exceptionCode) {
      key += "." + exceptionCode.getCode().name();
    }
    return key;
  }

  /**
   * Generate localized message
   *
   * @return localized message
   */
  protected String tryResolveMessage(Exception exception, Locale locale) {
    var bundle = getResourceBundle(locale);
    var template = bundle.getString(getLocalizationKey(exception));
    var sub = new StringSubstitutor(new ObjectStringLookup(exception));
    return sub.replace(template);
  }

  /**
   * Get localized message for given exception and locale
   *
   * @param exception exception object
   * @param locale    end-user locale (can be read from session/http header/settings)
   * @return the message understandable for the user
   */
  public String resolve(Exception exception, Locale locale) {
    try {
      return tryResolveMessage(exception, locale);
    } catch (Exception ex) {
      return exception.getMessage();
    }
  }

  /**
   * Get localized message given exception and default locale
   *
   * @param exception exception object
   * @return the message understandable for the user
   */
  public String resolve(Exception exception) {
    return resolve(exception, Locale.getDefault());
  }
}
