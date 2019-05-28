package com.tencent.p177mm.plugin.webview.luggage.p1330b;

import android.content.Context;
import android.text.ClipboardManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.luggage.b.b */
public final class C44782b extends C43884a {
    public C44782b() {
        super(6);
    }

    /* renamed from: a */
    public final void mo38418a(Context context, C24905d c24905d, C44273l c44273l) {
        AppMethodBeat.m2504i(6422);
        if (c24905d.mo23981wD(44)) {
            c44273l.mo70049a(6, context.getString(C25738R.string.g1v), (int) C1318a.bottomsheet_icon_copy);
        }
        AppMethodBeat.m2505o(6422);
    }

    /* renamed from: a */
    public final void mo38417a(Context context, C24905d c24905d) {
        CharSequence url;
        AppMethodBeat.m2504i(6423);
        String aek = c24905d.cWM().aek(c24905d.getUrl());
        if (C5046bo.isNullOrNil(aek)) {
            url = c24905d.getUrl();
        } else {
            Object url2 = aek;
        }
        ClipboardManager clipboardManager = (ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
        if (clipboardManager != null) {
            try {
                clipboardManager.setText(url2);
                Toast.makeText(context, context.getString(C25738R.string.g1w), 0).show();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MenuDelegate_CopyLink", e, "clip.setText error", new Object[0]);
            }
        }
        C7060h.pYm.mo15419k(982, 0, 1);
        AppMethodBeat.m2505o(6423);
    }
}
