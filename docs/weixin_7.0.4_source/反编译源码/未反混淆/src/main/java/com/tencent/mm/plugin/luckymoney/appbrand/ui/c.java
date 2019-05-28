package com.tencent.mm.plugin.luckymoney.appbrand.ui;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.ui.j;
import com.tencent.mm.ui.MMActivity;

public final class c extends j {
    public c(MMActivity mMActivity) {
        super(mMActivity);
    }

    public final void t(Drawable drawable) {
        AppMethodBeat.i(42016);
        super.t(drawable);
        AppMethodBeat.o(42016);
    }
}
