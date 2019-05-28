package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.gi */
public final class C23390gi extends C1331a {
    public int jBT;
    public String ptA;
    public long vIA;
    public double vIB;
    public int vIC;
    public long vIs;
    public String vIt;
    public int vIu;
    public long vIv;
    public int vIw;
    public long vIx;
    public long vIy;
    public int vIz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(54936);
        int o;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13472ai(1, this.vIs);
            if (this.ptA != null) {
                c6093a.mo13475e(2, this.ptA);
            }
            if (this.vIt != null) {
                c6093a.mo13475e(3, this.vIt);
            }
            c6093a.mo13480iz(4, this.vIu);
            c6093a.mo13472ai(5, this.vIv);
            c6093a.mo13480iz(6, this.vIw);
            c6093a.mo13480iz(7, this.jBT);
            c6093a.mo13472ai(8, this.vIx);
            c6093a.mo13472ai(9, this.vIy);
            c6093a.mo13480iz(10, this.vIz);
            c6093a.mo13472ai(11, this.vIA);
            c6093a.mo13476f(12, this.vIB);
            c6093a.mo13480iz(13, this.vIC);
            AppMethodBeat.m2505o(54936);
            return 0;
        } else if (i == 1) {
            o = C6091a.m9578o(1, this.vIs) + 0;
            if (this.ptA != null) {
                o += C6091a.m9575f(2, this.ptA);
            }
            if (this.vIt != null) {
                o += C6091a.m9575f(3, this.vIt);
            }
            o = (((((((((o + C6091a.m9572bs(4, this.vIu)) + C6091a.m9578o(5, this.vIv)) + C6091a.m9572bs(6, this.vIw)) + C6091a.m9572bs(7, this.jBT)) + C6091a.m9578o(8, this.vIx)) + C6091a.m9578o(9, this.vIy)) + C6091a.m9572bs(10, this.vIz)) + C6091a.m9578o(11, this.vIA)) + (C6091a.m9576fv(12) + 8)) + C6091a.m9572bs(13, this.vIC);
            AppMethodBeat.m2505o(54936);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(54936);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23390gi c23390gi = (C23390gi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c23390gi.vIs = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(54936);
                    return 0;
                case 2:
                    c23390gi.ptA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(54936);
                    return 0;
                case 3:
                    c23390gi.vIt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(54936);
                    return 0;
                case 4:
                    c23390gi.vIu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(54936);
                    return 0;
                case 5:
                    c23390gi.vIv = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(54936);
                    return 0;
                case 6:
                    c23390gi.vIw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(54936);
                    return 0;
                case 7:
                    c23390gi.jBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(54936);
                    return 0;
                case 8:
                    c23390gi.vIx = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(54936);
                    return 0;
                case 9:
                    c23390gi.vIy = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(54936);
                    return 0;
                case 10:
                    c23390gi.vIz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(54936);
                    return 0;
                case 11:
                    c23390gi.vIA = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(54936);
                    return 0;
                case 12:
                    c23390gi.vIB = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(54936);
                    return 0;
                case 13:
                    c23390gi.vIC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(54936);
                    return 0;
                default:
                    AppMethodBeat.m2505o(54936);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(54936);
            return -1;
        }
    }
}
