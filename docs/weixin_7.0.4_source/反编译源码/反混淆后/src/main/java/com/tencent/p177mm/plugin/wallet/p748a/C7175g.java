package com.tencent.p177mm.plugin.wallet.p748a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.wallet.a.g */
public final class C7175g extends C1331a {
    public C40051m tmC;
    public String tmE;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56648);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.tmC != null) {
                c6093a.mo13479iy(1, this.tmC.computeSize());
                this.tmC.writeFields(c6093a);
            }
            if (this.tmE != null) {
                c6093a.mo13475e(2, this.tmE);
            }
            AppMethodBeat.m2505o(56648);
            return 0;
        } else if (i == 1) {
            if (this.tmC != null) {
                ix = C6087a.m9557ix(1, this.tmC.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.tmE != null) {
                ix += C6091a.m9575f(2, this.tmE);
            }
            AppMethodBeat.m2505o(56648);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56648);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7175g c7175g = (C7175g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C40051m c40051m = new C40051m();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c40051m.populateBuilderWithField(c6086a3, c40051m, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7175g.tmC = c40051m;
                    }
                    AppMethodBeat.m2505o(56648);
                    return 0;
                case 2:
                    c7175g.tmE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56648);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56648);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56648);
            return -1;
        }
    }
}
