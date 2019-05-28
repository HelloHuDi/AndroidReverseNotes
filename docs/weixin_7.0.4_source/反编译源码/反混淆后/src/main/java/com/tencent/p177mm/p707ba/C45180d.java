package com.tencent.p177mm.p707ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.ba.d */
public final class C45180d extends C1331a {
    public int cKB;
    public LinkedList<C6336e> fLY = new LinkedList();
    public int fLZ;
    public int fMa;
    public int fMb;
    public String fMc;
    public String fMd;
    public int fMe;
    public int fMf;
    public int fMg;
    public int maxSize;
    public String name;

    public C45180d() {
        AppMethodBeat.m2504i(78440);
        AppMethodBeat.m2505o(78440);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(78441);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 8, this.fLY);
            if (this.name != null) {
                c6093a.mo13475e(2, this.name);
            }
            c6093a.mo13480iz(3, this.fLZ);
            c6093a.mo13480iz(4, this.cKB);
            c6093a.mo13480iz(5, this.fMa);
            c6093a.mo13480iz(6, this.fMb);
            if (this.fMc != null) {
                c6093a.mo13475e(7, this.fMc);
            }
            if (this.fMd != null) {
                c6093a.mo13475e(8, this.fMd);
            }
            c6093a.mo13480iz(9, this.fMe);
            c6093a.mo13480iz(10, this.fMf);
            c6093a.mo13480iz(11, this.fMg);
            c6093a.mo13480iz(12, this.maxSize);
            AppMethodBeat.m2505o(78441);
            return 0;
        } else if (i == 1) {
            c = C6087a.m9552c(1, 8, this.fLY) + 0;
            if (this.name != null) {
                c += C6091a.m9575f(2, this.name);
            }
            c = (((c + C6091a.m9572bs(3, this.fLZ)) + C6091a.m9572bs(4, this.cKB)) + C6091a.m9572bs(5, this.fMa)) + C6091a.m9572bs(6, this.fMb);
            if (this.fMc != null) {
                c += C6091a.m9575f(7, this.fMc);
            }
            if (this.fMd != null) {
                c += C6091a.m9575f(8, this.fMd);
            }
            c = (((c + C6091a.m9572bs(9, this.fMe)) + C6091a.m9572bs(10, this.fMf)) + C6091a.m9572bs(11, this.fMg)) + C6091a.m9572bs(12, this.maxSize);
            AppMethodBeat.m2505o(78441);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.fLY.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(78441);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C45180d c45180d = (C45180d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C6336e c6336e = new C6336e();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c6336e.populateBuilderWithField(c6086a3, c6336e, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c45180d.fLY.add(c6336e);
                    }
                    AppMethodBeat.m2505o(78441);
                    return 0;
                case 2:
                    c45180d.name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(78441);
                    return 0;
                case 3:
                    c45180d.fLZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(78441);
                    return 0;
                case 4:
                    c45180d.cKB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(78441);
                    return 0;
                case 5:
                    c45180d.fMa = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(78441);
                    return 0;
                case 6:
                    c45180d.fMb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(78441);
                    return 0;
                case 7:
                    c45180d.fMc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(78441);
                    return 0;
                case 8:
                    c45180d.fMd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(78441);
                    return 0;
                case 9:
                    c45180d.fMe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(78441);
                    return 0;
                case 10:
                    c45180d.fMf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(78441);
                    return 0;
                case 11:
                    c45180d.fMg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(78441);
                    return 0;
                case 12:
                    c45180d.maxSize = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(78441);
                    return 0;
                default:
                    AppMethodBeat.m2505o(78441);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(78441);
            return -1;
        }
    }
}
