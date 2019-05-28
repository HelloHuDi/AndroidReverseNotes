package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cnx */
public final class cnx extends C1331a {
    public bif wVz;
    public bam xlt;
    public int xlu;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48987);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wVz != null) {
                c6093a.mo13479iy(1, this.wVz.computeSize());
                this.wVz.writeFields(c6093a);
            }
            if (this.xlt != null) {
                c6093a.mo13479iy(2, this.xlt.computeSize());
                this.xlt.writeFields(c6093a);
            }
            c6093a.mo13480iz(3, this.xlu);
            AppMethodBeat.m2505o(48987);
            return 0;
        } else if (i == 1) {
            if (this.wVz != null) {
                ix = C6087a.m9557ix(1, this.wVz.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xlt != null) {
                ix += C6087a.m9557ix(2, this.xlt.computeSize());
            }
            int bs = ix + C6091a.m9572bs(3, this.xlu);
            AppMethodBeat.m2505o(48987);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48987);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cnx cnx = (cnx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bif bif = new bif();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bif.populateBuilderWithField(c6086a3, bif, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnx.wVz = bif;
                    }
                    AppMethodBeat.m2505o(48987);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bam bam = new bam();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bam.populateBuilderWithField(c6086a3, bam, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnx.xlt = bam;
                    }
                    AppMethodBeat.m2505o(48987);
                    return 0;
                case 3:
                    cnx.xlu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48987);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48987);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48987);
            return -1;
        }
    }
}
