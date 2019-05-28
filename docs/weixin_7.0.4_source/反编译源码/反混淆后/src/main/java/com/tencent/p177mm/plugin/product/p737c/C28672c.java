package com.tencent.p177mm.plugin.product.p737c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.product.c.c */
public final class C28672c extends C1331a {
    public String detail;
    public String fjz;
    public String name;
    public String pcl;
    public LinkedList<C39487d> phC = new LinkedList();
    public int phD;
    public int phE;
    public int phF;
    public LinkedList<String> phG = new LinkedList();
    public LinkedList<String> phH = new LinkedList();
    public LinkedList<C12814b> phI = new LinkedList();
    public LinkedList<String> phJ = new LinkedList();
    public int phK;
    public int phL;
    public LinkedList<C34682m> phM = new LinkedList();
    public LinkedList<C28671a> phN = new LinkedList();
    public C12815k phO;
    public int version;

    public C28672c() {
        AppMethodBeat.m2504i(56624);
        AppMethodBeat.m2505o(56624);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56625);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.name != null) {
                c6093a.mo13475e(1, this.name);
            }
            c6093a.mo13474e(2, 8, this.phC);
            c6093a.mo13480iz(3, this.phD);
            c6093a.mo13480iz(4, this.phE);
            c6093a.mo13480iz(5, this.phF);
            c6093a.mo13474e(6, 1, this.phG);
            if (this.fjz != null) {
                c6093a.mo13475e(7, this.fjz);
            }
            if (this.detail != null) {
                c6093a.mo13475e(8, this.detail);
            }
            c6093a.mo13474e(9, 1, this.phH);
            c6093a.mo13474e(10, 8, this.phI);
            c6093a.mo13474e(11, 1, this.phJ);
            c6093a.mo13480iz(12, this.phK);
            c6093a.mo13480iz(13, this.phL);
            c6093a.mo13474e(14, 8, this.phM);
            c6093a.mo13480iz(15, this.version);
            c6093a.mo13474e(16, 8, this.phN);
            if (this.pcl != null) {
                c6093a.mo13475e(17, this.pcl);
            }
            if (this.phO != null) {
                c6093a.mo13479iy(18, this.phO.computeSize());
                this.phO.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(56625);
            return 0;
        } else if (i == 1) {
            if (this.name != null) {
                f = C6091a.m9575f(1, this.name) + 0;
            } else {
                f = 0;
            }
            f = ((((f + C6087a.m9552c(2, 8, this.phC)) + C6091a.m9572bs(3, this.phD)) + C6091a.m9572bs(4, this.phE)) + C6091a.m9572bs(5, this.phF)) + C6087a.m9552c(6, 1, this.phG);
            if (this.fjz != null) {
                f += C6091a.m9575f(7, this.fjz);
            }
            if (this.detail != null) {
                f += C6091a.m9575f(8, this.detail);
            }
            f = (((((((f + C6087a.m9552c(9, 1, this.phH)) + C6087a.m9552c(10, 8, this.phI)) + C6087a.m9552c(11, 1, this.phJ)) + C6091a.m9572bs(12, this.phK)) + C6091a.m9572bs(13, this.phL)) + C6087a.m9552c(14, 8, this.phM)) + C6091a.m9572bs(15, this.version)) + C6087a.m9552c(16, 8, this.phN);
            if (this.pcl != null) {
                f += C6091a.m9575f(17, this.pcl);
            }
            if (this.phO != null) {
                f += C6087a.m9557ix(18, this.phO.computeSize());
            }
            AppMethodBeat.m2505o(56625);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.phC.clear();
            this.phG.clear();
            this.phH.clear();
            this.phI.clear();
            this.phJ.clear();
            this.phM.clear();
            this.phN.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56625);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C28672c c28672c = (C28672c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c28672c.name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56625);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C39487d c39487d = new C39487d();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c39487d.populateBuilderWithField(c6086a3, c39487d, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c28672c.phC.add(c39487d);
                    }
                    AppMethodBeat.m2505o(56625);
                    return 0;
                case 3:
                    c28672c.phD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56625);
                    return 0;
                case 4:
                    c28672c.phE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56625);
                    return 0;
                case 5:
                    c28672c.phF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56625);
                    return 0;
                case 6:
                    c28672c.phG.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(56625);
                    return 0;
                case 7:
                    c28672c.fjz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56625);
                    return 0;
                case 8:
                    c28672c.detail = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56625);
                    return 0;
                case 9:
                    c28672c.phH.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(56625);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C12814b c12814b = new C12814b();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c12814b.populateBuilderWithField(c6086a3, c12814b, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c28672c.phI.add(c12814b);
                    }
                    AppMethodBeat.m2505o(56625);
                    return 0;
                case 11:
                    c28672c.phJ.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(56625);
                    return 0;
                case 12:
                    c28672c.phK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56625);
                    return 0;
                case 13:
                    c28672c.phL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56625);
                    return 0;
                case 14:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C34682m c34682m = new C34682m();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c34682m.populateBuilderWithField(c6086a3, c34682m, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c28672c.phM.add(c34682m);
                    }
                    AppMethodBeat.m2505o(56625);
                    return 0;
                case 15:
                    c28672c.version = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56625);
                    return 0;
                case 16:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C28671a c28671a = new C28671a();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c28671a.populateBuilderWithField(c6086a3, c28671a, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c28672c.phN.add(c28671a);
                    }
                    AppMethodBeat.m2505o(56625);
                    return 0;
                case 17:
                    c28672c.pcl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56625);
                    return 0;
                case 18:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C12815k c12815k = new C12815k();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c12815k.populateBuilderWithField(c6086a3, c12815k, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c28672c.phO = c12815k;
                    }
                    AppMethodBeat.m2505o(56625);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56625);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56625);
            return -1;
        }
    }
}
