package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bxb */
public final class bxb extends bsr {
    public int wGh;
    public int wXj;
    public LinkedList<cru> wXk = new LinkedList();
    public int wXl;

    public bxb() {
        AppMethodBeat.m2504i(28633);
        AppMethodBeat.m2505o(28633);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28634);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.wGh);
            c6093a.mo13480iz(3, this.wXj);
            c6093a.mo13474e(4, 8, this.wXk);
            c6093a.mo13480iz(5, this.wXl);
            AppMethodBeat.m2505o(28634);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = (((ix + C6091a.m9572bs(2, this.wGh)) + C6091a.m9572bs(3, this.wXj)) + C6087a.m9552c(4, 8, this.wXk)) + C6091a.m9572bs(5, this.wXl);
            AppMethodBeat.m2505o(28634);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wXk.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28634);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bxb bxb = (bxb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bxb.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(28634);
                    return 0;
                case 2:
                    bxb.wGh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28634);
                    return 0;
                case 3:
                    bxb.wXj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28634);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cru cru = new cru();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cru.populateBuilderWithField(c6086a3, cru, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bxb.wXk.add(cru);
                    }
                    AppMethodBeat.m2505o(28634);
                    return 0;
                case 5:
                    bxb.wXl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28634);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28634);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28634);
            return -1;
        }
    }
}
