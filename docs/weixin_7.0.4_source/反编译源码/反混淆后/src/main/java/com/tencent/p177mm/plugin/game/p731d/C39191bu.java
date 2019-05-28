package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.bu */
public final class C39191bu extends C1331a {
    public String desc;
    public String ffv;
    public String kLe;
    public String ncD;
    public String title;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111627);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.title != null) {
                c6093a.mo13475e(1, this.title);
            }
            if (this.ffv != null) {
                c6093a.mo13475e(2, this.ffv);
            }
            if (this.kLe != null) {
                c6093a.mo13475e(3, this.kLe);
            }
            if (this.desc != null) {
                c6093a.mo13475e(4, this.desc);
            }
            if (this.ncD != null) {
                c6093a.mo13475e(5, this.ncD);
            }
            AppMethodBeat.m2505o(111627);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = C6091a.m9575f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.ffv != null) {
                f += C6091a.m9575f(2, this.ffv);
            }
            if (this.kLe != null) {
                f += C6091a.m9575f(3, this.kLe);
            }
            if (this.desc != null) {
                f += C6091a.m9575f(4, this.desc);
            }
            if (this.ncD != null) {
                f += C6091a.m9575f(5, this.ncD);
            }
            AppMethodBeat.m2505o(111627);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111627);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C39191bu c39191bu = (C39191bu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c39191bu.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111627);
                    return 0;
                case 2:
                    c39191bu.ffv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111627);
                    return 0;
                case 3:
                    c39191bu.kLe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111627);
                    return 0;
                case 4:
                    c39191bu.desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111627);
                    return 0;
                case 5:
                    c39191bu.ncD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111627);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111627);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111627);
            return -1;
        }
    }
}
