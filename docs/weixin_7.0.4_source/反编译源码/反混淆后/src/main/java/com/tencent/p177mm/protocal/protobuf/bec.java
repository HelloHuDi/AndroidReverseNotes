package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bec */
public final class bec extends btd {
    public int vBm;
    public int vQe;
    public SKBuiltinBuffer_t wHH;
    public SKBuiltinBuffer_t wHI;
    public int wHJ;
    public int wHK;
    public LinkedList<C40573tb> wHL = new LinkedList();

    public bec() {
        AppMethodBeat.m2504i(58918);
        AppMethodBeat.m2505o(58918);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(58919);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(58919);
                throw c6092b;
            } else if (this.wHH == null) {
                c6092b = new C6092b("Not all required fields were included: CurrentSynckey");
                AppMethodBeat.m2505o(58919);
                throw c6092b;
            } else if (this.wHI == null) {
                c6092b = new C6092b("Not all required fields were included: MaxSynckey");
                AppMethodBeat.m2505o(58919);
                throw c6092b;
            } else {
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                if (this.wHH != null) {
                    c6093a.mo13479iy(2, this.wHH.computeSize());
                    this.wHH.writeFields(c6093a);
                }
                if (this.wHI != null) {
                    c6093a.mo13479iy(3, this.wHI.computeSize());
                    this.wHI.writeFields(c6093a);
                }
                c6093a.mo13480iz(4, this.vQe);
                c6093a.mo13480iz(5, this.wHJ);
                c6093a.mo13480iz(6, this.wHK);
                c6093a.mo13474e(7, 8, this.wHL);
                c6093a.mo13480iz(8, this.vBm);
                AppMethodBeat.m2505o(58919);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wHH != null) {
                ix += C6087a.m9557ix(2, this.wHH.computeSize());
            }
            if (this.wHI != null) {
                ix += C6087a.m9557ix(3, this.wHI.computeSize());
            }
            int bs = ((((ix + C6091a.m9572bs(4, this.vQe)) + C6091a.m9572bs(5, this.wHJ)) + C6091a.m9572bs(6, this.wHK)) + C6087a.m9552c(7, 8, this.wHL)) + C6091a.m9572bs(8, this.vBm);
            AppMethodBeat.m2505o(58919);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wHL.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(58919);
                throw c6092b;
            } else if (this.wHH == null) {
                c6092b = new C6092b("Not all required fields were included: CurrentSynckey");
                AppMethodBeat.m2505o(58919);
                throw c6092b;
            } else if (this.wHI == null) {
                c6092b = new C6092b("Not all required fields were included: MaxSynckey");
                AppMethodBeat.m2505o(58919);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(58919);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bec bec = (bec) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
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
                        bec.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(58919);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bec.wHH = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58919);
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
                        bec.wHI = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58919);
                    return 0;
                case 4:
                    bec.vQe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58919);
                    return 0;
                case 5:
                    bec.wHJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58919);
                    return 0;
                case 6:
                    bec.wHK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58919);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40573tb c40573tb = new C40573tb();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40573tb.populateBuilderWithField(c6086a3, c40573tb, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bec.wHL.add(c40573tb);
                    }
                    AppMethodBeat.m2505o(58919);
                    return 0;
                case 8:
                    bec.vBm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58919);
                    return 0;
                default:
                    AppMethodBeat.m2505o(58919);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(58919);
            return -1;
        }
    }
}
