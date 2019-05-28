package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.awg */
public final class awg extends C1331a {
    public String qkh;
    public String scope;
    public int wzW;
    public LinkedList<String> wzX = new LinkedList();

    public awg() {
        AppMethodBeat.m2504i(10212);
        AppMethodBeat.m2505o(10212);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(10213);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.scope != null) {
                c6093a.mo13475e(1, this.scope);
            }
            c6093a.mo13480iz(2, this.wzW);
            if (this.qkh != null) {
                c6093a.mo13475e(3, this.qkh);
            }
            c6093a.mo13474e(4, 1, this.wzX);
            AppMethodBeat.m2505o(10213);
            return 0;
        } else if (i == 1) {
            if (this.scope != null) {
                f = C6091a.m9575f(1, this.scope) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.wzW);
            if (this.qkh != null) {
                f += C6091a.m9575f(3, this.qkh);
            }
            int c = f + C6087a.m9552c(4, 1, this.wzX);
            AppMethodBeat.m2505o(10213);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wzX.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(10213);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            awg awg = (awg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    awg.scope = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10213);
                    return 0;
                case 2:
                    awg.wzW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(10213);
                    return 0;
                case 3:
                    awg.qkh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10213);
                    return 0;
                case 4:
                    awg.wzX.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(10213);
                    return 0;
                default:
                    AppMethodBeat.m2505o(10213);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(10213);
            return -1;
        }
    }
}
