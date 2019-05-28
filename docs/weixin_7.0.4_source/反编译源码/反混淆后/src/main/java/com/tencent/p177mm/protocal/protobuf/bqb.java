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

/* renamed from: com.tencent.mm.protocal.protobuf.bqb */
public final class bqb extends btd {
    public String kfM;
    public int nSb;
    public int nSc;
    public String nSd;
    public String wKE;
    public String wKF;
    public String wKG;
    public int wKH;
    public String wKJ;
    public C1332b wKx;
    public int wKy;
    public int wKz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56953);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56953);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.wKy);
            if (this.nSd != null) {
                c6093a.mo13475e(3, this.nSd);
            }
            if (this.wKF != null) {
                c6093a.mo13475e(4, this.wKF);
            }
            if (this.wKG != null) {
                c6093a.mo13475e(5, this.wKG);
            }
            if (this.wKx != null) {
                c6093a.mo13473c(6, this.wKx);
            }
            c6093a.mo13480iz(7, this.wKz);
            c6093a.mo13480iz(8, this.nSb);
            c6093a.mo13480iz(9, this.wKH);
            c6093a.mo13480iz(10, this.nSc);
            if (this.kfM != null) {
                c6093a.mo13475e(11, this.kfM);
            }
            if (this.wKJ != null) {
                c6093a.mo13475e(12, this.wKJ);
            }
            if (this.wKE != null) {
                c6093a.mo13475e(13, this.wKE);
            }
            AppMethodBeat.m2505o(56953);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.wKy);
            if (this.nSd != null) {
                ix += C6091a.m9575f(3, this.nSd);
            }
            if (this.wKF != null) {
                ix += C6091a.m9575f(4, this.wKF);
            }
            if (this.wKG != null) {
                ix += C6091a.m9575f(5, this.wKG);
            }
            if (this.wKx != null) {
                ix += C6091a.m9571b(6, this.wKx);
            }
            ix = (((ix + C6091a.m9572bs(7, this.wKz)) + C6091a.m9572bs(8, this.nSb)) + C6091a.m9572bs(9, this.wKH)) + C6091a.m9572bs(10, this.nSc);
            if (this.kfM != null) {
                ix += C6091a.m9575f(11, this.kfM);
            }
            if (this.wKJ != null) {
                ix += C6091a.m9575f(12, this.wKJ);
            }
            if (this.wKE != null) {
                ix += C6091a.m9575f(13, this.wKE);
            }
            AppMethodBeat.m2505o(56953);
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
                AppMethodBeat.m2505o(56953);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56953);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bqb bqb = (bqb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bqb.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(56953);
                    return 0;
                case 2:
                    bqb.wKy = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56953);
                    return 0;
                case 3:
                    bqb.nSd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56953);
                    return 0;
                case 4:
                    bqb.wKF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56953);
                    return 0;
                case 5:
                    bqb.wKG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56953);
                    return 0;
                case 6:
                    bqb.wKx = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(56953);
                    return 0;
                case 7:
                    bqb.wKz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56953);
                    return 0;
                case 8:
                    bqb.nSb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56953);
                    return 0;
                case 9:
                    bqb.wKH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56953);
                    return 0;
                case 10:
                    bqb.nSc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56953);
                    return 0;
                case 11:
                    bqb.kfM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56953);
                    return 0;
                case 12:
                    bqb.wKJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56953);
                    return 0;
                case 13:
                    bqb.wKE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56953);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56953);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56953);
            return -1;
        }
    }
}
