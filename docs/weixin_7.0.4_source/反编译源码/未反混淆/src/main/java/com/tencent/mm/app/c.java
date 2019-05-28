package com.tencent.mm.app;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.o;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.sdk.platformtools.ah;

final class c implements a {
    private volatile Bitmap cdX = null;
    d cdY;

    public final void a(i iVar) {
        AppMethodBeat.i(15368);
        if (iVar instanceof d.a) {
            o.acd().a((d.a) iVar);
        }
        AppMethodBeat.o(15368);
    }

    public final Bitmap AZ() {
        AppMethodBeat.i(15370);
        if (this.cdX == null) {
            synchronized (this) {
                try {
                    if (this.cdX == null) {
                        this.cdX = com.tencent.mm.compatible.g.a.decodeResource(ah.getContext().getResources(), R.raw.default_avatar);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(15370);
                    }
                }
            }
        }
        Bitmap bitmap = this.cdX;
        AppMethodBeat.o(15370);
        return bitmap;
    }

    public final Bitmap cR(String str) {
        AppMethodBeat.i(15371);
        if (this.cdY == null) {
            this.cdY = o.acd();
        }
        Bitmap qd = d.qd(str);
        AppMethodBeat.o(15371);
        return qd;
    }

    public final Bitmap b(String str, int i, int i2, int i3) {
        AppMethodBeat.i(15372);
        Bitmap d = b.d(str, i, i2, i3);
        AppMethodBeat.o(15372);
        return d;
    }

    public final Bitmap cQ(String str) {
        AppMethodBeat.i(15369);
        Bitmap a = b.a(str, false, -1);
        AppMethodBeat.o(15369);
        return a;
    }
}
