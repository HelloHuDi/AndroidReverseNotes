package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.text.ClipboardManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;

public final class b extends a {
    public b() {
        super(6);
    }

    public final void a(Context context, d dVar, l lVar) {
        AppMethodBeat.i(6422);
        if (dVar.wD(44)) {
            lVar.a(6, context.getString(R.string.g1v), (int) R.raw.bottomsheet_icon_copy);
        }
        AppMethodBeat.o(6422);
    }

    public final void a(Context context, d dVar) {
        CharSequence url;
        AppMethodBeat.i(6423);
        String aek = dVar.cWM().aek(dVar.getUrl());
        if (bo.isNullOrNil(aek)) {
            url = dVar.getUrl();
        } else {
            Object url2 = aek;
        }
        ClipboardManager clipboardManager = (ClipboardManager) ah.getContext().getSystemService("clipboard");
        if (clipboardManager != null) {
            try {
                clipboardManager.setText(url2);
                Toast.makeText(context, context.getString(R.string.g1w), 0).show();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MenuDelegate_CopyLink", e, "clip.setText error", new Object[0]);
            }
        }
        h.pYm.k(982, 0, 1);
        AppMethodBeat.o(6423);
    }
}
