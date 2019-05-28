package com.tencent.p177mm.plugin.websearch.api;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.websearch.api.ah */
public final class C35571ah implements C46401c {
    public C46401c uaz;

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _sendMessage(String str) {
        AppMethodBeat.m2504i(124170);
        if (this.uaz != null) {
            this.uaz._sendMessage(str);
        }
        AppMethodBeat.m2505o(124170);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _getAllHosts(String str) {
        AppMethodBeat.m2504i(124171);
        if (this.uaz != null) {
            this.uaz._getAllHosts(str);
        }
        AppMethodBeat.m2505o(124171);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _getHtmlContent(String str) {
        AppMethodBeat.m2504i(124172);
        if (this.uaz != null) {
            this.uaz._getHtmlContent(str);
        }
        AppMethodBeat.m2505o(124172);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _ready(boolean z) {
        AppMethodBeat.m2504i(124173);
        if (this.uaz != null) {
            this.uaz._ready(z);
        }
        AppMethodBeat.m2505o(124173);
    }
}
