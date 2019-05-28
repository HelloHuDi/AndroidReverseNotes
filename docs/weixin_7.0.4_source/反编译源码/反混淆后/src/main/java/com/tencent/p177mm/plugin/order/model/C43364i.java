package com.tencent.p177mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.order.model.i */
public final class C43364i extends C1331a {
    public String ncH;
    public String pcU;
    public double pcV;
    public String pcW;
    public int pcX;
    public String pcY;
    public int pcZ;
    public String pda;
    public int pdb;
    public int pdc;
    public String pdd;
    public String pde;
    public String pdf;
    public String pdg;
    public String pdh;
    public int pdi;
    public LinkedList<C21423k> pdj = new LinkedList();
    public String pdk;
    public String pdl;
    public double pdm;
    public String pdn;

    public C43364i() {
        AppMethodBeat.m2504i(56618);
        AppMethodBeat.m2505o(56618);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56619);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.pcU != null) {
                c6093a.mo13475e(1, this.pcU);
            }
            c6093a.mo13476f(2, this.pcV);
            if (this.pcW != null) {
                c6093a.mo13475e(3, this.pcW);
            }
            c6093a.mo13480iz(4, this.pcX);
            if (this.pcY != null) {
                c6093a.mo13475e(5, this.pcY);
            }
            c6093a.mo13480iz(6, this.pcZ);
            if (this.pda != null) {
                c6093a.mo13475e(7, this.pda);
            }
            c6093a.mo13480iz(8, this.pdb);
            c6093a.mo13480iz(9, this.pdc);
            if (this.pdd != null) {
                c6093a.mo13475e(10, this.pdd);
            }
            if (this.ncH != null) {
                c6093a.mo13475e(11, this.ncH);
            }
            if (this.pde != null) {
                c6093a.mo13475e(12, this.pde);
            }
            if (this.pdf != null) {
                c6093a.mo13475e(13, this.pdf);
            }
            if (this.pdg != null) {
                c6093a.mo13475e(14, this.pdg);
            }
            if (this.pdh != null) {
                c6093a.mo13475e(15, this.pdh);
            }
            c6093a.mo13480iz(16, this.pdi);
            c6093a.mo13474e(17, 8, this.pdj);
            if (this.pdk != null) {
                c6093a.mo13475e(18, this.pdk);
            }
            if (this.pdl != null) {
                c6093a.mo13475e(19, this.pdl);
            }
            c6093a.mo13476f(20, this.pdm);
            if (this.pdn != null) {
                c6093a.mo13475e(21, this.pdn);
            }
            AppMethodBeat.m2505o(56619);
            return 0;
        } else if (i == 1) {
            if (this.pcU != null) {
                f = C6091a.m9575f(1, this.pcU) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9576fv(2) + 8;
            if (this.pcW != null) {
                f += C6091a.m9575f(3, this.pcW);
            }
            f += C6091a.m9572bs(4, this.pcX);
            if (this.pcY != null) {
                f += C6091a.m9575f(5, this.pcY);
            }
            f += C6091a.m9572bs(6, this.pcZ);
            if (this.pda != null) {
                f += C6091a.m9575f(7, this.pda);
            }
            f = (f + C6091a.m9572bs(8, this.pdb)) + C6091a.m9572bs(9, this.pdc);
            if (this.pdd != null) {
                f += C6091a.m9575f(10, this.pdd);
            }
            if (this.ncH != null) {
                f += C6091a.m9575f(11, this.ncH);
            }
            if (this.pde != null) {
                f += C6091a.m9575f(12, this.pde);
            }
            if (this.pdf != null) {
                f += C6091a.m9575f(13, this.pdf);
            }
            if (this.pdg != null) {
                f += C6091a.m9575f(14, this.pdg);
            }
            if (this.pdh != null) {
                f += C6091a.m9575f(15, this.pdh);
            }
            f = (f + C6091a.m9572bs(16, this.pdi)) + C6087a.m9552c(17, 8, this.pdj);
            if (this.pdk != null) {
                f += C6091a.m9575f(18, this.pdk);
            }
            if (this.pdl != null) {
                f += C6091a.m9575f(19, this.pdl);
            }
            f += C6091a.m9576fv(20) + 8;
            if (this.pdn != null) {
                f += C6091a.m9575f(21, this.pdn);
            }
            AppMethodBeat.m2505o(56619);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.pdj.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56619);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C43364i c43364i = (C43364i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c43364i.pcU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56619);
                    return 0;
                case 2:
                    c43364i.pcV = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(56619);
                    return 0;
                case 3:
                    c43364i.pcW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56619);
                    return 0;
                case 4:
                    c43364i.pcX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56619);
                    return 0;
                case 5:
                    c43364i.pcY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56619);
                    return 0;
                case 6:
                    c43364i.pcZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56619);
                    return 0;
                case 7:
                    c43364i.pda = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56619);
                    return 0;
                case 8:
                    c43364i.pdb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56619);
                    return 0;
                case 9:
                    c43364i.pdc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56619);
                    return 0;
                case 10:
                    c43364i.pdd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56619);
                    return 0;
                case 11:
                    c43364i.ncH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56619);
                    return 0;
                case 12:
                    c43364i.pde = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56619);
                    return 0;
                case 13:
                    c43364i.pdf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56619);
                    return 0;
                case 14:
                    c43364i.pdg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56619);
                    return 0;
                case 15:
                    c43364i.pdh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56619);
                    return 0;
                case 16:
                    c43364i.pdi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56619);
                    return 0;
                case 17:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C21423k c21423k = new C21423k();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c21423k.populateBuilderWithField(c6086a3, c21423k, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c43364i.pdj.add(c21423k);
                    }
                    AppMethodBeat.m2505o(56619);
                    return 0;
                case 18:
                    c43364i.pdk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56619);
                    return 0;
                case 19:
                    c43364i.pdl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56619);
                    return 0;
                case 20:
                    c43364i.pdm = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(56619);
                    return 0;
                case 21:
                    c43364i.pdn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56619);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56619);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56619);
            return -1;
        }
    }
}
