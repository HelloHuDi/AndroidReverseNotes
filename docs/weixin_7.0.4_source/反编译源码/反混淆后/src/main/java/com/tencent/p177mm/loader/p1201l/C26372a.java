package com.tencent.p177mm.loader.p1201l;

import android.graphics.Bitmap;
import com.tencent.p177mm.loader.p1197h.p1198a.C18543b;
import com.tencent.p177mm.loader.p1197h.p1198a.C42156a;
import com.tencent.p177mm.loader.p246e.p247b.C32731f;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.InputStream;

/* renamed from: com.tencent.mm.loader.l.a */
public final class C26372a {
    /* renamed from: d */
    public static boolean m41963d(C42156a c42156a) {
        if (c42156a == null || c42156a.mo67692Uf() == C18543b.ASSET_DATA || c42156a.mo67692Uf() == C18543b.DRAWABLE_ID || c42156a.mo67692Uf() == C18543b.LOCAL_PATH) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static Bitmap m41962a(C32731f<?> c32731f, InputStream inputStream, int i, int i2, boolean z, float f, boolean z2) {
        Bitmap a;
        if (i > 0 && i2 > 0) {
            a = C5056d.m7620a(inputStream, 0.0f, i, i2);
        } else if (c32731f == null || c32731f.width <= 0 || c32731f.width <= 0) {
            a = C5056d.decodeStream(inputStream);
        } else {
            a = C5056d.m7620a(inputStream, 0.0f, c32731f.width, c32731f.height);
        }
        if (z) {
            a = C5056d.m7615a(a, i, i2, false, true);
        }
        if (f > 0.0f) {
            a = C5056d.m7654c(a, f);
        }
        if (z2) {
            return C5056d.m7638ak(a);
        }
        return a;
    }
}
