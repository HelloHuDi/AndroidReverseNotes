package com.tencent.mm.ah;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.i.c;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public class o implements at {
    private static HashMap<Integer, d> eaA;
    private i fsp;
    private d fsq;
    private c fsr;
    private g fss;
    private ap fst = new ap(g.RS().oAl.getLooper(), new a() {
        public final boolean BI() {
            AppMethodBeat.i(77954);
            if (!g.RN().QY() || o.acd() == null) {
                ab.w("MicroMsg.SubCoreAvatar", "upAssetsHandler onTimerExpired acc:%b astg:%s ", Boolean.valueOf(g.RN().QY()), o.acd());
                AppMethodBeat.o(77954);
            } else {
                if (((Boolean) g.RP().Ry().get(90113, Boolean.FALSE)).booleanValue()) {
                    o.acx();
                    o.acw();
                }
                g.RP().Ry().set(90113, Boolean.FALSE);
                AppMethodBeat.o(77954);
            }
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(77955);
            String str = super.toString() + "|upAssetsHandler";
            AppMethodBeat.o(77955);
            return str;
        }
    }, false);

    public static o acs() {
        AppMethodBeat.i(77956);
        o oVar = (o) q.Y(o.class);
        AppMethodBeat.o(77956);
        return oVar;
    }

    public o() {
        AppMethodBeat.i(77957);
        AppMethodBeat.o(77957);
    }

    public static i act() {
        AppMethodBeat.i(77958);
        g.RN().QU();
        if (acs().fsp == null) {
            acs().fsp = new i(g.RP().eJN);
        }
        i iVar = acs().fsp;
        AppMethodBeat.o(77958);
        return iVar;
    }

    public static d acd() {
        AppMethodBeat.i(77959);
        g.RN().QU();
        if (acs().fsq == null) {
            acs().fsq = new d();
        }
        d dVar = acs().fsq;
        AppMethodBeat.o(77959);
        return dVar;
    }

    public static g acu() {
        AppMethodBeat.i(77960);
        g.RN().QU();
        if (acs().fss == null) {
            acs().fss = new g(g.RP().eJN);
        }
        g gVar = acs().fss;
        AppMethodBeat.o(77960);
        return gVar;
    }

    public static c acv() {
        AppMethodBeat.i(77961);
        g.RN().QU();
        if (acs().fsr == null) {
            acs().fsr = new c();
        }
        c cVar = acs().fsr;
        AppMethodBeat.o(77961);
        return cVar;
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(77962);
        this.fst.stopTimer();
        if (acs().fsq != null) {
            d.reset();
        }
        f fVar = acs().fsr;
        if (fVar != null) {
            g.Rg().b(123, fVar);
        }
        i iVar = acs().fsp;
        if (iVar != null) {
            iVar.frZ.clear();
        }
        b.N("//avatar");
        AppMethodBeat.o(77962);
    }

    public final void iy(int i) {
    }

    static {
        AppMethodBeat.i(77967);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("IMG_FLAG_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return i.fnj;
            }
        });
        eaA.put(Integer.valueOf("HDHEADIMGINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return g.fnj;
            }
        });
        AppMethodBeat.o(77967);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(77963);
        if (z) {
            ab.d("MicroMsg.SubCoreAvatar", "update all plugin avatars");
            g.RP().Ry().set(90113, Boolean.TRUE);
            try {
                String Yz = r.Yz();
                d acd = acd();
                d.E(Yz, false);
                d.E(Yz, true);
                acd.e(Yz, null);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.SubCoreAvatar", e, "Failed to refresh avatar.", new Object[0]);
            }
        }
        this.fst.ae(10000, 10000);
        b.a(new com.tencent.mm.plugin.avatar.a(), "//avatar");
        AppMethodBeat.o(77963);
    }

    static Context getContext() {
        AppMethodBeat.i(77964);
        Context context = ah.getContext();
        AppMethodBeat.o(77964);
        return context;
    }

    public final void bA(boolean z) {
    }

    public static boolean acw() {
        AppMethodBeat.i(77965);
        if (bo.a((Boolean) g.RP().Ry().get(59, null), false)) {
            AppMethodBeat.o(77965);
            return true;
        }
        acd();
        if (d.qe(r.Yz())) {
            AppMethodBeat.o(77965);
            return true;
        }
        String Yz = r.Yz();
        if (bo.isNullOrNil(Yz)) {
            AppMethodBeat.o(77965);
            return false;
        }
        Bitmap ql = d.b.ql(c.XW() + "user_" + com.tencent.mm.a.g.x(Yz.getBytes()) + ".png");
        if (ql == null || ql.isRecycled()) {
            AppMethodBeat.o(77965);
            return false;
        }
        boolean f = acd().f(Yz, ql);
        AppMethodBeat.o(77965);
        return f;
    }

    static /* synthetic */ void acx() {
        AppMethodBeat.i(77966);
        try {
            Context context = ah.getContext();
            for (String str : d.frx.keySet()) {
                int intValue;
                if (d.frx.containsKey(str)) {
                    intValue = ((Integer) d.frx.get(str)).intValue();
                } else {
                    intValue = 0;
                }
                if (intValue != 0) {
                    ab.d("MicroMsg.SubCoreAvatar", "updateAssetsAvatar user:%s ", str);
                    acd().f(str, com.tencent.mm.compatible.g.a.decodeResource(context.getResources(), intValue));
                }
            }
            AppMethodBeat.o(77966);
        } catch (Exception e) {
            ab.e("MicroMsg.SubCoreAvatar", "exception:%s", bo.l(e));
            AppMethodBeat.o(77966);
        }
    }
}
