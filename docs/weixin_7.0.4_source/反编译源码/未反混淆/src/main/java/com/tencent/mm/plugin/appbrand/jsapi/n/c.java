package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONObject;

public final class c extends a<q> {
    private static final int CTRL_INDEX = 104;
    private static final String NAME = "showModal";

    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(74793);
        final q qVar = (q) cVar;
        final u currentPageView = qVar.getCurrentPageView();
        if (currentPageView == null) {
            ab.w("MicroMsg.JsApiShowModal", "invoke JsApi JsApiShowModal failed, current page view is null.");
            qVar.M(i, j("fail", null));
            AppMethodBeat.o(74793);
            return;
        }
        final String optString = jSONObject.optString("title");
        final String optString2 = jSONObject.optString("confirmText", qVar.getContext().getString(R.string.cuu));
        final String optString3 = jSONObject.optString("cancelText", qVar.getContext().getString(R.string.cut));
        final Boolean valueOf = Boolean.valueOf(jSONObject.optBoolean("showCancel", true));
        final int by = g.by(jSONObject.optString("confirmColor", ""), ah.getContext().getResources().getColor(R.color.hi));
        final int by2 = g.by(jSONObject.optString("cancelColor", ""), Color.parseColor("#000000"));
        final String optString4 = jSONObject.optString(b.CONTENT);
        final int i2 = i;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74792);
                if (qVar.isRunning()) {
                    currentPageView.aAX().a(com.tencent.mm.plugin.appbrand.page.ah.MODAL);
                    com.tencent.mm.plugin.appbrand.widget.b.b bVar = new com.tencent.mm.plugin.appbrand.widget.b.b(qVar.getContext());
                    if (!bo.isNullOrNil(optString)) {
                        bVar.setTitle((CharSequence) optString);
                    }
                    bVar.setMessage(optString4);
                    bVar.a(optString2, true, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(74789);
                            HashMap hashMap = new HashMap();
                            hashMap.put("confirm", Boolean.TRUE);
                            hashMap.put("cancel", Boolean.FALSE);
                            qVar.M(i2, c.this.j("ok", hashMap));
                            AppMethodBeat.o(74789);
                        }
                    });
                    if (valueOf.booleanValue()) {
                        bVar.b(optString3, false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(74790);
                                HashMap hashMap = new HashMap();
                                hashMap.put("confirm", Boolean.FALSE);
                                hashMap.put("cancel", Boolean.TRUE);
                                dialogInterface.dismiss();
                                qVar.M(i2, c.this.j("ok", hashMap));
                                AppMethodBeat.o(74790);
                            }
                        });
                    }
                    bVar.setOnCancelListener(new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(74791);
                            HashMap hashMap = new HashMap();
                            hashMap.put("confirm", Boolean.FALSE);
                            hashMap.put("cancel", Boolean.TRUE);
                            qVar.M(i2, c.this.j("ok", hashMap));
                            AppMethodBeat.o(74791);
                        }
                    });
                    bVar.PT(by);
                    if (valueOf.booleanValue()) {
                        bVar.PU(by2);
                    }
                    qVar.getRuntime().gNG.b(bVar);
                    AppMethodBeat.o(74792);
                    return;
                }
                AppMethodBeat.o(74792);
            }
        });
        AppMethodBeat.o(74793);
    }
}
