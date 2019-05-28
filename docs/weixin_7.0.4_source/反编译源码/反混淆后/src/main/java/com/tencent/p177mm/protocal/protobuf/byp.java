package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.byp */
public final class byp extends bsr {
    public int fJT;
    public SKBuiltinBuffer_t ptz;
    public int vFE;
    public float vRq;
    public int vZF;
    public int wXO;
    public float wXP;
    public float wXQ;
    public int wrA;
    public int wrB;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28646);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.ptz == null) {
                c6092b = new C6092b("Not all required fields were included: Data");
                AppMethodBeat.m2505o(28646);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.ptz != null) {
                c6093a.mo13479iy(2, this.ptz.computeSize());
                this.ptz.writeFields(c6093a);
            }
            c6093a.mo13480iz(3, this.wXO);
            c6093a.mo13480iz(4, this.fJT);
            c6093a.mo13481r(5, this.wXP);
            c6093a.mo13480iz(6, this.vZF);
            c6093a.mo13480iz(7, this.vFE);
            c6093a.mo13481r(8, this.wXQ);
            c6093a.mo13481r(9, this.vRq);
            c6093a.mo13480iz(10, this.wrA);
            c6093a.mo13480iz(11, this.wrB);
            AppMethodBeat.m2505o(28646);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ptz != null) {
                ix += C6087a.m9557ix(2, this.ptz.computeSize());
            }
            int bs = ((((((((ix + C6091a.m9572bs(3, this.wXO)) + C6091a.m9572bs(4, this.fJT)) + (C6091a.m9576fv(5) + 4)) + C6091a.m9572bs(6, this.vZF)) + C6091a.m9572bs(7, this.vFE)) + (C6091a.m9576fv(8) + 4)) + (C6091a.m9576fv(9) + 4)) + C6091a.m9572bs(10, this.wrA)) + C6091a.m9572bs(11, this.wrB);
            AppMethodBeat.m2505o(28646);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.ptz == null) {
                c6092b = new C6092b("Not all required fields were included: Data");
                AppMethodBeat.m2505o(28646);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28646);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            byp byp = (byp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
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
                        byp.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(28646);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        byp.ptz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28646);
                    return 0;
                case 3:
                    byp.wXO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28646);
                    return 0;
                case 4:
                    byp.fJT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28646);
                    return 0;
                case 5:
                    byp.wXP = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(28646);
                    return 0;
                case 6:
                    byp.vZF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28646);
                    return 0;
                case 7:
                    byp.vFE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28646);
                    return 0;
                case 8:
                    byp.wXQ = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(28646);
                    return 0;
                case 9:
                    byp.vRq = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(28646);
                    return 0;
                case 10:
                    byp.wrA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28646);
                    return 0;
                case 11:
                    byp.wrB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28646);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28646);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28646);
            return -1;
        }
    }
}
