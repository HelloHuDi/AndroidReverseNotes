package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.zn */
public final class C35970zn extends btd {
    public C15404zq weL;
    public C46604zk weM;
    public C40594zl weN;
    public String weO;
    public int weP;
    public int weQ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28398);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28398);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.weL != null) {
                c6093a.mo13479iy(2, this.weL.computeSize());
                this.weL.writeFields(c6093a);
            }
            if (this.weM != null) {
                c6093a.mo13479iy(3, this.weM.computeSize());
                this.weM.writeFields(c6093a);
            }
            if (this.weN != null) {
                c6093a.mo13479iy(4, this.weN.computeSize());
                this.weN.writeFields(c6093a);
            }
            if (this.weO != null) {
                c6093a.mo13475e(5, this.weO);
            }
            c6093a.mo13480iz(6, this.weP);
            c6093a.mo13480iz(7, this.weQ);
            AppMethodBeat.m2505o(28398);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.weL != null) {
                ix += C6087a.m9557ix(2, this.weL.computeSize());
            }
            if (this.weM != null) {
                ix += C6087a.m9557ix(3, this.weM.computeSize());
            }
            if (this.weN != null) {
                ix += C6087a.m9557ix(4, this.weN.computeSize());
            }
            if (this.weO != null) {
                ix += C6091a.m9575f(5, this.weO);
            }
            int bs = (ix + C6091a.m9572bs(6, this.weP)) + C6091a.m9572bs(7, this.weQ);
            AppMethodBeat.m2505o(28398);
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
                AppMethodBeat.m2505o(28398);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28398);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35970zn c35970zn = (C35970zn) objArr[1];
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
                        c35970zn.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(28398);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15404zq c15404zq = new C15404zq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15404zq.populateBuilderWithField(c6086a3, c15404zq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35970zn.weL = c15404zq;
                    }
                    AppMethodBeat.m2505o(28398);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46604zk c46604zk = new C46604zk();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c46604zk.populateBuilderWithField(c6086a3, c46604zk, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35970zn.weM = c46604zk;
                    }
                    AppMethodBeat.m2505o(28398);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40594zl c40594zl = new C40594zl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40594zl.populateBuilderWithField(c6086a3, c40594zl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35970zn.weN = c40594zl;
                    }
                    AppMethodBeat.m2505o(28398);
                    return 0;
                case 5:
                    c35970zn.weO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28398);
                    return 0;
                case 6:
                    c35970zn.weP = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28398);
                    return 0;
                case 7:
                    c35970zn.weQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28398);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28398);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28398);
            return -1;
        }
    }
}
