package com.tencent.p177mm.plugin.appbrand.jsapi.p308i;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b.C9557a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.pluginsdk.wallet.C30158b.C30159a;
import com.tencent.p177mm.protocal.protobuf.bvz;
import com.tencent.p177mm.protocal.protobuf.bwa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.i.m */
public final class C42520m extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 507;
    public static final String NAME = "secureTunnel";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        String url;
        AppMethodBeat.m2504i(131364);
        final C38492q c38492q = (C38492q) c2241c;
        C4990ab.m7416i("MicroMsg.JsApiSecureTunnel", "start secureTunnel");
        final C194011 c194011 = new C30159a() {
            public final void onSuccess(String str) {
                AppMethodBeat.m2504i(131361);
                C4990ab.m7417i("MicroMsg.JsApiSecureTunnel", "secureTunnel callback success: %s", str);
                HashMap hashMap = new HashMap();
                hashMap.put("respbuf", str);
                c38492q.mo6107M(i, C42520m.this.mo73394j("ok", hashMap));
                AppMethodBeat.m2505o(131361);
            }

            /* renamed from: BD */
            public final void mo34551BD(String str) {
                AppMethodBeat.m2504i(131362);
                C4990ab.m7416i("MicroMsg.JsApiSecureTunnel", "secureTunnel callback fail");
                HashMap hashMap = new HashMap();
                hashMap.put("err_desc", str);
                c38492q.mo6107M(i, C42520m.this.mo73394j("fail", hashMap));
                AppMethodBeat.m2505o(131362);
            }
        };
        C44709u currentPageView = c38492q.getCurrentPageView();
        if (currentPageView != null) {
            url = currentPageView.getURL();
        } else {
            url = null;
        }
        String appId = c38492q.getAppId();
        int i2 = 1000;
        String str = "";
        int i3 = 0;
        Activity ad = c38492q.mo61197ad(Activity.class);
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
            if (C5046bo.isNullOrNil(string)) {
                C4990ab.m7412e("MicroMsg.JsApiSecureTunnel", "securetunnel type nil");
                c38492q.mo6107M(i, mo73394j("fail", null));
                AppMethodBeat.m2505o(131364);
                return;
            }
            String string2 = jSONObject.getString("reqbuf");
            if (C5046bo.isNullOrNil(string2)) {
                C4990ab.m7412e("MicroMsg.JsApiSecureTunnel", "securetunnel reqbuf nil");
                c38492q.mo6107M(i, mo73394j("fail", null));
                AppMethodBeat.m2505o(131364);
                return;
            }
            String string3 = jSONObject.getString("cmd");
            if (C5046bo.isNullOrNil(string3)) {
                C4990ab.m7412e("MicroMsg.JsApiSecureTunnel", "securetunnel cmd nil");
                c38492q.mo6107M(i, mo73394j("fail", null));
                AppMethodBeat.m2505o(131364);
            } else if (string.equals("wxpay")) {
                C4990ab.m7416i("MicroMsg.JsApiSecureTunnel", "secureTunnel doscene");
                C1196a c1196a = new C1196a();
                c1196a.fsJ = new bvz();
                c1196a.fsK = new bwa();
                c1196a.uri = "/cgi-bin/mmpay-bin/securetunnel";
                c1196a.fsI = 2632;
                if (jSONObject.has("timeout")) {
                    c1196a.azs = jSONObject.getInt("timeout");
                }
                C7472b acD = c1196a.acD();
                bvz bvz = (bvz) acD.fsG.fsP;
                bvz.wWO = string2;
                bvz.wap = string3;
                bvz.url = url;
                bvz.csB = appId;
                bvz.scene = i2;
                bvz.cvd = 1;
                bvz.vTT = str;
                bvz.vOP = i3;
                C42146b.m74301a(acD, new C9557a() {
                    /* renamed from: a */
                    public final void mo5951a(int i, int i2, String str, C7472b c7472b) {
                        AppMethodBeat.m2504i(131363);
                        C4990ab.m7416i("MicroMsg.JsApiSecureTunnel", "onGYNetEnd errType :" + i + " errCode: " + i2 + " errMsg :" + str);
                        if (i == 0 && i2 == 0 && c7472b.fsH.fsP != null) {
                            C4990ab.m7416i("MicroMsg.JsApiSecureTunnel", "secureTunnel cgi success");
                            c194011.onSuccess(((bwa) c7472b.fsH.fsP).wWP);
                            AppMethodBeat.m2505o(131363);
                            return;
                        }
                        C4990ab.m7412e("MicroMsg.JsApiSecureTunnel", "secureTunnel cgi failed");
                        c194011.mo34551BD(str);
                        AppMethodBeat.m2505o(131363);
                    }
                });
                AppMethodBeat.m2505o(131364);
            } else {
                C4990ab.m7416i("MicroMsg.JsApiSecureTunnel", "secureTunnel callback fail: invalid type");
                HashMap hashMap = new HashMap();
                hashMap.put("err_desc", "invalid type");
                c38492q.mo6107M(i, mo73394j("fail", hashMap));
                AppMethodBeat.m2505o(131364);
            }
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.JsApiSecureTunnel", "mini app securetunnel parameter error");
            c38492q.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131364);
        }
    }
}
