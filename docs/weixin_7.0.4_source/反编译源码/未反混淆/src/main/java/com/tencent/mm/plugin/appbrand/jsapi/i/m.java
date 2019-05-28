package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class m extends a<q> {
    public static final int CTRL_INDEX = 507;
    public static final String NAME = "secureTunnel";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        String url;
        AppMethodBeat.i(131364);
        final q qVar = (q) cVar;
        ab.i("MicroMsg.JsApiSecureTunnel", "start secureTunnel");
        final AnonymousClass1 anonymousClass1 = new b.a() {
            public final void onSuccess(String str) {
                AppMethodBeat.i(131361);
                ab.i("MicroMsg.JsApiSecureTunnel", "secureTunnel callback success: %s", str);
                HashMap hashMap = new HashMap();
                hashMap.put("respbuf", str);
                qVar.M(i, m.this.j("ok", hashMap));
                AppMethodBeat.o(131361);
            }

            public final void BD(String str) {
                AppMethodBeat.i(131362);
                ab.i("MicroMsg.JsApiSecureTunnel", "secureTunnel callback fail");
                HashMap hashMap = new HashMap();
                hashMap.put("err_desc", str);
                qVar.M(i, m.this.j("fail", hashMap));
                AppMethodBeat.o(131362);
            }
        };
        u currentPageView = qVar.getCurrentPageView();
        if (currentPageView != null) {
            url = currentPageView.getURL();
        } else {
            url = null;
        }
        String appId = qVar.getAppId();
        int i2 = 1000;
        String str = "";
        int i3 = 0;
        Activity ad = qVar.ad(Activity.class);
        if (ad != null) {
            Intent intent = ad.getIntent();
            if (intent != null) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    Object obj = extras.get("key_appbrand_stat_object");
                    if (obj instanceof AppBrandStatObject) {
                        i2 = ((AppBrandStatObject) obj).scene;
                    }
                    obj = extras.get("key_appbrand_init_config");
                    if (obj instanceof AppBrandInitConfigWC) {
                        AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) obj;
                        str = appBrandInitConfigWC.username;
                        i3 = appBrandInitConfigWC.axy;
                    }
                }
            }
        }
        try {
            String string = jSONObject.getString("type");
            if (bo.isNullOrNil(string)) {
                ab.e("MicroMsg.JsApiSecureTunnel", "securetunnel type nil");
                qVar.M(i, j("fail", null));
                AppMethodBeat.o(131364);
                return;
            }
            String string2 = jSONObject.getString("reqbuf");
            if (bo.isNullOrNil(string2)) {
                ab.e("MicroMsg.JsApiSecureTunnel", "securetunnel reqbuf nil");
                qVar.M(i, j("fail", null));
                AppMethodBeat.o(131364);
                return;
            }
            String string3 = jSONObject.getString("cmd");
            if (bo.isNullOrNil(string3)) {
                ab.e("MicroMsg.JsApiSecureTunnel", "securetunnel cmd nil");
                qVar.M(i, j("fail", null));
                AppMethodBeat.o(131364);
            } else if (string.equals("wxpay")) {
                ab.i("MicroMsg.JsApiSecureTunnel", "secureTunnel doscene");
                com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
                aVar.fsJ = new bvz();
                aVar.fsK = new bwa();
                aVar.uri = "/cgi-bin/mmpay-bin/securetunnel";
                aVar.fsI = 2632;
                if (jSONObject.has("timeout")) {
                    aVar.azs = jSONObject.getInt("timeout");
                }
                com.tencent.mm.ai.b acD = aVar.acD();
                bvz bvz = (bvz) acD.fsG.fsP;
                bvz.wWO = string2;
                bvz.wap = string3;
                bvz.url = url;
                bvz.csB = appId;
                bvz.scene = i2;
                bvz.cvd = 1;
                bvz.vTT = str;
                bvz.vOP = i3;
                com.tencent.mm.ipcinvoker.wx_extension.b.a(acD, new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
                    public final void a(int i, int i2, String str, com.tencent.mm.ai.b bVar) {
                        AppMethodBeat.i(131363);
                        ab.i("MicroMsg.JsApiSecureTunnel", "onGYNetEnd errType :" + i + " errCode: " + i2 + " errMsg :" + str);
                        if (i == 0 && i2 == 0 && bVar.fsH.fsP != null) {
                            ab.i("MicroMsg.JsApiSecureTunnel", "secureTunnel cgi success");
                            anonymousClass1.onSuccess(((bwa) bVar.fsH.fsP).wWP);
                            AppMethodBeat.o(131363);
                            return;
                        }
                        ab.e("MicroMsg.JsApiSecureTunnel", "secureTunnel cgi failed");
                        anonymousClass1.BD(str);
                        AppMethodBeat.o(131363);
                    }
                });
                AppMethodBeat.o(131364);
            } else {
                ab.i("MicroMsg.JsApiSecureTunnel", "secureTunnel callback fail: invalid type");
                HashMap hashMap = new HashMap();
                hashMap.put("err_desc", "invalid type");
                qVar.M(i, j("fail", hashMap));
                AppMethodBeat.o(131364);
            }
        } catch (JSONException e) {
            ab.e("MicroMsg.JsApiSecureTunnel", "mini app securetunnel parameter error");
            qVar.M(i, j("fail", null));
            AppMethodBeat.o(131364);
        }
    }
}
