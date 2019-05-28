package com.tencent.p177mm.plugin.wallet.p748a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.wallet.a.p */
public final class C14101p extends C1331a {
    public String fjD;
    /* renamed from: id */
    public int f2951id;
    public String name;
    public String tmN;
    public String url;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56659);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.f2951id);
            if (this.name != null) {
                c6093a.mo13475e(2, this.name);
            }
            if (this.url != null) {
                c6093a.mo13475e(3, this.url);
            }
            if (this.tmN != null) {
                c6093a.mo13475e(4, this.tmN);
            }
            if (this.fjD != null) {
                c6093a.mo13475e(5, this.fjD);
            }
            AppMethodBeat.m2505o(56659);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.f2951id) + 0;
            if (this.name != null) {
                bs += C6091a.m9575f(2, this.name);
            }
            if (this.url != null) {
                bs += C6091a.m9575f(3, this.url);
            }
            if (this.tmN != null) {
                bs += C6091a.m9575f(4, this.tmN);
            }
            if (this.fjD != null) {
                bs += C6091a.m9575f(5, this.fjD);
            }
            AppMethodBeat.m2505o(56659);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56659);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C14101p c14101p = (C14101p) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c14101p.f2951id = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56659);
                    return 0;
                case 2:
                    c14101p.name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56659);
                    return 0;
                case 3:
                    c14101p.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56659);
                    return 0;
                case 4:
                    c14101p.tmN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56659);
                    return 0;
                case 5:
                    c14101p.fjD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56659);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56659);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56659);
            return -1;
        }
    }
}
