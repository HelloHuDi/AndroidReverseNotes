package com.tencent.p177mm.plugin.appbrand.appusage.p280a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.p336ui.recommend.C10922e;
import com.tencent.p177mm.protocal.protobuf.C23440sq;
import com.tencent.p177mm.protocal.protobuf.C40552oo;
import com.tencent.p177mm.protocal.protobuf.ank;
import com.tencent.p177mm.protocal.protobuf.anl;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.h */
public class C42370h extends C37440a<anl> {

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.h$a */
    public interface C38124a {
        /* renamed from: a */
        void mo34320a(anl anl);

        void ayb();
    }

    public C42370h(int i, C23440sq c23440sq, long j, int i2) {
        AppMethodBeat.m2504i(129750);
        C4990ab.m7417i("MicroMsg.Recommend.CgiGetRecommendWxa", "pageNum:%d, filterType:%d, sessionId:%d, strategy:%d", Integer.valueOf(i), Integer.valueOf(5), Long.valueOf(j), Integer.valueOf(i2));
        C1196a c1196a = new C1196a();
        ank ank = new ank();
        ank.wsg = i;
        ank.wsh = new C40552oo();
        ank.bHi = j;
        ank.wsi = c23440sq;
        ank.wsj = i2;
        c1196a.fsJ = ank;
        c1196a.fsK = new anl();
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getrecommendwxa";
        c1196a.fsI = 2778;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(129750);
    }

    /* renamed from: a */
    public static void m74961a(int i, C23440sq c23440sq, long j, C38124a c38124a, int i2) {
        AppMethodBeat.m2504i(129751);
        final long currentTimeMillis = System.currentTimeMillis() / 1000;
        final int i3 = i;
        final C23440sq c23440sq2 = c23440sq;
        final long j2 = j;
        final int i4 = i2;
        final C38124a c38124a2 = c38124a;
        C42677e.aNS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(129749);
                new C42370h(i3, c23440sq2, j2, i4) {
                    /* renamed from: a */
                    public final /* synthetic */ void mo21469a(int i, int i2, String str, btd btd, C1207m c1207m) {
                        AppMethodBeat.m2504i(129748);
                        anl anl = (anl) btd;
                        if (C1720g.m3531RK()) {
                            long currentTimeMillis = (System.currentTimeMillis() / 1000) - currentTimeMillis;
                            C4990ab.m7417i("MicroMsg.Recommend.CgiGetRecommendWxa", "CgiGetRecommendWxa errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                            if (i != 0 || i2 != 0) {
                                C4990ab.m7412e("MicroMsg.Recommend.CgiGetRecommendWxa", "fetch fail");
                                if (c38124a2 != null) {
                                    c38124a2.ayb();
                                }
                                C10922e.m18647a(currentTimeMillis, null);
                                AppMethodBeat.m2505o(129748);
                                return;
                            } else if (anl == null) {
                                C4990ab.m7412e("MicroMsg.Recommend.CgiGetRecommendWxa", "response is null");
                                if (c38124a2 != null) {
                                    c38124a2.ayb();
                                }
                                C10922e.m18647a(currentTimeMillis, null);
                                AppMethodBeat.m2505o(129748);
                                return;
                            } else {
                                if (c38124a2 != null) {
                                    C4990ab.m7412e("MicroMsg.Recommend.CgiGetRecommendWxa", "get data success");
                                    c38124a2.mo34320a(anl);
                                    C10922e.m18647a(currentTimeMillis, anl);
                                }
                                AppMethodBeat.m2505o(129748);
                                return;
                            }
                        }
                        C4990ab.m7412e("MicroMsg.Recommend.CgiGetRecommendWxa", "account nor ready");
                        AppMethodBeat.m2505o(129748);
                    }
                }.acy();
                AppMethodBeat.m2505o(129749);
            }
        });
        AppMethodBeat.m2505o(129751);
    }
}
