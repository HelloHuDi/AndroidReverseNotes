package com.tencent.p177mm.plugin.wear.model.p575e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C45379vj;
import com.tencent.p177mm.sdk.p600b.C4879a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wear.model.e.o */
public final class C46930o extends C46394a {
    public final List<Integer> cUA() {
        AppMethodBeat.m2504i(26416);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11028));
        arrayList.add(Integer.valueOf(11027));
        AppMethodBeat.m2505o(26416);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: p */
    public final byte[] mo9572p(int i, byte[] bArr) {
        AppMethodBeat.m2504i(26417);
        switch (i) {
            case 11027:
                C46930o.m89580Gs(1);
                break;
            case 11028:
                C46930o.m89580Gs(2);
                break;
        }
        AppMethodBeat.m2505o(26417);
        return null;
    }

    /* renamed from: Gs */
    private static void m89580Gs(int i) {
        AppMethodBeat.m2504i(26418);
        C45379vj c45379vj = new C45379vj();
        c45379vj.cSr.cuy = i;
        C4879a.xxA.mo10055m(c45379vj);
        AppMethodBeat.m2505o(26418);
    }
}
