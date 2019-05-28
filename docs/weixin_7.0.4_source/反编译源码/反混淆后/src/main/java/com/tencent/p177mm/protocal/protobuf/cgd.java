package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cgd */
public final class cgd extends C1331a {
    public btr vCP;
    public String vJS;
    public bif wVz;
    public auj xff;
    public LinkedList<cgv> xfg = new LinkedList();
    public LinkedList<cgv> xfh = new LinkedList();
    public auj xfi;
    public bqn xfj;
    public btq xfk;

    public cgd() {
        AppMethodBeat.m2504i(48965);
        AppMethodBeat.m2505o(48965);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48966);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xff != null) {
                c6093a.mo13479iy(1, this.xff.computeSize());
                this.xff.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 8, this.xfg);
            c6093a.mo13474e(3, 8, this.xfh);
            if (this.xfi != null) {
                c6093a.mo13479iy(4, this.xfi.computeSize());
                this.xfi.writeFields(c6093a);
            }
            if (this.xfj != null) {
                c6093a.mo13479iy(5, this.xfj.computeSize());
                this.xfj.writeFields(c6093a);
            }
            if (this.vJS != null) {
                c6093a.mo13475e(6, this.vJS);
            }
            if (this.wVz != null) {
                c6093a.mo13479iy(7, this.wVz.computeSize());
                this.wVz.writeFields(c6093a);
            }
            if (this.vCP != null) {
                c6093a.mo13479iy(8, this.vCP.computeSize());
                this.vCP.writeFields(c6093a);
            }
            if (this.xfk != null) {
                c6093a.mo13479iy(9, this.xfk.computeSize());
                this.xfk.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(48966);
            return 0;
        } else if (i == 1) {
            if (this.xff != null) {
                ix = C6087a.m9557ix(1, this.xff.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6087a.m9552c(2, 8, this.xfg)) + C6087a.m9552c(3, 8, this.xfh);
            if (this.xfi != null) {
                ix += C6087a.m9557ix(4, this.xfi.computeSize());
            }
            if (this.xfj != null) {
                ix += C6087a.m9557ix(5, this.xfj.computeSize());
            }
            if (this.vJS != null) {
                ix += C6091a.m9575f(6, this.vJS);
            }
            if (this.wVz != null) {
                ix += C6087a.m9557ix(7, this.wVz.computeSize());
            }
            if (this.vCP != null) {
                ix += C6087a.m9557ix(8, this.vCP.computeSize());
            }
            if (this.xfk != null) {
                ix += C6087a.m9557ix(9, this.xfk.computeSize());
            }
            AppMethodBeat.m2505o(48966);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xfg.clear();
            this.xfh.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48966);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cgd cgd = (cgd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            auj auj;
            C6086a c6086a3;
            boolean z;
            cgv cgv;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        auj = new auj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = auj.populateBuilderWithField(c6086a3, auj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cgd.xff = auj;
                    }
                    AppMethodBeat.m2505o(48966);
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
                        cgd.xfg.add(cgv);
                    }
                    AppMethodBeat.m2505o(48966);
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
                        cgd.xfh.add(cgv);
                    }
                    AppMethodBeat.m2505o(48966);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        auj = new auj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = auj.populateBuilderWithField(c6086a3, auj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cgd.xfi = auj;
                    }
                    AppMethodBeat.m2505o(48966);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bqn bqn = new bqn();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqn.populateBuilderWithField(c6086a3, bqn, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cgd.xfj = bqn;
                    }
                    AppMethodBeat.m2505o(48966);
                    return 0;
                case 6:
                    cgd.vJS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48966);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bif bif = new bif();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bif.populateBuilderWithField(c6086a3, bif, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cgd.wVz = bif;
                    }
                    AppMethodBeat.m2505o(48966);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btr btr = new btr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = btr.populateBuilderWithField(c6086a3, btr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cgd.vCP = btr;
                    }
                    AppMethodBeat.m2505o(48966);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btq btq = new btq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = btq.populateBuilderWithField(c6086a3, btq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cgd.xfk = btq;
                    }
                    AppMethodBeat.m2505o(48966);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48966);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48966);
            return -1;
        }
    }
}
