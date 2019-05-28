package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.c;

public final class k extends i {
    private View uUT;

    public k(View view, com.tencent.mm.plugin.wenote.model.nativenote.manager.k kVar) {
        super(view, kVar);
        AppMethodBeat.i(27172);
        this.uUB.setVisibility(8);
        this.cAw.setVisibility(8);
        this.gCe.setVisibility(8);
        this.uUB.setOnClickListener(null);
        this.uUG.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(27171);
                k.this.uUA.deJ();
                k.this.uUA.requestFocus();
                AppMethodBeat.o(27171);
            }
        });
        AppMethodBeat.o(27172);
    }

    public final void a(c cVar, int i, int i2) {
        AppMethodBeat.i(27173);
        super.a(cVar, i, i2);
        if (cVar.getType() != -1) {
            AppMethodBeat.o(27173);
            return;
        }
        LayoutParams layoutParams = (LayoutParams) this.uUH.getLayoutParams();
        layoutParams.bottomMargin = 0;
        layoutParams.topMargin = 0;
        this.uUH.setLayoutParams(layoutParams);
        this.uUG.setVisibility(0);
        this.uUT = this.apJ.findViewById(R.id.djb);
        AppMethodBeat.o(27173);
    }

    public final int dfW() {
        return -1;
    }
}
