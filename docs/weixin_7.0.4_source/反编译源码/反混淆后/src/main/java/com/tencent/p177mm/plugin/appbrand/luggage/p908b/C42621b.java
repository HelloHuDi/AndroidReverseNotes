package com.tencent.p177mm.plugin.appbrand.luggage.p908b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38402w;
import com.tencent.p177mm.protocal.protobuf.bzx;

/* renamed from: com.tencent.mm.plugin.appbrand.luggage.b.b */
public final class C42621b implements C38402w {
    /* renamed from: a */
    public final void mo20078a(Context context, String str, bzx bzx) {
        AppMethodBeat.m2504i(132095);
        Intent putExtra = new Intent().putExtra("rawUrl", str).putExtra(AppBrandProcessProxyUI.huY, str);
        putExtra.putExtra("rawUrl", str);
        if (bzx != null) {
            putExtra.putExtra("show_native_web_view", bzx.wYS);
            putExtra.putExtra("KRightBtn", bzx.wYT);
        }
        C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", putExtra);
        AppMethodBeat.m2505o(132095);
    }
}
