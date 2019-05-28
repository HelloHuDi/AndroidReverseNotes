package com.tencent.p177mm.plugin.wallet.p748a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.wallet.a.j */
public final class C46330j extends C1331a {
    public double tmT;
    public LinkedList<C43758t> tmV = new LinkedList();
    public double tna;
    public double tnb;
    public int tnc;
    public String tnd;
    public String tne;
    public C1332b tnj;
    public String tnk;
    public double tnl;
    public LinkedList<C7174f> tnm = new LinkedList();

    public C46330j() {
        AppMethodBeat.m2504i(56653);
        AppMethodBeat.m2505o(56653);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56654);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.tnk != null) {
                c6093a.mo13475e(1, this.tnk);
            }
            c6093a.mo13476f(2, this.tnl);
            c6093a.mo13476f(3, this.tmT);
            c6093a.mo13474e(4, 8, this.tnm);
            c6093a.mo13474e(5, 8, this.tmV);
            c6093a.mo13476f(6, this.tna);
            c6093a.mo13476f(7, this.tnb);
            c6093a.mo13480iz(8, this.tnc);
            if (this.tnd != null) {
                c6093a.mo13475e(9, this.tnd);
            }
            if (this.tne != null) {
                c6093a.mo13475e(10, this.tne);
            }
            if (this.tnj != null) {
                c6093a.mo13473c(11, this.tnj);
            }
            AppMethodBeat.m2505o(56654);
            return 0;
        } else if (i == 1) {
            if (this.tnk != null) {
                f = C6091a.m9575f(1, this.tnk) + 0;
            } else {
                f = 0;
            }
            f = ((((((f + (C6091a.m9576fv(2) + 8)) + (C6091a.m9576fv(3) + 8)) + C6087a.m9552c(4, 8, this.tnm)) + C6087a.m9552c(5, 8, this.tmV)) + (C6091a.m9576fv(6) + 8)) + (C6091a.m9576fv(7) + 8)) + C6091a.m9572bs(8, this.tnc);
            if (this.tnd != null) {
                f += C6091a.m9575f(9, this.tnd);
            }
            if (this.tne != null) {
                f += C6091a.m9575f(10, this.tne);
            }
            if (this.tnj != null) {
                f += C6091a.m9571b(11, this.tnj);
            }
            AppMethodBeat.m2505o(56654);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.tnm.clear();
            this.tmV.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56654);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46330j c46330j = (C46330j) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c46330j.tnk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56654);
                    return 0;
                case 2:
                    c46330j.tnl = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(56654);
                    return 0;
                case 3:
                    c46330j.tmT = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(56654);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7174f c7174f = new C7174f();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7174f.populateBuilderWithField(c6086a3, c7174f, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46330j.tnm.add(c7174f);
                    }
                    AppMethodBeat.m2505o(56654);
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
                        c46330j.tmV.add(c43758t);
                    }
                    AppMethodBeat.m2505o(56654);
                    return 0;
                case 6:
                    c46330j.tna = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(56654);
                    return 0;
                case 7:
                    c46330j.tnb = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(56654);
                    return 0;
                case 8:
                    c46330j.tnc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56654);
                    return 0;
                case 9:
                    c46330j.tnd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56654);
                    return 0;
                case 10:
                    c46330j.tne = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56654);
                    return 0;
                case 11:
                    c46330j.tnj = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(56654);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56654);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56654);
            return -1;
        }
    }
}
