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

/* renamed from: com.tencent.mm.protocal.protobuf.cou */
public final class cou extends btd {
    public int nwF;
    public int nwL;
    public int nwM;
    public int nwQ;
    public LinkedList<coo> vIO = new LinkedList();
    public C1332b wPf;
    public long wen;
    public int xdw;
    public long xeF;
    public int xmA;
    public int xmB;
    public LinkedList<coo> xmC = new LinkedList();
    public int xmz;

    public cou() {
        AppMethodBeat.m2504i(135448);
        AppMethodBeat.m2505o(135448);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(135449);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(135449);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13472ai(2, this.xeF);
            c6093a.mo13472ai(3, this.wen);
            c6093a.mo13474e(4, 8, this.vIO);
            c6093a.mo13480iz(5, this.xdw);
            c6093a.mo13480iz(6, this.nwL);
            c6093a.mo13480iz(7, this.nwM);
            c6093a.mo13480iz(8, this.nwF);
            c6093a.mo13480iz(9, this.nwQ);
            c6093a.mo13480iz(10, this.xmz);
            c6093a.mo13480iz(11, this.xmA);
            if (this.wPf != null) {
                c6093a.mo13473c(12, this.wPf);
            }
            c6093a.mo13480iz(13, this.xmB);
            c6093a.mo13474e(14, 8, this.xmC);
            AppMethodBeat.m2505o(135449);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (((((((((ix + C6091a.m9578o(2, this.xeF)) + C6091a.m9578o(3, this.wen)) + C6087a.m9552c(4, 8, this.vIO)) + C6091a.m9572bs(5, this.xdw)) + C6091a.m9572bs(6, this.nwL)) + C6091a.m9572bs(7, this.nwM)) + C6091a.m9572bs(8, this.nwF)) + C6091a.m9572bs(9, this.nwQ)) + C6091a.m9572bs(10, this.xmz)) + C6091a.m9572bs(11, this.xmA);
            if (this.wPf != null) {
                ix += C6091a.m9571b(12, this.wPf);
            }
            int bs = (ix + C6091a.m9572bs(13, this.xmB)) + C6087a.m9552c(14, 8, this.xmC);
            AppMethodBeat.m2505o(135449);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vIO.clear();
            this.xmC.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(135449);
                throw c6092b;
            }
            AppMethodBeat.m2505o(135449);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cou cou = (cou) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            coo coo;
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
                        cou.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(135449);
                    return 0;
                case 2:
                    cou.xeF = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(135449);
                    return 0;
                case 3:
                    cou.wen = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(135449);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        coo = new coo();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = coo.populateBuilderWithField(c6086a3, coo, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cou.vIO.add(coo);
                    }
                    AppMethodBeat.m2505o(135449);
                    return 0;
                case 5:
                    cou.xdw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135449);
                    return 0;
                case 6:
                    cou.nwL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135449);
                    return 0;
                case 7:
                    cou.nwM = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135449);
                    return 0;
                case 8:
                    cou.nwF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135449);
                    return 0;
                case 9:
                    cou.nwQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135449);
                    return 0;
                case 10:
                    cou.xmz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135449);
                    return 0;
                case 11:
                    cou.xmA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135449);
                    return 0;
                case 12:
                    cou.wPf = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(135449);
                    return 0;
                case 13:
                    cou.xmB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135449);
                    return 0;
                case 14:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        coo = new coo();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = coo.populateBuilderWithField(c6086a3, coo, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cou.xmC.add(coo);
                    }
                    AppMethodBeat.m2505o(135449);
                    return 0;
                default:
                    AppMethodBeat.m2505o(135449);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(135449);
            return -1;
        }
    }
}
