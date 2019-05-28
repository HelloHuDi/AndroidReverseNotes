package com.tencent.mm.plugin.appbrand;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.game.b;
import com.tencent.mm.plugin.appbrand.page.as;
import com.tencent.mm.plugin.appbrand.ui.e;
import com.tencent.mm.sdk.platformtools.ab;

public final class ad {

    /* renamed from: com.tencent.mm.plugin.appbrand.ad$1 */
    public static class AnonymousClass1 implements Runnable {
        final /* synthetic */ o gQw;
        final /* synthetic */ AppBrandInitConfigWC gQx;

        public AnonymousClass1(o oVar, AppBrandInitConfigWC appBrandInitConfigWC) {
            this.gQw = oVar;
            this.gQx = appBrandInitConfigWC;
        }

        public final void run() {
            AppMethodBeat.i(129149);
            ab.i("MicroMsg.AppBrand.RuntimeRestartHelper", "performRestart OnUiThread appId[%s]", this.gQw.mAppId);
            try {
                e.a(this.gQw, ad.n(this.gQw));
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrand.RuntimeRestartHelper", "performRestart  takeSnapshot appId[%s], e[%s]", this.gQw.mAppId, e);
            }
            this.gQx.bQn = this.gQw.ya().bQn;
            this.gQx.resetSession();
            this.gQw.d(this.gQx);
            AppMethodBeat.o(129149);
        }
    }

    static Bitmap n(i iVar) {
        AppMethodBeat.i(129154);
        Bitmap a;
        if (p.k(iVar)) {
            try {
                a = ((b) iVar.xT()).getMBRuntime().getCanvasHandler().a(null, false);
            } catch (Exception e) {
                a = null;
            }
            AppMethodBeat.o(129154);
            return a;
        }
        a = as.cq(iVar.asV().getCurrentPage());
        AppMethodBeat.o(129154);
        return a;
    }
}
