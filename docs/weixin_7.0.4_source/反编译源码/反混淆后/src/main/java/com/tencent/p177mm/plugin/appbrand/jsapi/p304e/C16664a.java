package com.tencent.p177mm.plugin.appbrand.jsapi.p304e;

import android.app.Activity;
import android.content.Context;
import com.tencent.luggage.p147g.C0991g;
import com.tencent.luggage.p147g.C8870e;
import com.tencent.luggage.p147g.C8870e.C8871d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.e.a */
abstract class C16664a<CONTEXT extends C2241c> extends C10296a<CONTEXT> {
    /* renamed from: c */
    public abstract void mo6150c(CONTEXT context, JSONObject jSONObject, int i);

    C16664a() {
    }

    /* renamed from: a */
    public void mo5994a(final CONTEXT context, final JSONObject jSONObject, final int i) {
        boolean z;
        Context context2 = context.getContext() instanceof Activity ? (Activity) context.getContext() : null;
        if (context2 == null) {
            C4990ab.m7412e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "operateRecorder, pageContext is null");
            context.mo6107M(i, mo73394j("fail:internal error invalid android context", null));
            z = false;
        } else {
            z = C8870e.m15839ax(context2).mo20069a("android.permission.ACCESS_FINE_LOCATION", new C8871d() {
                /* renamed from: l */
                public final void mo20071l(int[] iArr) {
                    AppMethodBeat.m2504i(93820);
                    if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                        C4990ab.m7412e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "SYS_PERM_DENIED");
                        context.mo6107M(i, C16664a.this.mo73394j("fail:system permission denied", null));
                        AppMethodBeat.m2505o(93820);
                        return;
                    }
                    C4990ab.m7416i("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "PERMISSION_GRANTED, do invoke again");
                    C16664a.this.mo5994a(context, jSONObject, i);
                    AppMethodBeat.m2505o(93820);
                }
            });
        }
        if (!z) {
            C4990ab.m7413e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "%s requestPermission fail", getName());
        } else if (jSONObject == null) {
            C4990ab.m7413e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "%s invalid data", getName());
            context.mo6107M(i, mo73394j("fail:invalid data", null));
        } else {
            mo6150c(context, jSONObject, i);
        }
    }

    /* renamed from: o */
    static boolean m25670o(CONTEXT context) {
        return C0991g.m2253o(context.getContext(), "android.permission.ACCESS_FINE_LOCATION");
    }
}
