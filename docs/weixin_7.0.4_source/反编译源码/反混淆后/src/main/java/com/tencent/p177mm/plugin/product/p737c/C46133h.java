package com.tencent.p177mm.plugin.product.p737c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.product.c.h */
public final class C46133h extends C1331a {
    /* renamed from: id */
    public String f17901id;
    public String name;
    public boolean phS;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56631);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.f17901id != null) {
                c6093a.mo13475e(1, this.f17901id);
            }
            if (this.name != null) {
                c6093a.mo13475e(2, this.name);
            }
            c6093a.mo13471aO(3, this.phS);
            AppMethodBeat.m2505o(56631);
            return 0;
        } else if (i == 1) {
            if (this.f17901id != null) {
                f = C6091a.m9575f(1, this.f17901id) + 0;
            } else {
                f = 0;
            }
            if (this.name != null) {
                f += C6091a.m9575f(2, this.name);
            }
            int fv = f + (C6091a.m9576fv(3) + 1);
            AppMethodBeat.m2505o(56631);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56631);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46133h c46133h = (C46133h) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c46133h.f17901id = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56631);
                    return 0;
                case 2:
                    c46133h.name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56631);
                    return 0;
                case 3:
                    c46133h.phS = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(56631);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56631);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56631);
            return -1;
        }
    }
}
