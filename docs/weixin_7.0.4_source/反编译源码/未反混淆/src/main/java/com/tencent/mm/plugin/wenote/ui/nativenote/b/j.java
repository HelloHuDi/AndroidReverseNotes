package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class j extends i {
    private ImageView uUR;
    private TextView uUS;

    public j(View view, k kVar) {
        super(view, kVar);
        AppMethodBeat.i(27169);
        this.uUB.setVisibility(8);
        this.cAw.setVisibility(8);
        this.gCe.setVisibility(8);
        this.uUB.setOnClickListener(null);
        this.uUR = (ImageView) view.findViewById(R.id.djg);
        this.uUS = (TextView) view.findViewById(R.id.djh);
        AppMethodBeat.o(27169);
    }

    public final void a(c cVar, int i, int i2) {
        AppMethodBeat.i(27170);
        super.a(cVar, i, i2);
        if (cVar.getType() != -4) {
            AppMethodBeat.o(27170);
            return;
        }
        this.uUI.setVisibility(0);
        AppMethodBeat.o(27170);
    }

    public final int dfW() {
        return -4;
    }
}
