package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.od */
public final class C23422od extends C1331a {
    public float cEB;
    public float cGm;
    public String country;
    public String descriptor;
    public String duc;
    public String dud;
    public String fBg;
    public String kck;
    public String kdF;
    public String name;
    public float qVo;
    public String vTL;
    public String vTM;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89039);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.name != null) {
                c6093a.mo13475e(1, this.name);
            }
            if (this.descriptor != null) {
                c6093a.mo13475e(2, this.descriptor);
            }
            if (this.kck != null) {
                c6093a.mo13475e(3, this.kck);
            }
            if (this.country != null) {
                c6093a.mo13475e(4, this.country);
            }
            if (this.duc != null) {
                c6093a.mo13475e(5, this.duc);
            }
            if (this.dud != null) {
                c6093a.mo13475e(6, this.dud);
            }
            if (this.fBg != null) {
                c6093a.mo13475e(7, this.fBg);
            }
            c6093a.mo13481r(8, this.qVo);
            c6093a.mo13481r(9, this.cGm);
            c6093a.mo13481r(10, this.cEB);
            if (this.kdF != null) {
                c6093a.mo13475e(11, this.kdF);
            }
            if (this.vTL != null) {
                c6093a.mo13475e(12, this.vTL);
            }
            if (this.vTM != null) {
                c6093a.mo13475e(13, this.vTM);
            }
            AppMethodBeat.m2505o(89039);
            return 0;
        } else if (i == 1) {
            if (this.name != null) {
                f = C6091a.m9575f(1, this.name) + 0;
            } else {
                f = 0;
            }
            if (this.descriptor != null) {
                f += C6091a.m9575f(2, this.descriptor);
            }
            if (this.kck != null) {
                f += C6091a.m9575f(3, this.kck);
            }
            if (this.country != null) {
                f += C6091a.m9575f(4, this.country);
            }
            if (this.duc != null) {
                f += C6091a.m9575f(5, this.duc);
            }
            if (this.dud != null) {
                f += C6091a.m9575f(6, this.dud);
            }
            if (this.fBg != null) {
                f += C6091a.m9575f(7, this.fBg);
            }
            f = ((f + (C6091a.m9576fv(8) + 4)) + (C6091a.m9576fv(9) + 4)) + (C6091a.m9576fv(10) + 4);
            if (this.kdF != null) {
                f += C6091a.m9575f(11, this.kdF);
            }
            if (this.vTL != null) {
                f += C6091a.m9575f(12, this.vTL);
            }
            if (this.vTM != null) {
                f += C6091a.m9575f(13, this.vTM);
            }
            AppMethodBeat.m2505o(89039);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89039);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23422od c23422od = (C23422od) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c23422od.name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89039);
                    return 0;
                case 2:
                    c23422od.descriptor = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89039);
                    return 0;
                case 3:
                    c23422od.kck = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89039);
                    return 0;
                case 4:
                    c23422od.country = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89039);
                    return 0;
                case 5:
                    c23422od.duc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89039);
                    return 0;
                case 6:
                    c23422od.dud = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89039);
                    return 0;
                case 7:
                    c23422od.fBg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89039);
                    return 0;
                case 8:
                    c23422od.qVo = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(89039);
                    return 0;
                case 9:
                    c23422od.cGm = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(89039);
                    return 0;
                case 10:
                    c23422od.cEB = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(89039);
                    return 0;
                case 11:
                    c23422od.kdF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89039);
                    return 0;
                case 12:
                    c23422od.vTL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89039);
                    return 0;
                case 13:
                    c23422od.vTM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89039);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89039);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89039);
            return -1;
        }
    }
}
