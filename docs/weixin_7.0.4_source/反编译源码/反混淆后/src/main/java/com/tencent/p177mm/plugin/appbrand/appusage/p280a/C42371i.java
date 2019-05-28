package com.tencent.p177mm.plugin.appbrand.appusage.p280a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b.C9557a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.p177mm.protocal.protobuf.C23440sq;
import com.tencent.p177mm.protocal.protobuf.C40513dn;
import com.tencent.p177mm.protocal.protobuf.big;
import com.tencent.p177mm.protocal.protobuf.bow;
import com.tencent.p177mm.protocal.protobuf.box;
import com.tencent.p177mm.protocal.protobuf.bqc;
import com.tencent.p177mm.protocal.protobuf.bqe;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.i */
public class C42371i extends C37440a<box> {
    public C42371i(int i, long j, long j2, AppBrandRecommendStatObj appBrandRecommendStatObj) {
        AppMethodBeat.m2504i(129755);
        this.ehh = C42371i.m74962a(i, j, j2, appBrandRecommendStatObj).acD();
        AppMethodBeat.m2505o(129755);
    }

    /* renamed from: a */
    static C1196a m74962a(int i, long j, long j2, AppBrandRecommendStatObj appBrandRecommendStatObj) {
        AppMethodBeat.m2504i(129756);
        C4990ab.m7417i("MicroMsg.Recommend.CgiRTReportRecommdClick", "clickType:%d, page_stay_time:%d, app_stay_time:%d, recommendStatObj:%s", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), appBrandRecommendStatObj.toString());
        C1196a c1196a = new C1196a();
        bow bow = new bow();
        bqe bqe = new bqe();
        bqc bqc = new bqc();
        bqe.bHi = appBrandRecommendStatObj.hbj;
        C23440sq c23440sq = new C23440sq();
        c23440sq.waf = C5023at.getNetTypeString(C4996ah.getContext());
        c23440sq.longitude = (double) appBrandRecommendStatObj.cGm;
        c23440sq.latitude = (double) appBrandRecommendStatObj.cEB;
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
            C40513dn c40513dn = new C40513dn();
            c40513dn.username = appBrandRecommendStatObj.username;
            c40513dn.fBq = System.currentTimeMillis();
            c40513dn.iAa = appBrandRecommendStatObj.iAa;
            c40513dn.csB = appBrandRecommendStatObj.csB;
            c40513dn.iAe = appBrandRecommendStatObj.iAe;
            c40513dn.position = appBrandRecommendStatObj.position;
            c40513dn.vFr = (int) j2;
            bqc.wSo = c40513dn;
        }
        c1196a.fsJ = bow;
        c1196a.fsK = new box();
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxabusiness/rtreportrecommdclick";
        c1196a.fsI = 2799;
        AppMethodBeat.m2505o(129756);
        return c1196a;
    }

    /* renamed from: b */
    public static void m74963b(int i, long j, long j2, AppBrandRecommendStatObj appBrandRecommendStatObj) {
        AppMethodBeat.m2504i(129757);
        if (appBrandRecommendStatObj == null) {
            AppMethodBeat.m2505o(129757);
            return;
        }
        final int i2 = i;
        final long j3 = j;
        final long j4 = j2;
        final AppBrandRecommendStatObj appBrandRecommendStatObj2 = appBrandRecommendStatObj;
        C42677e.aNS().mo10302aa(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.i$1$1 */
            class C165841 implements C9557a {
                C165841() {
                }

                /* renamed from: a */
                public final void mo5951a(int i, int i2, String str, C7472b c7472b) {
                    AppMethodBeat.m2504i(129752);
                    C4990ab.m7417i("MicroMsg.Recommend.CgiRTReportRecommdClick", "CgiRTReportRecommdClick page click errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (i == 0 && i2 == 0) {
                        C4990ab.m7416i("MicroMsg.Recommend.CgiRTReportRecommdClick", "report success");
                        AppMethodBeat.m2505o(129752);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.Recommend.CgiRTReportRecommdClick", "report fail");
                    AppMethodBeat.m2505o(129752);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(129754);
                if (i2 == 1) {
                    C42146b.m74301a(C42371i.m74962a(i2, j3, j4, appBrandRecommendStatObj2).acD(), new C165841());
                    AppMethodBeat.m2505o(129754);
                    return;
                }
                new C42371i(i2, j3, j4, appBrandRecommendStatObj2) {
                    /* renamed from: a */
                    public final /* synthetic */ void mo21469a(int i, int i2, String str, btd btd, C1207m c1207m) {
                        AppMethodBeat.m2504i(129753);
                        if (C1720g.m3531RK()) {
                            C4990ab.m7417i("MicroMsg.Recommend.CgiRTReportRecommdClick", "CgiRTReportRecommdClick profile click errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                            if (i == 0 && i2 == 0) {
                                C4990ab.m7416i("MicroMsg.Recommend.CgiRTReportRecommdClick", "report success");
                                AppMethodBeat.m2505o(129753);
                                return;
                            }
                            C4990ab.m7412e("MicroMsg.Recommend.CgiRTReportRecommdClick", "report fail");
                            AppMethodBeat.m2505o(129753);
                            return;
                        }
                        C4990ab.m7412e("MicroMsg.Recommend.CgiRTReportRecommdClick", "account nor ready");
                        AppMethodBeat.m2505o(129753);
                    }
                }.acy();
                AppMethodBeat.m2505o(129754);
            }
        });
        AppMethodBeat.m2505o(129757);
    }
}
