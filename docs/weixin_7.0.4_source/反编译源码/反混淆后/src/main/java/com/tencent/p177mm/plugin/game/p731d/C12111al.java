package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.al */
public final class C12111al extends C1331a {
    public String Title;
    public String mZL;
    public int mZN;
    public String mZj;
    public String naV;
    public boolean naW;
    public boolean naX;
    public String naY;
    public String naZ;
    public int nba;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111577);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Title == null) {
                c6092b = new C6092b("Not all required fields were included: Title");
                AppMethodBeat.m2505o(111577);
                throw c6092b;
            } else if (this.naV == null) {
                c6092b = new C6092b("Not all required fields were included: NavKey");
                AppMethodBeat.m2505o(111577);
                throw c6092b;
            } else {
                if (this.Title != null) {
                    c6093a.mo13475e(1, this.Title);
                }
                if (this.naV != null) {
                    c6093a.mo13475e(2, this.naV);
                }
                if (this.mZj != null) {
                    c6093a.mo13475e(3, this.mZj);
                }
                c6093a.mo13471aO(4, this.naW);
                c6093a.mo13471aO(5, this.naX);
                if (this.naY != null) {
                    c6093a.mo13475e(6, this.naY);
                }
                if (this.naZ != null) {
                    c6093a.mo13475e(7, this.naZ);
                }
                c6093a.mo13480iz(8, this.nba);
                c6093a.mo13480iz(9, this.mZN);
                if (this.mZL != null) {
                    c6093a.mo13475e(10, this.mZL);
                }
                AppMethodBeat.m2505o(111577);
                return 0;
            }
        } else if (i == 1) {
            if (this.Title != null) {
                f = C6091a.m9575f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            if (this.naV != null) {
                f += C6091a.m9575f(2, this.naV);
            }
            if (this.mZj != null) {
                f += C6091a.m9575f(3, this.mZj);
            }
            f = (f + (C6091a.m9576fv(4) + 1)) + (C6091a.m9576fv(5) + 1);
            if (this.naY != null) {
                f += C6091a.m9575f(6, this.naY);
            }
            if (this.naZ != null) {
                f += C6091a.m9575f(7, this.naZ);
            }
            f = (f + C6091a.m9572bs(8, this.nba)) + C6091a.m9572bs(9, this.mZN);
            if (this.mZL != null) {
                f += C6091a.m9575f(10, this.mZL);
            }
            AppMethodBeat.m2505o(111577);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.Title == null) {
                c6092b = new C6092b("Not all required fields were included: Title");
                AppMethodBeat.m2505o(111577);
                throw c6092b;
            } else if (this.naV == null) {
                c6092b = new C6092b("Not all required fields were included: NavKey");
                AppMethodBeat.m2505o(111577);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(111577);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C12111al c12111al = (C12111al) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c12111al.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111577);
                    return 0;
                case 2:
                    c12111al.naV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111577);
                    return 0;
                case 3:
                    c12111al.mZj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111577);
                    return 0;
                case 4:
                    c12111al.naW = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(111577);
                    return 0;
                case 5:
                    c12111al.naX = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(111577);
                    return 0;
                case 6:
                    c12111al.naY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111577);
                    return 0;
                case 7:
                    c12111al.naZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111577);
                    return 0;
                case 8:
                    c12111al.nba = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111577);
                    return 0;
                case 9:
                    c12111al.mZN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111577);
                    return 0;
                case 10:
                    c12111al.mZL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111577);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111577);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111577);
            return -1;
        }
    }
}
