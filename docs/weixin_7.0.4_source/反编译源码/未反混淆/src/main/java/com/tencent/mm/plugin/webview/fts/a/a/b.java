package com.tencent.mm.plugin.webview.fts.a.a;

import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.da;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.c;
import java.util.List;

public final class b {
    private static final b ugs = new b();
    private a ugt;

    static class a implements Runnable {
        boolean isStopped;
        int lWS = 0;
        List<cvv> list;
        ak mHandler;

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(5769);
            aVar.cWs();
            AppMethodBeat.o(5769);
        }

        public a(List<cvv> list) {
            this.list = list;
        }

        public final void run() {
            AppMethodBeat.i(5767);
            try {
                int i = this.lWS + 1;
                this.lWS = i;
                if (i > this.list.size()) {
                    ab.i("WidgetPkgPreDownloadMgr", "download over, index %d", Integer.valueOf(this.lWS));
                    this.list = null;
                    Thread.currentThread().interrupt();
                    this.mHandler = null;
                    AppMethodBeat.o(5767);
                    return;
                }
                final cvv cvv = (cvv) this.list.get(this.lWS - 1);
                ab.i("WidgetPkgPreDownloadMgr", "try to download pkg appid %s, md5 %s", cvv.csB, cvv.xrN);
                if (cvv != null) {
                    if (TextUtils.isEmpty(cvv.csB) || TextUtils.isEmpty(cvv.xrN) || TextUtils.isEmpty(cvv.xrO)) {
                        ab.e("WidgetPkgPreDownloadMgr", "invalid appinfo");
                        cWs();
                        AppMethodBeat.o(5767);
                        return;
                    }
                    ((g) com.tencent.mm.kernel.g.K(g.class)).a(cvv.csB, cvv.vOP, cvv.xrN, cvv.xrO);
                    if (((g) com.tencent.mm.kernel.g.K(g.class)).S(cvv.csB, cvv.vOP)) {
                        ab.i("WidgetPkgPreDownloadMgr", "pkg exist,run next");
                        cWs();
                        AppMethodBeat.o(5767);
                        return;
                    }
                    ab.i("WidgetPkgPreDownloadMgr", "pkg not exist,starting download");
                    h.pYm.k(918, 1, 1);
                    final long currentTimeMillis = System.currentTimeMillis();
                    ((g) com.tencent.mm.kernel.g.K(g.class)).a(cvv.csB, cvv.vOP, cvv.xrO, new com.tencent.mm.modelappbrand.h() {
                        public final void a(boolean z, long j) {
                            long j2 = 1;
                            AppMethodBeat.i(5766);
                            ab.i("WidgetPkgPreDownloadMgr", "down succ %b", Boolean.valueOf(z));
                            if (z) {
                                h.pYm.k(918, 2, 1);
                            } else {
                                h.pYm.k(918, 3, 1);
                            }
                            a.a(a.this);
                            da ib = new da().ib(cvv.csB);
                            ib.diB = (long) cvv.vOP;
                            ib = ib.ie(cvv.xrO).ic(cvv.xrN);
                            ib.diG = System.currentTimeMillis();
                            if (!z) {
                                j2 = 0;
                            }
                            ib.diE = j2;
                            ib.diF = System.currentTimeMillis() - currentTimeMillis;
                            ib.diH = j;
                            ib.ajK();
                            AppMethodBeat.o(5766);
                        }
                    });
                }
                AppMethodBeat.o(5767);
            } catch (Exception e) {
                ab.printErrStackTrace("WidgetPkgPreDownloadMgr", e, "", new Object[0]);
                AppMethodBeat.o(5767);
            }
        }

        private void cWs() {
            AppMethodBeat.i(5768);
            this.mHandler.postDelayed(this, 500);
            AppMethodBeat.o(5768);
        }
    }

    static {
        AppMethodBeat.i(5772);
        AppMethodBeat.o(5772);
    }

    public static b cWr() {
        return ugs;
    }

    private b() {
    }

    public static boolean a(c cVar) {
        AppMethodBeat.i(5770);
        if ("1".equals(cVar.dru().get("canPreloadWidget"))) {
            AppMethodBeat.o(5770);
            return true;
        }
        ab.i("WidgetPkgPreDownloadMgr", "abtest close preDownload");
        AppMethodBeat.o(5770);
        return false;
    }

    static /* synthetic */ void a(b bVar, List list) {
        AppMethodBeat.i(5771);
        if (list == null) {
            ab.i("WidgetPkgPreDownloadMgr", "empty rsp");
            AppMethodBeat.o(5771);
            return;
        }
        if (bVar.ugt != null) {
            bVar.ugt.isStopped = true;
        }
        bVar.ugt = new a(list);
        a aVar = bVar.ugt;
        aVar.isStopped = false;
        HandlerThread anM = d.anM("WidgetPkgPreDownloadMgr");
        anM.setPriority(1);
        anM.start();
        aVar.mHandler = new ak(anM.getLooper());
        aVar.mHandler.post(aVar);
        ab.i("WidgetPkgPreDownloadMgr", "starting download %d app", Integer.valueOf(aVar.list.size()));
        AppMethodBeat.o(5771);
    }
}
