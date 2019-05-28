package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bsj */
public final class bsj extends C1331a {
    public int Scene;
    public long vQd;
    public int vZW;
    public String wDM;
    public long wOP;
    public String wUn;
    public String wUo;
    public int wUp;
    public int wUq;
    public int wUr;
    public String wUs;
    public String wUt;
    public String wUu;
    public int wyk;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124342);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.Scene);
            if (this.wDM != null) {
                c6093a.mo13475e(2, this.wDM);
            }
            if (this.wUn != null) {
                c6093a.mo13475e(3, this.wUn);
            }
            c6093a.mo13472ai(4, this.vQd);
            if (this.wUo != null) {
                c6093a.mo13475e(5, this.wUo);
            }
            c6093a.mo13480iz(6, this.wUp);
            c6093a.mo13480iz(7, this.wUq);
            c6093a.mo13480iz(8, this.wUr);
            c6093a.mo13472ai(9, this.wOP);
            c6093a.mo13480iz(10, this.wyk);
            if (this.wUs != null) {
                c6093a.mo13475e(11, this.wUs);
            }
            c6093a.mo13480iz(12, this.vZW);
            if (this.wUt != null) {
                c6093a.mo13475e(13, this.wUt);
            }
            if (this.wUu != null) {
                c6093a.mo13475e(14, this.wUu);
            }
            AppMethodBeat.m2505o(124342);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.Scene) + 0;
            if (this.wDM != null) {
                bs += C6091a.m9575f(2, this.wDM);
            }
            if (this.wUn != null) {
                bs += C6091a.m9575f(3, this.wUn);
            }
            bs += C6091a.m9578o(4, this.vQd);
            if (this.wUo != null) {
                bs += C6091a.m9575f(5, this.wUo);
            }
            bs = ((((bs + C6091a.m9572bs(6, this.wUp)) + C6091a.m9572bs(7, this.wUq)) + C6091a.m9572bs(8, this.wUr)) + C6091a.m9578o(9, this.wOP)) + C6091a.m9572bs(10, this.wyk);
            if (this.wUs != null) {
                bs += C6091a.m9575f(11, this.wUs);
            }
            bs += C6091a.m9572bs(12, this.vZW);
            if (this.wUt != null) {
                bs += C6091a.m9575f(13, this.wUt);
            }
            if (this.wUu != null) {
                bs += C6091a.m9575f(14, this.wUu);
            }
            AppMethodBeat.m2505o(124342);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(124342);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bsj bsj = (bsj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bsj.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124342);
                    return 0;
                case 2:
                    bsj.wDM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124342);
                    return 0;
                case 3:
                    bsj.wUn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124342);
                    return 0;
                case 4:
                    bsj.vQd = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(124342);
                    return 0;
                case 5:
                    bsj.wUo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124342);
                    return 0;
                case 6:
                    bsj.wUp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124342);
                    return 0;
                case 7:
                    bsj.wUq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124342);
                    return 0;
                case 8:
                    bsj.wUr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124342);
                    return 0;
                case 9:
                    bsj.wOP = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(124342);
                    return 0;
                case 10:
                    bsj.wyk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124342);
                    return 0;
                case 11:
                    bsj.wUs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124342);
                    return 0;
                case 12:
                    bsj.vZW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124342);
                    return 0;
                case 13:
                    bsj.wUt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124342);
                    return 0;
                case 14:
                    bsj.wUu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124342);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124342);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124342);
            return -1;
        }
    }
}
