package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle.Event;
import java.util.List;

class ReflectiveGenericLifecycleObserver implements GenericLifecycleObserver {
    /* renamed from: cM */
    private final Object f2021cM;
    /* renamed from: cN */
    private final CallbackInfo f2022cN = ClassesInfoCache.f4cd.mo285f(this.f2021cM.getClass());

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f2021cM = obj;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Event event) {
        CallbackInfo callbackInfo = this.f2022cN;
        Object obj = this.f2021cM;
        CallbackInfo.m311a((List) callbackInfo.f1cg.get(event), lifecycleOwner, event, obj);
        CallbackInfo.m311a((List) callbackInfo.f1cg.get(Event.ON_ANY), lifecycleOwner, event, obj);
    }
}
