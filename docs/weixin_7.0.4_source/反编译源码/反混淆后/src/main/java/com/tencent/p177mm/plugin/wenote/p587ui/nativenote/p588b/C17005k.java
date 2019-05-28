package com.tencent.p177mm.plugin.wenote.p587ui.nativenote.p588b;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C46457k;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44001c;

/* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.k */
public final class C17005k extends C14790i {
    private View uUT;

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.k$1 */
    class C170061 implements OnClickListener {
        C170061() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27171);
            C17005k.this.uUA.deJ();
            C17005k.this.uUA.requestFocus();
            AppMethodBeat.m2505o(27171);
        }
    }

    public C17005k(View view, C46457k c46457k) {
        super(view, c46457k);
        AppMethodBeat.m2504i(27172);
        this.uUB.setVisibility(8);
        this.cAw.setVisibility(8);
        this.gCe.setVisibility(8);
        this.uUB.setOnClickListener(null);
        this.uUG.setOnClickListener(new C170061());
        AppMethodBeat.m2505o(27172);
    }

    /* renamed from: a */
    public final void mo9809a(C44001c c44001c, int i, int i2) {
        AppMethodBeat.m2504i(27173);
        super.mo9809a(c44001c, i, i2);
        if (c44001c.getType() != -1) {
            AppMethodBeat.m2505o(27173);
            return;
        }
        LayoutParams layoutParams = (LayoutParams) this.uUH.getLayoutParams();
        layoutParams.bottomMargin = 0;
        layoutParams.topMargin = 0;
        this.uUH.setLayoutParams(layoutParams);
        this.uUG.setVisibility(0);
        this.uUT = this.apJ.findViewById(2131826401);
        AppMethodBeat.m2505o(27173);
    }

    public final int dfW() {
        return -1;
    }
}
