package com.tencent.p177mm.plugin.game.luggage;

import android.os.Build.VERSION;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.webview.p1172a.C17831c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.luggage.p432d.C3228d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.C46438d;

/* renamed from: com.tencent.mm.plugin.game.luggage.a */
public final class C12128a implements C17831c {
    private C3228d mTG;

    public C12128a(C3228d c3228d) {
        this.mTG = c3228d;
    }

    /* renamed from: yk */
    public final String mo23954yk() {
        return "weixin://game.js";
    }

    /* renamed from: bG */
    public final WebResourceResponse mo23953bG(String str) {
        AppMethodBeat.m2504i(135806);
        if (VERSION.SDK_INT < 21) {
            AppMethodBeat.m2505o(135806);
            return null;
        }
        boolean z = false;
        if (this.mTG.getWePkgPlugin() != null) {
            z = this.mTG.getWePkgPlugin().uVv;
        }
        WebResourceResponse nX = C46438d.m87588nX(z);
        AppMethodBeat.m2505o(135806);
        return nX;
    }
}
