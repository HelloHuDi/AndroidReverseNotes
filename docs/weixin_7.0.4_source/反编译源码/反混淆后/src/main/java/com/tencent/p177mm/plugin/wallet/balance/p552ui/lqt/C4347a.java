package com.tencent.p177mm.plugin.wallet.balance.p552ui.lqt;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C23322n;

/* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.a */
public final class C4347a extends C23322n {
    private C4348a thT;

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.a$a */
    public interface C4348a {
        void aos();
    }

    public C4347a(C4348a c4348a) {
        super(2, null);
        this.thT = c4348a;
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(45498);
        if (this.thT != null) {
            this.thT.aos();
        }
        AppMethodBeat.m2505o(45498);
    }
}
