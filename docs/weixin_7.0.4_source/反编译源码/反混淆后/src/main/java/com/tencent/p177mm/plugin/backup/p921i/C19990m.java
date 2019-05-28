package com.tencent.p177mm.plugin.backup.p921i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.backup.i.m */
public final class C19990m extends C1331a {
    public String jBE;
    public String jBF;
    public String jBG;
    public String jBH;
    public String jBI;
    public int jBJ;
    public long jBK;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(18060);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.jBE == null) {
                c6092b = new C6092b("Not all required fields were included: DeviceID");
                AppMethodBeat.m2505o(18060);
                throw c6092b;
            } else if (this.jBF == null) {
                c6092b = new C6092b("Not all required fields were included: DeviceName");
                AppMethodBeat.m2505o(18060);
                throw c6092b;
            } else if (this.jBG == null) {
                c6092b = new C6092b("Not all required fields were included: Model");
                AppMethodBeat.m2505o(18060);
                throw c6092b;
            } else if (this.jBH == null) {
                c6092b = new C6092b("Not all required fields were included: SystemName");
                AppMethodBeat.m2505o(18060);
                throw c6092b;
            } else if (this.jBI == null) {
                c6092b = new C6092b("Not all required fields were included: SystemVersion");
                AppMethodBeat.m2505o(18060);
                throw c6092b;
            } else {
                if (this.jBE != null) {
                    c6093a.mo13475e(1, this.jBE);
                }
                if (this.jBF != null) {
                    c6093a.mo13475e(2, this.jBF);
                }
                if (this.jBG != null) {
                    c6093a.mo13475e(3, this.jBG);
                }
                if (this.jBH != null) {
                    c6093a.mo13475e(4, this.jBH);
                }
                if (this.jBI != null) {
                    c6093a.mo13475e(5, this.jBI);
                }
                c6093a.mo13480iz(6, this.jBJ);
                c6093a.mo13472ai(7, this.jBK);
                AppMethodBeat.m2505o(18060);
                return 0;
            }
        } else if (i == 1) {
            if (this.jBE != null) {
                f = C6091a.m9575f(1, this.jBE) + 0;
            } else {
                f = 0;
            }
            if (this.jBF != null) {
                f += C6091a.m9575f(2, this.jBF);
            }
            if (this.jBG != null) {
                f += C6091a.m9575f(3, this.jBG);
            }
            if (this.jBH != null) {
                f += C6091a.m9575f(4, this.jBH);
            }
            if (this.jBI != null) {
                f += C6091a.m9575f(5, this.jBI);
            }
            int bs = (f + C6091a.m9572bs(6, this.jBJ)) + C6091a.m9578o(7, this.jBK);
            AppMethodBeat.m2505o(18060);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.jBE == null) {
                c6092b = new C6092b("Not all required fields were included: DeviceID");
                AppMethodBeat.m2505o(18060);
                throw c6092b;
            } else if (this.jBF == null) {
                c6092b = new C6092b("Not all required fields were included: DeviceName");
                AppMethodBeat.m2505o(18060);
                throw c6092b;
            } else if (this.jBG == null) {
                c6092b = new C6092b("Not all required fields were included: Model");
                AppMethodBeat.m2505o(18060);
                throw c6092b;
            } else if (this.jBH == null) {
                c6092b = new C6092b("Not all required fields were included: SystemName");
                AppMethodBeat.m2505o(18060);
                throw c6092b;
            } else if (this.jBI == null) {
                c6092b = new C6092b("Not all required fields were included: SystemVersion");
                AppMethodBeat.m2505o(18060);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(18060);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C19990m c19990m = (C19990m) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c19990m.jBE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18060);
                    return 0;
                case 2:
                    c19990m.jBF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18060);
                    return 0;
                case 3:
                    c19990m.jBG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18060);
                    return 0;
                case 4:
                    c19990m.jBH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18060);
                    return 0;
                case 5:
                    c19990m.jBI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18060);
                    return 0;
                case 6:
                    c19990m.jBJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18060);
                    return 0;
                case 7:
                    c19990m.jBK = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(18060);
                    return 0;
                default:
                    AppMethodBeat.m2505o(18060);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(18060);
            return -1;
        }
    }
}
