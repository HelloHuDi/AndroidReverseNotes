package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.da */
public final class C34275da extends C1331a {
    public String mZm;
    public String mZs;
    public boolean ndA;
    public boolean ndB;
    public String ndx;
    public String ndy;
    public String ndz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111668);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.mZs != null) {
                c6093a.mo13475e(1, this.mZs);
            }
            if (this.ndx != null) {
                c6093a.mo13475e(2, this.ndx);
            }
            if (this.ndy != null) {
                c6093a.mo13475e(3, this.ndy);
            }
            if (this.ndz != null) {
                c6093a.mo13475e(4, this.ndz);
            }
            if (this.mZm != null) {
                c6093a.mo13475e(5, this.mZm);
            }
            c6093a.mo13471aO(6, this.ndA);
            c6093a.mo13471aO(7, this.ndB);
            AppMethodBeat.m2505o(111668);
            return 0;
        } else if (i == 1) {
            if (this.mZs != null) {
                f = C6091a.m9575f(1, this.mZs) + 0;
            } else {
                f = 0;
            }
            if (this.ndx != null) {
                f += C6091a.m9575f(2, this.ndx);
            }
            if (this.ndy != null) {
                f += C6091a.m9575f(3, this.ndy);
            }
            if (this.ndz != null) {
                f += C6091a.m9575f(4, this.ndz);
            }
            if (this.mZm != null) {
                f += C6091a.m9575f(5, this.mZm);
            }
            int fv = (f + (C6091a.m9576fv(6) + 1)) + (C6091a.m9576fv(7) + 1);
            AppMethodBeat.m2505o(111668);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111668);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C34275da c34275da = (C34275da) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c34275da.mZs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111668);
                    return 0;
                case 2:
                    c34275da.ndx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111668);
                    return 0;
                case 3:
                    c34275da.ndy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111668);
                    return 0;
                case 4:
                    c34275da.ndz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111668);
                    return 0;
                case 5:
                    c34275da.mZm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111668);
                    return 0;
                case 6:
                    c34275da.ndA = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(111668);
                    return 0;
                case 7:
                    c34275da.ndB = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(111668);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111668);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111668);
            return -1;
        }
    }
}
