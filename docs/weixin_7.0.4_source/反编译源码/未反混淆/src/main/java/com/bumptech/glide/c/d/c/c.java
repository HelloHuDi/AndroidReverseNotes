package com.bumptech.glide.c.d.c;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.c.b.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c extends b<Drawable> {
    static u<Drawable> p(Drawable drawable) {
        AppMethodBeat.i(92287);
        if (drawable != null) {
            c cVar = new c(drawable);
            AppMethodBeat.o(92287);
            return cVar;
        }
        AppMethodBeat.o(92287);
        return null;
    }

    private c(Drawable drawable) {
        super(drawable);
    }

    public final Class<Drawable> mK() {
        AppMethodBeat.i(92288);
        Class cls = this.drawable.getClass();
        AppMethodBeat.o(92288);
        return cls;
    }

    public final int getSize() {
        AppMethodBeat.i(92289);
        int max = Math.max(1, (this.drawable.getIntrinsicWidth() * this.drawable.getIntrinsicHeight()) * 4);
        AppMethodBeat.o(92289);
        return max;
    }

    public final void recycle() {
    }
}
