package p1121d.p1122a.p1123a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: d.a.a.g */
public final class C44605g extends C1331a {
    public String BTP;
    public String BTQ;
    public String BTR;
    public String BTS;
    public String BTT;
    public String pia;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(57012);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.pia != null) {
                c6093a.mo13475e(1, this.pia);
            }
            if (this.BTP != null) {
                c6093a.mo13475e(2, this.BTP);
            }
            if (this.BTQ != null) {
                c6093a.mo13475e(3, this.BTQ);
            }
            if (this.BTR != null) {
                c6093a.mo13475e(4, this.BTR);
            }
            if (this.BTS != null) {
                c6093a.mo13475e(5, this.BTS);
            }
            if (this.BTT != null) {
                c6093a.mo13475e(6, this.BTT);
            }
            AppMethodBeat.m2505o(57012);
            return 0;
        } else if (i == 1) {
            if (this.pia != null) {
                f = C6091a.m9575f(1, this.pia) + 0;
            } else {
                f = 0;
            }
            if (this.BTP != null) {
                f += C6091a.m9575f(2, this.BTP);
            }
            if (this.BTQ != null) {
                f += C6091a.m9575f(3, this.BTQ);
            }
            if (this.BTR != null) {
                f += C6091a.m9575f(4, this.BTR);
            }
            if (this.BTS != null) {
                f += C6091a.m9575f(5, this.BTS);
            }
            if (this.BTT != null) {
                f += C6091a.m9575f(6, this.BTT);
            }
            AppMethodBeat.m2505o(57012);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(57012);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44605g c44605g = (C44605g) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c44605g.pia = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(57012);
                    return 0;
                case 2:
                    c44605g.BTP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(57012);
                    return 0;
                case 3:
                    c44605g.BTQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(57012);
                    return 0;
                case 4:
                    c44605g.BTR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(57012);
                    return 0;
                case 5:
                    c44605g.BTS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(57012);
                    return 0;
                case 6:
                    c44605g.BTT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(57012);
                    return 0;
                default:
                    AppMethodBeat.m2505o(57012);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(57012);
            return -1;
        }
    }
}
