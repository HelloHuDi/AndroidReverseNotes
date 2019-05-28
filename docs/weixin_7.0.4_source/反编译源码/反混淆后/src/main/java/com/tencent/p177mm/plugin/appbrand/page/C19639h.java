package com.tencent.p177mm.plugin.appbrand.page;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;
import com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.page.h */
public class C19639h extends C38369p {
    private static final int CTRL_INDEX = 49;
    private static final String NAME = "onAppEnterBackground";

    /* renamed from: A */
    public final void mo34864A(C6750i c6750i) {
        AppMethodBeat.m2504i(87064);
        HashMap hashMap = new HashMap(1);
        C33184d wV = C33183g.m54286wV(c6750i.mAppId);
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
        mo34958t(hashMap).mo61031i(c6750i.mo15032xT()).aCj();
        AppMethodBeat.m2505o(87064);
    }
}
