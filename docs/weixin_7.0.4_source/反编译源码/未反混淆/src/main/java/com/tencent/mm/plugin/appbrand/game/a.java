package com.tencent.mm.plugin.appbrand.game;

import com.tencent.luggage.g.d;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.MBRuntime.IMBEventListener;
import com.tencent.magicbrush.MBRuntime.MBParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.g;
import com.tencent.mm.plugin.appbrand.h.i;
import com.tencent.mm.plugin.appbrand.h.n;
import com.tencent.mm.plugin.appbrand.h.q;
import com.tencent.mm.plugin.appbrand.jsapi.bo;
import com.tencent.mm.plugin.appbrand.s.l;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.sdk.platformtools.f;

public final class a {
    public volatile MBRuntime hqb;
    public boolean hqc = false;
    public boolean hqd = false;
    public boolean hqe = true;
    public i hqf;
    public c hqg;
    public IMBEventListener hqh;
    public MBParams hqi = new MBParams();
    public final a hqj = new a(new Runnable() {
        public final void run() {
            AppMethodBeat.i(129993);
            if (a.this.hqb != null) {
                synchronized (a.this) {
                    try {
                        if (a.this.hqb != null) {
                            a.this.hqb.destroy();
                            a.this.hqb = null;
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(129993);
                    }
                }
                return;
            }
            AppMethodBeat.o(129993);
        }
    });

    class a extends com.tencent.magicbrush.d.b implements com.tencent.mm.plugin.appbrand.h.m.a {
        a(Runnable runnable) {
            super(runnable);
        }

        public final void onDestroy() {
            AppMethodBeat.i(129994);
            run();
            AppMethodBeat.o(129994);
        }
    }

    public class b extends com.tencent.magicbrush.MBRuntime.a {
        public final void onJsExceptionOccurred(String str, String str2, int i) {
            AppMethodBeat.i(129995);
            d.e("MicroMsg.MBRuntimeSimple", "[WAGame][AppBrand] message = [%s] stackTrace = [%s]", str, str2);
            if (a.this.hqf == null) {
                AppMethodBeat.o(129995);
                return;
            }
            q qVar = (q) a.this.hqf.af(q.class);
            if (i == qVar.aGU().aGT()) {
                bo.a(a.this.hqf, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[]{l.Ej(str), l.Ej(str2)}), 0);
                AppMethodBeat.o(129995);
                return;
            }
            g oO = qVar.oO(i);
            if (oO != null) {
                m.a(oO, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[]{l.Ej(str), l.Ej(str2)}));
                AppMethodBeat.o(129995);
            } else if (f.DEBUG) {
                IllegalStateException illegalStateException = new IllegalStateException("[DebugOnly] j2v8 not follow the pattern");
                AppMethodBeat.o(129995);
                throw illegalStateException;
            } else {
                AppMethodBeat.o(129995);
            }
        }
    }

    public static class c implements com.tencent.magicbrush.handler.a {
        private n hql;

        public /* synthetic */ c(i iVar, byte b) {
            this(iVar);
        }

        private c(i iVar) {
            AppMethodBeat.i(129996);
            this.hql = (n) iVar.af(n.class);
            AppMethodBeat.o(129996);
        }

        public final void f(Runnable runnable) {
            AppMethodBeat.i(129997);
            this.hql.f(runnable);
            AppMethodBeat.o(129997);
        }

        public final boolean yE() {
            AppMethodBeat.i(129998);
            boolean yE = this.hql.yE();
            AppMethodBeat.o(129998);
            return yE;
        }
    }

    public a() {
        AppMethodBeat.i(129999);
        AppMethodBeat.o(129999);
    }
}
