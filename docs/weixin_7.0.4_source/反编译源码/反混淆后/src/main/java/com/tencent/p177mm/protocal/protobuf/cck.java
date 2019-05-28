package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cck */
public final class cck extends btd {
    public int jCt;
    public String ptv;
    public int ptw;
    public int ptx;
    public long vQE;
    public int wFB;
    public LinkedList<caq> wFC = new LinkedList();
    public caq xbP;

    public cck() {
        AppMethodBeat.m2504i(94621);
        AppMethodBeat.m2505o(94621);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94622);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(94622);
                throw c6092b;
            } else if (this.xbP == null) {
                c6092b = new C6092b("Not all required fields were included: BufferUrl");
                AppMethodBeat.m2505o(94622);
                throw c6092b;
            } else {
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                c6093a.mo13480iz(2, this.ptx);
                c6093a.mo13480iz(3, this.ptw);
                if (this.ptv != null) {
                    c6093a.mo13475e(4, this.ptv);
                }
                if (this.xbP != null) {
                    c6093a.mo13479iy(5, this.xbP.computeSize());
                    this.xbP.writeFields(c6093a);
                }
                c6093a.mo13480iz(6, this.wFB);
                c6093a.mo13474e(7, 8, this.wFC);
                c6093a.mo13472ai(8, this.vQE);
                c6093a.mo13480iz(9, this.jCt);
                AppMethodBeat.m2505o(94622);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6091a.m9572bs(2, this.ptx)) + C6091a.m9572bs(3, this.ptw);
            if (this.ptv != null) {
                ix += C6091a.m9575f(4, this.ptv);
            }
            if (this.xbP != null) {
                ix += C6087a.m9557ix(5, this.xbP.computeSize());
            }
            int bs = (((ix + C6091a.m9572bs(6, this.wFB)) + C6087a.m9552c(7, 8, this.wFC)) + C6091a.m9578o(8, this.vQE)) + C6091a.m9572bs(9, this.jCt);
            AppMethodBeat.m2505o(94622);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wFC.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(94622);
                throw c6092b;
            } else if (this.xbP == null) {
                c6092b = new C6092b("Not all required fields were included: BufferUrl");
                AppMethodBeat.m2505o(94622);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(94622);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cck cck = (cck) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            caq caq;
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
                        cck.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(94622);
                    return 0;
                case 2:
                    cck.ptx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94622);
                    return 0;
                case 3:
                    cck.ptw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94622);
                    return 0;
                case 4:
                    cck.ptv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94622);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        caq = new caq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = caq.populateBuilderWithField(c6086a3, caq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cck.xbP = caq;
                    }
                    AppMethodBeat.m2505o(94622);
                    return 0;
                case 6:
                    cck.wFB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94622);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        caq = new caq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = caq.populateBuilderWithField(c6086a3, caq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cck.wFC.add(caq);
                    }
                    AppMethodBeat.m2505o(94622);
                    return 0;
                case 8:
                    cck.vQE = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94622);
                    return 0;
                case 9:
                    cck.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94622);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94622);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94622);
            return -1;
        }
    }
}
