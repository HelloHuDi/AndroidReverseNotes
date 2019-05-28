package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bon */
public final class bon extends btd {
    public long cSh;
    public int nSb;
    public int nSc;
    public String nSd;
    public String nSe;
    public String nSf;
    public int vzO;
    public int wKA;
    public long wKB;
    public long wKC;
    public LinkedList<ash> wKD = new LinkedList();
    public String wKE;
    public String wKF;
    public String wKG;
    public int wKH;
    public int wKI;
    public String wKJ;
    public int wKy;
    public int wKz;

    public bon() {
        AppMethodBeat.m2504i(56948);
        AppMethodBeat.m2505o(56948);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56949);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56949);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13472ai(2, this.cSh);
            c6093a.mo13480iz(3, this.wKA);
            c6093a.mo13472ai(4, this.wKB);
            c6093a.mo13480iz(5, this.vzO);
            c6093a.mo13472ai(6, this.wKC);
            c6093a.mo13480iz(9, this.nSc);
            c6093a.mo13474e(10, 8, this.wKD);
            if (this.nSd != null) {
                c6093a.mo13475e(11, this.nSd);
            }
            if (this.wKE != null) {
                c6093a.mo13475e(12, this.wKE);
            }
            if (this.wKF != null) {
                c6093a.mo13475e(13, this.wKF);
            }
            if (this.wKG != null) {
                c6093a.mo13475e(14, this.wKG);
            }
            c6093a.mo13480iz(15, this.wKH);
            if (this.nSf != null) {
                c6093a.mo13475e(16, this.nSf);
            }
            c6093a.mo13480iz(17, this.wKI);
            if (this.nSe != null) {
                c6093a.mo13475e(18, this.nSe);
            }
            c6093a.mo13480iz(19, this.wKz);
            c6093a.mo13480iz(20, this.nSb);
            c6093a.mo13480iz(21, this.wKy);
            if (this.wKJ != null) {
                c6093a.mo13475e(22, this.wKJ);
            }
            AppMethodBeat.m2505o(56949);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((((((ix + C6091a.m9578o(2, this.cSh)) + C6091a.m9572bs(3, this.wKA)) + C6091a.m9578o(4, this.wKB)) + C6091a.m9572bs(5, this.vzO)) + C6091a.m9578o(6, this.wKC)) + C6091a.m9572bs(9, this.nSc)) + C6087a.m9552c(10, 8, this.wKD);
            if (this.nSd != null) {
                ix += C6091a.m9575f(11, this.nSd);
            }
            if (this.wKE != null) {
                ix += C6091a.m9575f(12, this.wKE);
            }
            if (this.wKF != null) {
                ix += C6091a.m9575f(13, this.wKF);
            }
            if (this.wKG != null) {
                ix += C6091a.m9575f(14, this.wKG);
            }
            ix += C6091a.m9572bs(15, this.wKH);
            if (this.nSf != null) {
                ix += C6091a.m9575f(16, this.nSf);
            }
            ix += C6091a.m9572bs(17, this.wKI);
            if (this.nSe != null) {
                ix += C6091a.m9575f(18, this.nSe);
            }
            ix = ((ix + C6091a.m9572bs(19, this.wKz)) + C6091a.m9572bs(20, this.nSb)) + C6091a.m9572bs(21, this.wKy);
            if (this.wKJ != null) {
                ix += C6091a.m9575f(22, this.wKJ);
            }
            AppMethodBeat.m2505o(56949);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wKD.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56949);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56949);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bon bon = (bon) objArr[1];
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
                        bon.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(56949);
                    return 0;
                case 2:
                    bon.cSh = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56949);
                    return 0;
                case 3:
                    bon.wKA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56949);
                    return 0;
                case 4:
                    bon.wKB = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56949);
                    return 0;
                case 5:
                    bon.vzO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56949);
                    return 0;
                case 6:
                    bon.wKC = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56949);
                    return 0;
                case 9:
                    bon.nSc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56949);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ash ash = new ash();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ash.populateBuilderWithField(c6086a3, ash, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bon.wKD.add(ash);
                    }
                    AppMethodBeat.m2505o(56949);
                    return 0;
                case 11:
                    bon.nSd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56949);
                    return 0;
                case 12:
                    bon.wKE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56949);
                    return 0;
                case 13:
                    bon.wKF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56949);
                    return 0;
                case 14:
                    bon.wKG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56949);
                    return 0;
                case 15:
                    bon.wKH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56949);
                    return 0;
                case 16:
                    bon.nSf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56949);
                    return 0;
                case 17:
                    bon.wKI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56949);
                    return 0;
                case 18:
                    bon.nSe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56949);
                    return 0;
                case 19:
                    bon.wKz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56949);
                    return 0;
                case 20:
                    bon.nSb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56949);
                    return 0;
                case 21:
                    bon.wKy = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56949);
                    return 0;
                case 22:
                    bon.wKJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56949);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56949);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56949);
            return -1;
        }
    }
}
