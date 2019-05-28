package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bmm */
public final class bmm extends C1331a {
    public String cDL;
    public String cvZ;
    public String url;
    public int version;
    public boolean wPt;
    public int wPu;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96282);
        int fv;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13471aO(1, this.wPt);
            if (this.url != null) {
                c6093a.mo13475e(2, this.url);
            }
            if (this.cvZ != null) {
                c6093a.mo13475e(3, this.cvZ);
            }
            c6093a.mo13480iz(4, this.version);
            c6093a.mo13480iz(5, this.wPu);
            if (this.cDL != null) {
                c6093a.mo13475e(6, this.cDL);
            }
            AppMethodBeat.m2505o(96282);
            return 0;
        } else if (i == 1) {
            fv = (C6091a.m9576fv(1) + 1) + 0;
            if (this.url != null) {
                fv += C6091a.m9575f(2, this.url);
            }
            if (this.cvZ != null) {
                fv += C6091a.m9575f(3, this.cvZ);
            }
            fv = (fv + C6091a.m9572bs(4, this.version)) + C6091a.m9572bs(5, this.wPu);
            if (this.cDL != null) {
                fv += C6091a.m9575f(6, this.cDL);
            }
            AppMethodBeat.m2505o(96282);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (fv = C1331a.getNextFieldNumber(c6086a); fv > 0; fv = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, fv)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(96282);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bmm bmm = (bmm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bmm.wPt = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(96282);
                    return 0;
                case 2:
                    bmm.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96282);
                    return 0;
                case 3:
                    bmm.cvZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96282);
                    return 0;
                case 4:
                    bmm.version = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96282);
                    return 0;
                case 5:
                    bmm.wPu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96282);
                    return 0;
                case 6:
                    bmm.cDL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96282);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96282);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96282);
            return -1;
        }
    }
}
