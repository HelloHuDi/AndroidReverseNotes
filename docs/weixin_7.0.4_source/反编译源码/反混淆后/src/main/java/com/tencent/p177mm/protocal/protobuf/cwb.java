package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cwb */
public final class cwb extends C1331a {
    public LinkedList<C15324cdn> xrV = new LinkedList();
    public C1332b xrW;

    public cwb() {
        AppMethodBeat.m2504i(28769);
        AppMethodBeat.m2505o(28769);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28770);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 8, this.xrV);
            if (this.xrW != null) {
                c6093a.mo13473c(2, this.xrW);
            }
            AppMethodBeat.m2505o(28770);
            return 0;
        } else if (i == 1) {
            c = C6087a.m9552c(1, 8, this.xrV) + 0;
            if (this.xrW != null) {
                c += C6091a.m9571b(2, this.xrW);
            }
            AppMethodBeat.m2505o(28770);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xrV.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28770);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cwb cwb = (cwb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15324cdn c15324cdn = new C15324cdn();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c15324cdn.populateBuilderWithField(c6086a3, c15324cdn, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cwb.xrV.add(c15324cdn);
                    }
                    AppMethodBeat.m2505o(28770);
                    return 0;
                case 2:
                    cwb.xrW = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(28770);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28770);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28770);
            return -1;
        }
    }
}
