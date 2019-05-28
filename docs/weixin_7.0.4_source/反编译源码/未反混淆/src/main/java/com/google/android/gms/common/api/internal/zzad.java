package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.support.v4.f.b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzad extends zzk {
    private GoogleApiManager zzcq;
    private final b<zzh<?>> zzhb = new b();

    private zzad(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        AppMethodBeat.i(60686);
        this.mLifecycleFragment.addCallback("ConnectionlessLifecycleHelper", this);
        AppMethodBeat.o(60686);
    }

    public static void zza(Activity activity, GoogleApiManager googleApiManager, zzh<?> zzh) {
        AppMethodBeat.i(60685);
        LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
        zzad zzad = (zzad) fragment.getCallbackOrNull("ConnectionlessLifecycleHelper", zzad.class);
        if (zzad == null) {
            zzad = new zzad(fragment);
        }
        zzad.zzcq = googleApiManager;
        Preconditions.checkNotNull(zzh, "ApiKey cannot be null");
        zzad.zzhb.add(zzh);
        googleApiManager.zza(zzad);
        AppMethodBeat.o(60685);
    }

    private final void zzan() {
        AppMethodBeat.i(60692);
        if (!this.zzhb.isEmpty()) {
            this.zzcq.zza(this);
        }
        AppMethodBeat.o(60692);
    }

    public final void onResume() {
        AppMethodBeat.i(60688);
        super.onResume();
        zzan();
        AppMethodBeat.o(60688);
    }

    public final void onStart() {
        AppMethodBeat.i(60687);
        super.onStart();
        zzan();
        AppMethodBeat.o(60687);
    }

    public void onStop() {
        AppMethodBeat.i(60689);
        super.onStop();
        this.zzcq.zzb(this);
        AppMethodBeat.o(60689);
    }

    /* Access modifiers changed, original: protected|final */
    public final void zza(ConnectionResult connectionResult, int i) {
        AppMethodBeat.i(60690);
        this.zzcq.zza(connectionResult, i);
        AppMethodBeat.o(60690);
    }

    /* Access modifiers changed, original: final */
    public final b<zzh<?>> zzam() {
        return this.zzhb;
    }

    /* Access modifiers changed, original: protected|final */
    public final void zzr() {
        AppMethodBeat.i(60691);
        this.zzcq.zzr();
        AppMethodBeat.o(60691);
    }
}
