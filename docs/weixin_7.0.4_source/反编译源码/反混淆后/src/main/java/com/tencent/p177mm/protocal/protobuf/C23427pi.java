package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.pi */
public final class C23427pi extends bsr {
    public String kCK;
    public int nUf;
    public C1332b vWg;
    public C1332b vWh;
    public int vWi = 4;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56756);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.nUf);
            if (this.vWg != null) {
                c6093a.mo13473c(3, this.vWg);
            }
            if (this.vWh != null) {
                c6093a.mo13473c(4, this.vWh);
            }
            if (this.kCK != null) {
                c6093a.mo13475e(5, this.kCK);
            }
            c6093a.mo13480iz(6, this.vWi);
            AppMethodBeat.m2505o(56756);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.nUf);
            if (this.vWg != null) {
                ix += C6091a.m9571b(3, this.vWg);
            }
            if (this.vWh != null) {
                ix += C6091a.m9571b(4, this.vWh);
            }
            if (this.kCK != null) {
                ix += C6091a.m9575f(5, this.kCK);
            }
            int bs = ix + C6091a.m9572bs(6, this.vWi);
            AppMethodBeat.m2505o(56756);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56756);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23427pi c23427pi = (C23427pi) objArr[1];
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
                        c23427pi.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(56756);
                    return 0;
                case 2:
                    c23427pi.nUf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56756);
                    return 0;
                case 3:
                    c23427pi.vWg = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(56756);
                    return 0;
                case 4:
                    c23427pi.vWh = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(56756);
                    return 0;
                case 5:
                    c23427pi.kCK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56756);
                    return 0;
                case 6:
                    c23427pi.vWi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56756);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56756);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56756);
            return -1;
        }
    }
}
