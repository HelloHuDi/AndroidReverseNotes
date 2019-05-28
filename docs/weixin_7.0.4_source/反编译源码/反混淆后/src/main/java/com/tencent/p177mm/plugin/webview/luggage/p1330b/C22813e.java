package com.tencent.p177mm.plugin.webview.luggage.p1330b;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;

/* renamed from: com.tencent.mm.plugin.webview.luggage.b.e */
public final class C22813e extends C43884a {
    public C22813e() {
        super(27);
    }

    /* renamed from: a */
    public final void mo38418a(Context context, C24905d c24905d, C44273l c44273l) {
        AppMethodBeat.m2504i(6431);
        if (c24905d.isFullScreen()) {
            c44273l.mo70049a(27, context.getString(C25738R.string.dhq), (int) C1318a.bottomsheet_icon_exit);
        }
        AppMethodBeat.m2505o(6431);
    }

    /* renamed from: a */
    public final void mo38417a(Context context, C24905d c24905d) {
        AppMethodBeat.m2504i(6432);
        if (!(c24905d.cWG() || c24905d.bPe.mo43477xi().mo60238xb())) {
            ((Activity) c24905d.mContext).finish();
        }
        C7060h.pYm.mo15419k(982, 11, 1);
        AppMethodBeat.m2505o(6432);
    }
}
