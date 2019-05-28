package com.tencent.mm.plugin.multitalk.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.b;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.multitalk.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.HashMap;
import java.util.Map;

public class p implements at {
    private static HashMap<Integer, d> eaA;
    private com.tencent.mm.model.cc.a mBB = new com.tencent.mm.model.cc.a() {
        public final boolean aaG() {
            AppMethodBeat.i(54088);
            ab.w("MicroMsg.SubCoreMultiTalk", "HERE UninitForUEH is called! multitalk");
            if (p.this.oHx != null) {
                p.this.oHx.bGT();
                if (p.this.oHx.oGh != null) {
                    ab.i("MicroMsg.SubCoreMultiTalk", "dump multiTalkGroup: %s", j.h(p.this.oHx.oGh));
                }
            }
            AppMethodBeat.o(54088);
            return true;
        }
    };
    private a oHA;
    private h oHB;
    private com.tencent.mm.plugin.multitalk.a.a oHC;
    private c oHD;
    private g oHE;
    private d oHw;
    private f oHx;
    private m oHy;
    private i oHz;

    class a implements com.tencent.mm.model.bz.a {
        a() {
        }

        public final void a(com.tencent.mm.ai.e.a aVar) {
            AppMethodBeat.i(54089);
            g bSi = p.bSi();
            String a = aa.a(aVar.eAB.vED);
            Map z = br.z(a, "sysmsg");
            if (((String) z.get(".sysmsg.multivoip.notfriendnotifydata")) != null) {
                ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive notfriendnotifydata msg:".concat(String.valueOf(a)));
                AppMethodBeat.o(54089);
                return;
            }
            String str = (String) z.get(".sysmsg.multivoip.notifydata");
            if (str != null) {
                byte[] decode = Base64.decode(bo.bc(str, "").getBytes(), 0);
                ab.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive " + aa.a(aVar.eAB.vED) + " buffer len " + decode.length);
                p.bSe().oFP.bR(bo.h((Integer) g.RP().eJH.get(1)), r.Yz());
                p.bSe().oFP.ck(decode);
                AppMethodBeat.o(54089);
                return;
            }
            str = (String) z.get(".sysmsg.multivoip.banner");
            if (str != null) {
                bSi.a(str, aVar);
            }
            AppMethodBeat.o(54089);
        }
    }

    public p() {
        AppMethodBeat.i(54090);
        AppMethodBeat.o(54090);
    }

    static {
        AppMethodBeat.i(54102);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("MULTITALKINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.multitalk.a.a.fnj;
            }
        });
        eaA.put(Integer.valueOf("MULTITALKMEMBER_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return c.fnj;
            }
        });
        AppMethodBeat.o(54102);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    private static p bSa() {
        AppMethodBeat.i(54091);
        p pVar = (p) q.Y(p.class);
        AppMethodBeat.o(54091);
        return pVar;
    }

    public static com.tencent.mm.plugin.multitalk.a.a bSb() {
        AppMethodBeat.i(54092);
        g.RN();
        if (com.tencent.mm.kernel.a.QF() == 0) {
            b bVar = new b();
            AppMethodBeat.o(54092);
            throw bVar;
        }
        if (bSa().oHC == null) {
            bSa().oHC = new com.tencent.mm.plugin.multitalk.a.a(g.RP().eJN);
        }
        com.tencent.mm.plugin.multitalk.a.a aVar = bSa().oHC;
        AppMethodBeat.o(54092);
        return aVar;
    }

    public static c bSc() {
        AppMethodBeat.i(54093);
        g.RN();
        if (com.tencent.mm.kernel.a.QF() == 0) {
            b bVar = new b();
            AppMethodBeat.o(54093);
            throw bVar;
        }
        if (bSa().oHD == null) {
            bSa().oHD = new c(g.RP().eJN);
        }
        c cVar = bSa().oHD;
        AppMethodBeat.o(54093);
        return cVar;
    }

    public static i bSd() {
        AppMethodBeat.i(54094);
        g.RN().QU();
        if (bSa().oHz == null) {
            bSa().oHz = new i();
        }
        i iVar = bSa().oHz;
        AppMethodBeat.o(54094);
        return iVar;
    }

    public static d bSe() {
        AppMethodBeat.i(54095);
        g.RN().QU();
        if (bSa().oHw == null) {
            bSa().oHw = new d();
        }
        d dVar = bSa().oHw;
        AppMethodBeat.o(54095);
        return dVar;
    }

    public static f bSf() {
        AppMethodBeat.i(54096);
        g.RN().QU();
        if (bSa().oHx == null) {
            bSa().oHx = new f();
        }
        f fVar = bSa().oHx;
        AppMethodBeat.o(54096);
        return fVar;
    }

    public static m bSg() {
        AppMethodBeat.i(54097);
        g.RN().QU();
        if (bSa().oHy == null) {
            bSa().oHy = new m();
        }
        m mVar = bSa().oHy;
        AppMethodBeat.o(54097);
        return mVar;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(54098);
        this.oHw = new d();
        this.oHA = new a();
        ((com.tencent.mm.plugin.messenger.foundation.a.p) g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("multivoip", this.oHA, true);
        g.RR().a(this.mBB);
        g.a(a.class, bSh());
        bSh().bRT();
        AppMethodBeat.o(54098);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(54099);
        if (this.oHw != null) {
            f fVar = this.oHw;
            g.Rg().b(1918, fVar);
            g.Rg().b(1919, fVar);
            g.Rg().b(1927, fVar);
            g.Rg().b(1928, fVar);
            g.Rg().b(1929, fVar);
            g.Rg().b(1931, fVar);
            g.Rg().b(1932, fVar);
            g.Rg().b(1933, fVar);
            g.Rg().b(1935, fVar);
            g.Rg().b(1937, fVar);
            g.Rg().b(1938, fVar);
            g.Rg().b(1939, fVar);
            this.oHw = null;
        }
        if (this.oHx != null) {
            f fVar2 = this.oHx;
            ah.getContext().unregisterReceiver(fVar2.oGz);
            com.tencent.mm.sdk.b.a.xxA.d(fVar2.oGA);
            fVar2.h(false, false, false);
            this.oHx = null;
        }
        if (this.oHy != null) {
            this.oHy.bRZ();
            this.oHy = null;
        }
        if (this.oHz != null) {
            this.oHz.reset();
            this.oHz = null;
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.p) g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("multivoip", this.oHA, true);
        g.RR().b(this.mBB);
        g.L(a.class);
        AppMethodBeat.o(54099);
    }

    public static h bSh() {
        AppMethodBeat.i(54100);
        if (bSa().oHB == null) {
            bSa().oHB = new h();
        }
        h hVar = bSa().oHB;
        AppMethodBeat.o(54100);
        return hVar;
    }

    public static g bSi() {
        AppMethodBeat.i(54101);
        if (bSa().oHE == null) {
            bSa().oHE = new g();
        }
        g gVar = bSa().oHE;
        AppMethodBeat.o(54101);
        return gVar;
    }
}
