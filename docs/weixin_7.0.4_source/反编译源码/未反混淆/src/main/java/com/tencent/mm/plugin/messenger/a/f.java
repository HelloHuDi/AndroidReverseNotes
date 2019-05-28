package com.tencent.mm.plugin.messenger.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.but;
import com.tencent.mm.protocal.protobuf.buu;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;

public final class f extends m implements k {
    public final b ehh;
    private com.tencent.mm.ai.f ehi;
    public final boolean opS;

    public f(String str) {
        this(str, 0);
    }

    public f(String str, int i) {
        this(str, i, (byte) 0);
    }

    private f(String str, int i, byte b) {
        this(str, 1, i, false);
    }

    public f(String str, int i, int i2, boolean z) {
        AppMethodBeat.i(111114);
        this.opS = z;
        a aVar = new a();
        aVar.fsJ = new buu();
        aVar.fsK = new buv();
        aVar.uri = "/cgi-bin/micromsg-bin/searchcontact";
        aVar.fsI = 106;
        aVar.fsL = 34;
        aVar.fsM = 1000000034;
        this.ehh = aVar.acD();
        ab.d("MicroMsg.NetSceneSearchContact", "search username [%s]", str);
        buu buu = (buu) this.ehh.fsG.fsP;
        buu.wcB = new bts().alV(str);
        buu.wOo = i;
        buu.wWi = i2;
        AppMethodBeat.o(111114);
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(111115);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(111115);
        return a;
    }

    public final int getType() {
        return 106;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        h hVar;
        AppMethodBeat.i(111116);
        buv buv = (buv) this.ehh.fsH.fsP;
        if (buv != null && buv.wod > 0) {
            Iterator it = buv.woe.iterator();
            while (it.hasNext()) {
                but but = (but) it.next();
                ab.d("MicroMsg.NetSceneSearchContact", "search RES username [%s]", but.wcB);
                h hVar2 = new h();
                hVar2.username = aa.a(but.wcB);
                hVar2.frW = but.vXm;
                hVar2.frV = but.vXn;
                hVar2.bJt = -1;
                ab.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", hVar2.getUsername(), hVar2.ack(), hVar2.acl());
                hVar2.dtR = 3;
                hVar2.cB(true);
                o.act().b(hVar2);
            }
        } else if (!(buv == null || bo.isNullOrNil(aa.a(buv.wcB)))) {
            String a = aa.a(buv.wcB);
            hVar = new h();
            hVar.username = a;
            hVar.frW = buv.vXm;
            hVar.frV = buv.vXn;
            hVar.bJt = -1;
            ab.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", hVar.getUsername(), hVar.ack(), hVar.acl());
            hVar.dtR = 3;
            hVar.cB(true);
            o.act().b(hVar);
        }
        if (buv != null) {
            Iterator it2 = buv.wWn.iterator();
            while (it2.hasNext()) {
                bvk bvk = (bvk) it2.next();
                hVar = new h();
                hVar.username = bvk.jBB;
                hVar.frW = bvk.vXm;
                hVar.frV = bvk.vXn;
                hVar.bJt = -1;
                ab.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", hVar.getUsername(), hVar.ack(), hVar.acl());
                hVar.dtR = 3;
                hVar.cB(true);
                o.act().b(hVar);
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(111116);
    }

    public final buv bOj() {
        AppMethodBeat.i(111117);
        buv buv = (buv) this.ehh.fsH.fsP;
        if (buv != null) {
            Iterator it = buv.woe.iterator();
            while (it.hasNext()) {
                but but = (but) it.next();
                com.tencent.mm.plugin.c.a.ask().Yn().ia(but.wcB.wVI, but.wlF);
            }
        }
        AppMethodBeat.o(111117);
        return buv;
    }
}
