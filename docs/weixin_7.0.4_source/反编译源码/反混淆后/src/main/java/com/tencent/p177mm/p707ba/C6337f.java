package com.tencent.p177mm.p707ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.ba.f */
public final class C6337f extends C1331a {
    public LinkedList<C45180d> fMi = new LinkedList();
    public double fMj;

    public C6337f() {
        AppMethodBeat.m2504i(78443);
        AppMethodBeat.m2505o(78443);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(78444);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 8, this.fMi);
            c6093a.mo13476f(2, this.fMj);
            AppMethodBeat.m2505o(78444);
            return 0;
        } else if (i == 1) {
            c = (C6087a.m9552c(1, 8, this.fMi) + 0) + (C6091a.m9576fv(2) + 8);
            AppMethodBeat.m2505o(78444);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.fMi.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(78444);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C6337f c6337f = (C6337f) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C45180d c45180d = new C45180d();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c45180d.populateBuilderWithField(c6086a3, c45180d, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c6337f.fMi.add(c45180d);
                    }
                    AppMethodBeat.m2505o(78444);
                    return 0;
                case 2:
                    c6337f.fMj = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(78444);
                    return 0;
                default:
                    AppMethodBeat.m2505o(78444);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(78444);
            return -1;
        }
    }
}
