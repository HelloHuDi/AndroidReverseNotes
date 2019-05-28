package com.tencent.mm.plugin.appbrand.jsapi.k;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.q;
import org.json.JSONObject;

@l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiShowNavigationBar;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandSyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "Companion", "luggage-wxa-app-jsapi_release"})
public final class w extends u<d> {
    public static final int CTRL_INDEX = 577;
    public static final String NAME = "showNavigationBar";
    @Deprecated
    public static final a hTF = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiShowNavigationBar$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-wxa-app-jsapi_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(74821);
        AppMethodBeat.o(74821);
    }

    public final /* synthetic */ String b(c cVar, JSONObject jSONObject) {
        com.tencent.mm.plugin.appbrand.page.u uVar;
        AppMethodBeat.i(74820);
        d dVar = (d) cVar;
        if (dVar instanceof com.tencent.mm.plugin.appbrand.page.u) {
            uVar = (com.tencent.mm.plugin.appbrand.page.u) dVar;
        } else if (dVar instanceof q) {
            uVar = ((q) dVar).getCurrentPageView();
        } else {
            uVar = null;
        }
        String AK;
        if (uVar == null) {
            AK = AK("fail:page don't exist");
            j.o(AK, "makeReturnJson(Constants…Msg.API_PAGE_DON_T_EXIST)");
            AppMethodBeat.o(74820);
            return AK;
        }
        uVar.aJE();
        AK = AK("ok");
        j.o(AK, "makeReturnJson(\"ok\")");
        AppMethodBeat.o(74820);
        return AK;
    }
}
