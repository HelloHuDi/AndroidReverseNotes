package com.tencent.p177mm.plugin.appbrand.appusage.p280a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.protocal.protobuf.ani;
import com.tencent.p177mm.protocal.protobuf.anj;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.g */
public class C41223g extends C37440a<anj> {
    public C41223g() {
        AppMethodBeat.m2504i(129746);
        C4990ab.m7416i("MicroMsg.Recommend.CgiGetRecallInfo", "CgiGetRecallInfo");
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ani();
        c1196a.fsK = new anj();
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getrecallinfo";
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(129746);
    }

    /* renamed from: dF */
    public static void m71760dF(boolean z) {
        AppMethodBeat.m2504i(129747);
        if ((((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_app_brand_recommend_enter_switch, 0) == 1 ? 1 : null) == null) {
            C4990ab.m7413e("MicroMsg.Recommend.CgiGetRecallInfo", "ABTestShowRecommend is not open, labValue:%d", Integer.valueOf(((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_app_brand_recommend_enter_switch, 0)));
            AppMethodBeat.m2505o(129747);
            return;
        }
        long j = (long) AppBrandGlobalSystemConfig.ayC().hgj;
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_RECOMMEND_GET_RECALL_INFO_LAST_TIME_LONG_SYNC, Long.valueOf(0))).longValue();
        final long anT = C5046bo.anT();
        long toSeconds = TimeUnit.DAYS.toSeconds(1);
        longValue = anT - longValue;
        C4990ab.m7417i("MicroMsg.Recommend.CgiGetRecallInfo", "weUseRecallInterval:%d, internalTime:%d", Long.valueOf(j), Long.valueOf(longValue));
        if (z || ((j > 0 && longValue >= j) || (j <= 0 && longValue >= toSeconds))) {
            C4990ab.m7416i("MicroMsg.Recommend.CgiGetRecallInfo", "force or It's time to do getRecallInfo");
            C42677e.aNS().mo10302aa(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.g$1$1 */
                class C267621 extends C41223g {
                    C267621() {
                    }

                    /* renamed from: a */
                    public final /* synthetic */ void mo21469a(int i, int i2, String str, btd btd, C1207m c1207m) {
                        AppMethodBeat.m2504i(129744);
                        anj anj = (anj) btd;
                        if (C1720g.m3531RK()) {
                            C4990ab.m7417i("MicroMsg.Recommend.CgiGetRecallInfo", "CgiGetRecallInfo errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                            if (i != 0 || i2 != 0) {
                                C4990ab.m7412e("MicroMsg.Recommend.CgiGetRecallInfo", "cgi getRecallInfo fail");
                                AppMethodBeat.m2505o(129744);
                                return;
                            } else if (anj == null) {
                                C4990ab.m7412e("MicroMsg.Recommend.CgiGetRecallInfo", "getRecallInfo response is null");
                                AppMethodBeat.m2505o(129744);
                                return;
                            } else {
                                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_RECOMMEND_GET_RECALL_INFO_LAST_TIME_LONG_SYNC, Long.valueOf(anT));
                                C4990ab.m7417i("MicroMsg.Recommend.CgiGetRecallInfo", "response.recommend_data_state:%d", Integer.valueOf(anj.wsf));
                                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_RECOMMEND_DATA_STATE_INT_SYNC, Integer.valueOf(anj.wsf));
                                AppMethodBeat.m2505o(129744);
                                return;
                            }
                        }
                        C4990ab.m7412e("MicroMsg.Recommend.CgiGetRecallInfo", "account nor ready");
                        AppMethodBeat.m2505o(129744);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(129745);
                    new C267621().acy();
                    AppMethodBeat.m2505o(129745);
                }
            });
            AppMethodBeat.m2505o(129747);
            return;
        }
        C4990ab.m7416i("MicroMsg.Recommend.CgiGetRecallInfo", "time is not exceed one day, not to getRecallInfo");
        AppMethodBeat.m2505o(129747);
    }
}
