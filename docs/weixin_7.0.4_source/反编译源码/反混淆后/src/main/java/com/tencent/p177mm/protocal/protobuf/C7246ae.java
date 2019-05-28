package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ae */
public final class C7246ae extends C1331a {
    public String vBj;
    public int vBk;
    public int vBl;
    public int vBm;
    public int vBn;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(72837);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vBj != null) {
                c6093a.mo13475e(1, this.vBj);
            }
            c6093a.mo13480iz(2, this.vBk);
            c6093a.mo13480iz(3, this.vBl);
            c6093a.mo13480iz(4, this.vBm);
            c6093a.mo13480iz(5, this.vBn);
            AppMethodBeat.m2505o(72837);
            return 0;
        } else if (i == 1) {
            if (this.vBj != null) {
                f = C6091a.m9575f(1, this.vBj) + 0;
            } else {
                f = 0;
            }
            int bs = (((f + C6091a.m9572bs(2, this.vBk)) + C6091a.m9572bs(3, this.vBl)) + C6091a.m9572bs(4, this.vBm)) + C6091a.m9572bs(5, this.vBn);
            AppMethodBeat.m2505o(72837);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(72837);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7246ae c7246ae = (C7246ae) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c7246ae.vBj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(72837);
                    return 0;
                case 2:
                    c7246ae.vBk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72837);
                    return 0;
                case 3:
                    c7246ae.vBl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72837);
                    return 0;
                case 4:
                    c7246ae.vBm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72837);
                    return 0;
                case 5:
                    c7246ae.vBn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72837);
                    return 0;
                default:
                    AppMethodBeat.m2505o(72837);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(72837);
            return -1;
        }
    }
}
