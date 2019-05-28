package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.io */
public final class C35925io extends C1331a {
    public LinkedList<C40529in> vKG = new LinkedList();
    public C46552im vKH;
    public int vKI;

    public C35925io() {
        AppMethodBeat.m2504i(10155);
        AppMethodBeat.m2505o(10155);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(10156);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 8, this.vKG);
            if (this.vKH != null) {
                c6093a.mo13479iy(2, this.vKH.computeSize());
                this.vKH.writeFields(c6093a);
            }
            c6093a.mo13480iz(3, this.vKI);
            AppMethodBeat.m2505o(10156);
            return 0;
        } else if (i == 1) {
            c = C6087a.m9552c(1, 8, this.vKG) + 0;
            if (this.vKH != null) {
                c += C6087a.m9557ix(2, this.vKH.computeSize());
            }
            c += C6091a.m9572bs(3, this.vKI);
            AppMethodBeat.m2505o(10156);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vKG.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(10156);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35925io c35925io = (C35925io) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40529in c40529in = new C40529in();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40529in.populateBuilderWithField(c6086a3, c40529in, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35925io.vKG.add(c40529in);
                    }
                    AppMethodBeat.m2505o(10156);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46552im c46552im = new C46552im();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c46552im.populateBuilderWithField(c6086a3, c46552im, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35925io.vKH = c46552im;
                    }
                    AppMethodBeat.m2505o(10156);
                    return 0;
                case 3:
                    c35925io.vKI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(10156);
                    return 0;
                default:
                    AppMethodBeat.m2505o(10156);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(10156);
            return -1;
        }
    }
}
