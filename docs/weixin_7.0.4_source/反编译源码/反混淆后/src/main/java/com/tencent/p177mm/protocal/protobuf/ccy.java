package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ccy */
public final class ccy extends C1331a {
    public int xcC;
    public int xcD;
    public int xcE;
    public int xcg;
    public coj xch;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5223);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xch == null) {
                c6092b = new C6092b("Not all required fields were included: Addr");
                AppMethodBeat.m2505o(5223);
                throw c6092b;
            }
            if (this.xch != null) {
                c6093a.mo13479iy(1, this.xch.computeSize());
                this.xch.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.xcg);
            c6093a.mo13480iz(3, this.xcC);
            c6093a.mo13480iz(4, this.xcD);
            c6093a.mo13480iz(5, this.xcE);
            AppMethodBeat.m2505o(5223);
            return 0;
        } else if (i == 1) {
            if (this.xch != null) {
                ix = C6087a.m9557ix(1, this.xch.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = (((ix + C6091a.m9572bs(2, this.xcg)) + C6091a.m9572bs(3, this.xcC)) + C6091a.m9572bs(4, this.xcD)) + C6091a.m9572bs(5, this.xcE);
            AppMethodBeat.m2505o(5223);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.xch == null) {
                c6092b = new C6092b("Not all required fields were included: Addr");
                AppMethodBeat.m2505o(5223);
                throw c6092b;
            }
            AppMethodBeat.m2505o(5223);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ccy ccy = (ccy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        coj coj = new coj();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = coj.populateBuilderWithField(c6086a3, coj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ccy.xch = coj;
                    }
                    AppMethodBeat.m2505o(5223);
                    return 0;
                case 2:
                    ccy.xcg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5223);
                    return 0;
                case 3:
                    ccy.xcC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5223);
                    return 0;
                case 4:
                    ccy.xcD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5223);
                    return 0;
                case 5:
                    ccy.xcE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5223);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5223);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5223);
            return -1;
        }
    }
}
