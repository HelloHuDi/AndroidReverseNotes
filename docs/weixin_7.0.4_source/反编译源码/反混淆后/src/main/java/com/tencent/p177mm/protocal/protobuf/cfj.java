package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cfj */
public final class cfj extends bsr {
    public String csB;
    public String cxb;
    public LinkedList<Integer> wXf = new LinkedList();
    public String wXg;

    public cfj() {
        AppMethodBeat.m2504i(96296);
        AppMethodBeat.m2505o(96296);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96297);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.csB != null) {
                c6093a.mo13475e(2, this.csB);
            }
            c6093a.mo13474e(3, 2, this.wXf);
            if (this.wXg != null) {
                c6093a.mo13475e(4, this.wXg);
            }
            if (this.cxb != null) {
                c6093a.mo13475e(5, this.cxb);
            }
            AppMethodBeat.m2505o(96297);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.csB != null) {
                ix += C6091a.m9575f(2, this.csB);
            }
            ix += C6087a.m9552c(3, 2, this.wXf);
            if (this.wXg != null) {
                ix += C6091a.m9575f(4, this.wXg);
            }
            if (this.cxb != null) {
                ix += C6091a.m9575f(5, this.cxb);
            }
            AppMethodBeat.m2505o(96297);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wXf.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(96297);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cfj cfj = (cfj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cfj.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(96297);
                    return 0;
                case 2:
                    cfj.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96297);
                    return 0;
                case 3:
                    cfj.wXf.add(Integer.valueOf(c6086a2.BTU.mo13458vd()));
                    AppMethodBeat.m2505o(96297);
                    return 0;
                case 4:
                    cfj.wXg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96297);
                    return 0;
                case 5:
                    cfj.cxb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96297);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96297);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96297);
            return -1;
        }
    }
}
