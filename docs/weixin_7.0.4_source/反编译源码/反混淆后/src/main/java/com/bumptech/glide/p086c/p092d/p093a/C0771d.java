package com.bumptech.glide.p086c.p092d.p093a;

import android.graphics.Bitmap;
import com.bumptech.glide.p086c.p088b.C17526u;
import com.bumptech.glide.p086c.p088b.C41547q;
import com.bumptech.glide.p086c.p088b.p089a.C31925e;
import com.bumptech.glide.p095h.C45002j;
import com.bumptech.glide.p095h.C8561i;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.c.d.a.d */
public final class C0771d implements C41547q, C17526u<Bitmap> {
    private final C31925e awf;
    private final Bitmap bitmap;

    /* renamed from: a */
    public static C0771d m1760a(Bitmap bitmap, C31925e c31925e) {
        AppMethodBeat.m2504i(92187);
        if (bitmap == null) {
            AppMethodBeat.m2505o(92187);
            return null;
        }
        C0771d c0771d = new C0771d(bitmap, c31925e);
        AppMethodBeat.m2505o(92187);
        return c0771d;
    }

    public C0771d(Bitmap bitmap, C31925e c31925e) {
        AppMethodBeat.m2504i(92188);
        this.bitmap = (Bitmap) C8561i.m15217d(bitmap, "Bitmap must not be null");
        this.awf = (C31925e) C8561i.m15217d(c31925e, "BitmapPool must not be null");
        AppMethodBeat.m2505o(92188);
    }

    /* renamed from: mK */
    public final Class<Bitmap> mo2232mK() {
        return Bitmap.class;
    }

    public final int getSize() {
        AppMethodBeat.m2504i(92189);
        int k = C45002j.m82425k(this.bitmap);
        AppMethodBeat.m2505o(92189);
        return k;
    }

    public final void recycle() {
        AppMethodBeat.m2504i(92190);
        this.awf.mo2199g(this.bitmap);
        AppMethodBeat.m2505o(92190);
    }

    public final void initialize() {
        AppMethodBeat.m2504i(92191);
        this.bitmap.prepareToDraw();
        AppMethodBeat.m2505o(92191);
    }

    public final /* bridge */ /* synthetic */ Object get() {
        return this.bitmap;
    }
}
