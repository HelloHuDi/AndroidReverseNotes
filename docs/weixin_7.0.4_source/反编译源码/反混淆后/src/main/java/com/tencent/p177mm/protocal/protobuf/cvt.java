package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cvt */
public final class cvt extends C1331a {
    public LinkedList<cvq> xrI = new LinkedList();
    public boolean xrJ;

    public cvt() {
        AppMethodBeat.m2504i(63700);
        AppMethodBeat.m2505o(63700);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(63701);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 8, this.xrI);
            c6093a.mo13471aO(2, this.xrJ);
            AppMethodBeat.m2505o(63701);
            return 0;
        } else if (i == 1) {
            c = (C6087a.m9552c(1, 8, this.xrI) + 0) + (C6091a.m9576fv(2) + 1);
            AppMethodBeat.m2505o(63701);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xrI.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(63701);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cvt cvt = (cvt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cvq cvq = new cvq();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cvq.populateBuilderWithField(c6086a3, cvq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cvt.xrI.add(cvq);
                    }
                    AppMethodBeat.m2505o(63701);
                    return 0;
                case 2:
                    cvt.xrJ = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(63701);
                    return 0;
                default:
                    AppMethodBeat.m2505o(63701);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(63701);
            return -1;
        }
    }
}
