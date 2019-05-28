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

/* renamed from: com.tencent.mm.protocal.protobuf.bmb */
public final class bmb extends btd {
    public int nwA;
    public String nwB;
    public int nwF;
    public int nwL;
    public int nwM;
    public int nwN;
    public C1332b nwO;
    public int nwQ;
    public int nwT;
    public LinkedList<blt> vIO = new LinkedList();
    public long wOS;
    public int wPb;
    public int wPc;
    public LinkedList<blt> wPd = new LinkedList();
    public String wPe;
    public C1332b wPf;
    public int wPg;
    public int wem;
    public long wen;

    public bmb() {
        AppMethodBeat.m2504i(28582);
        AppMethodBeat.m2505o(28582);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28583);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28583);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.wem);
            c6093a.mo13472ai(3, this.wen);
            c6093a.mo13480iz(4, this.wPb);
            c6093a.mo13474e(5, 8, this.vIO);
            c6093a.mo13480iz(6, this.wPc);
            c6093a.mo13480iz(7, this.nwL);
            c6093a.mo13480iz(8, this.nwM);
            c6093a.mo13472ai(9, this.wOS);
            c6093a.mo13480iz(10, this.nwN);
            if (this.nwO != null) {
                c6093a.mo13473c(11, this.nwO);
            }
            c6093a.mo13480iz(12, this.nwF);
            c6093a.mo13480iz(13, this.nwA);
            if (this.nwB != null) {
                c6093a.mo13475e(14, this.nwB);
            }
            c6093a.mo13480iz(15, this.nwQ);
            c6093a.mo13474e(16, 8, this.wPd);
            c6093a.mo13480iz(17, this.nwT);
            if (this.wPe != null) {
                c6093a.mo13475e(18, this.wPe);
            }
            if (this.wPf != null) {
                c6093a.mo13473c(19, this.wPf);
            }
            c6093a.mo13480iz(20, this.wPg);
            AppMethodBeat.m2505o(28583);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((((((((ix + C6091a.m9572bs(2, this.wem)) + C6091a.m9578o(3, this.wen)) + C6091a.m9572bs(4, this.wPb)) + C6087a.m9552c(5, 8, this.vIO)) + C6091a.m9572bs(6, this.wPc)) + C6091a.m9572bs(7, this.nwL)) + C6091a.m9572bs(8, this.nwM)) + C6091a.m9578o(9, this.wOS)) + C6091a.m9572bs(10, this.nwN);
            if (this.nwO != null) {
                ix += C6091a.m9571b(11, this.nwO);
            }
            ix = (ix + C6091a.m9572bs(12, this.nwF)) + C6091a.m9572bs(13, this.nwA);
            if (this.nwB != null) {
                ix += C6091a.m9575f(14, this.nwB);
            }
            ix = ((ix + C6091a.m9572bs(15, this.nwQ)) + C6087a.m9552c(16, 8, this.wPd)) + C6091a.m9572bs(17, this.nwT);
            if (this.wPe != null) {
                ix += C6091a.m9575f(18, this.wPe);
            }
            if (this.wPf != null) {
                ix += C6091a.m9571b(19, this.wPf);
            }
            int bs = ix + C6091a.m9572bs(20, this.wPg);
            AppMethodBeat.m2505o(28583);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vIO.clear();
            this.wPd.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28583);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28583);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bmb bmb = (bmb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            blt blt;
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
                        bmb.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(28583);
                    return 0;
                case 2:
                    bmb.wem = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28583);
                    return 0;
                case 3:
                    bmb.wen = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(28583);
                    return 0;
                case 4:
                    bmb.wPb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28583);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        blt = new blt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = blt.populateBuilderWithField(c6086a3, blt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bmb.vIO.add(blt);
                    }
                    AppMethodBeat.m2505o(28583);
                    return 0;
                case 6:
                    bmb.wPc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28583);
                    return 0;
                case 7:
                    bmb.nwL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28583);
                    return 0;
                case 8:
                    bmb.nwM = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28583);
                    return 0;
                case 9:
                    bmb.wOS = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(28583);
                    return 0;
                case 10:
                    bmb.nwN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28583);
                    return 0;
                case 11:
                    bmb.nwO = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(28583);
                    return 0;
                case 12:
                    bmb.nwF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28583);
                    return 0;
                case 13:
                    bmb.nwA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28583);
                    return 0;
                case 14:
                    bmb.nwB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28583);
                    return 0;
                case 15:
                    bmb.nwQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28583);
                    return 0;
                case 16:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        blt = new blt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = blt.populateBuilderWithField(c6086a3, blt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bmb.wPd.add(blt);
                    }
                    AppMethodBeat.m2505o(28583);
                    return 0;
                case 17:
                    bmb.nwT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28583);
                    return 0;
                case 18:
                    bmb.wPe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28583);
                    return 0;
                case 19:
                    bmb.wPf = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(28583);
                    return 0;
                case 20:
                    bmb.wPg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28583);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28583);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28583);
            return -1;
        }
    }
}
