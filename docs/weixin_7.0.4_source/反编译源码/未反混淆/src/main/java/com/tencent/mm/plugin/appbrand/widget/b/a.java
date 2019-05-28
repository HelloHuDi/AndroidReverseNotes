package com.tencent.mm.plugin.appbrand.widget.b;

import android.content.Context;
import android.support.v4.widget.j;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

final class a extends FrameLayout {
    public a(Context context, View view) {
        super(context);
        AppMethodBeat.i(77401);
        addView(view);
        AppMethodBeat.o(77401);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.i(77402);
        if ((getParent() instanceof View) && ((View) getParent()).getMeasuredHeight() > 0) {
            i2 = MeasureSpec.makeMeasureSpec(((View) getParent()).getMeasuredHeight() - com.tencent.mm.bz.a.fromDPToPix(getContext(), x.gu(getContext()) ? ErrorCode.NEEDDOWNLOAD_FALSE_3 : 24), j.INVALID_ID);
        }
        super.onMeasure(i, i2);
        AppMethodBeat.o(77402);
    }
}
