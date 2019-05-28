package com.google.android.gms.common.api;

import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

public abstract class zzc {
    private static final Object sLock = new Object();
    @GuardedBy("sLock")
    private static final Map<Object, zzc> zzdo = new WeakHashMap();

    public abstract void remove(int i);
}
