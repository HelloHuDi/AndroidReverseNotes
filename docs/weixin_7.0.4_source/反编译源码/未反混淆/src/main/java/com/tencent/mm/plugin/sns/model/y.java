package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.rw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.bp;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.ccg;
import com.tencent.mm.protocal.protobuf.cch;
import com.tencent.mm.protocal.protobuf.cy;
import com.tencent.mm.protocal.protobuf.vd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public final class y extends m implements k, d {
    private static Vector<String> qIZ = new Vector();
    public int afg = 0;
    final int cvp;
    private b ehh;
    public f ehi;
    private boolean fNO = false;
    public boolean qIW;
    private long qIX = 0;
    long qIY = 0;
    private String qJA = "";
    private long qJR = 0;
    private boolean qJS = false;
    private boolean qJT = false;
    public int qJa = 0;
    public int qJb = 0;
    private long qJz = 0;

    static {
        AppMethodBeat.i(36344);
        AppMethodBeat.o(36344);
    }

    public static synchronized boolean XO(String str) {
        boolean z;
        synchronized (y.class) {
            AppMethodBeat.i(36336);
            if (qIZ.contains(str)) {
                z = false;
                AppMethodBeat.o(36336);
            } else {
                qIZ.add(str);
                z = true;
                AppMethodBeat.o(36336);
            }
        }
        return z;
    }

    public static synchronized boolean XP(String str) {
        synchronized (y.class) {
            AppMethodBeat.i(36337);
            qIZ.remove(str);
            AppMethodBeat.o(36337);
        }
        return true;
    }

    public y(long j) {
        int i;
        long j2;
        AppMethodBeat.i(36338);
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = new a();
        aVar.fsJ = new ccg();
        aVar.fsK = new cch();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstimeline";
        aVar.fsI = 211;
        aVar.fsL = 98;
        aVar.fsM = 1000000098;
        this.ehh = aVar.acD();
        if (at.isWifi(ah.getContext())) {
            i = 1;
        } else if (at.is3G(ah.getContext())) {
            i = 3;
        } else if (at.is4G(ah.getContext())) {
            i = 4;
        } else if (at.is2G(ah.getContext())) {
            i = 2;
        } else {
            i = 0;
        }
        this.qIX = j;
        this.qIW = j == 0;
        this.cvp = 2;
        ccg ccg = (ccg) this.ehh.fsG.fsP;
        ccg.wZy = i;
        ccg.wZU = j;
        int cod = af.cnv().cod();
        o cnF = af.cnF();
        if (this.qIW) {
            j2 = 0;
        } else {
            j2 = j;
        }
        this.qIY = cnF.g(j2, cod, true);
        ccg.xbw = this.qIY;
        ccg.xbx = c.a(this.qIY, j, "@__weixintimtline");
        if (this.qIW) {
            this.qJz = af.cnF().g(0, 1, true);
            ab.i("MicroMsg.NetSceneSnsTimeLine", "newerid " + this.qJz);
            ccg.xby = this.qJz;
            l YX = af.cnJ().YX("@__weixintimtline");
            this.qJA = YX == null ? "" : YX.field_md5;
            if (this.qJA == null) {
                this.qJA = "";
            }
            ccg.wZT = this.qJA;
            if (YX == null || YX.field_adsession == null) {
                ccg.wZw = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
            } else {
                ab.d("MicroMsg.NetSceneSnsTimeLine", "request adsession %s", YX.field_adsession);
                ccg.wZw = new SKBuiltinBuffer_t().setBuffer(YX.field_adsession);
            }
        }
        this.qJR = j;
        ab.i("MicroMsg.NetSceneSnsTimeLine", " This req nextCount: " + cod + " max:" + j + " min:" + this.qIY + " ReqTime:" + ccg.xbx + " nettype: " + i);
        ab.d("MicroMsg.NetSceneSnsTimeLine", "maxId: %s minId: %s lastReqTime: %s", i.jV(j), i.jV(this.qIY), Integer.valueOf(r3));
        ab.d("MicroMsg.NetSceneSnsTimeLine", "NetSceneSnsTimeLine %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(36338);
    }

    private void cnc() {
        AppMethodBeat.i(36339);
        o cnF = af.cnF();
        Cursor a = cnF.bSd.a(o.crn(), null, 2);
        int i = 0;
        while (a.moveToNext()) {
            i++;
        }
        a.close();
        if (i >= 3 || i <= 0) {
            if (i == 0) {
                this.qJS = true;
            }
            AppMethodBeat.o(36339);
            return;
        }
        this.qJT = true;
        AppMethodBeat.o(36339);
    }

    private void a(cch cch, String str) {
        AppMethodBeat.i(36340);
        aj.a("@__weixintimtline", this.cvp, cch.vKB, str);
        this.qIY = ((cbf) cch.vKB.getLast()).vQE;
        if (this.qIX == 0) {
            this.qIX = ((cbf) cch.vKB.getFirst()).vQE;
        } else {
            this.qIX = c.ka(this.qIX);
        }
        c.f("@__weixintimtline", this.qIX, this.qIY, cch.xbC);
        try {
            Iterator it = cch.vKB.iterator();
            while (it.hasNext()) {
                cbf cbf = (cbf) it.next();
                if (cbf.xax == 0) {
                    n kD = af.cnF().kD(cbf.vQE);
                    if (!(kD == null || kD.cqu() == null || kD.field_type != 15)) {
                        try {
                            String str2 = ((bau) kD.cqu().xfI.wbK.get(0)).Url;
                            h.pYm.e(14388, Long.valueOf(cbf.vQE), Integer.valueOf(4), str2, Integer.valueOf(0));
                        } catch (Exception e) {
                        }
                    }
                }
            }
            AppMethodBeat.o(36340);
        } catch (Exception e2) {
            AppMethodBeat.o(36340);
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(36341);
        ab.i("MicroMsg.NetSceneSnsTimeLine", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        cch cch = (cch) ((b) qVar).fsH.fsP;
        if (qVar.ZS().vyl == 207 || qVar.ZS().vyl == 0) {
            int i4;
            int i5;
            if (cch.wZZ != null) {
                ab.i("MicroMsg.NetSceneSnsTimeLine", "serverConfig  " + cch.wZZ.xbs + " " + cch.wZZ.xbr);
                i4 = cch.wZZ.xbs;
                com.tencent.mm.plugin.sns.c.a.qFE = i4;
                if (i4 <= 0) {
                    com.tencent.mm.plugin.sns.c.a.qFE = BaseClientBuilder.API_PRIORITY_OTHER;
                }
                com.tencent.mm.storage.ab.xID = cch.wZZ.xbr;
            }
            this.qJa = cch.wZX;
            this.qJb = cch.wZY;
            ab.i("MicroMsg.NetSceneSnsTimeLine", "for same md5 count: " + cch.wZX + " , objCount:  " + cch.wGG + " cflag : " + cch.wZY);
            this.afg = cch.wGG;
            String jW = i.jW(this.qIX);
            if (cch.vKB.isEmpty()) {
                ab.i("MicroMsg.NetSceneSnsTimeLine", " respone is Empty");
            } else {
                ab.i("MicroMsg.NetSceneSnsTimeLine", "respone size " + cch.vKB.size() + " Max " + ((cbf) cch.vKB.getFirst()).vQE + " " + i.jV(((cbf) cch.vKB.getFirst()).vQE) + "  respone min  " + ((cbf) cch.vKB.getLast()).vQE + " " + i.jV(((cbf) cch.vKB.getLast()).vQE));
            }
            if (cch.xbH > 0) {
                ab.i("MicroMsg.NetSceneSnsTimeLine", "%d ads to delete", Integer.valueOf(cch.xbH));
                if (cch.xbI != null && cch.xbI.size() == cch.xbH) {
                    LinkedList linkedList = new LinkedList();
                    i4 = 0;
                    while (true) {
                        i5 = i4;
                        if (i5 >= cch.xbH) {
                            break;
                        }
                        long j = ((vd) cch.xbI.get(i5)).vQE;
                        ab.i("MicroMsg.NetSceneSnsTimeLine", "delete ad %s", Long.valueOf(j));
                        if (j != 0) {
                            e ku = af.cnI().ku(j);
                            if (ku == null) {
                                ab.i("MicroMsg.NetSceneSnsTimeLine", "adSnsInfo is null!");
                            } else {
                                bp bpVar = new bp();
                                bpVar.vDS = 13298;
                                bpVar.vDT = new com.tencent.mm.bt.b(ku.cqq().qPj.getBytes());
                                bpVar.vDU = System.currentTimeMillis() / 1000;
                                linkedList.add(bpVar);
                                a.jX(j);
                            }
                        }
                        i4 = i5 + 1;
                    }
                    if (linkedList.size() > 0) {
                        g.RQ();
                        g.RO().eJo.a(new l(linkedList), 0);
                    }
                }
            }
            if (this.qJA.equals(cch.wZT)) {
                this.qIY = af.cnF().g(this.qIW ? 0 : this.qJR, this.qJa, true);
                ab.i("MicroMsg.NetSceneSnsTimeLine", "md5 is no change!! the new minid %s", Long.valueOf(this.qIY));
                cnc();
                XP("@__weixintimtline");
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(36341);
                return;
            }
            cy cyVar;
            String str2;
            String a;
            af.cnJ().h("@__weixintimtline", cch.wZT, aa.a(cch.wZw));
            ab.i("MicroMsg.NetSceneSnsTimeLine", "resp list size " + cch.vKB.size() + " adsize : " + cch.xbD);
            i4 = 0;
            while (true) {
                i5 = i4;
                if (i5 >= cch.xbE.size()) {
                    break;
                }
                cyVar = (cy) cch.xbE.get(i5);
                if (this.fNO) {
                    str2 = af.getAccPath() + "ad.proto";
                    try {
                        byte[] toByteArray = cyVar.toByteArray();
                        com.tencent.mm.vfs.e.b(str2, toByteArray, toByteArray.length);
                    } catch (Exception e) {
                        ab.e("MicroMsg.NetSceneSnsTimeLine", "save error " + e.getMessage());
                    }
                }
                str2 = aa.a(cyVar.vEY);
                a = aa.a(cyVar.vEX.wZv);
                String b = aa.b(cyVar.vEX.wZu.xam);
                ab.i("MicroMsg.NetSceneSnsTimeLine", "skXml ".concat(String.valueOf(str2)));
                ab.i("MicroMsg.NetSceneSnsTimeLine", "adXml ".concat(String.valueOf(a)));
                ab.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + b + IOUtils.LINE_SEPARATOR_WINDOWS);
                String str3 = cyVar.vEX.wZu.vHl;
                if (!bo.isNullOrNil(str3)) {
                    ao.a.flu.ai(str3, "");
                    com.tencent.mm.ah.o.acv().qa(str3);
                }
                i4 = i5 + 1;
            }
            if (this.fNO && cch.xbE.size() == 0) {
                try {
                    byte[] e2 = com.tencent.mm.vfs.e.e(af.getAccPath() + "ad.proto", 0, -1);
                    cy cyVar2 = new cy();
                    cyVar2.parseFrom(e2);
                    cch.xbE.add(cyVar2);
                    cch.xbD = cch.xbE.size();
                    ab.d("MicroMsg.NetSceneSnsTimeLine", "read from path " + cch.xbD);
                    if (cch.xbE.size() > 0) {
                        cyVar = (cy) cch.xbE.get(0);
                        String a2 = aa.a(cyVar.vEY);
                        str2 = aa.a(cyVar.vEX.wZv);
                        a = aa.b(cyVar.vEX.wZu.xam);
                        ab.i("MicroMsg.NetSceneSnsTimeLine", "skXml ".concat(String.valueOf(a2)));
                        ab.i("MicroMsg.NetSceneSnsTimeLine", "adXml ".concat(String.valueOf(str2)));
                        ab.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + a + IOUtils.LINE_SEPARATOR_WINDOWS);
                        c(cyVar);
                    }
                } catch (Exception e3) {
                    ab.e("MicroMsg.NetSceneSnsTimeLine", "read error " + e3.getMessage());
                }
            }
            a.k(cch.xbE, cch.vKB);
            a.ao(cch.xbE);
            if (cch.xbD == 0) {
                ab.i("MicroMsg.NetSceneSnsTimeLine", "recv %d recommend", Integer.valueOf(cch.xbF));
                a.e(cch.xbG, cch.vKB);
                a.an(cch.xbG);
            }
            if (this.qIW) {
                LinkedList linkedList2 = new LinkedList();
                Iterator it = cch.vKB.iterator();
                while (it.hasNext()) {
                    linkedList2.add(Long.valueOf(((cbf) it.next()).vQE));
                }
                rw rwVar = new rw();
                rwVar.cNP.cNQ = linkedList2;
                com.tencent.mm.sdk.b.a.xxA.m(rwVar);
                if (qVar.ZS().vyl == 207) {
                    if (cch.vKB.isEmpty()) {
                        af.cnF().crj();
                        this.qIY = this.qIX;
                    } else {
                        af.cnF().YZ(i.jW(((cbf) cch.vKB.getFirst()).vQE));
                        af.cnF().YY(i.jW(((cbf) cch.vKB.getLast()).vQE));
                        a(cch, jW);
                        a.ap(cch.vKB);
                    }
                    this.qJS = true;
                    XP("@__weixintimtline");
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.o(36341);
                    return;
                }
                if (cch.vKB.isEmpty()) {
                    af.cnF().crj();
                    this.qIY = this.qIX;
                    this.qJS = true;
                } else {
                    a(cch, jW);
                    a.ap(cch.vKB);
                }
                XP("@__weixintimtline");
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(36341);
                return;
            }
            ab.d("MicroMsg.NetSceneSnsTimeLine", "np resp list size " + cch.vKB.size());
            if (cch.vKB.isEmpty()) {
                af.cnF().YY(jW);
                this.qJS = true;
                this.qIY = this.qIX;
            } else {
                a(cch, jW);
            }
            XP("@__weixintimtline");
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(36341);
            return;
        }
        XP("@__weixintimtline");
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(36341);
    }

    private static boolean c(cy cyVar) {
        AppMethodBeat.i(36342);
        if (at.isWifi(ah.getContext())) {
            try {
                com.tencent.mm.modelsns.e.tC(aa.b(cyVar.vEX.wZu.xam));
                af.cnA();
                AppMethodBeat.o(36342);
                return true;
            } catch (Exception e) {
                AppMethodBeat.o(36342);
                return false;
            }
        }
        AppMethodBeat.o(36342);
        return false;
    }

    public final int getType() {
        return 211;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(36343);
        this.ehi = fVar;
        ccg ccg = (ccg) this.ehh.fsG.fsP;
        LinkedList coH = com.tencent.mm.plugin.sns.i.e.qTd.coH();
        if (coH == null || coH.isEmpty()) {
            ccg.xbz = 0;
        } else {
            ccg.xbA = coH;
            ccg.xbz = ccg.xbA.size();
            ab.d("MicroMsg.NetSceneSnsTimeLine", "req sns timeline had exposure feed id %s", coH);
        }
        ccg.xbB = g.RP().Ry().getInt(ac.a.USERINFO_UPDATE_SNS_TIMELINE_SCENE_INT, 0);
        g.RP().Ry().set(ac.a.USERINFO_UPDATE_SNS_TIMELINE_SCENE_INT, Integer.valueOf(0));
        ab.i("MicroMsg.NetSceneSnsTimeLine", "req sns timeline read exposure size[%d] update scene[%d]", Integer.valueOf(ccg.xbz), Integer.valueOf(ccg.xbB));
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(36343);
        return a;
    }

    public final String getUserName() {
        return "@__weixintimtline";
    }

    public final boolean cmM() {
        return this.qIW;
    }

    public final boolean cmN() {
        return this.qJS;
    }

    public final boolean cmO() {
        return this.qJT;
    }

    public final boolean cmP() {
        return false;
    }

    public final long cmQ() {
        return this.qIY;
    }

    public final boolean cmR() {
        return false;
    }

    public final long cmS() {
        return 0;
    }

    public final String cmT() {
        return "";
    }
}
