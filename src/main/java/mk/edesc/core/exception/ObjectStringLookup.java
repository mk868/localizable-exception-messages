package mk.edesc.core.exception;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.text.lookup.StringLookup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * String Lookup for object fields
 */
public class ObjectStringLookup implements StringLookup {

  private static final Logger log = LoggerFactory.getLogger(ObjectStringLookup.class);
  private final Object object;

  public ObjectStringLookup(Object object) {
    this.object = object;
  }

  @Override
  public String lookup(String key) {
    try {
      return String.valueOf(FieldUtils.readField(object, key, true));
    } catch (IllegalAccessException e) {
      log.error("Cannot read field value", e);
      return null;
    }
  }
}
