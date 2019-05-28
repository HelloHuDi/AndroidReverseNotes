package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aag */
public final class aag extends btd {
    public int lSN;
    public String lSO;
    public LinkedList<axh> vWz = new LinkedList();
    public blr wfp;
    public String wfq;
    public String wfr;
    public String wfs;
    public String wft;
    public float wfu;
    public String wfv;

    public aag() {
        AppMethodBeat.m2504i(839);
        AppMethodBeat.m2505o(839);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(840);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(840);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 8, this.vWz);
            if (this.wfp != null) {
                c6093a.mo13479iy(3, this.wfp.computeSize());
                this.wfp.writeFields(c6093a);
            }
            if (this.wfq != null) {
                c6093a.mo13475e(4, this.wfq);
            }
            if (this.wfr != null) {
                c6093a.mo13475e(5, this.wfr);
            }
            if (this.wfs != null) {
                c6093a.mo13475e(6, this.wfs);
            }
            if (this.wft != null) {
                c6093a.mo13475e(7, this.wft);
            }
            c6093a.mo13481r(8, this.wfu);
            c6093a.mo13480iz(9, this.lSN);
            if (this.lSO != null) {
                c6093a.mo13475e(10, this.lSO);
            }
            if (this.wfv != null) {
                c6093a.mo13475e(11, this.wfv);
            }
            AppMethodBeat.m2505o(840);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6087a.m9552c(2, 8, this.vWz);
            if (this.wfp != null) {
                ix += C6087a.m9557ix(3, this.wfp.computeSize());
            }
            if (this.wfq != null) {
                ix += C6091a.m9575f(4, this.wfq);
            }
            if (this.wfr != null) {
                ix += C6091a.m9575f(5, this.wfr);
            }
            if (this.wfs != null) {
                ix += C6091a.m9575f(6, this.wfs);
            }
            if (this.wft != null) {
                ix += C6091a.m9575f(7, this.wft);
            }
            ix = (ix + (C6091a.m9576fv(8) + 4)) + C6091a.m9572bs(9, this.lSN);
            if (this.lSO != null) {
                ix += C6091a.m9575f(10, this.lSO);
            }
            if (this.wfv != null) {
                ix += C6091a.m9575f(11, this.wfv);
            }
            AppMethodBeat.m2505o(840);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vWz.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(840);
                throw c6092b;
            }
            AppMethodBeat.m2505o(840);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aag aag = (aag) objArr[1];
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
                        aag.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(840);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axh axh = new axh();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = axh.populateBuilderWithField(c6086a3, axh, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aag.vWz.add(axh);
                    }
                    AppMethodBeat.m2505o(840);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        blr blr = new blr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = blr.populateBuilderWithField(c6086a3, blr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aag.wfp = blr;
                    }
                    AppMethodBeat.m2505o(840);
                    return 0;
                case 4:
                    aag.wfq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(840);
                    return 0;
                case 5:
                    aag.wfr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(840);
                    return 0;
                case 6:
                    aag.wfs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(840);
                    return 0;
                case 7:
                    aag.wft = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(840);
                    return 0;
                case 8:
                    aag.wfu = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(840);
                    return 0;
                case 9:
                    aag.lSN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(840);
                    return 0;
                case 10:
                    aag.lSO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(840);
                    return 0;
                case 11:
                    aag.wfv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(840);
                    return 0;
                default:
                    AppMethodBeat.m2505o(840);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(840);
            return -1;
        }
    }
}
