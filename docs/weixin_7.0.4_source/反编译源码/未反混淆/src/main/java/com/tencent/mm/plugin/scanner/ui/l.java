package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Point;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.k;

public final class l extends c {
    public l(b bVar, Point point, DisplayMetrics displayMetrics, int i) {
        super(bVar, point, displayMetrics, i);
    }

    /* Access modifiers changed, original: protected|final */
    public final float cgK() {
        return 1.467f;
    }

    /* Access modifiers changed, original: protected|final */
    public final String cgL() {
        return "driving";
    }

    /* Access modifiers changed, original: protected|final */
    public final int cgM() {
        return R.string.dxh;
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.plugin.scanner.util.b a(a aVar) {
        AppMethodBeat.i(81182);
        k kVar = new k(aVar, 2);
        AppMethodBeat.o(81182);
        return kVar;
    }
}
