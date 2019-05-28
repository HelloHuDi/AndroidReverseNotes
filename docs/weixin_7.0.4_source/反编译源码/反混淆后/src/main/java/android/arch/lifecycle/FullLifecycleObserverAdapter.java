package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle.Event;

class FullLifecycleObserverAdapter implements GenericLifecycleObserver {
    /* renamed from: ck */
    private final FullLifecycleObserver f2020ck;

    FullLifecycleObserverAdapter(FullLifecycleObserver fullLifecycleObserver) {
        this.f2020ck = fullLifecycleObserver;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Event event) {
        switch (event) {
            case ON_CREATE:
                this.f2020ck.onCreate(lifecycleOwner);
                return;
            case ON_START:
                this.f2020ck.onStart(lifecycleOwner);
                return;
            case ON_RESUME:
                this.f2020ck.onResume(lifecycleOwner);
                return;
            case ON_PAUSE:
                this.f2020ck.onPause(lifecycleOwner);
                return;
            case ON_STOP:
                this.f2020ck.onStop(lifecycleOwner);
                return;
            case ON_DESTROY:
                this.f2020ck.onDestroy(lifecycleOwner);
                return;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
