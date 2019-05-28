package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aym */
public final class aym extends C1331a {
    public String jBB;
    public int jBT;
    public String jCH;
    public String pXM;
    public String vXm;
    public String vXn;
    public String wlF;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(73732);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.pXM != null) {
                c6093a.mo13475e(1, this.pXM);
            }
            if (this.jBB != null) {
                c6093a.mo13475e(2, this.jBB);
            }
            c6093a.mo13480iz(3, this.jBT);
            if (this.vXm != null) {
                c6093a.mo13475e(4, this.vXm);
            }
            if (this.vXn != null) {
                c6093a.mo13475e(5, this.vXn);
            }
            if (this.jCH != null) {
                c6093a.mo13475e(6, this.jCH);
            }
            if (this.wlF != null) {
                c6093a.mo13475e(7, this.wlF);
            }
            AppMethodBeat.m2505o(73732);
            return 0;
        } else if (i == 1) {
            if (this.pXM != null) {
                f = C6091a.m9575f(1, this.pXM) + 0;
            } else {
                f = 0;
            }
            if (this.jBB != null) {
                f += C6091a.m9575f(2, this.jBB);
            }
            f += C6091a.m9572bs(3, this.jBT);
            if (this.vXm != null) {
                f += C6091a.m9575f(4, this.vXm);
            }
            if (this.vXn != null) {
                f += C6091a.m9575f(5, this.vXn);
            }
            if (this.jCH != null) {
                f += C6091a.m9575f(6, this.jCH);
            }
            if (this.wlF != null) {
                f += C6091a.m9575f(7, this.wlF);
            }
            AppMethodBeat.m2505o(73732);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(73732);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aym aym = (aym) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aym.pXM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73732);
                    return 0;
                case 2:
                    aym.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73732);
                    return 0;
                case 3:
                    aym.jBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73732);
                    return 0;
                case 4:
                    aym.vXm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73732);
                    return 0;
                case 5:
                    aym.vXn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73732);
                    return 0;
                case 6:
                    aym.jCH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73732);
                    return 0;
                case 7:
                    aym.wlF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73732);
                    return 0;
                default:
                    AppMethodBeat.m2505o(73732);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(73732);
            return -1;
        }
    }
}
