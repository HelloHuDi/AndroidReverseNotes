package com.google.android.gms.common.server.response;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.math.BigInteger;

final class zzg implements zza<BigInteger> {
    zzg() {
    }

    public final /* synthetic */ Object zzh(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.i(61632);
        BigInteger zzf = FastParser.zzf(fastParser, bufferedReader);
        AppMethodBeat.o(61632);
        return zzf;
    }
}
