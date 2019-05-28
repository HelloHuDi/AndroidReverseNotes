package com.tencent.mm.plugin.appbrand.h;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.c;

public final class y {
    public static boolean oV(int i) {
        boolean z;
        AppMethodBeat.i(73186);
        int aGZ = aGZ();
        if (aGY() != 2 || i < aGZ) {
            z = false;
        } else {
            z = true;
        }
        ab.i("MicroMsg.AppBrand.JsRuntimeABTests", "supportLibVer:%d currentLibVer:%d userNodeJS:%b", Integer.valueOf(aGZ), Integer.valueOf(i), Boolean.valueOf(z));
        AppMethodBeat.o(73186);
        return z;
    }

    private static int aGY() {
        AppMethodBeat.i(73187);
        a aVar = b.eGM;
        c ll = a.ll("100377");
        if (ll == null) {
            ab.i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal item is null");
            AppMethodBeat.o(73187);
            return 0;
        } else if (ll.isValid()) {
            ab.i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal:%d", Integer.valueOf(bo.getInt((String) ll.dru().get("JsRuntime"), 0)));
            AppMethodBeat.o(73187);
            return bo.getInt((String) ll.dru().get("JsRuntime"), 0);
        } else {
            ab.i("MicroMsg.AppBrand.JsRuntimeABTests", "getJsRuntimeControlVal item not valid");
            AppMethodBeat.o(73187);
            return 0;
        }
    }

    private static int aGZ() {
        AppMethodBeat.i(73188);
        a aVar = b.eGM;
        c ll = a.ll("100377");
        int i = (ll == null || !ll.isValid()) ? BaseClientBuilder.API_PRIORITY_OTHER : bo.getInt((String) ll.dru().get("isolateContextLibVersion"), BaseClientBuilder.API_PRIORITY_OTHER);
        AppMethodBeat.o(73188);
        return i;
    }
}
