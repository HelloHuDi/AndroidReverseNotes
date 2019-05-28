package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bti */
public final class bti extends bsr {
    public String ndF;
    public String ndG;
    public int pcX;
    public String vFF;
    public int wVo;
    public int wVp;
    public int wVq;
    public long wVr;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28618);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.vFF != null) {
                c6093a.mo13475e(2, this.vFF);
            }
            c6093a.mo13480iz(3, this.wVo);
            c6093a.mo13480iz(4, this.pcX);
            c6093a.mo13480iz(5, this.wVp);
            if (this.ndG != null) {
                c6093a.mo13475e(6, this.ndG);
            }
            if (this.ndF != null) {
                c6093a.mo13475e(7, this.ndF);
            }
            c6093a.mo13480iz(8, this.wVq);
            c6093a.mo13472ai(9, this.wVr);
            AppMethodBeat.m2505o(28618);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vFF != null) {
                ix += C6091a.m9575f(2, this.vFF);
            }
            ix = ((ix + C6091a.m9572bs(3, this.wVo)) + C6091a.m9572bs(4, this.pcX)) + C6091a.m9572bs(5, this.wVp);
            if (this.ndG != null) {
                ix += C6091a.m9575f(6, this.ndG);
            }
            if (this.ndF != null) {
                ix += C6091a.m9575f(7, this.ndF);
            }
            int bs = (ix + C6091a.m9572bs(8, this.wVq)) + C6091a.m9578o(9, this.wVr);
            AppMethodBeat.m2505o(28618);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28618);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bti bti = (bti) objArr[1];
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
                        bti.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(28618);
                    return 0;
                case 2:
                    bti.vFF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28618);
                    return 0;
                case 3:
                    bti.wVo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28618);
                    return 0;
                case 4:
                    bti.pcX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28618);
                    return 0;
                case 5:
                    bti.wVp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28618);
                    return 0;
                case 6:
                    bti.ndG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28618);
                    return 0;
                case 7:
                    bti.ndF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28618);
                    return 0;
                case 8:
                    bti.wVq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28618);
                    return 0;
                case 9:
                    bti.wVr = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(28618);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28618);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28618);
            return -1;
        }
    }
}
