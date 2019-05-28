package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class bg extends a<h> {
    public static final int CTRL_INDEX = 406;
    public static final String NAME = "private_openUrl";

    private void a(h hVar, int i, String str) {
        AppMethodBeat.i(73170);
        ab.e("MicroMsg.JsApiPrivateOpenUrl", "switchCallback msg:%s", str);
        if (hVar != null) {
            hVar.M(i, j(str, null));
        }
        AppMethodBeat.o(73170);
    }
}
