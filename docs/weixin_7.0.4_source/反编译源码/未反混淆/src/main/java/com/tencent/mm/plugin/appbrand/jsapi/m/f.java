package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f extends com.tencent.mm.plugin.appbrand.jsapi.a<e> {
    private static final int CTRL_INDEX = 257;
    private static final String NAME = "showMultiPickerView";

    static final class a extends ah {
        private static final int CTRL_INDEX = 259;
        private static final String NAME = "onMultiPickerViewChange";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    final class b extends d implements Runnable {
        private final AtomicReference<com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a[]> hUm;

        private b() {
            AppMethodBeat.i(126350);
            this.hUm = new AtomicReference();
            AppMethodBeat.o(126350);
        }

        /* synthetic */ b(f fVar, byte b) {
            this();
        }

        static /* synthetic */ void a(b bVar) {
            AppMethodBeat.i(126353);
            super.aEL();
            AppMethodBeat.o(126353);
        }

        /* Access modifiers changed, original: final */
        public final void C(JSONObject jSONObject) {
            AppMethodBeat.i(126351);
            JSONArray optJSONArray = jSONObject.optJSONArray("array");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("current");
            if (optJSONArray == null || optJSONArray2 == null || optJSONArray.length() != optJSONArray2.length()) {
                l("fail:invalid data", null);
                AppMethodBeat.o(126351);
            } else if (optJSONArray.length() <= 0) {
                l("ok", null);
                ab.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (one-dimensional)");
                m.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(126346);
                        b.this.aEL();
                        AppMethodBeat.o(126346);
                    }
                });
                AppMethodBeat.o(126351);
            } else {
                try {
                    com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a[] aVarArr = new com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a[optJSONArray.length()];
                    int i = 1;
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        int i3;
                        JSONArray jSONArray = optJSONArray.getJSONArray(i2);
                        int i4 = optJSONArray2.getInt(i2);
                        String[] strArr = new String[jSONArray.length()];
                        for (i3 = 0; i3 < strArr.length; i3++) {
                            strArr[i3] = jSONArray.getString(i3);
                        }
                        aVarArr[i2] = new com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a(strArr, i4);
                        if (jSONArray.length() <= 0) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        i &= i3;
                    }
                    if (i != 0) {
                        l("ok", null);
                        ab.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (multi-dimensional)");
                        m.runOnUiThread(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(126347);
                                b.a(b.this);
                                AppMethodBeat.o(126347);
                            }
                        });
                        AppMethodBeat.o(126351);
                        return;
                    }
                    this.hUm.set(aVarArr);
                    al.d(this);
                    AppMethodBeat.o(126351);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.JsApiShowMultiPickerView", e, "opt params", new Object[0]);
                    l("fail:invalid data", null);
                    AppMethodBeat.o(126351);
                }
            }
        }

        public final void run() {
            AppMethodBeat.i(126352);
            AppBrandMultiOptionsPicker appBrandMultiOptionsPicker = (AppBrandMultiOptionsPicker) an(AppBrandMultiOptionsPicker.class);
            if (appBrandMultiOptionsPicker == null) {
                l("fail cant init view", null);
                AppMethodBeat.o(126352);
                return;
            }
            com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a[] aVarArr = (com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a[]) this.hUm.get();
            if (aVarArr == null || aVarArr.length <= 0) {
                l("fail error data", null);
                AppMethodBeat.o(126352);
                return;
            }
            if (aVarArr != null && aVarArr.length > 0) {
                int pickersCount = appBrandMultiOptionsPicker.getPickersCount();
                appBrandMultiOptionsPicker.setLayoutFrozen(true);
                if (pickersCount < aVarArr.length) {
                    pickersCount = aVarArr.length - pickersCount;
                    if (pickersCount > 0) {
                        while (pickersCount > 0) {
                            com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.AnonymousClass2 anonymousClass2 = new com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.AnonymousClass2(appBrandMultiOptionsPicker.getContext());
                            anonymousClass2.setOnValueChangedListener(appBrandMultiOptionsPicker.jkI);
                            anonymousClass2.setEllipsizeType("end");
                            anonymousClass2.setDividerHeight(com.tencent.mm.bz.a.fromDPToPix(appBrandMultiOptionsPicker.getContext(), 1));
                            anonymousClass2.setTag(R.id.v, Integer.valueOf(appBrandMultiOptionsPicker.jkF.getChildCount()));
                            appBrandMultiOptionsPicker.jkF.addView(anonymousClass2, new LayoutParams(0, -1, 1.0f));
                            pickersCount--;
                        }
                    }
                } else if (pickersCount > aVarArr.length) {
                    appBrandMultiOptionsPicker.qQ(pickersCount - aVarArr.length);
                }
                for (pickersCount = 0; pickersCount < aVarArr.length; pickersCount++) {
                    c qP = appBrandMultiOptionsPicker.qP(pickersCount);
                    com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a aVar = aVarArr[pickersCount];
                    qP.setOptionsArray(aVar.jkK);
                    qP.setValue(aVar.jkL);
                    qP.setOnValueChangedListener(appBrandMultiOptionsPicker.jkI);
                }
                appBrandMultiOptionsPicker.jkF.setWeightSum((float) appBrandMultiOptionsPicker.getPickersCount());
                appBrandMultiOptionsPicker.setLayoutFrozen(false);
            }
            this.jks.setOnResultListener(new com.tencent.mm.plugin.appbrand.widget.picker.d.a<int[]>() {
                public final /* synthetic */ void b(boolean z, Object obj) {
                    AppMethodBeat.i(126348);
                    int[] iArr = (int[]) obj;
                    b.this.jks.hide();
                    if (!z) {
                        b.this.l("cancel", null);
                        AppMethodBeat.o(126348);
                    } else if (iArr == null || iArr.length <= 0) {
                        b.this.l("fail error result", null);
                        AppMethodBeat.o(126348);
                    } else {
                        JSONArray jSONArray = new JSONArray();
                        for (int put : iArr) {
                            jSONArray.put(put);
                        }
                        HashMap hashMap = new HashMap(1);
                        hashMap.put("current", jSONArray);
                        b.this.l("ok", hashMap);
                        AppMethodBeat.o(126348);
                    }
                }
            });
            this.jks.setOnValueUpdateListener(new com.tencent.mm.plugin.appbrand.widget.picker.d.b<int[]>() {
                public final /* synthetic */ void bw(Object obj) {
                    com.tencent.mm.plugin.appbrand.jsapi.c cVar;
                    AppMethodBeat.i(126349);
                    int[] iArr = (int[]) obj;
                    int i = iArr[0];
                    int i2 = iArr[1];
                    a aVar = new a();
                    HashMap hashMap = new HashMap(2);
                    hashMap.put("errMsg", "ok");
                    hashMap.put("column", Integer.valueOf(i));
                    hashMap.put("current", Integer.valueOf(i2));
                    aVar.t(hashMap);
                    b bVar = b.this;
                    if (bVar.hUk == null) {
                        cVar = null;
                    } else {
                        e cVar2 = (e) bVar.hUk.get();
                    }
                    if (cVar2 == null) {
                        AppMethodBeat.o(126349);
                        return;
                    }
                    aVar.j(cVar2).aCj();
                    AppMethodBeat.o(126349);
                }
            });
            this.jks.show();
            AppMethodBeat.o(126352);
        }
    }

    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(126354);
        new b(this, (byte) 0).a(this, (e) cVar, jSONObject, i);
        AppMethodBeat.o(126354);
    }
}
