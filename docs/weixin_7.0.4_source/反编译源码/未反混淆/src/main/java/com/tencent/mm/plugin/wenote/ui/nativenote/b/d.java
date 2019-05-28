package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class d extends i {
    public d(View view, k kVar) {
        super(view, kVar);
        AppMethodBeat.i(27155);
        this.uUB.setVisibility(0);
        this.cAw.setVisibility(8);
        this.gCe.setVisibility(8);
        this.uUB.setTag(this);
        this.uUB.setOnClickListener(this.nij);
        AppMethodBeat.o(27155);
    }

    public final void a(c cVar, int i, int i2) {
        AppMethodBeat.i(27156);
        this.uUE.setImageResource(com.tencent.mm.plugin.fav.ui.c.LX(((com.tencent.mm.plugin.wenote.model.a.d) cVar).uOf));
        this.uUC.setText(((com.tencent.mm.plugin.wenote.model.a.d) cVar).title);
        this.uUD.setText(((com.tencent.mm.plugin.wenote.model.a.d) cVar).content);
        super.a(cVar, i, i2);
        AppMethodBeat.o(27156);
    }

    public final int dfW() {
        return 5;
    }
}
