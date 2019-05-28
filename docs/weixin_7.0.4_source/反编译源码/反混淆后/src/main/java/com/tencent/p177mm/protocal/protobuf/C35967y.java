package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.y */
public final class C35967y extends C1331a {
    public String nZa;
    public String nZb;
    public String nZc;
    public String nZd;
    public int vAF;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56695);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.vAF);
            if (this.nZa != null) {
                c6093a.mo13475e(2, this.nZa);
            }
            if (this.nZb != null) {
                c6093a.mo13475e(3, this.nZb);
            }
            if (this.nZc != null) {
                c6093a.mo13475e(4, this.nZc);
            }
            if (this.nZd != null) {
                c6093a.mo13475e(5, this.nZd);
            }
            AppMethodBeat.m2505o(56695);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.vAF) + 0;
            if (this.nZa != null) {
                bs += C6091a.m9575f(2, this.nZa);
            }
            if (this.nZb != null) {
                bs += C6091a.m9575f(3, this.nZb);
            }
            if (this.nZc != null) {
                bs += C6091a.m9575f(4, this.nZc);
            }
            if (this.nZd != null) {
                bs += C6091a.m9575f(5, this.nZd);
            }
            AppMethodBeat.m2505o(56695);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56695);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35967y c35967y = (C35967y) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c35967y.vAF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56695);
                    return 0;
                case 2:
                    c35967y.nZa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56695);
                    return 0;
                case 3:
                    c35967y.nZb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56695);
                    return 0;
                case 4:
                    c35967y.nZc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56695);
                    return 0;
                case 5:
                    c35967y.nZd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56695);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56695);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56695);
            return -1;
        }
    }
}
