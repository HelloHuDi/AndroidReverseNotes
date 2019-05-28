package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.rj */
public final class C46582rj extends C1331a {
    public int Scene;
    public int jCt;
    public String nqc;
    public String vYA;
    public String vYB;
    public String vYC;
    public String vYD;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(50527);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.Scene);
            c6093a.mo13480iz(2, this.jCt);
            if (this.vYA != null) {
                c6093a.mo13475e(3, this.vYA);
            }
            if (this.vYB != null) {
                c6093a.mo13475e(4, this.vYB);
            }
            if (this.nqc != null) {
                c6093a.mo13475e(5, this.nqc);
            }
            if (this.vYC != null) {
                c6093a.mo13475e(6, this.vYC);
            }
            if (this.vYD != null) {
                c6093a.mo13475e(7, this.vYD);
            }
            AppMethodBeat.m2505o(50527);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.Scene) + 0) + C6091a.m9572bs(2, this.jCt);
            if (this.vYA != null) {
                bs += C6091a.m9575f(3, this.vYA);
            }
            if (this.vYB != null) {
                bs += C6091a.m9575f(4, this.vYB);
            }
            if (this.nqc != null) {
                bs += C6091a.m9575f(5, this.nqc);
            }
            if (this.vYC != null) {
                bs += C6091a.m9575f(6, this.vYC);
            }
            if (this.vYD != null) {
                bs += C6091a.m9575f(7, this.vYD);
            }
            AppMethodBeat.m2505o(50527);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(50527);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46582rj c46582rj = (C46582rj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c46582rj.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(50527);
                    return 0;
                case 2:
                    c46582rj.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(50527);
                    return 0;
                case 3:
                    c46582rj.vYA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(50527);
                    return 0;
                case 4:
                    c46582rj.vYB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(50527);
                    return 0;
                case 5:
                    c46582rj.nqc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(50527);
                    return 0;
                case 6:
                    c46582rj.vYC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(50527);
                    return 0;
                case 7:
                    c46582rj.vYD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(50527);
                    return 0;
                default:
                    AppMethodBeat.m2505o(50527);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(50527);
            return -1;
        }
    }
}
