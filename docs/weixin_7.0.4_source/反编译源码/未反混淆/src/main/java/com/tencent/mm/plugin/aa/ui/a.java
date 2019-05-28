package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.e.n;

public final class a extends n {
    private a gmZ;

    public interface a {
        void aos();
    }

    public a(a aVar) {
        super(2, null);
        this.gmZ = aVar;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(40707);
        if (this.gmZ != null) {
            this.gmZ.aos();
        }
        AppMethodBeat.o(40707);
    }
}
