package com.tencent.mm.at.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.n;
import com.tencent.mm.at.a.d.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class g implements n {
    private a<String, Integer> fHo = new a(10);

    public g() {
        AppMethodBeat.i(116093);
        AppMethodBeat.o(116093);
    }

    public final synchronized boolean sG(String str) {
        boolean z;
        AppMethodBeat.i(116094);
        if (this.fHo.aj(str)) {
            int intValue = ((Integer) this.fHo.get(str)).intValue();
            this.fHo.put(str, Integer.valueOf(intValue + 1));
            if (intValue >= 50) {
                if (intValue == 50 || intValue % 500 == 0) {
                    ab.i("MicroMsg.imageloader.DefaultImageRetryDownloadListener", "Url %s retry over time %d current time:%d, then stop retry download", str, Integer.valueOf(50), Integer.valueOf(intValue));
                }
                AppMethodBeat.o(116094);
                z = false;
            }
            AppMethodBeat.o(116094);
            z = true;
        } else {
            this.fHo.put(str, Integer.valueOf(1));
            AppMethodBeat.o(116094);
            z = true;
        }
        return z;
    }
}
