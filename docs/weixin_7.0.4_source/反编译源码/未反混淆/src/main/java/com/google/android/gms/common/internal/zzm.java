package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzm implements ResultConverter<R, T> {
    private final /* synthetic */ Response zzus;

    zzm(Response response) {
        this.zzus = response;
    }

    public final /* synthetic */ Object convert(Result result) {
        AppMethodBeat.i(61409);
        this.zzus.setResult(result);
        Response response = this.zzus;
        AppMethodBeat.o(61409);
        return response;
    }
}
