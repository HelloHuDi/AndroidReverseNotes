package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cs */
public final class C44112cs extends bsr {
    public long cSh;
    public int ehf;
    public String pbn;
    public String pck;
    public String vEQ;
    public String vER;
    public int vES;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56699);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13472ai(2, this.cSh);
            if (this.pbn != null) {
                c6093a.mo13475e(3, this.pbn);
            }
            if (this.pck != null) {
                c6093a.mo13475e(4, this.pck);
            }
            if (this.vEQ != null) {
                c6093a.mo13475e(5, this.vEQ);
            }
            c6093a.mo13480iz(6, this.ehf);
            if (this.vER != null) {
                c6093a.mo13475e(7, this.vER);
            }
            c6093a.mo13480iz(8, this.vES);
            AppMethodBeat.m2505o(56699);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9578o(2, this.cSh);
            if (this.pbn != null) {
                ix += C6091a.m9575f(3, this.pbn);
            }
            if (this.pck != null) {
                ix += C6091a.m9575f(4, this.pck);
            }
            if (this.vEQ != null) {
                ix += C6091a.m9575f(5, this.vEQ);
            }
            ix += C6091a.m9572bs(6, this.ehf);
            if (this.vER != null) {
                ix += C6091a.m9575f(7, this.vER);
            }
            int bs = ix + C6091a.m9572bs(8, this.vES);
            AppMethodBeat.m2505o(56699);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56699);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44112cs c44112cs = (C44112cs) objArr[1];
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
                        c44112cs.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(56699);
                    return 0;
                case 2:
                    c44112cs.cSh = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56699);
                    return 0;
                case 3:
                    c44112cs.pbn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56699);
                    return 0;
                case 4:
                    c44112cs.pck = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56699);
                    return 0;
                case 5:
                    c44112cs.vEQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56699);
                    return 0;
                case 6:
                    c44112cs.ehf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56699);
                    return 0;
                case 7:
                    c44112cs.vER = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56699);
                    return 0;
                case 8:
                    c44112cs.vES = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56699);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56699);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56699);
            return -1;
        }
    }
}
