package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GooglePlayServicesUpdatedReceiver.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class zzbb extends Callback {
    private WeakReference<zzav> zziy;

    zzbb(zzav zzav) {
        AppMethodBeat.m2504i(60814);
        this.zziy = new WeakReference(zzav);
        AppMethodBeat.m2505o(60814);
    }

    public final void zzv() {
        AppMethodBeat.m2504i(60815);
        zzav zzav = (zzav) this.zziy.get();
        if (zzav == null) {
            AppMethodBeat.m2505o(60815);
            return;
        }
        zzav.zza(zzav);
        AppMethodBeat.m2505o(60815);
    }
}
