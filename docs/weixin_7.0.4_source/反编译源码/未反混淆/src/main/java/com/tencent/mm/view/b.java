package com.tencent.mm.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.e;
import com.tencent.mm.api.s.a;

public final class b extends a {
    public b(Context context, a aVar) {
        super(context, aVar);
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.view.b.a dMG() {
        AppMethodBeat.i(116386);
        com.tencent.mm.view.b.b bVar = new com.tencent.mm.view.b.b(getContext(), getPresenter());
        AppMethodBeat.o(116386);
        return bVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.view.footer.a dMH() {
        AppMethodBeat.i(116387);
        com.tencent.mm.view.footer.b bVar = new com.tencent.mm.view.footer.b(getContext(), getPresenter());
        AppMethodBeat.o(116387);
        return bVar;
    }

    public final e[] getFeatures() {
        if (this.zZM == null) {
            this.zZM = new e[]{e.DOODLE, e.EMOJI, e.TEXT, e.MOSAIC, e.CROP_PHOTO};
        }
        return this.zZM;
    }
}
