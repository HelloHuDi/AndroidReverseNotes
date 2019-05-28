package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.Map;
import org.json.JSONObject;

public final class d extends a<s> {
    public static final int CTRL_INDEX = 431;
    public static final String NAME = "requestMallPayment";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(131414);
        final s sVar = (s) cVar;
        if (jSONObject == null) {
            sVar.M(i, j("fail", null));
            AppMethodBeat.o(131414);
            return;
        }
        MMActivity mMActivity = (MMActivity) sVar.ad(MMActivity.class);
        if (mMActivity == null) {
            sVar.M(i, j("fail", null));
            AppMethodBeat.o(131414);
            return;
        }
        try {
            jSONObject.put("appId", sVar.getAppId());
            jSONObject.put("pay_for_wallet_type", 3);
            PString pString = new PString();
            if (a.hTJ.a(mMActivity, sVar.getRuntime().ya().bQn, jSONObject, new b.a() {
                public final void a(int i, String str, Map<String, Object> map) {
                    AppMethodBeat.i(131413);
                    switch (i) {
                        case 1:
                            sVar.M(i, d.this.j("ok", null));
                            AppMethodBeat.o(131413);
                            return;
                        case 2:
                            sVar.M(i, d.this.j("fail:".concat(String.valueOf(str)), null));
                            AppMethodBeat.o(131413);
                            return;
                        case 3:
                            sVar.M(i, d.this.j("cancel", null));
                            break;
                    }
                    AppMethodBeat.o(131413);
                }
            }, pString)) {
                w aun = sVar.aun();
                String str = pString.value;
                if (aun != null) {
                    MainProcessTask reportSubmitFormTask = new ReportSubmitFormTask(aun.getRuntime().ye());
                    reportSubmitFormTask.type = 0;
                    reportSubmitFormTask.hCT = str.replace("prepay_id=", "");
                    reportSubmitFormTask.pageId = aun.getURL();
                    AppBrandMainProcessService.a(reportSubmitFormTask);
                }
                AppMethodBeat.o(131414);
                return;
            }
            sVar.M(i, j("fail", null));
            AppMethodBeat.o(131414);
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiRequestMallPayment", e.getMessage());
            sVar.M(i, j("fail", null));
            AppMethodBeat.o(131414);
        }
    }
}
