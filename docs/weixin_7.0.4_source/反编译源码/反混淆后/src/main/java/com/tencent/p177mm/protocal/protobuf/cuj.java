package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cuj */
public final class cuj extends C1331a {
    public LinkedList<cuc> wtc = new LinkedList();
    public boolean xqq;

    public cuj() {
        AppMethodBeat.m2504i(28749);
        AppMethodBeat.m2505o(28749);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28750);
        int fv;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13471aO(1, this.xqq);
            c6093a.mo13474e(2, 8, this.wtc);
            AppMethodBeat.m2505o(28750);
            return 0;
        } else if (i == 1) {
            fv = ((C6091a.m9576fv(1) + 1) + 0) + C6087a.m9552c(2, 8, this.wtc);
            AppMethodBeat.m2505o(28750);
            return fv;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wtc.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (fv = C1331a.getNextFieldNumber(c6086a); fv > 0; fv = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, fv)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28750);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cuj cuj = (cuj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cuj.xqq = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(28750);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cuc cuc = new cuc();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cuc.populateBuilderWithField(c6086a3, cuc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cuj.wtc.add(cuc);
                    }
                    AppMethodBeat.m2505o(28750);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28750);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28750);
            return -1;
        }
    }
}
