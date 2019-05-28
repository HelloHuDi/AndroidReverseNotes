package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bjg */
public final class bjg extends btd {
    public int cyE;
    public String cyF;
    public int okT;
    public String tCM;
    public csl wMA;
    public boolean wMB;
    public LinkedList<String> wMC = new LinkedList();
    public csi wMD;
    public csn wMx;
    public csk wMy;
    public csg wMz;

    public bjg() {
        AppMethodBeat.m2504i(56893);
        AppMethodBeat.m2505o(56893);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56894);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56894);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.cyE);
            if (this.cyF != null) {
                c6093a.mo13475e(3, this.cyF);
            }
            if (this.wMx != null) {
                c6093a.mo13479iy(4, this.wMx.computeSize());
                this.wMx.writeFields(c6093a);
            }
            if (this.wMy != null) {
                c6093a.mo13479iy(5, this.wMy.computeSize());
                this.wMy.writeFields(c6093a);
            }
            if (this.wMz != null) {
                c6093a.mo13479iy(6, this.wMz.computeSize());
                this.wMz.writeFields(c6093a);
            }
            if (this.wMA != null) {
                c6093a.mo13479iy(7, this.wMA.computeSize());
                this.wMA.writeFields(c6093a);
            }
            c6093a.mo13480iz(8, this.okT);
            c6093a.mo13471aO(9, this.wMB);
            if (this.tCM != null) {
                c6093a.mo13475e(10, this.tCM);
            }
            c6093a.mo13474e(11, 1, this.wMC);
            if (this.wMD != null) {
                c6093a.mo13479iy(12, this.wMD.computeSize());
                this.wMD.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(56894);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.cyE);
            if (this.cyF != null) {
                ix += C6091a.m9575f(3, this.cyF);
            }
            if (this.wMx != null) {
                ix += C6087a.m9557ix(4, this.wMx.computeSize());
            }
            if (this.wMy != null) {
                ix += C6087a.m9557ix(5, this.wMy.computeSize());
            }
            if (this.wMz != null) {
                ix += C6087a.m9557ix(6, this.wMz.computeSize());
            }
            if (this.wMA != null) {
                ix += C6087a.m9557ix(7, this.wMA.computeSize());
            }
            ix = (ix + C6091a.m9572bs(8, this.okT)) + (C6091a.m9576fv(9) + 1);
            if (this.tCM != null) {
                ix += C6091a.m9575f(10, this.tCM);
            }
            ix += C6087a.m9552c(11, 1, this.wMC);
            if (this.wMD != null) {
                ix += C6087a.m9557ix(12, this.wMD.computeSize());
            }
            AppMethodBeat.m2505o(56894);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wMC.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56894);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56894);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bjg bjg = (bjg) objArr[1];
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
                        bjg.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(56894);
                    return 0;
                case 2:
                    bjg.cyE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56894);
                    return 0;
                case 3:
                    bjg.cyF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56894);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        csn csn = new csn();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = csn.populateBuilderWithField(c6086a3, csn, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bjg.wMx = csn;
                    }
                    AppMethodBeat.m2505o(56894);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        csk csk = new csk();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = csk.populateBuilderWithField(c6086a3, csk, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bjg.wMy = csk;
                    }
                    AppMethodBeat.m2505o(56894);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        csg csg = new csg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = csg.populateBuilderWithField(c6086a3, csg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bjg.wMz = csg;
                    }
                    AppMethodBeat.m2505o(56894);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        csl csl = new csl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = csl.populateBuilderWithField(c6086a3, csl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bjg.wMA = csl;
                    }
                    AppMethodBeat.m2505o(56894);
                    return 0;
                case 8:
                    bjg.okT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56894);
                    return 0;
                case 9:
                    bjg.wMB = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(56894);
                    return 0;
                case 10:
                    bjg.tCM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56894);
                    return 0;
                case 11:
                    bjg.wMC.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(56894);
                    return 0;
                case 12:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        csi csi = new csi();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = csi.populateBuilderWithField(c6086a3, csi, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bjg.wMD = csi;
                    }
                    AppMethodBeat.m2505o(56894);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56894);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56894);
            return -1;
        }
    }
}
