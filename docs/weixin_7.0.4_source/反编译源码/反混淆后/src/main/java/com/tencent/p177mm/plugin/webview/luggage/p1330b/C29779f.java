package com.tencent.p177mm.plugin.webview.luggage.p1330b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C22935h;

/* renamed from: com.tencent.mm.plugin.webview.luggage.b.f */
public final class C29779f extends C43884a {
    public C29779f() {
        super(35);
    }

    /* renamed from: a */
    public final void mo38418a(Context context, C24905d c24905d, C44273l c44273l) {
        AppMethodBeat.m2504i(6433);
        C22935h cWP = c24905d.cWP();
        if (c24905d.cWO() && cWP != null) {
            if (cWP.dbd()) {
                c44273l.mo70049a(35, context.getString(C25738R.string.dhm), (int) C1318a.bottomsheet_icon_webview_cancel_minimize);
            } else {
                c44273l.mo70049a(35, context.getString(C25738R.string.dhw), (int) C1318a.bottomsheet_icon_webview_minimize);
                AppMethodBeat.m2505o(6433);
                return;
            }
        }
        AppMethodBeat.m2505o(6433);
    }

    /* renamed from: a */
    public final void mo38417a(Context context, C24905d c24905d) {
        AppMethodBeat.m2504i(6434);
        C22935h cWP = c24905d.cWP();
        if (cWP != null) {
            if (cWP.dbd()) {
                cWP.mo38532nT(true);
                C7060h.pYm.mo15419k(982, 5, 1);
            } else {
                cWP.mo38532nT(false);
                C7060h.pYm.mo15419k(982, 4, 1);
                AppMethodBeat.m2505o(6434);
                return;
            }
        }
        AppMethodBeat.m2505o(6434);
    }
}
