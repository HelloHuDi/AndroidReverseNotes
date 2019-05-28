package com.tencent.p177mm.plugin.appbrand.jsapi.p304e;

import android.os.Bundle;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.e.d */
public class C45593d<CONTEXT extends C2241c> extends C16664a<CONTEXT> {
    private static final int CTRL_INDEX = 340;
    private static final String NAME = "enableLocationUpdate";
    protected volatile C33299l hKK;

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(93823);
        super.mo5994a(c2241c, jSONObject, i);
        AppMethodBeat.m2505o(93823);
    }

    /* renamed from: c */
    public void mo6150c(CONTEXT context, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(93822);
        C45124d.m82930i("MicroMsg.AppBrand.JsApiEnableLocationUpdate", "enableLocationUpdate:%s", jSONObject);
        synchronized (this) {
            try {
                if (this.hKK == null) {
                    this.hKK = new C33299l(context);
                    this.hKK.start();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(93822);
            }
        }
        boolean optBoolean = jSONObject.optBoolean("enable");
        if (optBoolean || C16664a.m25670o(context)) {
            this.hKK.fPq = mo67987e(context, jSONObject);
            if (!optBoolean) {
                this.hKK.sendMessage(2);
            } else if (C16664a.m25670o(context)) {
                this.hKK.sendMessage(1);
            } else {
                context.mo6107M(i, mo73394j("fail:system permission denied", null));
                AppMethodBeat.m2505o(93822);
                return;
            }
            context.mo6107M(i, mo73394j("ok", null));
            AppMethodBeat.m2505o(93822);
            return;
        }
        context.mo6107M(i, mo73394j("ok", null));
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: e */
    public Bundle mo67987e(CONTEXT context, JSONObject jSONObject) {
        return null;
    }
}
