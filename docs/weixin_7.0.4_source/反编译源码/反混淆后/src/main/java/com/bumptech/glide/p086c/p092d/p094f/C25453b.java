package com.bumptech.glide.p086c.p092d.p094f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.p088b.C17526u;
import com.bumptech.glide.p086c.p092d.p093a.C8548l;
import com.bumptech.glide.p095h.C8561i;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.c.d.f.b */
public final class C25453b implements C8553e<Bitmap, BitmapDrawable> {
    private final Resources aEH;

    public C25453b(Resources resources) {
        AppMethodBeat.m2504i(92361);
        this.aEH = (Resources) C8561i.m15217d(resources, "Argument must not be null");
        AppMethodBeat.m2505o(92361);
    }

    /* renamed from: a */
    public final C17526u<BitmapDrawable> mo18654a(C17526u<Bitmap> c17526u, C31967j c31967j) {
        AppMethodBeat.m2504i(92362);
        C17526u a = C8548l.m15192a(this.aEH, c17526u);
        AppMethodBeat.m2505o(92362);
        return a;
    }
}
