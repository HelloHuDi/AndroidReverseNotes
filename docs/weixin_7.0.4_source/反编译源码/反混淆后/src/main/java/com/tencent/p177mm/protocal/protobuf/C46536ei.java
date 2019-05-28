package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ei */
public final class C46536ei extends btd {
    public C35931jz vGd;
    public C40538kr vGe;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14692);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(14692);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.vGd != null) {
                c6093a.mo13479iy(2, this.vGd.computeSize());
                this.vGd.writeFields(c6093a);
            }
            if (this.vGe != null) {
                c6093a.mo13479iy(3, this.vGe.computeSize());
                this.vGe.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(14692);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vGd != null) {
                ix += C6087a.m9557ix(2, this.vGd.computeSize());
            }
            if (this.vGe != null) {
                ix += C6087a.m9557ix(3, this.vGe.computeSize());
            }
            AppMethodBeat.m2505o(14692);
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
                AppMethodBeat.m2505o(14692);
                throw c6092b;
            }
            AppMethodBeat.m2505o(14692);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46536ei c46536ei = (C46536ei) objArr[1];
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
                        c46536ei.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(14692);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C35931jz c35931jz = new C35931jz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c35931jz.populateBuilderWithField(c6086a3, c35931jz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46536ei.vGd = c35931jz;
                    }
                    AppMethodBeat.m2505o(14692);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40538kr c40538kr = new C40538kr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40538kr.populateBuilderWithField(c6086a3, c40538kr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46536ei.vGe = c40538kr;
                    }
                    AppMethodBeat.m2505o(14692);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14692);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14692);
            return -1;
        }
    }
}
