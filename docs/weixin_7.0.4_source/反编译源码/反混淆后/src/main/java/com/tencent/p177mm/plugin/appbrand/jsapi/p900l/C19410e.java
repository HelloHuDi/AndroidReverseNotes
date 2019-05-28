package com.tencent.p177mm.plugin.appbrand.jsapi.p900l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C10443b.C10444a;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.l.e */
public final class C19410e extends C10296a<C33327h> {
    public static final int CTRL_INDEX = 57;
    public static final String NAME = "requestPayment";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(131416);
        final C33327h c33327h = (C33327h) c2241c;
        if (jSONObject == null) {
            c33327h.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131416);
            return;
        }
        C41243o c41243o = (C41243o) c33327h.getRuntime();
        MMActivity atM = c41243o.atM();
        if (atM == null) {
            c33327h.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131416);
            return;
        }
        String currentUrl = c41243o.atJ().getCurrentUrl();
        String str = c41243o.atI().username;
        try {
            jSONObject.put("appId", c33327h.getAppId());
            jSONObject.put("key_appbrand_from_path", currentUrl);
            jSONObject.put("key_appbrand_from_username", str);
            PString pString = new PString();
            if (C42531a.hTJ.mo67992a(atM, c41243o.mo43491ya().bQn, jSONObject, new C10444a() {
                /* renamed from: a */
                public final void mo21960a(int i, String str, Map<String, Object> map) {
                    AppMethodBeat.m2504i(131415);
                    switch (i) {
                        case 1:
                            c33327h.mo6107M(i, C19410e.this.mo73394j("ok", null));
                            AppMethodBeat.m2505o(131415);
                            return;
                        case 2:
                            c33327h.mo6107M(i, C19410e.this.mo73394j("fail:".concat(String.valueOf(str)), null));
                            AppMethodBeat.m2505o(131415);
                            return;
                        case 3:
                            c33327h.mo6107M(i, C19410e.this.mo73394j("cancel", null));
                            break;
                    }
                    AppMethodBeat.m2505o(131415);
                }
            }, pString)) {
                if (jSONObject.optBoolean("grantMessageQuota", true)) {
                    C44709u c44709u;
                    if (c33327h instanceof C44709u) {
                        c44709u = (C44709u) c33327h;
                    } else {
                        c44709u = ((C38492q) c33327h).getCurrentPageView();
                    }
                    currentUrl = pString.value;
                    if (c44709u != null) {
                        MainProcessTask reportSubmitFormTask = new ReportSubmitFormTask(c44709u.getRuntime().mo15034ye());
                        reportSubmitFormTask.type = 0;
                        reportSubmitFormTask.hCT = currentUrl.replace("prepay_id=", "");
                        reportSubmitFormTask.pageId = c44709u.getURL();
                        AppBrandMainProcessService.m54349a(reportSubmitFormTask);
                    }
                }
                AppMethodBeat.m2505o(131416);
                return;
            }
            c33327h.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131416);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.JsApiRequestPayment", e.getMessage());
            c33327h.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131416);
        }
    }
}
