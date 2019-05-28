package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.view.d;
import org.json.JSONObject;

@TargetApi(18)
public final class e extends a {
    private static final int CTRL_INDEX = 174;
    private static final String NAME = "closeBluetoothAdapter";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(94183);
        c.kT(116);
        ab.i("MicroMsg.JsApiCloseBluetoothAdapter", "appId:%s closeBluetoothAdapter!", cVar.getAppId());
        j AU = a.AU(r0);
        ab.i("MicroMsg.JsApiCloseBluetoothAdapter", "result:%s", AU);
        switch (AU.errCode) {
            case 0:
                cVar.M(i, j("ok", null));
                c.kT(d.MIC_ALPHA_ADJUST_REAL);
                AppMethodBeat.o(94183);
                return;
            default:
                cVar.M(i, j(AU.aIm, null));
                c.kT(118);
                AppMethodBeat.o(94183);
                return;
        }
    }
}
