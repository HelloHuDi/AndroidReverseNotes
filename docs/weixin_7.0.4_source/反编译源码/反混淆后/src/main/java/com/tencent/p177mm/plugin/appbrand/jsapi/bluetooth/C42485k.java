package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C38283b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C33263d;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C27011o;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.k */
public final class C42485k extends C10296a {
    private static final int CTRL_INDEX = 179;
    private static final String NAME = "getConnectedBluetoothDevices";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(94190);
        C42484c.m75254kT(191);
        C4990ab.m7416i("MicroMsg.JsApiGetConnectedBluetoothDevices", "getConnectedBluetoothDevices!");
        C4990ab.m7417i("MicroMsg.JsApiGetConnectedBluetoothDevices", "appId:%s getBLEDeviceCharacteristics data %s", c2241c.getAppId(), jSONObject.toString());
        C44696b AT = C42483a.m75250AT(c2241c.getAppId());
        HashMap hashMap;
        if (AT == null) {
            C4990ab.m7412e("MicroMsg.JsApiGetConnectedBluetoothDevices", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK));
            c2241c.mo6107M(i, mo73394j("fail:not init", hashMap));
            C42484c.m75253cZ(JsApiChooseMedia.CTRL_INDEX, JsApiChooseWeChatContact.CTRL_INDEX);
            AppMethodBeat.m2505o(94190);
        } else if (C38283b.aCZ()) {
            List<C33263d> aCO = AT.aCO();
            if (aCO == null) {
                C4990ab.m7412e("MicroMsg.JsApiGetConnectedBluetoothDevices", "bluetoothDevices is empty!");
                c2241c.mo6107M(i, mo73394j("fail:internal error", null));
                C42484c.m75253cZ(JsApiChooseMedia.CTRL_INDEX, C27011o.CTRL_INDEX);
                AppMethodBeat.m2505o(94190);
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (C33263d c33263d : aCO) {
                String str = c33263d.ceI;
                String str2 = c33263d.name;
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("deviceId", str);
                    jSONObject2.put("name", str2);
                    jSONArray.put(jSONObject2);
                } catch (JSONException e) {
                    C4990ab.m7413e("MicroMsg.JsApiGetConnectedBluetoothDevices", "put JSON data error : %s", e);
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("errMsg", getName() + ":ok");
                jSONObject3.put("devices", jSONArray);
            } catch (JSONException e2) {
                C4990ab.printErrStackTrace("MicroMsg.JsApiGetConnectedBluetoothDevices", e2, "", new Object[0]);
            }
            C4990ab.m7417i("MicroMsg.JsApiGetConnectedBluetoothDevices", "retJson %s", jSONObject3.toString());
            c2241c.mo6107M(i, jSONObject3.toString());
            C42484c.m75254kT(C33250az.CTRL_INDEX);
            AppMethodBeat.m2505o(94190);
        } else {
            C4990ab.m7412e("MicroMsg.JsApiGetConnectedBluetoothDevices", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            c2241c.mo6107M(i, mo73394j("fail:not available", hashMap));
            C42484c.m75253cZ(JsApiChooseMedia.CTRL_INDEX, 197);
            AppMethodBeat.m2505o(94190);
        }
    }
}
