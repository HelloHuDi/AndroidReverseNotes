package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.xy */
public final class C46599xy extends C1331a {
    public String cvZ;
    public String name;
    public cnw wdG;
    public cnw wdH;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(2531);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.cvZ == null) {
                c6092b = new C6092b("Not all required fields were included: md5");
                AppMethodBeat.m2505o(2531);
                throw c6092b;
            } else if (this.wdG == null) {
                c6092b = new C6092b("Not all required fields were included: editorMatrix");
                AppMethodBeat.m2505o(2531);
                throw c6092b;
            } else if (this.wdH == null) {
                c6092b = new C6092b("Not all required fields were included: showMatrix");
                AppMethodBeat.m2505o(2531);
                throw c6092b;
            } else {
                if (this.cvZ != null) {
                    c6093a.mo13475e(1, this.cvZ);
                }
                if (this.name != null) {
                    c6093a.mo13475e(2, this.name);
                }
                if (this.wdG != null) {
                    c6093a.mo13479iy(3, this.wdG.computeSize());
                    this.wdG.writeFields(c6093a);
                }
                if (this.wdH != null) {
                    c6093a.mo13479iy(4, this.wdH.computeSize());
                    this.wdH.writeFields(c6093a);
                }
                AppMethodBeat.m2505o(2531);
                return 0;
            }
        } else if (i == 1) {
            if (this.cvZ != null) {
                f = C6091a.m9575f(1, this.cvZ) + 0;
            } else {
                f = 0;
            }
            if (this.name != null) {
                f += C6091a.m9575f(2, this.name);
            }
            if (this.wdG != null) {
                f += C6087a.m9557ix(3, this.wdG.computeSize());
            }
            if (this.wdH != null) {
                f += C6087a.m9557ix(4, this.wdH.computeSize());
            }
            AppMethodBeat.m2505o(2531);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.cvZ == null) {
                c6092b = new C6092b("Not all required fields were included: md5");
                AppMethodBeat.m2505o(2531);
                throw c6092b;
            } else if (this.wdG == null) {
                c6092b = new C6092b("Not all required fields were included: editorMatrix");
                AppMethodBeat.m2505o(2531);
                throw c6092b;
            } else if (this.wdH == null) {
                c6092b = new C6092b("Not all required fields were included: showMatrix");
                AppMethodBeat.m2505o(2531);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(2531);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46599xy c46599xy = (C46599xy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            cnw cnw;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c46599xy.cvZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(2531);
                    return 0;
                case 2:
                    c46599xy.name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(2531);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cnw = new cnw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cnw.populateBuilderWithField(c6086a3, cnw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46599xy.wdG = cnw;
                    }
                    AppMethodBeat.m2505o(2531);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cnw = new cnw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cnw.populateBuilderWithField(c6086a3, cnw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46599xy.wdH = cnw;
                    }
                    AppMethodBeat.m2505o(2531);
                    return 0;
                default:
                    AppMethodBeat.m2505o(2531);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(2531);
            return -1;
        }
    }
}
