package com.google.android.gms.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzg implements zza {
    private final /* synthetic */ DeferredLifecycleHelper zzabg;

    zzg(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zzabg = deferredLifecycleHelper;
    }

    public final int getState() {
        return 5;
    }

    public final void zza(LifecycleDelegate lifecycleDelegate) {
        AppMethodBeat.m2504i(61641);
        this.zzabg.zzabc.onResume();
        AppMethodBeat.m2505o(61641);
    }
}
