package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.view.d;
import java.util.HashMap;
import org.json.JSONObject;

public final class i extends a {
    private static final int CTRL_INDEX = 175;
    private static final String NAME = "getBluetoothAdapterState";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        boolean z = false;
        AppMethodBeat.i(94188);
        c.kT(126);
        ab.i("MicroMsg.JsApiGetBluetoothAdapterState", "appId:%s getBluetoothAdapterState", cVar.getAppId());
        b AT = a.AT(cVar.getAppId());
        if (AT == null) {
            ab.e("MicroMsg.JsApiGetBluetoothAdapterState", "bleWorker is null, may not open ble");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK));
            cVar.M(i, j("fail:not init", hashMap));
            c.cZ(128, 130);
            AppMethodBeat.o(94188);
            return;
        }
        boolean aCZ = b.aCZ();
        if (AT.hDu != null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bVar = AT.hDu;
            if (bVar.hDZ != null) {
                z = bVar.hDZ.hFh.get();
            }
        }
        ab.i("MicroMsg.JsApiGetBluetoothAdapterState", "availableState : " + aCZ + ",discoveringState : " + z);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("available", Boolean.valueOf(aCZ));
        hashMap2.put("discovering", Boolean.valueOf(z));
        cVar.M(i, j("ok", hashMap2));
        c.kT(d.MIC_SketchMark);
        AppMethodBeat.o(94188);
    }
}
