package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.e.n;

public final class a extends n {
    private a thT;

    public interface a {
        void aos();
    }

    public a(a aVar) {
        super(2, null);
        this.thT = aVar;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(45498);
        if (this.thT != null) {
            this.thT.aos();
        }
        AppMethodBeat.o(45498);
    }
}
