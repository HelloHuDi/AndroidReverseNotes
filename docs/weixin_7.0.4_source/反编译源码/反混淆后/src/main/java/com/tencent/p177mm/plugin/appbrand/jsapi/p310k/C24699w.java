package com.tencent.p177mm.plugin.appbrand.jsapi.p310k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C2119d;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import org.json.JSONObject;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiShowNavigationBar;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandSyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "Companion", "luggage-wxa-app-jsapi_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.w */
public final class C24699w extends C19497u<C2119d> {
    public static final int CTRL_INDEX = 577;
    public static final String NAME = "showNavigationBar";
    @Deprecated
    public static final C24700a hTF = new C24700a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiShowNavigationBar$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-wxa-app-jsapi_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.w$a */
    static final class C24700a {
        private C24700a() {
        }

        public /* synthetic */ C24700a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(74821);
        AppMethodBeat.m2505o(74821);
    }

    /* renamed from: b */
    public final /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        C44709u c44709u;
        AppMethodBeat.m2504i(74820);
        C2119d c2119d = (C2119d) c2241c;
        if (c2119d instanceof C44709u) {
            c44709u = (C44709u) c2119d;
        } else if (c2119d instanceof C38492q) {
            c44709u = ((C38492q) c2119d).getCurrentPageView();
        } else {
            c44709u = null;
        }
        String AK;
        if (c44709u == null) {
            AK = mo73392AK("fail:page don't exist");
            C25052j.m39375o(AK, "makeReturnJson(Constants…Msg.API_PAGE_DON_T_EXIST)");
            AppMethodBeat.m2505o(74820);
            return AK;
        }
        c44709u.aJE();
        AK = mo73392AK("ok");
        C25052j.m39375o(AK, "makeReturnJson(\"ok\")");
        AppMethodBeat.m2505o(74820);
        return AK;
    }
}
