package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.view.d;

public final class r implements f {
    Context context;
    p mzU;
    ap ppI = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(81363);
            r rVar = r.this;
            Context context = r.this.context;
            r.this.context.getString(R.string.tz);
            rVar.mzU = h.b(context, r.this.context.getString(R.string.un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(81362);
                    g.Rg().c(r.this.qhf);
                    r.this.mzU = null;
                    AppMethodBeat.o(81362);
                }
            });
            AppMethodBeat.o(81363);
            return false;
        }
    }, false);
    com.tencent.mm.modelsimple.h qhf;
    String url;

    public r(Context context) {
        AppMethodBeat.i(81364);
        this.context = context;
        AppMethodBeat.o(81364);
    }

    /* Access modifiers changed, original: final */
    public final void c(String str, int i, byte[] bArr) {
        AppMethodBeat.i(81365);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        intent.putExtra("geta8key_session_id", i);
        intent.putExtra("geta8key_cookie", bArr);
        c.gkE.i(intent, this.context);
        AppMethodBeat.o(81365);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(81366);
        this.ppI.stopTimer();
        if (this.mzU != null) {
            this.mzU.dismiss();
        }
        g.Rg().b((int) d.MIC_PTU_MEISHI, (f) this);
        com.tencent.mm.modelsimple.h hVar = (com.tencent.mm.modelsimple.h) mVar;
        if (i == 0 && i2 == 0) {
            String aiT = hVar.aiT();
            if (aiT == null || aiT.length() == 0) {
                c(this.url, hVar.ajb(), hVar.ajc());
                AppMethodBeat.o(81366);
                return;
            }
            c(aiT, hVar.ajb(), hVar.ajc());
            AppMethodBeat.o(81366);
            return;
        }
        ab.e("MicroMsg.scanner.ViewMMURL", "getA8Key fail, errType = " + i + ", errCode = " + i2);
        c(this.url, hVar.ajb(), hVar.ajc());
        AppMethodBeat.o(81366);
    }
}
