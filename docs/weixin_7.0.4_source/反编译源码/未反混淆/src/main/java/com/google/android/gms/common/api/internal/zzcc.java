package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class zzcc extends Fragment implements LifecycleFragment {
    private static WeakHashMap<FragmentActivity, WeakReference<zzcc>> zzla = new WeakHashMap();
    private Map<String, LifecycleCallback> zzlb = new a();
    private int zzlc = 0;
    private Bundle zzld;

    static {
        AppMethodBeat.i(89513);
        AppMethodBeat.o(89513);
    }

    public zzcc() {
        AppMethodBeat.i(89500);
        AppMethodBeat.o(89500);
    }

    public static zzcc zza(FragmentActivity fragmentActivity) {
        zzcc zzcc;
        AppMethodBeat.i(89501);
        WeakReference weakReference = (WeakReference) zzla.get(fragmentActivity);
        if (weakReference != null) {
            zzcc = (zzcc) weakReference.get();
            if (zzcc != null) {
                AppMethodBeat.o(89501);
                return zzcc;
            }
        }
        try {
            zzcc = (zzcc) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
            if (zzcc == null || zzcc.isRemoving()) {
                zzcc = new zzcc();
                fragmentActivity.getSupportFragmentManager().beginTransaction().a((Fragment) zzcc, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
            }
            zzla.put(fragmentActivity, new WeakReference(zzcc));
            AppMethodBeat.o(89501);
            return zzcc;
        } catch (ClassCastException e) {
            IllegalStateException illegalStateException = new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
            AppMethodBeat.o(89501);
            throw illegalStateException;
        }
    }

    public final void addCallback(String str, LifecycleCallback lifecycleCallback) {
        AppMethodBeat.i(89503);
        if (this.zzlb.containsKey(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
            AppMethodBeat.o(89503);
            throw illegalArgumentException;
        }
        this.zzlb.put(str, lifecycleCallback);
        if (this.zzlc > 0) {
            new Handler(Looper.getMainLooper()).post(new zzcd(this, lifecycleCallback, str));
        }
        AppMethodBeat.o(89503);
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        AppMethodBeat.i(89511);
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback dump : this.zzlb.values()) {
            dump.dump(str, fileDescriptor, printWriter, strArr);
        }
        AppMethodBeat.o(89511);
    }

    public final <T extends LifecycleCallback> T getCallbackOrNull(String str, Class<T> cls) {
        AppMethodBeat.i(89502);
        LifecycleCallback lifecycleCallback = (LifecycleCallback) cls.cast(this.zzlb.get(str));
        AppMethodBeat.o(89502);
        return lifecycleCallback;
    }

    public final /* synthetic */ Activity getLifecycleActivity() {
        AppMethodBeat.i(89512);
        FragmentActivity activity = getActivity();
        AppMethodBeat.o(89512);
        return activity;
    }

    public final boolean isCreated() {
        return this.zzlc > 0;
    }

    public final boolean isStarted() {
        return this.zzlc >= 2;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(89507);
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback onActivityResult : this.zzlb.values()) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
        AppMethodBeat.o(89507);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(89504);
        super.onCreate(bundle);
        this.zzlc = 1;
        this.zzld = bundle;
        for (Entry entry : this.zzlb.entrySet()) {
            ((LifecycleCallback) entry.getValue()).onCreate(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
        AppMethodBeat.o(89504);
    }

    public final void onDestroy() {
        AppMethodBeat.i(89510);
        super.onDestroy();
        this.zzlc = 5;
        for (LifecycleCallback onDestroy : this.zzlb.values()) {
            onDestroy.onDestroy();
        }
        AppMethodBeat.o(89510);
    }

    public final void onResume() {
        AppMethodBeat.i(89506);
        super.onResume();
        this.zzlc = 3;
        for (LifecycleCallback onResume : this.zzlb.values()) {
            onResume.onResume();
        }
        AppMethodBeat.o(89506);
    }

    public final void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(89508);
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            AppMethodBeat.o(89508);
            return;
        }
        for (Entry entry : this.zzlb.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((LifecycleCallback) entry.getValue()).onSaveInstanceState(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
        AppMethodBeat.o(89508);
    }

    public final void onStart() {
        AppMethodBeat.i(89505);
        super.onStart();
        this.zzlc = 2;
        for (LifecycleCallback onStart : this.zzlb.values()) {
            onStart.onStart();
        }
        AppMethodBeat.o(89505);
    }

    public final void onStop() {
        AppMethodBeat.i(89509);
        super.onStop();
        this.zzlc = 4;
        for (LifecycleCallback onStop : this.zzlb.values()) {
            onStop.onStop();
        }
        AppMethodBeat.o(89509);
    }
}
