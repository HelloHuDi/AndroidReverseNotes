package com.tencent.mm.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.e;
import com.tencent.mm.api.s.a;
import com.tencent.mm.view.b.c;

public final class d extends a {
    public d(Context context, a aVar) {
        super(context, aVar);
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.view.b.a dMG() {
        AppMethodBeat.i(116393);
        c cVar = new c(getContext(), getPresenter());
        AppMethodBeat.o(116393);
        return cVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.view.footer.a dMH() {
        AppMethodBeat.i(116394);
        com.tencent.mm.view.footer.c cVar = new com.tencent.mm.view.footer.c(getContext(), getPresenter());
        AppMethodBeat.o(116394);
        return cVar;
    }

    public final e[] getFeatures() {
        if (this.zZM == null) {
            this.zZM = new e[]{e.DOODLE, e.EMOJI, e.TEXT, e.CROP_VIDEO};
        }
        return this.zZM;
    }
}
