package com.tencent.mm.plugin.appbrand.widget.i;

import android.graphics.Bitmap;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.plugin.appbrand.l.a;
import com.tencent.mm.plugin.appbrand.l.j;
import com.tencent.mm.plugin.appbrand.q;

public final class g extends d {
    public g(String str, c cVar, q qVar) {
        super(str, cVar, qVar);
    }

    public final void aSg() {
        Object obj;
        AppMethodBeat.i(87567);
        String str = this.jpu;
        a aVar = (a) this.hwf.aa(a.class);
        if (!aVar.iof || (j.c(aVar.bQF, str) && URLUtil.isHttpsUrl(str))) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            this.jpv.a("url not in domain list", this);
            AppMethodBeat.o(87567);
            return;
        }
        if (this.jpu != null) {
            b.abR().a(new i() {
                public final void abU() {
                }

                public final void x(Bitmap bitmap) {
                    AppMethodBeat.i(87565);
                    g.this.I(bitmap);
                    AppMethodBeat.o(87565);
                }

                public final void mr() {
                    AppMethodBeat.i(87566);
                    g.this.jpv.a("Failed to load icon via network", g.this);
                    AppMethodBeat.o(87566);
                }

                public final String wP() {
                    return g.this.jpu;
                }
            }, this.jpu, null);
        }
        AppMethodBeat.o(87567);
    }
}
