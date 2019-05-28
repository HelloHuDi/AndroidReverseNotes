package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import org.json.JSONObject;

public class d<CONTEXT extends c> extends a<CONTEXT> {
    private static final int CTRL_INDEX = 340;
    private static final String NAME = "enableLocationUpdate";
    protected volatile l hKK;

    public final /* bridge */ /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(93823);
        super.a(cVar, jSONObject, i);
        AppMethodBeat.o(93823);
    }

    public void c(CONTEXT context, JSONObject jSONObject, int i) {
        AppMethodBeat.i(93822);
        com.tencent.luggage.g.d.i("MicroMsg.AppBrand.JsApiEnableLocationUpdate", "enableLocationUpdate:%s", jSONObject);
        synchronized (this) {
            try {
                if (this.hKK == null) {
                    this.hKK = new l(context);
                    this.hKK.start();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(93822);
            }
        }
        boolean optBoolean = jSONObject.optBoolean("enable");
        if (optBoolean || a.o(context)) {
            this.hKK.fPq = e(context, jSONObject);
            if (!optBoolean) {
                this.hKK.sendMessage(2);
            } else if (a.o(context)) {
                this.hKK.sendMessage(1);
            } else {
                context.M(i, j("fail:system permission denied", null));
                AppMethodBeat.o(93822);
                return;
            }
            context.M(i, j("ok", null));
            AppMethodBeat.o(93822);
            return;
        }
        context.M(i, j("ok", null));
    }

    /* Access modifiers changed, original: protected */
    public Bundle e(CONTEXT context, JSONObject jSONObject) {
        return null;
    }
}
