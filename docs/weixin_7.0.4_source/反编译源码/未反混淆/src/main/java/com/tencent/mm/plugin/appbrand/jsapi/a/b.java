package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.protocal.protobuf.wv;
import com.tencent.mm.protocal.protobuf.ww;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class b extends a<u> {
    public static final int CTRL_INDEX = 206;
    public static final String NAME = "deleteUserAutoFillData";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(101962);
        final u uVar = (u) cVar;
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData data is invalid");
            uVar.M(i, j("fail:data is invalid", null));
            AppMethodBeat.o(101962);
            return;
        }
        String optString = jSONObject.optString("groupKey");
        int optInt = jSONObject.optInt("groupId", 0);
        if (TextUtils.isEmpty(optString)) {
            ab.e("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData groupKey is invalid");
            uVar.M(i, j("fail:groupKey is invalid", null));
            AppMethodBeat.o(101962);
            return;
        }
        ab.i("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData appId:%s, groupId:%d, groupKey:%s", uVar.getAppId(), Integer.valueOf(optInt), optString);
        wv wvVar = new wv();
        wvVar.wcQ = optString;
        wvVar.csB = r2;
        wvVar.wcR = optInt;
        wvVar.cvd = 1;
        ((com.tencent.mm.plugin.appbrand.networking.a) uVar.B(com.tencent.mm.plugin.appbrand.networking.a.class)).a("/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo", wvVar, ww.class).c(new com.tencent.mm.vending.c.a<Object, ww>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(101961);
                ww wwVar = (ww) obj;
                if (wwVar == null) {
                    ab.e("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData cgi failed, null response");
                    uVar.M(i, b.this.j("fail:cgi fail", null));
                    AppMethodBeat.o(101961);
                } else if (wwVar.BaseResponse.Ret != 0) {
                    ab.e("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(wwVar.BaseResponse.Ret), wwVar.BaseResponse.ErrMsg);
                    uVar.M(i, b.this.j("fail:cgi fail", null));
                    AppMethodBeat.o(101961);
                } else {
                    ab.i("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData success");
                    uVar.M(i, b.this.j("ok", null));
                    AppMethodBeat.o(101961);
                }
                return null;
            }
        });
        AppMethodBeat.o(101962);
    }
}
