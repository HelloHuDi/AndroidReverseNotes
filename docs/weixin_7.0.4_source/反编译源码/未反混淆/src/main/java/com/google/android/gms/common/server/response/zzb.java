package com.google.android.gms.common.server.response;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;

final class zzb implements zza<Long> {
    zzb() {
    }

    public final /* synthetic */ Object zzh(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.i(61627);
        Long valueOf = Long.valueOf(FastParser.zzb(fastParser, bufferedReader));
        AppMethodBeat.o(61627);
        return valueOf;
    }
}
