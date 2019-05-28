package com.tencent.xweb.xwalk;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.CustomViewCallback;
import org.xwalk.core.XWalkJavascriptResult;
import org.xwalk.core.XWalkUIClient;
import org.xwalk.core.XWalkView;

public class l extends XWalkUIClient {
    public l(XWalkView xWalkView) {
        super(xWalkView);
    }

    public final void a(XWalkView xWalkView, String str) {
        AppMethodBeat.i(85369);
        super.onPageLoadStarted(xWalkView, str);
        AppMethodBeat.o(85369);
    }

    public final void dVA() {
        AppMethodBeat.i(85370);
        super.onHideCustomView();
        AppMethodBeat.o(85370);
    }

    public final void a(View view, CustomViewCallback customViewCallback) {
        AppMethodBeat.i(85371);
        super.onShowCustomView(view, customViewCallback);
        AppMethodBeat.o(85371);
    }

    public final boolean a(XWalkView xWalkView, String str, String str2, String str3, XWalkJavascriptResult xWalkJavascriptResult) {
        AppMethodBeat.i(85372);
        boolean onJsPrompt = super.onJsPrompt(xWalkView, str, str2, str3, xWalkJavascriptResult);
        AppMethodBeat.o(85372);
        return onJsPrompt;
    }

    public final boolean a(XWalkView xWalkView, String str, String str2, XWalkJavascriptResult xWalkJavascriptResult) {
        AppMethodBeat.i(85373);
        boolean onJsConfirm = super.onJsConfirm(xWalkView, str, str2, xWalkJavascriptResult);
        AppMethodBeat.o(85373);
        return onJsConfirm;
    }

    public final boolean b(XWalkView xWalkView, String str, String str2, XWalkJavascriptResult xWalkJavascriptResult) {
        AppMethodBeat.i(85374);
        boolean onJsAlert = super.onJsAlert(xWalkView, str, str2, xWalkJavascriptResult);
        AppMethodBeat.o(85374);
        return onJsAlert;
    }
}
