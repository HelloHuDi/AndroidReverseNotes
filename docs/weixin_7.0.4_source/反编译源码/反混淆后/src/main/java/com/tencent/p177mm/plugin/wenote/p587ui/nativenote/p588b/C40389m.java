package com.tencent.p177mm.plugin.wenote.p587ui.nativenote.p588b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C46457k;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44001c;
import com.tencent.p177mm.plugin.wenote.model.p585a.C46451j;

/* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.m */
public final class C40389m extends C14790i {
    public C40389m(View view, C46457k c46457k) {
        super(view, c46457k);
        AppMethodBeat.m2504i(27180);
        this.uUB.setVisibility(0);
        this.cAw.setVisibility(8);
        this.gCe.setVisibility(8);
        this.uUB.setTag(this);
        this.uUB.setOnClickListener(this.nij);
        AppMethodBeat.m2505o(27180);
    }

    /* renamed from: a */
    public final void mo9809a(C44001c c44001c, int i, int i2) {
        AppMethodBeat.m2504i(27181);
        this.uUE.setImageResource(C1318a.msg_state_fail_resend);
        this.uUC.setText(((C46451j) c44001c).title);
        this.uUD.setText(((C46451j) c44001c).content);
        super.mo9809a(c44001c, i, i2);
        AppMethodBeat.m2505o(27181);
    }

    public final int dfW() {
        return 0;
    }
}
