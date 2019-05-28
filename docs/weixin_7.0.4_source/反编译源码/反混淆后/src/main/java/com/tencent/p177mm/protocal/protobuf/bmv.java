package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bmv */
public final class bmv extends C1331a {
    public int jBv;
    public LinkedList<bmu> wPM = new LinkedList();
    public int wrw;

    public bmv() {
        AppMethodBeat.m2504i(73748);
        AppMethodBeat.m2505o(73748);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(73749);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.wrw);
            c6093a.mo13480iz(2, this.jBv);
            c6093a.mo13474e(3, 8, this.wPM);
            AppMethodBeat.m2505o(73749);
            return 0;
        } else if (i == 1) {
            bs = ((C6091a.m9572bs(1, this.wrw) + 0) + C6091a.m9572bs(2, this.jBv)) + C6087a.m9552c(3, 8, this.wPM);
            AppMethodBeat.m2505o(73749);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wPM.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(73749);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bmv bmv = (bmv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bmv.wrw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73749);
                    return 0;
                case 2:
                    bmv.jBv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73749);
                    return 0;
                case 3:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bmu bmu = new bmu();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bmu.populateBuilderWithField(c6086a3, bmu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bmv.wPM.add(bmu);
                    }
                    AppMethodBeat.m2505o(73749);
                    return 0;
                default:
                    AppMethodBeat.m2505o(73749);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(73749);
            return -1;
        }
    }
}
