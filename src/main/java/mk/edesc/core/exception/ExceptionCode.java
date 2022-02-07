package mk.edesc.core.exception;

public interface ExceptionCode<T extends Enum<T>> {

  T getCode();
}
