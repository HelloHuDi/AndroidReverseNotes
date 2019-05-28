package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bqj */
public final class bqj extends C1331a {
    public long bHi;
    public String csB;
    public String nickname;
    public String pia;
    public String username;
    public String wSE;
    public double wSF;
    public LinkedList<C30210on> wSG = new LinkedList();
    public String wSH;
    public LinkedList<btm> wSI = new LinkedList();

    public bqj() {
        AppMethodBeat.m2504i(134441);
        AppMethodBeat.m2505o(134441);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(134442);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.csB != null) {
                c6093a.mo13475e(1, this.csB);
            }
            if (this.username != null) {
                c6093a.mo13475e(2, this.username);
            }
            if (this.nickname != null) {
                c6093a.mo13475e(3, this.nickname);
            }
            if (this.pia != null) {
                c6093a.mo13475e(4, this.pia);
            }
            c6093a.mo13472ai(5, this.bHi);
            if (this.wSE != null) {
                c6093a.mo13475e(6, this.wSE);
            }
            c6093a.mo13476f(7, this.wSF);
            c6093a.mo13474e(16, 8, this.wSG);
            if (this.wSH != null) {
                c6093a.mo13475e(17, this.wSH);
            }
            c6093a.mo13474e(19, 8, this.wSI);
            AppMethodBeat.m2505o(134442);
            return 0;
        } else if (i == 1) {
            if (this.csB != null) {
                f = C6091a.m9575f(1, this.csB) + 0;
            } else {
                f = 0;
            }
            if (this.username != null) {
                f += C6091a.m9575f(2, this.username);
            }
            if (this.nickname != null) {
                f += C6091a.m9575f(3, this.nickname);
            }
            if (this.pia != null) {
                f += C6091a.m9575f(4, this.pia);
            }
            f += C6091a.m9578o(5, this.bHi);
            if (this.wSE != null) {
                f += C6091a.m9575f(6, this.wSE);
            }
            f = (f + (C6091a.m9576fv(7) + 8)) + C6087a.m9552c(16, 8, this.wSG);
            if (this.wSH != null) {
                f += C6091a.m9575f(17, this.wSH);
            }
            int c = f + C6087a.m9552c(19, 8, this.wSI);
            AppMethodBeat.m2505o(134442);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wSG.clear();
            this.wSI.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(134442);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bqj bqj = (bqj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    bqj.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134442);
                    return 0;
                case 2:
                    bqj.username = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134442);
                    return 0;
                case 3:
                    bqj.nickname = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134442);
                    return 0;
                case 4:
                    bqj.pia = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134442);
                    return 0;
                case 5:
                    bqj.bHi = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(134442);
                    return 0;
                case 6:
                    bqj.wSE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134442);
                    return 0;
                case 7:
                    bqj.wSF = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(134442);
                    return 0;
                case 16:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C30210on c30210on = new C30210on();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c30210on.populateBuilderWithField(c6086a3, c30210on, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bqj.wSG.add(c30210on);
                    }
                    AppMethodBeat.m2505o(134442);
                    return 0;
                case 17:
                    bqj.wSH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134442);
                    return 0;
                case 19:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btm btm = new btm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = btm.populateBuilderWithField(c6086a3, btm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bqj.wSI.add(btm);
                    }
                    AppMethodBeat.m2505o(134442);
                    return 0;
                default:
                    AppMethodBeat.m2505o(134442);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(134442);
            return -1;
        }
    }
}
