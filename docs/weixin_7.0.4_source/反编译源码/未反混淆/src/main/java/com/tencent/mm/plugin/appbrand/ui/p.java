package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

final class p {
    static void b(MMActivity mMActivity) {
        AppMethodBeat.i(93755);
        if (mMActivity.getSupportActionBar() == null) {
            AppMethodBeat.o(93755);
            return;
        }
        View findViewById = mMActivity.getSupportActionBar().getCustomView().findViewById(R.id.kw);
        if (!(findViewById == null || findViewById.getLayoutParams() == null || !(findViewById.getLayoutParams() instanceof MarginLayoutParams))) {
            ((MarginLayoutParams) findViewById.getLayoutParams()).rightMargin = 0;
            findViewById.requestLayout();
        }
        AppMethodBeat.o(93755);
    }
}
