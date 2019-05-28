package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.view.C31128d;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cbf */
public final class cbf extends C1331a {
    public int pcX;
    public LinkedList<cba> vFk = new LinkedList();
    public String vHl;
    public long vQE;
    public String wCW;
    public LinkedList<bts> wFp = new LinkedList();
    public int wGu;
    public int wGz;
    public int wHG;
    public int wZH;
    public int xaA;
    public LinkedList<bts> xaB = new LinkedList();
    public int xaC;
    public SKBuiltinBuffer_t xaD;
    public cbu xaE;
    public bld xaF;
    public cap xaG;
    public SKBuiltinBuffer_t xam;
    public int xan;
    public int xao;
    public int xap;
    public LinkedList<cat> xaq = new LinkedList();
    public int xar;
    public int xas;
    public LinkedList<cat> xat = new LinkedList();
    public int xau;
    public int xav;
    public LinkedList<cat> xaw = new LinkedList();
    public int xax;
    public String xay;
    public long xaz;

    public cbf() {
        AppMethodBeat.m2504i(94581);
        AppMethodBeat.m2505o(94581);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94582);
        C6092b c6092b;
        int o;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xam == null) {
                c6092b = new C6092b("Not all required fields were included: ObjectDesc");
                AppMethodBeat.m2505o(94582);
                throw c6092b;
            }
            c6093a.mo13472ai(1, this.vQE);
            if (this.vHl != null) {
                c6093a.mo13475e(2, this.vHl);
            }
            if (this.wCW != null) {
                c6093a.mo13475e(3, this.wCW);
            }
            c6093a.mo13480iz(4, this.pcX);
            if (this.xam != null) {
                c6093a.mo13479iy(5, this.xam.computeSize());
                this.xam.writeFields(c6093a);
            }
            c6093a.mo13480iz(6, this.xan);
            c6093a.mo13480iz(7, this.xao);
            c6093a.mo13480iz(8, this.xap);
            c6093a.mo13474e(9, 8, this.xaq);
            c6093a.mo13480iz(10, this.xar);
            c6093a.mo13480iz(11, this.xas);
            c6093a.mo13474e(12, 8, this.xat);
            c6093a.mo13480iz(13, this.xau);
            c6093a.mo13480iz(14, this.xav);
            c6093a.mo13474e(15, 8, this.xaw);
            c6093a.mo13480iz(16, this.wGz);
            c6093a.mo13480iz(17, this.xax);
            c6093a.mo13480iz(18, this.wHG);
            c6093a.mo13474e(19, 8, this.vFk);
            c6093a.mo13480iz(20, this.wZH);
            if (this.xay != null) {
                c6093a.mo13475e(21, this.xay);
            }
            c6093a.mo13472ai(22, this.xaz);
            c6093a.mo13480iz(23, this.xaA);
            c6093a.mo13474e(24, 8, this.xaB);
            c6093a.mo13480iz(25, this.wGu);
            c6093a.mo13480iz(26, this.xaC);
            c6093a.mo13474e(27, 8, this.wFp);
            if (this.xaD != null) {
                c6093a.mo13479iy(28, this.xaD.computeSize());
                this.xaD.writeFields(c6093a);
            }
            if (this.xaE != null) {
                c6093a.mo13479iy(29, this.xaE.computeSize());
                this.xaE.writeFields(c6093a);
            }
            if (this.xaF != null) {
                c6093a.mo13479iy(30, this.xaF.computeSize());
                this.xaF.writeFields(c6093a);
            }
            if (this.xaG != null) {
                c6093a.mo13479iy(31, this.xaG.computeSize());
                this.xaG.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(94582);
            return 0;
        } else if (i == 1) {
            o = C6091a.m9578o(1, this.vQE) + 0;
            if (this.vHl != null) {
                o += C6091a.m9575f(2, this.vHl);
            }
            if (this.wCW != null) {
                o += C6091a.m9575f(3, this.wCW);
            }
            o += C6091a.m9572bs(4, this.pcX);
            if (this.xam != null) {
                o += C6087a.m9557ix(5, this.xam.computeSize());
            }
            o = ((((((((((((((o + C6091a.m9572bs(6, this.xan)) + C6091a.m9572bs(7, this.xao)) + C6091a.m9572bs(8, this.xap)) + C6087a.m9552c(9, 8, this.xaq)) + C6091a.m9572bs(10, this.xar)) + C6091a.m9572bs(11, this.xas)) + C6087a.m9552c(12, 8, this.xat)) + C6091a.m9572bs(13, this.xau)) + C6091a.m9572bs(14, this.xav)) + C6087a.m9552c(15, 8, this.xaw)) + C6091a.m9572bs(16, this.wGz)) + C6091a.m9572bs(17, this.xax)) + C6091a.m9572bs(18, this.wHG)) + C6087a.m9552c(19, 8, this.vFk)) + C6091a.m9572bs(20, this.wZH);
            if (this.xay != null) {
                o += C6091a.m9575f(21, this.xay);
            }
            o = (((((o + C6091a.m9578o(22, this.xaz)) + C6091a.m9572bs(23, this.xaA)) + C6087a.m9552c(24, 8, this.xaB)) + C6091a.m9572bs(25, this.wGu)) + C6091a.m9572bs(26, this.xaC)) + C6087a.m9552c(27, 8, this.wFp);
            if (this.xaD != null) {
                o += C6087a.m9557ix(28, this.xaD.computeSize());
            }
            if (this.xaE != null) {
                o += C6087a.m9557ix(29, this.xaE.computeSize());
            }
            if (this.xaF != null) {
                o += C6087a.m9557ix(30, this.xaF.computeSize());
            }
            if (this.xaG != null) {
                o += C6087a.m9557ix(31, this.xaG.computeSize());
            }
            AppMethodBeat.m2505o(94582);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xaq.clear();
            this.xat.clear();
            this.xaw.clear();
            this.vFk.clear();
            this.xaB.clear();
            this.wFp.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            if (this.xam == null) {
                c6092b = new C6092b("Not all required fields were included: ObjectDesc");
                AppMethodBeat.m2505o(94582);
                throw c6092b;
            }
            AppMethodBeat.m2505o(94582);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cbf cbf = (cbf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            C6086a c6086a3;
            boolean z;
            cat cat;
            bts bts;
            switch (intValue) {
                case 1:
                    cbf.vQE = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 2:
                    cbf.vHl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 3:
                    cbf.wCW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 4:
                    cbf.pcX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbf.xam = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 6:
                    cbf.xan = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 7:
                    cbf.xao = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 8:
                    cbf.xap = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cat = new cat();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cat.populateBuilderWithField(c6086a3, cat, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbf.xaq.add(cat);
                    }
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 10:
                    cbf.xar = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 11:
                    cbf.xas = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 12:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cat = new cat();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cat.populateBuilderWithField(c6086a3, cat, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbf.xat.add(cat);
                    }
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 13:
                    cbf.xau = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 14:
                    cbf.xav = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 15:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cat = new cat();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cat.populateBuilderWithField(c6086a3, cat, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbf.xaw.add(cat);
                    }
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 16:
                    cbf.wGz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 17:
                    cbf.xax = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 18:
                    cbf.wHG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 19:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cba cba = new cba();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cba.populateBuilderWithField(c6086a3, cba, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbf.vFk.add(cba);
                    }
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 20:
                    cbf.wZH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 21:
                    cbf.xay = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 22:
                    cbf.xaz = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 23:
                    cbf.xaA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 24:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbf.xaB.add(bts);
                    }
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 25:
                    cbf.wGu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 26:
                    cbf.xaC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 27:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbf.wFp.add(bts);
                    }
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbf.xaD = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 29:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbu cbu = new cbu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbu.populateBuilderWithField(c6086a3, cbu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbf.xaE = cbu;
                    }
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 30:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bld bld = new bld();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bld.populateBuilderWithField(c6086a3, bld, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbf.xaF = bld;
                    }
                    AppMethodBeat.m2505o(94582);
                    return 0;
                case 31:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cap cap = new cap();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cap.populateBuilderWithField(c6086a3, cap, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbf.xaG = cap;
                    }
                    AppMethodBeat.m2505o(94582);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94582);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94582);
            return -1;
        }
    }
}
