package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.xb */
public final class C30241xb extends C1331a {
    public String content;
    public String title;
    public LinkedList<C23461xc> wct = new LinkedList();

    public C30241xb() {
        AppMethodBeat.m2504i(48837);
        AppMethodBeat.m2505o(48837);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48838);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 8, this.wct);
            if (this.content != null) {
                c6093a.mo13475e(2, this.content);
            }
            if (this.title != null) {
                c6093a.mo13475e(3, this.title);
            }
            AppMethodBeat.m2505o(48838);
            return 0;
        } else if (i == 1) {
            c = C6087a.m9552c(1, 8, this.wct) + 0;
            if (this.content != null) {
                c += C6091a.m9575f(2, this.content);
            }
            if (this.title != null) {
                c += C6091a.m9575f(3, this.title);
            }
            AppMethodBeat.m2505o(48838);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wct.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48838);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30241xb c30241xb = (C30241xb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23461xc c23461xc = new C23461xc();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c23461xc.populateBuilderWithField(c6086a3, c23461xc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30241xb.wct.add(c23461xc);
                    }
                    AppMethodBeat.m2505o(48838);
                    return 0;
                case 2:
                    c30241xb.content = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48838);
                    return 0;
                case 3:
                    c30241xb.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48838);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48838);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48838);
            return -1;
        }
    }
}
