package com.tencent.mm.view.footer;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.e;
import com.tencent.mm.br.b;
import com.tencent.mm.sdk.platformtools.d;

public final class c extends a {
    private Bitmap Adg;
    private Bitmap Adh;

    /* Access modifiers changed, original: protected|final */
    public final void dMO() {
        AppMethodBeat.i(116446);
        super.dMO();
        this.Adg = d.v(getResources().getDrawable(R.raw.crop_video_unselected));
        this.Adh = d.v(getResources().getDrawable(R.raw.crop_video_selected));
        AppMethodBeat.o(116446);
    }

    /* Access modifiers changed, original: protected|final */
    public final Bitmap a(e eVar, boolean z) {
        if (eVar == e.CROP_VIDEO) {
            return z ? this.Adh : this.Adg;
        } else {
            return null;
        }
    }

    public c(Context context, b bVar) {
        super(context, bVar);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean QG(int i) {
        AppMethodBeat.i(116447);
        boolean QG = super.QG(i);
        switch (QF(i)) {
            case CROP_VIDEO:
                QG = false;
                break;
        }
        AppMethodBeat.o(116447);
        return QG;
    }
}
