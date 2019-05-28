package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.qi */
public final class C30217qi extends bsr {
    public String nuL;
    public String pbn;
    public String vXt;
    public String vXu;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48814);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.vXt != null) {
                c6093a.mo13475e(2, this.vXt);
            }
            if (this.vXu != null) {
                c6093a.mo13475e(3, this.vXu);
            }
            if (this.nuL != null) {
                c6093a.mo13475e(4, this.nuL);
            }
            if (this.pbn != null) {
                c6093a.mo13475e(5, this.pbn);
            }
            AppMethodBeat.m2505o(48814);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vXt != null) {
                ix += C6091a.m9575f(2, this.vXt);
            }
            if (this.vXu != null) {
                ix += C6091a.m9575f(3, this.vXu);
            }
            if (this.nuL != null) {
                ix += C6091a.m9575f(4, this.nuL);
            }
            if (this.pbn != null) {
                ix += C6091a.m9575f(5, this.pbn);
            }
            AppMethodBeat.m2505o(48814);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48814);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30217qi c30217qi = (C30217qi) objArr[1];
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
                        c30217qi.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(48814);
                    return 0;
                case 2:
                    c30217qi.vXt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48814);
                    return 0;
                case 3:
                    c30217qi.vXu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48814);
                    return 0;
                case 4:
                    c30217qi.nuL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48814);
                    return 0;
                case 5:
                    c30217qi.pbn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48814);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48814);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48814);
            return -1;
        }
    }
}
