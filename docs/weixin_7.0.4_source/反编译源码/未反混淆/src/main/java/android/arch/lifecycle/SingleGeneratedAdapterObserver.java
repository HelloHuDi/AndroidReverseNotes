package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle.Event;

public class SingleGeneratedAdapterObserver implements GenericLifecycleObserver {
    private final GeneratedAdapter cP;

    SingleGeneratedAdapterObserver(GeneratedAdapter generatedAdapter) {
        this.cP = generatedAdapter;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Event event) {
        this.cP.callMethods(lifecycleOwner, event, false, null);
        this.cP.callMethods(lifecycleOwner, event, true, null);
    }
}
