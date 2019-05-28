package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

final class e {
    ap frk = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(7414);
            if (e.this.urQ.isFinishing()) {
                ab.w("MicroMsg.OAuthSession", "onTimerExpired, context is finishing");
                AppMethodBeat.o(7414);
            } else {
                e eVar = e.this;
                Context context = e.this.urQ;
                e.this.urQ.getString(R.string.tz);
                eVar.mzU = h.b(context, e.this.urQ.getString(R.string.un), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(7413);
                        try {
                            dialogInterface.dismiss();
                            AppMethodBeat.o(7413);
                        } catch (Exception e) {
                            ab.e("MicroMsg.OAuthSession", "onCancel, ex = " + e.getMessage());
                            AppMethodBeat.o(7413);
                        }
                    }
                });
                AppMethodBeat.o(7414);
            }
            return false;
        }
    }, false);
    d icy;
    p mzU;
    boolean urN = false;
    boolean urO = false;
    final a urP;
    OAuthUI urQ;

    public interface a {
        void a(e eVar, String str, boolean z);

        void d(boolean z, String str, String str2, String str3);
    }

    private e(OAuthUI oAuthUI, a aVar, d dVar) {
        AppMethodBeat.i(7415);
        this.urQ = oAuthUI;
        this.urP = aVar;
        this.icy = dVar;
        AppMethodBeat.o(7415);
    }

    public static e a(OAuthUI oAuthUI, String str, Req req, a aVar, d dVar) {
        AppMethodBeat.i(7416);
        e eVar = new e(oAuthUI, aVar, dVar);
        String str2 = req.scope;
        String str3 = req.state;
        if (eVar.urN) {
            ab.e("MicroMsg.OAuthSession", "already getting");
        } else {
            eVar.urO = true;
            Bundle bundle = new Bundle();
            bundle.putString("geta8key_data_appid", str);
            bundle.putString("geta8key_data_scope", str2);
            bundle.putString("geta8key_data_state", str3);
            try {
                eVar.icy.s(com.tencent.view.d.MIC_PTU_MEISHI, bundle);
                eVar.urN = true;
            } catch (Exception e) {
                ab.w("MicroMsg.OAuthSession", "startGetA8Key, ex = " + e.getMessage());
            }
            eVar.frk.ae(3000, 3000);
        }
        AppMethodBeat.o(7416);
        return eVar;
    }
}
