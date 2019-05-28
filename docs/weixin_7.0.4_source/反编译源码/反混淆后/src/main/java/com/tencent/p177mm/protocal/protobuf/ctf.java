package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ctf */
public final class ctf extends C1331a {
    public String jBF;
    public String vIk;
    public String vOA;
    public String vOB;
    public String vOC;
    public String vOz;
    public String xqm;
    public String xqn;
    public String xqo;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(55729);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vIk != null) {
                c6093a.mo13475e(1, this.vIk);
            }
            if (this.vOA != null) {
                c6093a.mo13475e(2, this.vOA);
            }
            if (this.vOz != null) {
                c6093a.mo13475e(3, this.vOz);
            }
            if (this.jBF != null) {
                c6093a.mo13475e(4, this.jBF);
            }
            if (this.xqm != null) {
                c6093a.mo13475e(5, this.xqm);
            }
            if (this.vOB != null) {
                c6093a.mo13475e(6, this.vOB);
            }
            if (this.vOC != null) {
                c6093a.mo13475e(7, this.vOC);
            }
            if (this.xqn != null) {
                c6093a.mo13475e(8, this.xqn);
            }
            if (this.xqo != null) {
                c6093a.mo13475e(9, this.xqo);
            }
            AppMethodBeat.m2505o(55729);
            return 0;
        } else if (i == 1) {
            if (this.vIk != null) {
                f = C6091a.m9575f(1, this.vIk) + 0;
            } else {
                f = 0;
            }
            if (this.vOA != null) {
                f += C6091a.m9575f(2, this.vOA);
            }
            if (this.vOz != null) {
                f += C6091a.m9575f(3, this.vOz);
            }
            if (this.jBF != null) {
                f += C6091a.m9575f(4, this.jBF);
            }
            if (this.xqm != null) {
                f += C6091a.m9575f(5, this.xqm);
            }
            if (this.vOB != null) {
                f += C6091a.m9575f(6, this.vOB);
            }
            if (this.vOC != null) {
                f += C6091a.m9575f(7, this.vOC);
            }
            if (this.xqn != null) {
                f += C6091a.m9575f(8, this.xqn);
            }
            if (this.xqo != null) {
                f += C6091a.m9575f(9, this.xqo);
            }
            AppMethodBeat.m2505o(55729);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(55729);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ctf ctf = (ctf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ctf.vIk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55729);
                    return 0;
                case 2:
                    ctf.vOA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55729);
                    return 0;
                case 3:
                    ctf.vOz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55729);
                    return 0;
                case 4:
                    ctf.jBF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55729);
                    return 0;
                case 5:
                    ctf.xqm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55729);
                    return 0;
                case 6:
                    ctf.vOB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55729);
                    return 0;
                case 7:
                    ctf.vOC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55729);
                    return 0;
                case 8:
                    ctf.xqn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55729);
                    return 0;
                case 9:
                    ctf.xqo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55729);
                    return 0;
                default:
                    AppMethodBeat.m2505o(55729);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(55729);
            return -1;
        }
    }
}
