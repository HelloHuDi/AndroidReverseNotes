package com.tencent.p177mm.plugin.appbrand.jsapi.p900l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C10443b.C10444a;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.l.d */
public final class C27016d extends C10296a<C19722s> {
    public static final int CTRL_INDEX = 431;
    public static final String NAME = "requestMallPayment";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(131414);
        final C19722s c19722s = (C19722s) c2241c;
        if (jSONObject == null) {
            c19722s.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131414);
            return;
        }
        MMActivity mMActivity = (MMActivity) c19722s.mo61197ad(MMActivity.class);
        if (mMActivity == null) {
            c19722s.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131414);
            return;
        }
        try {
            jSONObject.put("appId", c19722s.getAppId());
            jSONObject.put("pay_for_wallet_type", 3);
            PString pString = new PString();
            if (C42531a.hTJ.mo67992a(mMActivity, c19722s.getRuntime().mo43491ya().bQn, jSONObject, new C10444a() {
                /* renamed from: a */
                public final void mo21960a(int i, String str, Map<String, Object> map) {
                    AppMethodBeat.m2504i(131413);
                    switch (i) {
                        case 1:
                            c19722s.mo6107M(i, C27016d.this.mo73394j("ok", null));
                            AppMethodBeat.m2505o(131413);
                            return;
                        case 2:
                            c19722s.mo6107M(i, C27016d.this.mo73394j("fail:".concat(String.valueOf(str)), null));
                            AppMethodBeat.m2505o(131413);
                            return;
                        case 3:
                            c19722s.mo6107M(i, C27016d.this.mo73394j("cancel", null));
                            break;
                    }
                    AppMethodBeat.m2505o(131413);
                }
            }, pString)) {
                C27242w aun = c19722s.aun();
                String str = pString.value;
                if (aun != null) {
                    MainProcessTask reportSubmitFormTask = new ReportSubmitFormTask(aun.getRuntime().mo15034ye());
                    reportSubmitFormTask.type = 0;
                    reportSubmitFormTask.hCT = str.replace("prepay_id=", "");
                    reportSubmitFormTask.pageId = aun.getURL();
                    AppBrandMainProcessService.m54349a(reportSubmitFormTask);
                }
                AppMethodBeat.m2505o(131414);
                return;
            }
            c19722s.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131414);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.JsApiRequestMallPayment", e.getMessage());
            c19722s.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131414);
        }
    }
}
