package com.tencent.p177mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.hce.p1471a.C33383c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiNFCStartHCE$2 */
class JsApiNFCStartHCE$2 extends ResultReceiver {
    final /* synthetic */ C33381d hSh;

    JsApiNFCStartHCE$2(C33381d c33381d, Handler handler) {
        this.hSh = c33381d;
        super(handler);
    }

    /* Access modifiers changed, original: protected */
    public void onReceiveResult(int i, Bundle bundle) {
        AppMethodBeat.m2504i(137873);
        C4990ab.m7417i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCEUI ResultReceiver resultCode: %d", Integer.valueOf(i));
        if (bundle == null || i != 10001) {
            AppMethodBeat.m2505o(137873);
            return;
        }
        int i2 = bundle.getInt("errCode", -1);
        String string = bundle.getString("errMsg");
        C33381d c33381d = this.hSh;
        C4990ab.m7417i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCEUI onResult errCode: %d, errMsg: %s", Integer.valueOf(i2), string);
        HashMap hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(i2));
        if (i2 == 0) {
            c33381d.onSuccess();
            AppMethodBeat.m2505o(137873);
            return;
        }
        C33383c.m54578G(c33381d.hzz.getAppId(), i2, -1);
        c33381d.mo53857AR(c33381d.mo73394j("fail: ".concat(String.valueOf(string)), hashMap));
        AppMethodBeat.m2505o(137873);
    }
}
