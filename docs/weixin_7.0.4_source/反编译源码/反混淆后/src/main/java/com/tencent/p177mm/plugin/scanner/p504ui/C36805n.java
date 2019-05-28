package com.tencent.p177mm.plugin.scanner.p504ui;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Looper;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C6535pp;
import com.tencent.p177mm.plugin.scanner.p504ui.C13161i.C13164b;
import com.tencent.p177mm.plugin.scanner.util.C21730k;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.scanner.ui.n */
public final class C36805n extends C34841m {
    public C36805n(C13164b c13164b, Point point, DisplayMetrics displayMetrics, int i) {
        super(c13164b, point, displayMetrics, i);
    }

    /* renamed from: b */
    public final void mo8421b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        AppMethodBeat.m2504i(81184);
        C4990ab.m7410d("MicroMsg.ScanModeLicenceForIdCardPayAuth", "onDecodeSuccess");
        Bitmap bitmap = ((C21730k) this.qen).qir;
        C4883b c6535pp = new C6535pp();
        c6535pp.cLM.cardType = "identity";
        c6535pp.cLM.cLN = 1;
        if (this.qen instanceof C21730k) {
            c6535pp.cLM.cLP = bitmap;
        }
        C4879a.xxA.mo10048a(c6535pp, Looper.getMainLooper());
        this.qet.getContext().finish();
        AppMethodBeat.m2505o(81184);
    }
}
