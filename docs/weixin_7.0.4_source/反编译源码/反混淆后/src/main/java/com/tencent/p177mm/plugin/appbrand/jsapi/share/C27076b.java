package com.tencent.p177mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.menu.C38449o;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.share.b */
public final class C27076b extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 203;
    public static final String NAME = "hideShareMenu";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(102009);
        C38492q c38492q = (C38492q) c2241c;
        C4990ab.m7416i("MicroMsg.JsApiHideShareMenu", "invoke");
        C44709u currentPageView = c38492q.getCurrentPageView();
        if (currentPageView != null) {
            currentPageView.mo71747H(C38449o.ShareAppMsg.ordinal(), true);
        }
        c38492q.mo6107M(i, mo73394j("ok", null));
        AppMethodBeat.m2505o(102009);
    }
}
