package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class zza extends ActivityLifecycleObserver {
    private final WeakReference<zza> zzds;

    static class zza extends LifecycleCallback {
        private List<Runnable> zzdt = new ArrayList();

        private zza(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            AppMethodBeat.i(60668);
            this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
            AppMethodBeat.o(60668);
        }

        private static zza zza(Activity activity) {
            zza zza;
            AppMethodBeat.i(60667);
            synchronized (activity) {
                try {
                    LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
                    zza = (zza) fragment.getCallbackOrNull("LifecycleObserverOnStop", zza.class);
                    if (zza == null) {
                        zza = new zza(fragment);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(60667);
                }
            }
            return zza;
        }

        static /* synthetic */ void zza(zza zza, Runnable runnable) {
            AppMethodBeat.i(60672);
            zza.zza(runnable);
            AppMethodBeat.o(60672);
        }

        private final synchronized void zza(Runnable runnable) {
            AppMethodBeat.i(60669);
            this.zzdt.add(runnable);
            AppMethodBeat.o(60669);
        }

        static /* synthetic */ zza zzb(Activity activity) {
            AppMethodBeat.i(60671);
            zza zza = zza(activity);
            AppMethodBeat.o(60671);
            return zza;
        }

        public void onStop() {
            AppMethodBeat.i(60670);
            synchronized (this) {
                try {
                    List<Runnable> list = this.zzdt;
                    this.zzdt = new ArrayList();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(60670);
                }
            }
            for (Runnable run : list) {
                run.run();
            }
        }
    }

    public zza(Activity activity) {
        this(zza.zzb(activity));
        AppMethodBeat.i(60673);
        AppMethodBeat.o(60673);
    }

    private zza(zza zza) {
        AppMethodBeat.i(60674);
        this.zzds = new WeakReference(zza);
        AppMethodBeat.o(60674);
    }

    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        AppMethodBeat.i(60675);
        zza zza = (zza) this.zzds.get();
        if (zza == null) {
            IllegalStateException illegalStateException = new IllegalStateException("The target activity has already been GC'd");
            AppMethodBeat.o(60675);
            throw illegalStateException;
        }
        zza.zza(zza, runnable);
        AppMethodBeat.o(60675);
        return this;
    }
}
