package com.tencent.p177mm.plugin.topstory.p541ui.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.topstory.ui.webview.a */
public final class C13993a {
    /* renamed from: a */
    public static void m22130a(C43702e c43702e, String str, String str2) {
        AppMethodBeat.m2504i(2143);
        try {
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(2143);
                return;
            }
            String nullAsNil = C5046bo.nullAsNil(str2);
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryJsEventNotifier", "lxl notifyJsEvent %s %s", str, nullAsNil);
            nullAsNil = String.format("javascript:window['%s'] && %s(%s)", new Object[]{str, str, nullAsNil});
            if (!(c43702e == null || c43702e.sHG == null)) {
                c43702e.sHG.evaluateJavascript(nullAsNil, null);
            }
            AppMethodBeat.m2505o(2143);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryJsEventNotifier", e, "notifyJsEvent", new Object[0]);
            AppMethodBeat.m2505o(2143);
        }
    }
}
