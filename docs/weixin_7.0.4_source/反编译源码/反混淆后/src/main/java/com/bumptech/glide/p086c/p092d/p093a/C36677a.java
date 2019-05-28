package com.bumptech.glide.p086c.p092d.p093a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.C31968k;
import com.bumptech.glide.p086c.p088b.C17526u;
import com.bumptech.glide.p095h.C8561i;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.c.d.a.a */
public final class C36677a<DataType> implements C31968k<DataType, BitmapDrawable> {
    private final Resources aEH;
    private final C31968k<DataType, Bitmap> aES;

    public C36677a(Resources resources, C31968k<DataType, Bitmap> c31968k) {
        AppMethodBeat.m2504i(92179);
        this.aEH = (Resources) C8561i.m15217d(resources, "Argument must not be null");
        this.aES = (C31968k) C8561i.m15217d(c31968k, "Argument must not be null");
        AppMethodBeat.m2505o(92179);
    }

    /* renamed from: a */
    public final boolean mo2235a(DataType dataType, C31967j c31967j) {
        AppMethodBeat.m2504i(92180);
        boolean a = this.aES.mo2235a(dataType, c31967j);
        AppMethodBeat.m2505o(92180);
        return a;
    }

    /* renamed from: a */
    public final C17526u<BitmapDrawable> mo2234a(DataType dataType, int i, int i2, C31967j c31967j) {
        AppMethodBeat.m2504i(92181);
        C17526u a = C8548l.m15192a(this.aEH, this.aES.mo2234a(dataType, i, i2, c31967j));
        AppMethodBeat.m2505o(92181);
        return a;
    }
}
