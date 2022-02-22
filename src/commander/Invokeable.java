package commander;

@FunctionalInterface
public interface Invokeable<T> {
    T execute();
}
