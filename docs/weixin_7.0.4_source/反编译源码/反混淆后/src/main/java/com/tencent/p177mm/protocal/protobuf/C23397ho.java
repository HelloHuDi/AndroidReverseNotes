package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ho */
public final class C23397ho extends bsr {
    public int jBv;
    public LinkedList<Integer> vKh = new LinkedList();

    public C23397ho() {
        AppMethodBeat.m2504i(51365);
        AppMethodBeat.m2505o(51365);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51366);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.jBv);
            c6093a.mo13477f(3, 2, this.vKh);
            AppMethodBeat.m2505o(51366);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = (ix + C6091a.m9572bs(2, this.jBv)) + C6087a.m9553d(3, 2, this.vKh);
            AppMethodBeat.m2505o(51366);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vKh.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(51366);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23397ho c23397ho = (C23397ho) objArr[1];
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
                        c23397ho.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(51366);
                    return 0;
                case 2:
                    c23397ho.jBv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51366);
                    return 0;
                case 3:
                    c23397ho.vKh = new C6086a(c6086a2.BTU.emu().f1226wR, unknownTagHandler).BTU.emt();
                    AppMethodBeat.m2505o(51366);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51366);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51366);
            return -1;
        }
    }
}
