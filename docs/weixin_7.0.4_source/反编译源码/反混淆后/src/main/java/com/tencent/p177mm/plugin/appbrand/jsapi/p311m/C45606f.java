package com.tencent.p177mm.plugin.appbrand.jsapi.p311m;

import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker;
import com.tencent.p177mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.C27421a;
import com.tencent.p177mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.C367422;
import com.tencent.p177mm.plugin.appbrand.widget.picker.C33641c;
import com.tencent.p177mm.plugin.appbrand.widget.picker.C33642d.C33643a;
import com.tencent.p177mm.plugin.appbrand.widget.picker.C33642d.C33644b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.f */
public final class C45606f extends C10296a<C33303e> {
    private static final int CTRL_INDEX = 257;
    private static final String NAME = "showMultiPickerView";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.f$a */
    static final class C38340a extends C42467ah {
        private static final int CTRL_INDEX = 259;
        private static final String NAME = "onMultiPickerViewChange";

        private C38340a() {
        }

        /* synthetic */ C38340a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.f$b */
    final class C42537b extends C27024d implements Runnable {
        private final AtomicReference<C27421a[]> hUm;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.f$b$1 */
        class C23121 implements Runnable {
            C23121() {
            }

            public final void run() {
                AppMethodBeat.m2504i(126346);
                C42537b.this.aEL();
                AppMethodBeat.m2505o(126346);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.f$b$2 */
        class C23132 implements Runnable {
            C23132() {
            }

            public final void run() {
                AppMethodBeat.m2504i(126347);
                C42537b.m75313a(C42537b.this);
                AppMethodBeat.m2505o(126347);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.f$b$3 */
        class C23143 implements C33643a<int[]> {
            C23143() {
            }

            /* renamed from: b */
            public final /* synthetic */ void mo6189b(boolean z, Object obj) {
                AppMethodBeat.m2504i(126348);
                int[] iArr = (int[]) obj;
                C42537b.this.jks.hide();
                if (!z) {
                    C42537b.this.mo44711l("cancel", null);
                    AppMethodBeat.m2505o(126348);
                } else if (iArr == null || iArr.length <= 0) {
                    C42537b.this.mo44711l("fail error result", null);
                    AppMethodBeat.m2505o(126348);
                } else {
                    JSONArray jSONArray = new JSONArray();
                    for (int put : iArr) {
                        jSONArray.put(put);
                    }
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("current", jSONArray);
                    C42537b.this.mo44711l("ok", hashMap);
                    AppMethodBeat.m2505o(126348);
                }
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.f$b$4 */
        class C194304 implements C33644b<int[]> {
            C194304() {
            }

            /* renamed from: bw */
            public final /* synthetic */ void mo34564bw(Object obj) {
                C2241c c2241c;
                AppMethodBeat.m2504i(126349);
                int[] iArr = (int[]) obj;
                int i = iArr[0];
                int i2 = iArr[1];
                C38340a c38340a = new C38340a();
                HashMap hashMap = new HashMap(2);
                hashMap.put("errMsg", "ok");
                hashMap.put("column", Integer.valueOf(i));
                hashMap.put("current", Integer.valueOf(i2));
                c38340a.mo34958t(hashMap);
                C42537b c42537b = C42537b.this;
                if (c42537b.hUk == null) {
                    c2241c = null;
                } else {
                    C33303e c2241c2 = (C33303e) c42537b.hUk.get();
                }
                if (c2241c2 == null) {
                    AppMethodBeat.m2505o(126349);
                    return;
                }
                c38340a.mo61032j(c2241c2).aCj();
                AppMethodBeat.m2505o(126349);
            }
        }

        private C42537b() {
            AppMethodBeat.m2504i(126350);
            this.hUm = new AtomicReference();
            AppMethodBeat.m2505o(126350);
        }

        /* synthetic */ C42537b(C45606f c45606f, byte b) {
            this();
        }

        /* renamed from: a */
        static /* synthetic */ void m75313a(C42537b c42537b) {
            AppMethodBeat.m2504i(126353);
            super.aEL();
            AppMethodBeat.m2505o(126353);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: C */
        public final void mo21974C(JSONObject jSONObject) {
            AppMethodBeat.m2504i(126351);
            JSONArray optJSONArray = jSONObject.optJSONArray("array");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("current");
            if (optJSONArray == null || optJSONArray2 == null || optJSONArray.length() != optJSONArray2.length()) {
                mo44711l("fail:invalid data", null);
                AppMethodBeat.m2505o(126351);
            } else if (optJSONArray.length() <= 0) {
                mo44711l("ok", null);
                C4990ab.m7416i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (one-dimensional)");
                C45673m.runOnUiThread(new C23121());
                AppMethodBeat.m2505o(126351);
            } else {
                try {
                    C27421a[] c27421aArr = new C27421a[optJSONArray.length()];
                    int i = 1;
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        int i3;
                        JSONArray jSONArray = optJSONArray.getJSONArray(i2);
                        int i4 = optJSONArray2.getInt(i2);
                        String[] strArr = new String[jSONArray.length()];
                        for (i3 = 0; i3 < strArr.length; i3++) {
                            strArr[i3] = jSONArray.getString(i3);
                        }
                        c27421aArr[i2] = new C27421a(strArr, i4);
                        if (jSONArray.length() <= 0) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        i &= i3;
                    }
                    if (i != 0) {
                        mo44711l("ok", null);
                        C4990ab.m7416i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (multi-dimensional)");
                        C45673m.runOnUiThread(new C23132());
                        AppMethodBeat.m2505o(126351);
                        return;
                    }
                    this.hUm.set(c27421aArr);
                    C5004al.m7441d(this);
                    AppMethodBeat.m2505o(126351);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.JsApiShowMultiPickerView", e, "opt params", new Object[0]);
                    mo44711l("fail:invalid data", null);
                    AppMethodBeat.m2505o(126351);
                }
            }
        }

        public final void run() {
            AppMethodBeat.m2504i(126352);
            AppBrandMultiOptionsPicker appBrandMultiOptionsPicker = (AppBrandMultiOptionsPicker) mo54197an(AppBrandMultiOptionsPicker.class);
            if (appBrandMultiOptionsPicker == null) {
                mo44711l("fail cant init view", null);
                AppMethodBeat.m2505o(126352);
                return;
            }
            C27421a[] c27421aArr = (C27421a[]) this.hUm.get();
            if (c27421aArr == null || c27421aArr.length <= 0) {
                mo44711l("fail error data", null);
                AppMethodBeat.m2505o(126352);
                return;
            }
            if (c27421aArr != null && c27421aArr.length > 0) {
                int pickersCount = appBrandMultiOptionsPicker.getPickersCount();
                appBrandMultiOptionsPicker.setLayoutFrozen(true);
                if (pickersCount < c27421aArr.length) {
                    pickersCount = c27421aArr.length - pickersCount;
                    if (pickersCount > 0) {
                        while (pickersCount > 0) {
                            C367422 c367422 = new C367422(appBrandMultiOptionsPicker.getContext());
                            c367422.setOnValueChangedListener(appBrandMultiOptionsPicker.jkI);
                            c367422.setEllipsizeType("end");
                            c367422.setDividerHeight(C1338a.fromDPToPix(appBrandMultiOptionsPicker.getContext(), 1));
                            c367422.setTag(2131820565, Integer.valueOf(appBrandMultiOptionsPicker.jkF.getChildCount()));
                            appBrandMultiOptionsPicker.jkF.addView(c367422, new LayoutParams(0, -1, 1.0f));
                            pickersCount--;
                        }
                    }
                } else if (pickersCount > c27421aArr.length) {
                    appBrandMultiOptionsPicker.mo68209qQ(pickersCount - c27421aArr.length);
                }
                for (pickersCount = 0; pickersCount < c27421aArr.length; pickersCount++) {
                    C33641c qP = appBrandMultiOptionsPicker.mo68208qP(pickersCount);
                    C27421a c27421a = c27421aArr[pickersCount];
                    qP.setOptionsArray(c27421a.jkK);
                    qP.setValue(c27421a.jkL);
                    qP.setOnValueChangedListener(appBrandMultiOptionsPicker.jkI);
                }
                appBrandMultiOptionsPicker.jkF.setWeightSum((float) appBrandMultiOptionsPicker.getPickersCount());
                appBrandMultiOptionsPicker.setLayoutFrozen(false);
            }
            this.jks.setOnResultListener(new C23143());
            this.jks.setOnValueUpdateListener(new C194304());
            this.jks.show();
            AppMethodBeat.m2505o(126352);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(126354);
        new C42537b(this, (byte) 0).mo44708a(this, (C33303e) c2241c, jSONObject, i);
        AppMethodBeat.m2505o(126354);
    }
}
