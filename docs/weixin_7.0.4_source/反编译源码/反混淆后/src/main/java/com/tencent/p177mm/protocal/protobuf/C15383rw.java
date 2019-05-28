package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.rw */
public final class C15383rw extends C1331a {
    public int jCt;
    public LinkedList<String> vZh = new LinkedList();
    public String vZi;
    public long vZj;

    public C15383rw() {
        AppMethodBeat.m2504i(14717);
        AppMethodBeat.m2505o(14717);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14718);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.jCt);
            c6093a.mo13474e(2, 1, this.vZh);
            if (this.vZi != null) {
                c6093a.mo13475e(3, this.vZi);
            }
            c6093a.mo13472ai(4, this.vZj);
            AppMethodBeat.m2505o(14718);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.jCt) + 0) + C6087a.m9552c(2, 1, this.vZh);
            if (this.vZi != null) {
                bs += C6091a.m9575f(3, this.vZi);
            }
            bs += C6091a.m9578o(4, this.vZj);
            AppMethodBeat.m2505o(14718);
            return bs;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vZh.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(14718);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15383rw c15383rw = (C15383rw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c15383rw.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14718);
                    return 0;
                case 2:
                    c15383rw.vZh.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(14718);
                    return 0;
                case 3:
                    c15383rw.vZi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14718);
                    return 0;
                case 4:
                    c15383rw.vZj = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(14718);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14718);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14718);
            return -1;
        }
    }
}
