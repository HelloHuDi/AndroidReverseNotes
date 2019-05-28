package com.tencent.p177mm.plugin.websearch.api;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.protocal.protobuf.bsj;
import com.tencent.p177mm.protocal.protobuf.cht;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.websearch.api.an */
public final class C14423an {
    private static C14424a uaY = new C14424a();

    /* renamed from: com.tencent.mm.plugin.websearch.api.an$a */
    public static class C14424a {
        long ckF;
        long oGj;
        boolean pZZ = true;
        int scene;
        int tZU;
        long uaZ;
        long uba;
    }

    /* renamed from: by */
    public static void m22651by(int i, String str) {
        AppMethodBeat.m2504i(124213);
        C7053e.pXa.mo8374X(i, str);
        AppMethodBeat.m2505o(124213);
    }

    /* renamed from: a */
    public static void m22643a(int i, String str, boolean z, boolean z2, int i2) {
        int i3;
        AppMethodBeat.m2504i(124214);
        if (z) {
            i3 = 3;
        } else if (z2) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        C7053e.pXa.mo8381e(12042, Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(i3), Integer.valueOf(i2), C5046bo.m7532bc(str, "").replace(",", " "));
        AppMethodBeat.m2505o(124214);
    }

    static {
        AppMethodBeat.m2504i(124241);
        AppMethodBeat.m2505o(124241);
    }

    /* renamed from: Ij */
    public static void m22638Ij(int i) {
        AppMethodBeat.m2504i(124215);
        uaY.scene = i;
        uaY.tZU = 1;
        uaY.uaZ = System.currentTimeMillis();
        uaY.uba = 0;
        uaY.oGj = System.currentTimeMillis();
        uaY.ckF = 0;
        uaY.pZZ = false;
        C4990ab.m7419v("MicroMsg.WebSearch.WebSearchReportLogic", "initReport %d %d", Integer.valueOf(i), Integer.valueOf(1));
        AppMethodBeat.m2505o(124215);
    }

    public static void cVv() {
        AppMethodBeat.m2504i(124216);
        uaY.uaZ = System.currentTimeMillis();
        C4990ab.m7419v("MicroMsg.WebSearch.WebSearchReportLogic", "startH5Report %s", Long.valueOf(uaY.uaZ));
        AppMethodBeat.m2505o(124216);
    }

    public static void cVw() {
        AppMethodBeat.m2504i(124217);
        C14424a c14424a = uaY;
        c14424a.uba += System.currentTimeMillis() - uaY.uaZ;
        C4990ab.m7419v("MicroMsg.WebSearch.WebSearchReportLogic", "stopH5Report %s", Long.valueOf(uaY.uba));
        AppMethodBeat.m2505o(124217);
    }

    public static void cVx() {
        AppMethodBeat.m2504i(124218);
        C14424a c14424a = uaY;
        c14424a.ckF += System.currentTimeMillis() - uaY.oGj;
        C4990ab.m7419v("MicroMsg.WebSearch.WebSearchReportLogic", "stopTotalReport %s", Long.valueOf(uaY.ckF));
        AppMethodBeat.m2505o(124218);
    }

    public static void cVy() {
        AppMethodBeat.m2504i(124219);
        C14424a c14424a = uaY;
        if (!c14424a.pZZ) {
            C7053e.pXa.mo8381e(12044, Integer.valueOf(c14424a.scene), Integer.valueOf(c14424a.tZU), Long.valueOf(c14424a.uba / 1000), Long.valueOf(c14424a.ckF / 1000));
            c14424a.pZZ = true;
        }
        C4990ab.m7418v("MicroMsg.WebSearch.WebSearchReportLogic", "reportTime");
        AppMethodBeat.m2505o(124219);
    }

    /* renamed from: Ik */
    public static void m22639Ik(int i) {
        AppMethodBeat.m2504i(124220);
        C4990ab.m7419v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchVisit %d", Integer.valueOf(i));
        C7053e.pXa.mo8381e(12041, Integer.valueOf(i), Integer.valueOf(C46400aa.m87305HV(0)));
        AppMethodBeat.m2505o(124220);
    }

    /* renamed from: a */
    public static void m22642a(int i, int i2, String str, int i3, int i4, String str2, int i5) {
        AppMethodBeat.m2504i(124221);
        C4990ab.m7419v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchGuideDisplay %d %d %s %d %d %s %d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), str2, Integer.valueOf(i5));
        C7053e.pXa.mo8381e(12098, Integer.valueOf(i), Integer.valueOf(C46400aa.m87305HV(0)), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), str2, Integer.valueOf(i5));
        AppMethodBeat.m2505o(124221);
    }

    /* renamed from: l */
    public static void m22656l(String str, int i, int i2, int i3) {
        AppMethodBeat.m2504i(124222);
        C7053e.pXa.mo8381e(12639, C5046bo.m7532bc(str, "").replace(",", " "), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3));
        AppMethodBeat.m2505o(124222);
    }

    /* renamed from: x */
    public static void m22657x(int i, int i2, String str) {
        AppMethodBeat.m2504i(124223);
        C14423an.m22653e(i, i2, str, false);
        AppMethodBeat.m2505o(124223);
    }

    /* renamed from: e */
    public static void m22653e(int i, int i2, String str, boolean z) {
        int i3 = 1;
        AppMethodBeat.m2504i(124224);
        C7053e c7053e = C7053e.pXa;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(0);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = str;
        if (!z) {
            i3 = 0;
        }
        objArr[4] = Integer.valueOf(i3);
        c7053e.mo8381e(12845, objArr);
        AppMethodBeat.m2505o(124224);
    }

    /* renamed from: bz */
    public static void m22652bz(int i, String str) {
        AppMethodBeat.m2504i(124225);
        C7053e.pXa.mo8381e(12070, Integer.valueOf(i), Integer.valueOf(C46400aa.m87305HV(0)), str, Integer.valueOf(4), Integer.valueOf(0), "", Integer.valueOf(1), Integer.valueOf(0));
        AppMethodBeat.m2505o(124225);
    }

    /* renamed from: F */
    public static void m22637F(int i, String str, String str2) {
        AppMethodBeat.m2504i(124226);
        C7053e.pXa.mo8381e(13809, Integer.valueOf(i), str, str2, Integer.valueOf(0));
        AppMethodBeat.m2505o(124226);
    }

    /* renamed from: e */
    public static void m22654e(String str, String str2, int i, String str3) {
        AppMethodBeat.m2504i(124227);
        C4990ab.m7419v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchLocalPageClick %s %s %d %s", str, str2, Integer.valueOf(i), str3);
        C7053e.pXa.mo8381e(14657, Uri.encode(str), str2, Integer.valueOf(i), str3, Integer.valueOf(3));
        AppMethodBeat.m2505o(124227);
    }

    /* renamed from: a */
    public static void m22646a(String str, String str2, long j, String str3) {
        AppMethodBeat.m2504i(124228);
        C4990ab.m7418v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchLocalPageExposure:");
        C7053e.pXa.mo8381e(14663, Uri.encode(str), str2, Long.valueOf(j), str3, Integer.valueOf(3));
        AppMethodBeat.m2505o(124228);
    }

    /* renamed from: b */
    public static void m22650b(int i, String str, String str2, int i2, int i3) {
        AppMethodBeat.m2504i(124229);
        C7053e.pXa.mo8381e(13810, Integer.valueOf(i), str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(0));
        AppMethodBeat.m2505o(124229);
    }

    public static final void adP(String str) {
        AppMethodBeat.m2504i(124230);
        C4990ab.m7419v("MicroMsg.WebSearch.WebSearchReportLogic", "reportWebSuggestClick %s", str);
        C7053e.pXa.mo8374X(12721, str);
        AppMethodBeat.m2505o(124230);
    }

    /* renamed from: Il */
    public static final void m22640Il(int i) {
        AppMethodBeat.m2504i(124231);
        C4990ab.m7419v("MicroMsg.WebSearch.WebSearchReportLogic", "reportIdKey649 %d", Integer.valueOf(i));
        C7053e.pXa.mo8378a(649, (long) i, 1, true);
        AppMethodBeat.m2505o(124231);
    }

    public static final void reportIdKey649ForLook(int i, int i2) {
        AppMethodBeat.m2504i(124232);
        if (i == 21) {
            C7053e.pXa.mo8378a(649, (long) i2, 1, true);
        }
        AppMethodBeat.m2505o(124232);
    }

    /* renamed from: gp */
    public static void m22655gp(int i, int i2) {
        AppMethodBeat.m2504i(124233);
        C14423an.m22658y(i, i2, "");
        AppMethodBeat.m2505o(124233);
    }

    /* renamed from: y */
    public static void m22658y(int i, int i2, String str) {
        AppMethodBeat.m2504i(124234);
        C14423an.m22641a(i, i2, 0, 0, str);
        AppMethodBeat.m2505o(124234);
    }

    /* renamed from: an */
    public static void m22647an(int i, int i2, int i3) {
        AppMethodBeat.m2504i(124235);
        C14423an.m22641a(i, 3, i2, i3, "");
        AppMethodBeat.m2505o(124235);
    }

    /* renamed from: a */
    public static void m22641a(int i, int i2, int i3, int i4, String str) {
        int HV;
        AppMethodBeat.m2504i(124236);
        if (i == 21) {
            HV = C46400aa.m87305HV(1);
        } else {
            HV = C46400aa.m87305HV(0);
        }
        C7053e.pXa.mo8381e(14457, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(HV), Integer.valueOf(i3), Integer.valueOf(i4), str);
        AppMethodBeat.m2505o(124236);
    }

    /* renamed from: as */
    public static void m22648as(String str, String str2, String str3) {
        AppMethodBeat.m2504i(124237);
        C7053e.pXa.mo8381e(14752, Integer.valueOf(1), str, str2, str3);
        AppMethodBeat.m2505o(124237);
    }

    /* renamed from: a */
    public static void m22644a(cht cht, int i, int i2, int i3, long j, String str) {
        AppMethodBeat.m2504i(124238);
        if (cht == null) {
            cht = new cht();
            cht.cJb = "";
            cht.xgz = 0;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("reddotreport=1");
        stringBuffer.append("&reddotid=");
        stringBuffer.append(C5046bo.nullAsNil(cht.cJb));
        stringBuffer.append("&reddotts=");
        stringBuffer.append(cht.xgz);
        stringBuffer.append("&nettype=");
        stringBuffer.append(C46400aa.bVP());
        stringBuffer.append("&optype=");
        stringBuffer.append(i);
        stringBuffer.append("&reddottype=");
        stringBuffer.append(i2);
        stringBuffer.append("&reddotcnt=");
        stringBuffer.append(i3);
        stringBuffer.append("&reddotconsumets=");
        stringBuffer.append(j);
        stringBuffer.append("&notshowreason=");
        stringBuffer.append(str);
        stringBuffer.append("&reddotseq=");
        stringBuffer.append(cht.fQi);
        if (i == 100 || i == 101 || i == 102 || i == 108) {
            int i4;
            int baS;
            if (C5046bo.isNullOrNil((String) C1720g.m3536RP().mo5239Ry().get(68377, null))) {
                i4 = 0;
            } else {
                i4 = 1;
            }
            if (C21877n.qFz != null) {
                baS = C21877n.qFz.baS();
            } else {
                baS = 0;
            }
            if (baS > 0) {
                stringBuffer.append("&snsreddottype=2&snsreddotcnt=").append(baS);
            } else if (i4 > 0) {
                stringBuffer.append("&snsreddottype=1&snsreddotcnt=0");
            } else {
                stringBuffer.append("&snsreddottype=0&snsreddotcnt=0");
            }
        }
        C4990ab.m7417i("MicroMsg.TopStory", "reportTopStoryRedDot 16399 %s", stringBuffer.toString());
        bsj bsj = new bsj();
        bsj.wUu = stringBuffer.toString();
        C1720g.m3540Rg().mo14541a(new C46405w(bsj), 0);
        AppMethodBeat.m2505o(124238);
    }

    /* renamed from: b */
    public static void m22649b(int i, int i2, String str, String str2, boolean z) {
        AppMethodBeat.m2504i(124239);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("recnondocreport=1");
        stringBuffer.append("&type=51");
        stringBuffer.append("&content=");
        stringBuffer.append(i).append("|").append(i2).append("|").append(C5046bo.nullAsNil(str)).append("|").append(z ? 1 : 0);
        stringBuffer.append("&searchid=");
        stringBuffer.append(C5046bo.nullAsNil(str2));
        C4990ab.m7417i("MicroMsg.TopStory", "reportTopStoryRedDot 14791 %s", stringBuffer.toString());
        bsj bsj = new bsj();
        bsj.wUu = stringBuffer.toString();
        C1720g.m3540Rg().mo14541a(new C46405w(bsj), 0);
        AppMethodBeat.m2505o(124239);
    }

    /* renamed from: a */
    public static void m22645a(String str, long j, int i, int i2, String str2, int i3) {
        Object obj;
        int baS;
        int i4;
        int i5;
        AppMethodBeat.m2504i(124240);
        if (C5046bo.isNullOrNil((String) C1720g.m3536RP().mo5239Ry().get(68377, null))) {
            obj = null;
        } else {
            obj = 1;
        }
        if (C21877n.qFz != null) {
            baS = C21877n.qFz.baS();
        } else {
            baS = 0;
        }
        if (baS > 0) {
            i4 = 2;
            i5 = baS;
        } else if (obj > null) {
            i5 = 0;
            i4 = 1;
        } else {
            i5 = 0;
            i4 = 0;
        }
        String format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{str, Long.valueOf(j), C46400aa.bVP(), Integer.valueOf(201), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(0), str2, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i3)});
        C4990ab.m7416i("MicroMsg.WebSearch.WebSearchReportLogic", "reportTopStoryRedDotKv 16654: ".concat(String.valueOf(format)));
        C7053e.pXa.mo8374X(16654, format);
        AppMethodBeat.m2505o(124240);
    }
}
