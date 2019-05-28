package com.tencent.xweb.xwalk;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.CustomViewCallback;
import org.xwalk.core.XWalkJavascriptResult;
import org.xwalk.core.XWalkUIClient;
import org.xwalk.core.XWalkView;

/* renamed from: com.tencent.xweb.xwalk.l */
public class C31537l extends XWalkUIClient {
    public C31537l(XWalkView xWalkView) {
        super(xWalkView);
    }

    /* renamed from: a */
    public final void mo51488a(XWalkView xWalkView, String str) {
        AppMethodBeat.m2504i(85369);
        super.onPageLoadStarted(xWalkView, str);
        AppMethodBeat.m2505o(85369);
    }

    public final void dVA() {
        AppMethodBeat.m2504i(85370);
        super.onHideCustomView();
        AppMethodBeat.m2505o(85370);
    }

    /* renamed from: a */
    public final void mo51487a(View view, CustomViewCallback customViewCallback) {
        AppMethodBeat.m2504i(85371);
        super.onShowCustomView(view, customViewCallback);
        AppMethodBeat.m2505o(85371);
    }

    /* renamed from: a */
    public final boolean mo51489a(XWalkView xWalkView, String str, String str2, String str3, XWalkJavascriptResult xWalkJavascriptResult) {
        AppMethodBeat.m2504i(85372);
        boolean onJsPrompt = super.onJsPrompt(xWalkView, str, str2, str3, xWalkJavascriptResult);
        AppMethodBeat.m2505o(85372);
        return onJsPrompt;
    }

    /* renamed from: a */
    public final boolean mo51490a(XWalkView xWalkView, String str, String str2, XWalkJavascriptResult xWalkJavascriptResult) {
        AppMethodBeat.m2504i(85373);
        boolean onJsConfirm = super.onJsConfirm(xWalkView, str, str2, xWalkJavascriptResult);
        AppMethodBeat.m2505o(85373);
        return onJsConfirm;
    }

    /* renamed from: b */
    public final boolean mo51491b(XWalkView xWalkView, String str, String str2, XWalkJavascriptResult xWalkJavascriptResult) {
        AppMethodBeat.m2504i(85374);
        boolean onJsAlert = super.onJsAlert(xWalkView, str, str2, xWalkJavascriptResult);
        AppMethodBeat.m2505o(85374);
        return onJsAlert;
    }
}
