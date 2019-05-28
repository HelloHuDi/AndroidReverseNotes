package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.xv */
public final class C40587xv extends bsr {
    public String luQ;
    public int vIJ;
    public String vIj;
    public String vLJ;
    public String vLe;
    public SKBuiltinBuffer_t vLz;
    public int wdA;
    public String wdy;
    public String wdz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(73701);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vLz == null) {
                c6092b = new C6092b("Not all required fields were included: RandomEncryKey");
                AppMethodBeat.m2505o(73701);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.vLz != null) {
                c6093a.mo13479iy(2, this.vLz.computeSize());
                this.vLz.writeFields(c6093a);
            }
            c6093a.mo13480iz(3, this.vIJ);
            if (this.vLe != null) {
                c6093a.mo13475e(4, this.vLe);
            }
            if (this.luQ != null) {
                c6093a.mo13475e(5, this.luQ);
            }
            if (this.vLJ != null) {
                c6093a.mo13475e(6, this.vLJ);
            }
            if (this.wdy != null) {
                c6093a.mo13475e(7, this.wdy);
            }
            if (this.vIj != null) {
                c6093a.mo13475e(8, this.vIj);
            }
            if (this.wdz != null) {
                c6093a.mo13475e(9, this.wdz);
            }
            c6093a.mo13480iz(10, this.wdA);
            AppMethodBeat.m2505o(73701);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vLz != null) {
                ix += C6087a.m9557ix(2, this.vLz.computeSize());
            }
            ix += C6091a.m9572bs(3, this.vIJ);
            if (this.vLe != null) {
                ix += C6091a.m9575f(4, this.vLe);
            }
            if (this.luQ != null) {
                ix += C6091a.m9575f(5, this.luQ);
            }
            if (this.vLJ != null) {
                ix += C6091a.m9575f(6, this.vLJ);
            }
            if (this.wdy != null) {
                ix += C6091a.m9575f(7, this.wdy);
            }
            if (this.vIj != null) {
                ix += C6091a.m9575f(8, this.vIj);
            }
            if (this.wdz != null) {
                ix += C6091a.m9575f(9, this.wdz);
            }
            int bs = ix + C6091a.m9572bs(10, this.wdA);
            AppMethodBeat.m2505o(73701);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.vLz == null) {
                c6092b = new C6092b("Not all required fields were included: RandomEncryKey");
                AppMethodBeat.m2505o(73701);
                throw c6092b;
            }
            AppMethodBeat.m2505o(73701);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40587xv c40587xv = (C40587xv) objArr[1];
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
                        c40587xv.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(73701);
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
                        c40587xv.vLz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(73701);
                    return 0;
                case 3:
                    c40587xv.vIJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73701);
                    return 0;
                case 4:
                    c40587xv.vLe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73701);
                    return 0;
                case 5:
                    c40587xv.luQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73701);
                    return 0;
                case 6:
                    c40587xv.vLJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73701);
                    return 0;
                case 7:
                    c40587xv.wdy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73701);
                    return 0;
                case 8:
                    c40587xv.vIj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73701);
                    return 0;
                case 9:
                    c40587xv.wdz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73701);
                    return 0;
                case 10:
                    c40587xv.wdA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73701);
                    return 0;
                default:
                    AppMethodBeat.m2505o(73701);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(73701);
            return -1;
        }
    }
}
