package com.tencent.p177mm.plugin.webview.fts.p1327a.p1328a;

import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.C32806h;
import com.tencent.p177mm.modelappbrand.C37934g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p230g.p232b.p233a.C37831da;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.aqy;
import com.tencent.p177mm.protocal.protobuf.cvv;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5141c;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.webview.fts.a.a.b */
public final class C40213b {
    private static final C40213b ugs = new C40213b();
    private C35584a ugt;

    /* renamed from: com.tencent.mm.plugin.webview.fts.a.a.b$a */
    static class C35584a implements Runnable {
        boolean isStopped;
        int lWS = 0;
        List<cvv> list;
        C7306ak mHandler;

        /* renamed from: a */
        static /* synthetic */ void m58414a(C35584a c35584a) {
            AppMethodBeat.m2504i(5769);
            c35584a.cWs();
            AppMethodBeat.m2505o(5769);
        }

        public C35584a(List<cvv> list) {
            this.list = list;
        }

        public final void run() {
            AppMethodBeat.m2504i(5767);
            try {
                int i = this.lWS + 1;
                this.lWS = i;
                if (i > this.list.size()) {
                    C4990ab.m7417i("WidgetPkgPreDownloadMgr", "download over, index %d", Integer.valueOf(this.lWS));
                    this.list = null;
                    Thread.currentThread().interrupt();
                    this.mHandler = null;
                    AppMethodBeat.m2505o(5767);
                    return;
                }
                final cvv cvv = (cvv) this.list.get(this.lWS - 1);
                C4990ab.m7417i("WidgetPkgPreDownloadMgr", "try to download pkg appid %s, md5 %s", cvv.csB, cvv.xrN);
                if (cvv != null) {
                    if (TextUtils.isEmpty(cvv.csB) || TextUtils.isEmpty(cvv.xrN) || TextUtils.isEmpty(cvv.xrO)) {
                        C4990ab.m7412e("WidgetPkgPreDownloadMgr", "invalid appinfo");
                        cWs();
                        AppMethodBeat.m2505o(5767);
                        return;
                    }
                    ((C37934g) C1720g.m3528K(C37934g.class)).mo60694a(cvv.csB, cvv.vOP, cvv.xrN, cvv.xrO);
                    if (((C37934g) C1720g.m3528K(C37934g.class)).mo60693S(cvv.csB, cvv.vOP)) {
                        C4990ab.m7416i("WidgetPkgPreDownloadMgr", "pkg exist,run next");
                        cWs();
                        AppMethodBeat.m2505o(5767);
                        return;
                    }
                    C4990ab.m7416i("WidgetPkgPreDownloadMgr", "pkg not exist,starting download");
                    C7060h.pYm.mo15419k(918, 1, 1);
                    final long currentTimeMillis = System.currentTimeMillis();
                    ((C37934g) C1720g.m3528K(C37934g.class)).mo60695a(cvv.csB, cvv.vOP, cvv.xrO, new C32806h() {
                        /* renamed from: a */
                        public final void mo38378a(boolean z, long j) {
                            long j2 = 1;
                            AppMethodBeat.m2504i(5766);
                            C4990ab.m7417i("WidgetPkgPreDownloadMgr", "down succ %b", Boolean.valueOf(z));
                            if (z) {
                                C7060h.pYm.mo15419k(918, 2, 1);
                            } else {
                                C7060h.pYm.mo15419k(918, 3, 1);
                            }
                            C35584a.m58414a(C35584a.this);
                            C37831da ib = new C37831da().mo60551ib(cvv.csB);
                            ib.diB = (long) cvv.vOP;
                            ib = ib.mo60553ie(cvv.xrO).mo60552ic(cvv.xrN);
                            ib.diG = System.currentTimeMillis();
                            if (!z) {
                                j2 = 0;
                            }
                            ib.diE = j2;
                            ib.diF = System.currentTimeMillis() - currentTimeMillis;
                            ib.diH = j;
                            ib.ajK();
                            AppMethodBeat.m2505o(5766);
                        }
                    });
                }
                AppMethodBeat.m2505o(5767);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("WidgetPkgPreDownloadMgr", e, "", new Object[0]);
                AppMethodBeat.m2505o(5767);
            }
        }

        private void cWs() {
            AppMethodBeat.m2504i(5768);
            this.mHandler.postDelayed(this, 500);
            AppMethodBeat.m2505o(5768);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.a.a.b$1 */
    public class C402141 implements C1224a {
        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(5765);
            C4990ab.m7417i("WidgetPkgPreDownloadMgr", "cgi back errType %d,errCode %d,errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                C40213b.m68969a(C40213b.this, ((aqy) c7472b.fsH.fsP).fjr);
            }
            AppMethodBeat.m2505o(5765);
            return 0;
        }
    }

    static {
        AppMethodBeat.m2504i(5772);
        AppMethodBeat.m2505o(5772);
    }

    public static C40213b cWr() {
        return ugs;
    }

    private C40213b() {
    }

    /* renamed from: a */
    public static boolean m68970a(C5141c c5141c) {
        AppMethodBeat.m2504i(5770);
        if ("1".equals(c5141c.dru().get("canPreloadWidget"))) {
            AppMethodBeat.m2505o(5770);
            return true;
        }
        C4990ab.m7416i("WidgetPkgPreDownloadMgr", "abtest close preDownload");
        AppMethodBeat.m2505o(5770);
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ void m68969a(C40213b c40213b, List list) {
        AppMethodBeat.m2504i(5771);
        if (list == null) {
            C4990ab.m7416i("WidgetPkgPreDownloadMgr", "empty rsp");
            AppMethodBeat.m2505o(5771);
            return;
        }
        if (c40213b.ugt != null) {
            c40213b.ugt.isStopped = true;
        }
        c40213b.ugt = new C35584a(list);
        C35584a c35584a = c40213b.ugt;
        c35584a.isStopped = false;
        HandlerThread anM = C7305d.anM("WidgetPkgPreDownloadMgr");
        anM.setPriority(1);
        anM.start();
        c35584a.mHandler = new C7306ak(anM.getLooper());
        c35584a.mHandler.post(c35584a);
        C4990ab.m7417i("WidgetPkgPreDownloadMgr", "starting download %d app", Integer.valueOf(c35584a.list.size()));
        AppMethodBeat.m2505o(5771);
    }
}
