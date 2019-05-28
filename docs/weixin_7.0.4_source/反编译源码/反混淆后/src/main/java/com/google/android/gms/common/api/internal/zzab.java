package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzab implements StatusListener {
    private final /* synthetic */ BasePendingResult zzgy;
    private final /* synthetic */ zzaa zzgz;

    zzab(zzaa zzaa, BasePendingResult basePendingResult) {
        this.zzgz = zzaa;
        this.zzgy = basePendingResult;
    }

    public final void onComplete(Status status) {
        AppMethodBeat.m2504i(60683);
        this.zzgz.zzgw.remove(this.zzgy);
        AppMethodBeat.m2505o(60683);
    }
}
