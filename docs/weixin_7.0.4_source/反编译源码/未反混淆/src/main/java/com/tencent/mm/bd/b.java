package com.tencent.mm.bd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;

public final class b {
    private static final b fNg = new b();
    public long fNf;

    static {
        AppMethodBeat.i(1007);
        AppMethodBeat.o(1007);
    }

    public b() {
        AppMethodBeat.i(1006);
        if (g.RK()) {
            this.fNf = r.YE();
            AppMethodBeat.o(1006);
            return;
        }
        a.xxA.b(new c<cd>() {
            {
                AppMethodBeat.i(1004);
                this.xxI = cd.class.getName().hashCode();
                AppMethodBeat.o(1004);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(1005);
                if (g.RK()) {
                    b.this.fNf = r.YE();
                }
                AppMethodBeat.o(1005);
                return true;
            }
        });
        AppMethodBeat.o(1006);
    }

    public static b aiC() {
        return fNg;
    }
}
