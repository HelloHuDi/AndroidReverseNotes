package com.tencent.p177mm.plugin.wenote.p587ui.nativenote.p588b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fav.p410ui.C45932c;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C46457k;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44001c;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44002d;

/* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.d */
public final class C44015d extends C14790i {
    public C44015d(View view, C46457k c46457k) {
        super(view, c46457k);
        AppMethodBeat.m2504i(27155);
        this.uUB.setVisibility(0);
        this.cAw.setVisibility(8);
        this.gCe.setVisibility(8);
        this.uUB.setTag(this);
        this.uUB.setOnClickListener(this.nij);
        AppMethodBeat.m2505o(27155);
    }

    /* renamed from: a */
    public final void mo9809a(C44001c c44001c, int i, int i2) {
        AppMethodBeat.m2504i(27156);
        this.uUE.setImageResource(C45932c.m85252LX(((C44002d) c44001c).uOf));
        this.uUC.setText(((C44002d) c44001c).title);
        this.uUD.setText(((C44002d) c44001c).content);
        super.mo9809a(c44001c, i, i2);
        AppMethodBeat.m2505o(27156);
    }

    public final int dfW() {
        return 5;
    }
}
