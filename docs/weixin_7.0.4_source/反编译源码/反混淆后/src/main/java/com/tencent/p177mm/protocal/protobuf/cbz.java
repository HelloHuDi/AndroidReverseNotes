package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cbz */
public final class cbz extends C1331a {
    public int jBv;
    public LinkedList<bts> jBw = new LinkedList();
    public String ncF;
    public long xbt;

    public cbz() {
        AppMethodBeat.m2504i(94606);
        AppMethodBeat.m2505o(94606);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94607);
        int o;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13472ai(1, this.xbt);
            if (this.ncF != null) {
                c6093a.mo13475e(2, this.ncF);
            }
            c6093a.mo13480iz(3, this.jBv);
            c6093a.mo13474e(4, 8, this.jBw);
            AppMethodBeat.m2505o(94607);
            return 0;
        } else if (i == 1) {
            o = C6091a.m9578o(1, this.xbt) + 0;
            if (this.ncF != null) {
                o += C6091a.m9575f(2, this.ncF);
            }
            o = (o + C6091a.m9572bs(3, this.jBv)) + C6087a.m9552c(4, 8, this.jBw);
            AppMethodBeat.m2505o(94607);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jBw.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94607);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cbz cbz = (cbz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cbz.xbt = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94607);
                    return 0;
                case 2:
                    cbz.ncF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94607);
                    return 0;
                case 3:
                    cbz.jBv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94607);
                    return 0;
                case 4:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbz.jBw.add(bts);
                    }
                    AppMethodBeat.m2505o(94607);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94607);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94607);
            return -1;
        }
    }
}
