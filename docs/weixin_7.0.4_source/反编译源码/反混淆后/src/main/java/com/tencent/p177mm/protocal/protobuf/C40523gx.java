package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.gx */
public final class C40523gx extends C1331a {
    public LinkedList<C46546gy> vJA = new LinkedList();
    public boolean vJz;

    public C40523gx() {
        AppMethodBeat.m2504i(56705);
        AppMethodBeat.m2505o(56705);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56706);
        int fv;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13471aO(1, this.vJz);
            c6093a.mo13474e(2, 8, this.vJA);
            AppMethodBeat.m2505o(56706);
            return 0;
        } else if (i == 1) {
            fv = ((C6091a.m9576fv(1) + 1) + 0) + C6087a.m9552c(2, 8, this.vJA);
            AppMethodBeat.m2505o(56706);
            return fv;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vJA.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (fv = C1331a.getNextFieldNumber(c6086a); fv > 0; fv = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, fv)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56706);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40523gx c40523gx = (C40523gx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c40523gx.vJz = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(56706);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46546gy c46546gy = new C46546gy();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c46546gy.populateBuilderWithField(c6086a3, c46546gy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40523gx.vJA.add(c46546gy);
                    }
                    AppMethodBeat.m2505o(56706);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56706);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56706);
            return -1;
        }
    }
}
