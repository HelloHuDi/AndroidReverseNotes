package com.tencent.mm.plugin.appbrand.m.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.a.e;
import com.tencent.mm.plugin.appbrand.m.a.e.a;
import com.tencent.mm.plugin.appbrand.permission.e.c;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class b extends e {
    private c iql;

    public b(a aVar, q qVar) {
        super(aVar, qVar);
    }

    public final void aIV() {
        AppMethodBeat.i(102208);
        com.tencent.mm.plugin.appbrand.permission.e xY = ((com.tencent.luggage.sdk.b.b) this.gMN.getRuntime()).xY();
        if (xY == null) {
            ab.e("MicroMsg.ProxyOnPermissionUpdateListener", "AppRuntimeApiPermissionController null");
            AppMethodBeat.o(102208);
            return;
        }
        this.iql = new c() {
            public final void f(byte[] bArr, byte[] bArr2) {
                AppMethodBeat.i(102207);
                ab.i("MicroMsg.ProxyOnPermissionUpdateListener", "onUpdate");
                HashMap hashMap = new HashMap();
                hashMap.put("fg", bArr);
                hashMap.put("bg", bArr2);
                b.this.D(hashMap);
                AppMethodBeat.o(102207);
            }
        };
        c cVar = this.iql;
        synchronized (xY.iwO) {
            try {
                xY.iwQ.add(cVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(102208);
            }
        }
    }

    public final void removeListener() {
        AppMethodBeat.i(102209);
        if (this.iql == null) {
            AppMethodBeat.o(102209);
        } else if (this.gMN.getRuntime() == null) {
            AppMethodBeat.o(102209);
        } else {
            com.tencent.mm.plugin.appbrand.permission.e xY = ((com.tencent.luggage.sdk.b.b) this.gMN.getRuntime()).xY();
            if (xY == null) {
                AppMethodBeat.o(102209);
                return;
            }
            c cVar = this.iql;
            synchronized (xY.iwO) {
                try {
                    xY.iwQ.remove(cVar);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(102209);
                }
            }
        }
    }

    public final int getType() {
        return 3;
    }
}
