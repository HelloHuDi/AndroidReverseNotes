package com.tencent.p177mm.plugin.appbrand.jsapi.p311m;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.widget.picker.AppBrandTimePicker;
import com.tencent.p177mm.plugin.appbrand.widget.picker.C2591f;
import com.tencent.p177mm.plugin.appbrand.widget.picker.C33642d.C33643a;
import com.tencent.p177mm.plugin.appbrand.widget.picker.C36743a;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.j */
final class C10464j extends C27024d {
    int hUA = BaseClientBuilder.API_PRIORITY_OTHER;
    int hUB = BaseClientBuilder.API_PRIORITY_OTHER;
    int hUC = -1;
    int hUD = -1;
    int hUy = -1;
    int hUz = -1;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.j$1 */
    class C104651 implements Runnable {
        C104651() {
        }

        public final void run() {
            AppMethodBeat.m2504i(126366);
            C10464j c10464j = C10464j.this;
            AppBrandTimePicker appBrandTimePicker = (AppBrandTimePicker) c10464j.mo54197an(AppBrandTimePicker.class);
            if (appBrandTimePicker == null) {
                c10464j.mo44711l("fail cant init view", null);
                AppMethodBeat.m2505o(126366);
                return;
            }
            C36743a c36743a = c10464j.jks;
            int i = c10464j.hUy;
            int i2 = c10464j.hUz;
            appBrandTimePicker.hUy = i;
            appBrandTimePicker.hUz = i2;
            if (C2591f.m4843qS(appBrandTimePicker.hUy) && appBrandTimePicker.jkY != null) {
                appBrandTimePicker.jkY.setMinValue(appBrandTimePicker.hUy);
            }
            i = c10464j.hUA;
            i2 = c10464j.hUB;
            appBrandTimePicker.hUA = i;
            appBrandTimePicker.hUB = i2;
            if (C2591f.m4843qS(appBrandTimePicker.hUA) && appBrandTimePicker.jkY != null) {
                appBrandTimePicker.jkY.setMaxValue(appBrandTimePicker.hUA);
            }
            i = c10464j.hUC;
            i2 = c10464j.hUD;
            if (C2591f.m4843qS(i) && C2591f.m4842qR(i2)) {
                appBrandTimePicker.setCurrentHour(Integer.valueOf(i));
                appBrandTimePicker.setCurrentMinute(Integer.valueOf(i2));
            }
            appBrandTimePicker.aRM();
            c36743a.setOnResultListener(new C104662());
            c36743a.show();
            AppMethodBeat.m2505o(126366);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.j$2 */
    class C104662 implements C33643a<String> {
        C104662() {
        }

        /* renamed from: b */
        public final /* synthetic */ void mo6189b(boolean z, Object obj) {
            AppMethodBeat.m2504i(126367);
            String str = (String) obj;
            C10464j c10464j = C10464j.this;
            if (c10464j.jks != null) {
                c10464j.jks.hide();
            }
            if (!z) {
                c10464j.mo44711l("cancel", null);
                AppMethodBeat.m2505o(126367);
            } else if (C5046bo.isNullOrNil(str)) {
                c10464j.mo44711l("fail", null);
                AppMethodBeat.m2505o(126367);
            } else {
                HashMap hashMap = new HashMap(1);
                hashMap.put("value", str);
                c10464j.mo44711l("ok", hashMap);
                AppMethodBeat.m2505o(126367);
            }
        }
    }

    C10464j() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: C */
    public final void mo21974C(JSONObject jSONObject) {
        int[] EO;
        AppMethodBeat.m2504i(126368);
        JSONObject optJSONObject = jSONObject.optJSONObject("range");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("start");
            String optString2 = optJSONObject.optString("end");
            int[] EO2 = C2591f.m4840EO(optString);
            if (EO2 != null) {
                this.hUy = EO2[0];
                this.hUz = EO2[1];
            }
            EO = C2591f.m4840EO(optString2);
            if (EO != null) {
                this.hUA = EO[0];
                this.hUB = EO[1];
            }
        }
        this.hUy = Math.max(this.hUy, 0);
        this.hUz = Math.max(this.hUz, 0);
        this.hUA = Math.min(this.hUA, 23);
        this.hUB = Math.min(this.hUB, 59);
        EO = C2591f.m4840EO(jSONObject.optString("current"));
        if (EO != null) {
            this.hUC = EO[0];
            this.hUD = EO[1];
        }
        C5004al.m7441d(new C104651());
        AppMethodBeat.m2505o(126368);
    }
}
