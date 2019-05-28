package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

final /* synthetic */ class zzaq implements ResultConverter {
    static final ResultConverter zzbx = new zzaq();

    static {
        AppMethodBeat.m2504i(71027);
        AppMethodBeat.m2505o(71027);
    }

    private zzaq() {
    }

    public final Object convert(Result result) {
        AppMethodBeat.m2504i(71026);
        InputStream inputStream = ((GetInputStreamResult) result).getInputStream();
        AppMethodBeat.m2505o(71026);
        return inputStream;
    }
}
