package com.google.android.gms.common.server.response;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;

final class zzb implements zza<Long> {
    zzb() {
    }

    public final /* synthetic */ Object zzh(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.m2504i(61627);
        Long valueOf = Long.valueOf(FastParser.zzb(fastParser, bufferedReader));
        AppMethodBeat.m2505o(61627);
        return valueOf;
    }
}
