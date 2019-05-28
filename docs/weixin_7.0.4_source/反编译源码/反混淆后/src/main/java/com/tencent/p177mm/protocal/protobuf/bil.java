package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bil */
public final class bil extends C1331a {
    public int uin;
    public int version;
    public SKBuiltinBuffer_t wLO;
    public int wLP;
    public SKBuiltinBuffer_t wLQ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51770);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.uin);
            c6093a.mo13480iz(2, this.version);
            if (this.wLO != null) {
                c6093a.mo13479iy(3, this.wLO.computeSize());
                this.wLO.writeFields(c6093a);
            }
            c6093a.mo13480iz(4, this.wLP);
            if (this.wLQ != null) {
                c6093a.mo13479iy(5, this.wLQ.computeSize());
                this.wLQ.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(51770);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.uin) + 0) + C6091a.m9572bs(2, this.version);
            if (this.wLO != null) {
                bs += C6087a.m9557ix(3, this.wLO.computeSize());
            }
            bs += C6091a.m9572bs(4, this.wLP);
            if (this.wLQ != null) {
                bs += C6087a.m9557ix(5, this.wLQ.computeSize());
            }
            AppMethodBeat.m2505o(51770);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(51770);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bil bil = (bil) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    bil.uin = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51770);
                    return 0;
                case 2:
                    bil.version = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51770);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bil.wLO = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(51770);
                    return 0;
                case 4:
                    bil.wLP = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51770);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bil.wLQ = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(51770);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51770);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51770);
            return -1;
        }
    }
}
