package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.qa */
public final class C7278qa extends C1331a {
    public int kKS;
    public String kKT;
    public String kKY;
    public String kKZ;
    public String kLL;
    public int vWZ;
    public String vXa;
    public int vXb;
    public String vXc;
    public int vXd;
    public String vXe;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94513);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.vWZ);
            if (this.kLL != null) {
                c6093a.mo13475e(2, this.kLL);
            }
            if (this.vXa != null) {
                c6093a.mo13475e(3, this.vXa);
            }
            if (this.kKY != null) {
                c6093a.mo13475e(4, this.kKY);
            }
            c6093a.mo13480iz(5, this.vXb);
            if (this.vXc != null) {
                c6093a.mo13475e(6, this.vXc);
            }
            c6093a.mo13480iz(7, this.vXd);
            if (this.kKZ != null) {
                c6093a.mo13475e(8, this.kKZ);
            }
            if (this.vXe != null) {
                c6093a.mo13475e(9, this.vXe);
            }
            c6093a.mo13480iz(10, this.kKS);
            if (this.kKT != null) {
                c6093a.mo13475e(11, this.kKT);
            }
            AppMethodBeat.m2505o(94513);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.vWZ) + 0;
            if (this.kLL != null) {
                bs += C6091a.m9575f(2, this.kLL);
            }
            if (this.vXa != null) {
                bs += C6091a.m9575f(3, this.vXa);
            }
            if (this.kKY != null) {
                bs += C6091a.m9575f(4, this.kKY);
            }
            bs += C6091a.m9572bs(5, this.vXb);
            if (this.vXc != null) {
                bs += C6091a.m9575f(6, this.vXc);
            }
            bs += C6091a.m9572bs(7, this.vXd);
            if (this.kKZ != null) {
                bs += C6091a.m9575f(8, this.kKZ);
            }
            if (this.vXe != null) {
                bs += C6091a.m9575f(9, this.vXe);
            }
            bs += C6091a.m9572bs(10, this.kKS);
            if (this.kKT != null) {
                bs += C6091a.m9575f(11, this.kKT);
            }
            AppMethodBeat.m2505o(94513);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94513);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7278qa c7278qa = (C7278qa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c7278qa.vWZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94513);
                    return 0;
                case 2:
                    c7278qa.kLL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94513);
                    return 0;
                case 3:
                    c7278qa.vXa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94513);
                    return 0;
                case 4:
                    c7278qa.kKY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94513);
                    return 0;
                case 5:
                    c7278qa.vXb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94513);
                    return 0;
                case 6:
                    c7278qa.vXc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94513);
                    return 0;
                case 7:
                    c7278qa.vXd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94513);
                    return 0;
                case 8:
                    c7278qa.kKZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94513);
                    return 0;
                case 9:
                    c7278qa.vXe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94513);
                    return 0;
                case 10:
                    c7278qa.kKS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94513);
                    return 0;
                case 11:
                    c7278qa.kKT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94513);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94513);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94513);
            return -1;
        }
    }
}
