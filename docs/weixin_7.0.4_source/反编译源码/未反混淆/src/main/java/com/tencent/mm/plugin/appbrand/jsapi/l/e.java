package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.Map;
import org.json.JSONObject;

public final class e extends a<h> {
    public static final int CTRL_INDEX = 57;
    public static final String NAME = "requestPayment";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(131416);
        final h hVar = (h) cVar;
        if (jSONObject == null) {
            hVar.M(i, j("fail", null));
            AppMethodBeat.o(131416);
            return;
        }
        o oVar = (o) hVar.getRuntime();
        MMActivity atM = oVar.atM();
        if (atM == null) {
            hVar.M(i, j("fail", null));
            AppMethodBeat.o(131416);
            return;
        }
        String currentUrl = oVar.atJ().getCurrentUrl();
        String str = oVar.atI().username;
        try {
            jSONObject.put("appId", hVar.getAppId());
            jSONObject.put("key_appbrand_from_path", currentUrl);
            jSONObject.put("key_appbrand_from_username", str);
            PString pString = new PString();
            if (a.hTJ.a(atM, oVar.ya().bQn, jSONObject, new b.a() {
                public final void a(int i, String str, Map<String, Object> map) {
                    AppMethodBeat.i(131415);
                    switch (i) {
                        case 1:
                            hVar.M(i, e.this.j("ok", null));
                            AppMethodBeat.o(131415);
                            return;
                        case 2:
                            hVar.M(i, e.this.j("fail:".concat(String.valueOf(str)), null));
                            AppMethodBeat.o(131415);
                            return;
                        case 3:
                            hVar.M(i, e.this.j("cancel", null));
                            break;
                    }
                    AppMethodBeat.o(131415);
                }
            }, pString)) {
                if (jSONObject.optBoolean("grantMessageQuota", true)) {
                    u uVar;
                    if (hVar instanceof u) {
                        uVar = (u) hVar;
                    } else {
                        uVar = ((q) hVar).getCurrentPageView();
                    }
                    currentUrl = pString.value;
                    if (uVar != null) {
                        MainProcessTask reportSubmitFormTask = new ReportSubmitFormTask(uVar.getRuntime().ye());
                        reportSubmitFormTask.type = 0;
                        reportSubmitFormTask.hCT = currentUrl.replace("prepay_id=", "");
                        reportSubmitFormTask.pageId = uVar.getURL();
                        AppBrandMainProcessService.a(reportSubmitFormTask);
                    }
                }
                AppMethodBeat.o(131416);
                return;
            }
            hVar.M(i, j("fail", null));
            AppMethodBeat.o(131416);
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiRequestPayment", e.getMessage());
            hVar.M(i, j("fail", null));
            AppMethodBeat.o(131416);
        }
    }
}
