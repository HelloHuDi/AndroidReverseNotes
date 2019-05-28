package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.sf */
public final class C44166sf extends bsr {
    public int Scene;
    public String ndF;
    public String ndG;
    public int ptD;
    public long ptF;
    public int ptw;
    public String vZx;
    public coa vZy;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28362);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.vZx != null) {
                c6093a.mo13475e(2, this.vZx);
            }
            c6093a.mo13480iz(3, this.ptw);
            c6093a.mo13480iz(4, this.ptD);
            if (this.vZy != null) {
                c6093a.mo13479iy(5, this.vZy.computeSize());
                this.vZy.writeFields(c6093a);
            }
            c6093a.mo13472ai(6, this.ptF);
            c6093a.mo13480iz(7, this.Scene);
            if (this.ndG != null) {
                c6093a.mo13475e(8, this.ndG);
            }
            if (this.ndF != null) {
                c6093a.mo13475e(9, this.ndF);
            }
            AppMethodBeat.m2505o(28362);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vZx != null) {
                ix += C6091a.m9575f(2, this.vZx);
            }
            ix = (ix + C6091a.m9572bs(3, this.ptw)) + C6091a.m9572bs(4, this.ptD);
            if (this.vZy != null) {
                ix += C6087a.m9557ix(5, this.vZy.computeSize());
            }
            ix = (ix + C6091a.m9578o(6, this.ptF)) + C6091a.m9572bs(7, this.Scene);
            if (this.ndG != null) {
                ix += C6091a.m9575f(8, this.ndG);
            }
            if (this.ndF != null) {
                ix += C6091a.m9575f(9, this.ndF);
            }
            AppMethodBeat.m2505o(28362);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28362);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44166sf c44166sf = (C44166sf) objArr[1];
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
                        c44166sf.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(28362);
                    return 0;
                case 2:
                    c44166sf.vZx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28362);
                    return 0;
                case 3:
                    c44166sf.ptw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28362);
                    return 0;
                case 4:
                    c44166sf.ptD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28362);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        coa coa = new coa();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = coa.populateBuilderWithField(c6086a3, coa, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44166sf.vZy = coa;
                    }
                    AppMethodBeat.m2505o(28362);
                    return 0;
                case 6:
                    c44166sf.ptF = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(28362);
                    return 0;
                case 7:
                    c44166sf.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28362);
                    return 0;
                case 8:
                    c44166sf.ndG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28362);
                    return 0;
                case 9:
                    c44166sf.ndF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28362);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28362);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28362);
            return -1;
        }
    }
}
