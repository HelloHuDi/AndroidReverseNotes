package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.no */
public final class C35938no extends C1331a {
    public String code;
    public int status;
    public int vRU;
    public int vRV;
    public LinkedList<C44153op> vRW = new LinkedList();
    public LinkedList<C44153op> vRX = new LinkedList();
    public LinkedList<C44153op> vRY = new LinkedList();
    public LinkedList<String> vRZ = new LinkedList();
    public int vSa;
    public int vSb;
    public LinkedList<C23446tm> vSc = new LinkedList();
    public long vSd;
    public int vSe;
    public String vSf;
    public C23446tm vSg;
    public LinkedList<C15320ax> vSh = new LinkedList();
    public C23446tm vSi;
    public C23446tm vSj;
    public C23446tm vSk;
    public C15396wz vSl;
    public String vSm;
    public C23446tm vSn;
    public String vSo;
    public C23446tm vSp;
    public boolean vSq;
    public boolean vSr;

    public C35938no() {
        AppMethodBeat.m2504i(89019);
        AppMethodBeat.m2505o(89019);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89020);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.status);
            c6093a.mo13480iz(2, this.vRU);
            c6093a.mo13480iz(3, this.vRV);
            c6093a.mo13474e(4, 8, this.vRW);
            c6093a.mo13474e(5, 8, this.vRX);
            c6093a.mo13474e(6, 8, this.vRY);
            c6093a.mo13474e(7, 1, this.vRZ);
            c6093a.mo13480iz(8, this.vSa);
            if (this.code != null) {
                c6093a.mo13475e(9, this.code);
            }
            c6093a.mo13480iz(10, this.vSb);
            c6093a.mo13474e(11, 8, this.vSc);
            c6093a.mo13472ai(12, this.vSd);
            c6093a.mo13480iz(13, this.vSe);
            if (this.vSf != null) {
                c6093a.mo13475e(14, this.vSf);
            }
            if (this.vSg != null) {
                c6093a.mo13479iy(15, this.vSg.computeSize());
                this.vSg.writeFields(c6093a);
            }
            c6093a.mo13474e(16, 8, this.vSh);
            if (this.vSi != null) {
                c6093a.mo13479iy(17, this.vSi.computeSize());
                this.vSi.writeFields(c6093a);
            }
            if (this.vSj != null) {
                c6093a.mo13479iy(18, this.vSj.computeSize());
                this.vSj.writeFields(c6093a);
            }
            if (this.vSk != null) {
                c6093a.mo13479iy(19, this.vSk.computeSize());
                this.vSk.writeFields(c6093a);
            }
            if (this.vSl != null) {
                c6093a.mo13479iy(20, this.vSl.computeSize());
                this.vSl.writeFields(c6093a);
            }
            if (this.vSm != null) {
                c6093a.mo13475e(21, this.vSm);
            }
            if (this.vSn != null) {
                c6093a.mo13479iy(22, this.vSn.computeSize());
                this.vSn.writeFields(c6093a);
            }
            if (this.vSo != null) {
                c6093a.mo13475e(23, this.vSo);
            }
            if (this.vSp != null) {
                c6093a.mo13479iy(24, this.vSp.computeSize());
                this.vSp.writeFields(c6093a);
            }
            c6093a.mo13471aO(25, this.vSq);
            c6093a.mo13471aO(26, this.vSr);
            AppMethodBeat.m2505o(89020);
            return 0;
        } else if (i == 1) {
            bs = (((((((C6091a.m9572bs(1, this.status) + 0) + C6091a.m9572bs(2, this.vRU)) + C6091a.m9572bs(3, this.vRV)) + C6087a.m9552c(4, 8, this.vRW)) + C6087a.m9552c(5, 8, this.vRX)) + C6087a.m9552c(6, 8, this.vRY)) + C6087a.m9552c(7, 1, this.vRZ)) + C6091a.m9572bs(8, this.vSa);
            if (this.code != null) {
                bs += C6091a.m9575f(9, this.code);
            }
            bs = (((bs + C6091a.m9572bs(10, this.vSb)) + C6087a.m9552c(11, 8, this.vSc)) + C6091a.m9578o(12, this.vSd)) + C6091a.m9572bs(13, this.vSe);
            if (this.vSf != null) {
                bs += C6091a.m9575f(14, this.vSf);
            }
            if (this.vSg != null) {
                bs += C6087a.m9557ix(15, this.vSg.computeSize());
            }
            bs += C6087a.m9552c(16, 8, this.vSh);
            if (this.vSi != null) {
                bs += C6087a.m9557ix(17, this.vSi.computeSize());
            }
            if (this.vSj != null) {
                bs += C6087a.m9557ix(18, this.vSj.computeSize());
            }
            if (this.vSk != null) {
                bs += C6087a.m9557ix(19, this.vSk.computeSize());
            }
            if (this.vSl != null) {
                bs += C6087a.m9557ix(20, this.vSl.computeSize());
            }
            if (this.vSm != null) {
                bs += C6091a.m9575f(21, this.vSm);
            }
            if (this.vSn != null) {
                bs += C6087a.m9557ix(22, this.vSn.computeSize());
            }
            if (this.vSo != null) {
                bs += C6091a.m9575f(23, this.vSo);
            }
            if (this.vSp != null) {
                bs += C6087a.m9557ix(24, this.vSp.computeSize());
            }
            bs = (bs + (C6091a.m9576fv(25) + 1)) + (C6091a.m9576fv(26) + 1);
            AppMethodBeat.m2505o(89020);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vRW.clear();
            this.vRX.clear();
            this.vRY.clear();
            this.vRZ.clear();
            this.vSc.clear();
            this.vSh.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89020);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35938no c35938no = (C35938no) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C44153op c44153op;
            C6086a c6086a3;
            boolean z;
            C23446tm c23446tm;
            switch (intValue) {
                case 1:
                    c35938no.status = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89020);
                    return 0;
                case 2:
                    c35938no.vRU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89020);
                    return 0;
                case 3:
                    c35938no.vRV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89020);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c44153op = new C44153op();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44153op.populateBuilderWithField(c6086a3, c44153op, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35938no.vRW.add(c44153op);
                    }
                    AppMethodBeat.m2505o(89020);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c44153op = new C44153op();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44153op.populateBuilderWithField(c6086a3, c44153op, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35938no.vRX.add(c44153op);
                    }
                    AppMethodBeat.m2505o(89020);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c44153op = new C44153op();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44153op.populateBuilderWithField(c6086a3, c44153op, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35938no.vRY.add(c44153op);
                    }
                    AppMethodBeat.m2505o(89020);
                    return 0;
                case 7:
                    c35938no.vRZ.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(89020);
                    return 0;
                case 8:
                    c35938no.vSa = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89020);
                    return 0;
                case 9:
                    c35938no.code = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89020);
                    return 0;
                case 10:
                    c35938no.vSb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89020);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c23446tm = new C23446tm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23446tm.populateBuilderWithField(c6086a3, c23446tm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35938no.vSc.add(c23446tm);
                    }
                    AppMethodBeat.m2505o(89020);
                    return 0;
                case 12:
                    c35938no.vSd = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(89020);
                    return 0;
                case 13:
                    c35938no.vSe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89020);
                    return 0;
                case 14:
                    c35938no.vSf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89020);
                    return 0;
                case 15:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c23446tm = new C23446tm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23446tm.populateBuilderWithField(c6086a3, c23446tm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35938no.vSg = c23446tm;
                    }
                    AppMethodBeat.m2505o(89020);
                    return 0;
                case 16:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15320ax c15320ax = new C15320ax();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15320ax.populateBuilderWithField(c6086a3, c15320ax, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35938no.vSh.add(c15320ax);
                    }
                    AppMethodBeat.m2505o(89020);
                    return 0;
                case 17:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c23446tm = new C23446tm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23446tm.populateBuilderWithField(c6086a3, c23446tm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35938no.vSi = c23446tm;
                    }
                    AppMethodBeat.m2505o(89020);
                    return 0;
                case 18:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c23446tm = new C23446tm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23446tm.populateBuilderWithField(c6086a3, c23446tm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35938no.vSj = c23446tm;
                    }
                    AppMethodBeat.m2505o(89020);
                    return 0;
                case 19:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c23446tm = new C23446tm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23446tm.populateBuilderWithField(c6086a3, c23446tm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35938no.vSk = c23446tm;
                    }
                    AppMethodBeat.m2505o(89020);
                    return 0;
                case 20:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15396wz c15396wz = new C15396wz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15396wz.populateBuilderWithField(c6086a3, c15396wz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35938no.vSl = c15396wz;
                    }
                    AppMethodBeat.m2505o(89020);
                    return 0;
                case 21:
                    c35938no.vSm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89020);
                    return 0;
                case 22:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c23446tm = new C23446tm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23446tm.populateBuilderWithField(c6086a3, c23446tm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35938no.vSn = c23446tm;
                    }
                    AppMethodBeat.m2505o(89020);
                    return 0;
                case 23:
                    c35938no.vSo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89020);
                    return 0;
                case 24:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c23446tm = new C23446tm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23446tm.populateBuilderWithField(c6086a3, c23446tm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35938no.vSp = c23446tm;
                    }
                    AppMethodBeat.m2505o(89020);
                    return 0;
                case 25:
                    c35938no.vSq = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(89020);
                    return 0;
                case 26:
                    c35938no.vSr = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(89020);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89020);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89020);
            return -1;
        }
    }
}
