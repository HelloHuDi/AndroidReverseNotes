package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.als */
public final class als extends bsr {
    public int OpCode;
    public int Scene;
    public double vNH;
    public double vNI;
    public String wkD;
    public SKBuiltinBuffer_t wpP;
    public int wpR;
    public double wqS;
    public double wqT;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(113782);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wpP == null) {
                c6092b = new C6092b("Not all required fields were included: Buff");
                AppMethodBeat.m2505o(113782);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.Scene);
            c6093a.mo13480iz(3, this.OpCode);
            if (this.wkD != null) {
                c6093a.mo13475e(4, this.wkD);
            }
            if (this.wpP != null) {
                c6093a.mo13479iy(5, this.wpP.computeSize());
                this.wpP.writeFields(c6093a);
            }
            c6093a.mo13476f(6, this.vNH);
            c6093a.mo13476f(7, this.vNI);
            c6093a.mo13476f(8, this.wqS);
            c6093a.mo13476f(9, this.wqT);
            c6093a.mo13480iz(10, this.wpR);
            AppMethodBeat.m2505o(113782);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6091a.m9572bs(2, this.Scene)) + C6091a.m9572bs(3, this.OpCode);
            if (this.wkD != null) {
                ix += C6091a.m9575f(4, this.wkD);
            }
            if (this.wpP != null) {
                ix += C6087a.m9557ix(5, this.wpP.computeSize());
            }
            int fv = ((((ix + (C6091a.m9576fv(6) + 8)) + (C6091a.m9576fv(7) + 8)) + (C6091a.m9576fv(8) + 8)) + (C6091a.m9576fv(9) + 8)) + C6091a.m9572bs(10, this.wpR);
            AppMethodBeat.m2505o(113782);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.wpP == null) {
                c6092b = new C6092b("Not all required fields were included: Buff");
                AppMethodBeat.m2505o(113782);
                throw c6092b;
            }
            AppMethodBeat.m2505o(113782);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            als als = (als) objArr[1];
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
                        als.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(113782);
                    return 0;
                case 2:
                    als.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(113782);
                    return 0;
                case 3:
                    als.OpCode = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(113782);
                    return 0;
                case 4:
                    als.wkD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(113782);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        als.wpP = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(113782);
                    return 0;
                case 6:
                    als.vNH = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(113782);
                    return 0;
                case 7:
                    als.vNI = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(113782);
                    return 0;
                case 8:
                    als.wqS = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(113782);
                    return 0;
                case 9:
                    als.wqT = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(113782);
                    return 0;
                case 10:
                    als.wpR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(113782);
                    return 0;
                default:
                    AppMethodBeat.m2505o(113782);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(113782);
            return -1;
        }
    }
}
