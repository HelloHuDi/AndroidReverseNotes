package com.tencent.p177mm.plugin.appbrand.widget.p916h;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.C5664a;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.h.b */
public final class C10982b extends C5664a {
    public C10982b(Drawable drawable) {
        super(drawable);
    }

    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        AppMethodBeat.m2504i(134411);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
        AppMethodBeat.m2505o(134411);
    }
}
