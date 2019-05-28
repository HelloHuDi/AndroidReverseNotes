package com.tencent.p177mm.plugin.shake.p506c.p507a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.shake.p1019b.C28987m;
import com.tencent.p177mm.plugin.shake.p506c.p1411c.C28999a;
import com.tencent.p177mm.protocal.protobuf.akf;
import com.tencent.p177mm.protocal.protobuf.akg;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.shake.c.a.b */
public final class C43522b extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public C21829e qsm;

    public C43522b(float f, float f2) {
        AppMethodBeat.m2504i(24511);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new akf();
        c1196a.fsK = new akg();
        c1196a.uri = "/cgi-bin/mmbiz-bin/card/getlbscard";
        this.ehh = c1196a.acD();
        akf akf = (akf) this.ehh.fsG.fsP;
        akf.cEB = f2;
        akf.cGm = f;
        AppMethodBeat.m2505o(24511);
    }

    public final int getType() {
        return 1251;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(24512);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(24512);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(24513);
        C4990ab.m7416i("MicroMsg.NetSceneGetLbsCard", "onGYNetEnd, getType = 1251 errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            akg akg = (akg) this.ehh.fsH.fsP;
            if (akg != null) {
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (!akg.wpH) {
                    C4990ab.m7412e("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is false, no card , don't handle");
                } else if (akg.wpL <= currentTimeMillis) {
                    C4990ab.m7412e("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + akg.wpL + " is <= currentTime:" + currentTimeMillis + " , don't handle");
                } else if (TextUtils.isEmpty(akg.kbU)) {
                    C4990ab.m7412e("MicroMsg.NetSceneGetLbsCard", "getlbscard card_tp_id is empty , don't handle");
                } else {
                    C4990ab.m7416i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is true");
                    if (akg.wpI) {
                        C4990ab.m7416i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is true");
                    } else {
                        C4990ab.m7416i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is false");
                    }
                    this.qsm = new C21829e();
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
                    C28987m.cjY().qsp = this.qsm.qsu;
                    C4990ab.m7416i("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + akg.wpL + " is <= currentTime:" + currentTimeMillis);
                    C4990ab.m7416i("MicroMsg.NetSceneGetLbsCard", "getlbscard activity_type: " + akg.wpN);
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_BEGIN_TIME_INT_SYNC, Integer.valueOf(currentTimeMillis));
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_END_TIME_INT_SYNC, Integer.valueOf(akg.wpL));
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_NAME_STRING_SYNC, akg.wpO);
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ENTRANCE_TIP_STRING_SYNC, akg.wpM);
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_ACTIVITY_TYPE_INT_SYNC, Integer.valueOf(akg.wpN));
                    String ckq = C28999a.ckq();
                    C4990ab.m7416i("MicroMsg.NetSceneGetLbsCard", "getlbscard msg reddotid is " + akg.wpJ);
                    C4990ab.m7416i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre reddotid is ".concat(String.valueOf(ckq)));
                    if (TextUtils.isEmpty(akg.wpJ)) {
                        C4990ab.m7416i("MicroMsg.NetSceneGetLbsCard", "getlbscard resp.red_dot_id is empty");
                    }
                    if (TextUtils.isEmpty(ckq)) {
                        C4990ab.m7416i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre_red_dot_id is empty, resp.red_dot_id is not empty");
                        C16112c.m24429PK().mo28557y(262155, true);
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_TAB_RED_DOT_ID_STRING_SYNC, akg.wpJ);
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_TAB_RED_DOT_DESC_STRING_SYNC, akg.wpK);
                    } else if (!ckq.equals(akg.wpJ)) {
                        C4990ab.m7416i("MicroMsg.NetSceneGetLbsCard", "getlbscard redDotId and msg.reddotid is not empty, but no equals");
                        C16112c.m24429PK().mo28557y(262155, true);
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_TAB_RED_DOT_ID_STRING_SYNC, akg.wpJ);
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(C5127a.USERINFO_SHAKE_CARD_TAB_RED_DOT_DESC_STRING_SYNC, akg.wpK);
                    } else if (ckq.equals(akg.wpJ)) {
                        C4990ab.m7416i("MicroMsg.NetSceneGetLbsCard", "redDotId equals msg.reddotid");
                    }
                    C7060h.pYm.mo8374X(11721, akg.kbU);
                }
            } else {
                C4990ab.m7412e("MicroMsg.NetSceneGetLbsCard", "getlbscard resp is null");
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(24513);
    }
}
