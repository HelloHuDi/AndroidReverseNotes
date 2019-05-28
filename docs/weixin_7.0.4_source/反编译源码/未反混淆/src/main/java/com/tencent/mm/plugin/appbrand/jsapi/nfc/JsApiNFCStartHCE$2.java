package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

class JsApiNFCStartHCE$2 extends ResultReceiver {
    final /* synthetic */ d hSh;

    JsApiNFCStartHCE$2(d dVar, Handler handler) {
        this.hSh = dVar;
        super(handler);
    }

    /* Access modifiers changed, original: protected */
    public void onReceiveResult(int i, Bundle bundle) {
        AppMethodBeat.i(137873);
        ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCEUI ResultReceiver resultCode: %d", Integer.valueOf(i));
        if (bundle == null || i != 10001) {
            AppMethodBeat.o(137873);
            return;
        }
        int i2 = bundle.getInt("errCode", -1);
        String string = bundle.getString("errMsg");
        d dVar = this.hSh;
        ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCEUI onResult errCode: %d, errMsg: %s", Integer.valueOf(i2), string);
        HashMap hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(i2));
        if (i2 == 0) {
            dVar.onSuccess();
            AppMethodBeat.o(137873);
            return;
        }
        c.G(dVar.hzz.getAppId(), i2, -1);
        dVar.AR(dVar.j("fail: ".concat(String.valueOf(string)), hashMap));
        AppMethodBeat.o(137873);
    }
}
