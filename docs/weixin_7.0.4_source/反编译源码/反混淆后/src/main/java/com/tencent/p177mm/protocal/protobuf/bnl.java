package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bnl */
public final class bnl extends btd {
    public int kdT;
    public String kdU;
    public LinkedList<bir> vAD = new LinkedList();
    public long vYi;
    public long vYj;
    public bdh wQl;
    public atj wci;
    public chl woi;
    public C30204mu wpq;
    public btn wxm;

    public bnl() {
        AppMethodBeat.m2504i(48935);
        AppMethodBeat.m2505o(48935);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48936);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(48936);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.kdT);
            if (this.kdU != null) {
                c6093a.mo13475e(3, this.kdU);
            }
            if (this.wci != null) {
                c6093a.mo13479iy(4, this.wci.computeSize());
                this.wci.writeFields(c6093a);
            }
            c6093a.mo13474e(5, 8, this.vAD);
            c6093a.mo13472ai(6, this.vYi);
            c6093a.mo13472ai(7, this.vYj);
            if (this.wxm != null) {
                c6093a.mo13479iy(8, this.wxm.computeSize());
                this.wxm.writeFields(c6093a);
            }
            if (this.wpq != null) {
                c6093a.mo13479iy(9, this.wpq.computeSize());
                this.wpq.writeFields(c6093a);
            }
            if (this.woi != null) {
                c6093a.mo13479iy(10, this.woi.computeSize());
                this.woi.writeFields(c6093a);
            }
            if (this.wQl != null) {
                c6093a.mo13479iy(11, this.wQl.computeSize());
                this.wQl.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(48936);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.kdT);
            if (this.kdU != null) {
                ix += C6091a.m9575f(3, this.kdU);
            }
            if (this.wci != null) {
                ix += C6087a.m9557ix(4, this.wci.computeSize());
            }
            ix = ((ix + C6087a.m9552c(5, 8, this.vAD)) + C6091a.m9578o(6, this.vYi)) + C6091a.m9578o(7, this.vYj);
            if (this.wxm != null) {
                ix += C6087a.m9557ix(8, this.wxm.computeSize());
            }
            if (this.wpq != null) {
                ix += C6087a.m9557ix(9, this.wpq.computeSize());
            }
            if (this.woi != null) {
                ix += C6087a.m9557ix(10, this.woi.computeSize());
            }
            if (this.wQl != null) {
                ix += C6087a.m9557ix(11, this.wQl.computeSize());
            }
            AppMethodBeat.m2505o(48936);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vAD.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(48936);
                throw c6092b;
            }
            AppMethodBeat.m2505o(48936);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bnl bnl = (bnl) objArr[1];
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
                        bnl.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(48936);
                    return 0;
                case 2:
                    bnl.kdT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48936);
                    return 0;
                case 3:
                    bnl.kdU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48936);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        atj atj = new atj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = atj.populateBuilderWithField(c6086a3, atj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bnl.wci = atj;
                    }
                    AppMethodBeat.m2505o(48936);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bir bir = new bir();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bir.populateBuilderWithField(c6086a3, bir, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bnl.vAD.add(bir);
                    }
                    AppMethodBeat.m2505o(48936);
                    return 0;
                case 6:
                    bnl.vYi = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(48936);
                    return 0;
                case 7:
                    bnl.vYj = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(48936);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btn btn = new btn();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = btn.populateBuilderWithField(c6086a3, btn, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bnl.wxm = btn;
                    }
                    AppMethodBeat.m2505o(48936);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C30204mu c30204mu = new C30204mu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c30204mu.populateBuilderWithField(c6086a3, c30204mu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bnl.wpq = c30204mu;
                    }
                    AppMethodBeat.m2505o(48936);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chl chl = new chl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = chl.populateBuilderWithField(c6086a3, chl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bnl.woi = chl;
                    }
                    AppMethodBeat.m2505o(48936);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdh bdh = new bdh();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdh.populateBuilderWithField(c6086a3, bdh, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bnl.wQl = bdh;
                    }
                    AppMethodBeat.m2505o(48936);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48936);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48936);
            return -1;
        }
    }
}
