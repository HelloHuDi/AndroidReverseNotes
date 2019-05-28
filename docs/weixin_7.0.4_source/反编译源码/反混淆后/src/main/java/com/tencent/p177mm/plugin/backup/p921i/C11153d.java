package com.tencent.p177mm.plugin.backup.p921i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.backup.i.d */
public final class C11153d extends C1331a {
    /* renamed from: ID */
    public String f2888ID;
    public C45751h jBj;
    public int jBk;
    public int jBl;
    public int jBm;
    public int jBn;
    public int jBo;
    public int jBp;
    public int jBq;
    public int jBr;
    public int jBs;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(18047);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.f2888ID == null) {
                c6092b = new C6092b("Not all required fields were included: ID");
                AppMethodBeat.m2505o(18047);
                throw c6092b;
            }
            if (this.f2888ID != null) {
                c6093a.mo13475e(1, this.f2888ID);
            }
            if (this.jBj != null) {
                c6093a.mo13479iy(2, this.jBj.computeSize());
                this.jBj.writeFields(c6093a);
            }
            c6093a.mo13480iz(3, this.jBk);
            c6093a.mo13480iz(4, this.jBl);
            c6093a.mo13480iz(5, this.jBm);
            c6093a.mo13480iz(6, this.jBn);
            c6093a.mo13480iz(7, this.jBo);
            c6093a.mo13480iz(8, this.jBp);
            c6093a.mo13480iz(9, this.jBq);
            c6093a.mo13480iz(10, this.jBr);
            c6093a.mo13480iz(11, this.jBs);
            AppMethodBeat.m2505o(18047);
            return 0;
        } else if (i == 1) {
            if (this.f2888ID != null) {
                f = C6091a.m9575f(1, this.f2888ID) + 0;
            } else {
                f = 0;
            }
            if (this.jBj != null) {
                f += C6087a.m9557ix(2, this.jBj.computeSize());
            }
            int bs = ((((((((f + C6091a.m9572bs(3, this.jBk)) + C6091a.m9572bs(4, this.jBl)) + C6091a.m9572bs(5, this.jBm)) + C6091a.m9572bs(6, this.jBn)) + C6091a.m9572bs(7, this.jBo)) + C6091a.m9572bs(8, this.jBp)) + C6091a.m9572bs(9, this.jBq)) + C6091a.m9572bs(10, this.jBr)) + C6091a.m9572bs(11, this.jBs);
            AppMethodBeat.m2505o(18047);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.f2888ID == null) {
                c6092b = new C6092b("Not all required fields were included: ID");
                AppMethodBeat.m2505o(18047);
                throw c6092b;
            }
            AppMethodBeat.m2505o(18047);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C11153d c11153d = (C11153d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c11153d.f2888ID = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18047);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C45751h c45751h = new C45751h();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c45751h.populateBuilderWithField(c6086a3, c45751h, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c11153d.jBj = c45751h;
                    }
                    AppMethodBeat.m2505o(18047);
                    return 0;
                case 3:
                    c11153d.jBk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18047);
                    return 0;
                case 4:
                    c11153d.jBl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18047);
                    return 0;
                case 5:
                    c11153d.jBm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18047);
                    return 0;
                case 6:
                    c11153d.jBn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18047);
                    return 0;
                case 7:
                    c11153d.jBo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18047);
                    return 0;
                case 8:
                    c11153d.jBp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18047);
                    return 0;
                case 9:
                    c11153d.jBq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18047);
                    return 0;
                case 10:
                    c11153d.jBr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18047);
                    return 0;
                case 11:
                    c11153d.jBs = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18047);
                    return 0;
                default:
                    AppMethodBeat.m2505o(18047);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(18047);
            return -1;
        }
    }
}
