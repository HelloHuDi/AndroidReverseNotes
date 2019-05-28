package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.kl */
public final class C44136kl extends C1331a {
    public String content;
    public String kKw;
    public String kbV;
    public int vGr;
    public String vGs;
    public int vMO;
    public int vMP;
    public int vNl;
    public int vNm;
    public int vNn;
    public C44174tq vNo;
    public int vNp;
    public int vNq;
    public int vNr = 0;
    public int vNs;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14712);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.vNl);
            c6093a.mo13480iz(2, this.vGr);
            if (this.vGs != null) {
                c6093a.mo13475e(3, this.vGs);
            }
            if (this.kKw != null) {
                c6093a.mo13475e(4, this.kKw);
            }
            if (this.kbV != null) {
                c6093a.mo13475e(5, this.kbV);
            }
            if (this.content != null) {
                c6093a.mo13475e(6, this.content);
            }
            c6093a.mo13480iz(7, this.vNm);
            c6093a.mo13480iz(8, this.vNn);
            c6093a.mo13480iz(9, this.vMO);
            c6093a.mo13480iz(10, this.vMP);
            if (this.vNo != null) {
                c6093a.mo13479iy(11, this.vNo.computeSize());
                this.vNo.writeFields(c6093a);
            }
            c6093a.mo13480iz(12, this.vNp);
            c6093a.mo13480iz(13, this.vNq);
            c6093a.mo13480iz(14, this.vNr);
            c6093a.mo13480iz(15, this.vNs);
            AppMethodBeat.m2505o(14712);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.vNl) + 0) + C6091a.m9572bs(2, this.vGr);
            if (this.vGs != null) {
                bs += C6091a.m9575f(3, this.vGs);
            }
            if (this.kKw != null) {
                bs += C6091a.m9575f(4, this.kKw);
            }
            if (this.kbV != null) {
                bs += C6091a.m9575f(5, this.kbV);
            }
            if (this.content != null) {
                bs += C6091a.m9575f(6, this.content);
            }
            bs = (((bs + C6091a.m9572bs(7, this.vNm)) + C6091a.m9572bs(8, this.vNn)) + C6091a.m9572bs(9, this.vMO)) + C6091a.m9572bs(10, this.vMP);
            if (this.vNo != null) {
                bs += C6087a.m9557ix(11, this.vNo.computeSize());
            }
            bs = (((bs + C6091a.m9572bs(12, this.vNp)) + C6091a.m9572bs(13, this.vNq)) + C6091a.m9572bs(14, this.vNr)) + C6091a.m9572bs(15, this.vNs);
            AppMethodBeat.m2505o(14712);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(14712);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44136kl c44136kl = (C44136kl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c44136kl.vNl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14712);
                    return 0;
                case 2:
                    c44136kl.vGr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14712);
                    return 0;
                case 3:
                    c44136kl.vGs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14712);
                    return 0;
                case 4:
                    c44136kl.kKw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14712);
                    return 0;
                case 5:
                    c44136kl.kbV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14712);
                    return 0;
                case 6:
                    c44136kl.content = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14712);
                    return 0;
                case 7:
                    c44136kl.vNm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14712);
                    return 0;
                case 8:
                    c44136kl.vNn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14712);
                    return 0;
                case 9:
                    c44136kl.vMO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14712);
                    return 0;
                case 10:
                    c44136kl.vMP = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14712);
                    return 0;
                case 11:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C44174tq c44174tq = new C44174tq();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c44174tq.populateBuilderWithField(c6086a3, c44174tq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44136kl.vNo = c44174tq;
                    }
                    AppMethodBeat.m2505o(14712);
                    return 0;
                case 12:
                    c44136kl.vNp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14712);
                    return 0;
                case 13:
                    c44136kl.vNq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14712);
                    return 0;
                case 14:
                    c44136kl.vNr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14712);
                    return 0;
                case 15:
                    c44136kl.vNs = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14712);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14712);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14712);
            return -1;
        }
    }
}
