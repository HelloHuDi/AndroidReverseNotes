package com.tencent.p177mm.plugin.p398f.p399c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.p398f.C45913b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.plugin.f.c.a */
public final class C45914a implements Runnable {
    private C7620bi csG;
    private int opType;

    public C45914a(C7620bi c7620bi, int i) {
        AppMethodBeat.m2504i(18641);
        this.csG = c7620bi;
        this.opType = i;
        C4990ab.m7411d("MicroMsg.MsgEventTask", "%d msg id[%d %d] optype[%d]", Integer.valueOf(hashCode()), Long.valueOf(this.csG.field_msgId), Integer.valueOf(this.csG.getType()), Integer.valueOf(this.opType));
        AppMethodBeat.m2505o(18641);
    }

    public final void run() {
        AppMethodBeat.m2504i(18642);
        switch (this.opType) {
            case 1:
                C45913b.aZc().mo73748O(this.csG);
                AppMethodBeat.m2505o(18642);
                return;
            default:
                C4990ab.m7421w("MicroMsg.MsgEventTask", "%d unknow op type [%d]", Integer.valueOf(hashCode()), Integer.valueOf(this.opType));
                AppMethodBeat.m2505o(18642);
                return;
        }
    }
}
