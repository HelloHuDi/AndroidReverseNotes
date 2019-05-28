package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.apr */
public final class apr extends btd {
    public int lCg;
    public boolean lvH;
    public String lvw;
    public String lvy;
    public String source;
    public LinkedList<ach> vEx = new LinkedList();
    public LinkedList<cdo> vFi = new LinkedList();
    public String wtC;
    public cyk wtD;
    public LinkedList<cym> wtE = new LinkedList();
    public LinkedList<cyl> wtF = new LinkedList();
    public LinkedList<String> wtG = new LinkedList();
    public String wtH;
    public String wtI;
    public LinkedList<C44146mq> wtJ = new LinkedList();
    public boolean wtK;

    public apr() {
        AppMethodBeat.m2504i(28479);
        AppMethodBeat.m2505o(28479);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28480);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28480);
                throw c6092b;
            } else if (this.wtC == null) {
                c6092b = new C6092b("Not all required fields were included: coverurl");
                AppMethodBeat.m2505o(28480);
                throw c6092b;
            } else if (this.lvy == null) {
                c6092b = new C6092b("Not all required fields were included: motto");
                AppMethodBeat.m2505o(28480);
                throw c6092b;
            } else if (this.wtD == null) {
                c6092b = new C6092b("Not all required fields were included: rankdesc");
                AppMethodBeat.m2505o(28480);
                throw c6092b;
            } else {
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                if (this.wtC != null) {
                    c6093a.mo13475e(2, this.wtC);
                }
                if (this.lvy != null) {
                    c6093a.mo13475e(3, this.lvy);
                }
                if (this.wtD != null) {
                    c6093a.mo13479iy(4, this.wtD.computeSize());
                    this.wtD.writeFields(c6093a);
                }
                c6093a.mo13474e(5, 8, this.wtE);
                c6093a.mo13474e(6, 8, this.wtF);
                if (this.source != null) {
                    c6093a.mo13475e(7, this.source);
                }
                c6093a.mo13474e(8, 1, this.wtG);
                if (this.wtH != null) {
                    c6093a.mo13475e(9, this.wtH);
                }
                if (this.wtI != null) {
                    c6093a.mo13475e(10, this.wtI);
                }
                c6093a.mo13474e(14, 8, this.vFi);
                c6093a.mo13474e(15, 8, this.vEx);
                c6093a.mo13471aO(16, this.lvH);
                c6093a.mo13474e(17, 8, this.wtJ);
                c6093a.mo13471aO(18, this.wtK);
                c6093a.mo13480iz(19, this.lCg);
                if (this.lvw != null) {
                    c6093a.mo13475e(20, this.lvw);
                }
                AppMethodBeat.m2505o(28480);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wtC != null) {
                ix += C6091a.m9575f(2, this.wtC);
            }
            if (this.lvy != null) {
                ix += C6091a.m9575f(3, this.lvy);
            }
            if (this.wtD != null) {
                ix += C6087a.m9557ix(4, this.wtD.computeSize());
            }
            ix = (ix + C6087a.m9552c(5, 8, this.wtE)) + C6087a.m9552c(6, 8, this.wtF);
            if (this.source != null) {
                ix += C6091a.m9575f(7, this.source);
            }
            ix += C6087a.m9552c(8, 1, this.wtG);
            if (this.wtH != null) {
                ix += C6091a.m9575f(9, this.wtH);
            }
            if (this.wtI != null) {
                ix += C6091a.m9575f(10, this.wtI);
            }
            ix = (((((ix + C6087a.m9552c(14, 8, this.vFi)) + C6087a.m9552c(15, 8, this.vEx)) + (C6091a.m9576fv(16) + 1)) + C6087a.m9552c(17, 8, this.wtJ)) + (C6091a.m9576fv(18) + 1)) + C6091a.m9572bs(19, this.lCg);
            if (this.lvw != null) {
                ix += C6091a.m9575f(20, this.lvw);
            }
            AppMethodBeat.m2505o(28480);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wtE.clear();
            this.wtF.clear();
            this.wtG.clear();
            this.vFi.clear();
            this.vEx.clear();
            this.wtJ.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28480);
                throw c6092b;
            } else if (this.wtC == null) {
                c6092b = new C6092b("Not all required fields were included: coverurl");
                AppMethodBeat.m2505o(28480);
                throw c6092b;
            } else if (this.lvy == null) {
                c6092b = new C6092b("Not all required fields were included: motto");
                AppMethodBeat.m2505o(28480);
                throw c6092b;
            } else if (this.wtD == null) {
                c6092b = new C6092b("Not all required fields were included: rankdesc");
                AppMethodBeat.m2505o(28480);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(28480);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            apr apr = (apr) objArr[1];
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
                        apr.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(28480);
                    return 0;
                case 2:
                    apr.wtC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28480);
                    return 0;
                case 3:
                    apr.lvy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28480);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cyk cyk = new cyk();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cyk.populateBuilderWithField(c6086a3, cyk, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        apr.wtD = cyk;
                    }
                    AppMethodBeat.m2505o(28480);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cym cym = new cym();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cym.populateBuilderWithField(c6086a3, cym, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        apr.wtE.add(cym);
                    }
                    AppMethodBeat.m2505o(28480);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cyl cyl = new cyl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cyl.populateBuilderWithField(c6086a3, cyl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        apr.wtF.add(cyl);
                    }
                    AppMethodBeat.m2505o(28480);
                    return 0;
                case 7:
                    apr.source = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28480);
                    return 0;
                case 8:
                    apr.wtG.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(28480);
                    return 0;
                case 9:
                    apr.wtH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28480);
                    return 0;
                case 10:
                    apr.wtI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28480);
                    return 0;
                case 14:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdo cdo = new cdo();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdo.populateBuilderWithField(c6086a3, cdo, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        apr.vFi.add(cdo);
                    }
                    AppMethodBeat.m2505o(28480);
                    return 0;
                case 15:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ach ach = new ach();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ach.populateBuilderWithField(c6086a3, ach, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        apr.vEx.add(ach);
                    }
                    AppMethodBeat.m2505o(28480);
                    return 0;
                case 16:
                    apr.lvH = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(28480);
                    return 0;
                case 17:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C44146mq c44146mq = new C44146mq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44146mq.populateBuilderWithField(c6086a3, c44146mq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        apr.wtJ.add(c44146mq);
                    }
                    AppMethodBeat.m2505o(28480);
                    return 0;
                case 18:
                    apr.wtK = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(28480);
                    return 0;
                case 19:
                    apr.lCg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28480);
                    return 0;
                case 20:
                    apr.lvw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28480);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28480);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28480);
            return -1;
        }
    }
}
