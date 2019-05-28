package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.ds */
public final class C43170ds extends C1331a {
    public String nac;
    public String ndR;
    public String ndS;
    public String ndT;
    public String ndU;
    public int ndV;
    public String ndW;
    public String ndX;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111683);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.nac != null) {
                c6093a.mo13475e(1, this.nac);
            }
            if (this.ndR != null) {
                c6093a.mo13475e(2, this.ndR);
            }
            if (this.ndS != null) {
                c6093a.mo13475e(3, this.ndS);
            }
            if (this.ndT != null) {
                c6093a.mo13475e(4, this.ndT);
            }
            if (this.ndU != null) {
                c6093a.mo13475e(5, this.ndU);
            }
            c6093a.mo13480iz(6, this.ndV);
            if (this.ndW != null) {
                c6093a.mo13475e(7, this.ndW);
            }
            if (this.ndX != null) {
                c6093a.mo13475e(8, this.ndX);
            }
            AppMethodBeat.m2505o(111683);
            return 0;
        } else if (i == 1) {
            if (this.nac != null) {
                f = C6091a.m9575f(1, this.nac) + 0;
            } else {
                f = 0;
            }
            if (this.ndR != null) {
                f += C6091a.m9575f(2, this.ndR);
            }
            if (this.ndS != null) {
                f += C6091a.m9575f(3, this.ndS);
            }
            if (this.ndT != null) {
                f += C6091a.m9575f(4, this.ndT);
            }
            if (this.ndU != null) {
                f += C6091a.m9575f(5, this.ndU);
            }
            f += C6091a.m9572bs(6, this.ndV);
            if (this.ndW != null) {
                f += C6091a.m9575f(7, this.ndW);
            }
            if (this.ndX != null) {
                f += C6091a.m9575f(8, this.ndX);
            }
            AppMethodBeat.m2505o(111683);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111683);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C43170ds c43170ds = (C43170ds) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c43170ds.nac = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111683);
                    return 0;
                case 2:
                    c43170ds.ndR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111683);
                    return 0;
                case 3:
                    c43170ds.ndS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111683);
                    return 0;
                case 4:
                    c43170ds.ndT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111683);
                    return 0;
                case 5:
                    c43170ds.ndU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111683);
                    return 0;
                case 6:
                    c43170ds.ndV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111683);
                    return 0;
                case 7:
                    c43170ds.ndW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111683);
                    return 0;
                case 8:
                    c43170ds.ndX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111683);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111683);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111683);
            return -1;
        }
    }
}
