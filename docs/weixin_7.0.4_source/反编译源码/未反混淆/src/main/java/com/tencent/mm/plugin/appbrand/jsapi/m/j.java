package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandTimePicker;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.d;
import com.tencent.mm.plugin.appbrand.widget.picker.f;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONObject;

final class j extends d {
    int hUA = BaseClientBuilder.API_PRIORITY_OTHER;
    int hUB = BaseClientBuilder.API_PRIORITY_OTHER;
    int hUC = -1;
    int hUD = -1;
    int hUy = -1;
    int hUz = -1;

    j() {
    }

    /* Access modifiers changed, original: final */
    public final void C(JSONObject jSONObject) {
        int[] EO;
        AppMethodBeat.i(126368);
        JSONObject optJSONObject = jSONObject.optJSONObject("range");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("start");
            String optString2 = optJSONObject.optString("end");
            int[] EO2 = f.EO(optString);
            if (EO2 != null) {
                this.hUy = EO2[0];
                this.hUz = EO2[1];
            }
            EO = f.EO(optString2);
            if (EO != null) {
                this.hUA = EO[0];
                this.hUB = EO[1];
            }
        }
        this.hUy = Math.max(this.hUy, 0);
        this.hUz = Math.max(this.hUz, 0);
        this.hUA = Math.min(this.hUA, 23);
        this.hUB = Math.min(this.hUB, 59);
        EO = f.EO(jSONObject.optString("current"));
        if (EO != null) {
            this.hUC = EO[0];
            this.hUD = EO[1];
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(126366);
                j jVar = j.this;
                AppBrandTimePicker appBrandTimePicker = (AppBrandTimePicker) jVar.an(AppBrandTimePicker.class);
                if (appBrandTimePicker == null) {
                    jVar.l("fail cant init view", null);
                    AppMethodBeat.o(126366);
                    return;
                }
                a aVar = jVar.jks;
                int i = jVar.hUy;
                int i2 = jVar.hUz;
                appBrandTimePicker.hUy = i;
                appBrandTimePicker.hUz = i2;
                if (f.qS(appBrandTimePicker.hUy) && appBrandTimePicker.jkY != null) {
                    appBrandTimePicker.jkY.setMinValue(appBrandTimePicker.hUy);
                }
                i = jVar.hUA;
                i2 = jVar.hUB;
                appBrandTimePicker.hUA = i;
                appBrandTimePicker.hUB = i2;
                if (f.qS(appBrandTimePicker.hUA) && appBrandTimePicker.jkY != null) {
                    appBrandTimePicker.jkY.setMaxValue(appBrandTimePicker.hUA);
                }
                i = jVar.hUC;
                i2 = jVar.hUD;
                if (f.qS(i) && f.qR(i2)) {
                    appBrandTimePicker.setCurrentHour(Integer.valueOf(i));
                    appBrandTimePicker.setCurrentMinute(Integer.valueOf(i2));
                }
                appBrandTimePicker.aRM();
                aVar.setOnResultListener(new d.a<String>() {
                    public final /* synthetic */ void b(boolean z, Object obj) {
                        AppMethodBeat.i(126367);
                        String str = (String) obj;
                        j jVar = j.this;
                        if (jVar.jks != null) {
                            jVar.jks.hide();
                        }
                        if (!z) {
                            jVar.l("cancel", null);
                            AppMethodBeat.o(126367);
                        } else if (bo.isNullOrNil(str)) {
                            jVar.l("fail", null);
                            AppMethodBeat.o(126367);
                        } else {
                            HashMap hashMap = new HashMap(1);
                            hashMap.put("value", str);
                            jVar.l("ok", hashMap);
                            AppMethodBeat.o(126367);
                        }
                    }
                });
                aVar.show();
                AppMethodBeat.o(126366);
            }
        });
        AppMethodBeat.o(126368);
    }
}
