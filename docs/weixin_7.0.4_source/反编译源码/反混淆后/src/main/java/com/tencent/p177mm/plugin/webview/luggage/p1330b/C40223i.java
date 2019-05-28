package com.tencent.p177mm.plugin.webview.luggage.p1330b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;

/* renamed from: com.tencent.mm.plugin.webview.luggage.b.i */
public final class C40223i extends C43884a {
    public C40223i() {
        super(31);
    }

    /* renamed from: a */
    public final void mo38418a(Context context, C24905d c24905d, C44273l c44273l) {
        AppMethodBeat.m2504i(6440);
        c44273l.mo70049a(31, context.getString(C25738R.string.g2s), (int) C1318a.bottomsheet_icon_search);
        AppMethodBeat.m2505o(6440);
    }

    /* renamed from: a */
    public final void mo38417a(Context context, C24905d c24905d) {
        AppMethodBeat.m2504i(6441);
        if (!c24905d.uhW.isShown()) {
            c24905d.uhW.reset();
            c24905d.uhW.dcX();
            c24905d.uhW.show();
        }
        C7060h.pYm.mo15419k(982, 8, 1);
        AppMethodBeat.m2505o(6441);
    }
}
