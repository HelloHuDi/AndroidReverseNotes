package com.tencent.p177mm.plugin.sns.model;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p230g.p231a.C18389rw;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.data.C39731e;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.storage.C29097l;
import com.tencent.p177mm.plugin.sns.storage.C43570e;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.C15392vd;
import com.tencent.p177mm.protocal.protobuf.C44105bp;
import com.tencent.p177mm.protocal.protobuf.C46531cy;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.protocal.protobuf.ccg;
import com.tencent.p177mm.protocal.protobuf.cch;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C15430ab;
import com.tencent.p177mm.storage.C44222az;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.sns.model.t */
public final class C34963t extends C1207m implements C1918k {
    public int afg = 0;
    final int cvp;
    private C7472b ehh;
    public C1202f ehi;
    private long qIY = 0;
    private String qJA = "";
    public int qJa = 0;
    public int qJb = 0;
    private long qJz = 0;

    public C34963t() {
        int i;
        AppMethodBeat.m2504i(36295);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ccg();
        c1196a.fsK = new cch();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmsnspreloadingtimeline";
        c1196a.fsI = 718;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        if (C5023at.isWifi(C4996ah.getContext())) {
            i = 1;
        } else if (C5023at.is3G(C4996ah.getContext())) {
            i = 3;
        } else if (C5023at.is4G(C4996ah.getContext())) {
            i = 4;
        } else if (C5023at.is2G(C4996ah.getContext())) {
            i = 2;
        } else {
            i = 0;
        }
        this.cvp = 2;
        ccg ccg = (ccg) this.ehh.fsG.fsP;
        ccg.wZy = i;
        ccg.wZU = 0;
        int cod = C13373af.cnv().cod();
        this.qIY = C13373af.cnF().mo62938g(0, cod, true);
        ccg.xbw = this.qIY;
        ccg.xbx = C43561c.m77914a(this.qIY, 0, "@__weixintimtline");
        this.qJz = C13373af.cnF().mo62938g(0, 1, true);
        C4990ab.m7416i("MicroMsg.NetSceneSnsPreTimeLine", "newerid " + this.qJz);
        ccg.xby = this.qJz;
        C29097l YX = C13373af.cnJ().mo69179YX("@__weixintimtline");
        this.qJA = YX == null ? "" : YX.field_md5;
        if (this.qJA == null) {
            this.qJA = "";
        }
        ccg.wZT = this.qJA;
        if (YX == null || YX.field_adsession == null) {
            ccg.wZw = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        } else {
            C4990ab.m7411d("MicroMsg.NetSceneSnsPreTimeLine", "request adsession %s", YX.field_adsession);
            ccg.wZw = new SKBuiltinBuffer_t().setBuffer(YX.field_adsession);
        }
        C4990ab.m7416i("MicroMsg.NetSceneSnsPreTimeLine", " This req nextCount: " + cod + " min:" + this.qIY + " ReqTime:" + ccg.xbx + " nettype: " + i);
        C4990ab.m7411d("MicroMsg.NetSceneSnsPreTimeLine", "minId: %s lastReqTime: %s", C29036i.m46117jV(this.qIY), Integer.valueOf(r7));
        AppMethodBeat.m2505o(36295);
    }

    /* renamed from: a */
    private void m57431a(cch cch, String str) {
        AppMethodBeat.m2504i(36296);
        C34955aj.m57397a("@__weixintimtline", this.cvp, cch.vKB, str);
        this.qIY = ((cbf) cch.vKB.getLast()).vQE;
        C43561c.m77916f("@__weixintimtline", ((cbf) cch.vKB.getFirst()).vQE, this.qIY, cch.xbC);
        Iterator it = cch.vKB.iterator();
        while (it.hasNext()) {
            cbf cbf = (cbf) it.next();
            if (cbf.xax == 0) {
                C46236n kD = C13373af.cnF().mo62941kD(cbf.vQE);
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
                            String e = C29036i.m46108e(bau);
                            int i = obj != null ? 1 : 0;
                            String fZ = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id);
                            if (C5730e.m8628ct(fZ + e) || C5730e.m8628ct(fZ + C29036i.m46121l(bau)) || C5730e.m8628ct(fZ + C29036i.m46122m(bau))) {
                                C4990ab.m7417i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia exist:%s", bau.f17915Id);
                            } else {
                                C4990ab.m7417i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia ready to download:%s", bau.f17915Id);
                                C39731e c39731e = new C39731e(bau);
                                c39731e.qFQ = i;
                                c39731e.nQB = bau.f17915Id;
                                C13373af.cnA().mo69138a(bau, bau.jCt == 6 ? 5 : 1, c39731e, C44222az.xYM);
                            }
                        }
                    }
                    if (kD.field_type == 15) {
                        C39754ar cnD = C13373af.cnD();
                        if (kD != null) {
                            C4990ab.m7417i("MicroMsg.SnsVideoService", "%d add preload video[%s]", Integer.valueOf(cnD.hashCode()), kD.cqU());
                            synchronized (cnD.qMZ) {
                                try {
                                    cnD.qMZ.addFirst(kD);
                                } catch (Throwable th) {
                                    while (true) {
                                        AppMethodBeat.m2505o(36296);
                                    }
                                }
                            }
                        }
                        try {
                            String str2 = ((bau) kD.cqu().xfI.wbK.get(0)).Url;
                            C7060h.pYm.mo8381e(14388, Long.valueOf(cbf.vQE), Integer.valueOf(4), str2, Integer.valueOf(0));
                        } catch (Exception e2) {
                        }
                    }
                }
            }
        }
        C13373af.cnD().coj();
        AppMethodBeat.m2505o(36296);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(36297);
        C4990ab.m7416i("MicroMsg.NetSceneSnsPreTimeLine", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        cch cch = (cch) ((C7472b) c1929q).fsH.fsP;
        if (c1929q.mo5618ZS().vyl == 207 || c1929q.mo5618ZS().vyl == 0) {
            int i4;
            int i5;
            if (cch.wZZ != null) {
                C4990ab.m7410d("MicroMsg.NetSceneSnsPreTimeLine", "serverConfig  " + cch.wZZ.xbs + " " + cch.wZZ.xbr);
                i4 = cch.wZZ.xbs;
                C24826a.qFE = i4;
                if (i4 <= 0) {
                    C24826a.qFE = BaseClientBuilder.API_PRIORITY_OTHER;
                }
                C15430ab.xID = cch.wZZ.xbr;
            }
            this.qJa = cch.wZX;
            this.qJb = cch.wZY;
            C4990ab.m7416i("MicroMsg.NetSceneSnsPreTimeLine", "for same md5 count: " + cch.wZX + " , objCount:  " + cch.wGG + " cflag : " + cch.wZY);
            this.afg = cch.wGG;
            String jW = C29036i.m46118jW(0);
            if (cch.vKB.isEmpty()) {
                C4990ab.m7416i("MicroMsg.NetSceneSnsPreTimeLine", " respone is Empty");
            } else {
                C4990ab.m7416i("MicroMsg.NetSceneSnsPreTimeLine", "respone size " + cch.vKB.size() + " Max " + ((cbf) cch.vKB.getFirst()).vQE + " " + C29036i.m46117jV(((cbf) cch.vKB.getFirst()).vQE) + "  respone min  " + ((cbf) cch.vKB.getLast()).vQE + " " + C29036i.m46117jV(((cbf) cch.vKB.getLast()).vQE));
            }
            if (cch.xbH > 0) {
                C4990ab.m7417i("MicroMsg.NetSceneSnsPreTimeLine", "%d ads to delete", Integer.valueOf(cch.xbH));
                if (cch.xbI != null && cch.xbI.size() == cch.xbH) {
                    LinkedList linkedList = new LinkedList();
                    i4 = 0;
                    while (true) {
                        i5 = i4;
                        if (i5 >= cch.xbH) {
                            break;
                        }
                        long j = ((C15392vd) cch.xbI.get(i5)).vQE;
                        C4990ab.m7417i("MicroMsg.NetSceneSnsPreTimeLine", "delete ad %s", Long.valueOf(j));
                        if (j != 0) {
                            C43570e ku = C13373af.cnI().mo69174ku(j);
                            if (ku == null) {
                                C4990ab.m7416i("MicroMsg.NetSceneSnsPreTimeLine", "adSnsInfo is null!");
                            } else {
                                C44105bp c44105bp = new C44105bp();
                                c44105bp.vDS = 13298;
                                c44105bp.vDT = new C1332b(ku.cqq().qPj.getBytes());
                                c44105bp.vDU = System.currentTimeMillis() / 1000;
                                linkedList.add(c44105bp);
                                C43555a.m77885jX(j);
                            }
                        }
                        i4 = i5 + 1;
                    }
                    if (linkedList.size() > 0) {
                        C1720g.m3537RQ();
                        C1720g.m3535RO().eJo.mo14541a(new C13427l(linkedList), 0);
                    }
                }
            }
            this.afg = cch.wGG;
            if (this.qJA.equals(cch.wZT)) {
                this.qIY = C13373af.cnF().mo62938g(0, this.qJa, true);
                C4990ab.m7417i("MicroMsg.NetSceneSnsPreTimeLine", "md5 is no change!! the new minid %s", Long.valueOf(this.qIY));
                C46225y.m86451XP("@__weixintimtline");
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(36297);
                return;
            }
            C13373af.cnJ().mo69184h("@__weixintimtline", cch.wZT, C1946aa.m4150a(cch.wZw));
            C4990ab.m7416i("MicroMsg.NetSceneSnsPreTimeLine", "fp resp list size " + cch.vKB.size() + " adsize : " + cch.xbD);
            i4 = 0;
            while (true) {
                i5 = i4;
                if (i5 >= cch.xbE.size()) {
                    break;
                }
                C46531cy c46531cy = (C46531cy) cch.xbE.get(i5);
                String a = C1946aa.m4148a(c46531cy.vEY);
                String a2 = C1946aa.m4148a(c46531cy.vEX.wZv);
                String b = C1946aa.m4153b(c46531cy.vEX.wZu.xam);
                C4990ab.m7416i("MicroMsg.NetSceneSnsPreTimeLine", "skXml ".concat(String.valueOf(a)));
                C4990ab.m7416i("MicroMsg.NetSceneSnsPreTimeLine", "adXml ".concat(String.valueOf(a2)));
                C4990ab.m7416i("MicroMsg.NetSceneSnsPreTimeLine", "snsXml " + b + IOUtils.LINE_SEPARATOR_WINDOWS);
                String str2 = c46531cy.vEX.wZu.vHl;
                if (!C5046bo.isNullOrNil(str2)) {
                    C26417a.flu.mo20967ai(str2, "");
                    C17884o.acv().mo67496qa(str2);
                }
                i4 = i5 + 1;
            }
            C43555a.m77888k(cch.xbE, cch.vKB);
            C43555a.m77876ao(cch.xbE);
            if (cch.xbD == 0) {
                C4990ab.m7417i("MicroMsg.NetSceneSnsPreTimeLine", "recv %d recommend", Integer.valueOf(cch.xbF));
                C43555a.m77883e(cch.xbG, cch.vKB);
                C43555a.m77875an(cch.xbG);
            }
            LinkedList linkedList2 = new LinkedList();
            Iterator it = cch.vKB.iterator();
            while (it.hasNext()) {
                linkedList2.add(Long.valueOf(((cbf) it.next()).vQE));
            }
            C18389rw c18389rw = new C18389rw();
            c18389rw.cNP.cNQ = linkedList2;
            C4879a.xxA.mo10055m(c18389rw);
            if (c1929q.mo5618ZS().vyl == 207) {
                if (cch.vKB.isEmpty()) {
                    C13373af.cnF().crj();
                } else {
                    C13373af.cnF().mo62920YZ(C29036i.m46118jW(((cbf) cch.vKB.getFirst()).vQE));
                    C13373af.cnF().mo62919YY(C29036i.m46118jW(((cbf) cch.vKB.getLast()).vQE));
                    m57431a(cch, jW);
                    C43555a.m77877ap(cch.vKB);
                }
                C46225y.m86451XP("@__weixintimtline");
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(36297);
                return;
            }
            if (cch.vKB.isEmpty()) {
                C13373af.cnF().crj();
            } else {
                m57431a(cch, jW);
                C43555a.m77877ap(cch.vKB);
            }
            C46225y.m86451XP("@__weixintimtline");
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(36297);
            return;
        }
        C46225y.m86451XP("@__weixintimtline");
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(36297);
    }

    public final int getType() {
        return 718;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(36298);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(36298);
        return a;
    }
}
