package com.bumptech.glide.p086c.p092d.p788e;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.C8555c;
import com.bumptech.glide.p086c.C31970m;
import com.bumptech.glide.p086c.p088b.C17526u;
import com.bumptech.glide.p086c.p092d.p093a.C0771d;
import com.bumptech.glide.p095h.C8561i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.c.d.e.f */
public final class C17543f implements C31970m<C37186c> {
    private final C31970m<Bitmap> aFv;

    public C17543f(C31970m<Bitmap> c31970m) {
        AppMethodBeat.m2504i(92337);
        this.aFv = (C31970m) C8561i.m15217d(c31970m, "Argument must not be null");
        AppMethodBeat.m2505o(92337);
    }

    /* renamed from: a */
    public final C17526u<C37186c> mo31965a(Context context, C17526u<C37186c> c17526u, int i, int i2) {
        AppMethodBeat.m2504i(92338);
        C37186c c37186c = (C37186c) c17526u.get();
        C0771d c0771d = new C0771d(c37186c.mo59276ny(), C8555c.m15204ae(context).awf);
        C17526u a = this.aFv.mo31965a(context, c0771d, i, i2);
        if (!c0771d.equals(a)) {
            c0771d.recycle();
        }
        Bitmap bitmap = (Bitmap) a.get();
        c37186c.aFU.aGa.mo42489a(this.aFv, bitmap);
        AppMethodBeat.m2505o(92338);
        return c17526u;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(92339);
        if (obj instanceof C17543f) {
            boolean equals = this.aFv.equals(((C17543f) obj).aFv);
            AppMethodBeat.m2505o(92339);
            return equals;
        }
        AppMethodBeat.m2505o(92339);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(92340);
        int hashCode = this.aFv.hashCode();
        AppMethodBeat.m2505o(92340);
        return hashCode;
    }

    /* renamed from: a */
    public final void mo2242a(MessageDigest messageDigest) {
        AppMethodBeat.m2504i(92341);
        this.aFv.mo2242a(messageDigest);
        AppMethodBeat.m2505o(92341);
    }
}
