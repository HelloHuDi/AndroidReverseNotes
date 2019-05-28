package com.tencent.p177mm.plugin.appbrand.jsapi.p310k;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.p */
public class C16667p extends C10296a<C33327h> {
    private static final int CTRL_INDEX = 238;
    private static final String NAME = "setNavigationBarRightButton";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        C44709u c44709u;
        boolean z = false;
        AppMethodBeat.m2504i(102008);
        C33327h c33327h = (C33327h) c2241c;
        if (c33327h instanceof C44709u) {
            c44709u = (C44709u) c33327h;
        } else {
            c44709u = ((C38492q) c33327h).getCurrentPageView();
        }
        boolean optBoolean = jSONObject.optBoolean(MessengerShareContentUtility.SHARE_BUTTON_HIDE, false);
        if (c44709u == null) {
            c33327h.mo6107M(i, mo73394j("fail:page don't exist", null));
            AppMethodBeat.m2505o(102008);
            return;
        }
        if (!optBoolean) {
            z = true;
        }
        c44709u.mo44917ew(z);
        c33327h.mo6107M(i, mo73394j("ok", null));
        AppMethodBeat.m2505o(102008);
    }
}
