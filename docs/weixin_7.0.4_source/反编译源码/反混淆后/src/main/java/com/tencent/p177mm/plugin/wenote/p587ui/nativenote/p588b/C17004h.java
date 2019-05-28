package com.tencent.p177mm.plugin.wenote.p587ui.nativenote.p588b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C46457k;
import com.tencent.p177mm.plugin.wenote.model.p585a.C23178g;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44001c;

/* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.h */
public final class C17004h extends C14790i {
    public C17004h(View view, C46457k c46457k) {
        super(view, c46457k);
        AppMethodBeat.m2504i(27163);
        this.uUB.setVisibility(0);
        this.cAw.setVisibility(8);
        this.gCe.setVisibility(8);
        this.uUB.setTag(this);
        this.uUB.setOnClickListener(this.nij);
        AppMethodBeat.m2505o(27163);
    }

    /* renamed from: a */
    public final void mo9809a(C44001c c44001c, int i, int i2) {
        AppMethodBeat.m2504i(27164);
        this.uUE.setImageResource(C1318a.app_attach_file_icon_location);
        this.uUC.setText(((C23178g) c44001c).eUu);
        this.uUD.setText(((C23178g) c44001c).fBg);
        super.mo9809a(c44001c, i, i2);
        AppMethodBeat.m2505o(27164);
    }

    public final int dfW() {
        return 3;
    }
}
