package com.tencent.p177mm.plugin.wallet.p748a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.wallet.a.e */
public final class C40050e extends C1331a {
    public String fjD;
    public String name;
    public String tmN;
    public String url;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56646);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.url != null) {
                c6093a.mo13475e(1, this.url);
            }
            if (this.name != null) {
                c6093a.mo13475e(2, this.name);
            }
            if (this.tmN != null) {
                c6093a.mo13475e(3, this.tmN);
            }
            if (this.fjD != null) {
                c6093a.mo13475e(4, this.fjD);
            }
            AppMethodBeat.m2505o(56646);
            return 0;
        } else if (i == 1) {
            if (this.url != null) {
                f = C6091a.m9575f(1, this.url) + 0;
            } else {
                f = 0;
            }
            if (this.name != null) {
                f += C6091a.m9575f(2, this.name);
            }
            if (this.tmN != null) {
                f += C6091a.m9575f(3, this.tmN);
            }
            if (this.fjD != null) {
                f += C6091a.m9575f(4, this.fjD);
            }
            AppMethodBeat.m2505o(56646);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56646);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40050e c40050e = (C40050e) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c40050e.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56646);
                    return 0;
                case 2:
                    c40050e.name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56646);
                    return 0;
                case 3:
                    c40050e.tmN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56646);
                    return 0;
                case 4:
                    c40050e.fjD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56646);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56646);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56646);
            return -1;
        }
    }
}
