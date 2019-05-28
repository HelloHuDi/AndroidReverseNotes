package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.dd */
public final class C39197dd extends C1331a {
    public String color;
    public String mYo;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(117002);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.color != null) {
                c6093a.mo13475e(1, this.color);
            }
            if (this.mYo != null) {
                c6093a.mo13475e(2, this.mYo);
            }
            AppMethodBeat.m2505o(117002);
            return 0;
        } else if (i == 1) {
            if (this.color != null) {
                f = C6091a.m9575f(1, this.color) + 0;
            } else {
                f = 0;
            }
            if (this.mYo != null) {
                f += C6091a.m9575f(2, this.mYo);
            }
            AppMethodBeat.m2505o(117002);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(117002);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C39197dd c39197dd = (C39197dd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c39197dd.color = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(117002);
                    return 0;
                case 2:
                    c39197dd.mYo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(117002);
                    return 0;
                default:
                    AppMethodBeat.m2505o(117002);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(117002);
            return -1;
        }
    }
}
