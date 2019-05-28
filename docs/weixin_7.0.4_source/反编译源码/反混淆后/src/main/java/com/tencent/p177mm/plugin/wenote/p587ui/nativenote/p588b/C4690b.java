package com.tencent.p177mm.plugin.wenote.p587ui.nativenote.p588b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C46457k;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44001c;

/* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.b */
public final class C4690b extends C14790i {
    public C4690b(View view, C46457k c46457k) {
        super(view, c46457k);
        AppMethodBeat.m2504i(27149);
        this.uUB.setVisibility(8);
        this.cAw.setVisibility(8);
        this.gCe.setVisibility(8);
        this.uUB.setOnClickListener(null);
        AppMethodBeat.m2505o(27149);
    }

    /* renamed from: a */
    public final void mo9809a(C44001c c44001c, int i, int i2) {
        AppMethodBeat.m2504i(27150);
        super.mo9809a(c44001c, i, i2);
        if (c44001c.getType() != -2) {
            AppMethodBeat.m2505o(27150);
        } else if (this.uSJ.uQI != 3) {
            AppMethodBeat.m2505o(27150);
        } else {
            this.uUJ.setVisibility(0);
            AppMethodBeat.m2505o(27150);
        }
    }

    public final int dfW() {
        return -2;
    }
}
