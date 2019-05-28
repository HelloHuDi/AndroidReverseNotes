package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aqq */
public final class aqq extends btd {
    public String Desc;
    public String Title;
    public String nzz;
    public String wuA;
    public String wuB;
    public String wuC;
    public String wuD;
    public String wuE;
    public int wug;
    public LinkedList<crw> wuh = new LinkedList();
    public String wut;
    public String wuu;
    public String wuv;
    public String wuw;
    public String wux;
    public String wuy;
    public csc wuz;

    public aqq() {
        AppMethodBeat.m2504i(28508);
        AppMethodBeat.m2505o(28508);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28509);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28509);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.wut != null) {
                c6093a.mo13475e(2, this.wut);
            }
            if (this.nzz != null) {
                c6093a.mo13475e(3, this.nzz);
            }
            if (this.Title != null) {
                c6093a.mo13475e(4, this.Title);
            }
            if (this.Desc != null) {
                c6093a.mo13475e(5, this.Desc);
            }
            if (this.wuu != null) {
                c6093a.mo13475e(6, this.wuu);
            }
            if (this.wuv != null) {
                c6093a.mo13475e(7, this.wuv);
            }
            if (this.wuw != null) {
                c6093a.mo13475e(8, this.wuw);
            }
            if (this.wux != null) {
                c6093a.mo13475e(9, this.wux);
            }
            if (this.wuy != null) {
                c6093a.mo13475e(10, this.wuy);
            }
            if (this.wuz != null) {
                c6093a.mo13479iy(11, this.wuz.computeSize());
                this.wuz.writeFields(c6093a);
            }
            if (this.wuA != null) {
                c6093a.mo13475e(12, this.wuA);
            }
            if (this.wuB != null) {
                c6093a.mo13475e(13, this.wuB);
            }
            if (this.wuC != null) {
                c6093a.mo13475e(14, this.wuC);
            }
            if (this.wuD != null) {
                c6093a.mo13475e(15, this.wuD);
            }
            if (this.wuE != null) {
                c6093a.mo13475e(16, this.wuE);
            }
            c6093a.mo13480iz(17, this.wug);
            c6093a.mo13474e(18, 8, this.wuh);
            AppMethodBeat.m2505o(28509);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wut != null) {
                ix += C6091a.m9575f(2, this.wut);
            }
            if (this.nzz != null) {
                ix += C6091a.m9575f(3, this.nzz);
            }
            if (this.Title != null) {
                ix += C6091a.m9575f(4, this.Title);
            }
            if (this.Desc != null) {
                ix += C6091a.m9575f(5, this.Desc);
            }
            if (this.wuu != null) {
                ix += C6091a.m9575f(6, this.wuu);
            }
            if (this.wuv != null) {
                ix += C6091a.m9575f(7, this.wuv);
            }
            if (this.wuw != null) {
                ix += C6091a.m9575f(8, this.wuw);
            }
            if (this.wux != null) {
                ix += C6091a.m9575f(9, this.wux);
            }
            if (this.wuy != null) {
                ix += C6091a.m9575f(10, this.wuy);
            }
            if (this.wuz != null) {
                ix += C6087a.m9557ix(11, this.wuz.computeSize());
            }
            if (this.wuA != null) {
                ix += C6091a.m9575f(12, this.wuA);
            }
            if (this.wuB != null) {
                ix += C6091a.m9575f(13, this.wuB);
            }
            if (this.wuC != null) {
                ix += C6091a.m9575f(14, this.wuC);
            }
            if (this.wuD != null) {
                ix += C6091a.m9575f(15, this.wuD);
            }
            if (this.wuE != null) {
                ix += C6091a.m9575f(16, this.wuE);
            }
            int bs = (ix + C6091a.m9572bs(17, this.wug)) + C6087a.m9552c(18, 8, this.wuh);
            AppMethodBeat.m2505o(28509);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wuh.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28509);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28509);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aqq aqq = (aqq) objArr[1];
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
                        aqq.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(28509);
                    return 0;
                case 2:
                    aqq.wut = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28509);
                    return 0;
                case 3:
                    aqq.nzz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28509);
                    return 0;
                case 4:
                    aqq.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28509);
                    return 0;
                case 5:
                    aqq.Desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28509);
                    return 0;
                case 6:
                    aqq.wuu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28509);
                    return 0;
                case 7:
                    aqq.wuv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28509);
                    return 0;
                case 8:
                    aqq.wuw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28509);
                    return 0;
                case 9:
                    aqq.wux = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28509);
                    return 0;
                case 10:
                    aqq.wuy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28509);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        csc csc = new csc();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = csc.populateBuilderWithField(c6086a3, csc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aqq.wuz = csc;
                    }
                    AppMethodBeat.m2505o(28509);
                    return 0;
                case 12:
                    aqq.wuA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28509);
                    return 0;
                case 13:
                    aqq.wuB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28509);
                    return 0;
                case 14:
                    aqq.wuC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28509);
                    return 0;
                case 15:
                    aqq.wuD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28509);
                    return 0;
                case 16:
                    aqq.wuE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28509);
                    return 0;
                case 17:
                    aqq.wug = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28509);
                    return 0;
                case 18:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        crw crw = new crw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = crw.populateBuilderWithField(c6086a3, crw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aqq.wuh.add(crw);
                    }
                    AppMethodBeat.m2505o(28509);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28509);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28509);
            return -1;
        }
    }
}
