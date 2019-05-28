package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzb implements OnSuccessListener<Void> {
    private final /* synthetic */ OnTokenCanceledListener zzafi;

    zzb(zza zza, OnTokenCanceledListener onTokenCanceledListener) {
        this.zzafi = onTokenCanceledListener;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        AppMethodBeat.m2504i(57380);
        this.zzafi.onCanceled();
        AppMethodBeat.m2505o(57380);
    }
}
