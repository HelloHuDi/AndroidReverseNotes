package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.protocal.protobuf.bzx;

public final class b implements w {
    public final void a(Context context, String str, bzx bzx) {
        AppMethodBeat.i(132095);
        Intent putExtra = new Intent().putExtra("rawUrl", str).putExtra(AppBrandProcessProxyUI.huY, str);
        putExtra.putExtra("rawUrl", str);
        if (bzx != null) {
            putExtra.putExtra("show_native_web_view", bzx.wYS);
            putExtra.putExtra("KRightBtn", bzx.wYT);
        }
        d.b(context, "webview", ".ui.tools.WebViewUI", putExtra);
        AppMethodBeat.o(132095);
    }
}
