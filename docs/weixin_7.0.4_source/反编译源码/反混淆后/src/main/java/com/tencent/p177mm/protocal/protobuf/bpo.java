package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bpo */
public final class bpo extends btd {
    /* renamed from: id */
    public int f13732id;
    public bpj wRK;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28609);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wRK == null) {
                c6092b = new C6092b("Not all required fields were included: rcptinfolist");
                AppMethodBeat.m2505o(28609);
                throw c6092b;
            } else if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28609);
                throw c6092b;
            } else {
                c6093a.mo13480iz(1, this.f13732id);
                if (this.wRK != null) {
                    c6093a.mo13479iy(2, this.wRK.computeSize());
                    this.wRK.writeFields(c6093a);
                }
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(3, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                AppMethodBeat.m2505o(28609);
                return 0;
            }
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.f13732id) + 0;
            if (this.wRK != null) {
                bs += C6087a.m9557ix(2, this.wRK.computeSize());
            }
            if (this.BaseResponse != null) {
                bs += C6087a.m9557ix(3, this.BaseResponse.computeSize());
            }
            AppMethodBeat.m2505o(28609);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.wRK == null) {
                c6092b = new C6092b("Not all required fields were included: rcptinfolist");
                AppMethodBeat.m2505o(28609);
                throw c6092b;
            } else if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28609);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(28609);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bpo bpo = (bpo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    bpo.f13732id = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28609);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bpj bpj = new bpj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpj.populateBuilderWithField(c6086a3, bpj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bpo.wRK = bpj;
                    }
                    AppMethodBeat.m2505o(28609);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bpo.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(28609);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28609);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28609);
            return -1;
        }
    }
}
