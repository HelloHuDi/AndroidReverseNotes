package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONObject;

public final class k extends a {
    public static final int CTRL_INDEX = 229;
    public static final String NAME = "setScreenBrightness";
    float hXJ = Float.NaN;
    float hXK;

    public final void a(final c cVar, final JSONObject jSONObject, final int i) {
        AppMethodBeat.i(126432);
        ab.d("MicroMsg.JsApiSetScreenBrightness", "JsApiSetScreenBrightness!");
        if (jSONObject == null) {
            cVar.M(i, j("fail:data is null", null));
            ab.e("MicroMsg.JsApiSetScreenBrightness", "data is null");
            AppMethodBeat.o(126432);
        } else if (cVar.getContext() instanceof Activity) {
            al.d(new Runnable() {
                public final void run() {
                    float f = 0.01f;
                    AppMethodBeat.i(126431);
                    k.this.hXK = (float) jSONObject.optDouble("value");
                    if (Float.isNaN(k.this.hXK) || k.this.hXK < 0.0f || k.this.hXK > 1.0f) {
                        cVar.M(i, k.this.j("fail:value invalid", null));
                        ab.e("MicroMsg.JsApiSetScreenBrightness", "value invalid");
                        AppMethodBeat.o(126431);
                        return;
                    }
                    Context context = cVar.getContext();
                    if (context == null) {
                        cVar.M(i, k.this.j("fail", null));
                        ab.e("MicroMsg.JsApiSetScreenBrightness", "context is null, invoke fail!");
                        AppMethodBeat.o(126431);
                    } else if (cVar.getContext() instanceof Activity) {
                        final Activity activity = (Activity) context;
                        final LayoutParams attributes = activity.getWindow().getAttributes();
                        if (Float.isNaN(k.this.hXJ)) {
                            k.this.hXJ = attributes.screenBrightness;
                            g.a(cVar.getAppId(), new g.c() {
                                public final void a(d dVar) {
                                    AppMethodBeat.i(126429);
                                    attributes.screenBrightness = k.this.hXJ;
                                    activity.getWindow().setAttributes(attributes);
                                    AppMethodBeat.o(126429);
                                }

                                public final void onResume() {
                                    AppMethodBeat.i(126430);
                                    attributes.screenBrightness = k.this.hXK;
                                    activity.getWindow().setAttributes(attributes);
                                    AppMethodBeat.o(126430);
                                }
                            });
                        }
                        if (k.this.hXK >= 0.01f) {
                            f = k.this.hXK;
                        }
                        attributes.screenBrightness = f;
                        activity.getWindow().setAttributes(attributes);
                        cVar.M(i, k.this.j("ok", null));
                        AppMethodBeat.o(126431);
                    } else {
                        ab.e("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
                        cVar.M(i, k.this.j("fail:context is not activity", null));
                        AppMethodBeat.o(126431);
                    }
                }
            });
            AppMethodBeat.o(126432);
        } else {
            ab.e("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
            cVar.M(i, j("fail:context is not activity", null));
            AppMethodBeat.o(126432);
        }
    }
}
