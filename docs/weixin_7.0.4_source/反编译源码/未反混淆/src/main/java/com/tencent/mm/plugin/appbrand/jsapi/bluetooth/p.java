package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import org.json.JSONObject;

@TargetApi(18)
public final class p extends a {
    private static final int CTRL_INDEX = 177;
    private static final String NAME = "stopBluetoothDevicesDiscovery";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(94213);
        c.kT(101);
        String appId = cVar.getAppId();
        String str = "MicroMsg.JsApiStopBluetoothDevicesDiscovery";
        String str2 = "appId:%s stopBluetoothDevicesDiscovery data:%s";
        Object[] objArr = new Object[2];
        objArr[0] = appId;
        if (jSONObject == null) {
            jSONObject = "";
        }
        objArr[1] = jSONObject;
        ab.i(str, str2, objArr);
        b AT = a.AT(appId);
        HashMap hashMap;
        if (AT == null) {
            ab.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK));
            cVar.M(i, j("fail:not init", hashMap));
            c.cZ(103, 106);
            AppMethodBeat.o(94213);
        } else if (b.aCZ()) {
            j aCU;
            if (AT.hDu != null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bVar = AT.hDu;
                if (bVar.hDZ != null) {
                    aCU = bVar.hDZ.aCU();
                } else {
                    aCU = j.hEM;
                }
            } else {
                aCU = j.hEM;
            }
            ab.i("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "stopBleScan result:%s", aCU);
            HashMap hashMap2 = new HashMap();
            switch (aCU.errCode) {
                case 0:
                    hashMap2.put("isDiscovering", Boolean.FALSE);
                    cVar.M(i, j("ok", hashMap2));
                    c.kT(102);
                    m.c.a(cVar, true, false);
                    AppMethodBeat.o(94213);
                    return;
                default:
                    hashMap2.put("isDiscovering", Boolean.FALSE);
                    cVar.M(i, j("fail", hashMap2));
                    c.kT(103);
                    AppMethodBeat.o(94213);
                    return;
            }
        } else {
            ab.e("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            cVar.M(i, j("fail:not available", hashMap));
            c.cZ(103, 108);
            AppMethodBeat.o(94213);
        }
    }
}
