package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.protocal.protobuf.ani;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.util.concurrent.TimeUnit;

public class g extends a<anj> {
    public g() {
        AppMethodBeat.i(129746);
        ab.i("MicroMsg.Recommend.CgiGetRecallInfo", "CgiGetRecallInfo");
        b.a aVar = new b.a();
        aVar.fsJ = new ani();
        aVar.fsK = new anj();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getrecallinfo";
        this.ehh = aVar.acD();
        AppMethodBeat.o(129746);
    }

    public static void dF(boolean z) {
        AppMethodBeat.i(129747);
        if ((((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_app_brand_recommend_enter_switch, 0) == 1 ? 1 : null) == null) {
            ab.e("MicroMsg.Recommend.CgiGetRecallInfo", "ABTestShowRecommend is not open, labValue:%d", Integer.valueOf(((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_app_brand_recommend_enter_switch, 0)));
            AppMethodBeat.o(129747);
            return;
        }
        long j = (long) AppBrandGlobalSystemConfig.ayC().hgj;
        long longValue = ((Long) com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_APP_BRAND_RECOMMEND_GET_RECALL_INFO_LAST_TIME_LONG_SYNC, Long.valueOf(0))).longValue();
        final long anT = bo.anT();
        long toSeconds = TimeUnit.DAYS.toSeconds(1);
        longValue = anT - longValue;
        ab.i("MicroMsg.Recommend.CgiGetRecallInfo", "weUseRecallInterval:%d, internalTime:%d", Long.valueOf(j), Long.valueOf(longValue));
        if (z || ((j > 0 && longValue >= j) || (j <= 0 && longValue >= toSeconds))) {
            ab.i("MicroMsg.Recommend.CgiGetRecallInfo", "force or It's time to do getRecallInfo");
            e.aNS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(129745);
                    new g() {
                        public final /* synthetic */ void a(int i, int i2, String str, btd btd, m mVar) {
                            AppMethodBeat.i(129744);
                            anj anj = (anj) btd;
                            if (com.tencent.mm.kernel.g.RK()) {
                                ab.i("MicroMsg.Recommend.CgiGetRecallInfo", "CgiGetRecallInfo errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                                if (i != 0 || i2 != 0) {
                                    ab.e("MicroMsg.Recommend.CgiGetRecallInfo", "cgi getRecallInfo fail");
                                    AppMethodBeat.o(129744);
                                    return;
                                } else if (anj == null) {
                                    ab.e("MicroMsg.Recommend.CgiGetRecallInfo", "getRecallInfo response is null");
                                    AppMethodBeat.o(129744);
                                    return;
                                } else {
                                    com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_APP_BRAND_RECOMMEND_GET_RECALL_INFO_LAST_TIME_LONG_SYNC, Long.valueOf(anT));
                                    ab.i("MicroMsg.Recommend.CgiGetRecallInfo", "response.recommend_data_state:%d", Integer.valueOf(anj.wsf));
                                    com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_APP_BRAND_RECOMMEND_DATA_STATE_INT_SYNC, Integer.valueOf(anj.wsf));
                                    AppMethodBeat.o(129744);
                                    return;
                                }
                            }
                            ab.e("MicroMsg.Recommend.CgiGetRecallInfo", "account nor ready");
                            AppMethodBeat.o(129744);
                        }
                    }.acy();
                    AppMethodBeat.o(129745);
                }
            });
            AppMethodBeat.o(129747);
            return;
        }
        ab.i("MicroMsg.Recommend.CgiGetRecallInfo", "time is not exceed one day, not to getRecallInfo");
        AppMethodBeat.o(129747);
    }
}
