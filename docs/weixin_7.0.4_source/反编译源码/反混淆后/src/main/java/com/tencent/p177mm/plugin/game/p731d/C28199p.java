package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.p */
public final class C28199p extends C1331a {
    public String mZZ;
    public String naa;
    public String nab;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111555);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.mZZ != null) {
                c6093a.mo13475e(1, this.mZZ);
            }
            if (this.naa != null) {
                c6093a.mo13475e(2, this.naa);
            }
            if (this.nab != null) {
                c6093a.mo13475e(3, this.nab);
            }
            AppMethodBeat.m2505o(111555);
            return 0;
        } else if (i == 1) {
            if (this.mZZ != null) {
                f = C6091a.m9575f(1, this.mZZ) + 0;
            } else {
                f = 0;
            }
            if (this.naa != null) {
                f += C6091a.m9575f(2, this.naa);
            }
            if (this.nab != null) {
                f += C6091a.m9575f(3, this.nab);
            }
            AppMethodBeat.m2505o(111555);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111555);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C28199p c28199p = (C28199p) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c28199p.mZZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111555);
                    return 0;
                case 2:
                    c28199p.naa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111555);
                    return 0;
                case 3:
                    c28199p.nab = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111555);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111555);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111555);
            return -1;
        }
    }
}
