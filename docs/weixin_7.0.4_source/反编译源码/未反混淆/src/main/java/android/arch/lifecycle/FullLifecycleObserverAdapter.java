package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle.Event;

class FullLifecycleObserverAdapter implements GenericLifecycleObserver {
    private final FullLifecycleObserver ck;

    FullLifecycleObserverAdapter(FullLifecycleObserver fullLifecycleObserver) {
        this.ck = fullLifecycleObserver;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Event event) {
        switch (event) {
            case ON_CREATE:
                this.ck.onCreate(lifecycleOwner);
                return;
            case ON_START:
                this.ck.onStart(lifecycleOwner);
                return;
            case ON_RESUME:
                this.ck.onResume(lifecycleOwner);
                return;
            case ON_PAUSE:
                this.ck.onPause(lifecycleOwner);
                return;
            case ON_STOP:
                this.ck.onStop(lifecycleOwner);
                return;
            case ON_DESTROY:
                this.ck.onDestroy(lifecycleOwner);
                return;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
