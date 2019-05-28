package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cbi */
public final class cbi extends C1331a {
    public int nbk;
    public long vQE;
    public SKBuiltinBuffer_t wLt;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94585);
        int o;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13472ai(1, this.vQE);
            c6093a.mo13480iz(2, this.nbk);
            if (this.wLt != null) {
                c6093a.mo13479iy(3, this.wLt.computeSize());
                this.wLt.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(94585);
            return 0;
        } else if (i == 1) {
            o = (C6091a.m9578o(1, this.vQE) + 0) + C6091a.m9572bs(2, this.nbk);
            if (this.wLt != null) {
                o += C6087a.m9557ix(3, this.wLt.computeSize());
            }
            AppMethodBeat.m2505o(94585);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94585);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cbi cbi = (cbi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cbi.vQE = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94585);
                    return 0;
                case 2:
                    cbi.nbk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94585);
                    return 0;
                case 3:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbi.wLt = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(94585);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94585);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94585);
            return -1;
        }
    }
}
