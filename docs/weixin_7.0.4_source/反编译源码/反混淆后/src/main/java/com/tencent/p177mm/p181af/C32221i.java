package com.tencent.p177mm.p181af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Map;

/* renamed from: com.tencent.mm.af.i */
public class C32221i extends C37435f {
    public int fgg = 0;

    /* renamed from: Xz */
    public final C37435f mo20330Xz() {
        AppMethodBeat.m2504i(16196);
        C32221i c32221i = new C32221i();
        AppMethodBeat.m2505o(16196);
        return c32221i;
    }

    /* renamed from: a */
    public final void mo20331a(StringBuilder stringBuilder, C8910b c8910b, String str, C9545d c9545d, int i, int i2) {
    }

    /* renamed from: a */
    public final void mo20332a(Map<String, String> map, C8910b c8910b) {
        AppMethodBeat.m2504i(16197);
        if (c8910b.type == 2000) {
            this.fgg = 0;
            C4990ab.m7417i("MicroMsg.AppContentTransferMsgPiece", "hasTransferAddress: %s", Integer.valueOf(this.fgg));
        }
        AppMethodBeat.m2505o(16197);
    }
}
