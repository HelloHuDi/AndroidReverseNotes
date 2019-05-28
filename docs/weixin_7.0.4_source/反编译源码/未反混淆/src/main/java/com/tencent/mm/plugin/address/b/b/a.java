package com.tencent.mm.plugin.address.b.b;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;

public final class a implements f {
    private HashSet<m> gIG;
    private HashSet<m> gIH;
    private Dialog gII;

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(16721);
        if (this.gIH.contains(mVar)) {
            this.gIH.remove(mVar);
            ab.d("MicroMsg.InvoiceNetSceneMgr", "has find scene ");
        } else if (this.gIG.contains(mVar)) {
            this.gIG.remove(mVar);
            ab.d("MicroMsg.InvoiceNetSceneMgr", "has find forcescenes ");
        }
        if (this.gIH.isEmpty() && this.gIG.isEmpty() && this.gII != null) {
            this.gII.dismiss();
            this.gII = null;
        }
        AppMethodBeat.o(16721);
    }
}
