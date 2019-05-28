package com.tencent.mm.d.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b extends v {
    private b(String str, byte[] bArr) {
        super(str, bArr);
    }

    static v f(String str, byte[] bArr) {
        AppMethodBeat.i(113797);
        b bVar = new b(str, bArr);
        AppMethodBeat.o(113797);
        return bVar;
    }

    /* Access modifiers changed, original: final */
    public final d Cp() {
        AppMethodBeat.i(113798);
        Looper.prepare();
        h hVar = new h(Looper.myLooper());
        AppMethodBeat.o(113798);
        return hVar;
    }
}
