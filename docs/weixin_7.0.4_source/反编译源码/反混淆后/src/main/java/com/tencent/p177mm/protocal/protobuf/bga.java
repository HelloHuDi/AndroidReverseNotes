package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bga */
public final class bga extends C1331a {
    public String bfz;
    public String cFW;
    public String kfO;
    public String wJW;
    public String wJX;
    public int wJY;
    public String wJZ;
    public String wKa;
    public String wKb;
    public int wKc;
    public int wKd;
    public int wKe;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80126);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.bfz != null) {
                c6093a.mo13475e(1, this.bfz);
            }
            if (this.wJW != null) {
                c6093a.mo13475e(2, this.wJW);
            }
            if (this.wJX != null) {
                c6093a.mo13475e(3, this.wJX);
            }
            c6093a.mo13480iz(4, this.wJY);
            if (this.cFW != null) {
                c6093a.mo13475e(5, this.cFW);
            }
            if (this.wJZ != null) {
                c6093a.mo13475e(6, this.wJZ);
            }
            if (this.wKa != null) {
                c6093a.mo13475e(7, this.wKa);
            }
            if (this.kfO != null) {
                c6093a.mo13475e(8, this.kfO);
            }
            if (this.wKb != null) {
                c6093a.mo13475e(9, this.wKb);
            }
            c6093a.mo13480iz(10, this.wKc);
            c6093a.mo13480iz(11, this.wKd);
            c6093a.mo13480iz(12, this.wKe);
            AppMethodBeat.m2505o(80126);
            return 0;
        } else if (i == 1) {
            if (this.bfz != null) {
                f = C6091a.m9575f(1, this.bfz) + 0;
            } else {
                f = 0;
            }
            if (this.wJW != null) {
                f += C6091a.m9575f(2, this.wJW);
            }
            if (this.wJX != null) {
                f += C6091a.m9575f(3, this.wJX);
            }
            f += C6091a.m9572bs(4, this.wJY);
            if (this.cFW != null) {
                f += C6091a.m9575f(5, this.cFW);
            }
            if (this.wJZ != null) {
                f += C6091a.m9575f(6, this.wJZ);
            }
            if (this.wKa != null) {
                f += C6091a.m9575f(7, this.wKa);
            }
            if (this.kfO != null) {
                f += C6091a.m9575f(8, this.kfO);
            }
            if (this.wKb != null) {
                f += C6091a.m9575f(9, this.wKb);
            }
            int bs = ((f + C6091a.m9572bs(10, this.wKc)) + C6091a.m9572bs(11, this.wKd)) + C6091a.m9572bs(12, this.wKe);
            AppMethodBeat.m2505o(80126);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(80126);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bga bga = (bga) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bga.bfz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80126);
                    return 0;
                case 2:
                    bga.wJW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80126);
                    return 0;
                case 3:
                    bga.wJX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80126);
                    return 0;
                case 4:
                    bga.wJY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80126);
                    return 0;
                case 5:
                    bga.cFW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80126);
                    return 0;
                case 6:
                    bga.wJZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80126);
                    return 0;
                case 7:
                    bga.wKa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80126);
                    return 0;
                case 8:
                    bga.kfO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80126);
                    return 0;
                case 9:
                    bga.wKb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80126);
                    return 0;
                case 10:
                    bga.wKc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80126);
                    return 0;
                case 11:
                    bga.wKd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80126);
                    return 0;
                case 12:
                    bga.wKe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80126);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80126);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80126);
            return -1;
        }
    }
}
