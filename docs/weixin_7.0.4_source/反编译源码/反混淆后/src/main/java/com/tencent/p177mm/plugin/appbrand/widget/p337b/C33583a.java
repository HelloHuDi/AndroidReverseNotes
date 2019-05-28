package com.tencent.p177mm.plugin.appbrand.widget.p337b;

import android.content.Context;
import android.support.p057v4.widget.C8415j;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.b.a */
final class C33583a extends FrameLayout {
    public C33583a(Context context, View view) {
        super(context);
        AppMethodBeat.m2504i(77401);
        addView(view);
        AppMethodBeat.m2505o(77401);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(77402);
        if ((getParent() instanceof View) && ((View) getParent()).getMeasuredHeight() > 0) {
            i2 = MeasureSpec.makeMeasureSpec(((View) getParent()).getMeasuredHeight() - C1338a.fromDPToPix(getContext(), C40619x.m70075gu(getContext()) ? ErrorCode.NEEDDOWNLOAD_FALSE_3 : 24), C8415j.INVALID_ID);
        }
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(77402);
    }
}
