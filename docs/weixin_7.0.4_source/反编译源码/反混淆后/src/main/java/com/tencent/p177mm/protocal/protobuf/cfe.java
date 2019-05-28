package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cfe */
public final class cfe extends btd {
    public int vAR;
    public String wZT;
    public int xbC;
    public long xdM;
    public int xeG;
    public LinkedList<cer> xeH = new LinkedList();
    public int xeI;
    public int xeJ;

    public cfe() {
        AppMethodBeat.m2504i(56549);
        AppMethodBeat.m2505o(56549);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56550);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56550);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.wZT != null) {
                c6093a.mo13475e(2, this.wZT);
            }
            c6093a.mo13480iz(3, this.xeG);
            c6093a.mo13474e(4, 8, this.xeH);
            c6093a.mo13480iz(5, this.xeI);
            c6093a.mo13480iz(6, this.xeJ);
            c6093a.mo13480iz(7, this.xbC);
            c6093a.mo13472ai(8, this.xdM);
            c6093a.mo13480iz(9, this.vAR);
            AppMethodBeat.m2505o(56550);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wZT != null) {
                ix += C6091a.m9575f(2, this.wZT);
            }
            int bs = ((((((ix + C6091a.m9572bs(3, this.xeG)) + C6087a.m9552c(4, 8, this.xeH)) + C6091a.m9572bs(5, this.xeI)) + C6091a.m9572bs(6, this.xeJ)) + C6091a.m9572bs(7, this.xbC)) + C6091a.m9578o(8, this.xdM)) + C6091a.m9572bs(9, this.vAR);
            AppMethodBeat.m2505o(56550);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xeH.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56550);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56550);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cfe cfe = (cfe) objArr[1];
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
                        cfe.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(56550);
                    return 0;
                case 2:
                    cfe.wZT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56550);
                    return 0;
                case 3:
                    cfe.xeG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56550);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cer cer = new cer();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cer.populateBuilderWithField(c6086a3, cer, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cfe.xeH.add(cer);
                    }
                    AppMethodBeat.m2505o(56550);
                    return 0;
                case 5:
                    cfe.xeI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56550);
                    return 0;
                case 6:
                    cfe.xeJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56550);
                    return 0;
                case 7:
                    cfe.xbC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56550);
                    return 0;
                case 8:
                    cfe.xdM = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56550);
                    return 0;
                case 9:
                    cfe.vAR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56550);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56550);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56550);
            return -1;
        }
    }
}
