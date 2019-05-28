package com.tencent.p177mm.plugin.appbrand.jsapi.p310k;

import com.tencent.luggage.sdk.p819a.p820a.C37402a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C2119d;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONObject;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/page/PrivateJsApiSetDisplayOrientation;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandSyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "Companion", "luggage-wechat-full-sdk_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.ac */
public final class C42523ac extends C19497u<C2119d> {
    public static final int CTRL_INDEX = 533;
    public static final String NAME = "setDisplayOrientation";
    @Deprecated
    public static final C33334a hTG = new C33334a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/page/PrivateJsApiSetDisplayOrientation$Companion;", "", "()V", "CTRL_INDEX", "", "LANDSCAPE", "LANDSCAPE_REVERSE", "NAME", "", "PORTRAIT", "TAG", "luggage-wechat-full-sdk_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.ac$a */
    static final class C33334a {
        private C33334a() {
        }

        public /* synthetic */ C33334a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(102470);
        AppMethodBeat.m2505o(102470);
    }

    /* renamed from: b */
    public final /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        Integer num = null;
        AppMethodBeat.m2504i(102469);
        C2119d c2119d = (C2119d) c2241c;
        C25052j.m39376p(c2119d, "env");
        C44709u currentPageView = c2119d instanceof C44709u ? (C44709u) c2119d : c2119d instanceof C38492q ? ((C38492q) c2119d).getCurrentPageView() : null;
        String AK;
        if (currentPageView == null) {
            AK = mo73392AK("fail:page don't exist");
            C25052j.m39375o(AK, "makeReturnJson(Constants…Msg.API_PAGE_DON_T_EXIST)");
            AppMethodBeat.m2505o(102469);
            return AK;
        }
        String str;
        if (jSONObject != null) {
            num = Integer.valueOf(jSONObject.optInt("orientation", 0));
        }
        if (num != null && num.intValue() == 90) {
            str = "landscape";
        } else if (num != null && num.intValue() == -90) {
            str = "landscapeLeft";
        } else {
            str = "portrait";
        }
        C4990ab.m7417i("MicroMsg.AppBrand.PrivateJsApiSetDisplayOrientation", "set display orientation:%s", str);
        if (C26835a.m42719yV(str) == null) {
            AK = mo73392AK("fail:invalid data");
            C25052j.m39375o(AK, "makeReturnJson(Constants…sApiMsg.API_INVALID_DATA)");
            AppMethodBeat.m2505o(102469);
            return AK;
        }
        if (currentPageView instanceof C37402a) {
            C37402a c37402a = (C37402a) currentPageView;
            HashMap hashMap = new HashMap();
            hashMap.put(getName(), str);
            c37402a.mo60248d(str, hashMap);
        } else {
            currentPageView.mo71744Dg(str);
        }
        AK = mo73392AK("ok");
        C25052j.m39375o(AK, "makeReturnJson(\"ok\")");
        AppMethodBeat.m2505o(102469);
        return AK;
    }
}
