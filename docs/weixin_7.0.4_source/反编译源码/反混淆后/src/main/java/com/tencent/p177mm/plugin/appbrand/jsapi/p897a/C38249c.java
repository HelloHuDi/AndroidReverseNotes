package com.tencent.p177mm.plugin.appbrand.jsapi.p897a;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.plugin.appbrand.config.C16597h;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.phonenumber.PhoneNumberProxyUI;
import com.tencent.p177mm.plugin.appbrand.phonenumber.PhoneNumberProxyUI.C33503a;
import java.util.HashMap;
import org.json.JSONObject;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetPhoneNumberNew;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.a.c */
public final class C38249c extends C10296a<C44709u> {
    private static final int CTRL_INDEX = 209;
    private static final String NAME = NAME;
    public static final C38250a hCz = new C38250a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, dWq = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.a.c$b */
    static final class C38248b implements C5186a {
        final /* synthetic */ int hBE;
        final /* synthetic */ C38249c hCA;
        final /* synthetic */ C44709u hCB;

        C38248b(C38249c c38249c, C44709u c44709u, int i) {
            this.hCA = c38249c;
            this.hCB = c44709u;
            this.hBE = i;
        }

        /* renamed from: c */
        public final void mo6069c(int i, int i2, Intent intent) {
            AppMethodBeat.m2504i(134661);
            C45124d.m82930i("MicroMsg.JsApiGetPhoneNumberNew", "requestCode:%d resultCode:%d data:%s", Integer.valueOf(i), Integer.valueOf(i2), intent);
            if (i == 291) {
                C44709u c44709u;
                int i3;
                C38249c c38249c;
                String str;
                HashMap hashMap = new HashMap();
                switch (i2) {
                    case -1:
                        if (intent == null) {
                            c44709u = this.hCB;
                            i3 = this.hBE;
                            c38249c = this.hCA;
                            str = "fail";
                            break;
                        }
                        String stringExtra = intent.getStringExtra("encryptedData");
                        C25052j.m39375o(stringExtra, "data.getStringExtra(Phon…berProxyUI.ENCRYPTEDDATA)");
                        hashMap.put("encryptedData", stringExtra);
                        stringExtra = intent.getStringExtra("iv");
                        C25052j.m39375o(stringExtra, "data.getStringExtra(PhoneNumberProxyUI.IV)");
                        hashMap.put("iv", stringExtra);
                        this.hCB.mo6107M(this.hBE, this.hCA.mo73394j("ok", hashMap));
                        AppMethodBeat.m2505o(134661);
                        return;
                    case 0:
                        c44709u = this.hCB;
                        i3 = this.hBE;
                        c38249c = this.hCA;
                        str = "fail:cancel";
                        break;
                    case 1:
                        c44709u = this.hCB;
                        i3 = this.hBE;
                        c38249c = this.hCA;
                        if (intent == null) {
                            str = null;
                            break;
                        } else {
                            str = intent.getStringExtra("errMsg");
                            break;
                        }
                }
                c44709u.mo6107M(i3, c38249c.mo73392AK(str));
            }
            AppMethodBeat.m2505o(134661);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\t8\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetPhoneNumberNew$Companion;", "", "()V", "CTRL_INDEX", "", "CTRL_INDEX$annotations", "getCTRL_INDEX", "()I", "NAME", "", "NAME$annotations", "getNAME", "()Ljava/lang/String;", "REQ_CODE_GET_PHONE_NUMBER", "TAG", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.a.c$a */
    public static final class C38250a {
        private C38250a() {
        }

        public /* synthetic */ C38250a(byte b) {
            this();
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(134662);
        C44709u c44709u = (C44709u) c2241c;
        C25052j.m39376p(c44709u, "env");
        C25052j.m39376p(jSONObject, "data");
        if (c44709u.getContext() == null || !(c44709u.getContext() instanceof MMActivity)) {
            C45124d.m82927e("MicroMsg.JsApiGetPhoneNumberNew", "env is null, return");
            c44709u.mo6107M(i, mo73392AK("fail"));
            AppMethodBeat.m2505o(134662);
            return;
        }
        Object obj;
        Object obj2;
        Object obj3;
        C45124d.m82930i("MicroMsg.JsApiGetPhoneNumberNew", "getPhoneNumber data:%s", jSONObject.toString());
        String str = ((C16597h) c44709u.mo5937aa(C16597h.class)).cwz;
        if (str == null) {
            obj = "";
        } else {
            String obj4 = str;
        }
        str = ((C16597h) c44709u.mo5937aa(C16597h.class)).hgW;
        if (str == null) {
            obj2 = "";
        } else {
            String obj22 = str;
        }
        String optString = jSONObject.optString("api_name", "webapi_getuserwxphone");
        boolean optBoolean = jSONObject.optBoolean("with_credentials", true);
        str = c44709u.aBm();
        if (str == null) {
            obj3 = "";
        } else {
            String obj32 = str;
        }
        C33503a c33503a = PhoneNumberProxyUI.iyP;
        Context context = c44709u.getContext();
        if (context == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.m2505o(134662);
            throw c44941v;
        }
        MMActivity mMActivity = (MMActivity) context;
        String appId = c44709u.getAppId();
        C25052j.m39375o(appId, "env.appId");
        C25052j.m39375o(optString, "api_name");
        C5186a c38248b = new C38248b(this, c44709u, i);
        C25052j.m39376p(mMActivity, "context");
        C25052j.m39376p(appId, "appId");
        C25052j.m39376p(obj4, "appName");
        C25052j.m39376p(obj22, "appIcon");
        C25052j.m39376p(obj32, "pagePath");
        C25052j.m39376p(optString, "apiName");
        C25052j.m39376p(c38248b, "onActResult");
        Intent intent = new Intent(mMActivity, PhoneNumberProxyUI.class);
        intent.putExtra("appId", appId);
        intent.putExtra("apiName", optString);
        intent.putExtra("pagePath", obj32);
        intent.putExtra("withCredentials", optBoolean);
        intent.putExtra("appName", obj4);
        intent.putExtra("appIcon", obj22);
        mMActivity.mo17391b(c38248b, intent, 291);
        AppMethodBeat.m2505o(134662);
    }

    static {
        AppMethodBeat.m2504i(134663);
        AppMethodBeat.m2505o(134663);
    }
}
