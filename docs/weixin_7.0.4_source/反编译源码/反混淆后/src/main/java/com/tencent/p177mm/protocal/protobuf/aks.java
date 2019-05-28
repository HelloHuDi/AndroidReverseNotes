package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aks */
public final class aks extends btd {
    public int kKI;
    public int kdT;
    public String kdU;
    public int wqk;
    public C35939nv wql;
    public C35940nw wqm;
    public C46571nt wqn;
    public C40551nu wqo;
    public String wqp;
    public int wqq;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89096);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(89096);
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
            c6093a.mo13480iz(4, this.kKI);
            c6093a.mo13480iz(5, this.wqk);
            if (this.wql != null) {
                c6093a.mo13479iy(6, this.wql.computeSize());
                this.wql.writeFields(c6093a);
            }
            if (this.wqm != null) {
                c6093a.mo13479iy(7, this.wqm.computeSize());
                this.wqm.writeFields(c6093a);
            }
            if (this.wqn != null) {
                c6093a.mo13479iy(8, this.wqn.computeSize());
                this.wqn.writeFields(c6093a);
            }
            if (this.wqo != null) {
                c6093a.mo13479iy(9, this.wqo.computeSize());
                this.wqo.writeFields(c6093a);
            }
            if (this.wqp != null) {
                c6093a.mo13475e(10, this.wqp);
            }
            c6093a.mo13480iz(11, this.wqq);
            AppMethodBeat.m2505o(89096);
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
            ix = (ix + C6091a.m9572bs(4, this.kKI)) + C6091a.m9572bs(5, this.wqk);
            if (this.wql != null) {
                ix += C6087a.m9557ix(6, this.wql.computeSize());
            }
            if (this.wqm != null) {
                ix += C6087a.m9557ix(7, this.wqm.computeSize());
            }
            if (this.wqn != null) {
                ix += C6087a.m9557ix(8, this.wqn.computeSize());
            }
            if (this.wqo != null) {
                ix += C6087a.m9557ix(9, this.wqo.computeSize());
            }
            if (this.wqp != null) {
                ix += C6091a.m9575f(10, this.wqp);
            }
            int bs = ix + C6091a.m9572bs(11, this.wqq);
            AppMethodBeat.m2505o(89096);
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
                AppMethodBeat.m2505o(89096);
                throw c6092b;
            }
            AppMethodBeat.m2505o(89096);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aks aks = (aks) objArr[1];
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
                        aks.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(89096);
                    return 0;
                case 2:
                    aks.kdT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89096);
                    return 0;
                case 3:
                    aks.kdU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89096);
                    return 0;
                case 4:
                    aks.kKI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89096);
                    return 0;
                case 5:
                    aks.wqk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89096);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C35939nv c35939nv = new C35939nv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c35939nv.populateBuilderWithField(c6086a3, c35939nv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aks.wql = c35939nv;
                    }
                    AppMethodBeat.m2505o(89096);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C35940nw c35940nw = new C35940nw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c35940nw.populateBuilderWithField(c6086a3, c35940nw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aks.wqm = c35940nw;
                    }
                    AppMethodBeat.m2505o(89096);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46571nt c46571nt = new C46571nt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c46571nt.populateBuilderWithField(c6086a3, c46571nt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aks.wqn = c46571nt;
                    }
                    AppMethodBeat.m2505o(89096);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40551nu c40551nu = new C40551nu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40551nu.populateBuilderWithField(c6086a3, c40551nu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aks.wqo = c40551nu;
                    }
                    AppMethodBeat.m2505o(89096);
                    return 0;
                case 10:
                    aks.wqp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89096);
                    return 0;
                case 11:
                    aks.wqq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89096);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89096);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89096);
            return -1;
        }
    }
}
