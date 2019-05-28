package com.tencent.p177mm.plugin.appbrand.game.page;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C45595e;
import com.tencent.p177mm.plugin.appbrand.page.C2412aq;
import com.tencent.p177mm.plugin.appbrand.page.C45665r;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.tencent.mm.plugin.appbrand.game.page.e */
public final class C10244e extends C45665r {
    private volatile C10243d hsI = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.game.page.e$2 */
    class C102472 implements Runnable {
        C102472() {
        }

        public final void run() {
            AppMethodBeat.m2504i(130229);
            C33183g.m54275a(C10244e.this.getAppId(), C33184d.BACK);
            C10244e.this.getRuntime().close();
            AppMethodBeat.m2505o(130229);
        }
    }

    public C10244e(Context context, C41243o c41243o) {
        super(context, c41243o);
    }

    /* renamed from: af */
    public final void mo21671af(String str, boolean z) {
        AppMethodBeat.m2504i(130230);
        if (z) {
            getCurrentPage().loadUrl(str);
            try {
                getReporter().mo6358a(getCurrentPageView(), null, C2412aq.AUTO_RE_LAUNCH);
                AppMethodBeat.m2505o(130230);
                return;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.WAGamePageContainer", "report autoReLaunch, e = %s", e);
                AppMethodBeat.m2505o(130230);
                return;
            }
        }
        C4990ab.m7412e("MicroMsg.WAGamePageContainer", "reLaunch without auto is not support here");
        AppMethodBeat.m2505o(130230);
    }

    /* renamed from: Az */
    public final void mo21667Az(final String str) {
        AppMethodBeat.m2504i(130231);
        runOnUiThread(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.appbrand.game.page.e$1$1 */
            class C102461 implements C45595e {
                C102461() {
                }

                public final void onReady() {
                    AppMethodBeat.m2504i(130227);
                    C10244e.this.onReady();
                    AppMethodBeat.m2505o(130227);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(130228);
                C10244e.this.hsI = new C10243d(C10244e.this.getContext(), C10244e.this);
                C10244e.this.addView(C10244e.this.hsI, 0);
                C10244e.this.hsI.getCurrentPageView().mo68074a((C45595e) new C102461());
                C10244e.this.hsI.loadUrl(str);
                C10244e.this.hsI.mo34865a(C2412aq.APP_LAUNCH);
                C10244e.this.hsI.aAS();
                C10244e.this.hsI.aJl();
                try {
                    C10244e.this.getReporter().mo6358a(C10244e.this.getCurrentPageView(), null, C2412aq.APP_LAUNCH);
                    AppMethodBeat.m2505o(130228);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.WAGamePageContainer", "report APP_LAUNCH, e = %s", e);
                    AppMethodBeat.m2505o(130228);
                }
            }
        });
        AppMethodBeat.m2505o(130231);
    }

    public final void onReady() {
        boolean z = true;
        AppMethodBeat.m2504i(130232);
        String str = "MicroMsg.WAGamePageContainer";
        String str2 = "hy: WAGamePageContainer init onReady, runtime alive %b";
        Object[] objArr = new Object[1];
        if (getRuntime() == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        if (getRuntime() != null) {
            super.onReady();
        }
        AppMethodBeat.m2505o(130232);
    }

    public final synchronized C10243d getCurrentPage() {
        return this.hsI;
    }

    public final C33204f getCurrentPageView() {
        AppMethodBeat.m2504i(130233);
        C33204f currentPageView = getCurrentPage().getCurrentPageView();
        AppMethodBeat.m2505o(130233);
        return currentPageView;
    }

    /* renamed from: c */
    public final void mo21672c(String str, String str2, int[] iArr) {
    }

    public final int getPageCount() {
        return 1;
    }

    public final void aAU() {
        AppMethodBeat.m2504i(130234);
        runOnUiThread(new C102472());
        AppMethodBeat.m2505o(130234);
    }

    /* renamed from: nU */
    public final void mo21677nU(int i) {
        AppMethodBeat.m2504i(130235);
        aAU();
        AppMethodBeat.m2505o(130235);
    }

    /* renamed from: wW */
    public final void mo21680wW() {
        AppMethodBeat.m2504i(130236);
        getCurrentPage().aAT();
        try {
            getReporter().mo6359b(getCurrentPageView());
            AppMethodBeat.m2505o(130236);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WAGamePageContainer", "report background, e = %s", e);
            AppMethodBeat.m2505o(130236);
        }
    }

    /* renamed from: wU */
    public final void mo21679wU() {
        AppMethodBeat.m2504i(130237);
        getCurrentPage().aAS();
        try {
            getReporter().mo6360c(getCurrentPageView());
            AppMethodBeat.m2505o(130237);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WAGamePageContainer", "report foreground, e = %s", e);
            AppMethodBeat.m2505o(130237);
        }
    }

    public final void cleanup() {
        AppMethodBeat.m2504i(130238);
        super.cleanup();
        getCurrentPage().aAR();
        getCurrentPage().cleanup();
        this.hsI = null;
        removeAllViews();
        AppMethodBeat.m2505o(130238);
    }

    public final boolean aAV() {
        return false;
    }

    public final boolean aAW() {
        return false;
    }
}
