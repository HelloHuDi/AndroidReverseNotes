package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class s extends p {
    private static final int CTRL_INDEX = 248;
    private static final String NAME = "onUserCaptureScreen";
    private static s hwm = new s();

    static {
        AppMethodBeat.i(86965);
        AppMethodBeat.o(86965);
    }

    public static void k(c cVar) {
        AppMethodBeat.i(86964);
        ab.i("MicroMsg.AppBrandOnUserCaptureScreenEvent", "user capture screen event dispatch, appId:%s", cVar.getAppId());
        hwm.i(cVar).aCj();
        AppMethodBeat.o(86964);
    }
}
