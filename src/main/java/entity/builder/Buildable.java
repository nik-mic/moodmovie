package entity.builder;

@FunctionalInterface
public interface Buildable<T> {
    T generate();
}
