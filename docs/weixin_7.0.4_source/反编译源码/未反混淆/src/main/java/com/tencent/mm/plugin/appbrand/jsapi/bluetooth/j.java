package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class j extends a {
    private static final int CTRL_INDEX = 178;
    private static final String NAME = "getBluetoothDevices";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        List list = null;
        AppMethodBeat.i(94189);
        c.kT(166);
        String appId = cVar.getAppId();
        String str = "MicroMsg.JsApiGetBluetoothDevices";
        String str2 = "appId:%s getBluetoothDevices data:%s";
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
            ab.e("MicroMsg.JsApiGetBluetoothDevices", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK));
            cVar.M(i, j("fail:not init", hashMap));
            c.cZ(168, ErrorCode.NEEDDOWNLOAD_TRUE);
            AppMethodBeat.o(94189);
        } else if (b.aCZ()) {
            if (AT.hDu != null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bVar = AT.hDu;
                if (bVar.hDZ != null) {
                    list = new ArrayList(bVar.hDZ.hFg.values());
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (list != null) {
                list.addAll(AT.aCO());
                for (d aCq : list) {
                    try {
                        jSONArray.put(aCq.aCq());
                    } catch (JSONException e) {
                        ab.printErrStackTrace("MicroMsg.JsApiGetBluetoothDevices", e, "", new Object[0]);
                    }
                }
            }
            try {
                jSONObject2.put("errMsg", getName() + ":ok");
                jSONObject2.put("devices", jSONArray);
            } catch (JSONException e2) {
                ab.e("MicroMsg.JsApiGetBluetoothDevices", "put json value error : %s", Log.getStackTraceString(e2));
            }
            ab.i("MicroMsg.JsApiGetBluetoothDevices", "retJson %s", jSONObject2);
            cVar.M(i, jSONObject2.toString());
            c.kT(ErrorCode.STARTDOWNLOAD_8);
            AppMethodBeat.o(94189);
        } else {
            ab.e("MicroMsg.JsApiGetBluetoothDevices", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            cVar.M(i, j("fail:not available", hashMap));
            c.cZ(168, ErrorCode.NEEDDOWNLOAD_FALSE_2);
            AppMethodBeat.o(94189);
        }
    }
}
