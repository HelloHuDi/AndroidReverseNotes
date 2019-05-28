package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.protocal.protobuf.bty;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class g extends a<u> {
    public static final int CTRL_INDEX = 205;
    public static final String NAME = "setUserAutoFillData";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(101973);
        final u uVar = (u) cVar;
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData data is invalid");
            uVar.M(i, j("fail:data is invalid", null));
            AppMethodBeat.o(101973);
            return;
        }
        String optString = jSONObject.optString("dataList");
        ab.i("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData appId:%s, dataList:%s", uVar.getAppId(), optString);
        bty bty = new bty();
        bty.csB = r1;
        bty.wty = optString;
        ((com.tencent.mm.plugin.appbrand.networking.a) uVar.B(com.tencent.mm.plugin.appbrand.networking.a.class)).a("/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo", bty, btz.class).c(new com.tencent.mm.vending.c.a<Object, btz>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(101972);
                btz btz = (btz) obj;
                if (btz == null) {
                    ab.e("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData SaveUserAutoFillInfo cgi failed, null response");
                    uVar.M(i, g.this.j("fail:cgi fail", null));
                    AppMethodBeat.o(101972);
                } else if (btz.BaseResponse.Ret != 0) {
                    ab.e("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData SaveUserAutoFillInfo cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(btz.BaseResponse.Ret), btz.BaseResponse.ErrMsg);
                    uVar.M(i, g.this.j("fail:cgi fail", null));
                    AppMethodBeat.o(101972);
                } else {
                    ab.i("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData success");
                    uVar.M(i, g.this.j("ok", null));
                    AppMethodBeat.o(101972);
                }
                return null;
            }
        });
        AppMethodBeat.o(101973);
    }
}
