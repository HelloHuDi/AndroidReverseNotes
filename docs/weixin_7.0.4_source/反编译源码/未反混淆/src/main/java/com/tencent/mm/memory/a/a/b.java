package com.tencent.mm.memory.a.a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.a.f.c;
import com.tencent.mm.memory.a.a.a.d;
import com.tencent.mm.memory.a.a.a.g;
import java.util.concurrent.ConcurrentHashMap;

public class b {
    private static volatile b feh;
    public static final com.tencent.mm.memory.a.a.a.a fei;
    private final String TAG = "MicroMsg.CacheInvoke";
    public ConcurrentHashMap<String, b> fdN = new ConcurrentHashMap();
    private b fej = null;

    public interface b<T> {
        void Xs();

        com.tencent.mm.memory.a.a.a.a Xt();

        d<String, T> Xu();

        f<String, T> Xv();
    }

    static class a implements b {
        private static String fen = "//data[%d,%d]::%s::%s";
        private d<String, a> fek = null;
        private g<String, Object> fel = null;
        private com.tencent.mm.memory.a.a.a.a fem;

        a(com.tencent.mm.memory.a.a.a.a aVar) {
            AppMethodBeat.i(115450);
            this.fem = aVar;
            this.fek = new com.tencent.mm.memory.a.a.a.f<String, a>(aVar, new com.tencent.mm.a.f.b<String, a>() {
                public final /* synthetic */ void c(Object obj, Object obj2, Object obj3) {
                    AppMethodBeat.i(115448);
                    String str = (String) obj;
                    a aVar = (a) obj2;
                    a aVar2 = (a) obj3;
                    if (!(aVar == null || aVar.fec == null || aVar.fec.get() == null)) {
                        com.tencent.mm.a.f.b bVar = (com.tencent.mm.a.f.b) aVar.fec.get();
                        if (bVar != null) {
                            bVar.c(str, aVar, aVar2);
                        }
                    }
                    AppMethodBeat.o(115448);
                }
            }, new c<String, a>() {
                public final /* bridge */ /* synthetic */ int l(Object obj, Object obj2) {
                    a aVar = (a) obj2;
                    if (aVar != null) {
                        return aVar.fee;
                    }
                    return 0;
                }
            }) {
                public final /* synthetic */ Object p(Object obj, Object obj2) {
                    AppMethodBeat.i(115449);
                    String str = (String) obj2;
                    String str2 = ((String) obj) + "@" + str;
                    AppMethodBeat.o(115449);
                    return str2;
                }
            };
            this.fel = new g();
            AppMethodBeat.o(115450);
        }

        public final void Xs() {
            AppMethodBeat.i(115451);
            this.fek.trimToSize(this.fem.fer / 2);
            AppMethodBeat.o(115451);
        }

        public final com.tencent.mm.memory.a.a.a.a Xt() {
            return this.fem;
        }

        public final d Xu() {
            return this.fek;
        }

        public final f Xv() {
            return this.fel;
        }
    }

    static {
        AppMethodBeat.i(115458);
        com.tencent.mm.memory.a.a.a.a Xw = com.tencent.mm.memory.a.a.a.a.Xw();
        fei = Xw;
        b Xr = Xr();
        a aVar = new a(Xw);
        Xr.fdN.put(Xw.few, aVar);
        if (Xw.equals(fei)) {
            Xr.fej = aVar;
        }
        AppMethodBeat.o(115458);
    }

    b() {
        AppMethodBeat.i(115452);
        AppMethodBeat.o(115452);
    }

    public static b Xr() {
        AppMethodBeat.i(115453);
        if (feh == null) {
            synchronized (b.class) {
                try {
                    if (feh == null) {
                        feh = new b();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(115453);
                    }
                }
            }
        }
        b bVar = feh;
        AppMethodBeat.o(115453);
        return bVar;
    }

    private static b b(com.tencent.mm.memory.a.a.a.a aVar) {
        AppMethodBeat.i(115454);
        b bVar = (b) Xr().fdN.get(aVar.few);
        AppMethodBeat.o(115454);
        return bVar;
    }

    public static d<String, a> c(com.tencent.mm.memory.a.a.a.a aVar) {
        AppMethodBeat.i(115455);
        d<String, a> Xu;
        if (aVar == null || aVar.equals("")) {
            AppMethodBeat.o(115455);
            return null;
        } else if (fei.equals(aVar)) {
            Xu = Xr().fej.Xu();
            AppMethodBeat.o(115455);
            return Xu;
        } else {
            Xr();
            Xu = b(aVar).Xu();
            AppMethodBeat.o(115455);
            return Xu;
        }
    }

    public static f<String, Object> d(com.tencent.mm.memory.a.a.a.a aVar) {
        AppMethodBeat.i(115456);
        f<String, Object> Xv;
        if (aVar == null || aVar.equals("")) {
            AppMethodBeat.o(115456);
            return null;
        } else if (fei.equals(aVar)) {
            Xv = Xr().fej.Xv();
            AppMethodBeat.o(115456);
            return Xv;
        } else {
            Xr();
            Xv = b(aVar).Xv();
            AppMethodBeat.o(115456);
            return Xv;
        }
    }

    public static int e(com.tencent.mm.memory.a.a.a.a aVar) {
        AppMethodBeat.i(115457);
        int i;
        if (aVar == null || aVar.equals("")) {
            AppMethodBeat.o(115457);
            return BaseClientBuilder.API_PRIORITY_OTHER;
        } else if (fei.equals(aVar)) {
            i = Xr().fej.Xt().fer;
            AppMethodBeat.o(115457);
            return i;
        } else {
            Xr();
            i = b(aVar).Xt().fer;
            AppMethodBeat.o(115457);
            return i;
        }
    }
}
