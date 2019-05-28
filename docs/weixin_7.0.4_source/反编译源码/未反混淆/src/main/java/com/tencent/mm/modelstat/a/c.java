package com.tencent.mm.modelstat.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class c {

    /* renamed from: com.tencent.mm.modelstat.a.c$1 */
    public static class AnonymousClass1 implements Runnable {
        final /* synthetic */ Bundle cgJ;

        public AnonymousClass1(Bundle bundle) {
            this.cgJ = bundle;
        }

        public final void run() {
            AppMethodBeat.i(78810);
            try {
                a aVar = (a) Class.forName(this.cgJ.getString("mm_event_class")).newInstance();
                ab.i("MicroMsg.WebViewMMReportUtil", "webview callback report className[%s]", this.cgJ.getString("mm_event_class"));
                aVar.callback(this.cgJ);
                AppMethodBeat.o(78810);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.WebViewMMReportUtil", e, "receiveWebViewCallback error", new Object[0]);
                AppMethodBeat.o(78810);
            }
        }
    }

    public static Bundle tL(String str) {
        AppMethodBeat.i(78811);
        ab.v("MicroMsg.WebViewMMReportUtil", "create webview bundle name[%s]", str);
        Bundle bundle = new Bundle();
        bundle.putString("mm_event_class", str);
        AppMethodBeat.o(78811);
        return bundle;
    }
}
