package com.google.android.gms.common.server.response;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;

final class zzd implements zza<Double> {
    zzd() {
    }

    public final /* synthetic */ Object zzh(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.m2504i(61629);
        Double valueOf = Double.valueOf(FastParser.zzd(fastParser, bufferedReader));
        AppMethodBeat.m2505o(61629);
        return valueOf;
    }
}
