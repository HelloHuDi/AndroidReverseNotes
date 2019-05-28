package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cbq */
public final class cbq extends bsr {
    public String ptv;
    public SKBuiltinBuffer_t vIl;
    public int wFe;
    public LinkedList<cba> wFk = new LinkedList();
    public LinkedList<bts> wFp = new LinkedList();
    public cbp wFq;
    public int wHG;
    public civ wNQ;
    public int xaA;
    public LinkedList<bts> xaB = new LinkedList();
    public int xaC;
    public cbu xaE;
    public int xaU;
    public int xaV;
    public int xaW;
    public cbo xaX;
    public SKBuiltinBuffer_t xaY;
    public String xaZ;
    public SKBuiltinBuffer_t xam;
    public int xav;
    public LinkedList<bts> xaw = new LinkedList();
    public long xaz;
    public C40550nl xba;
    public int xbb;
    public LinkedList<bas> xbc = new LinkedList();
    public cap xbd;

    public cbq() {
        AppMethodBeat.m2504i(94595);
        AppMethodBeat.m2505o(94595);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94596);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xam == null) {
                c6092b = new C6092b("Not all required fields were included: ObjectDesc");
                AppMethodBeat.m2505o(94596);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.xam != null) {
                c6093a.mo13479iy(2, this.xam.computeSize());
                this.xam.writeFields(c6093a);
            }
            c6093a.mo13480iz(3, this.xav);
            c6093a.mo13474e(4, 8, this.xaw);
            c6093a.mo13480iz(5, this.xaU);
            c6093a.mo13480iz(6, this.wFe);
            if (this.ptv != null) {
                c6093a.mo13475e(7, this.ptv);
            }
            c6093a.mo13480iz(8, this.xaV);
            c6093a.mo13480iz(9, this.wHG);
            c6093a.mo13474e(10, 8, this.wFk);
            c6093a.mo13480iz(11, this.xaW);
            c6093a.mo13472ai(12, this.xaz);
            c6093a.mo13480iz(13, this.xaA);
            c6093a.mo13474e(14, 8, this.xaB);
            if (this.wNQ != null) {
                c6093a.mo13479iy(15, this.wNQ.computeSize());
                this.wNQ.writeFields(c6093a);
            }
            c6093a.mo13480iz(16, this.xaC);
            c6093a.mo13474e(17, 8, this.wFp);
            if (this.xaX != null) {
                c6093a.mo13479iy(18, this.xaX.computeSize());
                this.xaX.writeFields(c6093a);
            }
            if (this.wFq != null) {
                c6093a.mo13479iy(19, this.wFq.computeSize());
                this.wFq.writeFields(c6093a);
            }
            if (this.xaE != null) {
                c6093a.mo13479iy(20, this.xaE.computeSize());
                this.xaE.writeFields(c6093a);
            }
            if (this.xaY != null) {
                c6093a.mo13479iy(21, this.xaY.computeSize());
                this.xaY.writeFields(c6093a);
            }
            if (this.xaZ != null) {
                c6093a.mo13475e(22, this.xaZ);
            }
            if (this.xba != null) {
                c6093a.mo13479iy(23, this.xba.computeSize());
                this.xba.writeFields(c6093a);
            }
            c6093a.mo13480iz(24, this.xbb);
            c6093a.mo13474e(25, 8, this.xbc);
            if (this.xbd != null) {
                c6093a.mo13479iy(26, this.xbd.computeSize());
                this.xbd.writeFields(c6093a);
            }
            if (this.vIl != null) {
                c6093a.mo13479iy(27, this.vIl.computeSize());
                this.vIl.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(94596);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xam != null) {
                ix += C6087a.m9557ix(2, this.xam.computeSize());
            }
            ix = (((ix + C6091a.m9572bs(3, this.xav)) + C6087a.m9552c(4, 8, this.xaw)) + C6091a.m9572bs(5, this.xaU)) + C6091a.m9572bs(6, this.wFe);
            if (this.ptv != null) {
                ix += C6091a.m9575f(7, this.ptv);
            }
            ix = ((((((ix + C6091a.m9572bs(8, this.xaV)) + C6091a.m9572bs(9, this.wHG)) + C6087a.m9552c(10, 8, this.wFk)) + C6091a.m9572bs(11, this.xaW)) + C6091a.m9578o(12, this.xaz)) + C6091a.m9572bs(13, this.xaA)) + C6087a.m9552c(14, 8, this.xaB);
            if (this.wNQ != null) {
                ix += C6087a.m9557ix(15, this.wNQ.computeSize());
            }
            ix = (ix + C6091a.m9572bs(16, this.xaC)) + C6087a.m9552c(17, 8, this.wFp);
            if (this.xaX != null) {
                ix += C6087a.m9557ix(18, this.xaX.computeSize());
            }
            if (this.wFq != null) {
                ix += C6087a.m9557ix(19, this.wFq.computeSize());
            }
            if (this.xaE != null) {
                ix += C6087a.m9557ix(20, this.xaE.computeSize());
            }
            if (this.xaY != null) {
                ix += C6087a.m9557ix(21, this.xaY.computeSize());
            }
            if (this.xaZ != null) {
                ix += C6091a.m9575f(22, this.xaZ);
            }
            if (this.xba != null) {
                ix += C6087a.m9557ix(23, this.xba.computeSize());
            }
            ix = (ix + C6091a.m9572bs(24, this.xbb)) + C6087a.m9552c(25, 8, this.xbc);
            if (this.xbd != null) {
                ix += C6087a.m9557ix(26, this.xbd.computeSize());
            }
            if (this.vIl != null) {
                ix += C6087a.m9557ix(27, this.vIl.computeSize());
            }
            AppMethodBeat.m2505o(94596);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xaw.clear();
            this.wFk.clear();
            this.xaB.clear();
            this.wFp.clear();
            this.xbc.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.xam == null) {
                c6092b = new C6092b("Not all required fields were included: ObjectDesc");
                AppMethodBeat.m2505o(94596);
                throw c6092b;
            }
            AppMethodBeat.m2505o(94596);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cbq cbq = (cbq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            bts bts;
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
                        cbq.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbq.xam = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 3:
                    cbq.xav = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbq.xaw.add(bts);
                    }
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 5:
                    cbq.xaU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 6:
                    cbq.wFe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 7:
                    cbq.ptv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 8:
                    cbq.xaV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 9:
                    cbq.wHG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cba cba = new cba();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cba.populateBuilderWithField(c6086a3, cba, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbq.wFk.add(cba);
                    }
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 11:
                    cbq.xaW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 12:
                    cbq.xaz = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 13:
                    cbq.xaA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 14:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbq.xaB.add(bts);
                    }
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 15:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        civ civ = new civ();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = civ.populateBuilderWithField(c6086a3, civ, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbq.wNQ = civ;
                    }
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 16:
                    cbq.xaC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 17:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbq.wFp.add(bts);
                    }
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 18:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbo cbo = new cbo();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbo.populateBuilderWithField(c6086a3, cbo, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbq.xaX = cbo;
                    }
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 19:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbp cbp = new cbp();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbp.populateBuilderWithField(c6086a3, cbp, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbq.wFq = cbp;
                    }
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 20:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbu cbu = new cbu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbu.populateBuilderWithField(c6086a3, cbu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbq.xaE = cbu;
                    }
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 21:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbq.xaY = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 22:
                    cbq.xaZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 23:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40550nl c40550nl = new C40550nl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40550nl.populateBuilderWithField(c6086a3, c40550nl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbq.xba = c40550nl;
                    }
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 24:
                    cbq.xbb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 25:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bas bas = new bas();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bas.populateBuilderWithField(c6086a3, bas, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbq.xbc.add(bas);
                    }
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 26:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cap cap = new cap();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cap.populateBuilderWithField(c6086a3, cap, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbq.xbd = cap;
                    }
                    AppMethodBeat.m2505o(94596);
                    return 0;
                case 27:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbq.vIl = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(94596);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94596);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94596);
            return -1;
        }
    }
}
