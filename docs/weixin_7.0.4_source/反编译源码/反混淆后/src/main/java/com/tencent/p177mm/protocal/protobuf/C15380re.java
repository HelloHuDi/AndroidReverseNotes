package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.re */
public final class C15380re extends bsr {
    public String vYm;
    public String vYn;
    public String vYo;
    public String vYp;
    public String vYq;
    public long vYr;
    public String vYs;
    public String vYt;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28357);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.vYm != null) {
                c6093a.mo13475e(2, this.vYm);
            }
            if (this.vYn != null) {
                c6093a.mo13475e(3, this.vYn);
            }
            if (this.vYo != null) {
                c6093a.mo13475e(4, this.vYo);
            }
            if (this.vYp != null) {
                c6093a.mo13475e(5, this.vYp);
            }
            if (this.vYq != null) {
                c6093a.mo13475e(6, this.vYq);
            }
            c6093a.mo13472ai(7, this.vYr);
            if (this.vYs != null) {
                c6093a.mo13475e(8, this.vYs);
            }
            if (this.vYt != null) {
                c6093a.mo13475e(9, this.vYt);
            }
            AppMethodBeat.m2505o(28357);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vYm != null) {
                ix += C6091a.m9575f(2, this.vYm);
            }
            if (this.vYn != null) {
                ix += C6091a.m9575f(3, this.vYn);
            }
            if (this.vYo != null) {
                ix += C6091a.m9575f(4, this.vYo);
            }
            if (this.vYp != null) {
                ix += C6091a.m9575f(5, this.vYp);
            }
            if (this.vYq != null) {
                ix += C6091a.m9575f(6, this.vYq);
            }
            ix += C6091a.m9578o(7, this.vYr);
            if (this.vYs != null) {
                ix += C6091a.m9575f(8, this.vYs);
            }
            if (this.vYt != null) {
                ix += C6091a.m9575f(9, this.vYt);
            }
            AppMethodBeat.m2505o(28357);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28357);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15380re c15380re = (C15380re) objArr[1];
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
                        c15380re.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(28357);
                    return 0;
                case 2:
                    c15380re.vYm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28357);
                    return 0;
                case 3:
                    c15380re.vYn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28357);
                    return 0;
                case 4:
                    c15380re.vYo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28357);
                    return 0;
                case 5:
                    c15380re.vYp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28357);
                    return 0;
                case 6:
                    c15380re.vYq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28357);
                    return 0;
                case 7:
                    c15380re.vYr = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(28357);
                    return 0;
                case 8:
                    c15380re.vYs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28357);
                    return 0;
                case 9:
                    c15380re.vYt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28357);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28357);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28357);
            return -1;
        }
    }
}
