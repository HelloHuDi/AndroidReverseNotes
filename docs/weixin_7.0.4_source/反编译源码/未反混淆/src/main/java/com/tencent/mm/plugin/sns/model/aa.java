package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.protocal.protobuf.ccm;
import com.tencent.mm.protocal.protobuf.ccn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Vector;

public final class aa extends m implements k, d {
    private static Vector<String> qKd = new Vector();
    private final int cvp;
    private boolean czr;
    private b ehh;
    public f ehi;
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
        AppMethodBeat.i(36362);
        AppMethodBeat.o(36362);
    }

    public static synchronized boolean XR(String str) {
        boolean z;
        synchronized (aa.class) {
            AppMethodBeat.i(36355);
            if (qKd.contains(str)) {
                z = false;
                AppMethodBeat.o(36355);
            } else {
                qKd.add(str);
                z = true;
                AppMethodBeat.o(36355);
            }
        }
        return z;
    }

    public static synchronized boolean XS(String str) {
        synchronized (aa.class) {
            AppMethodBeat.i(36356);
            qKd.remove(str);
            AppMethodBeat.o(36356);
        }
        return true;
    }

    public aa(String str, long j, boolean z, int i) {
        long j2 = 0;
        boolean z2 = false;
        AppMethodBeat.i(36357);
        this.userName = str;
        this.qIX = j;
        this.czr = z;
        if (j == 0) {
            ab.i("MicroMsg.NetSceneSnsUserPage", "fp userName ".concat(String.valueOf(str)));
        } else {
            ab.i("MicroMsg.NetSceneSnsUserPage", "np userName ".concat(String.valueOf(str)));
        }
        this.cvp = z ? 4 : 8;
        a aVar = new a();
        aVar.fsJ = new ccm();
        aVar.fsK = new ccn();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsuserpage";
        aVar.fsI = 212;
        aVar.fsL = 99;
        aVar.fsM = 1000000099;
        this.ehh = aVar.acD();
        ccm ccm = (ccm) this.ehh.fsG.fsP;
        ccm.vHl = str;
        ccm.wZU = j;
        if (j == 0) {
            z2 = true;
        }
        this.qIW = z2;
        int Yc = af.cnv().Yc(str);
        o cnF = af.cnF();
        if (!this.qIW) {
            j2 = j;
        }
        this.qIY = cnF.a(j2, Yc, str, z);
        ccm.xbw = this.qIY;
        int a = c.a(this.qIY, j, str);
        ccm.xbx = a;
        ccm.vFH = i;
        if (this.qIW) {
            this.qJA = af.cnJ().YX(str).field_md5;
            if (this.qJA == null) {
                this.qJA = "";
            }
            ccm.wZT = this.qJA;
        }
        this.qJR = j;
        ab.i("MicroMsg.NetSceneSnsUserPage", "nextCount: " + Yc + " maxId:" + i.jV(j) + " minId:" + i.jV(this.qIY) + " lastReqTime:" + a + " snsSource " + i);
        AppMethodBeat.o(36357);
    }

    private void fj(int i, int i2) {
        AppMethodBeat.i(138379);
        o cnF = af.cnF();
        String str = this.userName;
        boolean z = this.czr;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select snsId from SnsInfo ").append(o.bm(str, z)).append(" AND type in ( 1,2 , 3 , 4 , 18 , 5 , 12 , 9 , 14 , 15 , 13 , 21 , 25 , 26) and  (snsId != 0  )  limit 4");
        Cursor rawQuery = cnF.bSd.rawQuery(stringBuilder.toString(), null);
        int count = rawQuery.getCount();
        rawQuery.close();
        if (count > 3 || count <= 0 || i != 0 || i2 != 0) {
            if (count == 0) {
                this.qJS = true;
            }
            AppMethodBeat.o(138379);
            return;
        }
        this.qJT = true;
        AppMethodBeat.o(138379);
    }

    private void a(ccn ccn, String str) {
        AppMethodBeat.i(36359);
        aj.a(this.userName, this.cvp, ccn.vKB, str);
        if (this.qIX == 0) {
            this.qIX = ((cbf) ccn.vKB.getFirst()).vQE;
        } else {
            this.qIX = c.ka(this.qIX);
        }
        this.qIY = ((cbf) ccn.vKB.getLast()).vQE;
        ab.i("MicroMsg.NetSceneSnsUserPage", "insertListAndUpdateFaultInfo userName %s maxId %s minId %s NewRequestTime %s", this.userName, Long.valueOf(this.qIX), Long.valueOf(this.qIY), Integer.valueOf(ccn.xbC));
        c.f(this.userName, this.qIX, this.qIY, ccn.xbC);
        AppMethodBeat.o(36359);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(36360);
        ab.i("MicroMsg.NetSceneSnsUserPage", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        ccn ccn = (ccn) ((b) qVar).fsH.fsP;
        if (qVar.ZS().vyl == 207 || qVar.ZS().vyl == 203 || qVar.ZS().vyl == 0 || qVar.ZS().vyl == 2001 || qVar.ZS().vyl == 2004 || qVar.ZS().vyl == TXLiveConstants.PLAY_EVT_PLAY_PROGRESS || qVar.ZS().vyl == 2003) {
            String str2;
            if (qVar.ZS().vyl == 2003) {
                o cnF = af.cnF();
                str2 = this.userName;
                boolean hY = cnF.bSd.hY("SnsInfo", "DELETE FROM SnsInfo" + " where SnsInfo.userName=\"" + bo.vA(str2) + "\"");
                ab.d("MicroMsg.SnsInfoStorage", "del snsinfo " + str2 + " res " + hY);
                Boolean.valueOf(hY);
            }
            this.qKg = ccn.xbV;
            this.qJa = ccn.wZX;
            ab.i("MicroMsg.NetSceneSnsUserPage", "for same md5 count: " + ccn.wZX + " , objCount:  " + ccn.wGG + ", retTips:" + this.qKg);
            this.qKi = ccn.xbT;
            str2 = i.jW(this.qIX);
            if (!this.qIW) {
                ab.d("MicroMsg.NetSceneSnsUserPage", "np  " + ccn.vKB.size());
                if (ccn.vKB.isEmpty()) {
                    this.qKh = qVar.ZS().vyl == 203;
                    af.cnF().d(this.userName, this.czr, str2);
                    this.qJS = true;
                    this.qIY = this.qIX;
                } else {
                    a(ccn, str2);
                }
                XS(this.userName);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(36360);
                return;
            } else if (this.qJA.equals(ccn.wZT)) {
                this.qIY = af.cnF().a(this.qIW ? 0 : this.qJR, this.qJa, this.userName, this.czr);
                ab.i("MicroMsg.NetSceneSnsUserPage", "md5 is nochange the new minid %s", Long.valueOf(this.qIY));
                fj(i2, i3);
                XS(this.userName);
                l YX = af.cnJ().YX(this.userName);
                this.ehi.onSceneEnd(YX.field_lastFirstPageRequestErrType, YX.field_lastFirstPageRequestErrCode, str, this);
                AppMethodBeat.o(36360);
                return;
            } else {
                String jV;
                String str3;
                ab.i("MicroMsg.NetSceneSnsUserPage", "fp  " + ccn.vKB.size());
                if (this.qIW && !this.qJA.equals(ccn.wZT)) {
                    this.qKe = ccn.xbS;
                    l YX2 = af.cnJ().YX(this.userName);
                    YX2.field_icount = this.qKe;
                    ccl ccl = ccn.wBZ;
                    if (ccl != null) {
                        jV = i.jV(ccl.gva);
                        String accSnsPath = af.getAccSnsPath();
                        str3 = this.userName + "bg_";
                        String str4 = this.userName + "tbg_";
                        if (YX2.field_bgUrl == null || !YX2.field_bgId.equals(jV)) {
                            YX2.field_older_bgId = YX2.field_bgId;
                            if (e.ct(an.fZ(accSnsPath, this.userName) + str3)) {
                                e.deleteFile(an.fZ(accSnsPath, this.userName) + str4);
                                e.h(an.fZ(accSnsPath, this.userName), str3, str4);
                            }
                            this.qKf = true;
                            YX2.cqI();
                            ab.d("MicroMsg.NetSceneSnsUserPage", "get new  bgid " + ccl.guZ);
                        }
                        YX2.field_bgId = jV;
                        YX2.field_bgUrl = ccl.guZ;
                        YX2.field_snsBgId = ccl.gva;
                    }
                    af.cnJ().a(YX2);
                }
                af.cnJ().k(this.userName, ccn.wZT, i2, i3);
                if (qVar.ZS().vyl == 207 || qVar.ZS().vyl == 2001 || qVar.ZS().vyl == 2004 || qVar.ZS().vyl == TXLiveConstants.PLAY_EVT_PLAY_PROGRESS) {
                    af.cnJ().gq(this.userName, "");
                    String str5;
                    if (ccn.vKB.isEmpty()) {
                        o cnF2 = af.cnF();
                        str5 = this.userName;
                        boolean z = this.czr;
                        cnF2.q(z, o.bm(str5, z) + " AND  (snsId != 0  ) ");
                        this.qIY = this.qIX;
                    } else {
                        o cnF3 = af.cnF();
                        jV = this.userName;
                        boolean z2 = this.czr;
                        str3 = i.jW(((cbf) ccn.vKB.getFirst()).vQE);
                        str5 = o.bm(jV, z2) + " AND  (snsId != 0  ) ";
                        if (o.Zb(str3)) {
                            str5 = str5 + " AND " + cnF3.Ze(str3);
                        }
                        cnF3.q(z2, str5);
                        af.cnF().d(this.userName, this.czr, i.jW(((cbf) ccn.vKB.getLast()).vQE));
                        a(ccn, str2);
                    }
                    fj(i2, i3);
                    XS(this.userName);
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.o(36360);
                    return;
                } else if (ccn.vKB.size() == 0) {
                    ab.d("MicroMsg.NetSceneSnsUserPage", "error: server give size zero");
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.o(36360);
                    return;
                } else {
                    a(ccn, str2);
                    XS(this.userName);
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.o(36360);
                    return;
                }
            }
        }
        XS(this.userName);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(36360);
    }

    public final int getType() {
        return 212;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(36361);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(36361);
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
