package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.ca */
public final class C39192ca extends C1331a {
    public String Title;
    public String ncM;
    public LinkedList<String> ncN = new LinkedList();

    public C39192ca() {
        AppMethodBeat.m2504i(111634);
        AppMethodBeat.m2505o(111634);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111635);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Title != null) {
                c6093a.mo13475e(1, this.Title);
            }
            if (this.ncM != null) {
                c6093a.mo13475e(2, this.ncM);
            }
            c6093a.mo13474e(3, 1, this.ncN);
            AppMethodBeat.m2505o(111635);
            return 0;
        } else if (i == 1) {
            if (this.Title != null) {
                f = C6091a.m9575f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            if (this.ncM != null) {
                f += C6091a.m9575f(2, this.ncM);
            }
            int c = f + C6087a.m9552c(3, 1, this.ncN);
            AppMethodBeat.m2505o(111635);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.ncN.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111635);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C39192ca c39192ca = (C39192ca) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c39192ca.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111635);
                    return 0;
                case 2:
                    c39192ca.ncM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111635);
                    return 0;
                case 3:
                    c39192ca.ncN.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(111635);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111635);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111635);
            return -1;
        }
    }
}
