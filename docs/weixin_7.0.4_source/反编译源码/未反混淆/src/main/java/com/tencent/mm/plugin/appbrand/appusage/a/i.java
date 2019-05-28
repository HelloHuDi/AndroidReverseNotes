package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.protocal.protobuf.big;
import com.tencent.mm.protocal.protobuf.bow;
import com.tencent.mm.protocal.protobuf.box;
import com.tencent.mm.protocal.protobuf.bqc;
import com.tencent.mm.protocal.protobuf.bqe;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.dn;
import com.tencent.mm.protocal.protobuf.sq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

public class i extends a<box> {
    public i(int i, long j, long j2, AppBrandRecommendStatObj appBrandRecommendStatObj) {
        AppMethodBeat.i(129755);
        this.ehh = a(i, j, j2, appBrandRecommendStatObj).acD();
        AppMethodBeat.o(129755);
    }

    static b.a a(int i, long j, long j2, AppBrandRecommendStatObj appBrandRecommendStatObj) {
        AppMethodBeat.i(129756);
        ab.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "clickType:%d, page_stay_time:%d, app_stay_time:%d, recommendStatObj:%s", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), appBrandRecommendStatObj.toString());
        b.a aVar = new b.a();
        bow bow = new bow();
        bqe bqe = new bqe();
        bqc bqc = new bqc();
        bqe.bHi = appBrandRecommendStatObj.hbj;
        sq sqVar = new sq();
        sqVar.waf = at.getNetTypeString(ah.getContext());
        sqVar.longitude = (double) appBrandRecommendStatObj.cGm;
        sqVar.latitude = (double) appBrandRecommendStatObj.cEB;
        bow.wRt = bqe;
        bow.wRu = bqc;
        bqc.type = i;
        if (i == 1) {
            big big = new big();
            big.username = appBrandRecommendStatObj.username;
            big.izZ = appBrandRecommendStatObj.izZ;
            big.fBq = System.currentTimeMillis();
            big.iAa = appBrandRecommendStatObj.iAa;
            big.csB = appBrandRecommendStatObj.csB;
            big.iAe = appBrandRecommendStatObj.iAe;
            big.position = appBrandRecommendStatObj.position;
            big.wLx = (int) j;
            big.vFr = (int) j2;
            bqc.wSn = big;
        } else {
            dn dnVar = new dn();
            dnVar.username = appBrandRecommendStatObj.username;
            dnVar.fBq = System.currentTimeMillis();
            dnVar.iAa = appBrandRecommendStatObj.iAa;
            dnVar.csB = appBrandRecommendStatObj.csB;
            dnVar.iAe = appBrandRecommendStatObj.iAe;
            dnVar.position = appBrandRecommendStatObj.position;
            dnVar.vFr = (int) j2;
            bqc.wSo = dnVar;
        }
        aVar.fsJ = bow;
        aVar.fsK = new box();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/rtreportrecommdclick";
        aVar.fsI = 2799;
        AppMethodBeat.o(129756);
        return aVar;
    }

    public static void b(int i, long j, long j2, AppBrandRecommendStatObj appBrandRecommendStatObj) {
        AppMethodBeat.i(129757);
        if (appBrandRecommendStatObj == null) {
            AppMethodBeat.o(129757);
            return;
        }
        final int i2 = i;
        final long j3 = j;
        final long j4 = j2;
        final AppBrandRecommendStatObj appBrandRecommendStatObj2 = appBrandRecommendStatObj;
        e.aNS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(129754);
                if (i2 == 1) {
                    com.tencent.mm.ipcinvoker.wx_extension.b.a(i.a(i2, j3, j4, appBrandRecommendStatObj2).acD(), new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
                        public final void a(int i, int i2, String str, b bVar) {
                            AppMethodBeat.i(129752);
                            ab.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "CgiRTReportRecommdClick page click errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                            if (i == 0 && i2 == 0) {
                                ab.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "report success");
                                AppMethodBeat.o(129752);
                                return;
                            }
                            ab.e("MicroMsg.Recommend.CgiRTReportRecommdClick", "report fail");
                            AppMethodBeat.o(129752);
                        }
                    });
                    AppMethodBeat.o(129754);
                    return;
                }
                new i(i2, j3, j4, appBrandRecommendStatObj2) {
                    public final /* synthetic */ void a(int i, int i2, String str, btd btd, m mVar) {
                        AppMethodBeat.i(129753);
                        if (g.RK()) {
                            ab.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "CgiRTReportRecommdClick profile click errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                            if (i == 0 && i2 == 0) {
                                ab.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "report success");
                                AppMethodBeat.o(129753);
                                return;
                            }
                            ab.e("MicroMsg.Recommend.CgiRTReportRecommdClick", "report fail");
                            AppMethodBeat.o(129753);
                            return;
                        }
                        ab.e("MicroMsg.Recommend.CgiRTReportRecommdClick", "account nor ready");
                        AppMethodBeat.o(129753);
                    }
                }.acy();
                AppMethodBeat.o(129754);
            }
        });
        AppMethodBeat.o(129757);
    }
}
