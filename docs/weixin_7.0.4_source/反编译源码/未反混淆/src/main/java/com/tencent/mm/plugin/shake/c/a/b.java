package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.akg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;

public final class b extends m implements k {
    private final com.tencent.mm.ai.b ehh;
    private f ehi;
    public e qsm;

    public b(float f, float f2) {
        AppMethodBeat.i(24511);
        a aVar = new a();
        aVar.fsJ = new akf();
        aVar.fsK = new akg();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/getlbscard";
        this.ehh = aVar.acD();
        akf akf = (akf) this.ehh.fsG.fsP;
        akf.cEB = f2;
        akf.cGm = f;
        AppMethodBeat.o(24511);
    }

    public final int getType() {
        return 1251;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(24512);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(24512);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(24513);
        ab.i("MicroMsg.NetSceneGetLbsCard", "onGYNetEnd, getType = 1251 errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            akg akg = (akg) this.ehh.fsH.fsP;
            if (akg != null) {
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (!akg.wpH) {
                    ab.e("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is false, no card , don't handle");
                } else if (akg.wpL <= currentTimeMillis) {
                    ab.e("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + akg.wpL + " is <= currentTime:" + currentTimeMillis + " , don't handle");
                } else if (TextUtils.isEmpty(akg.kbU)) {
                    ab.e("MicroMsg.NetSceneGetLbsCard", "getlbscard card_tp_id is empty , don't handle");
                } else {
                    ab.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is true");
                    if (akg.wpI) {
                        ab.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is true");
                    } else {
                        ab.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is false");
                    }
                    this.qsm = new e();
                    this.qsm.kdC = 1;
                    this.qsm.kbU = akg.kbU;
                    this.qsm.cMD = akg.cMD;
                    this.qsm.title = akg.title;
                    this.qsm.kbW = akg.kbW;
                    this.qsm.kbX = akg.kbX;
                    this.qsm.kdg = akg.kdg;
                    this.qsm.kbV = akg.kbV;
                    this.qsm.color = akg.color;
                    this.qsm.qsn = 0;
                    this.qsm.qsq = akg.qsq;
                    this.qsm.qsr = akg.qsr;
                    this.qsm.qss = akg.qss;
                    this.qsm.qst = akg.qst;
                    this.qsm.qsu = "";
                    this.qsm.kbZ = akg.kbZ;
                    this.qsm.qsv = akg.qsv;
                    this.qsm.qsw = akg.qsw;
                    com.tencent.mm.plugin.shake.b.m.cjY().qsp = this.qsm.qsu;
                    ab.i("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + akg.wpL + " is <= currentTime:" + currentTimeMillis);
                    ab.i("MicroMsg.NetSceneGetLbsCard", "getlbscard activity_type: " + akg.wpN);
                    aw.ZK();
                    c.Ry().set(ac.a.USERINFO_SHAKE_CARD_ENTRANCE_BEGIN_TIME_INT_SYNC, Integer.valueOf(currentTimeMillis));
                    aw.ZK();
                    c.Ry().set(ac.a.USERINFO_SHAKE_CARD_ENTRANCE_END_TIME_INT_SYNC, Integer.valueOf(akg.wpL));
                    aw.ZK();
                    c.Ry().set(ac.a.USERINFO_SHAKE_CARD_ENTRANCE_NAME_STRING_SYNC, akg.wpO);
                    aw.ZK();
                    c.Ry().set(ac.a.USERINFO_SHAKE_CARD_ENTRANCE_TIP_STRING_SYNC, akg.wpM);
                    aw.ZK();
                    c.Ry().set(ac.a.USERINFO_SHAKE_CARD_ACTIVITY_TYPE_INT_SYNC, Integer.valueOf(akg.wpN));
                    String ckq = com.tencent.mm.plugin.shake.c.c.a.ckq();
                    ab.i("MicroMsg.NetSceneGetLbsCard", "getlbscard msg reddotid is " + akg.wpJ);
                    ab.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre reddotid is ".concat(String.valueOf(ckq)));
                    if (TextUtils.isEmpty(akg.wpJ)) {
                        ab.i("MicroMsg.NetSceneGetLbsCard", "getlbscard resp.red_dot_id is empty");
                    }
                    if (TextUtils.isEmpty(ckq)) {
                        ab.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre_red_dot_id is empty, resp.red_dot_id is not empty");
                        com.tencent.mm.x.c.PK().y(262155, true);
                        aw.ZK();
                        c.Ry().set(ac.a.USERINFO_SHAKE_CARD_TAB_RED_DOT_ID_STRING_SYNC, akg.wpJ);
                        aw.ZK();
                        c.Ry().set(ac.a.USERINFO_SHAKE_CARD_TAB_RED_DOT_DESC_STRING_SYNC, akg.wpK);
                    } else if (!ckq.equals(akg.wpJ)) {
                        ab.i("MicroMsg.NetSceneGetLbsCard", "getlbscard redDotId and msg.reddotid is not empty, but no equals");
                        com.tencent.mm.x.c.PK().y(262155, true);
                        aw.ZK();
                        c.Ry().set(ac.a.USERINFO_SHAKE_CARD_TAB_RED_DOT_ID_STRING_SYNC, akg.wpJ);
                        aw.ZK();
                        c.Ry().set(ac.a.USERINFO_SHAKE_CARD_TAB_RED_DOT_DESC_STRING_SYNC, akg.wpK);
                    } else if (ckq.equals(akg.wpJ)) {
                        ab.i("MicroMsg.NetSceneGetLbsCard", "redDotId equals msg.reddotid");
                    }
                    h.pYm.X(11721, akg.kbU);
                }
            } else {
                ab.e("MicroMsg.NetSceneGetLbsCard", "getlbscard resp is null");
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(24513);
    }
}
