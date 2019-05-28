package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.axb */
public final class axb extends C1331a {
    public String vOA;
    public String vOB;
    public String vOC;
    public String vOD;
    public String vOz;
    public int wBk;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(70482);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vOz != null) {
                c6093a.mo13475e(1, this.vOz);
            }
            if (this.vOA != null) {
                c6093a.mo13475e(2, this.vOA);
            }
            if (this.vOB != null) {
                c6093a.mo13475e(3, this.vOB);
            }
            if (this.vOC != null) {
                c6093a.mo13475e(4, this.vOC);
            }
            if (this.vOD != null) {
                c6093a.mo13475e(5, this.vOD);
            }
            c6093a.mo13480iz(6, this.wBk);
            AppMethodBeat.m2505o(70482);
            return 0;
        } else if (i == 1) {
            if (this.vOz != null) {
                f = C6091a.m9575f(1, this.vOz) + 0;
            } else {
                f = 0;
            }
            if (this.vOA != null) {
                f += C6091a.m9575f(2, this.vOA);
            }
            if (this.vOB != null) {
                f += C6091a.m9575f(3, this.vOB);
            }
            if (this.vOC != null) {
                f += C6091a.m9575f(4, this.vOC);
            }
            if (this.vOD != null) {
                f += C6091a.m9575f(5, this.vOD);
            }
            int bs = f + C6091a.m9572bs(6, this.wBk);
            AppMethodBeat.m2505o(70482);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(70482);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            axb axb = (axb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axb.vOz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(70482);
                    return 0;
                case 2:
                    axb.vOA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(70482);
                    return 0;
                case 3:
                    axb.vOB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(70482);
                    return 0;
                case 4:
                    axb.vOC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(70482);
                    return 0;
                case 5:
                    axb.vOD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(70482);
                    return 0;
                case 6:
                    axb.wBk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(70482);
                    return 0;
                default:
                    AppMethodBeat.m2505o(70482);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(70482);
            return -1;
        }
    }
}
