package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.avq */
public final class avq extends bsr {
    public String csB;
    public String cvO;
    public String signature;
    public String url;
    public String wzd;
    public String wzf;
    public String wzg;
    public C1332b wzh;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(10207);
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
            if (this.csB != null) {
                c6093a.mo13475e(3, this.csB);
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
            AppMethodBeat.m2505o(10207);
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
            if (this.csB != null) {
                ix += C6091a.m9575f(3, this.csB);
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
            AppMethodBeat.m2505o(10207);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(10207);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            avq avq = (avq) objArr[1];
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
                        avq.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(10207);
                    return 0;
                case 2:
                    avq.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10207);
                    return 0;
                case 3:
                    avq.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10207);
                    return 0;
                case 4:
                    avq.wzd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10207);
                    return 0;
                case 5:
                    avq.cvO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10207);
                    return 0;
                case 6:
                    avq.wzf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10207);
                    return 0;
                case 7:
                    avq.signature = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10207);
                    return 0;
                case 8:
                    avq.wzg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10207);
                    return 0;
                case 9:
                    avq.wzh = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(10207);
                    return 0;
                default:
                    AppMethodBeat.m2505o(10207);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(10207);
            return -1;
        }
    }
}
