package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.oh */
public final class C44150oh extends btd {
    public int vQe;
    public SKBuiltinBuffer_t vTO;
    public C35956tc vTR;
    public int vTS;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(114433);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(114433);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.vTR != null) {
                c6093a.mo13479iy(2, this.vTR.computeSize());
                this.vTR.writeFields(c6093a);
            }
            if (this.vTO != null) {
                c6093a.mo13479iy(3, this.vTO.computeSize());
                this.vTO.writeFields(c6093a);
            }
            c6093a.mo13480iz(4, this.vQe);
            c6093a.mo13480iz(5, this.vTS);
            AppMethodBeat.m2505o(114433);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vTR != null) {
                ix += C6087a.m9557ix(2, this.vTR.computeSize());
            }
            if (this.vTO != null) {
                ix += C6087a.m9557ix(3, this.vTO.computeSize());
            }
            int bs = (ix + C6091a.m9572bs(4, this.vQe)) + C6091a.m9572bs(5, this.vTS);
            AppMethodBeat.m2505o(114433);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(114433);
                throw c6092b;
            }
            AppMethodBeat.m2505o(114433);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44150oh c44150oh = (C44150oh) objArr[1];
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
                        BaseResponse baseResponse = new BaseResponse();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44150oh.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(114433);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C35956tc c35956tc = new C35956tc();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c35956tc.populateBuilderWithField(c6086a3, c35956tc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44150oh.vTR = c35956tc;
                    }
                    AppMethodBeat.m2505o(114433);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44150oh.vTO = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(114433);
                    return 0;
                case 4:
                    c44150oh.vQe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(114433);
                    return 0;
                case 5:
                    c44150oh.vTS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(114433);
                    return 0;
                default:
                    AppMethodBeat.m2505o(114433);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(114433);
            return -1;
        }
    }
}
