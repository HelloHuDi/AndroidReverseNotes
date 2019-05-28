package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bhw */
public final class bhw extends C1331a {
    public String pdA;
    public LinkedList<bhw> tOS = new LinkedList();
    public int timestamp;
    public String type;
    public String wLb;
    public LinkedList<bhv> wLc = new LinkedList();
    public int wLd;
    public int wLe;

    public bhw() {
        AppMethodBeat.m2504i(90697);
        AppMethodBeat.m2505o(90697);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(90698);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wLb != null) {
                c6093a.mo13475e(1, this.wLb);
            }
            if (this.pdA != null) {
                c6093a.mo13475e(2, this.pdA);
            }
            c6093a.mo13474e(3, 8, this.wLc);
            c6093a.mo13480iz(4, this.timestamp);
            if (this.type != null) {
                c6093a.mo13475e(5, this.type);
            }
            c6093a.mo13474e(6, 8, this.tOS);
            c6093a.mo13480iz(7, this.wLd);
            c6093a.mo13480iz(8, this.wLe);
            AppMethodBeat.m2505o(90698);
            return 0;
        } else if (i == 1) {
            if (this.wLb != null) {
                f = C6091a.m9575f(1, this.wLb) + 0;
            } else {
                f = 0;
            }
            if (this.pdA != null) {
                f += C6091a.m9575f(2, this.pdA);
            }
            f = (f + C6087a.m9552c(3, 8, this.wLc)) + C6091a.m9572bs(4, this.timestamp);
            if (this.type != null) {
                f += C6091a.m9575f(5, this.type);
            }
            int c = ((f + C6087a.m9552c(6, 8, this.tOS)) + C6091a.m9572bs(7, this.wLd)) + C6091a.m9572bs(8, this.wLe);
            AppMethodBeat.m2505o(90698);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wLc.clear();
            this.tOS.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(90698);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bhw bhw = (bhw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    bhw.wLb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(90698);
                    return 0;
                case 2:
                    bhw.pdA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(90698);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bhv bhv = new bhv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhv.populateBuilderWithField(c6086a3, bhv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bhw.wLc.add(bhv);
                    }
                    AppMethodBeat.m2505o(90698);
                    return 0;
                case 4:
                    bhw.timestamp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(90698);
                    return 0;
                case 5:
                    bhw.type = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(90698);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bhw bhw2 = new bhw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhw2.populateBuilderWithField(c6086a3, bhw2, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bhw.tOS.add(bhw2);
                    }
                    AppMethodBeat.m2505o(90698);
                    return 0;
                case 7:
                    bhw.wLd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(90698);
                    return 0;
                case 8:
                    bhw.wLe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(90698);
                    return 0;
                default:
                    AppMethodBeat.m2505o(90698);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(90698);
            return -1;
        }
    }
}
