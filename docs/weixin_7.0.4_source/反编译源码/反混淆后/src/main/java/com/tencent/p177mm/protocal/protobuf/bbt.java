package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bbt */
public final class bbt extends C1331a {
    public int jBT;
    public bts vEi;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5598);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vEi == null) {
                c6092b = new C6092b("Not all required fields were included: ChatRoomName");
                AppMethodBeat.m2505o(5598);
                throw c6092b;
            }
            if (this.vEi != null) {
                c6093a.mo13479iy(1, this.vEi.computeSize());
                this.vEi.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.jBT);
            AppMethodBeat.m2505o(5598);
            return 0;
        } else if (i == 1) {
            if (this.vEi != null) {
                ix = C6087a.m9557ix(1, this.vEi.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = ix + C6091a.m9572bs(2, this.jBT);
            AppMethodBeat.m2505o(5598);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.vEi == null) {
                c6092b = new C6092b("Not all required fields were included: ChatRoomName");
                AppMethodBeat.m2505o(5598);
                throw c6092b;
            }
            AppMethodBeat.m2505o(5598);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bbt bbt = (bbt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bbt.vEi = bts;
                    }
                    AppMethodBeat.m2505o(5598);
                    return 0;
                case 2:
                    bbt.jBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5598);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5598);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5598);
            return -1;
        }
    }
}
