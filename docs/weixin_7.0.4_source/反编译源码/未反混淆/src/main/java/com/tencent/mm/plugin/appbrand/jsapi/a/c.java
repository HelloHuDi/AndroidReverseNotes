package com.tencent.mm.plugin.appbrand.jsapi.a;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberProxyUI;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import org.json.JSONObject;

@l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetPhoneNumberNew;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class c extends com.tencent.mm.plugin.appbrand.jsapi.a<u> {
    private static final int CTRL_INDEX = 209;
    private static final String NAME = NAME;
    public static final a hCz = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, dWq = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    static final class b implements com.tencent.mm.ui.MMActivity.a {
        final /* synthetic */ int hBE;
        final /* synthetic */ c hCA;
        final /* synthetic */ u hCB;

        b(c cVar, u uVar, int i) {
            this.hCA = cVar;
            this.hCB = uVar;
            this.hBE = i;
        }

        public final void c(int i, int i2, Intent intent) {
            AppMethodBeat.i(134661);
            d.i("MicroMsg.JsApiGetPhoneNumberNew", "requestCode:%d resultCode:%d data:%s", Integer.valueOf(i), Integer.valueOf(i2), intent);
            if (i == 291) {
                u uVar;
                int i3;
                c cVar;
                String str;
                HashMap hashMap = new HashMap();
                switch (i2) {
                    case -1:
                        if (intent == null) {
                            uVar = this.hCB;
                            i3 = this.hBE;
                            cVar = this.hCA;
                            str = "fail";
                            break;
                        }
                        String stringExtra = intent.getStringExtra("encryptedData");
                        j.o(stringExtra, "data.getStringExtra(Phon…berProxyUI.ENCRYPTEDDATA)");
                        hashMap.put("encryptedData", stringExtra);
                        stringExtra = intent.getStringExtra("iv");
                        j.o(stringExtra, "data.getStringExtra(PhoneNumberProxyUI.IV)");
                        hashMap.put("iv", stringExtra);
                        this.hCB.M(this.hBE, this.hCA.j("ok", hashMap));
                        AppMethodBeat.o(134661);
                        return;
                    case 0:
                        uVar = this.hCB;
                        i3 = this.hBE;
                        cVar = this.hCA;
                        str = "fail:cancel";
                        break;
                    case 1:
                        uVar = this.hCB;
                        i3 = this.hBE;
                        cVar = this.hCA;
                        if (intent == null) {
                            str = null;
                            break;
                        } else {
                            str = intent.getStringExtra("errMsg");
                            break;
                        }
                }
                uVar.M(i3, cVar.AK(str));
            }
            AppMethodBeat.o(134661);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\t8\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetPhoneNumberNew$Companion;", "", "()V", "CTRL_INDEX", "", "CTRL_INDEX$annotations", "getCTRL_INDEX", "()I", "NAME", "", "NAME$annotations", "getNAME", "()Ljava/lang/String;", "REQ_CODE_GET_PHONE_NUMBER", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(134662);
        u uVar = (u) cVar;
        j.p(uVar, "env");
        j.p(jSONObject, "data");
        if (uVar.getContext() == null || !(uVar.getContext() instanceof MMActivity)) {
            d.e("MicroMsg.JsApiGetPhoneNumberNew", "env is null, return");
            uVar.M(i, AK("fail"));
            AppMethodBeat.o(134662);
            return;
        }
        Object obj;
        Object obj2;
        Object obj3;
        d.i("MicroMsg.JsApiGetPhoneNumberNew", "getPhoneNumber data:%s", jSONObject.toString());
        String str = ((h) uVar.aa(h.class)).cwz;
        if (str == null) {
            obj = "";
        } else {
            String obj4 = str;
        }
        str = ((h) uVar.aa(h.class)).hgW;
        if (str == null) {
            obj2 = "";
        } else {
            String obj22 = str;
        }
        String optString = jSONObject.optString("api_name", "webapi_getuserwxphone");
        boolean optBoolean = jSONObject.optBoolean("with_credentials", true);
        str = uVar.aBm();
        if (str == null) {
            obj3 = "";
        } else {
            String obj32 = str;
        }
        com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberProxyUI.a aVar = PhoneNumberProxyUI.iyP;
        Context context = uVar.getContext();
        if (context == null) {
            v vVar = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(134662);
            throw vVar;
        }
        MMActivity mMActivity = (MMActivity) context;
        String appId = uVar.getAppId();
        j.o(appId, "env.appId");
        j.o(optString, "api_name");
        com.tencent.mm.ui.MMActivity.a bVar = new b(this, uVar, i);
        j.p(mMActivity, "context");
        j.p(appId, "appId");
        j.p(obj4, "appName");
        j.p(obj22, "appIcon");
        j.p(obj32, "pagePath");
        j.p(optString, "apiName");
        j.p(bVar, "onActResult");
        Intent intent = new Intent(mMActivity, PhoneNumberProxyUI.class);
        intent.putExtra("appId", appId);
        intent.putExtra("apiName", optString);
        intent.putExtra("pagePath", obj32);
        intent.putExtra("withCredentials", optBoolean);
        intent.putExtra("appName", obj4);
        intent.putExtra("appIcon", obj22);
        mMActivity.b(bVar, intent, 291);
        AppMethodBeat.o(134662);
    }

    static {
        AppMethodBeat.i(134663);
        AppMethodBeat.o(134663);
    }
}
