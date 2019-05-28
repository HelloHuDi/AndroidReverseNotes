package com.tencent.mm.plugin.websearch.api;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.protocal.protobuf.cht;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class an {
    private static a uaY = new a();

    public static class a {
        long ckF;
        long oGj;
        boolean pZZ = true;
        int scene;
        int tZU;
        long uaZ;
        long uba;
    }

    public static void by(int i, String str) {
        AppMethodBeat.i(124213);
        e.pXa.X(i, str);
        AppMethodBeat.o(124213);
    }

    public static void a(int i, String str, boolean z, boolean z2, int i2) {
        int i3;
        AppMethodBeat.i(124214);
        if (z) {
            i3 = 3;
        } else if (z2) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        e.pXa.e(12042, Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(i3), Integer.valueOf(i2), bo.bc(str, "").replace(",", " "));
        AppMethodBeat.o(124214);
    }

    static {
        AppMethodBeat.i(124241);
        AppMethodBeat.o(124241);
    }

    public static void Ij(int i) {
        AppMethodBeat.i(124215);
        uaY.scene = i;
        uaY.tZU = 1;
        uaY.uaZ = System.currentTimeMillis();
        uaY.uba = 0;
        uaY.oGj = System.currentTimeMillis();
        uaY.ckF = 0;
        uaY.pZZ = false;
        ab.v("MicroMsg.WebSearch.WebSearchReportLogic", "initReport %d %d", Integer.valueOf(i), Integer.valueOf(1));
        AppMethodBeat.o(124215);
    }

    public static void cVv() {
        AppMethodBeat.i(124216);
        uaY.uaZ = System.currentTimeMillis();
        ab.v("MicroMsg.WebSearch.WebSearchReportLogic", "startH5Report %s", Long.valueOf(uaY.uaZ));
        AppMethodBeat.o(124216);
    }

    public static void cVw() {
        AppMethodBeat.i(124217);
        a aVar = uaY;
        aVar.uba += System.currentTimeMillis() - uaY.uaZ;
        ab.v("MicroMsg.WebSearch.WebSearchReportLogic", "stopH5Report %s", Long.valueOf(uaY.uba));
        AppMethodBeat.o(124217);
    }

    public static void cVx() {
        AppMethodBeat.i(124218);
        a aVar = uaY;
        aVar.ckF += System.currentTimeMillis() - uaY.oGj;
        ab.v("MicroMsg.WebSearch.WebSearchReportLogic", "stopTotalReport %s", Long.valueOf(uaY.ckF));
        AppMethodBeat.o(124218);
    }

    public static void cVy() {
        AppMethodBeat.i(124219);
        a aVar = uaY;
        if (!aVar.pZZ) {
            e.pXa.e(12044, Integer.valueOf(aVar.scene), Integer.valueOf(aVar.tZU), Long.valueOf(aVar.uba / 1000), Long.valueOf(aVar.ckF / 1000));
            aVar.pZZ = true;
        }
        ab.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportTime");
        AppMethodBeat.o(124219);
    }

    public static void Ik(int i) {
        AppMethodBeat.i(124220);
        ab.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchVisit %d", Integer.valueOf(i));
        e.pXa.e(12041, Integer.valueOf(i), Integer.valueOf(aa.HV(0)));
        AppMethodBeat.o(124220);
    }

    public static void a(int i, int i2, String str, int i3, int i4, String str2, int i5) {
        AppMethodBeat.i(124221);
        ab.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchGuideDisplay %d %d %s %d %d %s %d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), str2, Integer.valueOf(i5));
        e.pXa.e(12098, Integer.valueOf(i), Integer.valueOf(aa.HV(0)), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), str2, Integer.valueOf(i5));
        AppMethodBeat.o(124221);
    }

    public static void l(String str, int i, int i2, int i3) {
        AppMethodBeat.i(124222);
        e.pXa.e(12639, bo.bc(str, "").replace(",", " "), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3));
        AppMethodBeat.o(124222);
    }

    public static void x(int i, int i2, String str) {
        AppMethodBeat.i(124223);
        e(i, i2, str, false);
        AppMethodBeat.o(124223);
    }

    public static void e(int i, int i2, String str, boolean z) {
        int i3 = 1;
        AppMethodBeat.i(124224);
        e eVar = e.pXa;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(0);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = str;
        if (!z) {
            i3 = 0;
        }
        objArr[4] = Integer.valueOf(i3);
        eVar.e(12845, objArr);
        AppMethodBeat.o(124224);
    }

    public static void bz(int i, String str) {
        AppMethodBeat.i(124225);
        e.pXa.e(12070, Integer.valueOf(i), Integer.valueOf(aa.HV(0)), str, Integer.valueOf(4), Integer.valueOf(0), "", Integer.valueOf(1), Integer.valueOf(0));
        AppMethodBeat.o(124225);
    }

    public static void F(int i, String str, String str2) {
        AppMethodBeat.i(124226);
        e.pXa.e(13809, Integer.valueOf(i), str, str2, Integer.valueOf(0));
        AppMethodBeat.o(124226);
    }

    public static void e(String str, String str2, int i, String str3) {
        AppMethodBeat.i(124227);
        ab.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchLocalPageClick %s %s %d %s", str, str2, Integer.valueOf(i), str3);
        e.pXa.e(14657, Uri.encode(str), str2, Integer.valueOf(i), str3, Integer.valueOf(3));
        AppMethodBeat.o(124227);
    }

    public static void a(String str, String str2, long j, String str3) {
        AppMethodBeat.i(124228);
        ab.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchLocalPageExposure:");
        e.pXa.e(14663, Uri.encode(str), str2, Long.valueOf(j), str3, Integer.valueOf(3));
        AppMethodBeat.o(124228);
    }

    public static void b(int i, String str, String str2, int i2, int i3) {
        AppMethodBeat.i(124229);
        e.pXa.e(13810, Integer.valueOf(i), str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(0));
        AppMethodBeat.o(124229);
    }

    public static final void adP(String str) {
        AppMethodBeat.i(124230);
        ab.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportWebSuggestClick %s", str);
        e.pXa.X(12721, str);
        AppMethodBeat.o(124230);
    }

    public static final void Il(int i) {
        AppMethodBeat.i(124231);
        ab.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportIdKey649 %d", Integer.valueOf(i));
        e.pXa.a(649, (long) i, 1, true);
        AppMethodBeat.o(124231);
    }

    public static final void reportIdKey649ForLook(int i, int i2) {
        AppMethodBeat.i(124232);
        if (i == 21) {
            e.pXa.a(649, (long) i2, 1, true);
        }
        AppMethodBeat.o(124232);
    }

    public static void gp(int i, int i2) {
        AppMethodBeat.i(124233);
        y(i, i2, "");
        AppMethodBeat.o(124233);
    }

    public static void y(int i, int i2, String str) {
        AppMethodBeat.i(124234);
        a(i, i2, 0, 0, str);
        AppMethodBeat.o(124234);
    }

    public static void an(int i, int i2, int i3) {
        AppMethodBeat.i(124235);
        a(i, 3, i2, i3, "");
        AppMethodBeat.o(124235);
    }

    public static void a(int i, int i2, int i3, int i4, String str) {
        int HV;
        AppMethodBeat.i(124236);
        if (i == 21) {
            HV = aa.HV(1);
        } else {
            HV = aa.HV(0);
        }
        e.pXa.e(14457, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(HV), Integer.valueOf(i3), Integer.valueOf(i4), str);
        AppMethodBeat.o(124236);
    }

    public static void as(String str, String str2, String str3) {
        AppMethodBeat.i(124237);
        e.pXa.e(14752, Integer.valueOf(1), str, str2, str3);
        AppMethodBeat.o(124237);
    }

    public static void a(cht cht, int i, int i2, int i3, long j, String str) {
        AppMethodBeat.i(124238);
        if (cht == null) {
            cht = new cht();
            cht.cJb = "";
            cht.xgz = 0;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("reddotreport=1");
        stringBuffer.append("&reddotid=");
        stringBuffer.append(bo.nullAsNil(cht.cJb));
        stringBuffer.append("&reddotts=");
        stringBuffer.append(cht.xgz);
        stringBuffer.append("&nettype=");
        stringBuffer.append(aa.bVP());
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
            if (bo.isNullOrNil((String) g.RP().Ry().get(68377, null))) {
                i4 = 0;
            } else {
                i4 = 1;
            }
            if (n.qFz != null) {
                baS = n.qFz.baS();
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
        ab.i("MicroMsg.TopStory", "reportTopStoryRedDot 16399 %s", stringBuffer.toString());
        bsj bsj = new bsj();
        bsj.wUu = stringBuffer.toString();
        g.Rg().a(new w(bsj), 0);
        AppMethodBeat.o(124238);
    }

    public static void b(int i, int i2, String str, String str2, boolean z) {
        AppMethodBeat.i(124239);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("recnondocreport=1");
        stringBuffer.append("&type=51");
        stringBuffer.append("&content=");
        stringBuffer.append(i).append("|").append(i2).append("|").append(bo.nullAsNil(str)).append("|").append(z ? 1 : 0);
        stringBuffer.append("&searchid=");
        stringBuffer.append(bo.nullAsNil(str2));
        ab.i("MicroMsg.TopStory", "reportTopStoryRedDot 14791 %s", stringBuffer.toString());
        bsj bsj = new bsj();
        bsj.wUu = stringBuffer.toString();
        g.Rg().a(new w(bsj), 0);
        AppMethodBeat.o(124239);
    }

    public static void a(String str, long j, int i, int i2, String str2, int i3) {
        Object obj;
        int baS;
        int i4;
        int i5;
        AppMethodBeat.i(124240);
        if (bo.isNullOrNil((String) g.RP().Ry().get(68377, null))) {
            obj = null;
        } else {
            obj = 1;
        }
        if (n.qFz != null) {
            baS = n.qFz.baS();
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
        String format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{str, Long.valueOf(j), aa.bVP(), Integer.valueOf(201), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(0), str2, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i3)});
        ab.i("MicroMsg.WebSearch.WebSearchReportLogic", "reportTopStoryRedDotKv 16654: ".concat(String.valueOf(format)));
        e.pXa.X(16654, format);
        AppMethodBeat.o(124240);
    }
}
