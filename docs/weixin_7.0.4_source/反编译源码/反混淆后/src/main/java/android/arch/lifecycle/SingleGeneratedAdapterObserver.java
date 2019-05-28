package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle.Event;

public class SingleGeneratedAdapterObserver implements GenericLifecycleObserver {
    /* renamed from: cP */
    private final GeneratedAdapter f2023cP;

    SingleGeneratedAdapterObserver(GeneratedAdapter generatedAdapter) {
        this.f2023cP = generatedAdapter;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Event event) {
        this.f2023cP.callMethods(lifecycleOwner, event, false, null);
        this.f2023cP.callMethods(lifecycleOwner, event, true, null);
    }
}
