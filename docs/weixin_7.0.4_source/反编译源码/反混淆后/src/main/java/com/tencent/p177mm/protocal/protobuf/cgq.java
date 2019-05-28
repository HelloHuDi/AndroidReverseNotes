package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cgq */
public final class cgq extends C1331a {
    public boolean xfx = false;
    public LinkedList<C44101be> xfy = new LinkedList();

    public cgq() {
        AppMethodBeat.m2504i(73659);
        AppMethodBeat.m2505o(73659);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(73660);
        int fv;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13471aO(1, this.xfx);
            c6093a.mo13474e(2, 8, this.xfy);
            AppMethodBeat.m2505o(73660);
            return 0;
        } else if (i == 1) {
            fv = ((C6091a.m9576fv(1) + 1) + 0) + C6087a.m9552c(2, 8, this.xfy);
            AppMethodBeat.m2505o(73660);
            return fv;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xfy.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (fv = C1331a.getNextFieldNumber(c6086a); fv > 0; fv = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, fv)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(73660);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cgq cgq = (cgq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cgq.xfx = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(73660);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C44101be c44101be = new C44101be();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c44101be.populateBuilderWithField(c6086a3, c44101be, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cgq.xfy.add(c44101be);
                    }
                    AppMethodBeat.m2505o(73660);
                    return 0;
                default:
                    AppMethodBeat.m2505o(73660);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(73660);
            return -1;
        }
    }
}
