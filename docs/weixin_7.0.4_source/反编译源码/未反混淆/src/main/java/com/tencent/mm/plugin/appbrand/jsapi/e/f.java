package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.q;
import org.json.JSONObject;

public class f extends d<q> {
    private static final int CTRL_INDEX = 340;
    private static final String NAME = "enableLocationUpdate";
    private volatile a hKL;
    k hKM;

    public final /* synthetic */ void c(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(74742);
        final q qVar = (q) cVar;
        super.c(qVar, jSONObject, i);
        synchronized (this) {
            try {
                if (this.hKL == null) {
                    this.hKL = new a() {
                        public final void a(String str, b bVar) {
                            AppMethodBeat.i(74740);
                            if (bVar == b.DESTROYED) {
                                f.this.hKK.quit();
                                AppMethodBeat.o(74740);
                            } else if (bVar == b.SUSPEND) {
                                f.this.hKK.sendMessage(3);
                                AppMethodBeat.o(74740);
                            } else {
                                if (bVar == b.FOREGROUND) {
                                    f.this.hKK.sendMessage(4);
                                }
                                AppMethodBeat.o(74740);
                            }
                        }
                    };
                    qVar.getRuntime().gNN.a(this.hKL);
                    this.hKM = new k();
                    this.hKK.hKV = new l.a() {
                        public final void Bb(String str) {
                            AppMethodBeat.i(74741);
                            Object obj = -1;
                            switch (str.hashCode()) {
                                case -1562453447:
                                    if (str.equals("StateNotListening")) {
                                        obj = 1;
                                        break;
                                    }
                                    break;
                                case -1514425717:
                                    if (str.equals("StateSuspend")) {
                                        obj = 2;
                                        break;
                                    }
                                    break;
                                case 1073716042:
                                    if (str.equals("StateListening")) {
                                        obj = null;
                                        break;
                                    }
                                    break;
                            }
                            switch (obj) {
                                case null:
                                    f.this.hKM.w(qVar.getRuntime());
                                    AppMethodBeat.o(74741);
                                    return;
                                case 1:
                                    f.this.hKM.aDE();
                                    break;
                            }
                            AppMethodBeat.o(74741);
                        }
                    };
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(74742);
            }
        }
    }
}
