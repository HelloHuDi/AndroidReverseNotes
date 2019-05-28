package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.byr */
public final class byr extends bsr {
    public int OpCode;
    public SKBuiltinBuffer_t vIl;
    public float vRp;
    public float vRq;
    public int wYa;
    public int wYb;
    public int wfG;
    public String wfH;
    public String wfI;
    public int wfJ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28648);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.OpCode);
            c6093a.mo13481r(3, this.vRp);
            c6093a.mo13481r(4, this.vRq);
            c6093a.mo13480iz(5, this.wfG);
            if (this.wfH != null) {
                c6093a.mo13475e(6, this.wfH);
            }
            if (this.wfI != null) {
                c6093a.mo13475e(7, this.wfI);
            }
            c6093a.mo13480iz(8, this.wYa);
            c6093a.mo13480iz(9, this.wYb);
            c6093a.mo13480iz(10, this.wfJ);
            if (this.vIl != null) {
                c6093a.mo13479iy(11, this.vIl.computeSize());
                this.vIl.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(28648);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (((ix + C6091a.m9572bs(2, this.OpCode)) + (C6091a.m9576fv(3) + 4)) + (C6091a.m9576fv(4) + 4)) + C6091a.m9572bs(5, this.wfG);
            if (this.wfH != null) {
                ix += C6091a.m9575f(6, this.wfH);
            }
            if (this.wfI != null) {
                ix += C6091a.m9575f(7, this.wfI);
            }
            ix = ((ix + C6091a.m9572bs(8, this.wYa)) + C6091a.m9572bs(9, this.wYb)) + C6091a.m9572bs(10, this.wfJ);
            if (this.vIl != null) {
                ix += C6087a.m9557ix(11, this.vIl.computeSize());
            }
            AppMethodBeat.m2505o(28648);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28648);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            byr byr = (byr) objArr[1];
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
                        byr.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(28648);
                    return 0;
                case 2:
                    byr.OpCode = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28648);
                    return 0;
                case 3:
                    byr.vRp = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(28648);
                    return 0;
                case 4:
                    byr.vRq = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(28648);
                    return 0;
                case 5:
                    byr.wfG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28648);
                    return 0;
                case 6:
                    byr.wfH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28648);
                    return 0;
                case 7:
                    byr.wfI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28648);
                    return 0;
                case 8:
                    byr.wYa = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28648);
                    return 0;
                case 9:
                    byr.wYb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28648);
                    return 0;
                case 10:
                    byr.wfJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28648);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        byr.vIl = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28648);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28648);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28648);
            return -1;
        }
    }
}
