package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.networking.a;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.protocal.protobuf.cmx;
import com.tencent.mm.protocal.protobuf.cmy;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

public final class bn extends a<q> {
    public static final int CTRL_INDEX = 313;
    public static final String NAME = "verifyPlugin";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(101960);
        final q qVar = (q) cVar;
        if (jSONObject == null || jSONObject.opt("data") == null) {
            qVar.M(i, j("fail:data is null or nil", null));
            AppMethodBeat.o(101960);
            return;
        }
        cmx cmx = new cmx();
        cmx.csB = qVar.getAppId();
        cmx.xku = jSONObject.opt("data").toString();
        ((a) qVar.B(a.class)).a("/cgi-bin/mmbiz-bin/wxaapp/verifyplugin", cmx, cmy.class).c(new com.tencent.mm.vending.c.a<Object, cmy>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(101959);
                Object a = a((cmy) obj);
                AppMethodBeat.o(101959);
                return a;
            }

            private Object a(cmy cmy) {
                AppMethodBeat.i(101958);
                if (cmy == null) {
                    ab.e("MicroMsg.JsApiVerifyPlugin", "getsubbusinessinfo cgi failed, null response");
                    qVar.M(i, bn.this.j("fail:cgi fail", null));
                    AppMethodBeat.o(101958);
                } else if (cmy.BaseResponse.Ret != 0) {
                    ab.e("MicroMsg.JsApiVerifyPlugin", "getsubbusinessinfo cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(cmy.BaseResponse.Ret), cmy.BaseResponse.ErrMsg);
                    qVar.M(i, bn.this.j("fail:cgi fail", null));
                    AppMethodBeat.o(101958);
                } else {
                    HashMap hashMap = new HashMap();
                    try {
                        hashMap.put("data", new JSONObject(cmy.xkv));
                        qVar.M(i, bn.this.j("ok", hashMap));
                        AppMethodBeat.o(101958);
                    } catch (Exception e) {
                        qVar.M(i, bn.this.j("fail:resp invalid", null));
                        AppMethodBeat.o(101958);
                    }
                }
                return null;
            }
        });
        AppMethodBeat.o(101960);
    }
}
