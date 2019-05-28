package com.tencent.p177mm.plugin.appbrand.jsapi.op_report;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.p819a.p820a.C37402a;
import com.tencent.luggage.sdk.p819a.p820a.C45126b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appcache.C19062o;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.C27052b;
import com.tencent.p177mm.plugin.appbrand.networking.C42637a;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.protocal.protobuf.azt;
import com.tencent.p177mm.protocal.protobuf.bso;
import com.tencent.p177mm.protocal.protobuf.bsp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5692d.C5690a;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.op_report.b */
public final class C27053b extends C10296a<C45126b> {
    private static final int CTRL_INDEX = 245;
    private static final String NAME = "reportPageData";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(102007);
        final C45126b c45126b = (C45126b) c2241c;
        AppBrandInitConfigLU ya = c45126b.mo34954xL().mo43491ya();
        AppBrandSysConfigLU xZ = c45126b.mo34954xL().mo43489xZ();
        AppBrandStatObject appBrandStatObject = c45126b.mo34954xL().mo43491ya().bQn;
        final String appId = c45126b.getAppId();
        bso bso = new bso();
        bso.wUJ = new azt();
        if (xZ != null) {
            bso.wUJ.csB = xZ.appId;
            bso.wUJ.username = ya.username;
            bso.wUJ.wzF = xZ.hhd.gVt;
            bso.wUJ.vMG = xZ.hhd.gVu;
            C19062o asG = c45126b.asG();
            if (asG != null) {
                bso.wUJ.wDC = asG.avm().gVu;
            }
        }
        if (appBrandStatObject != null) {
            bso.wUJ.Scene = appBrandStatObject.scene;
            bso.wUJ.wDz = appBrandStatObject.cOq;
        }
        bso.wUJ.wDA = 1;
        C37402a xV = c45126b.mo34955xV();
        if (xV != null) {
            bso.wUJ.wDB = xV.getURL();
        }
        bso.wkG = jSONObject.toString();
        ((C42637a) c45126b.mo5936B(C42637a.class)).mo22168a("/cgi-bin/mmbiz-bin/wxabusiness/reportwxaappexpose", bso, bsp.class).mo15892c(new C5681a<Object, bsp>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(102006);
                bsp bsp = (bsp) obj;
                if (bsp == null) {
                    C4990ab.m7412e("Luggage.JsApiReportPageData", "reportwxaappexpose cgi failed, null response");
                    c45126b.mo6107M(i, C27053b.this.mo73394j("fail:cgi fail", null));
                    AppMethodBeat.m2505o(102006);
                } else if (bsp.BaseResponse.Ret != 0) {
                    C4990ab.m7413e("Luggage.JsApiReportPageData", "reportwxaappexpose cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(bsp.BaseResponse.Ret), bsp.BaseResponse.ErrMsg);
                    c45126b.mo6107M(i, C27053b.this.mo73394j("fail:cgi fail", null));
                    AppMethodBeat.m2505o(102006);
                } else {
                    C27052b.m42999bi(appId, bsp.wUK);
                    c45126b.mo6107M(i, C27053b.this.mo73394j("ok", null));
                    AppMethodBeat.m2505o(102006);
                }
                return null;
            }
        }).mo11586a((C5690a) new C5690a() {
            /* renamed from: bi */
            public final void mo9345bi(Object obj) {
                AppMethodBeat.m2504i(102005);
                C4990ab.m7413e("Luggage.JsApiReportPageData", "reportwxaappexpose cgi failed, message = %s", obj);
                c45126b.mo6107M(i, C27053b.this.mo73394j("fail:cgi fail", null));
                AppMethodBeat.m2505o(102005);
            }
        });
        AppMethodBeat.m2505o(102007);
    }
}
