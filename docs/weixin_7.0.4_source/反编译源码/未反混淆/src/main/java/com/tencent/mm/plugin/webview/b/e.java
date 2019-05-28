package com.tencent.mm.plugin.webview.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;

public final class e extends j<d> {
    public static final String[] fnj = new String[]{j.a(d.ccO, "WebViewHistory")};

    static {
        AppMethodBeat.i(5648);
        AppMethodBeat.o(5648);
    }

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, d.ccO, "WebViewHistory", null);
    }

    static /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(5647);
        int count = eVar.getCount() - 500;
        if (count > 0) {
            ab.i("MicroMsg.WebViewHistoryStorage", "deleteItem: ".concat(String.valueOf(eVar.hY("WebViewHistory", "delete from WebViewHistory order by timeStamp limit ".concat(String.valueOf(count))))));
        }
        AppMethodBeat.o(5647);
    }
}
