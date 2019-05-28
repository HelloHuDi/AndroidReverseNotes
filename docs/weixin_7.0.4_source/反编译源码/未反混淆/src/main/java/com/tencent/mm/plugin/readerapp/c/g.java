package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bm;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashMap;
import java.util.List;

public class g implements at {
    private static HashMap<Integer, d> eaA;
    private bm pEL;
    private c pEM = new c();
    private a pEN = new a();
    private d pEO = new d();
    private f pEP = new f();

    public interface a {
        void cdW();
    }

    public g() {
        AppMethodBeat.i(76769);
        AppMethodBeat.o(76769);
    }

    static /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(76782);
        c(aVar);
        AppMethodBeat.o(76782);
    }

    private static g cdY() {
        AppMethodBeat.i(76770);
        g gVar = (g) q.Y(g.class);
        AppMethodBeat.o(76770);
        return gVar;
    }

    public static bm cdZ() {
        AppMethodBeat.i(76771);
        com.tencent.mm.kernel.g.RN().QU();
        if (cdY().pEL == null) {
            cdY().pEL = new bm(com.tencent.mm.kernel.g.RP().eJN);
        }
        bm bmVar = cdY().pEL;
        AppMethodBeat.o(76771);
        return bmVar;
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(76772);
        com.tencent.mm.ai.d.a.b(this.pEM);
        com.tencent.mm.sdk.b.a.xxA.d(this.pEN);
        com.tencent.mm.sdk.b.a.xxA.d(this.pEO);
        com.tencent.mm.sdk.b.a.xxA.d(this.pEP);
        e eVar = e.pEK;
        AppMethodBeat.o(76772);
    }

    static {
        AppMethodBeat.i(76783);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("READERAPPINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return bm.fnj;
            }
        });
        AppMethodBeat.o(76783);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
        AppMethodBeat.i(76773);
        if ((SQLiteGlobal.journalSizeLimit & i) != 0) {
            a(null);
        }
        if ((262144 & i) != 0) {
            b(null);
        }
        AppMethodBeat.o(76773);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(76774);
        cdZ().kJ(20);
        ((j) com.tencent.mm.kernel.g.K(j.class)).XR().aoX("newsapp");
        a(20, aVar);
        AppMethodBeat.o(76774);
    }

    public static void b(a aVar) {
        AppMethodBeat.i(76775);
        cdZ().kJ(11);
        ((j) com.tencent.mm.kernel.g.K(j.class)).XR().aoX("blogapp");
        a(11, aVar);
        AppMethodBeat.o(76775);
    }

    public static void jA(long j) {
        AppMethodBeat.i(76776);
        n(cdZ().fn(j), 20);
        AppMethodBeat.o(76776);
    }

    public static void cU(String str, int i) {
        AppMethodBeat.i(76777);
        n(cdZ().Q(str, i), i);
        AppMethodBeat.o(76777);
    }

    private static void n(List<bl> list, int i) {
        AppMethodBeat.i(76778);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(76778);
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                if (i3 == 0) {
                    bo.deleteFile(com.tencent.mm.pluginsdk.model.q.v(((bl) list.get(i3)).aan(), i, "@T"));
                } else {
                    bo.deleteFile(com.tencent.mm.pluginsdk.model.q.v(((bl) list.get(i3)).aan(), i, "@S"));
                }
                i2 = i3 + 1;
            } else {
                AppMethodBeat.o(76778);
                return;
            }
        }
    }

    private static void c(final a aVar) {
        AppMethodBeat.i(76779);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(76764);
                if (aVar != null) {
                    aVar.cdW();
                }
                AppMethodBeat.o(76764);
            }
        });
        AppMethodBeat.o(76779);
    }

    private static void a(final int i, final a aVar) {
        AppMethodBeat.i(76780);
        if (com.tencent.mm.kernel.g.RK()) {
            com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                public final void run() {
                    int i = 0;
                    AppMethodBeat.i(76765);
                    b bVar = new b(c.XW());
                    if (bVar.exists() && bVar.isDirectory()) {
                        b[] dMF = bVar.dMF();
                        if (dMF == null || dMF.length <= 0) {
                            g.d(aVar);
                            AppMethodBeat.o(76765);
                            return;
                        }
                        String format = String.format("reader_%d_", new Object[]{Integer.valueOf(i)});
                        String format2 = String.format("ReaderApp_%d", new Object[]{Integer.valueOf(i)});
                        while (i < dMF.length) {
                            if (dMF[i].getName().startsWith(format)) {
                                dMF[i].delete();
                            }
                            if (dMF[i].getName().startsWith(format2)) {
                                dMF[i].delete();
                            }
                            i++;
                        }
                        g.d(aVar);
                        AppMethodBeat.o(76765);
                        return;
                    }
                    g.d(aVar);
                    AppMethodBeat.o(76765);
                }

                public final String toString() {
                    AppMethodBeat.i(76766);
                    String str = super.toString() + "|deleteAllPic";
                    AppMethodBeat.o(76766);
                    return str;
                }
            });
            AppMethodBeat.o(76780);
            return;
        }
        c(aVar);
        AppMethodBeat.o(76780);
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(76781);
        com.tencent.mm.ai.d.a.a(this.pEM);
        com.tencent.mm.kernel.g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(76767);
                if (com.tencent.mm.kernel.g.RK()) {
                    bo.o(c.XW(), "ReaderApp_", 604800000);
                    AppMethodBeat.o(76767);
                    return;
                }
                AppMethodBeat.o(76767);
            }

            public final String toString() {
                AppMethodBeat.i(76768);
                String str = super.toString() + "|onAccountPostReset";
                AppMethodBeat.o(76768);
                return str;
            }
        });
        com.tencent.mm.sdk.b.a.xxA.c(this.pEN);
        com.tencent.mm.sdk.b.a.xxA.c(this.pEO);
        com.tencent.mm.sdk.b.a.xxA.c(this.pEP);
        e eVar = e.pEK;
        AppMethodBeat.o(76781);
    }

    public final void bA(boolean z) {
    }
}
