package com.tencent.p177mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.report.service.a */
public final class C7054a extends C1331a {
    public int jBv;
    public LinkedList<C7055b> pXB = new LinkedList();

    public C7054a() {
        AppMethodBeat.m2504i(72700);
        AppMethodBeat.m2505o(72700);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(72701);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.jBv);
            c6093a.mo13474e(2, 8, this.pXB);
            AppMethodBeat.m2505o(72701);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.jBv) + 0) + C6087a.m9552c(2, 8, this.pXB);
            AppMethodBeat.m2505o(72701);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.pXB.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(72701);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7054a c7054a = (C7054a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c7054a.jBv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72701);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7055b c7055b = new C7055b();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c7055b.populateBuilderWithField(c6086a3, c7055b, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7054a.pXB.add(c7055b);
                    }
                    AppMethodBeat.m2505o(72701);
                    return 0;
                default:
                    AppMethodBeat.m2505o(72701);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(72701);
            return -1;
        }
    }
}
