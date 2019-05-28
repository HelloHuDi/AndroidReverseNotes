package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;

@KeepForSdkWithMembers
public abstract class ActivityLifecycleObserver {
    public static final ActivityLifecycleObserver of(Activity activity) {
        return new zza(activity);
    }

    public abstract ActivityLifecycleObserver onStopCallOnce(Runnable runnable);
}
