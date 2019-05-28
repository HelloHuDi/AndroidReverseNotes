package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bb */
public final class C23371bb extends C1331a {
    public boolean vCS = false;
    public boolean vCT = false;
    public boolean vCU = false;
    public boolean vCV = false;
    public String vCW = "";
    public String vCX = "";
    public String vCY = "";
    public String vCZ = "";
    public int vDa = -1;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(73642);
        int fv;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13471aO(1, this.vCS);
            c6093a.mo13471aO(2, this.vCT);
            c6093a.mo13471aO(3, this.vCU);
            c6093a.mo13471aO(4, this.vCV);
            if (this.vCW != null) {
                c6093a.mo13475e(5, this.vCW);
            }
            if (this.vCX != null) {
                c6093a.mo13475e(6, this.vCX);
            }
            if (this.vCY != null) {
                c6093a.mo13475e(7, this.vCY);
            }
            if (this.vCZ != null) {
                c6093a.mo13475e(8, this.vCZ);
            }
            c6093a.mo13480iz(9, this.vDa);
            AppMethodBeat.m2505o(73642);
            return 0;
        } else if (i == 1) {
            fv = ((((C6091a.m9576fv(1) + 1) + 0) + (C6091a.m9576fv(2) + 1)) + (C6091a.m9576fv(3) + 1)) + (C6091a.m9576fv(4) + 1);
            if (this.vCW != null) {
                fv += C6091a.m9575f(5, this.vCW);
            }
            if (this.vCX != null) {
                fv += C6091a.m9575f(6, this.vCX);
            }
            if (this.vCY != null) {
                fv += C6091a.m9575f(7, this.vCY);
            }
            if (this.vCZ != null) {
                fv += C6091a.m9575f(8, this.vCZ);
            }
            fv += C6091a.m9572bs(9, this.vDa);
            AppMethodBeat.m2505o(73642);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (fv = C1331a.getNextFieldNumber(c6086a); fv > 0; fv = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, fv)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(73642);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23371bb c23371bb = (C23371bb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c23371bb.vCS = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(73642);
                    return 0;
                case 2:
                    c23371bb.vCT = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(73642);
                    return 0;
                case 3:
                    c23371bb.vCU = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(73642);
                    return 0;
                case 4:
                    c23371bb.vCV = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(73642);
                    return 0;
                case 5:
                    c23371bb.vCW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73642);
                    return 0;
                case 6:
                    c23371bb.vCX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73642);
                    return 0;
                case 7:
                    c23371bb.vCY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73642);
                    return 0;
                case 8:
                    c23371bb.vCZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73642);
                    return 0;
                case 9:
                    c23371bb.vDa = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73642);
                    return 0;
                default:
                    AppMethodBeat.m2505o(73642);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(73642);
            return -1;
        }
    }
}
