package com.tencent.p177mm.plugin.appbrand;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.game.C42439b;
import com.tencent.p177mm.plugin.appbrand.p336ui.C38533e;
import com.tencent.p177mm.plugin.appbrand.page.C2413as;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.ad */
public final class C42327ad {

    /* renamed from: com.tencent.mm.plugin.appbrand.ad$1 */
    public static class C423261 implements Runnable {
        final /* synthetic */ C41243o gQw;
        final /* synthetic */ AppBrandInitConfigWC gQx;

        public C423261(C41243o c41243o, AppBrandInitConfigWC appBrandInitConfigWC) {
            this.gQw = c41243o;
            this.gQx = appBrandInitConfigWC;
        }

        public final void run() {
            AppMethodBeat.m2504i(129149);
            C4990ab.m7417i("MicroMsg.AppBrand.RuntimeRestartHelper", "performRestart OnUiThread appId[%s]", this.gQw.mAppId);
            try {
                C38533e.m65260a(this.gQw, C42327ad.m74859n(this.gQw));
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrand.RuntimeRestartHelper", "performRestart  takeSnapshot appId[%s], e[%s]", this.gQw.mAppId, e);
            }
            this.gQx.bQn = this.gQw.mo43491ya().bQn;
            this.gQx.resetSession();
            this.gQw.mo15020d(this.gQx);
            AppMethodBeat.m2505o(129149);
        }
    }

    /* renamed from: n */
    static Bitmap m74859n(C6750i c6750i) {
        AppMethodBeat.m2504i(129154);
        Bitmap a;
        if (C42641p.m75512k(c6750i)) {
            try {
                a = ((C42439b) c6750i.mo15032xT()).getMBRuntime().getCanvasHandler().mo4006a(null, false);
            } catch (Exception e) {
                a = null;
            }
            AppMethodBeat.m2505o(129154);
            return a;
        }
        a = C2413as.m4666cq(c6750i.asV().getCurrentPage());
        AppMethodBeat.m2505o(129154);
        return a;
    }
}
