package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class m extends i {
    public m(View view, k kVar) {
        super(view, kVar);
        AppMethodBeat.i(27180);
        this.uUB.setVisibility(0);
        this.cAw.setVisibility(8);
        this.gCe.setVisibility(8);
        this.uUB.setTag(this);
        this.uUB.setOnClickListener(this.nij);
        AppMethodBeat.o(27180);
    }

    public final void a(c cVar, int i, int i2) {
        AppMethodBeat.i(27181);
        this.uUE.setImageResource(R.raw.msg_state_fail_resend);
        this.uUC.setText(((j) cVar).title);
        this.uUD.setText(((j) cVar).content);
        super.a(cVar, i, i2);
        AppMethodBeat.o(27181);
    }

    public final int dfW() {
        return 0;
    }
}
