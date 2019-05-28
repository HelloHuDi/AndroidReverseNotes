package com.tencent.p177mm.modelappbrand.p873a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.modelappbrand.a.e */
public final class C42200e extends BitmapDrawable {
    public C42200e(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.m2504i(77382);
        if (!(getBitmap() == null || getBitmap().isRecycled())) {
            super.draw(canvas);
        }
        AppMethodBeat.m2505o(77382);
    }
}
