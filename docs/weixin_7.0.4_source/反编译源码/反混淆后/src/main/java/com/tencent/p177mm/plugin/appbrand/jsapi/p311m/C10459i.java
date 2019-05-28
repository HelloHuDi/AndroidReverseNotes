package com.tencent.p177mm.plugin.appbrand.jsapi.p311m;

import android.view.View;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.widget.picker.AppBrandOptionsPicker;
import com.tencent.p177mm.plugin.appbrand.widget.picker.C33642d.C33643a;
import com.tencent.p177mm.plugin.appbrand.widget.picker.C36743a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.i */
final class C10459i extends C27024d {

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.i$3 */
    class C104603 implements Runnable {
        final /* synthetic */ C36743a hUw;

        C104603(C36743a c36743a) {
            this.hUw = c36743a;
        }

        public final void run() {
            AppMethodBeat.m2504i(126362);
            if (this.hUw.getPicker() != null && (this.hUw.getPicker() instanceof View)) {
                ((View) this.hUw.getPicker()).requestLayout();
            }
            AppMethodBeat.m2505o(126362);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.i$4 */
    class C104614 implements C33643a<String> {
        final /* synthetic */ C36743a hUw;
        final /* synthetic */ AppBrandOptionsPicker hUx;

        C104614(C36743a c36743a, AppBrandOptionsPicker appBrandOptionsPicker) {
            this.hUw = c36743a;
            this.hUx = appBrandOptionsPicker;
        }

        /* renamed from: b */
        public final /* synthetic */ void mo6189b(boolean z, Object obj) {
            AppMethodBeat.m2504i(126363);
            this.hUw.hide();
            if (z) {
                HashMap hashMap = new HashMap(2);
                hashMap.put("value", this.hUx.aRK());
                hashMap.put(C8741b.INDEX, Integer.valueOf(this.hUx.getValue()));
                C10459i.this.mo44711l("ok", hashMap);
                AppMethodBeat.m2505o(126363);
                return;
            }
            C10459i.this.mo44711l("cancel", null);
            AppMethodBeat.m2505o(126363);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.i$1 */
    class C104621 implements Runnable {
        C104621() {
        }

        public final void run() {
            AppMethodBeat.m2504i(126360);
            C10459i.m18186a(C10459i.this);
            AppMethodBeat.m2505o(126360);
        }
    }

    C10459i() {
    }

    /* renamed from: a */
    static /* synthetic */ void m18186a(C10459i c10459i) {
        AppMethodBeat.m2504i(126365);
        super.aEL();
        AppMethodBeat.m2505o(126365);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: C */
    public final void mo21974C(JSONObject jSONObject) {
        AppMethodBeat.m2504i(126364);
        JSONArray optJSONArray = jSONObject.optJSONArray("array");
        final int optInt = jSONObject.optInt("current", 0);
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            C4990ab.m7416i("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "showPickerView as selector, empty range");
            mo44711l("ok", null);
            C45673m.runOnUiThread(new C104621());
            AppMethodBeat.m2505o(126364);
            return;
        }
        final String[] strArr = new String[optJSONArray.length()];
        int i = 0;
        while (i < optJSONArray.length()) {
            try {
                strArr[i] = optJSONArray.getString(i);
                i++;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "opt data.array, exp = %s", C5046bo.m7574l(e));
                mo44711l("fail", null);
                AppMethodBeat.m2505o(126364);
                return;
            }
        }
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(126361);
                C10459i c10459i = C10459i.this;
                String[] strArr = strArr;
                int i = optInt;
                AppBrandOptionsPicker appBrandOptionsPicker = (AppBrandOptionsPicker) c10459i.mo54197an(AppBrandOptionsPicker.class);
                if (appBrandOptionsPicker == null) {
                    c10459i.mo44711l("fail cant init view", null);
                    AppMethodBeat.m2505o(126361);
                    return;
                }
                C36743a c36743a = c10459i.jks;
                c36743a.post(new C104603(c36743a));
                appBrandOptionsPicker.setOptionsArray(strArr);
                appBrandOptionsPicker.setValue(i);
                c36743a.setOnResultListener(new C104614(c36743a, appBrandOptionsPicker));
                c36743a.show();
                AppMethodBeat.m2505o(126361);
            }
        });
        AppMethodBeat.m2505o(126364);
    }
}
