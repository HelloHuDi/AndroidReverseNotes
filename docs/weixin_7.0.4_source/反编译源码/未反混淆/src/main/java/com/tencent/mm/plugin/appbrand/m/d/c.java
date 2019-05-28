package com.tencent.mm.plugin.appbrand.m.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.m.a.e;
import com.tencent.mm.plugin.appbrand.q;
import java.util.HashMap;

public final class c extends e {
    private a iqn;

    public c(e.a aVar, q qVar) {
        super(aVar, qVar);
    }

    public final void aIV() {
        AppMethodBeat.i(102211);
        this.iqn = new a() {
            public final void a(String str, b bVar) {
                AppMethodBeat.i(102210);
                HashMap hashMap = new HashMap();
                hashMap.put("state", Integer.valueOf(bVar.ordinal()));
                c.this.D(hashMap);
                AppMethodBeat.o(102210);
            }
        };
        this.gMN.getRuntime().gNN.a(this.iqn);
        AppMethodBeat.o(102211);
    }

    public final void removeListener() {
        AppMethodBeat.i(102212);
        if (this.iqn == null) {
            AppMethodBeat.o(102212);
        } else if (this.gMN.getRuntime() == null) {
            AppMethodBeat.o(102212);
        } else {
            com.tencent.mm.plugin.appbrand.b.c cVar = this.gMN.getRuntime().gNN;
            if (cVar == null) {
                AppMethodBeat.o(102212);
                return;
            }
            cVar.b(this.iqn);
            AppMethodBeat.o(102212);
        }
    }

    public final int getType() {
        return 2;
    }
}
