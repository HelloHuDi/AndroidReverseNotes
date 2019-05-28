package com.tencent.p177mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.networking.C42637a;
import com.tencent.p177mm.protocal.protobuf.C35920fu;
import com.tencent.p177mm.protocal.protobuf.cwh;
import com.tencent.p177mm.protocal.protobuf.cwi;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ap */
public final class C38254ap extends C10296a {
    public static final int CTRL_INDEX = 236;
    public static final String NAME = "getSetting";

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(101946);
        cwh cwh = new cwh();
        cwh.appId = c2241c.getAppId();
        ((C42637a) c2241c.mo5936B(C42637a.class)).mo22168a("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", cwh, cwi.class).mo15892c(new C5681a<Object, cwi>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(101945);
                Object a = m11206a((cwi) obj);
                AppMethodBeat.m2505o(101945);
                return a;
            }

            /* renamed from: a */
            private Object m11206a(cwi cwi) {
                AppMethodBeat.m2504i(101944);
                if (cwi == null) {
                    C4990ab.m7412e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, null response");
                    c2241c.mo6107M(i, C38254ap.this.mo73394j("fail:cgi fail", null));
                    AppMethodBeat.m2505o(101944);
                } else if (cwi.BaseResponse.Ret != 0) {
                    C4990ab.m7413e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(cwi.BaseResponse.Ret), cwi.BaseResponse.ErrMsg);
                    c2241c.mo6107M(i, C38254ap.this.mo73394j("fail:cgi fail", null));
                    AppMethodBeat.m2505o(101944);
                } else {
                    try {
                        LinkedList linkedList = cwi.xsb;
                        JSONArray jSONArray = new JSONArray();
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            C35920fu c35920fu = (C35920fu) it.next();
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("scope", c35920fu.scope);
                                jSONObject.put("state", c35920fu.state);
                                jSONObject.put("desc", c35920fu.vHE);
                                jSONArray.put(jSONObject);
                            } catch (Exception e) {
                                C4990ab.m7413e("MicroMsg.JsApiGetSetting", "parse json failed : %s", e.getMessage());
                            }
                        }
                        String jSONArray2 = jSONArray.toString();
                        C4990ab.m7411d("MicroMsg.JsApiGetSetting", "authInfo %s", jSONArray);
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("errMsg", "getSetting:ok");
                            jSONObject2.put("authSetting", new JSONArray(C5046bo.nullAsNil(jSONArray2)));
                            c2241c.mo6107M(i, jSONObject2.toString());
                            AppMethodBeat.m2505o(101944);
                        } catch (JSONException e2) {
                            C4990ab.printErrStackTrace("MicroMsg.JsApiGetSetting", e2, "set json error!", new Object[0]);
                            c2241c.mo6107M(i, C38254ap.this.mo73394j("fail:resp invalid", null));
                            AppMethodBeat.m2505o(101944);
                            return null;
                        }
                    } catch (Exception e3) {
                    }
                }
                return null;
            }
        });
        AppMethodBeat.m2505o(101946);
    }
}
