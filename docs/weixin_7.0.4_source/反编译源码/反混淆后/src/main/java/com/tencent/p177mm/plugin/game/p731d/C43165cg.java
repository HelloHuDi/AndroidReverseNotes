package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.cg */
public final class C43165cg extends C1331a {
    public String Name;
    public String ncT;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111643);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Name == null) {
                c6092b = new C6092b("Not all required fields were included: Name");
                AppMethodBeat.m2505o(111643);
                throw c6092b;
            } else if (this.ncT == null) {
                c6092b = new C6092b("Not all required fields were included: Color");
                AppMethodBeat.m2505o(111643);
                throw c6092b;
            } else {
                if (this.Name != null) {
                    c6093a.mo13475e(1, this.Name);
                }
                if (this.ncT != null) {
                    c6093a.mo13475e(2, this.ncT);
                }
                AppMethodBeat.m2505o(111643);
                return 0;
            }
        } else if (i == 1) {
            if (this.Name != null) {
                f = C6091a.m9575f(1, this.Name) + 0;
            } else {
                f = 0;
            }
            if (this.ncT != null) {
                f += C6091a.m9575f(2, this.ncT);
            }
            AppMethodBeat.m2505o(111643);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.Name == null) {
                c6092b = new C6092b("Not all required fields were included: Name");
                AppMethodBeat.m2505o(111643);
                throw c6092b;
            } else if (this.ncT == null) {
                c6092b = new C6092b("Not all required fields were included: Color");
                AppMethodBeat.m2505o(111643);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(111643);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C43165cg c43165cg = (C43165cg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c43165cg.Name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111643);
                    return 0;
                case 2:
                    c43165cg.ncT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111643);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111643);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111643);
            return -1;
        }
    }
}
