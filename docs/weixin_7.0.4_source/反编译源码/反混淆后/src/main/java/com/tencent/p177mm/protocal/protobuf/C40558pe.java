package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.pe */
public final class C40558pe extends btd {
    public String desc;
    public String jMS;
    public int kCl;
    public String kCm;
    public String kdE;
    public String pOy;
    public String twd;
    public bpt vWf;
    public boolean vWq;
    public String vWr;
    public int vWs;
    public LinkedList<Integer> vWt = new LinkedList();
    public String vWu;
    public int vWv;
    public int vWw;

    public C40558pe() {
        AppMethodBeat.m2504i(48795);
        AppMethodBeat.m2505o(48795);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48796);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(48796);
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
            c6093a.mo13471aO(4, this.vWq);
            if (this.pOy != null) {
                c6093a.mo13475e(5, this.pOy);
            }
            if (this.vWr != null) {
                c6093a.mo13475e(6, this.vWr);
            }
            if (this.jMS != null) {
                c6093a.mo13475e(7, this.jMS);
            }
            c6093a.mo13480iz(8, this.vWs);
            if (this.desc != null) {
                c6093a.mo13475e(9, this.desc);
            }
            if (this.twd != null) {
                c6093a.mo13475e(10, this.twd);
            }
            c6093a.mo13474e(11, 2, this.vWt);
            if (this.vWu != null) {
                c6093a.mo13475e(12, this.vWu);
            }
            if (this.kdE != null) {
                c6093a.mo13475e(13, this.kdE);
            }
            c6093a.mo13480iz(14, this.vWv);
            c6093a.mo13480iz(15, this.vWw);
            if (this.vWf != null) {
                c6093a.mo13479iy(16, this.vWf.computeSize());
                this.vWf.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(48796);
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
            ix += C6091a.m9576fv(4) + 1;
            if (this.pOy != null) {
                ix += C6091a.m9575f(5, this.pOy);
            }
            if (this.vWr != null) {
                ix += C6091a.m9575f(6, this.vWr);
            }
            if (this.jMS != null) {
                ix += C6091a.m9575f(7, this.jMS);
            }
            ix += C6091a.m9572bs(8, this.vWs);
            if (this.desc != null) {
                ix += C6091a.m9575f(9, this.desc);
            }
            if (this.twd != null) {
                ix += C6091a.m9575f(10, this.twd);
            }
            ix += C6087a.m9552c(11, 2, this.vWt);
            if (this.vWu != null) {
                ix += C6091a.m9575f(12, this.vWu);
            }
            if (this.kdE != null) {
                ix += C6091a.m9575f(13, this.kdE);
            }
            ix = (ix + C6091a.m9572bs(14, this.vWv)) + C6091a.m9572bs(15, this.vWw);
            if (this.vWf != null) {
                ix += C6087a.m9557ix(16, this.vWf.computeSize());
            }
            AppMethodBeat.m2505o(48796);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vWt.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(48796);
                throw c6092b;
            }
            AppMethodBeat.m2505o(48796);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40558pe c40558pe = (C40558pe) objArr[1];
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
                        c40558pe.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(48796);
                    return 0;
                case 2:
                    c40558pe.kCl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48796);
                    return 0;
                case 3:
                    c40558pe.kCm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48796);
                    return 0;
                case 4:
                    c40558pe.vWq = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(48796);
                    return 0;
                case 5:
                    c40558pe.pOy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48796);
                    return 0;
                case 6:
                    c40558pe.vWr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48796);
                    return 0;
                case 7:
                    c40558pe.jMS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48796);
                    return 0;
                case 8:
                    c40558pe.vWs = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48796);
                    return 0;
                case 9:
                    c40558pe.desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48796);
                    return 0;
                case 10:
                    c40558pe.twd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48796);
                    return 0;
                case 11:
                    c40558pe.vWt.add(Integer.valueOf(c6086a2.BTU.mo13458vd()));
                    AppMethodBeat.m2505o(48796);
                    return 0;
                case 12:
                    c40558pe.vWu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48796);
                    return 0;
                case 13:
                    c40558pe.kdE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48796);
                    return 0;
                case 14:
                    c40558pe.vWv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48796);
                    return 0;
                case 15:
                    c40558pe.vWw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48796);
                    return 0;
                case 16:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bpt bpt = new bpt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpt.populateBuilderWithField(c6086a3, bpt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40558pe.vWf = bpt;
                    }
                    AppMethodBeat.m2505o(48796);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48796);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48796);
            return -1;
        }
    }
}
