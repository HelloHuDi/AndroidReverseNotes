package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.yn */
public final class C30247yn extends btd {
    public LinkedList<cgm> vEh = new LinkedList();
    public int vIN;
    public LinkedList<cgl> vIO = new LinkedList();
    public int wem;
    public long wen;
    public int weo;
    public int wep;
    public int weq;

    public C30247yn() {
        AppMethodBeat.m2504i(28387);
        AppMethodBeat.m2505o(28387);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28388);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28388);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.wem);
            c6093a.mo13472ai(3, this.wen);
            c6093a.mo13480iz(4, this.weo);
            c6093a.mo13480iz(5, this.wep);
            c6093a.mo13474e(6, 8, this.vEh);
            c6093a.mo13480iz(7, this.weq);
            c6093a.mo13480iz(8, this.vIN);
            c6093a.mo13474e(9, 8, this.vIO);
            AppMethodBeat.m2505o(28388);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = (((((((ix + C6091a.m9572bs(2, this.wem)) + C6091a.m9578o(3, this.wen)) + C6091a.m9572bs(4, this.weo)) + C6091a.m9572bs(5, this.wep)) + C6087a.m9552c(6, 8, this.vEh)) + C6091a.m9572bs(7, this.weq)) + C6091a.m9572bs(8, this.vIN)) + C6087a.m9552c(9, 8, this.vIO);
            AppMethodBeat.m2505o(28388);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vEh.clear();
            this.vIO.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28388);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28388);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30247yn c30247yn = (C30247yn) objArr[1];
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
                        c30247yn.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(28388);
                    return 0;
                case 2:
                    c30247yn.wem = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28388);
                    return 0;
                case 3:
                    c30247yn.wen = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(28388);
                    return 0;
                case 4:
                    c30247yn.weo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28388);
                    return 0;
                case 5:
                    c30247yn.wep = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28388);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgm cgm = new cgm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgm.populateBuilderWithField(c6086a3, cgm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30247yn.vEh.add(cgm);
                    }
                    AppMethodBeat.m2505o(28388);
                    return 0;
                case 7:
                    c30247yn.weq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28388);
                    return 0;
                case 8:
                    c30247yn.vIN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28388);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgl cgl = new cgl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgl.populateBuilderWithField(c6086a3, cgl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30247yn.vIO.add(cgl);
                    }
                    AppMethodBeat.m2505o(28388);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28388);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28388);
            return -1;
        }
    }
}
