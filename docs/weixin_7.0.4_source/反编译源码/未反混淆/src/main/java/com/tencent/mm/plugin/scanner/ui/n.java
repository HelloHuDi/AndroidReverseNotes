package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Looper;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pp;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class n extends m {
    public n(b bVar, Point point, DisplayMetrics displayMetrics, int i) {
        super(bVar, point, displayMetrics, i);
    }

    public final void b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        AppMethodBeat.i(81184);
        ab.d("MicroMsg.ScanModeLicenceForIdCardPayAuth", "onDecodeSuccess");
        Bitmap bitmap = ((k) this.qen).qir;
        com.tencent.mm.sdk.b.b ppVar = new pp();
        ppVar.cLM.cardType = "identity";
        ppVar.cLM.cLN = 1;
        if (this.qen instanceof k) {
            ppVar.cLM.cLP = bitmap;
        }
        a.xxA.a(ppVar, Looper.getMainLooper());
        this.qet.getContext().finish();
        AppMethodBeat.o(81184);
    }
}
