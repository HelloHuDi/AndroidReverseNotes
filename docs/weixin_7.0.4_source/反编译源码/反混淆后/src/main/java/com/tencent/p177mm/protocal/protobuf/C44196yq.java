package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.yq */
public final class C44196yq extends C1331a {
    public String color;
    public int pLQ;
    public String pLR;
    public String pLS;
    public int pLT;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48840);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.pLQ);
            if (this.pLR != null) {
                c6093a.mo13475e(2, this.pLR);
            }
            if (this.pLS != null) {
                c6093a.mo13475e(3, this.pLS);
            }
            c6093a.mo13480iz(4, this.pLT);
            if (this.color != null) {
                c6093a.mo13475e(5, this.color);
            }
            AppMethodBeat.m2505o(48840);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.pLQ) + 0;
            if (this.pLR != null) {
                bs += C6091a.m9575f(2, this.pLR);
            }
            if (this.pLS != null) {
                bs += C6091a.m9575f(3, this.pLS);
            }
            bs += C6091a.m9572bs(4, this.pLT);
            if (this.color != null) {
                bs += C6091a.m9575f(5, this.color);
            }
            AppMethodBeat.m2505o(48840);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48840);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44196yq c44196yq = (C44196yq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c44196yq.pLQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48840);
                    return 0;
                case 2:
                    c44196yq.pLR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48840);
                    return 0;
                case 3:
                    c44196yq.pLS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48840);
                    return 0;
                case 4:
                    c44196yq.pLT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48840);
                    return 0;
                case 5:
                    c44196yq.color = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48840);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48840);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48840);
            return -1;
        }
    }
}
