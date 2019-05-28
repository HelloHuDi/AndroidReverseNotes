package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle.Event;

public class CompositeGeneratedAdaptersObserver implements GenericLifecycleObserver {
    private final GeneratedAdapter[] cj;

    CompositeGeneratedAdaptersObserver(GeneratedAdapter[] generatedAdapterArr) {
        this.cj = generatedAdapterArr;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Event event) {
        int i = 0;
        MethodCallsLogger methodCallsLogger = new MethodCallsLogger();
        for (GeneratedAdapter callMethods : this.cj) {
            callMethods.callMethods(lifecycleOwner, event, false, methodCallsLogger);
        }
        GeneratedAdapter[] generatedAdapterArr = this.cj;
        int length = generatedAdapterArr.length;
        while (i < length) {
            generatedAdapterArr[i].callMethods(lifecycleOwner, event, true, methodCallsLogger);
            i++;
        }
    }
}
