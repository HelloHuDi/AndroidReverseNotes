package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.sdk.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class am extends u<b> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "getPermissionBytes";

    public final /* synthetic */ String b(c cVar, JSONObject jSONObject) {
        int i = 0;
        AppMethodBeat.i(101941);
        b bVar = (b) cVar;
        ab.i("MicroMsg.JsApiGetPermissionBytes", "invoke jsapi: %s", NAME);
        String j;
        if (jSONObject == null) {
            ab.i("MicroMsg.JsApiGetPermissionBytes", "fail:data is nil");
            j = j("fail:data is nil", null);
            AppMethodBeat.o(101941);
            return j;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("indexes");
        if (optJSONArray == null) {
            ab.i("MicroMsg.JsApiGetPermissionBytes", "fail:indexes is nil");
            j = j("fail:indexes is nil", null);
            AppMethodBeat.o(101941);
            return j;
        }
        com.tencent.luggage.sdk.b.b xL = bVar.xL();
        if (xL == null) {
            ab.i("MicroMsg.JsApiGetPermissionBytes", "fail:runtime is nil");
            j = j("fail:runtime is nil", null);
            AppMethodBeat.o(101941);
            return j;
        }
        e xY = xL.xY();
        byte[] z = xY.z(bVar);
        if (z == null || z.length <= 0) {
            ab.i("MicroMsg.JsApiGetPermissionBytes", "fail:ctrlBytes is empty");
            j = j("fail:ctrlBytes is empty", null);
            AppMethodBeat.o(101941);
            return j;
        }
        JSONArray jSONArray = new JSONArray();
        if (optJSONArray.length() == 0) {
            while (i < z.length) {
                jSONArray.put(xY.E(z, i));
                i++;
            }
        } else {
            while (i < optJSONArray.length()) {
                jSONArray.put(xY.E(z, optJSONArray.optInt(i, -1)));
                i++;
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("permissionBytes", jSONArray);
        ab.i("MicroMsg.JsApiGetPermissionBytes", "invoke getPermissionBytes ok");
        j = j("ok", hashMap);
        AppMethodBeat.o(101941);
        return j;
    }
}
