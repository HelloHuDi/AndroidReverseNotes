package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cak */
public final class cak extends btd {
    public cbt wSf;
    public SKBuiltinBuffer_t wZA;
    public C46531cy wZB;
    public SKBuiltinBuffer_t wZw;
    public cai wZz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94560);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(94560);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.wZz != null) {
                c6093a.mo13479iy(2, this.wZz.computeSize());
                this.wZz.writeFields(c6093a);
            }
            if (this.wZw != null) {
                c6093a.mo13479iy(3, this.wZw.computeSize());
                this.wZw.writeFields(c6093a);
            }
            if (this.wSf != null) {
                c6093a.mo13479iy(4, this.wSf.computeSize());
                this.wSf.writeFields(c6093a);
            }
            if (this.wZA != null) {
                c6093a.mo13479iy(5, this.wZA.computeSize());
                this.wZA.writeFields(c6093a);
            }
            if (this.wZB != null) {
                c6093a.mo13479iy(6, this.wZB.computeSize());
                this.wZB.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(94560);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wZz != null) {
                ix += C6087a.m9557ix(2, this.wZz.computeSize());
            }
            if (this.wZw != null) {
                ix += C6087a.m9557ix(3, this.wZw.computeSize());
            }
            if (this.wSf != null) {
                ix += C6087a.m9557ix(4, this.wSf.computeSize());
            }
            if (this.wZA != null) {
                ix += C6087a.m9557ix(5, this.wZA.computeSize());
            }
            if (this.wZB != null) {
                ix += C6087a.m9557ix(6, this.wZB.computeSize());
            }
            AppMethodBeat.m2505o(94560);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(94560);
                throw c6092b;
            }
            AppMethodBeat.m2505o(94560);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cak cak = (cak) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cak.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(94560);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cai cai = new cai();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cai.populateBuilderWithField(c6086a3, cai, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cak.wZz = cai;
                    }
                    AppMethodBeat.m2505o(94560);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cak.wZw = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(94560);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbt cbt = new cbt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbt.populateBuilderWithField(c6086a3, cbt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cak.wSf = cbt;
                    }
                    AppMethodBeat.m2505o(94560);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cak.wZA = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(94560);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46531cy c46531cy = new C46531cy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c46531cy.populateBuilderWithField(c6086a3, c46531cy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cak.wZB = c46531cy;
                    }
                    AppMethodBeat.m2505o(94560);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94560);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94560);
            return -1;
        }
    }
}
