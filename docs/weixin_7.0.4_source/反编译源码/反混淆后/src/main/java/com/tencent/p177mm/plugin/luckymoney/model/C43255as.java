package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.as */
public final class C43255as extends C1331a {
    public String content;
    public int erD;
    public String iconUrl;
    public int nZn;
    public int nZo;
    public String name;
    public String type;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56616);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.erD);
            if (this.name != null) {
                c6093a.mo13475e(2, this.name);
            }
            if (this.type != null) {
                c6093a.mo13475e(3, this.type);
            }
            if (this.content != null) {
                c6093a.mo13475e(4, this.content);
            }
            c6093a.mo13480iz(5, this.nZn);
            if (this.iconUrl != null) {
                c6093a.mo13475e(6, this.iconUrl);
            }
            c6093a.mo13480iz(7, this.nZo);
            AppMethodBeat.m2505o(56616);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.erD) + 0;
            if (this.name != null) {
                bs += C6091a.m9575f(2, this.name);
            }
            if (this.type != null) {
                bs += C6091a.m9575f(3, this.type);
            }
            if (this.content != null) {
                bs += C6091a.m9575f(4, this.content);
            }
            bs += C6091a.m9572bs(5, this.nZn);
            if (this.iconUrl != null) {
                bs += C6091a.m9575f(6, this.iconUrl);
            }
            bs += C6091a.m9572bs(7, this.nZo);
            AppMethodBeat.m2505o(56616);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56616);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C43255as c43255as = (C43255as) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c43255as.erD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56616);
                    return 0;
                case 2:
                    c43255as.name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56616);
                    return 0;
                case 3:
                    c43255as.type = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56616);
                    return 0;
                case 4:
                    c43255as.content = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56616);
                    return 0;
                case 5:
                    c43255as.nZn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56616);
                    return 0;
                case 6:
                    c43255as.iconUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56616);
                    return 0;
                case 7:
                    c43255as.nZo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56616);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56616);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56616);
            return -1;
        }
    }
}
