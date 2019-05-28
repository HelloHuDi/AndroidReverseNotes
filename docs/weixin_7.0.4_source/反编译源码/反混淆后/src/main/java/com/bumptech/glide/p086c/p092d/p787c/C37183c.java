package com.bumptech.glide.p086c.p092d.p787c;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.p086c.p088b.C17526u;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.c.d.c.c */
final class C37183c extends C25449b<Drawable> {
    /* renamed from: p */
    static C17526u<Drawable> m62323p(Drawable drawable) {
        AppMethodBeat.m2504i(92287);
        if (drawable != null) {
            C37183c c37183c = new C37183c(drawable);
            AppMethodBeat.m2505o(92287);
            return c37183c;
        }
        AppMethodBeat.m2505o(92287);
        return null;
    }

    private C37183c(Drawable drawable) {
        super(drawable);
    }

    /* renamed from: mK */
    public final Class<Drawable> mo2232mK() {
        AppMethodBeat.m2504i(92288);
        Class cls = this.drawable.getClass();
        AppMethodBeat.m2505o(92288);
        return cls;
    }

    public final int getSize() {
        AppMethodBeat.m2504i(92289);
        int max = Math.max(1, (this.drawable.getIntrinsicWidth() * this.drawable.getIntrinsicHeight()) * 4);
        AppMethodBeat.m2505o(92289);
        return max;
    }

    public final void recycle() {
    }
}
