package com.tencent.p177mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiLuggageStartSoterAuthentication$1 */
class JsApiLuggageStartSoterAuthentication$1 extends ResultReceiver {
    final /* synthetic */ int eIl;
    final /* synthetic */ C2232b hDp;
    final /* synthetic */ C2241c hxc;

    JsApiLuggageStartSoterAuthentication$1(C2232b c2232b, Handler handler, C2241c c2241c, int i) {
        this.hDp = c2232b;
        this.hxc = c2241c;
        this.eIl = i;
        super(handler);
    }

    /* Access modifiers changed, original: protected */
    public void onReceiveResult(int i, Bundle bundle) {
        AppMethodBeat.m2504i(73792);
        C2232b c2232b;
        C2241c c2241c;
        int i2;
        if (i == -1) {
            C4990ab.m7416i("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter auth ok");
            c2232b = this.hDp;
            c2241c = this.hxc;
            i2 = this.eIl;
            if (bundle == null) {
                bundle = null;
            }
            C2232b.m4444a(c2232b, c2241c, i2, bundle, "ok");
            AppMethodBeat.m2505o(73792);
        } else if (i == 1) {
            C4990ab.m7420w("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter auth failed");
            c2232b = this.hDp;
            c2241c = this.hxc;
            i2 = this.eIl;
            if (bundle == null) {
                bundle = null;
            }
            C2232b.m4444a(c2232b, c2241c, i2, bundle, "fail");
            AppMethodBeat.m2505o(73792);
        } else {
            C4990ab.m7412e("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter user cancelled");
            c2232b = this.hDp;
            c2241c = this.hxc;
            i2 = this.eIl;
            if (bundle == null) {
                bundle = null;
            }
            C2232b.m4444a(c2232b, c2241c, i2, bundle, "cancel");
            AppMethodBeat.m2505o(73792);
        }
    }
}
