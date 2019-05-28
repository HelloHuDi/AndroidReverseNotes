package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.app.Activity;
import android.content.Context;
import com.tencent.luggage.g.e;
import com.tencent.luggage.g.e.d;
import com.tencent.luggage.g.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

abstract class a<CONTEXT extends c> extends com.tencent.mm.plugin.appbrand.jsapi.a<CONTEXT> {
    public abstract void c(CONTEXT context, JSONObject jSONObject, int i);

    a() {
    }

    public void a(final CONTEXT context, final JSONObject jSONObject, final int i) {
        boolean z;
        Context context2 = context.getContext() instanceof Activity ? (Activity) context.getContext() : null;
        if (context2 == null) {
            ab.e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "operateRecorder, pageContext is null");
            context.M(i, j("fail:internal error invalid android context", null));
            z = false;
        } else {
            z = e.ax(context2).a("android.permission.ACCESS_FINE_LOCATION", new d() {
                public final void l(int[] iArr) {
                    AppMethodBeat.i(93820);
                    if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                        ab.e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "SYS_PERM_DENIED");
                        context.M(i, a.this.j("fail:system permission denied", null));
                        AppMethodBeat.o(93820);
                        return;
                    }
                    ab.i("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "PERMISSION_GRANTED, do invoke again");
                    a.this.a(context, jSONObject, i);
                    AppMethodBeat.o(93820);
                }
            });
        }
        if (!z) {
            ab.e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "%s requestPermission fail", getName());
        } else if (jSONObject == null) {
            ab.e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "%s invalid data", getName());
            context.M(i, j("fail:invalid data", null));
        } else {
            c(context, jSONObject, i);
        }
    }

    static boolean o(CONTEXT context) {
        return g.o(context.getContext(), "android.permission.ACCESS_FINE_LOCATION");
    }
}
