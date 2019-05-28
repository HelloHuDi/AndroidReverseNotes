package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bwh */
public final class bwh extends bsr {
    public asq vLi;
    public asu wWW;
    public SKBuiltinBuffer_t wwz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28631);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vLi == null) {
                c6092b = new C6092b("Not all required fields were included: HardDevice");
                AppMethodBeat.m2505o(28631);
                throw c6092b;
            } else if (this.wWW == null) {
                c6092b = new C6092b("Not all required fields were included: HardDeviceMsg");
                AppMethodBeat.m2505o(28631);
                throw c6092b;
            } else if (this.wwz == null) {
                c6092b = new C6092b("Not all required fields were included: SessionBuffer");
                AppMethodBeat.m2505o(28631);
                throw c6092b;
            } else {
                if (this.BaseRequest != null) {
                    c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(c6093a);
                }
                if (this.vLi != null) {
                    c6093a.mo13479iy(2, this.vLi.computeSize());
                    this.vLi.writeFields(c6093a);
                }
                if (this.wWW != null) {
                    c6093a.mo13479iy(3, this.wWW.computeSize());
                    this.wWW.writeFields(c6093a);
                }
                if (this.wwz != null) {
                    c6093a.mo13479iy(4, this.wwz.computeSize());
                    this.wwz.writeFields(c6093a);
                }
                AppMethodBeat.m2505o(28631);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vLi != null) {
                ix += C6087a.m9557ix(2, this.vLi.computeSize());
            }
            if (this.wWW != null) {
                ix += C6087a.m9557ix(3, this.wWW.computeSize());
            }
            if (this.wwz != null) {
                ix += C6087a.m9557ix(4, this.wwz.computeSize());
            }
            AppMethodBeat.m2505o(28631);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.vLi == null) {
                c6092b = new C6092b("Not all required fields were included: HardDevice");
                AppMethodBeat.m2505o(28631);
                throw c6092b;
            } else if (this.wWW == null) {
                c6092b = new C6092b("Not all required fields were included: HardDeviceMsg");
                AppMethodBeat.m2505o(28631);
                throw c6092b;
            } else if (this.wwz == null) {
                c6092b = new C6092b("Not all required fields were included: SessionBuffer");
                AppMethodBeat.m2505o(28631);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(28631);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bwh bwh = (bwh) objArr[1];
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
                        bwh.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(28631);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        asq asq = new asq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = asq.populateBuilderWithField(c6086a3, asq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bwh.vLi = asq;
                    }
                    AppMethodBeat.m2505o(28631);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        asu asu = new asu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = asu.populateBuilderWithField(c6086a3, asu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bwh.wWW = asu;
                    }
                    AppMethodBeat.m2505o(28631);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bwh.wwz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28631);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28631);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28631);
            return -1;
        }
    }
}
