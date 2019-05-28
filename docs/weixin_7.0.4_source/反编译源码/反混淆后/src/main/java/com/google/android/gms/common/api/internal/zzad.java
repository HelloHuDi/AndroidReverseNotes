package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.support.p057v4.p065f.C0402b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzad extends zzk {
    private GoogleApiManager zzcq;
    private final C0402b<zzh<?>> zzhb = new C0402b();

    private zzad(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        AppMethodBeat.m2504i(60686);
        this.mLifecycleFragment.addCallback("ConnectionlessLifecycleHelper", this);
        AppMethodBeat.m2505o(60686);
    }

    public static void zza(Activity activity, GoogleApiManager googleApiManager, zzh<?> zzh) {
        AppMethodBeat.m2504i(60685);
        LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
        zzad zzad = (zzad) fragment.getCallbackOrNull("ConnectionlessLifecycleHelper", zzad.class);
        if (zzad == null) {
            zzad = new zzad(fragment);
        }
        zzad.zzcq = googleApiManager;
        Preconditions.checkNotNull(zzh, "ApiKey cannot be null");
        zzad.zzhb.add(zzh);
        googleApiManager.zza(zzad);
        AppMethodBeat.m2505o(60685);
    }

    private final void zzan() {
        AppMethodBeat.m2504i(60692);
        if (!this.zzhb.isEmpty()) {
            this.zzcq.zza(this);
        }
        AppMethodBeat.m2505o(60692);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(60688);
        super.onResume();
        zzan();
        AppMethodBeat.m2505o(60688);
    }

    public final void onStart() {
        AppMethodBeat.m2504i(60687);
        super.onStart();
        zzan();
        AppMethodBeat.m2505o(60687);
    }

    public void onStop() {
        AppMethodBeat.m2504i(60689);
        super.onStop();
        this.zzcq.zzb(this);
        AppMethodBeat.m2505o(60689);
    }

    /* Access modifiers changed, original: protected|final */
    public final void zza(ConnectionResult connectionResult, int i) {
        AppMethodBeat.m2504i(60690);
        this.zzcq.zza(connectionResult, i);
        AppMethodBeat.m2505o(60690);
    }

    /* Access modifiers changed, original: final */
    public final C0402b<zzh<?>> zzam() {
        return this.zzhb;
    }

    /* Access modifiers changed, original: protected|final */
    public final void zzr() {
        AppMethodBeat.m2504i(60691);
        this.zzcq.zzr();
        AppMethodBeat.m2505o(60691);
    }
}
