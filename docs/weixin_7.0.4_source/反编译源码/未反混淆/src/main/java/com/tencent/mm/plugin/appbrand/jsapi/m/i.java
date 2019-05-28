package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.view.View;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

final class i extends d {

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.i$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ a hUw;

        AnonymousClass3(a aVar) {
            this.hUw = aVar;
        }

        public final void run() {
            AppMethodBeat.i(126362);
            if (this.hUw.getPicker() != null && (this.hUw.getPicker() instanceof View)) {
                ((View) this.hUw.getPicker()).requestLayout();
            }
            AppMethodBeat.o(126362);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.i$4 */
    class AnonymousClass4 implements d.a<String> {
        final /* synthetic */ a hUw;
        final /* synthetic */ AppBrandOptionsPicker hUx;

        AnonymousClass4(a aVar, AppBrandOptionsPicker appBrandOptionsPicker) {
            this.hUw = aVar;
            this.hUx = appBrandOptionsPicker;
        }

        public final /* synthetic */ void b(boolean z, Object obj) {
            AppMethodBeat.i(126363);
            this.hUw.hide();
            if (z) {
                HashMap hashMap = new HashMap(2);
                hashMap.put("value", this.hUx.aRK());
                hashMap.put(b.INDEX, Integer.valueOf(this.hUx.getValue()));
                i.this.l("ok", hashMap);
                AppMethodBeat.o(126363);
                return;
            }
            i.this.l("cancel", null);
            AppMethodBeat.o(126363);
        }
    }

    i() {
    }

    static /* synthetic */ void a(i iVar) {
        AppMethodBeat.i(126365);
        super.aEL();
        AppMethodBeat.o(126365);
    }

    /* Access modifiers changed, original: final */
    public final void C(JSONObject jSONObject) {
        AppMethodBeat.i(126364);
        JSONArray optJSONArray = jSONObject.optJSONArray("array");
        final int optInt = jSONObject.optInt("current", 0);
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            ab.i("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "showPickerView as selector, empty range");
            l("ok", null);
            m.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(126360);
                    i.a(i.this);
                    AppMethodBeat.o(126360);
                }
            });
            AppMethodBeat.o(126364);
            return;
        }
        final String[] strArr = new String[optJSONArray.length()];
        int i = 0;
        while (i < optJSONArray.length()) {
            try {
                strArr[i] = optJSONArray.getString(i);
                i++;
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "opt data.array, exp = %s", bo.l(e));
                l("fail", null);
                AppMethodBeat.o(126364);
                return;
            }
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(126361);
                i iVar = i.this;
                String[] strArr = strArr;
                int i = optInt;
                AppBrandOptionsPicker appBrandOptionsPicker = (AppBrandOptionsPicker) iVar.an(AppBrandOptionsPicker.class);
                if (appBrandOptionsPicker == null) {
                    iVar.l("fail cant init view", null);
                    AppMethodBeat.o(126361);
                    return;
                }
                a aVar = iVar.jks;
                aVar.post(new AnonymousClass3(aVar));
                appBrandOptionsPicker.setOptionsArray(strArr);
                appBrandOptionsPicker.setValue(i);
                aVar.setOnResultListener(new AnonymousClass4(aVar, appBrandOptionsPicker));
                aVar.show();
                AppMethodBeat.o(126361);
            }
        });
        AppMethodBeat.o(126364);
    }
}
