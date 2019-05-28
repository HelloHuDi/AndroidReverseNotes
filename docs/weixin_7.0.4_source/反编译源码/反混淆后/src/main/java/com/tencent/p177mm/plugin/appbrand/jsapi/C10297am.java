package com.tencent.p177mm.plugin.appbrand.jsapi;

import com.tencent.luggage.sdk.p148b.C25697b;
import com.tencent.luggage.sdk.p819a.p820a.C45126b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.permission.C33491e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.am */
public final class C10297am extends C19497u<C45126b> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "getPermissionBytes";

    /* renamed from: b */
    public final /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        int i = 0;
        AppMethodBeat.m2504i(101941);
        C45126b c45126b = (C45126b) c2241c;
        C4990ab.m7417i("MicroMsg.JsApiGetPermissionBytes", "invoke jsapi: %s", NAME);
        String j;
        if (jSONObject == null) {
            C4990ab.m7416i("MicroMsg.JsApiGetPermissionBytes", "fail:data is nil");
            j = mo73394j("fail:data is nil", null);
            AppMethodBeat.m2505o(101941);
            return j;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("indexes");
        if (optJSONArray == null) {
            C4990ab.m7416i("MicroMsg.JsApiGetPermissionBytes", "fail:indexes is nil");
            j = mo73394j("fail:indexes is nil", null);
            AppMethodBeat.m2505o(101941);
            return j;
        }
        C25697b xL = c45126b.mo34954xL();
        if (xL == null) {
            C4990ab.m7416i("MicroMsg.JsApiGetPermissionBytes", "fail:runtime is nil");
            j = mo73394j("fail:runtime is nil", null);
            AppMethodBeat.m2505o(101941);
            return j;
        }
        C33491e xY = xL.mo43488xY();
        byte[] z = xY.mo53982z(c45126b);
        if (z == null || z.length <= 0) {
            C4990ab.m7416i("MicroMsg.JsApiGetPermissionBytes", "fail:ctrlBytes is empty");
            j = mo73394j("fail:ctrlBytes is empty", null);
            AppMethodBeat.m2505o(101941);
            return j;
        }
        JSONArray jSONArray = new JSONArray();
        if (optJSONArray.length() == 0) {
            while (i < z.length) {
                jSONArray.put(xY.mo53975E(z, i));
                i++;
            }
        } else {
            while (i < optJSONArray.length()) {
                jSONArray.put(xY.mo53975E(z, optJSONArray.optInt(i, -1)));
                i++;
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("permissionBytes", jSONArray);
        C4990ab.m7416i("MicroMsg.JsApiGetPermissionBytes", "invoke getPermissionBytes ok");
        j = mo73394j("ok", hashMap);
        AppMethodBeat.m2505o(101941);
        return j;
    }
}
