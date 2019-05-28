package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.qf */
public final class C7281qf extends C1331a {
    public String jBB;
    public String jCH;
    public String vXl;
    public String vXm;
    public String vXn;
    public int vXo;
    public String vXp;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(60027);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.jBB != null) {
                c6093a.mo13475e(1, this.jBB);
            }
            if (this.jCH != null) {
                c6093a.mo13475e(2, this.jCH);
            }
            if (this.vXl != null) {
                c6093a.mo13475e(3, this.vXl);
            }
            if (this.vXm != null) {
                c6093a.mo13475e(4, this.vXm);
            }
            if (this.vXn != null) {
                c6093a.mo13475e(5, this.vXn);
            }
            c6093a.mo13480iz(6, this.vXo);
            if (this.vXp != null) {
                c6093a.mo13475e(7, this.vXp);
            }
            AppMethodBeat.m2505o(60027);
            return 0;
        } else if (i == 1) {
            if (this.jBB != null) {
                f = C6091a.m9575f(1, this.jBB) + 0;
            } else {
                f = 0;
            }
            if (this.jCH != null) {
                f += C6091a.m9575f(2, this.jCH);
            }
            if (this.vXl != null) {
                f += C6091a.m9575f(3, this.vXl);
            }
            if (this.vXm != null) {
                f += C6091a.m9575f(4, this.vXm);
            }
            if (this.vXn != null) {
                f += C6091a.m9575f(5, this.vXn);
            }
            f += C6091a.m9572bs(6, this.vXo);
            if (this.vXp != null) {
                f += C6091a.m9575f(7, this.vXp);
            }
            AppMethodBeat.m2505o(60027);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(60027);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7281qf c7281qf = (C7281qf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c7281qf.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60027);
                    return 0;
                case 2:
                    c7281qf.jCH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60027);
                    return 0;
                case 3:
                    c7281qf.vXl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60027);
                    return 0;
                case 4:
                    c7281qf.vXm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60027);
                    return 0;
                case 5:
                    c7281qf.vXn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60027);
                    return 0;
                case 6:
                    c7281qf.vXo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60027);
                    return 0;
                case 7:
                    c7281qf.vXp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60027);
                    return 0;
                default:
                    AppMethodBeat.m2505o(60027);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(60027);
            return -1;
        }
    }
}
