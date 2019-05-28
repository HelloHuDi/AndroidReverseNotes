package android.arch.lifecycle;

public class MutableLiveData<T> extends LiveData<T> {
    public void postValue(T t) {
        super.postValue(t);
    }

    public void setValue(T t) {
        super.setValue(t);
    }
}
