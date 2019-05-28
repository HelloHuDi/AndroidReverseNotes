package com.bumptech.glide.p086c.p092d.p094f;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.p088b.C17526u;
import com.bumptech.glide.p086c.p088b.p089a.C31925e;
import com.bumptech.glide.p086c.p092d.p093a.C0771d;
import com.bumptech.glide.p086c.p092d.p788e.C37186c;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.c.d.f.c */
public final class C17544c implements C8553e<Drawable, byte[]> {
    private final C8553e<Bitmap, byte[]> aGq;
    private final C8553e<C37186c, byte[]> aGr;
    private final C31925e awf;

    public C17544c(C31925e c31925e, C8553e<Bitmap, byte[]> c8553e, C8553e<C37186c, byte[]> c8553e2) {
        this.awf = c31925e;
        this.aGq = c8553e;
        this.aGr = c8553e2;
    }

    /* renamed from: a */
    public final C17526u<byte[]> mo18654a(C17526u<Drawable> c17526u, C31967j c31967j) {
        AppMethodBeat.m2504i(92363);
        Drawable drawable = (Drawable) c17526u.get();
        if (drawable instanceof BitmapDrawable) {
            C17526u a = this.aGq.mo18654a(C0771d.m1760a(((BitmapDrawable) drawable).getBitmap(), this.awf), c31967j);
            AppMethodBeat.m2505o(92363);
            return a;
        } else if (drawable instanceof C37186c) {
            C17526u<byte[]> a2 = this.aGr.mo18654a(c17526u, c31967j);
            AppMethodBeat.m2505o(92363);
            return a2;
        } else {
            AppMethodBeat.m2505o(92363);
            return null;
        }
    }
}
