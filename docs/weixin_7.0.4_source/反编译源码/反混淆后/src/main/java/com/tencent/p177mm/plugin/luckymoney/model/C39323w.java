package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.w */
public final class C39323w extends C1331a {
    public String nWX;
    public long nXM;
    public String nXN;
    public String nXZ;
    public String nYa;
    public String nYb;
    public String nYc;
    public String userName;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56615);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.nXZ != null) {
                c6093a.mo13475e(1, this.nXZ);
            }
            if (this.nYa != null) {
                c6093a.mo13475e(2, this.nYa);
            }
            c6093a.mo13472ai(3, this.nXM);
            if (this.nXN != null) {
                c6093a.mo13475e(4, this.nXN);
            }
            if (this.nYb != null) {
                c6093a.mo13475e(5, this.nYb);
            }
            if (this.nWX != null) {
                c6093a.mo13475e(6, this.nWX);
            }
            if (this.nYc != null) {
                c6093a.mo13475e(7, this.nYc);
            }
            if (this.userName != null) {
                c6093a.mo13475e(8, this.userName);
            }
            AppMethodBeat.m2505o(56615);
            return 0;
        } else if (i == 1) {
            if (this.nXZ != null) {
                f = C6091a.m9575f(1, this.nXZ) + 0;
            } else {
                f = 0;
            }
            if (this.nYa != null) {
                f += C6091a.m9575f(2, this.nYa);
            }
            f += C6091a.m9578o(3, this.nXM);
            if (this.nXN != null) {
                f += C6091a.m9575f(4, this.nXN);
            }
            if (this.nYb != null) {
                f += C6091a.m9575f(5, this.nYb);
            }
            if (this.nWX != null) {
                f += C6091a.m9575f(6, this.nWX);
            }
            if (this.nYc != null) {
                f += C6091a.m9575f(7, this.nYc);
            }
            if (this.userName != null) {
                f += C6091a.m9575f(8, this.userName);
            }
            AppMethodBeat.m2505o(56615);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56615);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C39323w c39323w = (C39323w) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c39323w.nXZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56615);
                    return 0;
                case 2:
                    c39323w.nYa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56615);
                    return 0;
                case 3:
                    c39323w.nXM = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56615);
                    return 0;
                case 4:
                    c39323w.nXN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56615);
                    return 0;
                case 5:
                    c39323w.nYb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56615);
                    return 0;
                case 6:
                    c39323w.nWX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56615);
                    return 0;
                case 7:
                    c39323w.nYc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56615);
                    return 0;
                case 8:
                    c39323w.userName = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56615);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56615);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56615);
            return -1;
        }
    }
}
