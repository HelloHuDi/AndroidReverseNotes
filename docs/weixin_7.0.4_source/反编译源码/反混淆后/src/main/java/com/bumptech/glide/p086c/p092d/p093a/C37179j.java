package com.bumptech.glide.p086c.p092d.p093a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.C8555c;
import com.bumptech.glide.p086c.C31970m;
import com.bumptech.glide.p086c.p088b.C17526u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.c.d.a.j */
public final class C37179j implements C31970m<Drawable> {
    private final C31970m<Bitmap> aFv;
    private final boolean aFw = true;

    public C37179j(C31970m<Bitmap> c31970m) {
        this.aFv = c31970m;
    }

    /* renamed from: a */
    public final C17526u<Drawable> mo31965a(Context context, C17526u<Drawable> c17526u, int i, int i2) {
        AppMethodBeat.m2504i(92235);
        Drawable drawable = (Drawable) c17526u.get();
        C17526u a = C44995i.m82394a(C8555c.m15204ae(context).awf, drawable, i, i2);
        if (a != null) {
            C17526u a2 = this.aFv.mo31965a(context, a, i, i2);
            if (a2.equals(a)) {
                a2.recycle();
                AppMethodBeat.m2505o(92235);
                return c17526u;
            }
            c17526u = C8548l.m15192a(context.getResources(), a2);
            AppMethodBeat.m2505o(92235);
            return c17526u;
        } else if (this.aFw) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
            AppMethodBeat.m2505o(92235);
            throw illegalArgumentException;
        } else {
            AppMethodBeat.m2505o(92235);
            return c17526u;
        }
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(92236);
        if (obj instanceof C37179j) {
            boolean equals = this.aFv.equals(((C37179j) obj).aFv);
            AppMethodBeat.m2505o(92236);
            return equals;
        }
        AppMethodBeat.m2505o(92236);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(92237);
        int hashCode = this.aFv.hashCode();
        AppMethodBeat.m2505o(92237);
        return hashCode;
    }

    /* renamed from: a */
    public final void mo2242a(MessageDigest messageDigest) {
        AppMethodBeat.m2504i(92238);
        this.aFv.mo2242a(messageDigest);
        AppMethodBeat.m2505o(92238);
    }
}
