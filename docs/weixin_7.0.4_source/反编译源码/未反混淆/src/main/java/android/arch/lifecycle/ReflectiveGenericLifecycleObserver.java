package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle.Event;
import java.util.List;

class ReflectiveGenericLifecycleObserver implements GenericLifecycleObserver {
    private final Object cM;
    private final CallbackInfo cN = ClassesInfoCache.cd.f(this.cM.getClass());

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.cM = obj;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Event event) {
        CallbackInfo callbackInfo = this.cN;
        Object obj = this.cM;
        CallbackInfo.a((List) callbackInfo.cg.get(event), lifecycleOwner, event, obj);
        CallbackInfo.a((List) callbackInfo.cg.get(Event.ON_ANY), lifecycleOwner, event, obj);
    }
}
