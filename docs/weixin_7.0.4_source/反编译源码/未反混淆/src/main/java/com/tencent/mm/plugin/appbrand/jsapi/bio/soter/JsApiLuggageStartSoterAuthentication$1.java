package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;

class JsApiLuggageStartSoterAuthentication$1 extends ResultReceiver {
    final /* synthetic */ int eIl;
    final /* synthetic */ b hDp;
    final /* synthetic */ c hxc;

    JsApiLuggageStartSoterAuthentication$1(b bVar, Handler handler, c cVar, int i) {
        this.hDp = bVar;
        this.hxc = cVar;
        this.eIl = i;
        super(handler);
    }

    /* Access modifiers changed, original: protected */
    public void onReceiveResult(int i, Bundle bundle) {
        AppMethodBeat.i(73792);
        b bVar;
        c cVar;
        int i2;
        if (i == -1) {
            ab.i("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter auth ok");
            bVar = this.hDp;
            cVar = this.hxc;
            i2 = this.eIl;
            if (bundle == null) {
                bundle = null;
            }
            b.a(bVar, cVar, i2, bundle, "ok");
            AppMethodBeat.o(73792);
        } else if (i == 1) {
            ab.w("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter auth failed");
            bVar = this.hDp;
            cVar = this.hxc;
            i2 = this.eIl;
            if (bundle == null) {
                bundle = null;
            }
            b.a(bVar, cVar, i2, bundle, "fail");
            AppMethodBeat.o(73792);
        } else {
            ab.e("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter user cancelled");
            bVar = this.hDp;
            cVar = this.hxc;
            i2 = this.eIl;
            if (bundle == null) {
                bundle = null;
            }
            b.a(bVar, cVar, i2, bundle, "cancel");
            AppMethodBeat.o(73792);
        }
    }
}
