package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.acc */
public final class acc extends C1331a {
    public int jCo;
    public String wjQ;
    public long wjR;
    public String wjS;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(63689);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wjQ == null) {
                c6092b = new C6092b("Not all required fields were included: Rid");
                AppMethodBeat.m2505o(63689);
                throw c6092b;
            } else if (this.wjS == null) {
                c6092b = new C6092b("Not all required fields were included: MimeType");
                AppMethodBeat.m2505o(63689);
                throw c6092b;
            } else {
                if (this.wjQ != null) {
                    c6093a.mo13475e(1, this.wjQ);
                }
                c6093a.mo13472ai(2, this.wjR);
                c6093a.mo13480iz(3, this.jCo);
                if (this.wjS != null) {
                    c6093a.mo13475e(4, this.wjS);
                }
                AppMethodBeat.m2505o(63689);
                return 0;
            }
        } else if (i == 1) {
            if (this.wjQ != null) {
                f = C6091a.m9575f(1, this.wjQ) + 0;
            } else {
                f = 0;
            }
            f = (f + C6091a.m9578o(2, this.wjR)) + C6091a.m9572bs(3, this.jCo);
            if (this.wjS != null) {
                f += C6091a.m9575f(4, this.wjS);
            }
            AppMethodBeat.m2505o(63689);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.wjQ == null) {
                c6092b = new C6092b("Not all required fields were included: Rid");
                AppMethodBeat.m2505o(63689);
                throw c6092b;
            } else if (this.wjS == null) {
                c6092b = new C6092b("Not all required fields were included: MimeType");
                AppMethodBeat.m2505o(63689);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(63689);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            acc acc = (acc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    acc.wjQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(63689);
                    return 0;
                case 2:
                    acc.wjR = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(63689);
                    return 0;
                case 3:
                    acc.jCo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(63689);
                    return 0;
                case 4:
                    acc.wjS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(63689);
                    return 0;
                default:
                    AppMethodBeat.m2505o(63689);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(63689);
            return -1;
        }
    }
}
