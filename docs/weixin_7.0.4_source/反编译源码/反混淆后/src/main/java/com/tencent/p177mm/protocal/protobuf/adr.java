package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.adr */
public final class adr extends btd {
    public int Timestamp;
    public LinkedList<C1332b> wlP = new LinkedList();
    public int wlQ;
    public LinkedList<Integer> wlR = new LinkedList();

    public adr() {
        AppMethodBeat.m2504i(118198);
        AppMethodBeat.m2505o(118198);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(118199);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(118199);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 6, this.wlP);
            c6093a.mo13480iz(3, this.wlQ);
            c6093a.mo13480iz(4, this.Timestamp);
            c6093a.mo13474e(5, 2, this.wlR);
            AppMethodBeat.m2505o(118199);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int c = (((ix + C6087a.m9552c(2, 6, this.wlP)) + C6091a.m9572bs(3, this.wlQ)) + C6091a.m9572bs(4, this.Timestamp)) + C6087a.m9552c(5, 2, this.wlR);
            AppMethodBeat.m2505o(118199);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wlP.clear();
            this.wlR.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(118199);
                throw c6092b;
            }
            AppMethodBeat.m2505o(118199);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            adr adr = (adr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        adr.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(118199);
                    return 0;
                case 2:
                    adr.wlP.add(c6086a2.BTU.emu());
                    AppMethodBeat.m2505o(118199);
                    return 0;
                case 3:
                    adr.wlQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(118199);
                    return 0;
                case 4:
                    adr.Timestamp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(118199);
                    return 0;
                case 5:
                    adr.wlR.add(Integer.valueOf(c6086a2.BTU.mo13458vd()));
                    AppMethodBeat.m2505o(118199);
                    return 0;
                default:
                    AppMethodBeat.m2505o(118199);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(118199);
            return -1;
        }
    }
}
