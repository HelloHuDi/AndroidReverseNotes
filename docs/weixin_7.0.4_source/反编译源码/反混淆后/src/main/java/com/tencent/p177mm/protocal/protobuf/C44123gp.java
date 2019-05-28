package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.gp */
public final class C44123gp extends C1331a {
    public LinkedList<C44122go> vIM = new LinkedList();

    public C44123gp() {
        AppMethodBeat.m2504i(28325);
        AppMethodBeat.m2505o(28325);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28326);
        int c;
        byte[] bArr;
        if (i == 0) {
            ((C6093a) objArr[0]).mo13474e(1, 8, this.vIM);
            AppMethodBeat.m2505o(28326);
            return 0;
        } else if (i == 1) {
            c = C6087a.m9552c(1, 8, this.vIM) + 0;
            AppMethodBeat.m2505o(28326);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vIM.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28326);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44123gp c44123gp = (C44123gp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C44122go c44122go = new C44122go();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c44122go.populateBuilderWithField(c6086a3, c44122go, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44123gp.vIM.add(c44122go);
                    }
                    AppMethodBeat.m2505o(28326);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28326);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28326);
            return -1;
        }
    }
}
