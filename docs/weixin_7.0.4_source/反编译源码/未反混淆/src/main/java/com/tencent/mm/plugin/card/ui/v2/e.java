package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ah;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, dWq = {"radius_4dp", "", "getRadius_4dp", "()I", "plugin-card_release"})
public final class e {
    private static final int kqm;

    static {
        AppMethodBeat.i(89328);
        Context context = ah.getContext();
        j.o(context, "MMApplicationContext.getContext()");
        kqm = context.getResources().getDimensionPixelOffset(R.dimen.vo);
        AppMethodBeat.o(89328);
    }

    public static final int ber() {
        return kqm;
    }
}
