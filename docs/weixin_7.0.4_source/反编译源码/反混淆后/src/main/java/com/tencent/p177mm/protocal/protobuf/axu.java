package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.axu */
public final class axu extends C1331a {
    public String kfA;
    public double latitude;
    public double longitude;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(114435);
        int fv;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13476f(1, this.latitude);
            c6093a.mo13476f(2, this.longitude);
            if (this.kfA != null) {
                c6093a.mo13475e(3, this.kfA);
            }
            AppMethodBeat.m2505o(114435);
            return 0;
        } else if (i == 1) {
            fv = ((C6091a.m9576fv(1) + 8) + 0) + (C6091a.m9576fv(2) + 8);
            if (this.kfA != null) {
                fv += C6091a.m9575f(3, this.kfA);
            }
            AppMethodBeat.m2505o(114435);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (fv = C1331a.getNextFieldNumber(c6086a); fv > 0; fv = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, fv)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(114435);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            axu axu = (axu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axu.latitude = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(114435);
                    return 0;
                case 2:
                    axu.longitude = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(114435);
                    return 0;
                case 3:
                    axu.kfA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(114435);
                    return 0;
                default:
                    AppMethodBeat.m2505o(114435);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(114435);
            return -1;
        }
    }
}
