package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.view.d;

public final class u implements f {
    Context context;
    p mzU;
    private ap ppI = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(27722);
            u uVar = u.this;
            Context context = u.this.context;
            u.this.context.getString(R.string.tz);
            uVar.mzU = h.b(context, u.this.context.getString(R.string.un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(27721);
                    aw.Rg().c(u.this.qhf);
                    u.this.mzU = null;
                    AppMethodBeat.o(27721);
                }
            });
            AppMethodBeat.o(27722);
            return false;
        }
    }, false);
    com.tencent.mm.modelsimple.h qhf;
    private String vlr;

    public u(Context context) {
        AppMethodBeat.i(27723);
        this.context = context;
        AppMethodBeat.o(27723);
    }

    public final void ajG(String str) {
        AppMethodBeat.i(27724);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.ViewQZone", "go fail, qqNum is null");
            AppMethodBeat.o(27724);
            return;
        }
        this.vlr = str;
        aw.ZK();
        String str2 = (String) c.Ry().get(46, null);
        aw.ZK();
        ab.i("MicroMsg.ViewQZone", "get a2key:[%s], get new a2key:[%s]", str2, bo.nullAsNil((String) c.Ry().get(72, null)));
        if (bo.isNullOrNil(str2) && bo.isNullOrNil(r1)) {
            ajH(str);
            AppMethodBeat.o(27724);
            return;
        }
        aw.Rg().a((int) d.MIC_PTU_MEISHI, (f) this);
        this.qhf = new com.tencent.mm.modelsimple.h(com.tencent.mm.a.p.cB(str), (int) System.currentTimeMillis());
        aw.Rg().a(this.qhf, 0);
        this.ppI.ae(3000, 3000);
        AppMethodBeat.o(27724);
    }

    private void ajH(String str) {
        AppMethodBeat.i(27725);
        Intent intent = new Intent();
        String str2 = "rawUrl";
        intent.putExtra(str2, this.context.getString(R.string.az4, new Object[]{str}));
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        intent.putExtra("neverGetA8Key", true);
        com.tencent.mm.bp.d.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", intent);
        AppMethodBeat.o(27725);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(27726);
        this.ppI.stopTimer();
        if (this.mzU != null) {
            this.mzU.dismiss();
        }
        aw.Rg().b((int) d.MIC_PTU_MEISHI, (f) this);
        if (i == 0 && i2 == 0) {
            com.tencent.mm.modelsimple.h hVar = (com.tencent.mm.modelsimple.h) mVar;
            String aiT = hVar.aiT();
            if (aiT == null || aiT.length() == 0) {
                ajH(this.vlr);
                AppMethodBeat.o(27726);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", aiT);
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            intent.putExtra("neverGetA8Key", true);
            intent.putExtra("geta8key_session_id", hVar.ajb());
            com.tencent.mm.bp.d.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", intent);
            AppMethodBeat.o(27726);
            return;
        }
        ab.e("MicroMsg.ViewQZone", "getA8Key fail, errType = " + i + ", errCode = " + i2);
        ajH(this.vlr);
        AppMethodBeat.o(27726);
    }
}
