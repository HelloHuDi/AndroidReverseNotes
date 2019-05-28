package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Point;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.k;

public class m extends c {
    public m(b bVar, Point point, DisplayMetrics displayMetrics, int i) {
        super(bVar, point, displayMetrics, i);
    }

    /* Access modifiers changed, original: protected|final */
    public final float cgK() {
        return 1.586f;
    }

    /* Access modifiers changed, original: protected|final */
    public final String cgL() {
        return "identity";
    }

    /* Access modifiers changed, original: protected|final */
    public final int cgM() {
        return R.string.dxi;
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.plugin.scanner.util.b a(a aVar) {
        AppMethodBeat.i(81183);
        k kVar = new k(aVar, 1);
        AppMethodBeat.o(81183);
        return kVar;
    }
}
