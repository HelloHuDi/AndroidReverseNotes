package com.tencent.p177mm.plugin.appbrand.jsapi.p897a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.networking.C42637a;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.protocal.protobuf.C23459ww;
import com.tencent.p177mm.protocal.protobuf.C7558wv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p637c.C5681a;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.a.b */
public final class C42463b extends C10296a<C44709u> {
    public static final int CTRL_INDEX = 206;
    public static final String NAME = "deleteUserAutoFillData";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(101962);
        final C44709u c44709u = (C44709u) c2241c;
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData data is invalid");
            c44709u.mo6107M(i, mo73394j("fail:data is invalid", null));
            AppMethodBeat.m2505o(101962);
            return;
        }
        String optString = jSONObject.optString("groupKey");
        int optInt = jSONObject.optInt("groupId", 0);
        if (TextUtils.isEmpty(optString)) {
            C4990ab.m7412e("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData groupKey is invalid");
            c44709u.mo6107M(i, mo73394j("fail:groupKey is invalid", null));
            AppMethodBeat.m2505o(101962);
            return;
        }
        C4990ab.m7417i("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData appId:%s, groupId:%d, groupKey:%s", c44709u.getAppId(), Integer.valueOf(optInt), optString);
        C7558wv c7558wv = new C7558wv();
        c7558wv.wcQ = optString;
        c7558wv.csB = r2;
        c7558wv.wcR = optInt;
        c7558wv.cvd = 1;
        ((C42637a) c44709u.mo5936B(C42637a.class)).mo22168a("/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo", c7558wv, C23459ww.class).mo15892c(new C5681a<Object, C23459ww>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(101961);
                C23459ww c23459ww = (C23459ww) obj;
                if (c23459ww == null) {
                    C4990ab.m7412e("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData cgi failed, null response");
                    c44709u.mo6107M(i, C42463b.this.mo73394j("fail:cgi fail", null));
                    AppMethodBeat.m2505o(101961);
                } else if (c23459ww.BaseResponse.Ret != 0) {
                    C4990ab.m7413e("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(c23459ww.BaseResponse.Ret), c23459ww.BaseResponse.ErrMsg);
                    c44709u.mo6107M(i, C42463b.this.mo73394j("fail:cgi fail", null));
                    AppMethodBeat.m2505o(101961);
                } else {
                    C4990ab.m7416i("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData success");
                    c44709u.mo6107M(i, C42463b.this.mo73394j("ok", null));
                    AppMethodBeat.m2505o(101961);
                }
                return null;
            }
        });
        AppMethodBeat.m2505o(101962);
    }
}
