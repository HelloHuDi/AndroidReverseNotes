package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.k.o;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class k extends a {
    private static final int CTRL_INDEX = 179;
    private static final String NAME = "getConnectedBluetoothDevices";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(94190);
        c.kT(191);
        ab.i("MicroMsg.JsApiGetConnectedBluetoothDevices", "getConnectedBluetoothDevices!");
        ab.i("MicroMsg.JsApiGetConnectedBluetoothDevices", "appId:%s getBLEDeviceCharacteristics data %s", cVar.getAppId(), jSONObject.toString());
        b AT = a.AT(cVar.getAppId());
        HashMap hashMap;
        if (AT == null) {
            ab.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK));
            cVar.M(i, j("fail:not init", hashMap));
            c.cZ(JsApiChooseMedia.CTRL_INDEX, JsApiChooseWeChatContact.CTRL_INDEX);
            AppMethodBeat.o(94190);
        } else if (b.aCZ()) {
            List<d> aCO = AT.aCO();
            if (aCO == null) {
                ab.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "bluetoothDevices is empty!");
                cVar.M(i, j("fail:internal error", null));
                c.cZ(JsApiChooseMedia.CTRL_INDEX, o.CTRL_INDEX);
                AppMethodBeat.o(94190);
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (d dVar : aCO) {
                String str = dVar.ceI;
                String str2 = dVar.name;
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("deviceId", str);
                    jSONObject2.put("name", str2);
                    jSONArray.put(jSONObject2);
                } catch (JSONException e) {
                    ab.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "put JSON data error : %s", e);
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("errMsg", getName() + ":ok");
                jSONObject3.put("devices", jSONArray);
            } catch (JSONException e2) {
                ab.printErrStackTrace("MicroMsg.JsApiGetConnectedBluetoothDevices", e2, "", new Object[0]);
            }
            ab.i("MicroMsg.JsApiGetConnectedBluetoothDevices", "retJson %s", jSONObject3.toString());
            cVar.M(i, jSONObject3.toString());
            c.kT(az.CTRL_INDEX);
            AppMethodBeat.o(94190);
        } else {
            ab.e("MicroMsg.JsApiGetConnectedBluetoothDevices", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            cVar.M(i, j("fail:not available", hashMap));
            c.cZ(JsApiChooseMedia.CTRL_INDEX, 197);
            AppMethodBeat.o(94190);
        }
    }
}
