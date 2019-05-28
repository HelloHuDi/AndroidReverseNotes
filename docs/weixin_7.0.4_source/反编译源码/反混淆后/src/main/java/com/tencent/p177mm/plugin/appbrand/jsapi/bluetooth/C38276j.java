package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.C45588b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C38283b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C33263d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.j */
public final class C38276j extends C10296a {
    private static final int CTRL_INDEX = 178;
    private static final String NAME = "getBluetoothDevices";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        List list = null;
        AppMethodBeat.m2504i(94189);
        C42484c.m75254kT(166);
        String appId = c2241c.getAppId();
        String str = "MicroMsg.JsApiGetBluetoothDevices";
        String str2 = "appId:%s getBluetoothDevices data:%s";
        Object[] objArr = new Object[2];
        objArr[0] = appId;
        if (jSONObject == null) {
            jSONObject = "";
        }
        objArr[1] = jSONObject;
        C4990ab.m7417i(str, str2, objArr);
        C44696b AT = C42483a.m75250AT(appId);
        HashMap hashMap;
        if (AT == null) {
            C4990ab.m7412e("MicroMsg.JsApiGetBluetoothDevices", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK));
            c2241c.mo6107M(i, mo73394j("fail:not init", hashMap));
            C42484c.m75253cZ(168, ErrorCode.NEEDDOWNLOAD_TRUE);
            AppMethodBeat.m2505o(94189);
        } else if (C38283b.aCZ()) {
            if (AT.hDu != null) {
                C45588b c45588b = AT.hDu;
                if (c45588b.hDZ != null) {
                    list = new ArrayList(c45588b.hDZ.hFg.values());
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (list != null) {
                list.addAll(AT.aCO());
                for (C33263d aCq : list) {
                    try {
                        jSONArray.put(aCq.aCq());
                    } catch (JSONException e) {
                        C4990ab.printErrStackTrace("MicroMsg.JsApiGetBluetoothDevices", e, "", new Object[0]);
                    }
                }
            }
            try {
                jSONObject2.put("errMsg", getName() + ":ok");
                jSONObject2.put("devices", jSONArray);
            } catch (JSONException e2) {
                C4990ab.m7413e("MicroMsg.JsApiGetBluetoothDevices", "put json value error : %s", Log.getStackTraceString(e2));
            }
            C4990ab.m7417i("MicroMsg.JsApiGetBluetoothDevices", "retJson %s", jSONObject2);
            c2241c.mo6107M(i, jSONObject2.toString());
            C42484c.m75254kT(ErrorCode.STARTDOWNLOAD_8);
            AppMethodBeat.m2505o(94189);
        } else {
            C4990ab.m7412e("MicroMsg.JsApiGetBluetoothDevices", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            c2241c.mo6107M(i, mo73394j("fail:not available", hashMap));
            C42484c.m75253cZ(168, ErrorCode.NEEDDOWNLOAD_FALSE_2);
            AppMethodBeat.m2505o(94189);
        }
    }
}
