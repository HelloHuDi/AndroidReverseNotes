package com.tencent.p177mm.plugin.address.p1534d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.address.d.b */
public final class C38090b extends C1331a {
    public String gIZ;
    public String gJa;
    public String gJb;
    public String gJc;
    public String gJd;
    public String gJe;
    public String gJf;
    public String gJg;
    public String gJh;
    /* renamed from: id */
    public int f16139id;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(16786);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.f16139id);
            if (this.gIZ != null) {
                c6093a.mo13475e(2, this.gIZ);
            }
            if (this.gJa != null) {
                c6093a.mo13475e(3, this.gJa);
            }
            if (this.gJb != null) {
                c6093a.mo13475e(4, this.gJb);
            }
            if (this.gJc != null) {
                c6093a.mo13475e(5, this.gJc);
            }
            if (this.gJd != null) {
                c6093a.mo13475e(6, this.gJd);
            }
            if (this.gJe != null) {
                c6093a.mo13475e(7, this.gJe);
            }
            if (this.gJf != null) {
                c6093a.mo13475e(8, this.gJf);
            }
            if (this.gJg != null) {
                c6093a.mo13475e(9, this.gJg);
            }
            if (this.gJh != null) {
                c6093a.mo13475e(10, this.gJh);
            }
            AppMethodBeat.m2505o(16786);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.f16139id) + 0;
            if (this.gIZ != null) {
                bs += C6091a.m9575f(2, this.gIZ);
            }
            if (this.gJa != null) {
                bs += C6091a.m9575f(3, this.gJa);
            }
            if (this.gJb != null) {
                bs += C6091a.m9575f(4, this.gJb);
            }
            if (this.gJc != null) {
                bs += C6091a.m9575f(5, this.gJc);
            }
            if (this.gJd != null) {
                bs += C6091a.m9575f(6, this.gJd);
            }
            if (this.gJe != null) {
                bs += C6091a.m9575f(7, this.gJe);
            }
            if (this.gJf != null) {
                bs += C6091a.m9575f(8, this.gJf);
            }
            if (this.gJg != null) {
                bs += C6091a.m9575f(9, this.gJg);
            }
            if (this.gJh != null) {
                bs += C6091a.m9575f(10, this.gJh);
            }
            AppMethodBeat.m2505o(16786);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(16786);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C38090b c38090b = (C38090b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c38090b.f16139id = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(16786);
                    return 0;
                case 2:
                    c38090b.gIZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(16786);
                    return 0;
                case 3:
                    c38090b.gJa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(16786);
                    return 0;
                case 4:
                    c38090b.gJb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(16786);
                    return 0;
                case 5:
                    c38090b.gJc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(16786);
                    return 0;
                case 6:
                    c38090b.gJd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(16786);
                    return 0;
                case 7:
                    c38090b.gJe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(16786);
                    return 0;
                case 8:
                    c38090b.gJf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(16786);
                    return 0;
                case 9:
                    c38090b.gJg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(16786);
                    return 0;
                case 10:
                    c38090b.gJh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(16786);
                    return 0;
                default:
                    AppMethodBeat.m2505o(16786);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(16786);
            return -1;
        }
    }
}
