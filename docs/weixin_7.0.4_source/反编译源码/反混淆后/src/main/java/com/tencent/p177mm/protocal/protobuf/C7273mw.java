package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.mw */
public final class C7273mw extends C1331a {
    public int luF;
    public int vQV;
    public int vQW;
    public int vQX;
    public int vQY;
    public LinkedList<bts> vQZ = new LinkedList();
    public String vRa;
    public SKBuiltinBuffer_t vRb;
    public int vRc;
    public int vRd;
    public LinkedList<bts> vRe = new LinkedList();
    public LinkedList<C7274mx> vRf = new LinkedList();
    public LinkedList<C7274mx> vRg = new LinkedList();
    public int vRh;
    public int vRi;

    public C7273mw() {
        AppMethodBeat.m2504i(58898);
        AppMethodBeat.m2505o(58898);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(58899);
        C6092b c6092b;
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vRb == null) {
                c6092b = new C6092b("Not all required fields were included: AuthKey");
                AppMethodBeat.m2505o(58899);
                throw c6092b;
            }
            c6093a.mo13480iz(1, this.vQV);
            c6093a.mo13480iz(2, this.luF);
            c6093a.mo13480iz(3, this.vQW);
            c6093a.mo13480iz(4, this.vQX);
            c6093a.mo13480iz(5, this.vQY);
            c6093a.mo13474e(6, 8, this.vQZ);
            if (this.vRa != null) {
                c6093a.mo13475e(7, this.vRa);
            }
            if (this.vRb != null) {
                c6093a.mo13479iy(8, this.vRb.computeSize());
                this.vRb.writeFields(c6093a);
            }
            c6093a.mo13480iz(9, this.vRc);
            c6093a.mo13480iz(10, this.vRd);
            c6093a.mo13474e(11, 8, this.vRe);
            c6093a.mo13474e(12, 8, this.vRf);
            c6093a.mo13474e(13, 8, this.vRg);
            c6093a.mo13480iz(14, this.vRh);
            c6093a.mo13480iz(15, this.vRi);
            AppMethodBeat.m2505o(58899);
            return 0;
        } else if (i == 1) {
            bs = (((((C6091a.m9572bs(1, this.vQV) + 0) + C6091a.m9572bs(2, this.luF)) + C6091a.m9572bs(3, this.vQW)) + C6091a.m9572bs(4, this.vQX)) + C6091a.m9572bs(5, this.vQY)) + C6087a.m9552c(6, 8, this.vQZ);
            if (this.vRa != null) {
                bs += C6091a.m9575f(7, this.vRa);
            }
            if (this.vRb != null) {
                bs += C6087a.m9557ix(8, this.vRb.computeSize());
            }
            bs = ((((((bs + C6091a.m9572bs(9, this.vRc)) + C6091a.m9572bs(10, this.vRd)) + C6087a.m9552c(11, 8, this.vRe)) + C6087a.m9552c(12, 8, this.vRf)) + C6087a.m9552c(13, 8, this.vRg)) + C6091a.m9572bs(14, this.vRh)) + C6091a.m9572bs(15, this.vRi);
            AppMethodBeat.m2505o(58899);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vQZ.clear();
            this.vRe.clear();
            this.vRf.clear();
            this.vRg.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.vRb == null) {
                c6092b = new C6092b("Not all required fields were included: AuthKey");
                AppMethodBeat.m2505o(58899);
                throw c6092b;
            }
            AppMethodBeat.m2505o(58899);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7273mw c7273mw = (C7273mw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            bts bts;
            C6086a c6086a3;
            boolean z;
            C7274mx c7274mx;
            switch (intValue) {
                case 1:
                    c7273mw.vQV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58899);
                    return 0;
                case 2:
                    c7273mw.luF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58899);
                    return 0;
                case 3:
                    c7273mw.vQW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58899);
                    return 0;
                case 4:
                    c7273mw.vQX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58899);
                    return 0;
                case 5:
                    c7273mw.vQY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58899);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7273mw.vQZ.add(bts);
                    }
                    AppMethodBeat.m2505o(58899);
                    return 0;
                case 7:
                    c7273mw.vRa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58899);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7273mw.vRb = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58899);
                    return 0;
                case 9:
                    c7273mw.vRc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58899);
                    return 0;
                case 10:
                    c7273mw.vRd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58899);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7273mw.vRe.add(bts);
                    }
                    AppMethodBeat.m2505o(58899);
                    return 0;
                case 12:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c7274mx = new C7274mx();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7274mx.populateBuilderWithField(c6086a3, c7274mx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7273mw.vRf.add(c7274mx);
                    }
                    AppMethodBeat.m2505o(58899);
                    return 0;
                case 13:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c7274mx = new C7274mx();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7274mx.populateBuilderWithField(c6086a3, c7274mx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7273mw.vRg.add(c7274mx);
                    }
                    AppMethodBeat.m2505o(58899);
                    return 0;
                case 14:
                    c7273mw.vRh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58899);
                    return 0;
                case 15:
                    c7273mw.vRi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58899);
                    return 0;
                default:
                    AppMethodBeat.m2505o(58899);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(58899);
            return -1;
        }
    }
}
