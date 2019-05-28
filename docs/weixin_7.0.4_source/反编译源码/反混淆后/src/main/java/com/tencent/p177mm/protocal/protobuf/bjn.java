package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bjn */
public final class bjn extends C1331a {
    public String ncH;
    public String pcU;
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
    public LinkedList<bzv> pdj = new LinkedList();
    public int wMU;

    public bjn() {
        AppMethodBeat.m2504i(56901);
        AppMethodBeat.m2505o(56901);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56902);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.pcU != null) {
                c6093a.mo13475e(1, this.pcU);
            }
            c6093a.mo13480iz(2, this.wMU);
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
            AppMethodBeat.m2505o(56902);
            return 0;
        } else if (i == 1) {
            if (this.pcU != null) {
                f = C6091a.m9575f(1, this.pcU) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.wMU);
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
            int bs = (f + C6091a.m9572bs(16, this.pdi)) + C6087a.m9552c(17, 8, this.pdj);
            AppMethodBeat.m2505o(56902);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.pdj.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56902);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bjn bjn = (bjn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bjn.pcU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56902);
                    return 0;
                case 2:
                    bjn.wMU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56902);
                    return 0;
                case 3:
                    bjn.pcW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56902);
                    return 0;
                case 4:
                    bjn.pcX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56902);
                    return 0;
                case 5:
                    bjn.pcY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56902);
                    return 0;
                case 6:
                    bjn.pcZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56902);
                    return 0;
                case 7:
                    bjn.pda = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56902);
                    return 0;
                case 8:
                    bjn.pdb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56902);
                    return 0;
                case 9:
                    bjn.pdc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56902);
                    return 0;
                case 10:
                    bjn.pdd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56902);
                    return 0;
                case 11:
                    bjn.ncH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56902);
                    return 0;
                case 12:
                    bjn.pde = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56902);
                    return 0;
                case 13:
                    bjn.pdf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56902);
                    return 0;
                case 14:
                    bjn.pdg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56902);
                    return 0;
                case 15:
                    bjn.pdh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56902);
                    return 0;
                case 16:
                    bjn.pdi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56902);
                    return 0;
                case 17:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzv bzv = new bzv();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bzv.populateBuilderWithField(c6086a3, bzv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bjn.pdj.add(bzv);
                    }
                    AppMethodBeat.m2505o(56902);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56902);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56902);
            return -1;
        }
    }
}
