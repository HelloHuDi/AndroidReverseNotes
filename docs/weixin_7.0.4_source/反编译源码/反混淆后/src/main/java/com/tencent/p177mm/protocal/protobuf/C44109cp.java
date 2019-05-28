package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cp */
public final class C44109cp extends btd {
    public LinkedList<bgd> vEN = new LinkedList();
    public String vEO;

    public C44109cp() {
        AppMethodBeat.m2504i(80009);
        AppMethodBeat.m2505o(80009);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80010);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 8, this.vEN);
            if (this.vEO != null) {
                c6093a.mo13475e(3, this.vEO);
            }
            AppMethodBeat.m2505o(80010);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6087a.m9552c(2, 8, this.vEN);
            if (this.vEO != null) {
                ix += C6091a.m9575f(3, this.vEO);
            }
            AppMethodBeat.m2505o(80010);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vEN.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(80010);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44109cp c44109cp = (C44109cp) objArr[1];
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
                        c44109cp.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(80010);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bgd bgd = new bgd();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bgd.populateBuilderWithField(c6086a3, bgd, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44109cp.vEN.add(bgd);
                    }
                    AppMethodBeat.m2505o(80010);
                    return 0;
                case 3:
                    c44109cp.vEO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80010);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80010);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80010);
            return -1;
        }
    }
}
