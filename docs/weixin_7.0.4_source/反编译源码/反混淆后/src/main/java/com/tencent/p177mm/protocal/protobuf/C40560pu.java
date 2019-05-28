package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.pu */
public final class C40560pu extends bsr {
    public String desc;
    public boolean vWT;
    public boolean vWU;
    public LinkedList<Integer> vWt = new LinkedList();

    public C40560pu() {
        AppMethodBeat.m2504i(48806);
        AppMethodBeat.m2505o(48806);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48807);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 2, this.vWt);
            if (this.desc != null) {
                c6093a.mo13475e(3, this.desc);
            }
            c6093a.mo13471aO(4, this.vWT);
            c6093a.mo13471aO(5, this.vWU);
            AppMethodBeat.m2505o(48807);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6087a.m9552c(2, 2, this.vWt);
            if (this.desc != null) {
                ix += C6091a.m9575f(3, this.desc);
            }
            int fv = (ix + (C6091a.m9576fv(4) + 1)) + (C6091a.m9576fv(5) + 1);
            AppMethodBeat.m2505o(48807);
            return fv;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vWt.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48807);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40560pu c40560pu = (C40560pu) objArr[1];
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
                        c40560pu.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(48807);
                    return 0;
                case 2:
                    c40560pu.vWt.add(Integer.valueOf(c6086a2.BTU.mo13458vd()));
                    AppMethodBeat.m2505o(48807);
                    return 0;
                case 3:
                    c40560pu.desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48807);
                    return 0;
                case 4:
                    c40560pu.vWT = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(48807);
                    return 0;
                case 5:
                    c40560pu.vWU = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(48807);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48807);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48807);
            return -1;
        }
    }
}
