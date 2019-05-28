package com.tencent.p177mm.plugin.downloader.p723c.p724b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.downloader.c.b.f */
public final class C38845f extends C1331a {
    public C27704b kLn;
    public C45828i kLo;
    public boolean kLp;
    public int kLq;
    public boolean kLr;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(35532);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.kLn != null) {
                c6093a.mo13479iy(1, this.kLn.computeSize());
                this.kLn.writeFields(c6093a);
            }
            if (this.kLo != null) {
                c6093a.mo13479iy(2, this.kLo.computeSize());
                this.kLo.writeFields(c6093a);
            }
            c6093a.mo13471aO(3, this.kLp);
            c6093a.mo13480iz(4, this.kLq);
            c6093a.mo13471aO(5, this.kLr);
            AppMethodBeat.m2505o(35532);
            return 0;
        } else if (i == 1) {
            if (this.kLn != null) {
                ix = C6087a.m9557ix(1, this.kLn.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.kLo != null) {
                ix += C6087a.m9557ix(2, this.kLo.computeSize());
            }
            int fv = ((ix + (C6091a.m9576fv(3) + 1)) + C6091a.m9572bs(4, this.kLq)) + (C6091a.m9576fv(5) + 1);
            AppMethodBeat.m2505o(35532);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(35532);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C38845f c38845f = (C38845f) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C27704b c27704b = new C27704b();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c27704b.populateBuilderWithField(c6086a3, c27704b, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c38845f.kLn = c27704b;
                    }
                    AppMethodBeat.m2505o(35532);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C45828i c45828i = new C45828i();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c45828i.populateBuilderWithField(c6086a3, c45828i, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c38845f.kLo = c45828i;
                    }
                    AppMethodBeat.m2505o(35532);
                    return 0;
                case 3:
                    c38845f.kLp = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(35532);
                    return 0;
                case 4:
                    c38845f.kLq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(35532);
                    return 0;
                case 5:
                    c38845f.kLr = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(35532);
                    return 0;
                default:
                    AppMethodBeat.m2505o(35532);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(35532);
            return -1;
        }
    }
}
