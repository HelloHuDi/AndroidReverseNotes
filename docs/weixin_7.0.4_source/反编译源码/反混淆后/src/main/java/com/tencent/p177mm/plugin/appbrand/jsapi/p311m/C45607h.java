package com.tencent.p177mm.plugin.appbrand.jsapi.p311m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker;
import com.tencent.p177mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.C27421a;
import com.tencent.p177mm.plugin.appbrand.widget.picker.C36743a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.h */
public final class C45607h extends C10296a<C33303e> {
    private static final int CTRL_INDEX = 258;
    private static final String NAME = "updateMultiPickerView";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.h$1 */
    class C383421 extends C27024d {
        C383421() {
        }

        /* Access modifiers changed, original: final */
        /* renamed from: C */
        public final void mo21974C(JSONObject jSONObject) {
            AppMethodBeat.m2504i(126357);
            final int optInt = jSONObject.optInt("column", -1);
            JSONArray optJSONArray = jSONObject.optJSONArray("array");
            if (optInt < 0 || optJSONArray == null || optJSONArray.length() < 0) {
                mo44711l("fail:invalid data", null);
                AppMethodBeat.m2505o(126357);
                return;
            }
            try {
                String[] strArr = new String[optJSONArray.length()];
                for (int i = 0; i < strArr.length; i++) {
                    strArr[i] = optJSONArray.getString(i);
                }
                final C27421a c27421a = new C27421a(strArr, jSONObject.optInt("current", 0));
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(126356);
                        AppBrandMultiOptionsPicker appBrandMultiOptionsPicker = (AppBrandMultiOptionsPicker) C383421.m64883a(C383421.this, AppBrandMultiOptionsPicker.class);
                        if (appBrandMultiOptionsPicker == null) {
                            C383421.this.mo44711l("fail picker not exists", null);
                            AppMethodBeat.m2505o(126356);
                            return;
                        }
                        int i = optInt;
                        C27421a c27421a = c27421a;
                        if (i >= 0 && i < appBrandMultiOptionsPicker.getPickersCount() && c27421a != null) {
                            appBrandMultiOptionsPicker.setLayoutFrozen(true);
                            appBrandMultiOptionsPicker.mo68208qP(i).setOptionsArray(c27421a.jkK);
                            if (!C5046bo.m7510Q(c27421a.jkK)) {
                                appBrandMultiOptionsPicker.mo68208qP(i).setValue(c27421a.jkL);
                            }
                            appBrandMultiOptionsPicker.setLayoutFrozen(false);
                        }
                        C383421.this.mo44711l("ok", null);
                        AppMethodBeat.m2505o(126356);
                    }
                });
                AppMethodBeat.m2505o(126357);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrand.JsApiUpdateMultiPickerView", e, "opt params", new Object[0]);
                mo44711l("fail:invalid data", null);
                AppMethodBeat.m2505o(126357);
            }
        }

        /* renamed from: a */
        static /* synthetic */ C19427b m64883a(C383421 c383421, Class cls) {
            AppMethodBeat.m2504i(126358);
            C36743a ff = super.mo54198ff(false);
            if (ff == null || !cls.isInstance(ff.getPicker())) {
                AppMethodBeat.m2505o(126358);
                return null;
            }
            C19427b picker = ff.getPicker();
            AppMethodBeat.m2505o(126358);
            return picker;
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(126359);
        new C383421().mo44708a(this, (C33303e) c2241c, jSONObject, i);
        AppMethodBeat.m2505o(126359);
    }
}
