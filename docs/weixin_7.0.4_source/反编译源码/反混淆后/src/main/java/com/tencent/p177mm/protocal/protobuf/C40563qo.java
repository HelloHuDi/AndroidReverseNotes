package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.qo */
public final class C40563qo extends C1331a {
    public String vXB;
    public String vXC;
    public String vXD;
    public int vXE;
    public int vXF;
    public String vXG;
    public int vXH;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51377);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vXB != null) {
                c6093a.mo13475e(1, this.vXB);
            }
            if (this.vXC != null) {
                c6093a.mo13475e(2, this.vXC);
            }
            if (this.vXD != null) {
                c6093a.mo13475e(3, this.vXD);
            }
            c6093a.mo13480iz(4, this.vXE);
            c6093a.mo13480iz(5, this.vXF);
            if (this.vXG != null) {
                c6093a.mo13475e(6, this.vXG);
            }
            c6093a.mo13480iz(7, this.vXH);
            AppMethodBeat.m2505o(51377);
            return 0;
        } else if (i == 1) {
            if (this.vXB != null) {
                f = C6091a.m9575f(1, this.vXB) + 0;
            } else {
                f = 0;
            }
            if (this.vXC != null) {
                f += C6091a.m9575f(2, this.vXC);
            }
            if (this.vXD != null) {
                f += C6091a.m9575f(3, this.vXD);
            }
            f = (f + C6091a.m9572bs(4, this.vXE)) + C6091a.m9572bs(5, this.vXF);
            if (this.vXG != null) {
                f += C6091a.m9575f(6, this.vXG);
            }
            int bs = f + C6091a.m9572bs(7, this.vXH);
            AppMethodBeat.m2505o(51377);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(51377);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40563qo c40563qo = (C40563qo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c40563qo.vXB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51377);
                    return 0;
                case 2:
                    c40563qo.vXC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51377);
                    return 0;
                case 3:
                    c40563qo.vXD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51377);
                    return 0;
                case 4:
                    c40563qo.vXE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51377);
                    return 0;
                case 5:
                    c40563qo.vXF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51377);
                    return 0;
                case 6:
                    c40563qo.vXG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51377);
                    return 0;
                case 7:
                    c40563qo.vXH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51377);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51377);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51377);
            return -1;
        }
    }
}
