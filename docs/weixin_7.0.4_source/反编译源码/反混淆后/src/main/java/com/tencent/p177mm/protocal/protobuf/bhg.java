package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bhg */
public final class bhg extends C1331a {
    public String desc;
    public String detail;
    public String title;
    public String wdd;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48907);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.title != null) {
                c6093a.mo13475e(1, this.title);
            }
            if (this.desc != null) {
                c6093a.mo13475e(2, this.desc);
            }
            if (this.wdd != null) {
                c6093a.mo13475e(3, this.wdd);
            }
            if (this.detail != null) {
                c6093a.mo13475e(4, this.detail);
            }
            AppMethodBeat.m2505o(48907);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = C6091a.m9575f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.desc != null) {
                f += C6091a.m9575f(2, this.desc);
            }
            if (this.wdd != null) {
                f += C6091a.m9575f(3, this.wdd);
            }
            if (this.detail != null) {
                f += C6091a.m9575f(4, this.detail);
            }
            AppMethodBeat.m2505o(48907);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48907);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bhg bhg = (bhg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bhg.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48907);
                    return 0;
                case 2:
                    bhg.desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48907);
                    return 0;
                case 3:
                    bhg.wdd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48907);
                    return 0;
                case 4:
                    bhg.detail = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48907);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48907);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48907);
            return -1;
        }
    }
}
