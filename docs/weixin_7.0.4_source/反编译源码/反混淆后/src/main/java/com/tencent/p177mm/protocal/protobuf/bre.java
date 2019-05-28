package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bre */
public final class bre extends C1331a {
    public int jCt;
    public int lvf;
    public int wOI;
    public String wTy;
    public C1332b wcJ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(118282);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wTy != null) {
                c6093a.mo13475e(1, this.wTy);
            }
            c6093a.mo13480iz(2, this.jCt);
            c6093a.mo13480iz(3, this.lvf);
            c6093a.mo13480iz(4, this.wOI);
            if (this.wcJ != null) {
                c6093a.mo13473c(5, this.wcJ);
            }
            AppMethodBeat.m2505o(118282);
            return 0;
        } else if (i == 1) {
            if (this.wTy != null) {
                f = C6091a.m9575f(1, this.wTy) + 0;
            } else {
                f = 0;
            }
            f = ((f + C6091a.m9572bs(2, this.jCt)) + C6091a.m9572bs(3, this.lvf)) + C6091a.m9572bs(4, this.wOI);
            if (this.wcJ != null) {
                f += C6091a.m9571b(5, this.wcJ);
            }
            AppMethodBeat.m2505o(118282);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(118282);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bre bre = (bre) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bre.wTy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(118282);
                    return 0;
                case 2:
                    bre.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(118282);
                    return 0;
                case 3:
                    bre.lvf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(118282);
                    return 0;
                case 4:
                    bre.wOI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(118282);
                    return 0;
                case 5:
                    bre.wcJ = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(118282);
                    return 0;
                default:
                    AppMethodBeat.m2505o(118282);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(118282);
            return -1;
        }
    }
}
