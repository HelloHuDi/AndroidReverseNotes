package com.tencent.mm.plugin.appbrand.page;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import java.util.HashMap;

public class h extends p {
    private static final int CTRL_INDEX = 49;
    private static final String NAME = "onAppEnterBackground";

    public final void A(i iVar) {
        AppMethodBeat.i(87064);
        HashMap hashMap = new HashMap(1);
        d wV = g.wV(iVar.mAppId);
        Object obj = MessengerShareContentUtility.SHARE_BUTTON_HIDE;
        switch (wV) {
            case CLOSE:
                obj = "close";
                break;
            case BACK:
                obj = "back";
                break;
            case LAUNCH_NATIVE_PAGE:
            case HOME_PRESSED:
            case HIDE:
                obj = MessengerShareContentUtility.SHARE_BUTTON_HIDE;
                break;
            case HANG:
                obj = "hang";
                break;
            case LAUNCH_MINI_PROGRAM:
                obj = JsApiLaunchMiniProgram.NAME;
                break;
        }
        hashMap.put("mode", obj);
        t(hashMap).i(iVar.xT()).aCj();
        AppMethodBeat.o(87064);
    }
}
