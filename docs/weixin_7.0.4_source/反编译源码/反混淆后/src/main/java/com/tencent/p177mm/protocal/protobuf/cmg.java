package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cmg */
public final class cmg extends C1331a {
    public String guS;
    public String jBB;
    public String jCH;
    public String vEA;
    public String wbw;
    public String xkl;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124372);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.jBB == null) {
                c6092b = new C6092b("Not all required fields were included: UserName");
                AppMethodBeat.m2505o(124372);
                throw c6092b;
            } else if (this.xkl == null) {
                c6092b = new C6092b("Not all required fields were included: MatchWord");
                AppMethodBeat.m2505o(124372);
                throw c6092b;
            } else {
                if (this.jBB != null) {
                    c6093a.mo13475e(1, this.jBB);
                }
                if (this.xkl != null) {
                    c6093a.mo13475e(2, this.xkl);
                }
                if (this.jCH != null) {
                    c6093a.mo13475e(3, this.jCH);
                }
                if (this.wbw != null) {
                    c6093a.mo13475e(4, this.wbw);
                }
                if (this.guS != null) {
                    c6093a.mo13475e(5, this.guS);
                }
                if (this.vEA != null) {
                    c6093a.mo13475e(6, this.vEA);
                }
                AppMethodBeat.m2505o(124372);
                return 0;
            }
        } else if (i == 1) {
            if (this.jBB != null) {
                f = C6091a.m9575f(1, this.jBB) + 0;
            } else {
                f = 0;
            }
            if (this.xkl != null) {
                f += C6091a.m9575f(2, this.xkl);
            }
            if (this.jCH != null) {
                f += C6091a.m9575f(3, this.jCH);
            }
            if (this.wbw != null) {
                f += C6091a.m9575f(4, this.wbw);
            }
            if (this.guS != null) {
                f += C6091a.m9575f(5, this.guS);
            }
            if (this.vEA != null) {
                f += C6091a.m9575f(6, this.vEA);
            }
            AppMethodBeat.m2505o(124372);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.jBB == null) {
                c6092b = new C6092b("Not all required fields were included: UserName");
                AppMethodBeat.m2505o(124372);
                throw c6092b;
            } else if (this.xkl == null) {
                c6092b = new C6092b("Not all required fields were included: MatchWord");
                AppMethodBeat.m2505o(124372);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(124372);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cmg cmg = (cmg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cmg.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124372);
                    return 0;
                case 2:
                    cmg.xkl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124372);
                    return 0;
                case 3:
                    cmg.jCH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124372);
                    return 0;
                case 4:
                    cmg.wbw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124372);
                    return 0;
                case 5:
                    cmg.guS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124372);
                    return 0;
                case 6:
                    cmg.vEA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124372);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124372);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124372);
            return -1;
        }
    }
}
