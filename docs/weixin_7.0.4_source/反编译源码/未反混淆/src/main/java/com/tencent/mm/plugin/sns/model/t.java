package com.tencent.mm.plugin.sns.model;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.o;
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
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.n;
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
import com.tencent.mm.storage.az;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Iterator;
import java.util.LinkedList;

public final class t extends m implements k {
    public int afg = 0;
    final int cvp;
    private b ehh;
    public f ehi;
    private long qIY = 0;
    private String qJA = "";
    public int qJa = 0;
    public int qJb = 0;
    private long qJz = 0;

    public t() {
        int i;
        AppMethodBeat.i(36295);
        a aVar = new a();
        aVar.fsJ = new ccg();
        aVar.fsK = new cch();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnspreloadingtimeline";
        aVar.fsI = 718;
        aVar.fsL = 0;
        aVar.fsM = 0;
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
        this.cvp = 2;
        ccg ccg = (ccg) this.ehh.fsG.fsP;
        ccg.wZy = i;
        ccg.wZU = 0;
        int cod = af.cnv().cod();
        this.qIY = af.cnF().g(0, cod, true);
        ccg.xbw = this.qIY;
        ccg.xbx = c.a(this.qIY, 0, "@__weixintimtline");
        this.qJz = af.cnF().g(0, 1, true);
        ab.i("MicroMsg.NetSceneSnsPreTimeLine", "newerid " + this.qJz);
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
            ab.d("MicroMsg.NetSceneSnsPreTimeLine", "request adsession %s", YX.field_adsession);
            ccg.wZw = new SKBuiltinBuffer_t().setBuffer(YX.field_adsession);
        }
        ab.i("MicroMsg.NetSceneSnsPreTimeLine", " This req nextCount: " + cod + " min:" + this.qIY + " ReqTime:" + ccg.xbx + " nettype: " + i);
        ab.d("MicroMsg.NetSceneSnsPreTimeLine", "minId: %s lastReqTime: %s", i.jV(this.qIY), Integer.valueOf(r7));
        AppMethodBeat.o(36295);
    }

    private void a(cch cch, String str) {
        AppMethodBeat.i(36296);
        aj.a("@__weixintimtline", this.cvp, cch.vKB, str);
        this.qIY = ((cbf) cch.vKB.getLast()).vQE;
        c.f("@__weixintimtline", ((cbf) cch.vKB.getFirst()).vQE, this.qIY, cch.xbC);
        Iterator it = cch.vKB.iterator();
        while (it.hasNext()) {
            cbf cbf = (cbf) it.next();
            if (cbf.xax == 0) {
                n kD = af.cnF().kD(cbf.vQE);
                if (!(kD == null || kD.cqu() == null)) {
                    LinkedList<bau> linkedList = kD.cqu().xfI.wbK;
                    for (bau bau : linkedList) {
                        Object obj;
                        if (linkedList.size() <= 1) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (bau != null) {
                            String e = i.e(bau);
                            int i = obj != null ? 1 : 0;
                            String fZ = an.fZ(af.getAccSnsPath(), bau.Id);
                            if (e.ct(fZ + e) || e.ct(fZ + i.l(bau)) || e.ct(fZ + i.m(bau))) {
                                ab.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia exist:%s", bau.Id);
                            } else {
                                ab.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia ready to download:%s", bau.Id);
                                com.tencent.mm.plugin.sns.data.e eVar = new com.tencent.mm.plugin.sns.data.e(bau);
                                eVar.qFQ = i;
                                eVar.nQB = bau.Id;
                                af.cnA().a(bau, bau.jCt == 6 ? 5 : 1, eVar, az.xYM);
                            }
                        }
                    }
                    if (kD.field_type == 15) {
                        ar cnD = af.cnD();
                        if (kD != null) {
                            ab.i("MicroMsg.SnsVideoService", "%d add preload video[%s]", Integer.valueOf(cnD.hashCode()), kD.cqU());
                            synchronized (cnD.qMZ) {
                                try {
                                    cnD.qMZ.addFirst(kD);
                                } catch (Throwable th) {
                                    while (true) {
                                        AppMethodBeat.o(36296);
                                    }
                                }
                            }
                        }
                        try {
                            String str2 = ((bau) kD.cqu().xfI.wbK.get(0)).Url;
                            h.pYm.e(14388, Long.valueOf(cbf.vQE), Integer.valueOf(4), str2, Integer.valueOf(0));
                        } catch (Exception e2) {
                        }
                    }
                }
            }
        }
        af.cnD().coj();
        AppMethodBeat.o(36296);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(36297);
        ab.i("MicroMsg.NetSceneSnsPreTimeLine", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        cch cch = (cch) ((b) qVar).fsH.fsP;
        if (qVar.ZS().vyl == 207 || qVar.ZS().vyl == 0) {
            int i4;
            int i5;
            if (cch.wZZ != null) {
                ab.d("MicroMsg.NetSceneSnsPreTimeLine", "serverConfig  " + cch.wZZ.xbs + " " + cch.wZZ.xbr);
                i4 = cch.wZZ.xbs;
                com.tencent.mm.plugin.sns.c.a.qFE = i4;
                if (i4 <= 0) {
                    com.tencent.mm.plugin.sns.c.a.qFE = BaseClientBuilder.API_PRIORITY_OTHER;
                }
                com.tencent.mm.storage.ab.xID = cch.wZZ.xbr;
            }
            this.qJa = cch.wZX;
            this.qJb = cch.wZY;
            ab.i("MicroMsg.NetSceneSnsPreTimeLine", "for same md5 count: " + cch.wZX + " , objCount:  " + cch.wGG + " cflag : " + cch.wZY);
            this.afg = cch.wGG;
            String jW = i.jW(0);
            if (cch.vKB.isEmpty()) {
                ab.i("MicroMsg.NetSceneSnsPreTimeLine", " respone is Empty");
            } else {
                ab.i("MicroMsg.NetSceneSnsPreTimeLine", "respone size " + cch.vKB.size() + " Max " + ((cbf) cch.vKB.getFirst()).vQE + " " + i.jV(((cbf) cch.vKB.getFirst()).vQE) + "  respone min  " + ((cbf) cch.vKB.getLast()).vQE + " " + i.jV(((cbf) cch.vKB.getLast()).vQE));
            }
            if (cch.xbH > 0) {
                ab.i("MicroMsg.NetSceneSnsPreTimeLine", "%d ads to delete", Integer.valueOf(cch.xbH));
                if (cch.xbI != null && cch.xbI.size() == cch.xbH) {
                    LinkedList linkedList = new LinkedList();
                    i4 = 0;
                    while (true) {
                        i5 = i4;
                        if (i5 >= cch.xbH) {
                            break;
                        }
                        long j = ((vd) cch.xbI.get(i5)).vQE;
                        ab.i("MicroMsg.NetSceneSnsPreTimeLine", "delete ad %s", Long.valueOf(j));
                        if (j != 0) {
                            com.tencent.mm.plugin.sns.storage.e ku = af.cnI().ku(j);
                            if (ku == null) {
                                ab.i("MicroMsg.NetSceneSnsPreTimeLine", "adSnsInfo is null!");
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
            this.afg = cch.wGG;
            if (this.qJA.equals(cch.wZT)) {
                this.qIY = af.cnF().g(0, this.qJa, true);
                ab.i("MicroMsg.NetSceneSnsPreTimeLine", "md5 is no change!! the new minid %s", Long.valueOf(this.qIY));
                y.XP("@__weixintimtline");
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(36297);
                return;
            }
            af.cnJ().h("@__weixintimtline", cch.wZT, aa.a(cch.wZw));
            ab.i("MicroMsg.NetSceneSnsPreTimeLine", "fp resp list size " + cch.vKB.size() + " adsize : " + cch.xbD);
            i4 = 0;
            while (true) {
                i5 = i4;
                if (i5 >= cch.xbE.size()) {
                    break;
                }
                cy cyVar = (cy) cch.xbE.get(i5);
                String a = aa.a(cyVar.vEY);
                String a2 = aa.a(cyVar.vEX.wZv);
                String b = aa.b(cyVar.vEX.wZu.xam);
                ab.i("MicroMsg.NetSceneSnsPreTimeLine", "skXml ".concat(String.valueOf(a)));
                ab.i("MicroMsg.NetSceneSnsPreTimeLine", "adXml ".concat(String.valueOf(a2)));
                ab.i("MicroMsg.NetSceneSnsPreTimeLine", "snsXml " + b + IOUtils.LINE_SEPARATOR_WINDOWS);
                String str2 = cyVar.vEX.wZu.vHl;
                if (!bo.isNullOrNil(str2)) {
                    ao.a.flu.ai(str2, "");
                    o.acv().qa(str2);
                }
                i4 = i5 + 1;
            }
            a.k(cch.xbE, cch.vKB);
            a.ao(cch.xbE);
            if (cch.xbD == 0) {
                ab.i("MicroMsg.NetSceneSnsPreTimeLine", "recv %d recommend", Integer.valueOf(cch.xbF));
                a.e(cch.xbG, cch.vKB);
                a.an(cch.xbG);
            }
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
                } else {
                    af.cnF().YZ(i.jW(((cbf) cch.vKB.getFirst()).vQE));
                    af.cnF().YY(i.jW(((cbf) cch.vKB.getLast()).vQE));
                    a(cch, jW);
                    a.ap(cch.vKB);
                }
                y.XP("@__weixintimtline");
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(36297);
                return;
            }
            if (cch.vKB.isEmpty()) {
                af.cnF().crj();
            } else {
                a(cch, jW);
                a.ap(cch.vKB);
            }
            y.XP("@__weixintimtline");
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(36297);
            return;
        }
        y.XP("@__weixintimtline");
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(36297);
    }

    public final int getType() {
        return 718;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(36298);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(36298);
        return a;
    }
}
