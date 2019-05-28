package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.wz */
public final class C15396wz extends C1331a {
    public String kbW;
    public String title;
    public int wcU;
    public LinkedList<C23446tm> wcV = new LinkedList();

    public C15396wz() {
        AppMethodBeat.m2504i(89063);
        AppMethodBeat.m2505o(89063);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89064);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.title != null) {
                c6093a.mo13475e(1, this.title);
            }
            if (this.kbW != null) {
                c6093a.mo13475e(2, this.kbW);
            }
            c6093a.mo13480iz(3, this.wcU);
            c6093a.mo13474e(4, 8, this.wcV);
            AppMethodBeat.m2505o(89064);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = C6091a.m9575f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.kbW != null) {
                f += C6091a.m9575f(2, this.kbW);
            }
            int bs = (f + C6091a.m9572bs(3, this.wcU)) + C6087a.m9552c(4, 8, this.wcV);
            AppMethodBeat.m2505o(89064);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wcV.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89064);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15396wz c15396wz = (C15396wz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c15396wz.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89064);
                    return 0;
                case 2:
                    c15396wz.kbW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89064);
                    return 0;
                case 3:
                    c15396wz.wcU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89064);
                    return 0;
                case 4:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23446tm c23446tm = new C23446tm();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c23446tm.populateBuilderWithField(c6086a3, c23446tm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c15396wz.wcV.add(c23446tm);
                    }
                    AppMethodBeat.m2505o(89064);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89064);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89064);
            return -1;
        }
    }
}
