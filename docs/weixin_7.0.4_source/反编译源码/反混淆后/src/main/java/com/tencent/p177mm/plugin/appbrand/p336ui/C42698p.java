package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.p */
final class C42698p {
    /* renamed from: b */
    static void m75626b(MMActivity mMActivity) {
        AppMethodBeat.m2504i(93755);
        if (mMActivity.getSupportActionBar() == null) {
            AppMethodBeat.m2505o(93755);
            return;
        }
        View findViewById = mMActivity.getSupportActionBar().getCustomView().findViewById(2131820973);
        if (!(findViewById == null || findViewById.getLayoutParams() == null || !(findViewById.getLayoutParams() instanceof MarginLayoutParams))) {
            ((MarginLayoutParams) findViewById.getLayoutParams()).rightMargin = 0;
            findViewById.requestLayout();
        }
        AppMethodBeat.m2505o(93755);
    }
}
