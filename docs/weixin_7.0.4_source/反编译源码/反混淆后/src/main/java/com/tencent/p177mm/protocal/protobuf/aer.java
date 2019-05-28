package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aer */
public final class aer extends bsr {
    public String appId;
    public String cvO;
    public String mwU;
    public String mwV;
    public String mwW;
    public String sign;
    public String vAN;
    public int vAO;
    public C7257dh wmv;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28415);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.appId != null) {
                c6093a.mo13475e(2, this.appId);
            }
            if (this.mwU != null) {
                c6093a.mo13475e(3, this.mwU);
            }
            if (this.mwV != null) {
                c6093a.mo13475e(4, this.mwV);
            }
            if (this.mwW != null) {
                c6093a.mo13475e(5, this.mwW);
            }
            if (this.cvO != null) {
                c6093a.mo13475e(6, this.cvO);
            }
            if (this.sign != null) {
                c6093a.mo13475e(7, this.sign);
            }
            if (this.wmv != null) {
                c6093a.mo13479iy(8, this.wmv.computeSize());
                this.wmv.writeFields(c6093a);
            }
            if (this.vAN != null) {
                c6093a.mo13475e(9, this.vAN);
            }
            c6093a.mo13480iz(10, this.vAO);
            AppMethodBeat.m2505o(28415);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.appId != null) {
                ix += C6091a.m9575f(2, this.appId);
            }
            if (this.mwU != null) {
                ix += C6091a.m9575f(3, this.mwU);
            }
            if (this.mwV != null) {
                ix += C6091a.m9575f(4, this.mwV);
            }
            if (this.mwW != null) {
                ix += C6091a.m9575f(5, this.mwW);
            }
            if (this.cvO != null) {
                ix += C6091a.m9575f(6, this.cvO);
            }
            if (this.sign != null) {
                ix += C6091a.m9575f(7, this.sign);
            }
            if (this.wmv != null) {
                ix += C6087a.m9557ix(8, this.wmv.computeSize());
            }
            if (this.vAN != null) {
                ix += C6091a.m9575f(9, this.vAN);
            }
            int bs = ix + C6091a.m9572bs(10, this.vAO);
            AppMethodBeat.m2505o(28415);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28415);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aer aer = (aer) objArr[1];
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
                        C7267hl c7267hl = new C7267hl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aer.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(28415);
                    return 0;
                case 2:
                    aer.appId = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28415);
                    return 0;
                case 3:
                    aer.mwU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28415);
                    return 0;
                case 4:
                    aer.mwV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28415);
                    return 0;
                case 5:
                    aer.mwW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28415);
                    return 0;
                case 6:
                    aer.cvO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28415);
                    return 0;
                case 7:
                    aer.sign = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28415);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7257dh c7257dh = new C7257dh();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7257dh.populateBuilderWithField(c6086a3, c7257dh, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aer.wmv = c7257dh;
                    }
                    AppMethodBeat.m2505o(28415);
                    return 0;
                case 9:
                    aer.vAN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28415);
                    return 0;
                case 10:
                    aer.vAO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28415);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28415);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28415);
            return -1;
        }
    }
}
