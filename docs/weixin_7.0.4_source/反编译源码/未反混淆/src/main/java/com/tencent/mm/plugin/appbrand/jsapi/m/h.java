package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h extends a<e> {
    private static final int CTRL_INDEX = 258;
    private static final String NAME = "updateMultiPickerView";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(126359);
        new d() {
            /* Access modifiers changed, original: final */
            public final void C(JSONObject jSONObject) {
                AppMethodBeat.i(126357);
                final int optInt = jSONObject.optInt("column", -1);
                JSONArray optJSONArray = jSONObject.optJSONArray("array");
                if (optInt < 0 || optJSONArray == null || optJSONArray.length() < 0) {
                    l("fail:invalid data", null);
                    AppMethodBeat.o(126357);
                    return;
                }
                try {
                    String[] strArr = new String[optJSONArray.length()];
                    for (int i = 0; i < strArr.length; i++) {
                        strArr[i] = optJSONArray.getString(i);
                    }
                    final AppBrandMultiOptionsPicker.a aVar = new AppBrandMultiOptionsPicker.a(strArr, jSONObject.optInt("current", 0));
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(126356);
                            AppBrandMultiOptionsPicker appBrandMultiOptionsPicker = (AppBrandMultiOptionsPicker) AnonymousClass1.a(AnonymousClass1.this, AppBrandMultiOptionsPicker.class);
                            if (appBrandMultiOptionsPicker == null) {
                                AnonymousClass1.this.l("fail picker not exists", null);
                                AppMethodBeat.o(126356);
                                return;
                            }
                            int i = optInt;
                            AppBrandMultiOptionsPicker.a aVar = aVar;
                            if (i >= 0 && i < appBrandMultiOptionsPicker.getPickersCount() && aVar != null) {
                                appBrandMultiOptionsPicker.setLayoutFrozen(true);
                                appBrandMultiOptionsPicker.qP(i).setOptionsArray(aVar.jkK);
                                if (!bo.Q(aVar.jkK)) {
                                    appBrandMultiOptionsPicker.qP(i).setValue(aVar.jkL);
                                }
                                appBrandMultiOptionsPicker.setLayoutFrozen(false);
                            }
                            AnonymousClass1.this.l("ok", null);
                            AppMethodBeat.o(126356);
                        }
                    });
                    AppMethodBeat.o(126357);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.AppBrand.JsApiUpdateMultiPickerView", e, "opt params", new Object[0]);
                    l("fail:invalid data", null);
                    AppMethodBeat.o(126357);
                }
            }

            static /* synthetic */ b a(AnonymousClass1 anonymousClass1, Class cls) {
                AppMethodBeat.i(126358);
                com.tencent.mm.plugin.appbrand.widget.picker.a ff = super.ff(false);
                if (ff == null || !cls.isInstance(ff.getPicker())) {
                    AppMethodBeat.o(126358);
                    return null;
                }
                b picker = ff.getPicker();
                AppMethodBeat.o(126358);
                return picker;
            }
        }.a(this, (e) cVar, jSONObject, i);
        AppMethodBeat.o(126359);
    }
}
