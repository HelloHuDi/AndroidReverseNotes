package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cdt */
public final class cdt extends btd {
    public SKBuiltinBuffer_t xdt;
    public int xdu;
    public LinkedList<cdr> xdv = new LinkedList();
    public int xdw;

    public cdt() {
        AppMethodBeat.m2504i(56501);
        AppMethodBeat.m2505o(56501);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56502);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56502);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.xdu);
            c6093a.mo13474e(3, 8, this.xdv);
            c6093a.mo13480iz(4, this.xdw);
            if (this.xdt != null) {
                c6093a.mo13479iy(5, this.xdt.computeSize());
                this.xdt.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(56502);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + C6091a.m9572bs(2, this.xdu)) + C6087a.m9552c(3, 8, this.xdv)) + C6091a.m9572bs(4, this.xdw);
            if (this.xdt != null) {
                ix += C6087a.m9557ix(5, this.xdt.computeSize());
            }
            AppMethodBeat.m2505o(56502);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xdv.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56502);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56502);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cdt cdt = (cdt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
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
                        cdt.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(56502);
                    return 0;
                case 2:
                    cdt.xdu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56502);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdr cdr = new cdr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdr.populateBuilderWithField(c6086a3, cdr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cdt.xdv.add(cdr);
                    }
                    AppMethodBeat.m2505o(56502);
                    return 0;
                case 4:
                    cdt.xdw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56502);
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
                        cdt.xdt = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(56502);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56502);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56502);
            return -1;
        }
    }
}
