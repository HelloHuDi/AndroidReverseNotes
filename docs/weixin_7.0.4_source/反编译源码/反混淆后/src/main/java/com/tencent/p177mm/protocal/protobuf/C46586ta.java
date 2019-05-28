package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ta */
public final class C46586ta extends C1331a {
    public int waq;
    public C1332b war;
    public bkd was;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48824);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.waq);
            if (this.war != null) {
                c6093a.mo13473c(2, this.war);
            }
            if (this.was != null) {
                c6093a.mo13479iy(3, this.was.computeSize());
                this.was.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(48824);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.waq) + 0;
            if (this.war != null) {
                bs += C6091a.m9571b(2, this.war);
            }
            if (this.was != null) {
                bs += C6087a.m9557ix(3, this.was.computeSize());
            }
            AppMethodBeat.m2505o(48824);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48824);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46586ta c46586ta = (C46586ta) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c46586ta.waq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48824);
                    return 0;
                case 2:
                    c46586ta.war = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(48824);
                    return 0;
                case 3:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bkd bkd = new bkd();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bkd.populateBuilderWithField(c6086a3, bkd, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46586ta.was = bkd;
                    }
                    AppMethodBeat.m2505o(48824);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48824);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48824);
            return -1;
        }
    }
}
