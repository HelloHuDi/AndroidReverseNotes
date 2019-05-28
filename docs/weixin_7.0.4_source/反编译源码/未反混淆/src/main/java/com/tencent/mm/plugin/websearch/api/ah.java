package com.tencent.mm.plugin.websearch.api;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ah implements c {
    public c uaz;

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _sendMessage(String str) {
        AppMethodBeat.i(124170);
        if (this.uaz != null) {
            this.uaz._sendMessage(str);
        }
        AppMethodBeat.o(124170);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _getAllHosts(String str) {
        AppMethodBeat.i(124171);
        if (this.uaz != null) {
            this.uaz._getAllHosts(str);
        }
        AppMethodBeat.o(124171);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _getHtmlContent(String str) {
        AppMethodBeat.i(124172);
        if (this.uaz != null) {
            this.uaz._getHtmlContent(str);
        }
        AppMethodBeat.o(124172);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _ready(boolean z) {
        AppMethodBeat.i(124173);
        if (this.uaz != null) {
            this.uaz._ready(z);
        }
        AppMethodBeat.o(124173);
    }
}
