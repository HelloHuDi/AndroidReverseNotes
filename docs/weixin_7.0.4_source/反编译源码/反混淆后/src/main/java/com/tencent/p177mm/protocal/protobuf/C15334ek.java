package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ek */
public final class C15334ek extends btd {
    public String fgd;
    public String url;
    public LinkedList<C46538ew> vGg = new LinkedList();
    public int vGh;
    public String vGi;
    public int vGj;
    public int vGk;
    public int vGl;
    public C40514dw vGm;
    public cns vGn;
    public String vGo;
    public bac vGp;
    public C46535eg vGq;

    public C15334ek() {
        AppMethodBeat.m2504i(14694);
        AppMethodBeat.m2505o(14694);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14695);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(14695);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 8, this.vGg);
            c6093a.mo13480iz(3, this.vGh);
            if (this.vGi != null) {
                c6093a.mo13475e(4, this.vGi);
            }
            c6093a.mo13480iz(5, this.vGj);
            c6093a.mo13480iz(6, this.vGk);
            c6093a.mo13480iz(7, this.vGl);
            if (this.vGm != null) {
                c6093a.mo13479iy(8, this.vGm.computeSize());
                this.vGm.writeFields(c6093a);
            }
            if (this.url != null) {
                c6093a.mo13475e(9, this.url);
            }
            if (this.fgd != null) {
                c6093a.mo13475e(10, this.fgd);
            }
            if (this.vGn != null) {
                c6093a.mo13479iy(11, this.vGn.computeSize());
                this.vGn.writeFields(c6093a);
            }
            if (this.vGo != null) {
                c6093a.mo13475e(12, this.vGo);
            }
            if (this.vGp != null) {
                c6093a.mo13479iy(13, this.vGp.computeSize());
                this.vGp.writeFields(c6093a);
            }
            if (this.vGq != null) {
                c6093a.mo13479iy(14, this.vGq.computeSize());
                this.vGq.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(14695);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6087a.m9552c(2, 8, this.vGg)) + C6091a.m9572bs(3, this.vGh);
            if (this.vGi != null) {
                ix += C6091a.m9575f(4, this.vGi);
            }
            ix = ((ix + C6091a.m9572bs(5, this.vGj)) + C6091a.m9572bs(6, this.vGk)) + C6091a.m9572bs(7, this.vGl);
            if (this.vGm != null) {
                ix += C6087a.m9557ix(8, this.vGm.computeSize());
            }
            if (this.url != null) {
                ix += C6091a.m9575f(9, this.url);
            }
            if (this.fgd != null) {
                ix += C6091a.m9575f(10, this.fgd);
            }
            if (this.vGn != null) {
                ix += C6087a.m9557ix(11, this.vGn.computeSize());
            }
            if (this.vGo != null) {
                ix += C6091a.m9575f(12, this.vGo);
            }
            if (this.vGp != null) {
                ix += C6087a.m9557ix(13, this.vGp.computeSize());
            }
            if (this.vGq != null) {
                ix += C6087a.m9557ix(14, this.vGq.computeSize());
            }
            AppMethodBeat.m2505o(14695);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vGg.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(14695);
                throw c6092b;
            }
            AppMethodBeat.m2505o(14695);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15334ek c15334ek = (C15334ek) objArr[1];
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
                        c15334ek.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(14695);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46538ew c46538ew = new C46538ew();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c46538ew.populateBuilderWithField(c6086a3, c46538ew, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15334ek.vGg.add(c46538ew);
                    }
                    AppMethodBeat.m2505o(14695);
                    return 0;
                case 3:
                    c15334ek.vGh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14695);
                    return 0;
                case 4:
                    c15334ek.vGi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14695);
                    return 0;
                case 5:
                    c15334ek.vGj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14695);
                    return 0;
                case 6:
                    c15334ek.vGk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14695);
                    return 0;
                case 7:
                    c15334ek.vGl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14695);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40514dw c40514dw = new C40514dw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40514dw.populateBuilderWithField(c6086a3, c40514dw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15334ek.vGm = c40514dw;
                    }
                    AppMethodBeat.m2505o(14695);
                    return 0;
                case 9:
                    c15334ek.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14695);
                    return 0;
                case 10:
                    c15334ek.fgd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14695);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cns cns = new cns();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cns.populateBuilderWithField(c6086a3, cns, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15334ek.vGn = cns;
                    }
                    AppMethodBeat.m2505o(14695);
                    return 0;
                case 12:
                    c15334ek.vGo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14695);
                    return 0;
                case 13:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bac bac = new bac();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bac.populateBuilderWithField(c6086a3, bac, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15334ek.vGp = bac;
                    }
                    AppMethodBeat.m2505o(14695);
                    return 0;
                case 14:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46535eg c46535eg = new C46535eg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c46535eg.populateBuilderWithField(c6086a3, c46535eg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15334ek.vGq = c46535eg;
                    }
                    AppMethodBeat.m2505o(14695);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14695);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14695);
            return -1;
        }
    }
}
