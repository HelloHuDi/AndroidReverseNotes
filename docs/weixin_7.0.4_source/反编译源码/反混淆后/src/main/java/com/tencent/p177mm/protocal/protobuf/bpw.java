package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bpw */
public final class bpw extends C1331a {
    public int Category;
    public int wSb;
    public int wSc;
    public LinkedList<String> wSd = new LinkedList();
    public int wSe;

    public bpw() {
        AppMethodBeat.m2504i(124334);
        AppMethodBeat.m2505o(124334);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124335);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.wSb);
            c6093a.mo13480iz(2, this.wSc);
            c6093a.mo13480iz(3, this.Category);
            c6093a.mo13474e(4, 1, this.wSd);
            c6093a.mo13480iz(5, this.wSe);
            AppMethodBeat.m2505o(124335);
            return 0;
        } else if (i == 1) {
            bs = ((((C6091a.m9572bs(1, this.wSb) + 0) + C6091a.m9572bs(2, this.wSc)) + C6091a.m9572bs(3, this.Category)) + C6087a.m9552c(4, 1, this.wSd)) + C6091a.m9572bs(5, this.wSe);
            AppMethodBeat.m2505o(124335);
            return bs;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wSd.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(124335);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bpw bpw = (bpw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bpw.wSb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124335);
                    return 0;
                case 2:
                    bpw.wSc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124335);
                    return 0;
                case 3:
                    bpw.Category = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124335);
                    return 0;
                case 4:
                    bpw.wSd.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(124335);
                    return 0;
                case 5:
                    bpw.wSe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124335);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124335);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124335);
            return -1;
        }
    }
}
