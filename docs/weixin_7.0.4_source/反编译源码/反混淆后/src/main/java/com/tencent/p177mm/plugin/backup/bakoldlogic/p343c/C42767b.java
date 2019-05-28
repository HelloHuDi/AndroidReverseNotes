package com.tencent.p177mm.plugin.backup.bakoldlogic.p343c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.backup.p920g.C19978b;
import com.tencent.p177mm.plugin.backup.p921i.C33707ac;
import com.tencent.p177mm.plugin.backup.p921i.C38659ab;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.c.b */
public final class C42767b extends C19978b {
    private C38659ab jAg = new C38659ab();
    private C33707ac jAh = new C33707ac();

    public C42767b(int i) {
        AppMethodBeat.m2504i(17881);
        this.jAg.jBh = i;
        AppMethodBeat.m2505o(17881);
    }

    public final C1331a aTS() {
        return this.jAh;
    }

    public final C1331a aTT() {
        return this.jAg;
    }

    /* renamed from: rw */
    public final void mo6711rw(int i) {
        AppMethodBeat.m2504i(17882);
        if (this.jAh.jBT == 0) {
            mo35227l(0, 0, "ok");
            AppMethodBeat.m2505o(17882);
            return;
        }
        C4990ab.m7413e("MicroMsg.BakSceneCommand", " type:%d  errCode:%d", Integer.valueOf(this.jAg.jBh), Integer.valueOf(this.jAh.jBT));
        mo35227l(4, this.jAh.jBT, "fail");
        AppMethodBeat.m2505o(17882);
    }

    public final int getType() {
        return 3;
    }
}
