package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

final /* synthetic */ class zzar implements ResultConverter {
    static final ResultConverter zzbx = new zzar();

    static {
        AppMethodBeat.m2504i(71029);
        AppMethodBeat.m2505o(71029);
    }

    private zzar() {
    }

    public final Object convert(Result result) {
        AppMethodBeat.m2504i(71028);
        OutputStream outputStream = ((GetOutputStreamResult) result).getOutputStream();
        AppMethodBeat.m2505o(71028);
        return outputStream;
    }
}
