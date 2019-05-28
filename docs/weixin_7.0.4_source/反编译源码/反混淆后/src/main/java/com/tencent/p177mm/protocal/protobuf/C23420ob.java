package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ob */
public final class C23420ob extends C1331a {
    public String pbn;
    public String pbo;
    public int state;
    public cgv vCN;
    public btr vCP;
    public String vJS;
    public auj vTA;
    public LinkedList<cgv> vTB = new LinkedList();
    public int vTC;
    public int vTD;

    public C23420ob() {
        AppMethodBeat.m2504i(48789);
        AppMethodBeat.m2505o(48789);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48790);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vTA != null) {
                c6093a.mo13479iy(1, this.vTA.computeSize());
                this.vTA.writeFields(c6093a);
            }
            if (this.vCN != null) {
                c6093a.mo13479iy(2, this.vCN.computeSize());
                this.vCN.writeFields(c6093a);
            }
            c6093a.mo13474e(3, 8, this.vTB);
            if (this.pbo != null) {
                c6093a.mo13475e(4, this.pbo);
            }
            if (this.pbn != null) {
                c6093a.mo13475e(5, this.pbn);
            }
            if (this.vCP != null) {
                c6093a.mo13479iy(6, this.vCP.computeSize());
                this.vCP.writeFields(c6093a);
            }
            c6093a.mo13480iz(7, this.state);
            c6093a.mo13480iz(8, this.vTC);
            c6093a.mo13480iz(9, this.vTD);
            if (this.vJS != null) {
                c6093a.mo13475e(10, this.vJS);
            }
            AppMethodBeat.m2505o(48790);
            return 0;
        } else if (i == 1) {
            if (this.vTA != null) {
                ix = C6087a.m9557ix(1, this.vTA.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vCN != null) {
                ix += C6087a.m9557ix(2, this.vCN.computeSize());
            }
            ix += C6087a.m9552c(3, 8, this.vTB);
            if (this.pbo != null) {
                ix += C6091a.m9575f(4, this.pbo);
            }
            if (this.pbn != null) {
                ix += C6091a.m9575f(5, this.pbn);
            }
            if (this.vCP != null) {
                ix += C6087a.m9557ix(6, this.vCP.computeSize());
            }
            ix = ((ix + C6091a.m9572bs(7, this.state)) + C6091a.m9572bs(8, this.vTC)) + C6091a.m9572bs(9, this.vTD);
            if (this.vJS != null) {
                ix += C6091a.m9575f(10, this.vJS);
            }
            AppMethodBeat.m2505o(48790);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vTB.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48790);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23420ob c23420ob = (C23420ob) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            cgv cgv;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        auj auj = new auj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = auj.populateBuilderWithField(c6086a3, auj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23420ob.vTA = auj;
                    }
                    AppMethodBeat.m2505o(48790);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv = new cgv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(c6086a3, cgv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23420ob.vCN = cgv;
                    }
                    AppMethodBeat.m2505o(48790);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv = new cgv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(c6086a3, cgv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23420ob.vTB.add(cgv);
                    }
                    AppMethodBeat.m2505o(48790);
                    return 0;
                case 4:
                    c23420ob.pbo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48790);
                    return 0;
                case 5:
                    c23420ob.pbn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48790);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btr btr = new btr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = btr.populateBuilderWithField(c6086a3, btr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23420ob.vCP = btr;
                    }
                    AppMethodBeat.m2505o(48790);
                    return 0;
                case 7:
                    c23420ob.state = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48790);
                    return 0;
                case 8:
                    c23420ob.vTC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48790);
                    return 0;
                case 9:
                    c23420ob.vTD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48790);
                    return 0;
                case 10:
                    c23420ob.vJS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48790);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48790);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48790);
            return -1;
        }
    }
}
