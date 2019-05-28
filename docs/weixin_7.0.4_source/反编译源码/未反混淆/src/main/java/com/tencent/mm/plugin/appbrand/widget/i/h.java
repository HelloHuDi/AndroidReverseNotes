package com.tencent.mm.plugin.appbrand.widget.i;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.InputStream;

public final class h extends d {
    public h(String str, c cVar, q qVar) {
        super(str, cVar, qVar);
    }

    public final void aSg() {
        AppMethodBeat.i(87569);
        final i runtime = this.hwf.getRuntime();
        if (!(runtime == null || this.jpu == null)) {
            d.h(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(87568);
                    InputStream d = aw.d(runtime, h.this.jpu);
                    Bitmap decodeStream = BitmapFactory.decodeStream(d);
                    if (decodeStream == null) {
                        h.this.jpv.a("Failed to load icon via package path", h.this);
                    } else {
                        h.this.I(decodeStream);
                    }
                    if (d != null) {
                        bo.b(d);
                    }
                    AppMethodBeat.o(87568);
                }
            }, "PackageIconLoader ").start();
        }
        AppMethodBeat.o(87569);
    }
}
