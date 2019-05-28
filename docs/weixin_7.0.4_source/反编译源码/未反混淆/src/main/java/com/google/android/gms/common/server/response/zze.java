package com.google.android.gms.common.server.response;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;

final class zze implements zza<Boolean> {
    zze() {
    }

    public final /* synthetic */ Object zzh(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.i(61630);
        Boolean valueOf = Boolean.valueOf(FastParser.zza(fastParser, bufferedReader, false));
        AppMethodBeat.o(61630);
        return valueOf;
    }
}
