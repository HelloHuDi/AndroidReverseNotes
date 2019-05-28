package com.tencent.p177mm.protocal.p1084a.p1085a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.a.a.k */
public final class C23366k extends C1331a {
    public int vzn;
    public LinkedList<C23367l> vzo = new LinkedList();

    public C23366k() {
        AppMethodBeat.m2504i(72829);
        AppMethodBeat.m2505o(72829);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(72830);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.vzn);
            c6093a.mo13474e(2, 8, this.vzo);
            AppMethodBeat.m2505o(72830);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.vzn) + 0) + C6087a.m9552c(2, 8, this.vzo);
            AppMethodBeat.m2505o(72830);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vzo.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(72830);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23366k c23366k = (C23366k) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c23366k.vzn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72830);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23367l c23367l = new C23367l();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c23367l.populateBuilderWithField(c6086a3, c23367l, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23366k.vzo.add(c23367l);
                    }
                    AppMethodBeat.m2505o(72830);
                    return 0;
                default:
                    AppMethodBeat.m2505o(72830);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(72830);
            return -1;
        }
    }
}
