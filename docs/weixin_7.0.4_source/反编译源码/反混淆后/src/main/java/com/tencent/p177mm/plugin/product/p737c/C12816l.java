package com.tencent.p177mm.plugin.product.p737c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.product.c.l */
public class C12816l extends C1331a {
    public String phU;
    public int phV;
    public LinkedList<C39488e> phW = new LinkedList();
    public int phq;
    public String url;

    public C12816l() {
        AppMethodBeat.m2504i(56635);
        AppMethodBeat.m2505o(56635);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56636);
        C6092b c6092b;
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.phU == null) {
                c6092b = new C6092b("Not all required fields were included: id_info");
                AppMethodBeat.m2505o(56636);
                throw c6092b;
            }
            if (this.phU != null) {
                c6093a.mo13475e(1, this.phU);
            }
            c6093a.mo13480iz(2, this.phV);
            if (this.url != null) {
                c6093a.mo13475e(3, this.url);
            }
            c6093a.mo13474e(4, 8, this.phW);
            c6093a.mo13480iz(5, this.phq);
            AppMethodBeat.m2505o(56636);
            return 0;
        } else if (i == 1) {
            if (this.phU != null) {
                f = C6091a.m9575f(1, this.phU) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.phV);
            if (this.url != null) {
                f += C6091a.m9575f(3, this.url);
            }
            int c = (f + C6087a.m9552c(4, 8, this.phW)) + C6091a.m9572bs(5, this.phq);
            AppMethodBeat.m2505o(56636);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.phW.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.phU == null) {
                c6092b = new C6092b("Not all required fields were included: id_info");
                AppMethodBeat.m2505o(56636);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56636);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C12816l c12816l = (C12816l) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c12816l.phU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56636);
                    return 0;
                case 2:
                    c12816l.phV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56636);
                    return 0;
                case 3:
                    c12816l.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56636);
                    return 0;
                case 4:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C39488e c39488e = new C39488e();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c39488e.populateBuilderWithField(c6086a3, c39488e, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12816l.phW.add(c39488e);
                    }
                    AppMethodBeat.m2505o(56636);
                    return 0;
                case 5:
                    c12816l.phq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56636);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56636);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56636);
            return -1;
        }
    }
}
