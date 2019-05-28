package com.bumptech.glide.p086c.p092d.p093a;

import android.graphics.Bitmap;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.C31968k;
import com.bumptech.glide.p086c.p088b.C17526u;
import com.bumptech.glide.p095h.C45002j;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.c.d.a.q */
public final class C37181q implements C31968k<Bitmap, Bitmap> {

    /* renamed from: com.bumptech.glide.c.d.a.q$a */
    static final class C31963a implements C17526u<Bitmap> {
        private final Bitmap bitmap;

        C31963a(Bitmap bitmap) {
            this.bitmap = bitmap;
        }

        /* renamed from: mK */
        public final Class<Bitmap> mo2232mK() {
            return Bitmap.class;
        }

        public final int getSize() {
            AppMethodBeat.m2504i(92268);
            int k = C45002j.m82425k(this.bitmap);
            AppMethodBeat.m2505o(92268);
            return k;
        }

        public final void recycle() {
        }

        public final /* bridge */ /* synthetic */ Object get() {
            return this.bitmap;
        }
    }

    /* renamed from: a */
    public final /* synthetic */ C17526u mo2234a(Object obj, int i, int i2, C31967j c31967j) {
        AppMethodBeat.m2504i(92269);
        C31963a c31963a = new C31963a((Bitmap) obj);
        AppMethodBeat.m2505o(92269);
        return c31963a;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ boolean mo2235a(Object obj, C31967j c31967j) {
        return true;
    }
}
