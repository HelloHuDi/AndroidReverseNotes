package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.iq */
public final class C15350iq extends C1331a {
    public int Ret;
    public String jBF;
    public String vKF;
    public String vKK;
    public bbv vKL;
    public asq vKM;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(10159);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.Ret);
            if (this.vKK != null) {
                c6093a.mo13475e(2, this.vKK);
            }
            if (this.vKL != null) {
                c6093a.mo13479iy(3, this.vKL.computeSize());
                this.vKL.writeFields(c6093a);
            }
            if (this.vKF != null) {
                c6093a.mo13475e(4, this.vKF);
            }
            if (this.jBF != null) {
                c6093a.mo13475e(5, this.jBF);
            }
            if (this.vKM != null) {
                c6093a.mo13479iy(6, this.vKM.computeSize());
                this.vKM.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(10159);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.Ret) + 0;
            if (this.vKK != null) {
                bs += C6091a.m9575f(2, this.vKK);
            }
            if (this.vKL != null) {
                bs += C6087a.m9557ix(3, this.vKL.computeSize());
            }
            if (this.vKF != null) {
                bs += C6091a.m9575f(4, this.vKF);
            }
            if (this.jBF != null) {
                bs += C6091a.m9575f(5, this.jBF);
            }
            if (this.vKM != null) {
                bs += C6087a.m9557ix(6, this.vKM.computeSize());
            }
            AppMethodBeat.m2505o(10159);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(10159);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15350iq c15350iq = (C15350iq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c15350iq.Ret = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(10159);
                    return 0;
                case 2:
                    c15350iq.vKK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10159);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bbv bbv = new bbv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbv.populateBuilderWithField(c6086a3, bbv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15350iq.vKL = bbv;
                    }
                    AppMethodBeat.m2505o(10159);
                    return 0;
                case 4:
                    c15350iq.vKF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10159);
                    return 0;
                case 5:
                    c15350iq.jBF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10159);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        asq asq = new asq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = asq.populateBuilderWithField(c6086a3, asq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15350iq.vKM = asq;
                    }
                    AppMethodBeat.m2505o(10159);
                    return 0;
                default:
                    AppMethodBeat.m2505o(10159);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(10159);
            return -1;
        }
    }
}
