package com.tencent.p177mm.plugin.appbrand.jsapi.p304e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelgeo.Addr;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.e.c */
public final class C38288c extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 103;
    public static final String NAME = "chooseLocation";
    int bOs = 0;

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(131109);
        final C38492q c38492q = (C38492q) c2241c;
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 8);
        Activity ad = c38492q.mo61197ad(Activity.class);
        if (ad == null || !(ad instanceof MMActivity)) {
            c38492q.mo6107M(i, mo73394j("fail", null));
            C4990ab.m7412e("MicroMsg.JsApiChooseLocation", "mmActivity is null, invoke fail!");
            AppMethodBeat.m2505o(131109);
            return;
        }
        Context context = (MMActivity) ad;
        this.bOs = i;
        context.ifE = new C5186a() {
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(131108);
                if (i == 1) {
                    if (i2 == -1) {
                        if (intent == null) {
                            c38492q.mo6107M(C38288c.this.bOs, C38288c.this.mo73394j("fail", null));
                            C4990ab.m7412e("MicroMsg.JsApiChooseLocation", "location result is empty!");
                            AppMethodBeat.m2505o(131108);
                            return;
                        }
                        Addr addr = (Addr) intent.getParcelableExtra("key_pick_addr");
                        HashMap hashMap = new HashMap();
                        if (addr != null) {
                            C4990ab.m7416i("MicroMsg.JsApiChooseLocation", "addr: " + addr.toString());
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
                            c38492q.mo6107M(C38288c.this.bOs, C38288c.this.mo73394j("ok", hashMap));
                            AppMethodBeat.m2505o(131108);
                            return;
                        }
                        c38492q.mo6107M(C38288c.this.bOs, C38288c.this.mo73394j("fail", null));
                        C4990ab.m7412e("MicroMsg.JsApiChooseLocation", "location result is empty!");
                        AppMethodBeat.m2505o(131108);
                        return;
                    } else if (i2 == 0) {
                        c38492q.mo6107M(C38288c.this.bOs, C38288c.this.mo73394j("cancel", null));
                        C4990ab.m7412e("MicroMsg.JsApiChooseLocation", "location result is cancel!");
                        AppMethodBeat.m2505o(131108);
                        return;
                    } else {
                        c38492q.mo6107M(C38288c.this.bOs, C38288c.this.mo73394j("fail", null));
                        C4990ab.m7412e("MicroMsg.JsApiChooseLocation", "location result is fail!");
                    }
                }
                AppMethodBeat.m2505o(131108);
            }
        };
        C25985d.m41468b(context, C8741b.LOCATION, ".ui.RedirectUI", intent, 1);
        AppMethodBeat.m2505o(131109);
    }
}
