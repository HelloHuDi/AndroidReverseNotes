package com.tencent.mm.plugin.appbrand.widget.i;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.g.d;
import java.io.File;

public final class i extends d {
    public i(String str, c cVar, q qVar) {
        super(str, cVar, qVar);
    }

    public final void aSg() {
        AppMethodBeat.i(87571);
        if (this.hwf.asE() == null || this.jpu == null) {
            this.jpv.a("Failed to load icon via temp file", this);
            AppMethodBeat.o(87571);
            return;
        }
        d.h(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87570);
                File yg = i.this.hwf.asE().yg(i.this.jpu);
                if (yg == null) {
                    i.this.jpv.a("Failed to load icon via temp file", i.this);
                    AppMethodBeat.o(87570);
                    return;
                }
                Bitmap decodeFile = BitmapFactory.decodeFile(yg.getPath());
                if (decodeFile != null) {
                    i.this.I(decodeFile);
                    AppMethodBeat.o(87570);
                    return;
                }
                i.this.jpv.a("Failed to load icon via temp file", i.this);
                AppMethodBeat.o(87570);
            }
        }, "TempFileIconLoader").start();
        AppMethodBeat.o(87571);
    }
}
