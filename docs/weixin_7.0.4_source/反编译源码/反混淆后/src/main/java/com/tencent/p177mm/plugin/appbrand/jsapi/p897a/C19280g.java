package com.tencent.p177mm.plugin.appbrand.jsapi.p897a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.networking.C42637a;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.protocal.protobuf.bty;
import com.tencent.p177mm.protocal.protobuf.btz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p637c.C5681a;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.a.g */
public final class C19280g extends C10296a<C44709u> {
    public static final int CTRL_INDEX = 205;
    public static final String NAME = "setUserAutoFillData";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(101973);
        final C44709u c44709u = (C44709u) c2241c;
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData data is invalid");
            c44709u.mo6107M(i, mo73394j("fail:data is invalid", null));
            AppMethodBeat.m2505o(101973);
            return;
        }
        String optString = jSONObject.optString("dataList");
        C4990ab.m7417i("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData appId:%s, dataList:%s", c44709u.getAppId(), optString);
        bty bty = new bty();
        bty.csB = r1;
        bty.wty = optString;
        ((C42637a) c44709u.mo5936B(C42637a.class)).mo22168a("/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo", bty, btz.class).mo15892c(new C5681a<Object, btz>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(101972);
                btz btz = (btz) obj;
                if (btz == null) {
                    C4990ab.m7412e("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData SaveUserAutoFillInfo cgi failed, null response");
                    c44709u.mo6107M(i, C19280g.this.mo73394j("fail:cgi fail", null));
                    AppMethodBeat.m2505o(101972);
                } else if (btz.BaseResponse.Ret != 0) {
                    C4990ab.m7413e("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData SaveUserAutoFillInfo cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(btz.BaseResponse.Ret), btz.BaseResponse.ErrMsg);
                    c44709u.mo6107M(i, C19280g.this.mo73394j("fail:cgi fail", null));
                    AppMethodBeat.m2505o(101972);
                } else {
                    C4990ab.m7416i("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData success");
                    c44709u.mo6107M(i, C19280g.this.mo73394j("ok", null));
                    AppMethodBeat.m2505o(101972);
                }
                return null;
            }
        });
        AppMethodBeat.m2505o(101973);
    }
}
