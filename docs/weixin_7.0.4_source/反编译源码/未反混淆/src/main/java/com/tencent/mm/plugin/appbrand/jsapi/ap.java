package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.networking.a;
import com.tencent.mm.protocal.protobuf.cwh;
import com.tencent.mm.protocal.protobuf.cwi;
import com.tencent.mm.protocal.protobuf.fu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ap extends a {
    public static final int CTRL_INDEX = 236;
    public static final String NAME = "getSetting";

    public final void a(final c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(101946);
        cwh cwh = new cwh();
        cwh.appId = cVar.getAppId();
        ((a) cVar.B(a.class)).a("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", cwh, cwi.class).c(new com.tencent.mm.vending.c.a<Object, cwi>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(101945);
                Object a = a((cwi) obj);
                AppMethodBeat.o(101945);
                return a;
            }

            private Object a(cwi cwi) {
                AppMethodBeat.i(101944);
                if (cwi == null) {
                    ab.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, null response");
                    cVar.M(i, ap.this.j("fail:cgi fail", null));
                    AppMethodBeat.o(101944);
                } else if (cwi.BaseResponse.Ret != 0) {
                    ab.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(cwi.BaseResponse.Ret), cwi.BaseResponse.ErrMsg);
                    cVar.M(i, ap.this.j("fail:cgi fail", null));
                    AppMethodBeat.o(101944);
                } else {
                    try {
                        LinkedList linkedList = cwi.xsb;
                        JSONArray jSONArray = new JSONArray();
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            fu fuVar = (fu) it.next();
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("scope", fuVar.scope);
                                jSONObject.put("state", fuVar.state);
                                jSONObject.put("desc", fuVar.vHE);
                                jSONArray.put(jSONObject);
                            } catch (Exception e) {
                                ab.e("MicroMsg.JsApiGetSetting", "parse json failed : %s", e.getMessage());
                            }
                        }
                        String jSONArray2 = jSONArray.toString();
                        ab.d("MicroMsg.JsApiGetSetting", "authInfo %s", jSONArray);
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("errMsg", "getSetting:ok");
                            jSONObject2.put("authSetting", new JSONArray(bo.nullAsNil(jSONArray2)));
                            cVar.M(i, jSONObject2.toString());
                            AppMethodBeat.o(101944);
                        } catch (JSONException e2) {
                            ab.printErrStackTrace("MicroMsg.JsApiGetSetting", e2, "set json error!", new Object[0]);
                            cVar.M(i, ap.this.j("fail:resp invalid", null));
                            AppMethodBeat.o(101944);
                            return null;
                        }
                    } catch (Exception e3) {
                    }
                }
                return null;
            }
        });
        AppMethodBeat.o(101946);
    }
}
