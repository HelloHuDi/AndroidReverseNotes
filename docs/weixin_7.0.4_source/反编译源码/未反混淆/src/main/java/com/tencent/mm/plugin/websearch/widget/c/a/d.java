package com.tencent.mm.plugin.websearch.widget.c.a;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.widget.c.c;
import com.tencent.mm.sdk.platformtools.ah;

public final class d implements a {
    public final boolean adV(String str) {
        AppMethodBeat.i(91470);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(91470);
            return false;
        } else if (str.startsWith("http://") || str.startsWith("https://")) {
            AppMethodBeat.o(91470);
            return true;
        } else {
            AppMethodBeat.o(91470);
            return false;
        }
    }

    public final boolean lO(long j) {
        AppMethodBeat.i(91471);
        boolean H = c.H(j, 0);
        AppMethodBeat.o(91471);
        return H;
    }

    public final boolean adW(String str) {
        AppMethodBeat.i(91472);
        if (adV(str)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("useJs", true);
            com.tencent.mm.bp.d.b(ah.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(91472);
            return true;
        }
        AppMethodBeat.o(91472);
        return false;
    }
}
