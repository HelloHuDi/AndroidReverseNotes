package com.google.android.gms.common.server.response;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;

final class zze implements zza<Boolean> {
    zze() {
    }

    public final /* synthetic */ Object zzh(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.m2504i(61630);
        Boolean valueOf = Boolean.valueOf(FastParser.zza(fastParser, bufferedReader, false));
        AppMethodBeat.m2505o(61630);
        return valueOf;
    }
}
