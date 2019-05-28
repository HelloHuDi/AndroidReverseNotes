package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.sq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import java.util.LinkedList;

public final class f {

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.f$1 */
    public static class AnonymousClass1 implements Runnable {
        final /* synthetic */ long hbB;
        final /* synthetic */ LinkedList hbC;
        final /* synthetic */ LinkedList hbD;
        final /* synthetic */ int hbE;
        final /* synthetic */ int hbF;
        final /* synthetic */ int hbG;

        public AnonymousClass1(long j, LinkedList linkedList, LinkedList linkedList2, int i, int i2, int i3) {
            this.hbB = j;
            this.hbC = linkedList;
            this.hbD = linkedList2;
            this.hbE = i;
            this.hbF = i2;
            this.hbG = i3;
        }

        public final void run() {
            AppMethodBeat.i(129743);
            sq sqVar = new sq();
            sqVar.waf = at.getNetTypeString(ah.getContext());
            sqVar.latitude = (double) c.getLatitude();
            sqVar.longitude = (double) c.getLongitude();
            new j(this.hbB, this.hbC, this.hbD, this.hbE, this.hbF, this.hbG, sqVar) {
                public final /* synthetic */ void a(int i, int i2, String str, btd btd, m mVar) {
                    AppMethodBeat.i(129742);
                    if (g.RK()) {
                        ab.i("MicroMsg.Recommend.AppBrandReportRecommendLogic", "CgiReportRecommendWxa errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (!(i == 0 && i2 == 0)) {
                            ab.e("MicroMsg.Recommend.AppBrandReportRecommendLogic", "report fail");
                        }
                        AppMethodBeat.o(129742);
                        return;
                    }
                    ab.e("MicroMsg.Recommend.AppBrandReportRecommendLogic", "account nor ready");
                    AppMethodBeat.o(129742);
                }
            }.acy();
            AppMethodBeat.o(129743);
        }
    }
}
