package com.tencent.mm.plugin.appbrand.page.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.sdk.platformtools.ab;

public final class d extends p {
    private static final int CTRL_INDEX = 633;
    private static final String NAME = "onCustomRightButtonClick";
    private static d ivx = new d();

    static {
        AppMethodBeat.i(87378);
        AppMethodBeat.o(87378);
    }

    public static void c(u uVar) {
        AppMethodBeat.i(87377);
        ab.i("onCustomRightButtonClickEvent", "onCustomRightButtonClickEvent dispatch");
        ivx.i(uVar.xT()).aCj();
        AppMethodBeat.o(87377);
    }
}
