package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.cw */
public final class C34272cw extends C1331a {
    public String Label;
    public String jBB;
    public int ndr;
    public long nds;
    public boolean ndt;
    public int ndu;
    public String ndv;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111663);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.jBB == null) {
                c6092b = new C6092b("Not all required fields were included: UserName");
                AppMethodBeat.m2505o(111663);
                throw c6092b;
            }
            if (this.jBB != null) {
                c6093a.mo13475e(1, this.jBB);
            }
            c6093a.mo13480iz(2, this.ndr);
            c6093a.mo13472ai(3, this.nds);
            if (this.Label != null) {
                c6093a.mo13475e(4, this.Label);
            }
            c6093a.mo13471aO(5, this.ndt);
            c6093a.mo13480iz(6, this.ndu);
            if (this.ndv != null) {
                c6093a.mo13475e(7, this.ndv);
            }
            AppMethodBeat.m2505o(111663);
            return 0;
        } else if (i == 1) {
            if (this.jBB != null) {
                f = C6091a.m9575f(1, this.jBB) + 0;
            } else {
                f = 0;
            }
            f = (f + C6091a.m9572bs(2, this.ndr)) + C6091a.m9578o(3, this.nds);
            if (this.Label != null) {
                f += C6091a.m9575f(4, this.Label);
            }
            f = (f + (C6091a.m9576fv(5) + 1)) + C6091a.m9572bs(6, this.ndu);
            if (this.ndv != null) {
                f += C6091a.m9575f(7, this.ndv);
            }
            AppMethodBeat.m2505o(111663);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.jBB == null) {
                c6092b = new C6092b("Not all required fields were included: UserName");
                AppMethodBeat.m2505o(111663);
                throw c6092b;
            }
            AppMethodBeat.m2505o(111663);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C34272cw c34272cw = (C34272cw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c34272cw.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111663);
                    return 0;
                case 2:
                    c34272cw.ndr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111663);
                    return 0;
                case 3:
                    c34272cw.nds = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(111663);
                    return 0;
                case 4:
                    c34272cw.Label = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111663);
                    return 0;
                case 5:
                    c34272cw.ndt = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(111663);
                    return 0;
                case 6:
                    c34272cw.ndu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111663);
                    return 0;
                case 7:
                    c34272cw.ndv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111663);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111663);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111663);
            return -1;
        }
    }
}
