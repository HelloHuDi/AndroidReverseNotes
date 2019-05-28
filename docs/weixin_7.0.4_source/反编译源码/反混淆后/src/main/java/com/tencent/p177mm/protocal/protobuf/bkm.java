package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bkm */
public final class bkm extends C1331a {
    public long cSh;
    public int ehf;
    public String nuL;
    public String pbn;
    public String pck;
    public int state;
    public String vEQ;
    public int vES;
    public String wND;
    public cij wNE;
    public bdg wNF;
    public bbk wNG;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56921);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.ehf);
            c6093a.mo13472ai(2, this.cSh);
            if (this.pbn != null) {
                c6093a.mo13475e(3, this.pbn);
            }
            if (this.pck != null) {
                c6093a.mo13475e(4, this.pck);
            }
            if (this.vEQ != null) {
                c6093a.mo13475e(5, this.vEQ);
            }
            if (this.wND != null) {
                c6093a.mo13475e(6, this.wND);
            }
            if (this.wNE != null) {
                c6093a.mo13479iy(7, this.wNE.computeSize());
                this.wNE.writeFields(c6093a);
            }
            if (this.wNF != null) {
                c6093a.mo13479iy(8, this.wNF.computeSize());
                this.wNF.writeFields(c6093a);
            }
            if (this.wNG != null) {
                c6093a.mo13479iy(9, this.wNG.computeSize());
                this.wNG.writeFields(c6093a);
            }
            c6093a.mo13480iz(10, this.vES);
            c6093a.mo13480iz(11, this.state);
            if (this.nuL != null) {
                c6093a.mo13475e(12, this.nuL);
            }
            AppMethodBeat.m2505o(56921);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.ehf) + 0) + C6091a.m9578o(2, this.cSh);
            if (this.pbn != null) {
                bs += C6091a.m9575f(3, this.pbn);
            }
            if (this.pck != null) {
                bs += C6091a.m9575f(4, this.pck);
            }
            if (this.vEQ != null) {
                bs += C6091a.m9575f(5, this.vEQ);
            }
            if (this.wND != null) {
                bs += C6091a.m9575f(6, this.wND);
            }
            if (this.wNE != null) {
                bs += C6087a.m9557ix(7, this.wNE.computeSize());
            }
            if (this.wNF != null) {
                bs += C6087a.m9557ix(8, this.wNF.computeSize());
            }
            if (this.wNG != null) {
                bs += C6087a.m9557ix(9, this.wNG.computeSize());
            }
            bs = (bs + C6091a.m9572bs(10, this.vES)) + C6091a.m9572bs(11, this.state);
            if (this.nuL != null) {
                bs += C6091a.m9575f(12, this.nuL);
            }
            AppMethodBeat.m2505o(56921);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56921);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bkm bkm = (bkm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    bkm.ehf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56921);
                    return 0;
                case 2:
                    bkm.cSh = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56921);
                    return 0;
                case 3:
                    bkm.pbn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56921);
                    return 0;
                case 4:
                    bkm.pck = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56921);
                    return 0;
                case 5:
                    bkm.vEQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56921);
                    return 0;
                case 6:
                    bkm.wND = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56921);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cij cij = new cij();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cij.populateBuilderWithField(c6086a3, cij, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bkm.wNE = cij;
                    }
                    AppMethodBeat.m2505o(56921);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdg bdg = new bdg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdg.populateBuilderWithField(c6086a3, bdg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bkm.wNF = bdg;
                    }
                    AppMethodBeat.m2505o(56921);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bbk bbk = new bbk();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbk.populateBuilderWithField(c6086a3, bbk, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bkm.wNG = bbk;
                    }
                    AppMethodBeat.m2505o(56921);
                    return 0;
                case 10:
                    bkm.vES = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56921);
                    return 0;
                case 11:
                    bkm.state = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56921);
                    return 0;
                case 12:
                    bkm.nuL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56921);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56921);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56921);
            return -1;
        }
    }
}
