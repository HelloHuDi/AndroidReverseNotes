package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.anh */
public final class anh extends btd {
    public int kCl;
    public String kCm;
    public boolean ttQ;
    public String wrM;
    public String wrN;
    public String wrO;
    public String wrP;
    public String wrQ;
    public boolean wrR;
    public String wrS;
    public long wrT;
    public boolean wrU;
    public boolean wrV;
    public boolean wrW;
    public String wrX;
    public String wrY;
    public String wrZ;
    public String wsa;
    public boolean wsb;
    public LinkedList<String> wsc = new LinkedList();
    public awr wsd;
    public boolean wse;

    public anh() {
        AppMethodBeat.m2504i(56834);
        AppMethodBeat.m2505o(56834);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56835);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56835);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.kCl);
            if (this.kCm != null) {
                c6093a.mo13475e(3, this.kCm);
            }
            if (this.wrM != null) {
                c6093a.mo13475e(4, this.wrM);
            }
            if (this.wrN != null) {
                c6093a.mo13475e(5, this.wrN);
            }
            if (this.wrO != null) {
                c6093a.mo13475e(6, this.wrO);
            }
            if (this.wrP != null) {
                c6093a.mo13475e(7, this.wrP);
            }
            if (this.wrQ != null) {
                c6093a.mo13475e(8, this.wrQ);
            }
            c6093a.mo13471aO(9, this.wrR);
            if (this.wrS != null) {
                c6093a.mo13475e(10, this.wrS);
            }
            c6093a.mo13472ai(11, this.wrT);
            c6093a.mo13471aO(12, this.wrU);
            c6093a.mo13471aO(13, this.wrV);
            c6093a.mo13471aO(14, this.wrW);
            if (this.wrX != null) {
                c6093a.mo13475e(15, this.wrX);
            }
            if (this.wrY != null) {
                c6093a.mo13475e(16, this.wrY);
            }
            if (this.wrZ != null) {
                c6093a.mo13475e(17, this.wrZ);
            }
            if (this.wsa != null) {
                c6093a.mo13475e(18, this.wsa);
            }
            c6093a.mo13471aO(19, this.wsb);
            c6093a.mo13474e(20, 1, this.wsc);
            c6093a.mo13471aO(21, this.ttQ);
            if (this.wsd != null) {
                c6093a.mo13479iy(22, this.wsd.computeSize());
                this.wsd.writeFields(c6093a);
            }
            c6093a.mo13471aO(23, this.wse);
            AppMethodBeat.m2505o(56835);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.kCl);
            if (this.kCm != null) {
                ix += C6091a.m9575f(3, this.kCm);
            }
            if (this.wrM != null) {
                ix += C6091a.m9575f(4, this.wrM);
            }
            if (this.wrN != null) {
                ix += C6091a.m9575f(5, this.wrN);
            }
            if (this.wrO != null) {
                ix += C6091a.m9575f(6, this.wrO);
            }
            if (this.wrP != null) {
                ix += C6091a.m9575f(7, this.wrP);
            }
            if (this.wrQ != null) {
                ix += C6091a.m9575f(8, this.wrQ);
            }
            ix += C6091a.m9576fv(9) + 1;
            if (this.wrS != null) {
                ix += C6091a.m9575f(10, this.wrS);
            }
            ix = (((ix + C6091a.m9578o(11, this.wrT)) + (C6091a.m9576fv(12) + 1)) + (C6091a.m9576fv(13) + 1)) + (C6091a.m9576fv(14) + 1);
            if (this.wrX != null) {
                ix += C6091a.m9575f(15, this.wrX);
            }
            if (this.wrY != null) {
                ix += C6091a.m9575f(16, this.wrY);
            }
            if (this.wrZ != null) {
                ix += C6091a.m9575f(17, this.wrZ);
            }
            if (this.wsa != null) {
                ix += C6091a.m9575f(18, this.wsa);
            }
            ix = ((ix + (C6091a.m9576fv(19) + 1)) + C6087a.m9552c(20, 1, this.wsc)) + (C6091a.m9576fv(21) + 1);
            if (this.wsd != null) {
                ix += C6087a.m9557ix(22, this.wsd.computeSize());
            }
            int fv = ix + (C6091a.m9576fv(23) + 1);
            AppMethodBeat.m2505o(56835);
            return fv;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wsc.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56835);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56835);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            anh anh = (anh) objArr[1];
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
                        anh.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(56835);
                    return 0;
                case 2:
                    anh.kCl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56835);
                    return 0;
                case 3:
                    anh.kCm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56835);
                    return 0;
                case 4:
                    anh.wrM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56835);
                    return 0;
                case 5:
                    anh.wrN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56835);
                    return 0;
                case 6:
                    anh.wrO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56835);
                    return 0;
                case 7:
                    anh.wrP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56835);
                    return 0;
                case 8:
                    anh.wrQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56835);
                    return 0;
                case 9:
                    anh.wrR = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(56835);
                    return 0;
                case 10:
                    anh.wrS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56835);
                    return 0;
                case 11:
                    anh.wrT = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56835);
                    return 0;
                case 12:
                    anh.wrU = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(56835);
                    return 0;
                case 13:
                    anh.wrV = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(56835);
                    return 0;
                case 14:
                    anh.wrW = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(56835);
                    return 0;
                case 15:
                    anh.wrX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56835);
                    return 0;
                case 16:
                    anh.wrY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56835);
                    return 0;
                case 17:
                    anh.wrZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56835);
                    return 0;
                case 18:
                    anh.wsa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56835);
                    return 0;
                case 19:
                    anh.wsb = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(56835);
                    return 0;
                case 20:
                    anh.wsc.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(56835);
                    return 0;
                case 21:
                    anh.ttQ = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(56835);
                    return 0;
                case 22:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        awr awr = new awr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = awr.populateBuilderWithField(c6086a3, awr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        anh.wsd = awr;
                    }
                    AppMethodBeat.m2505o(56835);
                    return 0;
                case 23:
                    anh.wse = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(56835);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56835);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56835);
            return -1;
        }
    }
}
