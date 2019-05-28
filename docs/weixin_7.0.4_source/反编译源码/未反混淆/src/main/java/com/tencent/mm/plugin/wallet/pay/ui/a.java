package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.g;

public final class a {
    private Dialog gII = null;
    private Context mContext;
    a toy = null;

    public interface a {
        void c(boolean z, String str, String str2);
    }

    public a(Context context, a aVar) {
        this.mContext = context;
        this.toy = aVar;
    }

    public final void release() {
        this.toy = null;
        this.mContext = null;
    }

    public final void a(boolean z, int i, String str) {
        AppMethodBeat.i(45954);
        final b hdVar = new hd();
        hdVar.cBQ = null;
        hdVar.cBP.cBR = z;
        if (z && (this.gII == null || !(this.gII == null || this.gII.isShowing()))) {
            if (this.gII != null) {
                this.gII.dismiss();
            }
            this.gII = g.a(this.mContext, false, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(45953);
                    a.this.cNM();
                    AppMethodBeat.o(45953);
                }
            });
        }
        hdVar.cBP.cBS = i;
        hdVar.cBP.cBT = str;
        hdVar.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.i(45952);
                ab.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback");
                hd.b bVar = hdVar.cBQ;
                if (bVar != null && bVar.cxT) {
                    ab.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is true");
                    a.this.cNM();
                    if (a.this.toy != null) {
                        a.this.toy.c(bVar.cxT, bVar.cBU, bVar.cBV);
                        AppMethodBeat.o(45952);
                        return;
                    }
                } else if (bVar == null || bVar.cxT) {
                    ab.i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result == null");
                } else {
                    a.this.cNM();
                    if (a.this.toy != null) {
                        a.this.toy.c(bVar.cxT, bVar.cBU, bVar.cBV);
                    }
                    ab.e("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is false");
                    AppMethodBeat.o(45952);
                    return;
                }
                AppMethodBeat.o(45952);
            }
        };
        com.tencent.mm.sdk.b.a.xxA.a(hdVar, Looper.getMainLooper());
        AppMethodBeat.o(45954);
    }

    public final void cNM() {
        AppMethodBeat.i(45955);
        if (this.gII != null) {
            this.gII.dismiss();
            this.gII = null;
        }
        AppMethodBeat.o(45955);
    }
}
