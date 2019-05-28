package com.tencent.p177mm.modelstat.p874a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.modelstat.a.c */
public final class C42218c {

    /* renamed from: com.tencent.mm.modelstat.a.c$1 */
    public static class C97071 implements Runnable {
        final /* synthetic */ Bundle cgJ;

        public C97071(Bundle bundle) {
            this.cgJ = bundle;
        }

        public final void run() {
            AppMethodBeat.m2504i(78810);
            try {
                C37954a c37954a = (C37954a) Class.forName(this.cgJ.getString("mm_event_class")).newInstance();
                C4990ab.m7417i("MicroMsg.WebViewMMReportUtil", "webview callback report className[%s]", this.cgJ.getString("mm_event_class"));
                c37954a.callback(this.cgJ);
                AppMethodBeat.m2505o(78810);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.WebViewMMReportUtil", e, "receiveWebViewCallback error", new Object[0]);
                AppMethodBeat.m2505o(78810);
            }
        }
    }

    /* renamed from: tL */
    public static Bundle m74509tL(String str) {
        AppMethodBeat.m2504i(78811);
        C4990ab.m7419v("MicroMsg.WebViewMMReportUtil", "create webview bundle name[%s]", str);
        Bundle bundle = new Bundle();
        bundle.putString("mm_event_class", str);
        AppMethodBeat.m2505o(78811);
        return bundle;
    }
}
