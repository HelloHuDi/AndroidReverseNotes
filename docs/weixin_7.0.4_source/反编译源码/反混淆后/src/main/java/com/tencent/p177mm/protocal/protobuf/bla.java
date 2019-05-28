package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bla */
public final class bla extends btd {
    public int kdT;
    public String kdU;
    public int vES;
    public String wCO;
    public boolean wCP = true;
    public aum wNW;
    public bls wNX;
    public String wNY;
    public int wNZ;
    public long wOa;
    public LinkedList<C40553oq> wmz = new LinkedList();

    public bla() {
        AppMethodBeat.m2504i(56923);
        AppMethodBeat.m2505o(56923);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56924);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56924);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.kdT);
            if (this.kdU != null) {
                c6093a.mo13475e(3, this.kdU);
            }
            if (this.wNW != null) {
                c6093a.mo13479iy(4, this.wNW.computeSize());
                this.wNW.writeFields(c6093a);
            }
            if (this.wNX != null) {
                c6093a.mo13479iy(5, this.wNX.computeSize());
                this.wNX.writeFields(c6093a);
            }
            if (this.wCO != null) {
                c6093a.mo13475e(6, this.wCO);
            }
            c6093a.mo13474e(7, 8, this.wmz);
            c6093a.mo13471aO(8, this.wCP);
            c6093a.mo13480iz(9, this.vES);
            if (this.wNY != null) {
                c6093a.mo13475e(10, this.wNY);
            }
            c6093a.mo13480iz(11, this.wNZ);
            c6093a.mo13472ai(12, this.wOa);
            AppMethodBeat.m2505o(56924);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.kdT);
            if (this.kdU != null) {
                ix += C6091a.m9575f(3, this.kdU);
            }
            if (this.wNW != null) {
                ix += C6087a.m9557ix(4, this.wNW.computeSize());
            }
            if (this.wNX != null) {
                ix += C6087a.m9557ix(5, this.wNX.computeSize());
            }
            if (this.wCO != null) {
                ix += C6091a.m9575f(6, this.wCO);
            }
            ix = ((ix + C6087a.m9552c(7, 8, this.wmz)) + (C6091a.m9576fv(8) + 1)) + C6091a.m9572bs(9, this.vES);
            if (this.wNY != null) {
                ix += C6091a.m9575f(10, this.wNY);
            }
            int bs = (ix + C6091a.m9572bs(11, this.wNZ)) + C6091a.m9578o(12, this.wOa);
            AppMethodBeat.m2505o(56924);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wmz.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56924);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56924);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bla bla = (bla) objArr[1];
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
                        bla.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(56924);
                    return 0;
                case 2:
                    bla.kdT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56924);
                    return 0;
                case 3:
                    bla.kdU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56924);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aum aum = new aum();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = aum.populateBuilderWithField(c6086a3, aum, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bla.wNW = aum;
                    }
                    AppMethodBeat.m2505o(56924);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bls bls = new bls();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bls.populateBuilderWithField(c6086a3, bls, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bla.wNX = bls;
                    }
                    AppMethodBeat.m2505o(56924);
                    return 0;
                case 6:
                    bla.wCO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56924);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40553oq c40553oq = new C40553oq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40553oq.populateBuilderWithField(c6086a3, c40553oq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bla.wmz.add(c40553oq);
                    }
                    AppMethodBeat.m2505o(56924);
                    return 0;
                case 8:
                    bla.wCP = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(56924);
                    return 0;
                case 9:
                    bla.vES = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56924);
                    return 0;
                case 10:
                    bla.wNY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56924);
                    return 0;
                case 11:
                    bla.wNZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56924);
                    return 0;
                case 12:
                    bla.wOa = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56924);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56924);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56924);
            return -1;
        }
    }
}
