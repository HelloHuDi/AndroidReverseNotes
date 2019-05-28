package com.tencent.p177mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.storage.am */
public final class C7308am extends C1331a {
    public int xXB;
    public LinkedList<Integer> xXC = new LinkedList();
    public LinkedList<Integer> xXD = new LinkedList();
    public LinkedList<Integer> xXE = new LinkedList();
    public LinkedList<Long> xXF = new LinkedList();
    public LinkedList<Long> xXG = new LinkedList();
    public LinkedList<Long> xXH = new LinkedList();

    public C7308am() {
        AppMethodBeat.m2504i(60134);
        AppMethodBeat.m2505o(60134);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(60135);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.xXB);
            c6093a.mo13474e(2, 2, this.xXC);
            c6093a.mo13474e(3, 2, this.xXD);
            c6093a.mo13474e(4, 2, this.xXE);
            c6093a.mo13474e(5, 3, this.xXF);
            c6093a.mo13474e(6, 3, this.xXG);
            c6093a.mo13474e(7, 3, this.xXH);
            AppMethodBeat.m2505o(60135);
            return 0;
        } else if (i == 1) {
            bs = ((((((C6091a.m9572bs(1, this.xXB) + 0) + C6087a.m9552c(2, 2, this.xXC)) + C6087a.m9552c(3, 2, this.xXD)) + C6087a.m9552c(4, 2, this.xXE)) + C6087a.m9552c(5, 3, this.xXF)) + C6087a.m9552c(6, 3, this.xXG)) + C6087a.m9552c(7, 3, this.xXH);
            AppMethodBeat.m2505o(60135);
            return bs;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.xXC.clear();
            this.xXD.clear();
            this.xXE.clear();
            this.xXF.clear();
            this.xXG.clear();
            this.xXH.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(60135);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7308am c7308am = (C7308am) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c7308am.xXB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60135);
                    return 0;
                case 2:
                    c7308am.xXC.add(Integer.valueOf(c6086a2.BTU.mo13458vd()));
                    AppMethodBeat.m2505o(60135);
                    return 0;
                case 3:
                    c7308am.xXD.add(Integer.valueOf(c6086a2.BTU.mo13458vd()));
                    AppMethodBeat.m2505o(60135);
                    return 0;
                case 4:
                    c7308am.xXE.add(Integer.valueOf(c6086a2.BTU.mo13458vd()));
                    AppMethodBeat.m2505o(60135);
                    return 0;
                case 5:
                    c7308am.xXF.add(Long.valueOf(c6086a2.BTU.mo13459ve()));
                    AppMethodBeat.m2505o(60135);
                    return 0;
                case 6:
                    c7308am.xXG.add(Long.valueOf(c6086a2.BTU.mo13459ve()));
                    AppMethodBeat.m2505o(60135);
                    return 0;
                case 7:
                    c7308am.xXH.add(Long.valueOf(c6086a2.BTU.mo13459ve()));
                    AppMethodBeat.m2505o(60135);
                    return 0;
                default:
                    AppMethodBeat.m2505o(60135);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(60135);
            return -1;
        }
    }
}
