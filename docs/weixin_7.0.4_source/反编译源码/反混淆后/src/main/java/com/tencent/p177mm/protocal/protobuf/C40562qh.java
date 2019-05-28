package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.downloader.p723c.p724b.C38845f;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.qh */
public final class C40562qh extends btd {
    /* renamed from: op */
    public int f16207op;
    public long vXr;
    public C38845f vXs;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(112419);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(112419);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.f16207op);
            c6093a.mo13472ai(3, this.vXr);
            if (this.vXs != null) {
                c6093a.mo13479iy(4, this.vXs.computeSize());
                this.vXs.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(112419);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6091a.m9572bs(2, this.f16207op)) + C6091a.m9578o(3, this.vXr);
            if (this.vXs != null) {
                ix += C6087a.m9557ix(4, this.vXs.computeSize());
            }
            AppMethodBeat.m2505o(112419);
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
                AppMethodBeat.m2505o(112419);
                throw c6092b;
            }
            AppMethodBeat.m2505o(112419);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40562qh c40562qh = (C40562qh) objArr[1];
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
                        c40562qh.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(112419);
                    return 0;
                case 2:
                    c40562qh.f16207op = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(112419);
                    return 0;
                case 3:
                    c40562qh.vXr = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(112419);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C38845f c38845f = new C38845f();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c38845f.populateBuilderWithField(c6086a3, c38845f, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40562qh.vXs = c38845f;
                    }
                    AppMethodBeat.m2505o(112419);
                    return 0;
                default:
                    AppMethodBeat.m2505o(112419);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(112419);
            return -1;
        }
    }
}
