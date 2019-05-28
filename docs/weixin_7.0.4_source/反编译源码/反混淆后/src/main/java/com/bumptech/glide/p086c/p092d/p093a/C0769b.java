package com.bumptech.glide.p086c.p092d.p093a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.C31969l;
import com.bumptech.glide.p086c.C44994c;
import com.bumptech.glide.p086c.p088b.C17526u;
import com.bumptech.glide.p086c.p088b.p089a.C31925e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

/* renamed from: com.bumptech.glide.c.d.a.b */
public final class C0769b implements C31969l<BitmapDrawable> {
    private final C31969l<Bitmap> aAN;
    private final C31925e awf;

    /* renamed from: a */
    public final /* synthetic */ boolean mo2227a(Object obj, File file, C31967j c31967j) {
        AppMethodBeat.m2504i(92183);
        boolean a = this.aAN.mo2227a(new C0771d(((BitmapDrawable) ((C17526u) obj).get()).getBitmap(), this.awf), file, c31967j);
        AppMethodBeat.m2505o(92183);
        return a;
    }

    public C0769b(C31925e c31925e, C31969l<Bitmap> c31969l) {
        this.awf = c31925e;
        this.aAN = c31969l;
    }

    /* renamed from: b */
    public final C44994c mo2228b(C31967j c31967j) {
        AppMethodBeat.m2504i(92182);
        C44994c b = this.aAN.mo2228b(c31967j);
        AppMethodBeat.m2505o(92182);
        return b;
    }
}
