package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.zy */
public final class C23471zy extends btd {
    public int cRU;
    public int cRV;
    public int cvG;
    public int kCl;
    public String kCm;
    public String nSX;
    public int nUf;
    public int nUh;
    public String nUi;
    public String nUj;
    public String nUk;
    public int nUl;
    public String nXl;
    public bpt vWf;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56785);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56785);
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
            c6093a.mo13480iz(4, this.cvG);
            if (this.nSX != null) {
                c6093a.mo13475e(5, this.nSX);
            }
            c6093a.mo13480iz(6, this.cRU);
            c6093a.mo13480iz(7, this.cRV);
            if (this.nXl != null) {
                c6093a.mo13475e(8, this.nXl);
            }
            c6093a.mo13480iz(9, this.nUf);
            if (this.vWf != null) {
                c6093a.mo13479iy(10, this.vWf.computeSize());
                this.vWf.writeFields(c6093a);
            }
            c6093a.mo13480iz(11, this.nUh);
            if (this.nUi != null) {
                c6093a.mo13475e(12, this.nUi);
            }
            if (this.nUj != null) {
                c6093a.mo13475e(13, this.nUj);
            }
            if (this.nUk != null) {
                c6093a.mo13475e(14, this.nUk);
            }
            c6093a.mo13480iz(15, this.nUl);
            AppMethodBeat.m2505o(56785);
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
            ix += C6091a.m9572bs(4, this.cvG);
            if (this.nSX != null) {
                ix += C6091a.m9575f(5, this.nSX);
            }
            ix = (ix + C6091a.m9572bs(6, this.cRU)) + C6091a.m9572bs(7, this.cRV);
            if (this.nXl != null) {
                ix += C6091a.m9575f(8, this.nXl);
            }
            ix += C6091a.m9572bs(9, this.nUf);
            if (this.vWf != null) {
                ix += C6087a.m9557ix(10, this.vWf.computeSize());
            }
            ix += C6091a.m9572bs(11, this.nUh);
            if (this.nUi != null) {
                ix += C6091a.m9575f(12, this.nUi);
            }
            if (this.nUj != null) {
                ix += C6091a.m9575f(13, this.nUj);
            }
            if (this.nUk != null) {
                ix += C6091a.m9575f(14, this.nUk);
            }
            int bs = ix + C6091a.m9572bs(15, this.nUl);
            AppMethodBeat.m2505o(56785);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56785);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56785);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23471zy c23471zy = (C23471zy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
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
                        c23471zy.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(56785);
                    return 0;
                case 2:
                    c23471zy.kCl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56785);
                    return 0;
                case 3:
                    c23471zy.kCm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56785);
                    return 0;
                case 4:
                    c23471zy.cvG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56785);
                    return 0;
                case 5:
                    c23471zy.nSX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56785);
                    return 0;
                case 6:
                    c23471zy.cRU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56785);
                    return 0;
                case 7:
                    c23471zy.cRV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56785);
                    return 0;
                case 8:
                    c23471zy.nXl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56785);
                    return 0;
                case 9:
                    c23471zy.nUf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56785);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bpt bpt = new bpt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpt.populateBuilderWithField(c6086a3, bpt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23471zy.vWf = bpt;
                    }
                    AppMethodBeat.m2505o(56785);
                    return 0;
                case 11:
                    c23471zy.nUh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56785);
                    return 0;
                case 12:
                    c23471zy.nUi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56785);
                    return 0;
                case 13:
                    c23471zy.nUj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56785);
                    return 0;
                case 14:
                    c23471zy.nUk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56785);
                    return 0;
                case 15:
                    c23471zy.nUl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56785);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56785);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56785);
            return -1;
        }
    }
}
