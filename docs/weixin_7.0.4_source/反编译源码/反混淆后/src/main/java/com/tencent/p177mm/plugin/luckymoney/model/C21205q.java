package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.q */
public final class C21205q extends C1331a {
    public int mLA;
    public int nXH;
    public long nXI;
    public int nXJ;
    public long nXK;
    public int nXa;
    public LinkedList<C21206r> nXj = new LinkedList();

    public C21205q() {
        AppMethodBeat.m2504i(56612);
        AppMethodBeat.m2505o(56612);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56613);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.nXH);
            c6093a.mo13472ai(2, this.nXI);
            c6093a.mo13480iz(3, this.nXJ);
            c6093a.mo13472ai(4, this.nXK);
            c6093a.mo13480iz(5, this.mLA);
            c6093a.mo13480iz(6, this.nXa);
            c6093a.mo13474e(7, 8, this.nXj);
            AppMethodBeat.m2505o(56613);
            return 0;
        } else if (i == 1) {
            bs = ((((((C6091a.m9572bs(1, this.nXH) + 0) + C6091a.m9578o(2, this.nXI)) + C6091a.m9572bs(3, this.nXJ)) + C6091a.m9578o(4, this.nXK)) + C6091a.m9572bs(5, this.mLA)) + C6091a.m9572bs(6, this.nXa)) + C6087a.m9552c(7, 8, this.nXj);
            AppMethodBeat.m2505o(56613);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nXj.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56613);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C21205q c21205q = (C21205q) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c21205q.nXH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56613);
                    return 0;
                case 2:
                    c21205q.nXI = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56613);
                    return 0;
                case 3:
                    c21205q.nXJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56613);
                    return 0;
                case 4:
                    c21205q.nXK = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56613);
                    return 0;
                case 5:
                    c21205q.mLA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56613);
                    return 0;
                case 6:
                    c21205q.nXa = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56613);
                    return 0;
                case 7:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C21206r c21206r = new C21206r();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c21206r.populateBuilderWithField(c6086a3, c21206r, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c21205q.nXj.add(c21206r);
                    }
                    AppMethodBeat.m2505o(56613);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56613);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56613);
            return -1;
        }
    }
}
