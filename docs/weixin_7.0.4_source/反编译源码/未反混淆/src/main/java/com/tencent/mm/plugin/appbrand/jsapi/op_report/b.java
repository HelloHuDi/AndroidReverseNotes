package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.o;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.protocal.protobuf.bso;
import com.tencent.mm.protocal.protobuf.bsp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.g.d;
import org.json.JSONObject;

public final class b extends a<com.tencent.luggage.sdk.a.a.b> {
    private static final int CTRL_INDEX = 245;
    private static final String NAME = "reportPageData";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(102007);
        final com.tencent.luggage.sdk.a.a.b bVar = (com.tencent.luggage.sdk.a.a.b) cVar;
        AppBrandInitConfigLU ya = bVar.xL().ya();
        AppBrandSysConfigLU xZ = bVar.xL().xZ();
        AppBrandStatObject appBrandStatObject = bVar.xL().ya().bQn;
        final String appId = bVar.getAppId();
        bso bso = new bso();
        bso.wUJ = new azt();
        if (xZ != null) {
            bso.wUJ.csB = xZ.appId;
            bso.wUJ.username = ya.username;
            bso.wUJ.wzF = xZ.hhd.gVt;
            bso.wUJ.vMG = xZ.hhd.gVu;
            o asG = bVar.asG();
            if (asG != null) {
                bso.wUJ.wDC = asG.avm().gVu;
            }
        }
        if (appBrandStatObject != null) {
            bso.wUJ.Scene = appBrandStatObject.scene;
            bso.wUJ.wDz = appBrandStatObject.cOq;
        }
        bso.wUJ.wDA = 1;
        com.tencent.luggage.sdk.a.a.a xV = bVar.xV();
        if (xV != null) {
            bso.wUJ.wDB = xV.getURL();
        }
        bso.wkG = jSONObject.toString();
        ((com.tencent.mm.plugin.appbrand.networking.a) bVar.B(com.tencent.mm.plugin.appbrand.networking.a.class)).a("/cgi-bin/mmbiz-bin/wxabusiness/reportwxaappexpose", bso, bsp.class).c(new com.tencent.mm.vending.c.a<Object, bsp>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(102006);
                bsp bsp = (bsp) obj;
                if (bsp == null) {
                    ab.e("Luggage.JsApiReportPageData", "reportwxaappexpose cgi failed, null response");
                    bVar.M(i, b.this.j("fail:cgi fail", null));
                    AppMethodBeat.o(102006);
                } else if (bsp.BaseResponse.Ret != 0) {
                    ab.e("Luggage.JsApiReportPageData", "reportwxaappexpose cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(bsp.BaseResponse.Ret), bsp.BaseResponse.ErrMsg);
                    bVar.M(i, b.this.j("fail:cgi fail", null));
                    AppMethodBeat.o(102006);
                } else {
                    com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.b.bi(appId, bsp.wUK);
                    bVar.M(i, b.this.j("ok", null));
                    AppMethodBeat.o(102006);
                }
                return null;
            }
        }).a((d.a) new d.a() {
            public final void bi(Object obj) {
                AppMethodBeat.i(102005);
                ab.e("Luggage.JsApiReportPageData", "reportwxaappexpose cgi failed, message = %s", obj);
                bVar.M(i, b.this.j("fail:cgi fail", null));
                AppMethodBeat.o(102005);
            }
        });
        AppMethodBeat.o(102007);
    }
}
