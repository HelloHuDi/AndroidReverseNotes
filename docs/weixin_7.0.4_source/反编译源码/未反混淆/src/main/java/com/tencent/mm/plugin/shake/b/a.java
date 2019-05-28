package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.z;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bym;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.protocal.protobuf.uy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.LinkedList;
import java.util.List;

public final class a extends m implements k {
    private b ehh;
    private f ehi;
    private String kfM;
    List<d> qrD;
    private int qrE;
    int ret;

    public a(byte[] bArr) {
        AppMethodBeat.i(24411);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new byn();
        aVar.fsK = new byo();
        aVar.uri = "/cgi-bin/micromsg-bin/shakeget";
        aVar.fsI = ErrorCode.STARTDOWNLOAD_3;
        this.ehh = aVar.acD();
        byn byn = (byn) this.ehh.fsG.fsP;
        byn.vJd = new SKBuiltinBuffer_t().setBuffer(bArr);
        byn.wXL = 1;
        byn.vIl = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.oTO.bVS());
        AppMethodBeat.o(24411);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(24412);
        ab.d("MicroMsg.NetSceneShakeGet", "doScene");
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(24412);
        return a;
    }

    public final int getType() {
        return ErrorCode.STARTDOWNLOAD_3;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(24413);
        ab.d("MicroMsg.NetSceneShakeGet", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        byo byo = (byo) this.ehh.fsH.fsP;
        this.qrD = new LinkedList();
        this.qrE = byo.wXN;
        this.ret = byo.Ret;
        this.kfM = byo.phA;
        int i4 = byo.jBv;
        ab.d("MicroMsg.NetSceneShakeGet", "size:".concat(String.valueOf(i4)));
        aw.ZK();
        bd XM = c.XM();
        if (i4 > 0) {
            e cjS = m.cjS();
            cjS.cjI();
            ab.i("MicroMsg.NewShakeItemStorage", "delOldRecord count:".concat(String.valueOf(i4)));
            if (cjS.bSd.hY("shakeitem1", "DELETE FROM shakeitem1 WHERE shakeItemID NOT IN ( SELECT shakeItemID FROM shakeitem1 ORDER BY shakeItemID DESC LIMIT " + (100 > i4 ? 100 - i4 : 0) + " )")) {
                ab.i("MicroMsg.NewShakeItemStorage", "delOldRecord success count:".concat(String.valueOf(i4)));
                cjS.doNotify();
            }
            for (i4--; i4 >= 0; i4--) {
                boolean z;
                int i5;
                if (!r.Yz().equals(((bym) byo.wXM.get(i4)).jBB)) {
                    d qP = z.aeR().qP(((bym) byo.wXM.get(i4)).jBB);
                    qP.field_username = ((bym) byo.wXM.get(i4)).jBB;
                    qP.field_brandList = ((bym) byo.wXM.get(i4)).guX;
                    uy uyVar = ((bym) byo.wXM.get(i4)).wCa;
                    if (uyVar != null) {
                        qP.field_brandFlag = uyVar.gvb;
                        qP.field_brandInfo = uyVar.gvd;
                        qP.field_brandIconURL = uyVar.gve;
                        qP.field_extInfo = uyVar.gvc;
                    }
                    if (!z.aeR().e(qP)) {
                        z.aeR().d(qP);
                    }
                }
                d dVar = new d((bym) byo.wXM.get(i4));
                h hVar = new h();
                hVar.username = dVar.field_username;
                if (dVar.field_hasHDImg > 0) {
                    z = true;
                } else {
                    z = false;
                }
                hVar.cB(z);
                hVar.dtR = dVar.field_imgstatus;
                hVar.frW = ((bym) byo.wXM.get(i4)).vXm;
                hVar.frV = ((bym) byo.wXM.get(i4)).vXn;
                o.act().b(hVar);
                hVar.bJt = -1;
                ab.d("MicroMsg.NetSceneShakeGet", "dkhurl search %s b[%s] s[%s]", hVar.getUsername(), hVar.ack(), hVar.acl());
                if (XM.aoJ(dVar.field_username)) {
                    i5 = 1;
                } else {
                    i5 = 0;
                }
                dVar.field_reserved2 = i5;
                ad aoO = XM.aoO(dVar.field_username);
                if (aoO != null && ((int) aoO.ewQ) > 0) {
                    cjS.WC(aoO.field_username);
                    cjS.WC(aoO.field_encryptUsername);
                }
                cjS.a(dVar, false);
                aw.ZK();
                c.Yn().x(dVar.field_username, this.qrE, ((bym) byo.wXM.get(i4)).wlF);
                dVar.scene = this.qrE;
                this.qrD.add(dVar);
                ab.v("MicroMsg.NetSceneShakeGet", "item info: " + dVar.field_username + " " + dVar.field_nickname);
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(24413);
    }
}
