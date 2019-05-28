package com.google.android.gms.dynamic;

public interface OnDelegateCreatedListener<T extends LifecycleDelegate> {
    void onDelegateCreated(T t);
}
