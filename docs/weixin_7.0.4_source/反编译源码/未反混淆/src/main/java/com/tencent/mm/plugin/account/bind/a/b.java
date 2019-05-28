package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.jq;
import com.tencent.mm.protocal.protobuf.jr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public final class b extends m implements k {
    private String cCU;
    private String cCW;
    public final com.tencent.mm.ai.b ehh;
    private f ehi;
    public long fPN;

    public b(long j, String str, String str2, String str3, String str4, int i, boolean z) {
        byte[] d;
        AppMethodBeat.i(13320);
        this.fPN = 0;
        a aVar = new a();
        aVar.fsJ = new jq();
        aVar.fsK = new jr();
        aVar.uri = "/cgi-bin/micromsg-bin/bindqq";
        aVar.fsI = 144;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.fPN = j;
        jq jqVar = (jq) this.ehh.fsG.fsP;
        jqVar.vLV = new p(j).intValue();
        jqVar.vLJ = "";
        jqVar.vLW = "";
        jqVar.vLX = "";
        jqVar.vLY = "";
        jqVar.vMa = new bts().alV("");
        jqVar.vLZ = 1;
        if (z) {
            d = g.RN().QR().d(j, str3);
        } else {
            d = g.RN().QR().a(j, bo.ane(str), true);
        }
        jqVar.vJT = new SKBuiltinBuffer_t().setBuffer(d);
        jqVar.vMb = new SKBuiltinBuffer_t().setBuffer(bo.anf(bo.nullAsNil((String) g.RP().Ry().get(47, null))));
        ab.i("MicroMsg.NetSceneBindQQ", "init opcode:%d qq:%d  wtbuf:%d img[%s,%s,%s] ksid:%s", Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(bo.cc(d)), str3, str2, str4, r1);
        AppMethodBeat.o(13320);
    }

    public b(long j, String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        this(j, str, str2, str3, str4, 1, z);
        AppMethodBeat.i(13321);
        this.cCU = str5;
        this.cCW = str6;
        jq jqVar = (jq) this.ehh.fsG.fsP;
        jqVar.vLx = str5;
        jqVar.vLy = str6;
        AppMethodBeat.o(13321);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(13322);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(13322);
        return a;
    }

    public final int getType() {
        return 144;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        boolean z;
        AppMethodBeat.i(13323);
        jq jqVar = (jq) this.ehh.fsG.fsP;
        jr jrVar = (jr) this.ehh.fsH.fsP;
        byte[] a = aa.a(jrVar.vHJ);
        if (bo.cb(a)) {
            z = false;
        } else {
            z = g.RN().QR().a(new p(jqVar.vLV).longValue(), a);
        }
        ab.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd[%d,%d] wtret:%b wtRespBuf:%d imgsid:%s", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(bo.cc(a)), jrVar.vLX);
        if (i2 == 0 && i3 == 0) {
            int i4 = g.RP().Ry().getInt(9, 0);
            g.RP().Ry().set(9, Integer.valueOf(jqVar.vLV));
            if (i4 != 0) {
                if (g.RP().Ry().get(ac.a.USERINFO_LAST_LOGIN_USERNAME_STRING, (Object) "").equals(String.valueOf(i4))) {
                    g.RP().Ry().set(ac.a.USERINFO_LAST_LOGIN_USERNAME_STRING, r.Yz());
                }
                for (String str2 : bx.fnB.aat()) {
                    if (String.valueOf(i4).equals(bx.fnB.getString(str2, "login_user_name"))) {
                        bx.fnB.n(str2, "login_user_name", str2);
                    }
                }
            }
            if (jqVar.vLZ == 1) {
                g.RP().Ry().set(17, Integer.valueOf(jrVar.vCo));
            }
            ((j) g.K(j.class)).XU().aT(jrVar.vMe, jrVar.vMd == 1);
            i4 = jqVar.vLV;
            if (i4 != 0) {
                ((j) g.K(j.class)).XU().cE(new p(i4) + "@qqim", 3);
            }
            com.tencent.mm.ah.b.d((long) i4, 3);
            g.RP().Ry().set(32, jqVar.vLJ);
            g.RP().Ry().set(33, jqVar.vLW);
            ab.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd wtret:%b newa2key:%s ", Boolean.valueOf(z), bo.anv(bo.cd(g.RN().QR().ft(new p(jqVar.vLV).longValue()))));
            g.RP().Ry().set(72, r2);
            g.RP().Ry().set(46, bo.cd(aa.a(jrVar.vHP)));
            Object cd = bo.cd(aa.a(jqVar.vMb));
            g.RP().Ry().set(47, cd);
            g.RP().eJH.set(18, cd);
            g.RP().Ry().set(-1535680990, jrVar.vMf);
        } else if (i2 == 4) {
            g.RP().Ry().set(32, (Object) "");
            g.RP().Ry().set(33, (Object) "");
        }
        if (jqVar.vLZ == 3 && i3 == -3) {
            i3 = Downloads.MIN_WAIT_FOR_NETWORK;
            ab.d("MicroMsg.NetSceneBindQQ", "onGYNetEnd : retCode = 10000");
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(13323);
    }
}
