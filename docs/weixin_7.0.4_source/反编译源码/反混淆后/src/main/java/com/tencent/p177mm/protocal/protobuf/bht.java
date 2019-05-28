package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bht */
public final class bht extends C1331a {
    public String vJS;
    public bln wKU;
    public LinkedList<bzy> wKV = new LinkedList();

    public bht() {
        AppMethodBeat.m2504i(48913);
        AppMethodBeat.m2505o(48913);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48914);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wKU != null) {
                c6093a.mo13479iy(1, this.wKU.computeSize());
                this.wKU.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 8, this.wKV);
            if (this.vJS != null) {
                c6093a.mo13475e(3, this.vJS);
            }
            AppMethodBeat.m2505o(48914);
            return 0;
        } else if (i == 1) {
            if (this.wKU != null) {
                ix = C6087a.m9557ix(1, this.wKU.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6087a.m9552c(2, 8, this.wKV);
            if (this.vJS != null) {
                ix += C6091a.m9575f(3, this.vJS);
            }
            AppMethodBeat.m2505o(48914);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wKV.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48914);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bht bht = (bht) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bln bln = new bln();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bln.populateBuilderWithField(c6086a3, bln, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bht.wKU = bln;
                    }
                    AppMethodBeat.m2505o(48914);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzy bzy = new bzy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzy.populateBuilderWithField(c6086a3, bzy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bht.wKV.add(bzy);
                    }
                    AppMethodBeat.m2505o(48914);
                    return 0;
                case 3:
                    bht.vJS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48914);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48914);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48914);
            return -1;
        }
    }
}
