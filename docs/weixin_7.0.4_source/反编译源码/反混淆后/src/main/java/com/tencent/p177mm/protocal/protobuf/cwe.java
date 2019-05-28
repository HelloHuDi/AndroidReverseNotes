package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cwe */
public final class cwe extends C1331a {
    public String wsL;
    public SKBuiltinBuffer_t wsO;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(58942);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wsO == null) {
                c6092b = new C6092b("Not all required fields were included: VerifyBuff");
                AppMethodBeat.m2505o(58942);
                throw c6092b;
            }
            if (this.wsL != null) {
                c6093a.mo13475e(1, this.wsL);
            }
            if (this.wsO != null) {
                c6093a.mo13479iy(2, this.wsO.computeSize());
                this.wsO.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(58942);
            return 0;
        } else if (i == 1) {
            if (this.wsL != null) {
                f = C6091a.m9575f(1, this.wsL) + 0;
            } else {
                f = 0;
            }
            if (this.wsO != null) {
                f += C6087a.m9557ix(2, this.wsO.computeSize());
            }
            AppMethodBeat.m2505o(58942);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.wsO == null) {
                c6092b = new C6092b("Not all required fields were included: VerifyBuff");
                AppMethodBeat.m2505o(58942);
                throw c6092b;
            }
            AppMethodBeat.m2505o(58942);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cwe cwe = (cwe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cwe.wsL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58942);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cwe.wsO = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58942);
                    return 0;
                default:
                    AppMethodBeat.m2505o(58942);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(58942);
            return -1;
        }
    }
}
