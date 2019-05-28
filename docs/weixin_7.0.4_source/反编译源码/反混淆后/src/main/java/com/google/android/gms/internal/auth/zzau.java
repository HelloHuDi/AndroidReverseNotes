package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzau extends zzam {
    private ResultHolder<Status> zzdu;

    zzau(ResultHolder<Status> resultHolder) {
        this.zzdu = resultHolder;
    }

    public final void zze(Status status) {
        AppMethodBeat.m2504i(50484);
        this.zzdu.setResult(status);
        AppMethodBeat.m2505o(50484);
    }
}
