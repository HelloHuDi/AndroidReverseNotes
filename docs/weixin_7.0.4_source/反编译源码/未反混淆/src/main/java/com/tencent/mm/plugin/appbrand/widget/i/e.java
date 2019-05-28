package com.tencent.mm.plugin.appbrand.widget.i;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class e {
    public void a(Bitmap bitmap, d dVar) {
        AppMethodBeat.i(87564);
        if (!(dVar == null || dVar.jpw == null)) {
            dVar.jpw.destroy(dVar.index);
        }
        AppMethodBeat.o(87564);
    }
}
