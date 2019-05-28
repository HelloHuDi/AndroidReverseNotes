package com.tencent.p177mm.plugin.appbrand.jsapi.p897a;

import android.text.TextUtils;
import com.facebook.GraphRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.networking.C42637a;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.protocal.protobuf.apm;
import com.tencent.p177mm.protocal.protobuf.apn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.a.d */
public final class C45570d extends C10296a<C44709u> {
    public static final int CTRL_INDEX = 204;
    public static final String NAME = "getUserAutoFillData";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(101964);
        final C44709u c44709u = (C44709u) c2241c;
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData data is invalid");
            c44709u.mo6107M(i, mo73394j("fail:data is invalid", null));
            AppMethodBeat.m2505o(101964);
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
            C4990ab.m7412e("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData fields is empty");
            c44709u.mo6107M(i, mo73394j("fail:fields is empty", null));
            AppMethodBeat.m2505o(101964);
            return;
        }
        C4990ab.m7417i("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData appId:%s, data:%s", c44709u.getAppId(), jSONObject.toString());
        apm apm = new apm();
        apm.wtx = linkedList;
        apm.csB = r0;
        apm.wtw = false;
        apm.cvd = 1;
        ((C42637a) c44709u.mo5936B(C42637a.class)).mo22168a("/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo", apm, apn.class).mo15892c(new C5681a<Object, apn>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(101963);
                apn apn = (apn) obj;
                HashMap hashMap = new HashMap();
                if (apn == null) {
                    C4990ab.m7412e("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData cgi failed, null response");
                    hashMap.put("ret", Integer.valueOf(-99));
                    c44709u.mo6107M(i, C45570d.this.mo73394j("fail: ErrMsg: cgi fail", hashMap));
                    AppMethodBeat.m2505o(101963);
                } else if (apn.BaseResponse.Ret != 0) {
                    C4990ab.m7413e("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(apn.BaseResponse.Ret), apn.BaseResponse.ErrMsg);
                    hashMap.put("ret", Integer.valueOf(apn.BaseResponse.Ret));
                    c44709u.mo6107M(i, C45570d.this.mo73394j("fail: ErrMsg:" + apn.BaseResponse.ErrMsg, hashMap));
                    AppMethodBeat.m2505o(101963);
                } else {
                    C4990ab.m7416i("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData success");
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
                    C4990ab.m7417i("MicroMsg.JsApiGetUserAutoFillData", "auth_info:%s, auth_status:%d", obj3, Integer.valueOf(i));
                    C4990ab.m7417i("MicroMsg.JsApiGetUserAutoFillData", "user_info_json:%s", obj2);
                    hashMap.put("userData", obj2);
                    hashMap.put("authStatus", Integer.valueOf(i));
                    hashMap.put("authInfo", obj3);
                    if (linkedList != null && linkedList.size() > 0) {
                        hashMap.put("authGroupList", new JSONArray(linkedList));
                        C4990ab.m7417i("MicroMsg.JsApiGetUserAutoFillData", "authGroupList:%s", new JSONArray(linkedList).toString());
                    }
                    c44709u.mo6107M(i, C45570d.this.mo73394j("ok", hashMap));
                    AppMethodBeat.m2505o(101963);
                }
                return null;
            }
        });
        AppMethodBeat.m2505o(101964);
    }
}
