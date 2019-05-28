package com.tencent.p177mm.plugin.wenote.p587ui.nativenote.p588b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C46457k;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44001c;

/* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.j */
public final class C29998j extends C14790i {
    private ImageView uUR;
    private TextView uUS;

    public C29998j(View view, C46457k c46457k) {
        super(view, c46457k);
        AppMethodBeat.m2504i(27169);
        this.uUB.setVisibility(8);
        this.cAw.setVisibility(8);
        this.gCe.setVisibility(8);
        this.uUB.setOnClickListener(null);
        this.uUR = (ImageView) view.findViewById(2131826406);
        this.uUS = (TextView) view.findViewById(2131826407);
        AppMethodBeat.m2505o(27169);
    }

    /* renamed from: a */
    public final void mo9809a(C44001c c44001c, int i, int i2) {
        AppMethodBeat.m2504i(27170);
        super.mo9809a(c44001c, i, i2);
        if (c44001c.getType() != -4) {
            AppMethodBeat.m2505o(27170);
            return;
        }
        this.uUI.setVisibility(0);
        AppMethodBeat.m2505o(27170);
    }

    public final int dfW() {
        return -4;
    }
}
