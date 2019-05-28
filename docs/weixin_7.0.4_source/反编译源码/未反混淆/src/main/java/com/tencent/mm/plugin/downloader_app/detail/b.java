package com.tencent.mm.plugin.downloader_app.detail;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.d;
import com.tencent.xweb.WebView;

public class b extends d {
    public b(Context context) {
        super(context);
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.i(136041);
        super.b(webView, str, bitmap);
        AppMethodBeat.o(136041);
    }

    public final void b(WebView webView, String str) {
        AppMethodBeat.i(136042);
        super.b(webView, str);
        AppMethodBeat.o(136042);
    }
}
