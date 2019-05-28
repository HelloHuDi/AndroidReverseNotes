package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.ai.w;
import com.tencent.mm.g.a.kr;
import com.tencent.mm.kernel.api.d;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bk;
import com.tencent.mm.network.e;
import com.tencent.mm.network.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Iterator;

public final class b {
    public static String eJm = "wechatnetwork";
    private static al eJr = null;
    public final a eJn;
    public final p eJo;
    private HashSet<n> eJp = new HashSet();
    public n eJq = new com.tencent.mm.network.n.a() {
        public final void gl(int i) {
            AppMethodBeat.i(57923);
            try {
                HashSet hashSet = new HashSet();
                synchronized (b.this.eJp) {
                    hashSet.addAll(b.this.eJp);
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    ((n) it.next()).gl(i);
                }
                AppMethodBeat.o(57923);
            } catch (Exception e) {
                ab.printErrStackTrace("MMKernel.CoreNetwork", e, "onNetworkChange caught crash", new Object[0]);
                AppMethodBeat.o(57923);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(57923);
                }
            }
        }
    };

    public static class a extends com.tencent.mm.ci.a<d> implements d {
        a() {
        }

        public final void b(final e eVar) {
            AppMethodBeat.i(57932);
            a(new com.tencent.mm.ci.a.a<d>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(57931);
                    ((d) obj).b(eVar);
                    AppMethodBeat.o(57931);
                }
            });
            AppMethodBeat.o(57932);
        }
    }

    public b(com.tencent.mm.ai.p.a aVar, a aVar2) {
        AppMethodBeat.i(57933);
        this.eJo = p.a(aVar);
        this.eJo.ftB = g.RS();
        w.fuq = new com.tencent.mm.ai.w.b() {
            public final p Rh() {
                AppMethodBeat.i(57922);
                p a = b.this.eJo;
                AppMethodBeat.o(57922);
                return a;
            }
        };
        this.eJn = aVar2;
        AppMethodBeat.o(57933);
    }

    public final void a(n nVar) {
        AppMethodBeat.i(57934);
        synchronized (this.eJp) {
            try {
                this.eJp.add(nVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(57934);
            }
        }
    }

    public final void b(n nVar) {
        AppMethodBeat.i(57935);
        synchronized (this.eJp) {
            try {
                this.eJp.remove(nVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(57935);
            }
        }
    }

    public static al Re() {
        return eJr;
    }

    public static void a(al alVar) {
        eJr = alVar;
    }

    public final p Rg() {
        return this.eJo;
    }

    public static void b(int i, int i2, boolean z, String str) {
        AppMethodBeat.i(57938);
        kr krVar = new kr();
        krVar.cGB.status = i;
        krVar.cGB.cGC = i2;
        krVar.cGB.cGD = z;
        krVar.cGB.cGE = str;
        com.tencent.mm.sdk.b.a.xxA.m(krVar);
        AppMethodBeat.o(57938);
    }

    public final void Rf() {
        AppMethodBeat.i(57936);
        this.eJo.a(new bk(new com.tencent.mm.model.bk.a() {
            public final void a(e eVar) {
                AppMethodBeat.i(57924);
                if (eVar == null || eVar.adg() == null) {
                    AppMethodBeat.o(57924);
                    return;
                }
                eVar.adg().reset();
                AppMethodBeat.o(57924);
            }
        }, "reset accinfo"), 0);
        AppMethodBeat.o(57936);
    }

    public final byte[] jQ(int i) {
        byte[] bArr = null;
        AppMethodBeat.i(57937);
        try {
            if (this.eJo == null || this.eJo.ftA == null || this.eJo.ftA.adg() == null) {
                AppMethodBeat.o(57937);
                return bArr;
            }
            bArr = this.eJo.ftA.adg().jQ(i);
            AppMethodBeat.o(57937);
            return bArr;
        } catch (Exception e) {
            ab.w("MMKernel.CoreNetwork", "get session key error, %s", e.getMessage());
            ab.e("MMKernel.CoreNetwork", "exception:%s", bo.l(e));
            AppMethodBeat.o(57937);
        }
    }
}
