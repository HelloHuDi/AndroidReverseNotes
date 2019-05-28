package com.tencent.p177mm.plugin.backup.p921i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.backup.i.p */
public final class C42777p extends C1331a {
    /* renamed from: ID */
    public String f17191ID;
    public long jBS;
    public int jBV;
    public int jBW;
    public int jBX;
    public long jBY;
    public long jBZ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(18063);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.f17191ID == null) {
                c6092b = new C6092b("Not all required fields were included: ID");
                AppMethodBeat.m2505o(18063);
                throw c6092b;
            }
            if (this.f17191ID != null) {
                c6093a.mo13475e(1, this.f17191ID);
            }
            c6093a.mo13480iz(2, this.jBV);
            c6093a.mo13480iz(3, this.jBW);
            c6093a.mo13480iz(4, this.jBX);
            c6093a.mo13472ai(5, this.jBS);
            c6093a.mo13472ai(6, this.jBY);
            c6093a.mo13472ai(7, this.jBZ);
            AppMethodBeat.m2505o(18063);
            return 0;
        } else if (i == 1) {
            if (this.f17191ID != null) {
                f = C6091a.m9575f(1, this.f17191ID) + 0;
            } else {
                f = 0;
            }
            int bs = (((((f + C6091a.m9572bs(2, this.jBV)) + C6091a.m9572bs(3, this.jBW)) + C6091a.m9572bs(4, this.jBX)) + C6091a.m9578o(5, this.jBS)) + C6091a.m9578o(6, this.jBY)) + C6091a.m9578o(7, this.jBZ);
            AppMethodBeat.m2505o(18063);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.f17191ID == null) {
                c6092b = new C6092b("Not all required fields were included: ID");
                AppMethodBeat.m2505o(18063);
                throw c6092b;
            }
            AppMethodBeat.m2505o(18063);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C42777p c42777p = (C42777p) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c42777p.f17191ID = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18063);
                    return 0;
                case 2:
                    c42777p.jBV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18063);
                    return 0;
                case 3:
                    c42777p.jBW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18063);
                    return 0;
                case 4:
                    c42777p.jBX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18063);
                    return 0;
                case 5:
                    c42777p.jBS = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(18063);
                    return 0;
                case 6:
                    c42777p.jBY = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(18063);
                    return 0;
                case 7:
                    c42777p.jBZ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(18063);
                    return 0;
                default:
                    AppMethodBeat.m2505o(18063);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(18063);
            return -1;
        }
    }
}
