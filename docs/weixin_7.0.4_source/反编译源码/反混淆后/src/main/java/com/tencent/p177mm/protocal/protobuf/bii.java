package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bii */
public final class bii extends C1331a {
    public String wLF;
    public String wLG;
    public String wLH;
    public int wLI;
    public String wLJ;
    public C30208ny wLK;
    public String wLL;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89116);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wLF != null) {
                c6093a.mo13475e(1, this.wLF);
            }
            if (this.wLG != null) {
                c6093a.mo13475e(2, this.wLG);
            }
            if (this.wLH != null) {
                c6093a.mo13475e(3, this.wLH);
            }
            c6093a.mo13480iz(4, this.wLI);
            if (this.wLJ != null) {
                c6093a.mo13475e(5, this.wLJ);
            }
            if (this.wLK != null) {
                c6093a.mo13479iy(6, this.wLK.computeSize());
                this.wLK.writeFields(c6093a);
            }
            if (this.wLL != null) {
                c6093a.mo13475e(7, this.wLL);
            }
            AppMethodBeat.m2505o(89116);
            return 0;
        } else if (i == 1) {
            if (this.wLF != null) {
                f = C6091a.m9575f(1, this.wLF) + 0;
            } else {
                f = 0;
            }
            if (this.wLG != null) {
                f += C6091a.m9575f(2, this.wLG);
            }
            if (this.wLH != null) {
                f += C6091a.m9575f(3, this.wLH);
            }
            f += C6091a.m9572bs(4, this.wLI);
            if (this.wLJ != null) {
                f += C6091a.m9575f(5, this.wLJ);
            }
            if (this.wLK != null) {
                f += C6087a.m9557ix(6, this.wLK.computeSize());
            }
            if (this.wLL != null) {
                f += C6091a.m9575f(7, this.wLL);
            }
            AppMethodBeat.m2505o(89116);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89116);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bii bii = (bii) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bii.wLF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89116);
                    return 0;
                case 2:
                    bii.wLG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89116);
                    return 0;
                case 3:
                    bii.wLH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89116);
                    return 0;
                case 4:
                    bii.wLI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89116);
                    return 0;
                case 5:
                    bii.wLJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89116);
                    return 0;
                case 6:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C30208ny c30208ny = new C30208ny();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c30208ny.populateBuilderWithField(c6086a3, c30208ny, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bii.wLK = c30208ny;
                    }
                    AppMethodBeat.m2505o(89116);
                    return 0;
                case 7:
                    bii.wLL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89116);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89116);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89116);
            return -1;
        }
    }
}
