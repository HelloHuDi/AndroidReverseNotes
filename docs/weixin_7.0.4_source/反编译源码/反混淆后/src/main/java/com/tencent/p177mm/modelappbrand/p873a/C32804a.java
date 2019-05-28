package com.tencent.p177mm.modelappbrand.p873a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.p057v4.p058a.p059a.C37111b;
import android.support.p057v4.p058a.p059a.C37112d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p222g.C1434a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.modelappbrand.a.a */
public enum C32804a {
    ;
    
    private static volatile WeakReference<Bitmap> fpX;

    /* JADX WARNING: Missing block: B:5:0x0018, code skipped:
            if (r0.isRecycled() == false) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Drawable abQ() {
        AppMethodBeat.m2504i(93748);
        if (fpX != null) {
            Bitmap bitmap = (Bitmap) fpX.get();
            if (bitmap != null) {
            }
        }
        fpX = new WeakReference(C1434a.decodeResource(C4996ah.getResources(), C1318a.miniprogram_default_avatar));
        C37111b a = C37112d.m62123a(C4996ah.getResources(), (Bitmap) fpX.get());
        a.mo59157dA();
        AppMethodBeat.m2505o(93748);
        return a;
    }
}
