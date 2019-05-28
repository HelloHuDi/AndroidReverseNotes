package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.p057v4.p065f.C6197a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class zzbr extends Fragment implements LifecycleFragment {
    private static WeakHashMap<Activity, WeakReference<zzbr>> zzla = new WeakHashMap();
    private Map<String, LifecycleCallback> zzlb = new C6197a();
    private int zzlc = 0;
    private Bundle zzld;

    static {
        AppMethodBeat.m2504i(89498);
        AppMethodBeat.m2505o(89498);
    }

    public zzbr() {
        AppMethodBeat.m2504i(89485);
        AppMethodBeat.m2505o(89485);
    }

    public static zzbr zzc(Activity activity) {
        zzbr zzbr;
        AppMethodBeat.m2504i(89486);
        WeakReference weakReference = (WeakReference) zzla.get(activity);
        if (weakReference != null) {
            zzbr = (zzbr) weakReference.get();
            if (zzbr != null) {
                AppMethodBeat.m2505o(89486);
                return zzbr;
            }
        }
        try {
            zzbr = (zzbr) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (zzbr == null || zzbr.isRemoving()) {
                zzbr = new zzbr();
                activity.getFragmentManager().beginTransaction().add(zzbr, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            zzla.put(activity, new WeakReference(zzbr));
            AppMethodBeat.m2505o(89486);
            return zzbr;
        } catch (ClassCastException e) {
            IllegalStateException illegalStateException = new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e);
            AppMethodBeat.m2505o(89486);
            throw illegalStateException;
        }
    }

    public final void addCallback(String str, LifecycleCallback lifecycleCallback) {
        AppMethodBeat.m2504i(89488);
        if (this.zzlb.containsKey(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
            AppMethodBeat.m2505o(89488);
            throw illegalArgumentException;
        }
        this.zzlb.put(str, lifecycleCallback);
        if (this.zzlc > 0) {
            new Handler(Looper.getMainLooper()).post(new zzbs(this, lifecycleCallback, str));
        }
        AppMethodBeat.m2505o(89488);
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        AppMethodBeat.m2504i(89497);
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback dump : this.zzlb.values()) {
            dump.dump(str, fileDescriptor, printWriter, strArr);
        }
        AppMethodBeat.m2505o(89497);
    }

    public final <T extends LifecycleCallback> T getCallbackOrNull(String str, Class<T> cls) {
        AppMethodBeat.m2504i(89487);
        LifecycleCallback lifecycleCallback = (LifecycleCallback) cls.cast(this.zzlb.get(str));
        AppMethodBeat.m2505o(89487);
        return lifecycleCallback;
    }

    public final Activity getLifecycleActivity() {
        AppMethodBeat.m2504i(89489);
        Activity activity = getActivity();
        AppMethodBeat.m2505o(89489);
        return activity;
    }

    public final boolean isCreated() {
        return this.zzlc > 0;
    }

    public final boolean isStarted() {
        return this.zzlc >= 2;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(89493);
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback onActivityResult : this.zzlb.values()) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
        AppMethodBeat.m2505o(89493);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(89490);
        super.onCreate(bundle);
        this.zzlc = 1;
        this.zzld = bundle;
        for (Entry entry : this.zzlb.entrySet()) {
            ((LifecycleCallback) entry.getValue()).onCreate(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
        AppMethodBeat.m2505o(89490);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(89496);
        super.onDestroy();
        this.zzlc = 5;
        for (LifecycleCallback onDestroy : this.zzlb.values()) {
            onDestroy.onDestroy();
        }
        AppMethodBeat.m2505o(89496);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(89492);
        super.onResume();
        this.zzlc = 3;
        for (LifecycleCallback onResume : this.zzlb.values()) {
            onResume.onResume();
        }
        AppMethodBeat.m2505o(89492);
    }

    public final void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.m2504i(89494);
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            AppMethodBeat.m2505o(89494);
            return;
        }
        for (Entry entry : this.zzlb.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((LifecycleCallback) entry.getValue()).onSaveInstanceState(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
        AppMethodBeat.m2505o(89494);
    }

    public final void onStart() {
        AppMethodBeat.m2504i(89491);
        super.onStart();
        this.zzlc = 2;
        for (LifecycleCallback onStart : this.zzlb.values()) {
            onStart.onStart();
        }
        AppMethodBeat.m2505o(89491);
    }

    public final void onStop() {
        AppMethodBeat.m2504i(89495);
        super.onStop();
        this.zzlc = 4;
        for (LifecycleCallback onStop : this.zzlb.values()) {
            onStop.onStop();
        }
        AppMethodBeat.m2505o(89495);
    }
}
