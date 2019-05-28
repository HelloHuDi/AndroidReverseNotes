package com.tencent.p177mm.plugin.appbrand.appusage.p280a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.protocal.protobuf.C23440sq;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.f */
public final class C45519f {

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.f$1 */
    public static class C423691 implements Runnable {
        final /* synthetic */ long hbB;
        final /* synthetic */ LinkedList hbC;
        final /* synthetic */ LinkedList hbD;
        final /* synthetic */ int hbE;
        final /* synthetic */ int hbF;
        final /* synthetic */ int hbG;

        public C423691(long j, LinkedList linkedList, LinkedList linkedList2, int i, int i2, int i3) {
            this.hbB = j;
            this.hbC = linkedList;
            this.hbD = linkedList2;
            this.hbE = i;
            this.hbF = i2;
            this.hbG = i3;
        }

        public final void run() {
            AppMethodBeat.m2504i(129743);
            C23440sq c23440sq = new C23440sq();
            c23440sq.waf = C5023at.getNetTypeString(C4996ah.getContext());
            c23440sq.latitude = (double) C26759c.getLatitude();
            c23440sq.longitude = (double) C26759c.getLongitude();
            new C19102j(this.hbB, this.hbC, this.hbD, this.hbE, this.hbF, this.hbG, c23440sq) {
                /* renamed from: a */
                public final /* synthetic */ void mo21469a(int i, int i2, String str, btd btd, C1207m c1207m) {
                    AppMethodBeat.m2504i(129742);
                    if (C1720g.m3531RK()) {
                        C4990ab.m7417i("MicroMsg.Recommend.AppBrandReportRecommendLogic", "CgiReportRecommendWxa errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (!(i == 0 && i2 == 0)) {
                            C4990ab.m7412e("MicroMsg.Recommend.AppBrandReportRecommendLogic", "report fail");
                        }
                        AppMethodBeat.m2505o(129742);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.Recommend.AppBrandReportRecommendLogic", "account nor ready");
                    AppMethodBeat.m2505o(129742);
                }
            }.acy();
            AppMethodBeat.m2505o(129743);
        }
    }
}
