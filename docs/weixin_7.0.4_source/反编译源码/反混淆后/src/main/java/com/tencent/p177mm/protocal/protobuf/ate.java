package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ate */
public final class ate extends C1331a {
    public int wxc;
    public LinkedList<bdf> wxd = new LinkedList();
    public int wxe;

    public ate() {
        AppMethodBeat.m2504i(72853);
        AppMethodBeat.m2505o(72853);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(72854);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.wxc);
            c6093a.mo13474e(2, 8, this.wxd);
            c6093a.mo13480iz(3, this.wxe);
            AppMethodBeat.m2505o(72854);
            return 0;
        } else if (i == 1) {
            bs = ((C6091a.m9572bs(1, this.wxc) + 0) + C6087a.m9552c(2, 8, this.wxd)) + C6091a.m9572bs(3, this.wxe);
            AppMethodBeat.m2505o(72854);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wxd.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(72854);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ate ate = (ate) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ate.wxc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72854);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdf bdf = new bdf();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bdf.populateBuilderWithField(c6086a3, bdf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ate.wxd.add(bdf);
                    }
                    AppMethodBeat.m2505o(72854);
                    return 0;
                case 3:
                    ate.wxe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72854);
                    return 0;
                default:
                    AppMethodBeat.m2505o(72854);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(72854);
            return -1;
        }
    }
}
