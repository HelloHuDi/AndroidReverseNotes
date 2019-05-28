package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bac */
public final class bac extends C1331a {
    public String fjx;
    public String fjz;
    public String title;
    public String wDU;
    public String wDV;
    public String wDW;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14732);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.title != null) {
                c6093a.mo13475e(1, this.title);
            }
            if (this.fjz != null) {
                c6093a.mo13475e(2, this.fjz);
            }
            if (this.fjx != null) {
                c6093a.mo13475e(3, this.fjx);
            }
            if (this.wDU != null) {
                c6093a.mo13475e(4, this.wDU);
            }
            if (this.wDV != null) {
                c6093a.mo13475e(5, this.wDV);
            }
            if (this.wDW != null) {
                c6093a.mo13475e(6, this.wDW);
            }
            AppMethodBeat.m2505o(14732);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = C6091a.m9575f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.fjz != null) {
                f += C6091a.m9575f(2, this.fjz);
            }
            if (this.fjx != null) {
                f += C6091a.m9575f(3, this.fjx);
            }
            if (this.wDU != null) {
                f += C6091a.m9575f(4, this.wDU);
            }
            if (this.wDV != null) {
                f += C6091a.m9575f(5, this.wDV);
            }
            if (this.wDW != null) {
                f += C6091a.m9575f(6, this.wDW);
            }
            AppMethodBeat.m2505o(14732);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(14732);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bac bac = (bac) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bac.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14732);
                    return 0;
                case 2:
                    bac.fjz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14732);
                    return 0;
                case 3:
                    bac.fjx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14732);
                    return 0;
                case 4:
                    bac.wDU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14732);
                    return 0;
                case 5:
                    bac.wDV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14732);
                    return 0;
                case 6:
                    bac.wDW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14732);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14732);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14732);
            return -1;
        }
    }
}
