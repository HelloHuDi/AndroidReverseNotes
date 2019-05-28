package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bif */
public final class bif extends C1331a {
    public float bottom;
    public float left;
    public float right;
    public float top;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48916);
        int fv;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13481r(1, this.top);
            c6093a.mo13481r(2, this.bottom);
            c6093a.mo13481r(3, this.left);
            c6093a.mo13481r(4, this.right);
            AppMethodBeat.m2505o(48916);
            return 0;
        } else if (i == 1) {
            fv = ((((C6091a.m9576fv(1) + 4) + 0) + (C6091a.m9576fv(2) + 4)) + (C6091a.m9576fv(3) + 4)) + (C6091a.m9576fv(4) + 4);
            AppMethodBeat.m2505o(48916);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (fv = C1331a.getNextFieldNumber(c6086a); fv > 0; fv = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, fv)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48916);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bif bif = (bif) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bif.top = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(48916);
                    return 0;
                case 2:
                    bif.bottom = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(48916);
                    return 0;
                case 3:
                    bif.left = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(48916);
                    return 0;
                case 4:
                    bif.right = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(48916);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48916);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48916);
            return -1;
        }
    }
}
