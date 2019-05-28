package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cre */
public final class cre extends C1331a {
    public LinkedList<cra> xoN = new LinkedList();
    public String xot;

    public cre() {
        AppMethodBeat.m2504i(102414);
        AppMethodBeat.m2505o(102414);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(102415);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xot != null) {
                c6093a.mo13475e(1, this.xot);
            }
            c6093a.mo13474e(2, 8, this.xoN);
            AppMethodBeat.m2505o(102415);
            return 0;
        } else if (i == 1) {
            if (this.xot != null) {
                f = C6091a.m9575f(1, this.xot) + 0;
            } else {
                f = 0;
            }
            int c = f + C6087a.m9552c(2, 8, this.xoN);
            AppMethodBeat.m2505o(102415);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xoN.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(102415);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cre cre = (cre) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cre.xot = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102415);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cra cra = new cra();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cra.populateBuilderWithField(c6086a3, cra, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cre.xoN.add(cra);
                    }
                    AppMethodBeat.m2505o(102415);
                    return 0;
                default:
                    AppMethodBeat.m2505o(102415);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(102415);
            return -1;
        }
    }
}
