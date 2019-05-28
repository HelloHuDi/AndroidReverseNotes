package com.tencent.mm.plugin.appbrand.widget.h;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a;

public final class b extends a {
    public b(Drawable drawable) {
        super(drawable);
    }

    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        AppMethodBeat.i(134411);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
        AppMethodBeat.o(134411);
    }
}
