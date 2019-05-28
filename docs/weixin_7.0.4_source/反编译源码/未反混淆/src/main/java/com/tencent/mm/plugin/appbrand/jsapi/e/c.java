package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import org.json.JSONObject;

public final class c extends a<q> {
    public static final int CTRL_INDEX = 103;
    public static final String NAME = "chooseLocation";
    int bOs = 0;

    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(131109);
        final q qVar = (q) cVar;
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 8);
        Activity ad = qVar.ad(Activity.class);
        if (ad == null || !(ad instanceof MMActivity)) {
            qVar.M(i, j("fail", null));
            ab.e("MicroMsg.JsApiChooseLocation", "mmActivity is null, invoke fail!");
            AppMethodBeat.o(131109);
            return;
        }
        Context context = (MMActivity) ad;
        this.bOs = i;
        context.ifE = new MMActivity.a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(131108);
                if (i == 1) {
                    if (i2 == -1) {
                        if (intent == null) {
                            qVar.M(c.this.bOs, c.this.j("fail", null));
                            ab.e("MicroMsg.JsApiChooseLocation", "location result is empty!");
                            AppMethodBeat.o(131108);
                            return;
                        }
                        Addr addr = (Addr) intent.getParcelableExtra("key_pick_addr");
                        HashMap hashMap = new HashMap();
                        if (addr != null) {
                            ab.i("MicroMsg.JsApiChooseLocation", "addr: " + addr.toString());
                            StringBuilder stringBuilder = new StringBuilder();
                            if (TextUtils.isEmpty(addr.fBg)) {
                                stringBuilder.append(addr.agv());
                            } else {
                                stringBuilder.append(addr.fBg);
                            }
                            hashMap.put("address", stringBuilder.toString());
                            if (TextUtils.isEmpty(addr.fBp)) {
                                hashMap.put("name", stringBuilder.toString());
                            } else {
                                hashMap.put("name", addr.fBp);
                            }
                            hashMap.put("latitude", Float.valueOf(addr.fBr));
                            hashMap.put("longitude", Float.valueOf(addr.fBs));
                            qVar.M(c.this.bOs, c.this.j("ok", hashMap));
                            AppMethodBeat.o(131108);
                            return;
                        }
                        qVar.M(c.this.bOs, c.this.j("fail", null));
                        ab.e("MicroMsg.JsApiChooseLocation", "location result is empty!");
                        AppMethodBeat.o(131108);
                        return;
                    } else if (i2 == 0) {
                        qVar.M(c.this.bOs, c.this.j("cancel", null));
                        ab.e("MicroMsg.JsApiChooseLocation", "location result is cancel!");
                        AppMethodBeat.o(131108);
                        return;
                    } else {
                        qVar.M(c.this.bOs, c.this.j("fail", null));
                        ab.e("MicroMsg.JsApiChooseLocation", "location result is fail!");
                    }
                }
                AppMethodBeat.o(131108);
            }
        };
        d.b(context, b.LOCATION, ".ui.RedirectUI", intent, 1);
        AppMethodBeat.o(131109);
    }
}
