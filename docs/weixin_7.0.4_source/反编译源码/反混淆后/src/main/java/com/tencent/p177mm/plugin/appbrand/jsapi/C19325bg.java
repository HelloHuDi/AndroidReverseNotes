package com.tencent.p177mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bg */
public final class C19325bg extends C10296a<C33327h> {
    public static final int CTRL_INDEX = 406;
    public static final String NAME = "private_openUrl";

    /* renamed from: a */
    private void m30001a(C33327h c33327h, int i, String str) {
        AppMethodBeat.m2504i(73170);
        C4990ab.m7413e("MicroMsg.JsApiPrivateOpenUrl", "switchCallback msg:%s", str);
        if (c33327h != null) {
            c33327h.mo6107M(i, mo73394j(str, null));
        }
        AppMethodBeat.m2505o(73170);
    }
}
