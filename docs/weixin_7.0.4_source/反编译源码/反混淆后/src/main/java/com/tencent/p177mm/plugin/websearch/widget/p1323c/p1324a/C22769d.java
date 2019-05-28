package com.tencent.p177mm.plugin.websearch.widget.p1323c.p1324a;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.websearch.widget.p1323c.C46407c;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.websearch.widget.c.a.d */
public final class C22769d implements C43854a {
    public final boolean adV(String str) {
        AppMethodBeat.m2504i(91470);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(91470);
            return false;
        } else if (str.startsWith("http://") || str.startsWith("https://")) {
            AppMethodBeat.m2505o(91470);
            return true;
        } else {
            AppMethodBeat.m2505o(91470);
            return false;
        }
    }

    /* renamed from: lO */
    public final boolean mo38361lO(long j) {
        AppMethodBeat.m2504i(91471);
        boolean H = C46407c.m87352H(j, 0);
        AppMethodBeat.m2505o(91471);
        return H;
    }

    public final boolean adW(String str) {
        AppMethodBeat.m2504i(91472);
        if (adV(str)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("useJs", true);
            C25985d.m41467b(C4996ah.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(91472);
            return true;
        }
        AppMethodBeat.m2505o(91472);
        return false;
    }
}
