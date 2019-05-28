package com.tencent.p177mm.plugin.webview.luggage.p1330b;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.modeltools.C35618a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.luggage.b.g */
public final class C22814g extends C43884a {
    private C35618a uju = new C35618a();

    public C22814g() {
        super(7);
        AppMethodBeat.m2504i(6435);
        AppMethodBeat.m2505o(6435);
    }

    /* renamed from: a */
    public final void mo38418a(Context context, C24905d c24905d, C44273l c44273l) {
        AppMethodBeat.m2504i(6436);
        c44273l.mo70049a(7, context.getString(C25738R.string.g20), (int) C1318a.bottomsheet_icon_brower);
        AppMethodBeat.m2505o(6436);
    }

    /* renamed from: a */
    public final void mo38417a(Context context, C24905d c24905d) {
        AppMethodBeat.m2504i(6437);
        String aek = c24905d.cWM().aek(c24905d.getUrl());
        if (C5046bo.isNullOrNil(aek)) {
            aek = c24905d.getUrl();
        }
        if (context instanceof Activity) {
            C35618a.m58463e((Activity) context, aek);
        }
        C7060h.pYm.mo15419k(982, 6, 1);
        AppMethodBeat.m2505o(6437);
    }
}
