package com.tencent.p177mm.plugin.game.luggage.p430c.p431a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.protocal.protobuf.bbb;

/* renamed from: com.tencent.mm.plugin.game.luggage.c.a.i */
public final class C46004i extends C34289a {
    public C46004i() {
        super(7);
    }

    /* renamed from: a */
    public final void mo7540a(Context context, C24905d c24905d, bbb bbb) {
        AppMethodBeat.m2504i(135909);
        if (c24905d.getWebView() != null) {
            c24905d.getWebView().reload();
        }
        AppMethodBeat.m2505o(135909);
    }
}
