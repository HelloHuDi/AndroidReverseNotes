package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aw */
public final class C15319aw extends C1331a {
    public String duc;
    public String dud;
    public double latitude;
    public double longitude;
    public long vCE;
    public String vCF;
    public String vCG;
    public String vCH;
    public String vCI;
    public String vCJ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56697);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.duc != null) {
                c6093a.mo13475e(1, this.duc);
            }
            if (this.dud != null) {
                c6093a.mo13475e(2, this.dud);
            }
            c6093a.mo13476f(3, this.latitude);
            c6093a.mo13476f(4, this.longitude);
            c6093a.mo13472ai(5, this.vCE);
            if (this.vCF != null) {
                c6093a.mo13475e(6, this.vCF);
            }
            if (this.vCG != null) {
                c6093a.mo13475e(7, this.vCG);
            }
            if (this.vCH != null) {
                c6093a.mo13475e(8, this.vCH);
            }
            if (this.vCI != null) {
                c6093a.mo13475e(9, this.vCI);
            }
            if (this.vCJ != null) {
                c6093a.mo13475e(10, this.vCJ);
            }
            AppMethodBeat.m2505o(56697);
            return 0;
        } else if (i == 1) {
            if (this.duc != null) {
                f = C6091a.m9575f(1, this.duc) + 0;
            } else {
                f = 0;
            }
            if (this.dud != null) {
                f += C6091a.m9575f(2, this.dud);
            }
            f = ((f + (C6091a.m9576fv(3) + 8)) + (C6091a.m9576fv(4) + 8)) + C6091a.m9578o(5, this.vCE);
            if (this.vCF != null) {
                f += C6091a.m9575f(6, this.vCF);
            }
            if (this.vCG != null) {
                f += C6091a.m9575f(7, this.vCG);
            }
            if (this.vCH != null) {
                f += C6091a.m9575f(8, this.vCH);
            }
            if (this.vCI != null) {
                f += C6091a.m9575f(9, this.vCI);
            }
            if (this.vCJ != null) {
                f += C6091a.m9575f(10, this.vCJ);
            }
            AppMethodBeat.m2505o(56697);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56697);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15319aw c15319aw = (C15319aw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c15319aw.duc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56697);
                    return 0;
                case 2:
                    c15319aw.dud = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56697);
                    return 0;
                case 3:
                    c15319aw.latitude = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(56697);
                    return 0;
                case 4:
                    c15319aw.longitude = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(56697);
                    return 0;
                case 5:
                    c15319aw.vCE = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56697);
                    return 0;
                case 6:
                    c15319aw.vCF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56697);
                    return 0;
                case 7:
                    c15319aw.vCG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56697);
                    return 0;
                case 8:
                    c15319aw.vCH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56697);
                    return 0;
                case 9:
                    c15319aw.vCI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56697);
                    return 0;
                case 10:
                    c15319aw.vCJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56697);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56697);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56697);
            return -1;
        }
    }
}
