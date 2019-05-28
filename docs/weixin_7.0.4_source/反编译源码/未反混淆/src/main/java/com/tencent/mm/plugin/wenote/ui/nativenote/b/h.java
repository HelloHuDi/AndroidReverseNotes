package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.g;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class h extends i {
    public h(View view, k kVar) {
        super(view, kVar);
        AppMethodBeat.i(27163);
        this.uUB.setVisibility(0);
        this.cAw.setVisibility(8);
        this.gCe.setVisibility(8);
        this.uUB.setTag(this);
        this.uUB.setOnClickListener(this.nij);
        AppMethodBeat.o(27163);
    }

    public final void a(c cVar, int i, int i2) {
        AppMethodBeat.i(27164);
        this.uUE.setImageResource(R.raw.app_attach_file_icon_location);
        this.uUC.setText(((g) cVar).eUu);
        this.uUD.setText(((g) cVar).fBg);
        super.a(cVar, i, i2);
        AppMethodBeat.o(27164);
    }

    public final int dfW() {
        return 3;
    }
}
