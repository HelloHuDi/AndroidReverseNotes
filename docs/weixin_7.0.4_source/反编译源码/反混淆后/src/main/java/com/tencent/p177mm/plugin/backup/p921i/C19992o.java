package com.tencent.p177mm.plugin.backup.p921i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.backup.i.o */
public final class C19992o extends C1331a {
    /* renamed from: ID */
    public String f4367ID;
    public long jBL;
    public C19990m jBO;
    public int jBQ;
    public long jBR;
    public long jBS;
    public int jBT;
    public int jBU;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(18062);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.f4367ID == null) {
                c6092b = new C6092b("Not all required fields were included: ID");
                AppMethodBeat.m2505o(18062);
                throw c6092b;
            }
            if (this.f4367ID != null) {
                c6093a.mo13475e(1, this.f4367ID);
            }
            c6093a.mo13472ai(2, this.jBR);
            c6093a.mo13472ai(3, this.jBS);
            c6093a.mo13480iz(4, this.jBT);
            c6093a.mo13480iz(5, this.jBU);
            c6093a.mo13472ai(6, this.jBL);
            if (this.jBO != null) {
                c6093a.mo13479iy(7, this.jBO.computeSize());
                this.jBO.writeFields(c6093a);
            }
            c6093a.mo13480iz(8, this.jBQ);
            AppMethodBeat.m2505o(18062);
            return 0;
        } else if (i == 1) {
            if (this.f4367ID != null) {
                f = C6091a.m9575f(1, this.f4367ID) + 0;
            } else {
                f = 0;
            }
            f = ((((f + C6091a.m9578o(2, this.jBR)) + C6091a.m9578o(3, this.jBS)) + C6091a.m9572bs(4, this.jBT)) + C6091a.m9572bs(5, this.jBU)) + C6091a.m9578o(6, this.jBL);
            if (this.jBO != null) {
                f += C6087a.m9557ix(7, this.jBO.computeSize());
            }
            int bs = f + C6091a.m9572bs(8, this.jBQ);
            AppMethodBeat.m2505o(18062);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.f4367ID == null) {
                c6092b = new C6092b("Not all required fields were included: ID");
                AppMethodBeat.m2505o(18062);
                throw c6092b;
            }
            AppMethodBeat.m2505o(18062);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C19992o c19992o = (C19992o) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c19992o.f4367ID = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18062);
                    return 0;
                case 2:
                    c19992o.jBR = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(18062);
                    return 0;
                case 3:
                    c19992o.jBS = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(18062);
                    return 0;
                case 4:
                    c19992o.jBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18062);
                    return 0;
                case 5:
                    c19992o.jBU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18062);
                    return 0;
                case 6:
                    c19992o.jBL = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(18062);
                    return 0;
                case 7:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C19990m c19990m = new C19990m();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c19990m.populateBuilderWithField(c6086a3, c19990m, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c19992o.jBO = c19990m;
                    }
                    AppMethodBeat.m2505o(18062);
                    return 0;
                case 8:
                    c19992o.jBQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18062);
                    return 0;
                default:
                    AppMethodBeat.m2505o(18062);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(18062);
            return -1;
        }
    }
}
