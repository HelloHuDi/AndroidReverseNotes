package com.tencent.p177mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.networking.C42637a;
import com.tencent.p177mm.protocal.protobuf.cmx;
import com.tencent.p177mm.protocal.protobuf.cmy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bn */
public final class C42490bn extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 313;
    public static final String NAME = "verifyPlugin";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(101960);
        final C38492q c38492q = (C38492q) c2241c;
        if (jSONObject == null || jSONObject.opt("data") == null) {
            c38492q.mo6107M(i, mo73394j("fail:data is null or nil", null));
            AppMethodBeat.m2505o(101960);
            return;
        }
        cmx cmx = new cmx();
        cmx.csB = c38492q.getAppId();
        cmx.xku = jSONObject.opt("data").toString();
        ((C42637a) c38492q.mo5936B(C42637a.class)).mo22168a("/cgi-bin/mmbiz-bin/wxaapp/verifyplugin", cmx, cmy.class).mo15892c(new C5681a<Object, cmy>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(101959);
                Object a = m30023a((cmy) obj);
                AppMethodBeat.m2505o(101959);
                return a;
            }

            /* renamed from: a */
            private Object m30023a(cmy cmy) {
                AppMethodBeat.m2504i(101958);
                if (cmy == null) {
                    C4990ab.m7412e("MicroMsg.JsApiVerifyPlugin", "getsubbusinessinfo cgi failed, null response");
                    c38492q.mo6107M(i, C42490bn.this.mo73394j("fail:cgi fail", null));
                    AppMethodBeat.m2505o(101958);
                } else if (cmy.BaseResponse.Ret != 0) {
                    C4990ab.m7413e("MicroMsg.JsApiVerifyPlugin", "getsubbusinessinfo cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(cmy.BaseResponse.Ret), cmy.BaseResponse.ErrMsg);
                    c38492q.mo6107M(i, C42490bn.this.mo73394j("fail:cgi fail", null));
                    AppMethodBeat.m2505o(101958);
                } else {
                    HashMap hashMap = new HashMap();
                    try {
                        hashMap.put("data", new JSONObject(cmy.xkv));
                        c38492q.mo6107M(i, C42490bn.this.mo73394j("ok", hashMap));
                        AppMethodBeat.m2505o(101958);
                    } catch (Exception e) {
                        c38492q.mo6107M(i, C42490bn.this.mo73394j("fail:resp invalid", null));
                        AppMethodBeat.m2505o(101958);
                    }
                }
                return null;
            }
        });
        AppMethodBeat.m2505o(101960);
    }
}
