package com.bumptech.glide.p086c.p092d.p093a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.p086c.p088b.C17526u;
import com.bumptech.glide.p086c.p088b.C41547q;
import com.bumptech.glide.p095h.C8561i;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.c.d.a.l */
public final class C8548l implements C41547q, C17526u<BitmapDrawable> {
    private final Resources aEH;
    private final C17526u<Bitmap> aFB;

    /* renamed from: a */
    public static C17526u<BitmapDrawable> m15192a(Resources resources, C17526u<Bitmap> c17526u) {
        AppMethodBeat.m2504i(92242);
        if (c17526u == null) {
            AppMethodBeat.m2505o(92242);
            return null;
        }
        C17526u<BitmapDrawable> c8548l = new C8548l(resources, c17526u);
        AppMethodBeat.m2505o(92242);
        return c8548l;
    }

    private C8548l(Resources resources, C17526u<Bitmap> c17526u) {
        AppMethodBeat.m2504i(92243);
        this.aEH = (Resources) C8561i.m15217d(resources, "Argument must not be null");
        this.aFB = (C17526u) C8561i.m15217d(c17526u, "Argument must not be null");
        AppMethodBeat.m2505o(92243);
    }

    /* renamed from: mK */
    public final Class<BitmapDrawable> mo2232mK() {
        return BitmapDrawable.class;
    }

    public final int getSize() {
        AppMethodBeat.m2504i(92244);
        int size = this.aFB.getSize();
        AppMethodBeat.m2505o(92244);
        return size;
    }

    public final void recycle() {
        AppMethodBeat.m2504i(92245);
        this.aFB.recycle();
        AppMethodBeat.m2505o(92245);
    }

    public final void initialize() {
        AppMethodBeat.m2504i(92246);
        if (this.aFB instanceof C41547q) {
            ((C41547q) this.aFB).initialize();
        }
        AppMethodBeat.m2505o(92246);
    }

    public final /* synthetic */ Object get() {
        AppMethodBeat.m2504i(92247);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.aEH, (Bitmap) this.aFB.get());
        AppMethodBeat.m2505o(92247);
        return bitmapDrawable;
    }
}
