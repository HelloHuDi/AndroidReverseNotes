package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ckw */
public final class ckw extends C1331a {
    public int ptw;
    public int ptx;
    public String wdD;
    public String wdE;
    public String wdF;
    public String wdO;
    public C1332b xiD;
    public boolean xiE;
    public LinkedList<String> xiF = new LinkedList();
    public String xiG;

    public ckw() {
        AppMethodBeat.m2504i(62584);
        AppMethodBeat.m2505o(62584);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(62585);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xiD == null) {
                c6092b = new C6092b("Not all required fields were included: EmojiBuffer");
                AppMethodBeat.m2505o(62585);
                throw c6092b;
            }
            if (this.wdO != null) {
                c6093a.mo13475e(1, this.wdO);
            }
            c6093a.mo13480iz(2, this.ptx);
            c6093a.mo13480iz(3, this.ptw);
            if (this.xiD != null) {
                c6093a.mo13473c(4, this.xiD);
            }
            c6093a.mo13471aO(5, this.xiE);
            c6093a.mo13474e(6, 1, this.xiF);
            if (this.wdD != null) {
                c6093a.mo13475e(7, this.wdD);
            }
            if (this.xiG != null) {
                c6093a.mo13475e(8, this.xiG);
            }
            if (this.wdF != null) {
                c6093a.mo13475e(9, this.wdF);
            }
            if (this.wdE != null) {
                c6093a.mo13475e(10, this.wdE);
            }
            AppMethodBeat.m2505o(62585);
            return 0;
        } else if (i == 1) {
            if (this.wdO != null) {
                f = C6091a.m9575f(1, this.wdO) + 0;
            } else {
                f = 0;
            }
            f = (f + C6091a.m9572bs(2, this.ptx)) + C6091a.m9572bs(3, this.ptw);
            if (this.xiD != null) {
                f += C6091a.m9571b(4, this.xiD);
            }
            f = (f + (C6091a.m9576fv(5) + 1)) + C6087a.m9552c(6, 1, this.xiF);
            if (this.wdD != null) {
                f += C6091a.m9575f(7, this.wdD);
            }
            if (this.xiG != null) {
                f += C6091a.m9575f(8, this.xiG);
            }
            if (this.wdF != null) {
                f += C6091a.m9575f(9, this.wdF);
            }
            if (this.wdE != null) {
                f += C6091a.m9575f(10, this.wdE);
            }
            AppMethodBeat.m2505o(62585);
            return f;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.xiF.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.xiD == null) {
                c6092b = new C6092b("Not all required fields were included: EmojiBuffer");
                AppMethodBeat.m2505o(62585);
                throw c6092b;
            }
            AppMethodBeat.m2505o(62585);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ckw ckw = (ckw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ckw.wdO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62585);
                    return 0;
                case 2:
                    ckw.ptx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62585);
                    return 0;
                case 3:
                    ckw.ptw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62585);
                    return 0;
                case 4:
                    ckw.xiD = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(62585);
                    return 0;
                case 5:
                    ckw.xiE = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(62585);
                    return 0;
                case 6:
                    ckw.xiF.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(62585);
                    return 0;
                case 7:
                    ckw.wdD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62585);
                    return 0;
                case 8:
                    ckw.xiG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62585);
                    return 0;
                case 9:
                    ckw.wdF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62585);
                    return 0;
                case 10:
                    ckw.wdE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62585);
                    return 0;
                default:
                    AppMethodBeat.m2505o(62585);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(62585);
            return -1;
        }
    }
}
