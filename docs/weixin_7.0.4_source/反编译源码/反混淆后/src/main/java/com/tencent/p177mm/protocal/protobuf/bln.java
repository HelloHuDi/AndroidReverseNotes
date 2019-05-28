package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bln */
public final class bln extends C1331a {
    public String vJS;
    public bzy wOA;
    public bzy wOB;
    public boolean wOz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48926);
        int fv;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13471aO(1, this.wOz);
            if (this.wOA != null) {
                c6093a.mo13479iy(2, this.wOA.computeSize());
                this.wOA.writeFields(c6093a);
            }
            if (this.wOB != null) {
                c6093a.mo13479iy(3, this.wOB.computeSize());
                this.wOB.writeFields(c6093a);
            }
            if (this.vJS != null) {
                c6093a.mo13475e(4, this.vJS);
            }
            AppMethodBeat.m2505o(48926);
            return 0;
        } else if (i == 1) {
            fv = (C6091a.m9576fv(1) + 1) + 0;
            if (this.wOA != null) {
                fv += C6087a.m9557ix(2, this.wOA.computeSize());
            }
            if (this.wOB != null) {
                fv += C6087a.m9557ix(3, this.wOB.computeSize());
            }
            if (this.vJS != null) {
                fv += C6091a.m9575f(4, this.vJS);
            }
            AppMethodBeat.m2505o(48926);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (fv = C1331a.getNextFieldNumber(c6086a); fv > 0; fv = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, fv)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48926);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bln bln = (bln) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            bzy bzy;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    bln.wOz = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(48926);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzy = new bzy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzy.populateBuilderWithField(c6086a3, bzy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bln.wOA = bzy;
                    }
                    AppMethodBeat.m2505o(48926);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzy = new bzy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzy.populateBuilderWithField(c6086a3, bzy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bln.wOB = bzy;
                    }
                    AppMethodBeat.m2505o(48926);
                    return 0;
                case 4:
                    bln.vJS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48926);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48926);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48926);
            return -1;
        }
    }
}
