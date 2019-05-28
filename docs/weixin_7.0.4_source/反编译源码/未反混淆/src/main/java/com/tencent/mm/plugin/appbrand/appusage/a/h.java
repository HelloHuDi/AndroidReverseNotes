package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anl;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.oo;
import com.tencent.mm.protocal.protobuf.sq;
import com.tencent.mm.sdk.platformtools.ab;

public class h extends com.tencent.mm.ai.a<anl> {

    public interface a {
        void a(anl anl);

        void ayb();
    }

    public h(int i, sq sqVar, long j, int i2) {
        AppMethodBeat.i(129750);
        ab.i("MicroMsg.Recommend.CgiGetRecommendWxa", "pageNum:%d, filterType:%d, sessionId:%d, strategy:%d", Integer.valueOf(i), Integer.valueOf(5), Long.valueOf(j), Integer.valueOf(i2));
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        ank ank = new ank();
        ank.wsg = i;
        ank.wsh = new oo();
        ank.bHi = j;
        ank.wsi = sqVar;
        ank.wsj = i2;
        aVar.fsJ = ank;
        aVar.fsK = new anl();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getrecommendwxa";
        aVar.fsI = 2778;
        this.ehh = aVar.acD();
        AppMethodBeat.o(129750);
    }

    public static void a(int i, sq sqVar, long j, a aVar, int i2) {
        AppMethodBeat.i(129751);
        final long currentTimeMillis = System.currentTimeMillis() / 1000;
        final int i3 = i;
        final sq sqVar2 = sqVar;
        final long j2 = j;
        final int i4 = i2;
        final a aVar2 = aVar;
        e.aNS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(129749);
                new h(i3, sqVar2, j2, i4) {
                    public final /* synthetic */ void a(int i, int i2, String str, btd btd, m mVar) {
                        AppMethodBeat.i(129748);
                        anl anl = (anl) btd;
                        if (g.RK()) {
                            long currentTimeMillis = (System.currentTimeMillis() / 1000) - currentTimeMillis;
                            ab.i("MicroMsg.Recommend.CgiGetRecommendWxa", "CgiGetRecommendWxa errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                            if (i != 0 || i2 != 0) {
                                ab.e("MicroMsg.Recommend.CgiGetRecommendWxa", "fetch fail");
                                if (aVar2 != null) {
                                    aVar2.ayb();
                                }
                                com.tencent.mm.plugin.appbrand.ui.recommend.e.a(currentTimeMillis, null);
                                AppMethodBeat.o(129748);
                                return;
                            } else if (anl == null) {
                                ab.e("MicroMsg.Recommend.CgiGetRecommendWxa", "response is null");
                                if (aVar2 != null) {
                                    aVar2.ayb();
                                }
                                com.tencent.mm.plugin.appbrand.ui.recommend.e.a(currentTimeMillis, null);
                                AppMethodBeat.o(129748);
                                return;
                            } else {
                                if (aVar2 != null) {
                                    ab.e("MicroMsg.Recommend.CgiGetRecommendWxa", "get data success");
                                    aVar2.a(anl);
                                    com.tencent.mm.plugin.appbrand.ui.recommend.e.a(currentTimeMillis, anl);
                                }
                                AppMethodBeat.o(129748);
                                return;
                            }
                        }
                        ab.e("MicroMsg.Recommend.CgiGetRecommendWxa", "account nor ready");
                        AppMethodBeat.o(129748);
                    }
                }.acy();
                AppMethodBeat.o(129749);
            }
        });
        AppMethodBeat.o(129751);
    }
}
