package com.tencent.p177mm.plugin.address.p718b.p719b;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.address.b.b.a */
public final class C6736a implements C1202f {
    private HashSet<C1207m> gIG;
    private HashSet<C1207m> gIH;
    private Dialog gII;

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(16721);
        if (this.gIH.contains(c1207m)) {
            this.gIH.remove(c1207m);
            C4990ab.m7410d("MicroMsg.InvoiceNetSceneMgr", "has find scene ");
        } else if (this.gIG.contains(c1207m)) {
            this.gIG.remove(c1207m);
            C4990ab.m7410d("MicroMsg.InvoiceNetSceneMgr", "has find forcescenes ");
        }
        if (this.gIH.isEmpty() && this.gIG.isEmpty() && this.gII != null) {
            this.gII.dismiss();
            this.gII = null;
        }
        AppMethodBeat.m2505o(16721);
    }
}
