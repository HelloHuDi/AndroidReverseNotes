package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.a.a.b;
import android.support.v4.a.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.ref.WeakReference;

public enum a {
    ;
    
    private static volatile WeakReference<Bitmap> fpX;

    /* JADX WARNING: Missing block: B:5:0x0018, code skipped:
            if (r0.isRecycled() == false) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Drawable abQ() {
        AppMethodBeat.i(93748);
        if (fpX != null) {
            Bitmap bitmap = (Bitmap) fpX.get();
            if (bitmap != null) {
            }
        }
        fpX = new WeakReference(com.tencent.mm.compatible.g.a.decodeResource(ah.getResources(), R.raw.miniprogram_default_avatar));
        b a = d.a(ah.getResources(), (Bitmap) fpX.get());
        a.dA();
        AppMethodBeat.o(93748);
        return a;
    }
}
