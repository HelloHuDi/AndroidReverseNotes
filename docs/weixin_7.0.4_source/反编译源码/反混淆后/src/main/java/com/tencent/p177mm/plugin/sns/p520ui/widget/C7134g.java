package com.tencent.p177mm.plugin.sns.p520ui.widget;

import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.C5664a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.sns.ui.widget.g */
public final class C7134g extends C5664a {
    public C7134g(Drawable drawable) {
        super(drawable);
    }

    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
        AppMethodBeat.m2504i(40524);
        int fromDPToPix = C1338a.fromDPToPix(C4996ah.getContext(), 4) + super.getSize(paint, charSequence, i, i2, fontMetricsInt);
        AppMethodBeat.m2505o(40524);
        return fromDPToPix;
    }
}
