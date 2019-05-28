package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.k */
public final class C20957k extends C1331a {
    public String Url;
    public String mZR;
    public String mZS;
    public String mZT;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111551);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.mZR == null) {
                c6092b = new C6092b("Not all required fields were included: Message");
                AppMethodBeat.m2505o(111551);
                throw c6092b;
            } else if (this.mZS == null) {
                c6092b = new C6092b("Not all required fields were included: GotoBtn");
                AppMethodBeat.m2505o(111551);
                throw c6092b;
            } else if (this.mZT == null) {
                c6092b = new C6092b("Not all required fields were included: CancelBtn");
                AppMethodBeat.m2505o(111551);
                throw c6092b;
            } else if (this.Url == null) {
                c6092b = new C6092b("Not all required fields were included: Url");
                AppMethodBeat.m2505o(111551);
                throw c6092b;
            } else {
                if (this.mZR != null) {
                    c6093a.mo13475e(1, this.mZR);
                }
                if (this.mZS != null) {
                    c6093a.mo13475e(2, this.mZS);
                }
                if (this.mZT != null) {
                    c6093a.mo13475e(3, this.mZT);
                }
                if (this.Url != null) {
                    c6093a.mo13475e(4, this.Url);
                }
                AppMethodBeat.m2505o(111551);
                return 0;
            }
        } else if (i == 1) {
            if (this.mZR != null) {
                f = C6091a.m9575f(1, this.mZR) + 0;
            } else {
                f = 0;
            }
            if (this.mZS != null) {
                f += C6091a.m9575f(2, this.mZS);
            }
            if (this.mZT != null) {
                f += C6091a.m9575f(3, this.mZT);
            }
            if (this.Url != null) {
                f += C6091a.m9575f(4, this.Url);
            }
            AppMethodBeat.m2505o(111551);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.mZR == null) {
                c6092b = new C6092b("Not all required fields were included: Message");
                AppMethodBeat.m2505o(111551);
                throw c6092b;
            } else if (this.mZS == null) {
                c6092b = new C6092b("Not all required fields were included: GotoBtn");
                AppMethodBeat.m2505o(111551);
                throw c6092b;
            } else if (this.mZT == null) {
                c6092b = new C6092b("Not all required fields were included: CancelBtn");
                AppMethodBeat.m2505o(111551);
                throw c6092b;
            } else if (this.Url == null) {
                c6092b = new C6092b("Not all required fields were included: Url");
                AppMethodBeat.m2505o(111551);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(111551);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C20957k c20957k = (C20957k) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c20957k.mZR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111551);
                    return 0;
                case 2:
                    c20957k.mZS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111551);
                    return 0;
                case 3:
                    c20957k.mZT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111551);
                    return 0;
                case 4:
                    c20957k.Url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111551);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111551);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111551);
            return -1;
        }
    }
}
