package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.avg */
public final class avg extends bsr {
    public String cvO;
    public String mZr;
    public String scope;
    public String signature;
    public String url;
    public String wzd;
    public String wzf;
    public String wzg;
    public C1332b wzh;
    public int wzi;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(10198);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.url != null) {
                c6093a.mo13475e(2, this.url);
            }
            if (this.mZr != null) {
                c6093a.mo13475e(3, this.mZr);
            }
            if (this.wzd != null) {
                c6093a.mo13475e(4, this.wzd);
            }
            if (this.cvO != null) {
                c6093a.mo13475e(5, this.cvO);
            }
            if (this.wzf != null) {
                c6093a.mo13475e(6, this.wzf);
            }
            if (this.signature != null) {
                c6093a.mo13475e(7, this.signature);
            }
            if (this.wzg != null) {
                c6093a.mo13475e(8, this.wzg);
            }
            if (this.wzh != null) {
                c6093a.mo13473c(9, this.wzh);
            }
            c6093a.mo13480iz(10, this.wzi);
            if (this.scope != null) {
                c6093a.mo13475e(11, this.scope);
            }
            AppMethodBeat.m2505o(10198);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.url != null) {
                ix += C6091a.m9575f(2, this.url);
            }
            if (this.mZr != null) {
                ix += C6091a.m9575f(3, this.mZr);
            }
            if (this.wzd != null) {
                ix += C6091a.m9575f(4, this.wzd);
            }
            if (this.cvO != null) {
                ix += C6091a.m9575f(5, this.cvO);
            }
            if (this.wzf != null) {
                ix += C6091a.m9575f(6, this.wzf);
            }
            if (this.signature != null) {
                ix += C6091a.m9575f(7, this.signature);
            }
            if (this.wzg != null) {
                ix += C6091a.m9575f(8, this.wzg);
            }
            if (this.wzh != null) {
                ix += C6091a.m9571b(9, this.wzh);
            }
            ix += C6091a.m9572bs(10, this.wzi);
            if (this.scope != null) {
                ix += C6091a.m9575f(11, this.scope);
            }
            AppMethodBeat.m2505o(10198);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(10198);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            avg avg = (avg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        avg.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(10198);
                    return 0;
                case 2:
                    avg.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10198);
                    return 0;
                case 3:
                    avg.mZr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10198);
                    return 0;
                case 4:
                    avg.wzd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10198);
                    return 0;
                case 5:
                    avg.cvO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10198);
                    return 0;
                case 6:
                    avg.wzf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10198);
                    return 0;
                case 7:
                    avg.signature = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10198);
                    return 0;
                case 8:
                    avg.wzg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10198);
                    return 0;
                case 9:
                    avg.wzh = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(10198);
                    return 0;
                case 10:
                    avg.wzi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(10198);
                    return 0;
                case 11:
                    avg.scope = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10198);
                    return 0;
                default:
                    AppMethodBeat.m2505o(10198);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(10198);
            return -1;
        }
    }
}
