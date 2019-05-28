package com.tencent.mm.plugin.appbrand.game.page;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aq;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.sdk.platformtools.ab;

@SuppressLint({"ViewConstructor"})
public final class e extends r {
    private volatile d hsI = null;

    public e(Context context, o oVar) {
        super(context, oVar);
    }

    public final void af(String str, boolean z) {
        AppMethodBeat.i(130230);
        if (z) {
            getCurrentPage().loadUrl(str);
            try {
                getReporter().a(getCurrentPageView(), null, aq.AUTO_RE_LAUNCH);
                AppMethodBeat.o(130230);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.WAGamePageContainer", "report autoReLaunch, e = %s", e);
                AppMethodBeat.o(130230);
                return;
            }
        }
        ab.e("MicroMsg.WAGamePageContainer", "reLaunch without auto is not support here");
        AppMethodBeat.o(130230);
    }

    public final void Az(final String str) {
        AppMethodBeat.i(130231);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(130228);
                e.this.hsI = new d(e.this.getContext(), e.this);
                e.this.addView(e.this.hsI, 0);
                e.this.hsI.getCurrentPageView().a((com.tencent.mm.plugin.appbrand.jsapi.f.e) new com.tencent.mm.plugin.appbrand.jsapi.f.e() {
                    public final void onReady() {
                        AppMethodBeat.i(130227);
                        e.this.onReady();
                        AppMethodBeat.o(130227);
                    }
                });
                e.this.hsI.loadUrl(str);
                e.this.hsI.a(aq.APP_LAUNCH);
                e.this.hsI.aAS();
                e.this.hsI.aJl();
                try {
                    e.this.getReporter().a(e.this.getCurrentPageView(), null, aq.APP_LAUNCH);
                    AppMethodBeat.o(130228);
                } catch (Exception e) {
                    ab.e("MicroMsg.WAGamePageContainer", "report APP_LAUNCH, e = %s", e);
                    AppMethodBeat.o(130228);
                }
            }
        });
        AppMethodBeat.o(130231);
    }

    public final void onReady() {
        boolean z = true;
        AppMethodBeat.i(130232);
        String str = "MicroMsg.WAGamePageContainer";
        String str2 = "hy: WAGamePageContainer init onReady, runtime alive %b";
        Object[] objArr = new Object[1];
        if (getRuntime() == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        if (getRuntime() != null) {
            super.onReady();
        }
        AppMethodBeat.o(130232);
    }

    public final synchronized d getCurrentPage() {
        return this.hsI;
    }

    public final f getCurrentPageView() {
        AppMethodBeat.i(130233);
        f currentPageView = getCurrentPage().getCurrentPageView();
        AppMethodBeat.o(130233);
        return currentPageView;
    }

    public final void c(String str, String str2, int[] iArr) {
    }

    public final int getPageCount() {
        return 1;
    }

    public final void aAU() {
        AppMethodBeat.i(130234);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(130229);
                g.a(e.this.getAppId(), d.BACK);
                e.this.getRuntime().close();
                AppMethodBeat.o(130229);
            }
        });
        AppMethodBeat.o(130234);
    }

    public final void nU(int i) {
        AppMethodBeat.i(130235);
        aAU();
        AppMethodBeat.o(130235);
    }

    public final void wW() {
        AppMethodBeat.i(130236);
        getCurrentPage().aAT();
        try {
            getReporter().b(getCurrentPageView());
            AppMethodBeat.o(130236);
        } catch (Exception e) {
            ab.e("MicroMsg.WAGamePageContainer", "report background, e = %s", e);
            AppMethodBeat.o(130236);
        }
    }

    public final void wU() {
        AppMethodBeat.i(130237);
        getCurrentPage().aAS();
        try {
            getReporter().c(getCurrentPageView());
            AppMethodBeat.o(130237);
        } catch (Exception e) {
            ab.e("MicroMsg.WAGamePageContainer", "report foreground, e = %s", e);
            AppMethodBeat.o(130237);
        }
    }

    public final void cleanup() {
        AppMethodBeat.i(130238);
        super.cleanup();
        getCurrentPage().aAR();
        getCurrentPage().cleanup();
        this.hsI = null;
        removeAllViews();
        AppMethodBeat.o(130238);
    }

    public final boolean aAV() {
        return false;
    }

    public final boolean aAW() {
        return false;
    }
}
