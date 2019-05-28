package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class b extends i {
    public b(View view, k kVar) {
        super(view, kVar);
        AppMethodBeat.i(27149);
        this.uUB.setVisibility(8);
        this.cAw.setVisibility(8);
        this.gCe.setVisibility(8);
        this.uUB.setOnClickListener(null);
        AppMethodBeat.o(27149);
    }

    public final void a(c cVar, int i, int i2) {
        AppMethodBeat.i(27150);
        super.a(cVar, i, i2);
        if (cVar.getType() != -2) {
            AppMethodBeat.o(27150);
        } else if (this.uSJ.uQI != 3) {
            AppMethodBeat.o(27150);
        } else {
            this.uUJ.setVisibility(0);
            AppMethodBeat.o(27150);
        }
    }

    public final int dfW() {
        return -2;
    }
}
