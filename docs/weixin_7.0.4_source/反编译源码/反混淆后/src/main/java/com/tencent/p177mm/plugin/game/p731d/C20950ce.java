package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.ce */
public final class C20950ce extends C1331a {
    public String Title;
    public String mZm;
    public String mZs;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111640);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.mZs == null) {
                c6092b = new C6092b("Not all required fields were included: IconURL");
                AppMethodBeat.m2505o(111640);
                throw c6092b;
            }
            if (this.mZs != null) {
                c6093a.mo13475e(1, this.mZs);
            }
            if (this.Title != null) {
                c6093a.mo13475e(2, this.Title);
            }
            if (this.mZm != null) {
                c6093a.mo13475e(3, this.mZm);
            }
            AppMethodBeat.m2505o(111640);
            return 0;
        } else if (i == 1) {
            if (this.mZs != null) {
                f = C6091a.m9575f(1, this.mZs) + 0;
            } else {
                f = 0;
            }
            if (this.Title != null) {
                f += C6091a.m9575f(2, this.Title);
            }
            if (this.mZm != null) {
                f += C6091a.m9575f(3, this.mZm);
            }
            AppMethodBeat.m2505o(111640);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.mZs == null) {
                c6092b = new C6092b("Not all required fields were included: IconURL");
                AppMethodBeat.m2505o(111640);
                throw c6092b;
            }
            AppMethodBeat.m2505o(111640);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C20950ce c20950ce = (C20950ce) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c20950ce.mZs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111640);
                    return 0;
                case 2:
                    c20950ce.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111640);
                    return 0;
                case 3:
                    c20950ce.mZm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111640);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111640);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111640);
            return -1;
        }
    }
}
