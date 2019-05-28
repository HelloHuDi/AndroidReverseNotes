package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.nn */
public final class C35937nn extends C1331a {
    public String name;
    public LinkedList<C40578ul> vRR = new LinkedList();
    public int vRS;
    public String vRT;
    public String vzX;

    public C35937nn() {
        AppMethodBeat.m2504i(28351);
        AppMethodBeat.m2505o(28351);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28352);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 8, this.vRR);
            if (this.vzX != null) {
                c6093a.mo13475e(2, this.vzX);
            }
            c6093a.mo13480iz(3, this.vRS);
            if (this.vRT != null) {
                c6093a.mo13475e(4, this.vRT);
            }
            if (this.name != null) {
                c6093a.mo13475e(5, this.name);
            }
            AppMethodBeat.m2505o(28352);
            return 0;
        } else if (i == 1) {
            c = C6087a.m9552c(1, 8, this.vRR) + 0;
            if (this.vzX != null) {
                c += C6091a.m9575f(2, this.vzX);
            }
            c += C6091a.m9572bs(3, this.vRS);
            if (this.vRT != null) {
                c += C6091a.m9575f(4, this.vRT);
            }
            if (this.name != null) {
                c += C6091a.m9575f(5, this.name);
            }
            AppMethodBeat.m2505o(28352);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vRR.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28352);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35937nn c35937nn = (C35937nn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40578ul c40578ul = new C40578ul();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c40578ul.populateBuilderWithField(c6086a3, c40578ul, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35937nn.vRR.add(c40578ul);
                    }
                    AppMethodBeat.m2505o(28352);
                    return 0;
                case 2:
                    c35937nn.vzX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28352);
                    return 0;
                case 3:
                    c35937nn.vRS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28352);
                    return 0;
                case 4:
                    c35937nn.vRT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28352);
                    return 0;
                case 5:
                    c35937nn.name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28352);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28352);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28352);
            return -1;
        }
    }
}
