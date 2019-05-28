package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.kd */
public final class C44133kd extends C1331a {
    public String name;
    public int type;
    public String vMV;
    public String vMW;
    public int vMX;
    public int vMY;
    public String vMZ;
    public String vNa;
    public int ver;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(11700);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vMV != null) {
                c6093a.mo13475e(1, this.vMV);
            }
            c6093a.mo13480iz(2, this.type);
            if (this.vMW != null) {
                c6093a.mo13475e(3, this.vMW);
            }
            if (this.name != null) {
                c6093a.mo13475e(4, this.name);
            }
            c6093a.mo13480iz(5, this.ver);
            c6093a.mo13480iz(6, this.vMX);
            c6093a.mo13480iz(7, this.vMY);
            if (this.vMZ != null) {
                c6093a.mo13475e(8, this.vMZ);
            }
            if (this.vNa != null) {
                c6093a.mo13475e(9, this.vNa);
            }
            AppMethodBeat.m2505o(11700);
            return 0;
        } else if (i == 1) {
            if (this.vMV != null) {
                f = C6091a.m9575f(1, this.vMV) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.type);
            if (this.vMW != null) {
                f += C6091a.m9575f(3, this.vMW);
            }
            if (this.name != null) {
                f += C6091a.m9575f(4, this.name);
            }
            f = ((f + C6091a.m9572bs(5, this.ver)) + C6091a.m9572bs(6, this.vMX)) + C6091a.m9572bs(7, this.vMY);
            if (this.vMZ != null) {
                f += C6091a.m9575f(8, this.vMZ);
            }
            if (this.vNa != null) {
                f += C6091a.m9575f(9, this.vNa);
            }
            AppMethodBeat.m2505o(11700);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(11700);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44133kd c44133kd = (C44133kd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c44133kd.vMV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11700);
                    return 0;
                case 2:
                    c44133kd.type = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11700);
                    return 0;
                case 3:
                    c44133kd.vMW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11700);
                    return 0;
                case 4:
                    c44133kd.name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11700);
                    return 0;
                case 5:
                    c44133kd.ver = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11700);
                    return 0;
                case 6:
                    c44133kd.vMX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11700);
                    return 0;
                case 7:
                    c44133kd.vMY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11700);
                    return 0;
                case 8:
                    c44133kd.vMZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11700);
                    return 0;
                case 9:
                    c44133kd.vNa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11700);
                    return 0;
                default:
                    AppMethodBeat.m2505o(11700);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(11700);
            return -1;
        }
    }
}
