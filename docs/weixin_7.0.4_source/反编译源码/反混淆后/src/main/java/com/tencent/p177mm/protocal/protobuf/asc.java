package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.asc */
public final class asc extends btd {
    public bqi wvP;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14731);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(14731);
                throw c6092b;
            } else if (this.wvP == null) {
                c6092b = new C6092b("Not all required fields were included: GroupList");
                AppMethodBeat.m2505o(14731);
                throw c6092b;
            } else {
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                if (this.wvP != null) {
                    c6093a.mo13479iy(2, this.wvP.computeSize());
                    this.wvP.writeFields(c6093a);
                }
                AppMethodBeat.m2505o(14731);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wvP != null) {
                ix += C6087a.m9557ix(2, this.wvP.computeSize());
            }
            AppMethodBeat.m2505o(14731);
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
                AppMethodBeat.m2505o(14731);
                throw c6092b;
            } else if (this.wvP == null) {
                c6092b = new C6092b("Not all required fields were included: GroupList");
                AppMethodBeat.m2505o(14731);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(14731);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            asc asc = (asc) objArr[1];
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
                        asc.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(14731);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bqi bqi = new bqi();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqi.populateBuilderWithField(c6086a3, bqi, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        asc.wvP = bqi;
                    }
                    AppMethodBeat.m2505o(14731);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14731);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14731);
            return -1;
        }
    }
}
