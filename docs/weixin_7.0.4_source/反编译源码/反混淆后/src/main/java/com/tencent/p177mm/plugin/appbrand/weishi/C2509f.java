package com.tencent.p177mm.plugin.appbrand.weishi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.weishi.f */
public final class C2509f extends C10296a<C2241c> {
    public static final int CTRL_INDEX = 621;
    public static final String NAME = "showShareActionSheet";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        C27242w aun;
        AppMethodBeat.m2504i(133645);
        if (c2241c instanceof C19722s) {
            aun = ((C19722s) c2241c).aun();
        } else if (c2241c instanceof C27242w) {
            aun = (C27242w) c2241c;
        } else {
            aun = null;
        }
        if (aun == null) {
            C4990ab.m7412e("MicroMsg.JsApiShowShareActionSheet", "fail, page view is null");
            c2241c.mo6107M(i, mo73394j("fail:page don't exist", null));
            AppMethodBeat.m2505o(133645);
            return;
        }
        C4990ab.m7416i("MicroMsg.JsApiShowShareActionSheet", "weishi show share action sheet");
        aun.aJT();
        c2241c.mo6107M(i, mo73394j("ok", null));
        AppMethodBeat.m2505o(133645);
    }
}
