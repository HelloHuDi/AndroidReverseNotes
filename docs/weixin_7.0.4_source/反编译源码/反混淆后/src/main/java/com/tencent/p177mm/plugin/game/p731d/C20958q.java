package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.q */
public final class C20958q extends C1331a {
    public String nac;
    public String nad;
    public String nae;
    public C43170ds naf;
    public int nag;
    public int nah;
    public String nai;
    public int naj;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111556);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.nac == null) {
                c6092b = new C6092b("Not all required fields were included: DownloadURL");
                AppMethodBeat.m2505o(111556);
                throw c6092b;
            }
            if (this.nac != null) {
                c6093a.mo13475e(1, this.nac);
            }
            if (this.nad != null) {
                c6093a.mo13475e(2, this.nad);
            }
            if (this.nae != null) {
                c6093a.mo13475e(4, this.nae);
            }
            if (this.naf != null) {
                c6093a.mo13479iy(5, this.naf.computeSize());
                this.naf.writeFields(c6093a);
            }
            c6093a.mo13480iz(6, this.nag);
            c6093a.mo13480iz(7, this.nah);
            if (this.nai != null) {
                c6093a.mo13475e(8, this.nai);
            }
            c6093a.mo13480iz(9, this.naj);
            AppMethodBeat.m2505o(111556);
            return 0;
        } else if (i == 1) {
            if (this.nac != null) {
                f = C6091a.m9575f(1, this.nac) + 0;
            } else {
                f = 0;
            }
            if (this.nad != null) {
                f += C6091a.m9575f(2, this.nad);
            }
            if (this.nae != null) {
                f += C6091a.m9575f(4, this.nae);
            }
            if (this.naf != null) {
                f += C6087a.m9557ix(5, this.naf.computeSize());
            }
            f = (f + C6091a.m9572bs(6, this.nag)) + C6091a.m9572bs(7, this.nah);
            if (this.nai != null) {
                f += C6091a.m9575f(8, this.nai);
            }
            int bs = f + C6091a.m9572bs(9, this.naj);
            AppMethodBeat.m2505o(111556);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.nac == null) {
                c6092b = new C6092b("Not all required fields were included: DownloadURL");
                AppMethodBeat.m2505o(111556);
                throw c6092b;
            }
            AppMethodBeat.m2505o(111556);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C20958q c20958q = (C20958q) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c20958q.nac = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111556);
                    return 0;
                case 2:
                    c20958q.nad = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111556);
                    return 0;
                case 4:
                    c20958q.nae = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111556);
                    return 0;
                case 5:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C43170ds c43170ds = new C43170ds();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c43170ds.populateBuilderWithField(c6086a3, c43170ds, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c20958q.naf = c43170ds;
                    }
                    AppMethodBeat.m2505o(111556);
                    return 0;
                case 6:
                    c20958q.nag = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111556);
                    return 0;
                case 7:
                    c20958q.nah = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111556);
                    return 0;
                case 8:
                    c20958q.nai = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111556);
                    return 0;
                case 9:
                    c20958q.naj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111556);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111556);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111556);
            return -1;
        }
    }
}
