package com.tencent.p177mm.plugin.sns.model;

import android.database.Cursor;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.modelsns.C37953e;
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
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p517i.C43549e;
import com.tencent.p177mm.plugin.sns.storage.C29097l;
import com.tencent.p177mm.plugin.sns.storage.C39789o;
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
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

/* renamed from: com.tencent.mm.plugin.sns.model.y */
public final class C46225y extends C1207m implements C1918k, C21918d {
    private static Vector<String> qIZ = new Vector();
    public int afg = 0;
    final int cvp;
    private C7472b ehh;
    public C1202f ehi;
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
        AppMethodBeat.m2504i(36344);
        AppMethodBeat.m2505o(36344);
    }

    /* renamed from: XO */
    public static synchronized boolean m86450XO(String str) {
        boolean z;
        synchronized (C46225y.class) {
            AppMethodBeat.m2504i(36336);
            if (qIZ.contains(str)) {
                z = false;
                AppMethodBeat.m2505o(36336);
            } else {
                qIZ.add(str);
                z = true;
                AppMethodBeat.m2505o(36336);
            }
        }
        return z;
    }

    /* renamed from: XP */
    public static synchronized boolean m86451XP(String str) {
        synchronized (C46225y.class) {
            AppMethodBeat.m2504i(36337);
            qIZ.remove(str);
            AppMethodBeat.m2505o(36337);
        }
        return true;
    }

    public C46225y(long j) {
        int i;
        long j2;
        AppMethodBeat.m2504i(36338);
        long currentTimeMillis = System.currentTimeMillis();
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ccg();
        c1196a.fsK = new cch();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmsnstimeline";
        c1196a.fsI = 211;
        c1196a.fsL = 98;
        c1196a.fsM = 1000000098;
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
        this.qIX = j;
        this.qIW = j == 0;
        this.cvp = 2;
        ccg ccg = (ccg) this.ehh.fsG.fsP;
        ccg.wZy = i;
        ccg.wZU = j;
        int cod = C13373af.cnv().cod();
        C39789o cnF = C13373af.cnF();
        if (this.qIW) {
            j2 = 0;
        } else {
            j2 = j;
        }
        this.qIY = cnF.mo62938g(j2, cod, true);
        ccg.xbw = this.qIY;
        ccg.xbx = C43561c.m77914a(this.qIY, j, "@__weixintimtline");
        if (this.qIW) {
            this.qJz = C13373af.cnF().mo62938g(0, 1, true);
            C4990ab.m7416i("MicroMsg.NetSceneSnsTimeLine", "newerid " + this.qJz);
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
                C4990ab.m7411d("MicroMsg.NetSceneSnsTimeLine", "request adsession %s", YX.field_adsession);
                ccg.wZw = new SKBuiltinBuffer_t().setBuffer(YX.field_adsession);
            }
        }
        this.qJR = j;
        C4990ab.m7416i("MicroMsg.NetSceneSnsTimeLine", " This req nextCount: " + cod + " max:" + j + " min:" + this.qIY + " ReqTime:" + ccg.xbx + " nettype: " + i);
        C4990ab.m7411d("MicroMsg.NetSceneSnsTimeLine", "maxId: %s minId: %s lastReqTime: %s", C29036i.m46117jV(j), C29036i.m46117jV(this.qIY), Integer.valueOf(r3));
        C4990ab.m7411d("MicroMsg.NetSceneSnsTimeLine", "NetSceneSnsTimeLine %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(36338);
    }

    private void cnc() {
        AppMethodBeat.m2504i(36339);
        C39789o cnF = C13373af.cnF();
        Cursor a = cnF.bSd.mo10104a(C39789o.crn(), null, 2);
        int i = 0;
        while (a.moveToNext()) {
            i++;
        }
        a.close();
        if (i >= 3 || i <= 0) {
            if (i == 0) {
                this.qJS = true;
            }
            AppMethodBeat.m2505o(36339);
            return;
        }
        this.qJT = true;
        AppMethodBeat.m2505o(36339);
    }

    /* renamed from: a */
    private void m86452a(cch cch, String str) {
        AppMethodBeat.m2504i(36340);
        C34955aj.m57397a("@__weixintimtline", this.cvp, cch.vKB, str);
        this.qIY = ((cbf) cch.vKB.getLast()).vQE;
        if (this.qIX == 0) {
            this.qIX = ((cbf) cch.vKB.getFirst()).vQE;
        } else {
            this.qIX = C43561c.m77917ka(this.qIX);
        }
        C43561c.m77916f("@__weixintimtline", this.qIX, this.qIY, cch.xbC);
        try {
            Iterator it = cch.vKB.iterator();
            while (it.hasNext()) {
                cbf cbf = (cbf) it.next();
                if (cbf.xax == 0) {
                    C46236n kD = C13373af.cnF().mo62941kD(cbf.vQE);
                    if (!(kD == null || kD.cqu() == null || kD.field_type != 15)) {
                        try {
                            String str2 = ((bau) kD.cqu().xfI.wbK.get(0)).Url;
                            C7060h.pYm.mo8381e(14388, Long.valueOf(cbf.vQE), Integer.valueOf(4), str2, Integer.valueOf(0));
                        } catch (Exception e) {
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(36340);
        } catch (Exception e2) {
            AppMethodBeat.m2505o(36340);
        }
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(36341);
        C4990ab.m7416i("MicroMsg.NetSceneSnsTimeLine", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        cch cch = (cch) ((C7472b) c1929q).fsH.fsP;
        if (c1929q.mo5618ZS().vyl == 207 || c1929q.mo5618ZS().vyl == 0) {
            int i4;
            int i5;
            if (cch.wZZ != null) {
                C4990ab.m7416i("MicroMsg.NetSceneSnsTimeLine", "serverConfig  " + cch.wZZ.xbs + " " + cch.wZZ.xbr);
                i4 = cch.wZZ.xbs;
                C24826a.qFE = i4;
                if (i4 <= 0) {
                    C24826a.qFE = BaseClientBuilder.API_PRIORITY_OTHER;
                }
                C15430ab.xID = cch.wZZ.xbr;
            }
            this.qJa = cch.wZX;
            this.qJb = cch.wZY;
            C4990ab.m7416i("MicroMsg.NetSceneSnsTimeLine", "for same md5 count: " + cch.wZX + " , objCount:  " + cch.wGG + " cflag : " + cch.wZY);
            this.afg = cch.wGG;
            String jW = C29036i.m46118jW(this.qIX);
            if (cch.vKB.isEmpty()) {
                C4990ab.m7416i("MicroMsg.NetSceneSnsTimeLine", " respone is Empty");
            } else {
                C4990ab.m7416i("MicroMsg.NetSceneSnsTimeLine", "respone size " + cch.vKB.size() + " Max " + ((cbf) cch.vKB.getFirst()).vQE + " " + C29036i.m46117jV(((cbf) cch.vKB.getFirst()).vQE) + "  respone min  " + ((cbf) cch.vKB.getLast()).vQE + " " + C29036i.m46117jV(((cbf) cch.vKB.getLast()).vQE));
            }
            if (cch.xbH > 0) {
                C4990ab.m7417i("MicroMsg.NetSceneSnsTimeLine", "%d ads to delete", Integer.valueOf(cch.xbH));
                if (cch.xbI != null && cch.xbI.size() == cch.xbH) {
                    LinkedList linkedList = new LinkedList();
                    i4 = 0;
                    while (true) {
                        i5 = i4;
                        if (i5 >= cch.xbH) {
                            break;
                        }
                        long j = ((C15392vd) cch.xbI.get(i5)).vQE;
                        C4990ab.m7417i("MicroMsg.NetSceneSnsTimeLine", "delete ad %s", Long.valueOf(j));
                        if (j != 0) {
                            C43570e ku = C13373af.cnI().mo69174ku(j);
                            if (ku == null) {
                                C4990ab.m7416i("MicroMsg.NetSceneSnsTimeLine", "adSnsInfo is null!");
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
            if (this.qJA.equals(cch.wZT)) {
                this.qIY = C13373af.cnF().mo62938g(this.qIW ? 0 : this.qJR, this.qJa, true);
                C4990ab.m7417i("MicroMsg.NetSceneSnsTimeLine", "md5 is no change!! the new minid %s", Long.valueOf(this.qIY));
                cnc();
                C46225y.m86451XP("@__weixintimtline");
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(36341);
                return;
            }
            C46531cy c46531cy;
            String str2;
            String a;
            C13373af.cnJ().mo69184h("@__weixintimtline", cch.wZT, C1946aa.m4150a(cch.wZw));
            C4990ab.m7416i("MicroMsg.NetSceneSnsTimeLine", "resp list size " + cch.vKB.size() + " adsize : " + cch.xbD);
            i4 = 0;
            while (true) {
                i5 = i4;
                if (i5 >= cch.xbE.size()) {
                    break;
                }
                c46531cy = (C46531cy) cch.xbE.get(i5);
                if (this.fNO) {
                    str2 = C13373af.getAccPath() + "ad.proto";
                    try {
                        byte[] toByteArray = c46531cy.toByteArray();
                        C5730e.m8624b(str2, toByteArray, toByteArray.length);
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.NetSceneSnsTimeLine", "save error " + e.getMessage());
                    }
                }
                str2 = C1946aa.m4148a(c46531cy.vEY);
                a = C1946aa.m4148a(c46531cy.vEX.wZv);
                String b = C1946aa.m4153b(c46531cy.vEX.wZu.xam);
                C4990ab.m7416i("MicroMsg.NetSceneSnsTimeLine", "skXml ".concat(String.valueOf(str2)));
                C4990ab.m7416i("MicroMsg.NetSceneSnsTimeLine", "adXml ".concat(String.valueOf(a)));
                C4990ab.m7416i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + b + IOUtils.LINE_SEPARATOR_WINDOWS);
                String str3 = c46531cy.vEX.wZu.vHl;
                if (!C5046bo.isNullOrNil(str3)) {
                    C26417a.flu.mo20967ai(str3, "");
                    C17884o.acv().mo67496qa(str3);
                }
                i4 = i5 + 1;
            }
            if (this.fNO && cch.xbE.size() == 0) {
                try {
                    byte[] e2 = C5730e.m8632e(C13373af.getAccPath() + "ad.proto", 0, -1);
                    C46531cy c46531cy2 = new C46531cy();
                    c46531cy2.parseFrom(e2);
                    cch.xbE.add(c46531cy2);
                    cch.xbD = cch.xbE.size();
                    C4990ab.m7410d("MicroMsg.NetSceneSnsTimeLine", "read from path " + cch.xbD);
                    if (cch.xbE.size() > 0) {
                        c46531cy = (C46531cy) cch.xbE.get(0);
                        String a2 = C1946aa.m4148a(c46531cy.vEY);
                        str2 = C1946aa.m4148a(c46531cy.vEX.wZv);
                        a = C1946aa.m4153b(c46531cy.vEX.wZu.xam);
                        C4990ab.m7416i("MicroMsg.NetSceneSnsTimeLine", "skXml ".concat(String.valueOf(a2)));
                        C4990ab.m7416i("MicroMsg.NetSceneSnsTimeLine", "adXml ".concat(String.valueOf(str2)));
                        C4990ab.m7416i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + a + IOUtils.LINE_SEPARATOR_WINDOWS);
                        C46225y.m86453c(c46531cy);
                    }
                } catch (Exception e3) {
                    C4990ab.m7412e("MicroMsg.NetSceneSnsTimeLine", "read error " + e3.getMessage());
                }
            }
            C43555a.m77888k(cch.xbE, cch.vKB);
            C43555a.m77876ao(cch.xbE);
            if (cch.xbD == 0) {
                C4990ab.m7417i("MicroMsg.NetSceneSnsTimeLine", "recv %d recommend", Integer.valueOf(cch.xbF));
                C43555a.m77883e(cch.xbG, cch.vKB);
                C43555a.m77875an(cch.xbG);
            }
            if (this.qIW) {
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
                        this.qIY = this.qIX;
                    } else {
                        C13373af.cnF().mo62920YZ(C29036i.m46118jW(((cbf) cch.vKB.getFirst()).vQE));
                        C13373af.cnF().mo62919YY(C29036i.m46118jW(((cbf) cch.vKB.getLast()).vQE));
                        m86452a(cch, jW);
                        C43555a.m77877ap(cch.vKB);
                    }
                    this.qJS = true;
                    C46225y.m86451XP("@__weixintimtline");
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.m2505o(36341);
                    return;
                }
                if (cch.vKB.isEmpty()) {
                    C13373af.cnF().crj();
                    this.qIY = this.qIX;
                    this.qJS = true;
                } else {
                    m86452a(cch, jW);
                    C43555a.m77877ap(cch.vKB);
                }
                C46225y.m86451XP("@__weixintimtline");
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(36341);
                return;
            }
            C4990ab.m7410d("MicroMsg.NetSceneSnsTimeLine", "np resp list size " + cch.vKB.size());
            if (cch.vKB.isEmpty()) {
                C13373af.cnF().mo62919YY(jW);
                this.qJS = true;
                this.qIY = this.qIX;
            } else {
                m86452a(cch, jW);
            }
            C46225y.m86451XP("@__weixintimtline");
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(36341);
            return;
        }
        C46225y.m86451XP("@__weixintimtline");
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(36341);
    }

    /* renamed from: c */
    private static boolean m86453c(C46531cy c46531cy) {
        AppMethodBeat.m2504i(36342);
        if (C5023at.isWifi(C4996ah.getContext())) {
            try {
                C37953e.m64188tC(C1946aa.m4153b(c46531cy.vEX.wZu.xam));
                C13373af.cnA();
                AppMethodBeat.m2505o(36342);
                return true;
            } catch (Exception e) {
                AppMethodBeat.m2505o(36342);
                return false;
            }
        }
        AppMethodBeat.m2505o(36342);
        return false;
    }

    public final int getType() {
        return 211;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(36343);
        this.ehi = c1202f;
        ccg ccg = (ccg) this.ehh.fsG.fsP;
        LinkedList coH = C43549e.qTd.coH();
        if (coH == null || coH.isEmpty()) {
            ccg.xbz = 0;
        } else {
            ccg.xbA = coH;
            ccg.xbz = ccg.xbA.size();
            C4990ab.m7411d("MicroMsg.NetSceneSnsTimeLine", "req sns timeline had exposure feed id %s", coH);
        }
        ccg.xbB = C1720g.m3536RP().mo5239Ry().getInt(C5127a.USERINFO_UPDATE_SNS_TIMELINE_SCENE_INT, 0);
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_UPDATE_SNS_TIMELINE_SCENE_INT, Integer.valueOf(0));
        C4990ab.m7417i("MicroMsg.NetSceneSnsTimeLine", "req sns timeline read exposure size[%d] update scene[%d]", Integer.valueOf(ccg.xbz), Integer.valueOf(ccg.xbB));
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(36343);
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
