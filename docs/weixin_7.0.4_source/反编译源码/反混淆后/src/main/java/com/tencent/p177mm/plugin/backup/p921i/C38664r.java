package com.tencent.p177mm.plugin.backup.p921i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.backup.i.r */
public final class C38664r extends C1331a {
    /* renamed from: ID */
    public String f16158ID;
    public long jBS;
    public int jBV;
    public int jBW;
    public int jBX;
    public long jBY;
    public long jBZ;
    public LinkedList<C11155t> jCk = new LinkedList();
    public LinkedList<C11155t> jCl = new LinkedList();

    public C38664r() {
        AppMethodBeat.m2504i(18065);
        AppMethodBeat.m2505o(18065);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(18066);
        C6092b c6092b;
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.f16158ID == null) {
                c6092b = new C6092b("Not all required fields were included: ID");
                AppMethodBeat.m2505o(18066);
                throw c6092b;
            }
            if (this.f16158ID != null) {
                c6093a.mo13475e(1, this.f16158ID);
            }
            c6093a.mo13480iz(2, this.jBV);
            c6093a.mo13480iz(3, this.jBW);
            c6093a.mo13480iz(4, this.jBX);
            c6093a.mo13472ai(5, this.jBS);
            c6093a.mo13472ai(6, this.jBY);
            c6093a.mo13472ai(7, this.jBZ);
            c6093a.mo13474e(8, 8, this.jCk);
            c6093a.mo13474e(9, 8, this.jCl);
            AppMethodBeat.m2505o(18066);
            return 0;
        } else if (i == 1) {
            if (this.f16158ID != null) {
                f = C6091a.m9575f(1, this.f16158ID) + 0;
            } else {
                f = 0;
            }
            int bs = (((((((f + C6091a.m9572bs(2, this.jBV)) + C6091a.m9572bs(3, this.jBW)) + C6091a.m9572bs(4, this.jBX)) + C6091a.m9578o(5, this.jBS)) + C6091a.m9578o(6, this.jBY)) + C6091a.m9578o(7, this.jBZ)) + C6087a.m9552c(8, 8, this.jCk)) + C6087a.m9552c(9, 8, this.jCl);
            AppMethodBeat.m2505o(18066);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jCk.clear();
            this.jCl.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.f16158ID == null) {
                c6092b = new C6092b("Not all required fields were included: ID");
                AppMethodBeat.m2505o(18066);
                throw c6092b;
            }
            AppMethodBeat.m2505o(18066);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C38664r c38664r = (C38664r) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C11155t c11155t;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c38664r.f16158ID = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18066);
                    return 0;
                case 2:
                    c38664r.jBV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18066);
                    return 0;
                case 3:
                    c38664r.jBW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18066);
                    return 0;
                case 4:
                    c38664r.jBX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18066);
                    return 0;
                case 5:
                    c38664r.jBS = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(18066);
                    return 0;
                case 6:
                    c38664r.jBY = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(18066);
                    return 0;
                case 7:
                    c38664r.jBZ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(18066);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c11155t = new C11155t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c11155t.populateBuilderWithField(c6086a3, c11155t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c38664r.jCk.add(c11155t);
                    }
                    AppMethodBeat.m2505o(18066);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c11155t = new C11155t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c11155t.populateBuilderWithField(c6086a3, c11155t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c38664r.jCl.add(c11155t);
                    }
                    AppMethodBeat.m2505o(18066);
                    return 0;
                default:
                    AppMethodBeat.m2505o(18066);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(18066);
            return -1;
        }
    }
}
