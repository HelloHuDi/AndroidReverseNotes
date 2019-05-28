package com.tencent.mm.plugin.hardwareopt.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.asz;

public class a {
    private static volatile a nqq = null;
    private asz nqr = null;

    private a() {
    }

    public static a bFS() {
        AppMethodBeat.i(59273);
        a aVar;
        if (nqq == null) {
            synchronized (a.class) {
                try {
                    if (nqq == null) {
                        nqq = new a();
                    }
                    aVar = nqq;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(59273);
                }
            }
            return aVar;
        }
        aVar = nqq;
        AppMethodBeat.o(59273);
        return aVar;
    }

    public final asz bFT() {
        AppMethodBeat.i(59274);
        if (this.nqr == null) {
            this.nqr = new asz();
        }
        asz asz = this.nqr;
        AppMethodBeat.o(59274);
        return asz;
    }
}
