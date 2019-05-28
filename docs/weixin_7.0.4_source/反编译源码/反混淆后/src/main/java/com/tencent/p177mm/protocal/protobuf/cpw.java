package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cpw */
public final class cpw extends btd {
    public int wPb;
    public int wem;
    public long wen;
    public LinkedList<coj> xmC = new LinkedList();
    public int xnR;
    public LinkedList<coj> xnS = new LinkedList();
    public int xnT;
    public LinkedList<coj> xnU = new LinkedList();
    public int xnV;
    public int xnW;
    public int xnX;

    public cpw() {
        AppMethodBeat.m2504i(5261);
        AppMethodBeat.m2505o(5261);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5262);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(5262);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.wem);
            c6093a.mo13480iz(3, this.xnR);
            c6093a.mo13474e(4, 8, this.xnS);
            c6093a.mo13480iz(5, this.xnT);
            c6093a.mo13474e(6, 8, this.xnU);
            c6093a.mo13472ai(7, this.wen);
            c6093a.mo13480iz(8, this.wPb);
            c6093a.mo13480iz(9, this.xnV);
            c6093a.mo13474e(10, 8, this.xmC);
            c6093a.mo13480iz(11, this.xnW);
            c6093a.mo13480iz(12, this.xnX);
            AppMethodBeat.m2505o(5262);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = ((((((((((ix + C6091a.m9572bs(2, this.wem)) + C6091a.m9572bs(3, this.xnR)) + C6087a.m9552c(4, 8, this.xnS)) + C6091a.m9572bs(5, this.xnT)) + C6087a.m9552c(6, 8, this.xnU)) + C6091a.m9578o(7, this.wen)) + C6091a.m9572bs(8, this.wPb)) + C6091a.m9572bs(9, this.xnV)) + C6087a.m9552c(10, 8, this.xmC)) + C6091a.m9572bs(11, this.xnW)) + C6091a.m9572bs(12, this.xnX);
            AppMethodBeat.m2505o(5262);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xnS.clear();
            this.xnU.clear();
            this.xmC.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(5262);
                throw c6092b;
            }
            AppMethodBeat.m2505o(5262);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cpw cpw = (cpw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            coj coj;
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
                        cpw.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(5262);
                    return 0;
                case 2:
                    cpw.wem = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5262);
                    return 0;
                case 3:
                    cpw.xnR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5262);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        coj = new coj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = coj.populateBuilderWithField(c6086a3, coj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cpw.xnS.add(coj);
                    }
                    AppMethodBeat.m2505o(5262);
                    return 0;
                case 5:
                    cpw.xnT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5262);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        coj = new coj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = coj.populateBuilderWithField(c6086a3, coj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cpw.xnU.add(coj);
                    }
                    AppMethodBeat.m2505o(5262);
                    return 0;
                case 7:
                    cpw.wen = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(5262);
                    return 0;
                case 8:
                    cpw.wPb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5262);
                    return 0;
                case 9:
                    cpw.xnV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5262);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        coj = new coj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = coj.populateBuilderWithField(c6086a3, coj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cpw.xmC.add(coj);
                    }
                    AppMethodBeat.m2505o(5262);
                    return 0;
                case 11:
                    cpw.xnW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5262);
                    return 0;
                case 12:
                    cpw.xnX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5262);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5262);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5262);
            return -1;
        }
    }
}
