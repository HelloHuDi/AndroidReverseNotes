package com.tencent.mm.plugin.topstory.ui.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {
    public static void a(e eVar, String str, String str2) {
        AppMethodBeat.i(2143);
        try {
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(2143);
                return;
            }
            String nullAsNil = bo.nullAsNil(str2);
            ab.i("MicroMsg.TopStory.TopStoryJsEventNotifier", "lxl notifyJsEvent %s %s", str, nullAsNil);
            nullAsNil = String.format("javascript:window['%s'] && %s(%s)", new Object[]{str, str, nullAsNil});
            if (!(eVar == null || eVar.sHG == null)) {
                eVar.sHG.evaluateJavascript(nullAsNil, null);
            }
            AppMethodBeat.o(2143);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryJsEventNotifier", e, "notifyJsEvent", new Object[0]);
            AppMethodBeat.o(2143);
        }
    }
}
