package com.bumptech.glide.p086c.p092d.p093a;

import android.graphics.Bitmap;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.C31968k;
import com.bumptech.glide.p086c.p088b.C17526u;
import com.bumptech.glide.p086c.p088b.p089a.C31925e;
import com.bumptech.glide.p086c.p088b.p089a.C8515b;
import com.bumptech.glide.p086c.p092d.p093a.C31961h.C31960a;
import com.bumptech.glide.p095h.C37196d;
import com.bumptech.glide.p095h.C8560g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.c.d.a.o */
public final class C41554o implements C31968k<InputStream, Bitmap> {
    private final C31961h aEV;
    private final C8515b azx;

    /* renamed from: com.bumptech.glide.c.d.a.o$a */
    static class C0774a implements C31960a {
        private final C37196d aFD;
        private final C25444m azw;

        C0774a(C25444m c25444m, C37196d c37196d) {
            this.azw = c25444m;
            this.aFD = c37196d;
        }

        /* renamed from: ns */
        public final void mo2237ns() {
            AppMethodBeat.m2504i(92261);
            this.azw.mo42477nw();
            AppMethodBeat.m2505o(92261);
        }

        /* renamed from: a */
        public final void mo2236a(C31925e c31925e, Bitmap bitmap) {
            AppMethodBeat.m2504i(92262);
            IOException iOException = this.aFD.aIa;
            if (iOException != null) {
                if (bitmap != null) {
                    c31925e.mo2199g(bitmap);
                }
                AppMethodBeat.m2505o(92262);
                throw iOException;
            }
            AppMethodBeat.m2505o(92262);
        }
    }

    public C41554o(C31961h c31961h, C8515b c8515b) {
        this.aEV = c31961h;
        this.azx = c8515b;
    }

    /* renamed from: a */
    private C17526u<Bitmap> m72741a(InputStream inputStream, int i, int i2, C31967j c31967j) {
        Object obj;
        AppMethodBeat.m2504i(92263);
        if (inputStream instanceof C25444m) {
            inputStream = (C25444m) inputStream;
            obj = null;
        } else {
            int obj2 = 1;
            inputStream = new C25444m(inputStream, this.azx);
        }
        C37196d e = C37196d.m62347e(inputStream);
        try {
            C17526u<Bitmap> a = this.aEV.mo52067a(new C8560g(e), i, i2, c31967j, new C0774a(inputStream, e));
            return a;
        } finally {
            e.release();
            if (obj2 != null) {
                inputStream.release();
            }
            AppMethodBeat.m2505o(92263);
        }
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ boolean mo2235a(Object obj, C31967j c31967j) {
        return true;
    }
}
