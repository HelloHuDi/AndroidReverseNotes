package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.t.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class j implements at {
    private static HashMap<Integer, d> jZD;
    private c jOJ = new c<k>() {
        {
            AppMethodBeat.i(72806);
            this.xxI = k.class.getName().hashCode();
            AppMethodBeat.o(72806);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(72807);
            if (((k) bVar).csh.csi && !g.RN().QY()) {
                ab.i("MicroMsg.SubCoreReport", "mOnForegroundListener: account not ready");
            }
            AppMethodBeat.o(72807);
            return false;
        }
    };
    private a jZF;
    public boolean pWV = false;
    public HashMap<String, List<d>> pYD;
    public HashMap<String, String> pYE;

    static {
        AppMethodBeat.i(72814);
        HashMap hashMap = new HashMap();
        jZD = hashMap;
        hashMap.put(Integer.valueOf("DUPLICATEKVLOG_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.report.a.b.fnj;
            }
        });
        AppMethodBeat.o(72814);
    }

    public j() {
        AppMethodBeat.i(72808);
        AppMethodBeat.o(72808);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(72809);
        if (cgu() != null) {
            j cgu = cgu();
            if (cgu.jZF != null) {
                cgu.jZF.mJ(cgu.hashCode());
                cgu.jZF = null;
            }
        }
        com.tencent.mm.sdk.b.a.xxA.d(this.jOJ);
        if (this.pYD != null) {
            this.pYD.clear();
        }
        if (this.pYE != null) {
            this.pYE.clear();
        }
        AppMethodBeat.o(72809);
    }

    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(72810);
        long currentTimeMillis = System.currentTimeMillis();
        this.jZF = t.a(hashCode(), g.RP().cachePath + "CommonOneMicroMsg.db", jZD, false);
        ab.i("MicroMsg.SubCoreReport", "summeranrt onAccountPostReset tid[%d] [%d]ms, stack[%s]", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), bo.dpG());
        com.tencent.mm.sdk.b.a.xxA.c(this.jOJ);
        this.pYD = new HashMap();
        this.pYE = new HashMap();
        g.RQ();
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(72804);
                if (g.RK()) {
                    bo.o(g.RP().cachePath + "logcat/", "temp_", 10800000);
                    AppMethodBeat.o(72804);
                    return;
                }
                AppMethodBeat.o(72804);
            }

            public final String toString() {
                AppMethodBeat.i(72805);
                String str = super.toString() + "|onAccountPostReset";
                AppMethodBeat.o(72805);
                return str;
            }
        });
        AppMethodBeat.o(72810);
    }

    public final void bA(boolean z) {
    }

    public static j cgu() {
        AppMethodBeat.i(72811);
        j jVar = (j) q.Y(j.class);
        AppMethodBeat.o(72811);
        return jVar;
    }

    public final void t(long j, String str) {
        AppMethodBeat.i(72812);
        if (this.pWV && this.pYD != null) {
            boolean z;
            List linkedList;
            ab.v("MicroMsg.SubCoreReport", "put kv info [%d %s]", Long.valueOf(j), str);
            List list = (List) this.pYD.get(String.valueOf(j));
            if (list == null) {
                z = false;
                linkedList = new LinkedList();
            } else {
                d dVar = (d) list.get(list.size() - 1);
                if (bo.gb(dVar.pXQ) < 1000) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    dVar.pXS = true;
                }
                linkedList = list;
            }
            linkedList.add(0, new d(j, str, bo.anU(), z));
            this.pYD.put(String.valueOf(j), linkedList);
        }
        AppMethodBeat.o(72812);
    }

    public final void aa(String str, String str2, String str3) {
        AppMethodBeat.i(72813);
        if (this.pWV && this.pYE != null) {
            ab.v("MicroMsg.SubCoreReport", "put kv info [%s %s %s]", str, str2, str3);
            this.pYE.put(ag.ck(str), str2 + str3);
        }
        AppMethodBeat.o(72813);
    }
}
