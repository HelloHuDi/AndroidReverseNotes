package com.tencent.p177mm.plugin.wallet.pay.p557ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C42000hd;
import com.tencent.p177mm.p230g.p231a.C42000hd.C18279b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;

/* renamed from: com.tencent.mm.plugin.wallet.pay.ui.a */
public final class C14196a {
    private Dialog gII = null;
    private Context mContext;
    C14198a toy = null;

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.a$2 */
    class C141972 implements OnCancelListener {
        C141972() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(45953);
            C14196a.this.cNM();
            AppMethodBeat.m2505o(45953);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.a$a */
    public interface C14198a {
        /* renamed from: c */
        void mo26490c(boolean z, String str, String str2);
    }

    public C14196a(Context context, C14198a c14198a) {
        this.mContext = context;
        this.toy = c14198a;
    }

    public final void release() {
        this.toy = null;
        this.mContext = null;
    }

    /* renamed from: a */
    public final void mo26486a(boolean z, int i, String str) {
        AppMethodBeat.m2504i(45954);
        final C4883b c42000hd = new C42000hd();
        c42000hd.cBQ = null;
        c42000hd.cBP.cBR = z;
        if (z && (this.gII == null || !(this.gII == null || this.gII.isShowing()))) {
            if (this.gII != null) {
                this.gII.dismiss();
            }
            this.gII = C30901g.m49317a(this.mContext, false, new C141972());
        }
        c42000hd.cBP.cBS = i;
        c42000hd.cBP.cBT = str;
        c42000hd.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(45952);
                C4990ab.m7416i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback");
                C18279b c18279b = c42000hd.cBQ;
                if (c18279b != null && c18279b.cxT) {
                    C4990ab.m7416i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is true");
                    C14196a.this.cNM();
                    if (C14196a.this.toy != null) {
                        C14196a.this.toy.mo26490c(c18279b.cxT, c18279b.cBU, c18279b.cBV);
                        AppMethodBeat.m2505o(45952);
                        return;
                    }
                } else if (c18279b == null || c18279b.cxT) {
                    C4990ab.m7416i("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result == null");
                } else {
                    C14196a.this.cNM();
                    if (C14196a.this.toy != null) {
                        C14196a.this.toy.mo26490c(c18279b.cxT, c18279b.cBU, c18279b.cBV);
                    }
                    C4990ab.m7412e("MicroMsg.RegenFingerPrintRsaKey", "GenFingerPrintRsaKeyEvent callback, result.isSuccess is false");
                    AppMethodBeat.m2505o(45952);
                    return;
                }
                AppMethodBeat.m2505o(45952);
            }
        };
        C4879a.xxA.mo10048a(c42000hd, Looper.getMainLooper());
        AppMethodBeat.m2505o(45954);
    }

    public final void cNM() {
        AppMethodBeat.m2504i(45955);
        if (this.gII != null) {
            this.gII.dismiss();
            this.gII = null;
        }
        AppMethodBeat.m2505o(45955);
    }
}
