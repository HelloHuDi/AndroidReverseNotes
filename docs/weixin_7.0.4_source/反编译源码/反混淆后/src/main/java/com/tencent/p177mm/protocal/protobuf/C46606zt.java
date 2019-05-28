package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.zt */
public final class C46606zt extends bsr {
    public double latitude;
    public double longitude;
    public String nSX;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56780);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.nSX != null) {
                c6093a.mo13475e(2, this.nSX);
            }
            c6093a.mo13476f(3, this.latitude);
            c6093a.mo13476f(4, this.longitude);
            AppMethodBeat.m2505o(56780);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.nSX != null) {
                ix += C6091a.m9575f(2, this.nSX);
            }
            int fv = (ix + (C6091a.m9576fv(3) + 8)) + (C6091a.m9576fv(4) + 8);
            AppMethodBeat.m2505o(56780);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56780);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46606zt c46606zt = (C46606zt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46606zt.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(56780);
                    return 0;
                case 2:
                    c46606zt.nSX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56780);
                    return 0;
                case 3:
                    c46606zt.latitude = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(56780);
                    return 0;
                case 4:
                    c46606zt.longitude = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(56780);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56780);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56780);
            return -1;
        }
    }
}
