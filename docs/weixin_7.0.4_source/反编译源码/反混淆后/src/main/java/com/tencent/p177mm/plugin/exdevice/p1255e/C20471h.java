package com.tencent.p177mm.plugin.exdevice.p1255e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.exdevice.e.h */
public final class C20471h extends C1331a {
    public C1332b jBi;
    public int jCt;
    public C42985c lvi;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(19425);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.lvi == null) {
                c6092b = new C6092b("Not all required fields were included: BasePush");
                AppMethodBeat.m2505o(19425);
                throw c6092b;
            } else if (this.jBi == null) {
                c6092b = new C6092b("Not all required fields were included: Data");
                AppMethodBeat.m2505o(19425);
                throw c6092b;
            } else {
                if (this.lvi != null) {
                    c6093a.mo13479iy(1, this.lvi.computeSize());
                    this.lvi.writeFields(c6093a);
                }
                if (this.jBi != null) {
                    c6093a.mo13473c(2, this.jBi);
                }
                c6093a.mo13480iz(3, this.jCt);
                AppMethodBeat.m2505o(19425);
                return 0;
            }
        } else if (i == 1) {
            if (this.lvi != null) {
                ix = C6087a.m9557ix(1, this.lvi.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.jBi != null) {
                ix += C6091a.m9571b(2, this.jBi);
            }
            int bs = ix + C6091a.m9572bs(3, this.jCt);
            AppMethodBeat.m2505o(19425);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.lvi == null) {
                c6092b = new C6092b("Not all required fields were included: BasePush");
                AppMethodBeat.m2505o(19425);
                throw c6092b;
            } else if (this.jBi == null) {
                c6092b = new C6092b("Not all required fields were included: Data");
                AppMethodBeat.m2505o(19425);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(19425);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C20471h c20471h = (C20471h) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C42985c c42985c = new C42985c();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c42985c.populateBuilderWithField(c6086a3, c42985c, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c20471h.lvi = c42985c;
                    }
                    AppMethodBeat.m2505o(19425);
                    return 0;
                case 2:
                    c20471h.jBi = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(19425);
                    return 0;
                case 3:
                    c20471h.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(19425);
                    return 0;
                default:
                    AppMethodBeat.m2505o(19425);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(19425);
            return -1;
        }
    }
}
