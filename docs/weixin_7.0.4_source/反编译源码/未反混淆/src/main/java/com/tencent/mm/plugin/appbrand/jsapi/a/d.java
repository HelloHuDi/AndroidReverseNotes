package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.text.TextUtils;
import com.facebook.GraphRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.protocal.protobuf.apm;
import com.tencent.mm.protocal.protobuf.apn;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends a<u> {
    public static final int CTRL_INDEX = 204;
    public static final String NAME = "getUserAutoFillData";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(101964);
        final u uVar = (u) cVar;
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData data is invalid");
            uVar.M(i, j("fail:data is invalid", null));
            AppMethodBeat.o(101964);
            return;
        }
        LinkedList linkedList = new LinkedList();
        JSONArray optJSONArray = jSONObject.optJSONArray(GraphRequest.FIELDS_PARAM);
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                linkedList.add(optJSONArray.optString(i2));
            }
        }
        if (linkedList.size() == 0) {
            ab.e("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData fields is empty");
            uVar.M(i, j("fail:fields is empty", null));
            AppMethodBeat.o(101964);
            return;
        }
        ab.i("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData appId:%s, data:%s", uVar.getAppId(), jSONObject.toString());
        apm apm = new apm();
        apm.wtx = linkedList;
        apm.csB = r0;
        apm.wtw = false;
        apm.cvd = 1;
        ((com.tencent.mm.plugin.appbrand.networking.a) uVar.B(com.tencent.mm.plugin.appbrand.networking.a.class)).a("/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo", apm, apn.class).c(new com.tencent.mm.vending.c.a<Object, apn>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(101963);
                apn apn = (apn) obj;
                HashMap hashMap = new HashMap();
                if (apn == null) {
                    ab.e("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData cgi failed, null response");
                    hashMap.put("ret", Integer.valueOf(-99));
                    uVar.M(i, d.this.j("fail: ErrMsg: cgi fail", hashMap));
                    AppMethodBeat.o(101963);
                } else if (apn.BaseResponse.Ret != 0) {
                    ab.e("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(apn.BaseResponse.Ret), apn.BaseResponse.ErrMsg);
                    hashMap.put("ret", Integer.valueOf(apn.BaseResponse.Ret));
                    uVar.M(i, d.this.j("fail: ErrMsg:" + apn.BaseResponse.ErrMsg, hashMap));
                    AppMethodBeat.o(101963);
                } else {
                    ab.i("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData success");
                    Object obj2 = "";
                    if (!TextUtils.isEmpty(apn.wty)) {
                        obj2 = apn.wty;
                    }
                    Object obj3 = "";
                    if (!TextUtils.isEmpty(apn.wtz)) {
                        obj3 = apn.wtz;
                    }
                    int i = apn.vIc;
                    LinkedList linkedList = apn.wtA;
                    ab.i("MicroMsg.JsApiGetUserAutoFillData", "auth_info:%s, auth_status:%d", obj3, Integer.valueOf(i));
                    ab.i("MicroMsg.JsApiGetUserAutoFillData", "user_info_json:%s", obj2);
                    hashMap.put("userData", obj2);
                    hashMap.put("authStatus", Integer.valueOf(i));
                    hashMap.put("authInfo", obj3);
                    if (linkedList != null && linkedList.size() > 0) {
                        hashMap.put("authGroupList", new JSONArray(linkedList));
                        ab.i("MicroMsg.JsApiGetUserAutoFillData", "authGroupList:%s", new JSONArray(linkedList).toString());
                    }
                    uVar.M(i, d.this.j("ok", hashMap));
                    AppMethodBeat.o(101963);
                }
                return null;
            }
        });
        AppMethodBeat.o(101964);
    }
}
