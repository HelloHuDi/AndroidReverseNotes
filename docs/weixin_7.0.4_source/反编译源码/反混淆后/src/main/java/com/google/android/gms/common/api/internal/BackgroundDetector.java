package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public final class BackgroundDetector implements ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final BackgroundDetector zzem = new BackgroundDetector();
    private final AtomicBoolean zzen = new AtomicBoolean();
    private final AtomicBoolean zzeo = new AtomicBoolean();
    @GuardedBy("sInstance")
    private final ArrayList<BackgroundStateChangeListener> zzep = new ArrayList();
    @GuardedBy("sInstance")
    private boolean zzeq = false;

    @KeepForSdk
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z);
    }

    static {
        AppMethodBeat.m2504i(89469);
        AppMethodBeat.m2505o(89469);
    }

    @KeepForSdk
    private BackgroundDetector() {
        AppMethodBeat.m2504i(89460);
        AppMethodBeat.m2505o(89460);
    }

    @KeepForSdk
    public static BackgroundDetector getInstance() {
        return zzem;
    }

    @KeepForSdk
    public static void initialize(Application application) {
        AppMethodBeat.m2504i(89461);
        synchronized (zzem) {
            try {
                if (!zzem.zzeq) {
                    application.registerActivityLifecycleCallbacks(zzem);
                    application.registerComponentCallbacks(zzem);
                    zzem.zzeq = true;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(89461);
            }
        }
    }

    private final void onBackgroundStateChanged(boolean z) {
        AppMethodBeat.m2504i(89468);
        synchronized (zzem) {
            try {
                ArrayList arrayList = this.zzep;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((BackgroundStateChangeListener) obj).onBackgroundStateChanged(z);
                }
            } finally {
                AppMethodBeat.m2505o(89468);
            }
        }
    }

    @KeepForSdk
    public final void addListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        AppMethodBeat.m2504i(89464);
        synchronized (zzem) {
            try {
                this.zzep.add(backgroundStateChangeListener);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(89464);
            }
        }
    }

    @KeepForSdk
    public final boolean isInBackground() {
        AppMethodBeat.m2504i(89463);
        boolean z = this.zzen.get();
        AppMethodBeat.m2505o(89463);
        return z;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(89465);
        boolean compareAndSet = this.zzen.compareAndSet(true, false);
        this.zzeo.set(true);
        if (compareAndSet) {
            onBackgroundStateChanged(false);
        }
        AppMethodBeat.m2505o(89465);
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        AppMethodBeat.m2504i(89466);
        boolean compareAndSet = this.zzen.compareAndSet(true, false);
        this.zzeo.set(true);
        if (compareAndSet) {
            onBackgroundStateChanged(false);
        }
        AppMethodBeat.m2505o(89466);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i) {
        AppMethodBeat.m2504i(89467);
        if (i == 20 && this.zzen.compareAndSet(false, true)) {
            this.zzeo.set(true);
            onBackgroundStateChanged(true);
        }
        AppMethodBeat.m2505o(89467);
    }

    @TargetApi(16)
    @KeepForSdk
    public final boolean readCurrentStateIfPossible(boolean z) {
        AppMethodBeat.m2504i(89462);
        if (!this.zzeo.get()) {
            if (PlatformVersion.isAtLeastJellyBean()) {
                RunningAppProcessInfo runningAppProcessInfo = new RunningAppProcessInfo();
                ActivityManager.getMyMemoryState(runningAppProcessInfo);
                if (!this.zzeo.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                    this.zzen.set(true);
                }
            } else {
                AppMethodBeat.m2505o(89462);
                return z;
            }
        }
        z = isInBackground();
        AppMethodBeat.m2505o(89462);
        return z;
    }
}
