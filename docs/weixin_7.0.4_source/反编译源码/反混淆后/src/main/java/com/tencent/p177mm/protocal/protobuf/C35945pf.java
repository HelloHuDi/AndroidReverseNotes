package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.pf */
public final class C35945pf extends C1331a {
    public String cMC;
    public int kbZ;
    public String kfO;
    public int vWx;
    public String vWy;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89048);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.cMC != null) {
                c6093a.mo13475e(1, this.cMC);
            }
            if (this.kfO != null) {
                c6093a.mo13475e(2, this.kfO);
            }
            c6093a.mo13480iz(3, this.kbZ);
            c6093a.mo13480iz(4, this.vWx);
            if (this.vWy != null) {
                c6093a.mo13475e(5, this.vWy);
            }
            AppMethodBeat.m2505o(89048);
            return 0;
        } else if (i == 1) {
            if (this.cMC != null) {
                f = C6091a.m9575f(1, this.cMC) + 0;
            } else {
                f = 0;
            }
            if (this.kfO != null) {
                f += C6091a.m9575f(2, this.kfO);
            }
            f = (f + C6091a.m9572bs(3, this.kbZ)) + C6091a.m9572bs(4, this.vWx);
            if (this.vWy != null) {
                f += C6091a.m9575f(5, this.vWy);
            }
            AppMethodBeat.m2505o(89048);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89048);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35945pf c35945pf = (C35945pf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c35945pf.cMC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89048);
                    return 0;
                case 2:
                    c35945pf.kfO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89048);
                    return 0;
                case 3:
                    c35945pf.kbZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89048);
                    return 0;
                case 4:
                    c35945pf.vWx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89048);
                    return 0;
                case 5:
                    c35945pf.vWy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89048);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89048);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89048);
            return -1;
        }
    }
}
