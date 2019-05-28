package com.tencent.p177mm.plugin.product.p737c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.product.c.a */
public final class C28671a extends C1331a {
    public String IconUrl;
    public String Name;
    public int jCt;
    public String ncM;
    public String phA;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56621);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Name != null) {
                c6093a.mo13475e(1, this.Name);
            }
            if (this.phA != null) {
                c6093a.mo13475e(2, this.phA);
            }
            c6093a.mo13480iz(3, this.jCt);
            if (this.ncM != null) {
                c6093a.mo13475e(4, this.ncM);
            }
            if (this.IconUrl != null) {
                c6093a.mo13475e(5, this.IconUrl);
            }
            AppMethodBeat.m2505o(56621);
            return 0;
        } else if (i == 1) {
            if (this.Name != null) {
                f = C6091a.m9575f(1, this.Name) + 0;
            } else {
                f = 0;
            }
            if (this.phA != null) {
                f += C6091a.m9575f(2, this.phA);
            }
            f += C6091a.m9572bs(3, this.jCt);
            if (this.ncM != null) {
                f += C6091a.m9575f(4, this.ncM);
            }
            if (this.IconUrl != null) {
                f += C6091a.m9575f(5, this.IconUrl);
            }
            AppMethodBeat.m2505o(56621);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56621);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C28671a c28671a = (C28671a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c28671a.Name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56621);
                    return 0;
                case 2:
                    c28671a.phA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56621);
                    return 0;
                case 3:
                    c28671a.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56621);
                    return 0;
                case 4:
                    c28671a.ncM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56621);
                    return 0;
                case 5:
                    c28671a.IconUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56621);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56621);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56621);
            return -1;
        }
    }
}
