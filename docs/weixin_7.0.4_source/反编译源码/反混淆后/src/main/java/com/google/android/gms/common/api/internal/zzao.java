package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.concurrent.GuardedBy;

final class zzao extends zzbe {
    private final /* synthetic */ ConnectionProgressReportCallbacks zzia;

    zzao(zzam zzam, zzbc zzbc, ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.zzia = connectionProgressReportCallbacks;
        super(zzbc);
    }

    @GuardedBy("mLock")
    public final void zzaq() {
        AppMethodBeat.m2504i(60754);
        this.zzia.onReportServiceBinding(new ConnectionResult(16, null));
        AppMethodBeat.m2505o(60754);
    }
}
