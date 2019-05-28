package com.tencent.p177mm.plugin.appbrand.jsapi.p314q;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.q.k */
public final class C16676k extends C10296a {
    public static final int CTRL_INDEX = 229;
    public static final String NAME = "setScreenBrightness";
    float hXJ = Float.NaN;
    float hXK;

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, final JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(126432);
        C4990ab.m7410d("MicroMsg.JsApiSetScreenBrightness", "JsApiSetScreenBrightness!");
        if (jSONObject == null) {
            c2241c.mo6107M(i, mo73394j("fail:data is null", null));
            C4990ab.m7412e("MicroMsg.JsApiSetScreenBrightness", "data is null");
            AppMethodBeat.m2505o(126432);
        } else if (c2241c.getContext() instanceof Activity) {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    float f = 0.01f;
                    AppMethodBeat.m2504i(126431);
                    C16676k.this.hXK = (float) jSONObject.optDouble("value");
                    if (Float.isNaN(C16676k.this.hXK) || C16676k.this.hXK < 0.0f || C16676k.this.hXK > 1.0f) {
                        c2241c.mo6107M(i, C16676k.this.mo73394j("fail:value invalid", null));
                        C4990ab.m7412e("MicroMsg.JsApiSetScreenBrightness", "value invalid");
                        AppMethodBeat.m2505o(126431);
                        return;
                    }
                    Context context = c2241c.getContext();
                    if (context == null) {
                        c2241c.mo6107M(i, C16676k.this.mo73394j("fail", null));
                        C4990ab.m7412e("MicroMsg.JsApiSetScreenBrightness", "context is null, invoke fail!");
                        AppMethodBeat.m2505o(126431);
                    } else if (c2241c.getContext() instanceof Activity) {
                        final Activity activity = (Activity) context;
                        final LayoutParams attributes = activity.getWindow().getAttributes();
                        if (Float.isNaN(C16676k.this.hXJ)) {
                            C16676k.this.hXJ = attributes.screenBrightness;
                            C33183g.m54274a(c2241c.getAppId(), new C33186c() {
                                /* renamed from: a */
                                public final void mo6074a(C33184d c33184d) {
                                    AppMethodBeat.m2504i(126429);
                                    attributes.screenBrightness = C16676k.this.hXJ;
                                    activity.getWindow().setAttributes(attributes);
                                    AppMethodBeat.m2505o(126429);
                                }

                                public final void onResume() {
                                    AppMethodBeat.m2504i(126430);
                                    attributes.screenBrightness = C16676k.this.hXK;
                                    activity.getWindow().setAttributes(attributes);
                                    AppMethodBeat.m2505o(126430);
                                }
                            });
                        }
                        if (C16676k.this.hXK >= 0.01f) {
                            f = C16676k.this.hXK;
                        }
                        attributes.screenBrightness = f;
                        activity.getWindow().setAttributes(attributes);
                        c2241c.mo6107M(i, C16676k.this.mo73394j("ok", null));
                        AppMethodBeat.m2505o(126431);
                    } else {
                        C4990ab.m7412e("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
                        c2241c.mo6107M(i, C16676k.this.mo73394j("fail:context is not activity", null));
                        AppMethodBeat.m2505o(126431);
                    }
                }
            });
            AppMethodBeat.m2505o(126432);
        } else {
            C4990ab.m7412e("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
            c2241c.mo6107M(i, mo73394j("fail:context is not activity", null));
            AppMethodBeat.m2505o(126432);
        }
    }
}
