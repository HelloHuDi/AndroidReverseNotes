package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.p146d.C17821n;
import com.tencent.luggage.p146d.C37393a;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.webview.luggage.ipc.C43889d;
import com.tencent.p177mm.plugin.webview.luggage.ipc.C4541a;
import com.tencent.p177mm.plugin.webview.luggage.ipc.C4542b;
import com.tencent.p177mm.plugin.webview.luggage.ipc.JsApiMMTask;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.bc */
public abstract class C22840bc<T extends C17821n> extends C37393a<T> {

    /* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.bc$a */
    public static abstract class C22841a {
        /* renamed from: d */
        public abstract void mo26722d(String str, JSONObject jSONObject);
    }

    /* renamed from: a */
    public abstract void mo9617a(Context context, String str, C22841a c22841a);

    /* renamed from: b */
    public abstract void mo9618b(C32183a c32183a);

    public abstract int biG();

    /* renamed from: a */
    public void mo38432a(final C32183a c32183a) {
        if (biG() == 1) {
            MainProcessTask jsApiMMTask = new JsApiMMTask();
            jsApiMMTask.ujK = c32183a;
            jsApiMMTask.ujL = getClass().getName();
            jsApiMMTask.hAP = c32183a.bPa.bOf.toString();
            jsApiMMTask.aBV();
            AppBrandMainProcessService.m54349a(jsApiMMTask);
        } else if (biG() == 2) {
            Bundle bundle = new Bundle();
            bundle.putString("jsapi_name", getClass().getName());
            bundle.putString("data", c32183a.bPa.bOf.toString());
            C4542b.m6919a((MMActivity) ((C17821n) c32183a.bOZ).mContext, bundle, C43889d.class, new C4541a() {
                /* renamed from: l */
                public final void mo9613l(Bundle bundle) {
                    AppMethodBeat.m2504i(6389);
                    String string = bundle.getString("err_msg");
                    String string2 = bundle.getString("data");
                    if (C5046bo.isNullOrNil(string)) {
                        try {
                            c32183a.mo52824a("", new JSONObject(string2));
                            AppMethodBeat.m2505o(6389);
                            return;
                        } catch (Exception e) {
                            c32183a.mo52824a("", null);
                            AppMethodBeat.m2505o(6389);
                            return;
                        }
                    }
                    c32183a.mo52824a(string, null);
                    AppMethodBeat.m2505o(6389);
                }
            });
        } else {
            mo9618b(c32183a);
        }
    }
}
