package android.arch.lifecycle;

public interface Observer<T> {
    void onChanged(T t);
}
