package com.tencent.p177mm.plugin.wallet.p748a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.wallet.a.h */
public final class C7176h extends C1331a {
    public double tmR;
    public double tmS;
    public double tmT;
    public String tmU;
    public LinkedList<C43758t> tmV = new LinkedList();
    public C22492i tmW;
    public int tmX;
    public String tmY;
    public String tmZ;
    public double tna;
    public double tnb;
    public int tnc;
    public String tnd;
    public String tne;
    public C35390a tnf;
    public LinkedList<C7175g> tng = new LinkedList();
    public C40049b tnh;

    public C7176h() {
        AppMethodBeat.m2504i(56649);
        AppMethodBeat.m2505o(56649);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56650);
        int fv;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13476f(1, this.tmR);
            c6093a.mo13476f(2, this.tmS);
            c6093a.mo13476f(3, this.tmT);
            if (this.tmU != null) {
                c6093a.mo13475e(4, this.tmU);
            }
            c6093a.mo13474e(5, 8, this.tmV);
            if (this.tmW != null) {
                c6093a.mo13479iy(6, this.tmW.computeSize());
                this.tmW.writeFields(c6093a);
            }
            c6093a.mo13480iz(7, this.tmX);
            if (this.tmY != null) {
                c6093a.mo13475e(8, this.tmY);
            }
            if (this.tmZ != null) {
                c6093a.mo13475e(9, this.tmZ);
            }
            c6093a.mo13476f(10, this.tna);
            c6093a.mo13476f(11, this.tnb);
            c6093a.mo13480iz(12, this.tnc);
            if (this.tnd != null) {
                c6093a.mo13475e(13, this.tnd);
            }
            if (this.tne != null) {
                c6093a.mo13475e(14, this.tne);
            }
            if (this.tnf != null) {
                c6093a.mo13479iy(15, this.tnf.computeSize());
                this.tnf.writeFields(c6093a);
            }
            c6093a.mo13474e(16, 8, this.tng);
            if (this.tnh != null) {
                c6093a.mo13479iy(17, this.tnh.computeSize());
                this.tnh.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(56650);
            return 0;
        } else if (i == 1) {
            fv = (((C6091a.m9576fv(1) + 8) + 0) + (C6091a.m9576fv(2) + 8)) + (C6091a.m9576fv(3) + 8);
            if (this.tmU != null) {
                fv += C6091a.m9575f(4, this.tmU);
            }
            fv += C6087a.m9552c(5, 8, this.tmV);
            if (this.tmW != null) {
                fv += C6087a.m9557ix(6, this.tmW.computeSize());
            }
            fv += C6091a.m9572bs(7, this.tmX);
            if (this.tmY != null) {
                fv += C6091a.m9575f(8, this.tmY);
            }
            if (this.tmZ != null) {
                fv += C6091a.m9575f(9, this.tmZ);
            }
            fv = ((fv + (C6091a.m9576fv(10) + 8)) + (C6091a.m9576fv(11) + 8)) + C6091a.m9572bs(12, this.tnc);
            if (this.tnd != null) {
                fv += C6091a.m9575f(13, this.tnd);
            }
            if (this.tne != null) {
                fv += C6091a.m9575f(14, this.tne);
            }
            if (this.tnf != null) {
                fv += C6087a.m9557ix(15, this.tnf.computeSize());
            }
            fv += C6087a.m9552c(16, 8, this.tng);
            if (this.tnh != null) {
                fv += C6087a.m9557ix(17, this.tnh.computeSize());
            }
            AppMethodBeat.m2505o(56650);
            return fv;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.tmV.clear();
            this.tng.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (fv = C1331a.getNextFieldNumber(c6086a); fv > 0; fv = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, fv)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56650);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7176h c7176h = (C7176h) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c7176h.tmR = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(56650);
                    return 0;
                case 2:
                    c7176h.tmS = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(56650);
                    return 0;
                case 3:
                    c7176h.tmT = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(56650);
                    return 0;
                case 4:
                    c7176h.tmU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56650);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C43758t c43758t = new C43758t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c43758t.populateBuilderWithField(c6086a3, c43758t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7176h.tmV.add(c43758t);
                    }
                    AppMethodBeat.m2505o(56650);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C22492i c22492i = new C22492i();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c22492i.populateBuilderWithField(c6086a3, c22492i, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7176h.tmW = c22492i;
                    }
                    AppMethodBeat.m2505o(56650);
                    return 0;
                case 7:
                    c7176h.tmX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56650);
                    return 0;
                case 8:
                    c7176h.tmY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56650);
                    return 0;
                case 9:
                    c7176h.tmZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56650);
                    return 0;
                case 10:
                    c7176h.tna = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(56650);
                    return 0;
                case 11:
                    c7176h.tnb = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(56650);
                    return 0;
                case 12:
                    c7176h.tnc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56650);
                    return 0;
                case 13:
                    c7176h.tnd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56650);
                    return 0;
                case 14:
                    c7176h.tne = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56650);
                    return 0;
                case 15:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C35390a c35390a = new C35390a();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c35390a.populateBuilderWithField(c6086a3, c35390a, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7176h.tnf = c35390a;
                    }
                    AppMethodBeat.m2505o(56650);
                    return 0;
                case 16:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7175g c7175g = new C7175g();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7175g.populateBuilderWithField(c6086a3, c7175g, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7176h.tng.add(c7175g);
                    }
                    AppMethodBeat.m2505o(56650);
                    return 0;
                case 17:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40049b c40049b = new C40049b();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40049b.populateBuilderWithField(c6086a3, c40049b, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7176h.tnh = c40049b;
                    }
                    AppMethodBeat.m2505o(56650);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56650);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56650);
            return -1;
        }
    }
}
