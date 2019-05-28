package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.luggage.ipc.JsApiMMTask;
import com.tencent.mm.plugin.webview.luggage.ipc.b;
import com.tencent.mm.plugin.webview.luggage.ipc.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public abstract class bc<T extends n> extends com.tencent.luggage.d.a<T> {

    public static abstract class a {
        public abstract void d(String str, JSONObject jSONObject);
    }

    public abstract void a(Context context, String str, a aVar);

    public abstract void b(com.tencent.luggage.d.a.a aVar);

    public abstract int biG();

    public void a(final com.tencent.luggage.d.a.a aVar) {
        if (biG() == 1) {
            MainProcessTask jsApiMMTask = new JsApiMMTask();
            jsApiMMTask.ujK = aVar;
            jsApiMMTask.ujL = getClass().getName();
            jsApiMMTask.hAP = aVar.bPa.bOf.toString();
            jsApiMMTask.aBV();
            AppBrandMainProcessService.a(jsApiMMTask);
        } else if (biG() == 2) {
            Bundle bundle = new Bundle();
            bundle.putString("jsapi_name", getClass().getName());
            bundle.putString("data", aVar.bPa.bOf.toString());
            b.a((MMActivity) ((n) aVar.bOZ).mContext, bundle, d.class, new com.tencent.mm.plugin.webview.luggage.ipc.a() {
                public final void l(Bundle bundle) {
                    AppMethodBeat.i(6389);
                    String string = bundle.getString("err_msg");
                    String string2 = bundle.getString("data");
                    if (bo.isNullOrNil(string)) {
                        try {
                            aVar.a("", new JSONObject(string2));
                            AppMethodBeat.o(6389);
                            return;
                        } catch (Exception e) {
                            aVar.a("", null);
                            AppMethodBeat.o(6389);
                            return;
                        }
                    }
                    aVar.a(string, null);
                    AppMethodBeat.o(6389);
                }
            });
        } else {
            b(aVar);
        }
    }
}
