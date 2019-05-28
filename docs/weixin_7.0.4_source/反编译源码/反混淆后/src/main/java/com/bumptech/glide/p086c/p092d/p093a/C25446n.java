package com.bumptech.glide.p086c.p092d.p093a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.C31968k;
import com.bumptech.glide.p086c.p088b.C17526u;
import com.bumptech.glide.p086c.p088b.p089a.C31925e;
import com.bumptech.glide.p086c.p092d.p787c.C41557d;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.c.d.a.n */
public final class C25446n implements C31968k<Uri, Bitmap> {
    private final C41557d aFC;
    private final C31925e awf;

    /* renamed from: a */
    public final /* synthetic */ C17526u mo2234a(Object obj, int i, int i2, C31967j c31967j) {
        AppMethodBeat.m2504i(92259);
        C17526u m = this.aFC.mo66576m((Uri) obj);
        if (m == null) {
            AppMethodBeat.m2505o(92259);
            return null;
        }
        m = C44995i.m82394a(this.awf, (Drawable) m.get(), i, i2);
        AppMethodBeat.m2505o(92259);
        return m;
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo2235a(Object obj, C31967j c31967j) {
        AppMethodBeat.m2504i(92260);
        boolean equals = "android.resource".equals(((Uri) obj).getScheme());
        AppMethodBeat.m2505o(92260);
        return equals;
    }

    public C25446n(C41557d c41557d, C31925e c31925e) {
        this.aFC = c41557d;
        this.awf = c31925e;
    }
}
