package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bzo */
public final class bzo extends btd {
    public String cxb;
    public String fhH;
    public String title;
    public String wIL;
    public C46543fz wXh;
    public int wYA;
    public C23388fy wYB;
    public String wYC;
    public LinkedList<C15342ga> wYD = new LinkedList();
    public String wYE;
    public String wYF;
    public C30185gb wYG;
    public LinkedList<C30185gb> wYH = new LinkedList();
    public cno wYI;
    public boolean wYJ;
    public String wYK;

    public bzo() {
        AppMethodBeat.m2504i(96292);
        AppMethodBeat.m2505o(96292);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96293);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(96293);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.wXh != null) {
                c6093a.mo13479iy(2, this.wXh.computeSize());
                this.wXh.writeFields(c6093a);
            }
            c6093a.mo13480iz(3, this.wYA);
            if (this.wYB != null) {
                c6093a.mo13479iy(4, this.wYB.computeSize());
                this.wYB.writeFields(c6093a);
            }
            if (this.title != null) {
                c6093a.mo13475e(5, this.title);
            }
            if (this.wIL != null) {
                c6093a.mo13475e(6, this.wIL);
            }
            if (this.fhH != null) {
                c6093a.mo13475e(7, this.fhH);
            }
            if (this.wYC != null) {
                c6093a.mo13475e(8, this.wYC);
            }
            c6093a.mo13474e(9, 8, this.wYD);
            if (this.wYE != null) {
                c6093a.mo13475e(10, this.wYE);
            }
            if (this.wYF != null) {
                c6093a.mo13475e(11, this.wYF);
            }
            if (this.wYG != null) {
                c6093a.mo13479iy(12, this.wYG.computeSize());
                this.wYG.writeFields(c6093a);
            }
            c6093a.mo13474e(13, 8, this.wYH);
            if (this.cxb != null) {
                c6093a.mo13475e(14, this.cxb);
            }
            if (this.wYI != null) {
                c6093a.mo13479iy(15, this.wYI.computeSize());
                this.wYI.writeFields(c6093a);
            }
            c6093a.mo13471aO(16, this.wYJ);
            if (this.wYK != null) {
                c6093a.mo13475e(17, this.wYK);
            }
            AppMethodBeat.m2505o(96293);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wXh != null) {
                ix += C6087a.m9557ix(2, this.wXh.computeSize());
            }
            ix += C6091a.m9572bs(3, this.wYA);
            if (this.wYB != null) {
                ix += C6087a.m9557ix(4, this.wYB.computeSize());
            }
            if (this.title != null) {
                ix += C6091a.m9575f(5, this.title);
            }
            if (this.wIL != null) {
                ix += C6091a.m9575f(6, this.wIL);
            }
            if (this.fhH != null) {
                ix += C6091a.m9575f(7, this.fhH);
            }
            if (this.wYC != null) {
                ix += C6091a.m9575f(8, this.wYC);
            }
            ix += C6087a.m9552c(9, 8, this.wYD);
            if (this.wYE != null) {
                ix += C6091a.m9575f(10, this.wYE);
            }
            if (this.wYF != null) {
                ix += C6091a.m9575f(11, this.wYF);
            }
            if (this.wYG != null) {
                ix += C6087a.m9557ix(12, this.wYG.computeSize());
            }
            ix += C6087a.m9552c(13, 8, this.wYH);
            if (this.cxb != null) {
                ix += C6091a.m9575f(14, this.cxb);
            }
            if (this.wYI != null) {
                ix += C6087a.m9557ix(15, this.wYI.computeSize());
            }
            ix += C6091a.m9576fv(16) + 1;
            if (this.wYK != null) {
                ix += C6091a.m9575f(17, this.wYK);
            }
            AppMethodBeat.m2505o(96293);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wYD.clear();
            this.wYH.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(96293);
                throw c6092b;
            }
            AppMethodBeat.m2505o(96293);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bzo bzo = (bzo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            C30185gb c30185gb;
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
                        bzo.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(96293);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46543fz c46543fz = new C46543fz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c46543fz.populateBuilderWithField(c6086a3, c46543fz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bzo.wXh = c46543fz;
                    }
                    AppMethodBeat.m2505o(96293);
                    return 0;
                case 3:
                    bzo.wYA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96293);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23388fy c23388fy = new C23388fy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23388fy.populateBuilderWithField(c6086a3, c23388fy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bzo.wYB = c23388fy;
                    }
                    AppMethodBeat.m2505o(96293);
                    return 0;
                case 5:
                    bzo.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96293);
                    return 0;
                case 6:
                    bzo.wIL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96293);
                    return 0;
                case 7:
                    bzo.fhH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96293);
                    return 0;
                case 8:
                    bzo.wYC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96293);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15342ga c15342ga = new C15342ga();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15342ga.populateBuilderWithField(c6086a3, c15342ga, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bzo.wYD.add(c15342ga);
                    }
                    AppMethodBeat.m2505o(96293);
                    return 0;
                case 10:
                    bzo.wYE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96293);
                    return 0;
                case 11:
                    bzo.wYF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96293);
                    return 0;
                case 12:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c30185gb = new C30185gb();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c30185gb.populateBuilderWithField(c6086a3, c30185gb, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bzo.wYG = c30185gb;
                    }
                    AppMethodBeat.m2505o(96293);
                    return 0;
                case 13:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c30185gb = new C30185gb();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c30185gb.populateBuilderWithField(c6086a3, c30185gb, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bzo.wYH.add(c30185gb);
                    }
                    AppMethodBeat.m2505o(96293);
                    return 0;
                case 14:
                    bzo.cxb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96293);
                    return 0;
                case 15:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cno cno = new cno();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cno.populateBuilderWithField(c6086a3, cno, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bzo.wYI = cno;
                    }
                    AppMethodBeat.m2505o(96293);
                    return 0;
                case 16:
                    bzo.wYJ = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(96293);
                    return 0;
                case 17:
                    bzo.wYK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96293);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96293);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96293);
            return -1;
        }
    }
}
