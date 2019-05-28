package com.tencent.p177mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.storage.C29097l;
import com.tencent.p177mm.plugin.sns.storage.C39789o;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.protocal.protobuf.ccl;
import com.tencent.p177mm.protocal.protobuf.ccm;
import com.tencent.p177mm.protocal.protobuf.ccn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Vector;

/* renamed from: com.tencent.mm.plugin.sns.model.aa */
public final class C46218aa extends C1207m implements C1918k, C21918d {
    private static Vector<String> qKd = new Vector();
    private final int cvp;
    private boolean czr;
    private C7472b ehh;
    public C1202f ehi;
    private boolean qIW;
    private long qIX = 0;
    long qIY = 0;
    private String qJA = "";
    private long qJR = 0;
    private boolean qJS = false;
    private boolean qJT = false;
    public int qJa = 0;
    private int qKe = 0;
    private boolean qKf = false;
    private String qKg = "";
    private boolean qKh = false;
    public long qKi;
    String userName;

    static {
        AppMethodBeat.m2504i(36362);
        AppMethodBeat.m2505o(36362);
    }

    /* renamed from: XR */
    public static synchronized boolean m86427XR(String str) {
        boolean z;
        synchronized (C46218aa.class) {
            AppMethodBeat.m2504i(36355);
            if (qKd.contains(str)) {
                z = false;
                AppMethodBeat.m2505o(36355);
            } else {
                qKd.add(str);
                z = true;
                AppMethodBeat.m2505o(36355);
            }
        }
        return z;
    }

    /* renamed from: XS */
    public static synchronized boolean m86428XS(String str) {
        synchronized (C46218aa.class) {
            AppMethodBeat.m2504i(36356);
            qKd.remove(str);
            AppMethodBeat.m2505o(36356);
        }
        return true;
    }

    public C46218aa(String str, long j, boolean z, int i) {
        long j2 = 0;
        boolean z2 = false;
        AppMethodBeat.m2504i(36357);
        this.userName = str;
        this.qIX = j;
        this.czr = z;
        if (j == 0) {
            C4990ab.m7416i("MicroMsg.NetSceneSnsUserPage", "fp userName ".concat(String.valueOf(str)));
        } else {
            C4990ab.m7416i("MicroMsg.NetSceneSnsUserPage", "np userName ".concat(String.valueOf(str)));
        }
        this.cvp = z ? 4 : 8;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ccm();
        c1196a.fsK = new ccn();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmsnsuserpage";
        c1196a.fsI = 212;
        c1196a.fsL = 99;
        c1196a.fsM = 1000000099;
        this.ehh = c1196a.acD();
        ccm ccm = (ccm) this.ehh.fsG.fsP;
        ccm.vHl = str;
        ccm.wZU = j;
        if (j == 0) {
            z2 = true;
        }
        this.qIW = z2;
        int Yc = C13373af.cnv().mo8616Yc(str);
        C39789o cnF = C13373af.cnF();
        if (!this.qIW) {
            j2 = j;
        }
        this.qIY = cnF.mo62925a(j2, Yc, str, z);
        ccm.xbw = this.qIY;
        int a = C43561c.m77914a(this.qIY, j, str);
        ccm.xbx = a;
        ccm.vFH = i;
        if (this.qIW) {
            this.qJA = C13373af.cnJ().mo69179YX(str).field_md5;
            if (this.qJA == null) {
                this.qJA = "";
            }
            ccm.wZT = this.qJA;
        }
        this.qJR = j;
        C4990ab.m7416i("MicroMsg.NetSceneSnsUserPage", "nextCount: " + Yc + " maxId:" + C29036i.m46117jV(j) + " minId:" + C29036i.m46117jV(this.qIY) + " lastReqTime:" + a + " snsSource " + i);
        AppMethodBeat.m2505o(36357);
    }

    /* renamed from: fj */
    private void m86430fj(int i, int i2) {
        AppMethodBeat.m2504i(138379);
        C39789o cnF = C13373af.cnF();
        String str = this.userName;
        boolean z = this.czr;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select snsId from SnsInfo ").append(C39789o.m68083bm(str, z)).append(" AND type in ( 1,2 , 3 , 4 , 18 , 5 , 12 , 9 , 14 , 15 , 13 , 21 , 25 , 26) and  (snsId != 0  )  limit 4");
        Cursor rawQuery = cnF.bSd.rawQuery(stringBuilder.toString(), null);
        int count = rawQuery.getCount();
        rawQuery.close();
        if (count > 3 || count <= 0 || i != 0 || i2 != 0) {
            if (count == 0) {
                this.qJS = true;
            }
            AppMethodBeat.m2505o(138379);
            return;
        }
        this.qJT = true;
        AppMethodBeat.m2505o(138379);
    }

    /* renamed from: a */
    private void m86429a(ccn ccn, String str) {
        AppMethodBeat.m2504i(36359);
        C34955aj.m57397a(this.userName, this.cvp, ccn.vKB, str);
        if (this.qIX == 0) {
            this.qIX = ((cbf) ccn.vKB.getFirst()).vQE;
        } else {
            this.qIX = C43561c.m77917ka(this.qIX);
        }
        this.qIY = ((cbf) ccn.vKB.getLast()).vQE;
        C4990ab.m7417i("MicroMsg.NetSceneSnsUserPage", "insertListAndUpdateFaultInfo userName %s maxId %s minId %s NewRequestTime %s", this.userName, Long.valueOf(this.qIX), Long.valueOf(this.qIY), Integer.valueOf(ccn.xbC));
        C43561c.m77916f(this.userName, this.qIX, this.qIY, ccn.xbC);
        AppMethodBeat.m2505o(36359);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(36360);
        C4990ab.m7416i("MicroMsg.NetSceneSnsUserPage", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        ccn ccn = (ccn) ((C7472b) c1929q).fsH.fsP;
        if (c1929q.mo5618ZS().vyl == 207 || c1929q.mo5618ZS().vyl == 203 || c1929q.mo5618ZS().vyl == 0 || c1929q.mo5618ZS().vyl == 2001 || c1929q.mo5618ZS().vyl == 2004 || c1929q.mo5618ZS().vyl == TXLiveConstants.PLAY_EVT_PLAY_PROGRESS || c1929q.mo5618ZS().vyl == 2003) {
            String str2;
            if (c1929q.mo5618ZS().vyl == 2003) {
                C39789o cnF = C13373af.cnF();
                str2 = this.userName;
                boolean hY = cnF.bSd.mo10108hY("SnsInfo", "DELETE FROM SnsInfo" + " where SnsInfo.userName=\"" + C5046bo.m7586vA(str2) + "\"");
                C4990ab.m7410d("MicroMsg.SnsInfoStorage", "del snsinfo " + str2 + " res " + hY);
                Boolean.valueOf(hY);
            }
            this.qKg = ccn.xbV;
            this.qJa = ccn.wZX;
            C4990ab.m7416i("MicroMsg.NetSceneSnsUserPage", "for same md5 count: " + ccn.wZX + " , objCount:  " + ccn.wGG + ", retTips:" + this.qKg);
            this.qKi = ccn.xbT;
            str2 = C29036i.m46118jW(this.qIX);
            if (!this.qIW) {
                C4990ab.m7410d("MicroMsg.NetSceneSnsUserPage", "np  " + ccn.vKB.size());
                if (ccn.vKB.isEmpty()) {
                    this.qKh = c1929q.mo5618ZS().vyl == 203;
                    C13373af.cnF().mo62935d(this.userName, this.czr, str2);
                    this.qJS = true;
                    this.qIY = this.qIX;
                } else {
                    m86429a(ccn, str2);
                }
                C46218aa.m86428XS(this.userName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(36360);
                return;
            } else if (this.qJA.equals(ccn.wZT)) {
                this.qIY = C13373af.cnF().mo62925a(this.qIW ? 0 : this.qJR, this.qJa, this.userName, this.czr);
                C4990ab.m7417i("MicroMsg.NetSceneSnsUserPage", "md5 is nochange the new minid %s", Long.valueOf(this.qIY));
                m86430fj(i2, i3);
                C46218aa.m86428XS(this.userName);
                C29097l YX = C13373af.cnJ().mo69179YX(this.userName);
                this.ehi.onSceneEnd(YX.field_lastFirstPageRequestErrType, YX.field_lastFirstPageRequestErrCode, str, this);
                AppMethodBeat.m2505o(36360);
                return;
            } else {
                String jV;
                String str3;
                C4990ab.m7416i("MicroMsg.NetSceneSnsUserPage", "fp  " + ccn.vKB.size());
                if (this.qIW && !this.qJA.equals(ccn.wZT)) {
                    this.qKe = ccn.xbS;
                    C29097l YX2 = C13373af.cnJ().mo69179YX(this.userName);
                    YX2.field_icount = this.qKe;
                    ccl ccl = ccn.wBZ;
                    if (ccl != null) {
                        jV = C29036i.m46117jV(ccl.gva);
                        String accSnsPath = C13373af.getAccSnsPath();
                        str3 = this.userName + "bg_";
                        String str4 = this.userName + "tbg_";
                        if (YX2.field_bgUrl == null || !YX2.field_bgId.equals(jV)) {
                            YX2.field_older_bgId = YX2.field_bgId;
                            if (C5730e.m8628ct(C3892an.m6198fZ(accSnsPath, this.userName) + str3)) {
                                C5730e.deleteFile(C3892an.m6198fZ(accSnsPath, this.userName) + str4);
                                C5730e.m8633h(C3892an.m6198fZ(accSnsPath, this.userName), str3, str4);
                            }
                            this.qKf = true;
                            YX2.cqI();
                            C4990ab.m7410d("MicroMsg.NetSceneSnsUserPage", "get new  bgid " + ccl.guZ);
                        }
                        YX2.field_bgId = jV;
                        YX2.field_bgUrl = ccl.guZ;
                        YX2.field_snsBgId = ccl.gva;
                    }
                    C13373af.cnJ().mo69180a(YX2);
                }
                C13373af.cnJ().mo69185k(this.userName, ccn.wZT, i2, i3);
                if (c1929q.mo5618ZS().vyl == 207 || c1929q.mo5618ZS().vyl == 2001 || c1929q.mo5618ZS().vyl == 2004 || c1929q.mo5618ZS().vyl == TXLiveConstants.PLAY_EVT_PLAY_PROGRESS) {
                    C13373af.cnJ().mo69183gq(this.userName, "");
                    String str5;
                    if (ccn.vKB.isEmpty()) {
                        C39789o cnF2 = C13373af.cnF();
                        str5 = this.userName;
                        boolean z = this.czr;
                        cnF2.mo62943q(z, C39789o.m68083bm(str5, z) + " AND  (snsId != 0  ) ");
                        this.qIY = this.qIX;
                    } else {
                        C39789o cnF3 = C13373af.cnF();
                        jV = this.userName;
                        boolean z2 = this.czr;
                        str3 = C29036i.m46118jW(((cbf) ccn.vKB.getFirst()).vQE);
                        str5 = C39789o.m68083bm(jV, z2) + " AND  (snsId != 0  ) ";
                        if (C39789o.m68080Zb(str3)) {
                            str5 = str5 + " AND " + cnF3.mo62922Ze(str3);
                        }
                        cnF3.mo62943q(z2, str5);
                        C13373af.cnF().mo62935d(this.userName, this.czr, C29036i.m46118jW(((cbf) ccn.vKB.getLast()).vQE));
                        m86429a(ccn, str2);
                    }
                    m86430fj(i2, i3);
                    C46218aa.m86428XS(this.userName);
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.m2505o(36360);
                    return;
                } else if (ccn.vKB.size() == 0) {
                    C4990ab.m7410d("MicroMsg.NetSceneSnsUserPage", "error: server give size zero");
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.m2505o(36360);
                    return;
                } else {
                    m86429a(ccn, str2);
                    C46218aa.m86428XS(this.userName);
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.m2505o(36360);
                    return;
                }
            }
        }
        C46218aa.m86428XS(this.userName);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(36360);
    }

    public final int getType() {
        return 212;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(36361);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(36361);
        return a;
    }

    public final long cmQ() {
        return this.qIY;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final boolean cmM() {
        return this.qIW;
    }

    public final boolean cmN() {
        return this.qJS;
    }

    public final boolean cmR() {
        return this.qKf;
    }

    public final boolean cmP() {
        return this.qKh;
    }

    public final boolean cmO() {
        return this.qJT;
    }

    public final long cmS() {
        return this.qKi;
    }

    public final String cmT() {
        return this.qKg;
    }
}
