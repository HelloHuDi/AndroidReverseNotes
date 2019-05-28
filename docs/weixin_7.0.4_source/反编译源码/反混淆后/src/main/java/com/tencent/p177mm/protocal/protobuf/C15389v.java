package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.v */
public final class C15389v extends btd {
    public int kCl = 268513600;
    public String kCm = "请求不成功，请稍候再试";
    public int state;
    public String title;
    public int type;
    public String vAg;
    public String vAk;
    public long vAl;
    public int vAm;
    public long vAn;
    public int vAo;
    public int vAp;
    public int vAq;
    public int vAr;
    public long vAs;
    public long vAt;
    public long vAu;
    public int vAv;
    public String vAw;
    public int vAx;
    public long vAy;
    public String vzL;
    public LinkedList<C35955t> vzQ = new LinkedList();
    public int vzW;

    public C15389v() {
        AppMethodBeat.m2504i(56690);
        AppMethodBeat.m2505o(56690);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56691);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56691);
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
            if (this.vzL != null) {
                c6093a.mo13475e(4, this.vzL);
            }
            if (this.title != null) {
                c6093a.mo13475e(5, this.title);
            }
            c6093a.mo13480iz(6, this.type);
            if (this.vAk != null) {
                c6093a.mo13475e(7, this.vAk);
            }
            c6093a.mo13472ai(8, this.vAl);
            c6093a.mo13480iz(9, this.vAm);
            c6093a.mo13472ai(10, this.vAn);
            c6093a.mo13480iz(11, this.vAo);
            c6093a.mo13480iz(12, this.state);
            c6093a.mo13480iz(13, this.vAp);
            c6093a.mo13480iz(14, this.vAq);
            c6093a.mo13480iz(15, this.vzW);
            c6093a.mo13480iz(16, this.vAr);
            c6093a.mo13472ai(17, this.vAs);
            c6093a.mo13472ai(18, this.vAt);
            c6093a.mo13472ai(19, this.vAu);
            c6093a.mo13480iz(20, this.vAv);
            if (this.vAg != null) {
                c6093a.mo13475e(21, this.vAg);
            }
            c6093a.mo13474e(22, 8, this.vzQ);
            if (this.vAw != null) {
                c6093a.mo13475e(23, this.vAw);
            }
            c6093a.mo13480iz(24, this.vAx);
            c6093a.mo13472ai(25, this.vAy);
            AppMethodBeat.m2505o(56691);
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
            if (this.vzL != null) {
                ix += C6091a.m9575f(4, this.vzL);
            }
            if (this.title != null) {
                ix += C6091a.m9575f(5, this.title);
            }
            ix += C6091a.m9572bs(6, this.type);
            if (this.vAk != null) {
                ix += C6091a.m9575f(7, this.vAk);
            }
            ix = ((((((((((((ix + C6091a.m9578o(8, this.vAl)) + C6091a.m9572bs(9, this.vAm)) + C6091a.m9578o(10, this.vAn)) + C6091a.m9572bs(11, this.vAo)) + C6091a.m9572bs(12, this.state)) + C6091a.m9572bs(13, this.vAp)) + C6091a.m9572bs(14, this.vAq)) + C6091a.m9572bs(15, this.vzW)) + C6091a.m9572bs(16, this.vAr)) + C6091a.m9578o(17, this.vAs)) + C6091a.m9578o(18, this.vAt)) + C6091a.m9578o(19, this.vAu)) + C6091a.m9572bs(20, this.vAv);
            if (this.vAg != null) {
                ix += C6091a.m9575f(21, this.vAg);
            }
            ix += C6087a.m9552c(22, 8, this.vzQ);
            if (this.vAw != null) {
                ix += C6091a.m9575f(23, this.vAw);
            }
            int bs = (ix + C6091a.m9572bs(24, this.vAx)) + C6091a.m9578o(25, this.vAy);
            AppMethodBeat.m2505o(56691);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vzQ.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56691);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56691);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15389v c15389v = (C15389v) objArr[1];
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
                        c15389v.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(56691);
                    return 0;
                case 2:
                    c15389v.kCl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56691);
                    return 0;
                case 3:
                    c15389v.kCm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56691);
                    return 0;
                case 4:
                    c15389v.vzL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56691);
                    return 0;
                case 5:
                    c15389v.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56691);
                    return 0;
                case 6:
                    c15389v.type = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56691);
                    return 0;
                case 7:
                    c15389v.vAk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56691);
                    return 0;
                case 8:
                    c15389v.vAl = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56691);
                    return 0;
                case 9:
                    c15389v.vAm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56691);
                    return 0;
                case 10:
                    c15389v.vAn = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56691);
                    return 0;
                case 11:
                    c15389v.vAo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56691);
                    return 0;
                case 12:
                    c15389v.state = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56691);
                    return 0;
                case 13:
                    c15389v.vAp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56691);
                    return 0;
                case 14:
                    c15389v.vAq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56691);
                    return 0;
                case 15:
                    c15389v.vzW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56691);
                    return 0;
                case 16:
                    c15389v.vAr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56691);
                    return 0;
                case 17:
                    c15389v.vAs = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56691);
                    return 0;
                case 18:
                    c15389v.vAt = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56691);
                    return 0;
                case 19:
                    c15389v.vAu = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56691);
                    return 0;
                case 20:
                    c15389v.vAv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56691);
                    return 0;
                case 21:
                    c15389v.vAg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56691);
                    return 0;
                case 22:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C35955t c35955t = new C35955t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c35955t.populateBuilderWithField(c6086a3, c35955t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15389v.vzQ.add(c35955t);
                    }
                    AppMethodBeat.m2505o(56691);
                    return 0;
                case 23:
                    c15389v.vAw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56691);
                    return 0;
                case 24:
                    c15389v.vAx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56691);
                    return 0;
                case 25:
                    c15389v.vAy = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56691);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56691);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56691);
            return -1;
        }
    }
}
