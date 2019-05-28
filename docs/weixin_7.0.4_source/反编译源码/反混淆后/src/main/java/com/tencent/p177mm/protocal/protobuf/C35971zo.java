package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.zo */
public final class C35971zo extends C1331a {
    public String weG;
    public String weR;
    public LinkedList<String> weS = new LinkedList();
    public boolean weT;

    public C35971zo() {
        AppMethodBeat.m2504i(28399);
        AppMethodBeat.m2505o(28399);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28400);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.weG == null) {
                c6092b = new C6092b("Not all required fields were included: LoginUrl");
                AppMethodBeat.m2505o(28400);
                throw c6092b;
            }
            if (this.weG != null) {
                c6093a.mo13475e(1, this.weG);
            }
            if (this.weR != null) {
                c6093a.mo13475e(2, this.weR);
            }
            c6093a.mo13474e(3, 1, this.weS);
            c6093a.mo13471aO(4, this.weT);
            AppMethodBeat.m2505o(28400);
            return 0;
        } else if (i == 1) {
            if (this.weG != null) {
                f = C6091a.m9575f(1, this.weG) + 0;
            } else {
                f = 0;
            }
            if (this.weR != null) {
                f += C6091a.m9575f(2, this.weR);
            }
            int c = (f + C6087a.m9552c(3, 1, this.weS)) + (C6091a.m9576fv(4) + 1);
            AppMethodBeat.m2505o(28400);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.weS.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.weG == null) {
                c6092b = new C6092b("Not all required fields were included: LoginUrl");
                AppMethodBeat.m2505o(28400);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28400);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35971zo c35971zo = (C35971zo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c35971zo.weG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28400);
                    return 0;
                case 2:
                    c35971zo.weR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28400);
                    return 0;
                case 3:
                    c35971zo.weS.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(28400);
                    return 0;
                case 4:
                    c35971zo.weT = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(28400);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28400);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28400);
            return -1;
        }
    }
}
