package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cdb */
public final class cdb extends C1331a {
    public int scene;
    public cda xcI;
    public cda xcJ;
    public cda xcK;
    public int xcL;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96295);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xcI != null) {
                c6093a.mo13479iy(1, this.xcI.computeSize());
                this.xcI.writeFields(c6093a);
            }
            if (this.xcJ != null) {
                c6093a.mo13479iy(2, this.xcJ.computeSize());
                this.xcJ.writeFields(c6093a);
            }
            if (this.xcK != null) {
                c6093a.mo13479iy(3, this.xcK.computeSize());
                this.xcK.writeFields(c6093a);
            }
            c6093a.mo13480iz(4, this.scene);
            c6093a.mo13480iz(5, this.xcL);
            AppMethodBeat.m2505o(96295);
            return 0;
        } else if (i == 1) {
            if (this.xcI != null) {
                ix = C6087a.m9557ix(1, this.xcI.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xcJ != null) {
                ix += C6087a.m9557ix(2, this.xcJ.computeSize());
            }
            if (this.xcK != null) {
                ix += C6087a.m9557ix(3, this.xcK.computeSize());
            }
            int bs = (ix + C6091a.m9572bs(4, this.scene)) + C6091a.m9572bs(5, this.xcL);
            AppMethodBeat.m2505o(96295);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(96295);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cdb cdb = (cdb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            cda cda;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cda = new cda();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cda.populateBuilderWithField(c6086a3, cda, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cdb.xcI = cda;
                    }
                    AppMethodBeat.m2505o(96295);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cda = new cda();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cda.populateBuilderWithField(c6086a3, cda, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cdb.xcJ = cda;
                    }
                    AppMethodBeat.m2505o(96295);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cda = new cda();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cda.populateBuilderWithField(c6086a3, cda, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cdb.xcK = cda;
                    }
                    AppMethodBeat.m2505o(96295);
                    return 0;
                case 4:
                    cdb.scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96295);
                    return 0;
                case 5:
                    cdb.xcL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96295);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96295);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96295);
            return -1;
        }
    }
}
