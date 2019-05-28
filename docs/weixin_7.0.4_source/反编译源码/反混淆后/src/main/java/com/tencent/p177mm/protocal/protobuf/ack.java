package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ack */
public final class ack extends C1331a {
    public String jBB;
    public int pcX;
    public int vAR;
    public String vEA;
    public String vEy;
    public String wkf;
    public String wkg;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51020);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vEy != null) {
                c6093a.mo13475e(1, this.vEy);
            }
            c6093a.mo13480iz(2, this.pcX);
            c6093a.mo13480iz(3, this.vAR);
            if (this.vEA != null) {
                c6093a.mo13475e(4, this.vEA);
            }
            if (this.wkf != null) {
                c6093a.mo13475e(5, this.wkf);
            }
            if (this.jBB != null) {
                c6093a.mo13475e(6, this.jBB);
            }
            if (this.wkg != null) {
                c6093a.mo13475e(7, this.wkg);
            }
            AppMethodBeat.m2505o(51020);
            return 0;
        } else if (i == 1) {
            if (this.vEy != null) {
                f = C6091a.m9575f(1, this.vEy) + 0;
            } else {
                f = 0;
            }
            f = (f + C6091a.m9572bs(2, this.pcX)) + C6091a.m9572bs(3, this.vAR);
            if (this.vEA != null) {
                f += C6091a.m9575f(4, this.vEA);
            }
            if (this.wkf != null) {
                f += C6091a.m9575f(5, this.wkf);
            }
            if (this.jBB != null) {
                f += C6091a.m9575f(6, this.jBB);
            }
            if (this.wkg != null) {
                f += C6091a.m9575f(7, this.wkg);
            }
            AppMethodBeat.m2505o(51020);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(51020);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ack ack = (ack) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ack.vEy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51020);
                    return 0;
                case 2:
                    ack.pcX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51020);
                    return 0;
                case 3:
                    ack.vAR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51020);
                    return 0;
                case 4:
                    ack.vEA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51020);
                    return 0;
                case 5:
                    ack.wkf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51020);
                    return 0;
                case 6:
                    ack.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51020);
                    return 0;
                case 7:
                    ack.wkg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51020);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51020);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51020);
            return -1;
        }
    }
}
