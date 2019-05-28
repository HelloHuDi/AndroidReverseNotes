package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cnw */
public final class cnw extends C1331a {
    public LinkedList<Float> xls = new LinkedList();

    public cnw() {
        AppMethodBeat.m2504i(2534);
        AppMethodBeat.m2505o(2534);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(2535);
        int c;
        if (i == 0) {
            ((C6093a) objArr[0]).mo13474e(1, 5, this.xls);
            AppMethodBeat.m2505o(2535);
            return 0;
        } else if (i == 1) {
            c = C6087a.m9552c(1, 5, this.xls) + 0;
            AppMethodBeat.m2505o(2535);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.xls.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(2535);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cnw cnw = (cnw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cnw.xls.add(Float.valueOf(Float.intBitsToFloat(c6086a2.BTU.eia())));
                    AppMethodBeat.m2505o(2535);
                    return 0;
                default:
                    AppMethodBeat.m2505o(2535);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(2535);
            return -1;
        }
    }
}
