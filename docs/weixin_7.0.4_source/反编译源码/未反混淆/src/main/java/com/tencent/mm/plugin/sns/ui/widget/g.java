package com.tencent.mm.plugin.sns.ui.widget;

import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.widget.a;

public final class g extends a {
    public g(Drawable drawable) {
        super(drawable);
    }

    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
        AppMethodBeat.i(40524);
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 4) + super.getSize(paint, charSequence, i, i2, fontMetricsInt);
        AppMethodBeat.o(40524);
        return fromDPToPix;
    }
}
