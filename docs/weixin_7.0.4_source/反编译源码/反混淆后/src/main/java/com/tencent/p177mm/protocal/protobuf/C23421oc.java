package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.oc */
public final class C23421oc extends C1331a {
    public String vTE;
    public String vTF;
    public String vTG;
    public int vTH;
    public String vTI;
    public C30208ny vTJ;
    public String vTK;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89038);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vTE != null) {
                c6093a.mo13475e(1, this.vTE);
            }
            if (this.vTF != null) {
                c6093a.mo13475e(2, this.vTF);
            }
            if (this.vTG != null) {
                c6093a.mo13475e(3, this.vTG);
            }
            c6093a.mo13480iz(4, this.vTH);
            if (this.vTI != null) {
                c6093a.mo13475e(5, this.vTI);
            }
            if (this.vTJ != null) {
                c6093a.mo13479iy(6, this.vTJ.computeSize());
                this.vTJ.writeFields(c6093a);
            }
            if (this.vTK != null) {
                c6093a.mo13475e(7, this.vTK);
            }
            AppMethodBeat.m2505o(89038);
            return 0;
        } else if (i == 1) {
            if (this.vTE != null) {
                f = C6091a.m9575f(1, this.vTE) + 0;
            } else {
                f = 0;
            }
            if (this.vTF != null) {
                f += C6091a.m9575f(2, this.vTF);
            }
            if (this.vTG != null) {
                f += C6091a.m9575f(3, this.vTG);
            }
            f += C6091a.m9572bs(4, this.vTH);
            if (this.vTI != null) {
                f += C6091a.m9575f(5, this.vTI);
            }
            if (this.vTJ != null) {
                f += C6087a.m9557ix(6, this.vTJ.computeSize());
            }
            if (this.vTK != null) {
                f += C6091a.m9575f(7, this.vTK);
            }
            AppMethodBeat.m2505o(89038);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89038);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23421oc c23421oc = (C23421oc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c23421oc.vTE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89038);
                    return 0;
                case 2:
                    c23421oc.vTF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89038);
                    return 0;
                case 3:
                    c23421oc.vTG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89038);
                    return 0;
                case 4:
                    c23421oc.vTH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89038);
                    return 0;
                case 5:
                    c23421oc.vTI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89038);
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
                        c23421oc.vTJ = c30208ny;
                    }
                    AppMethodBeat.m2505o(89038);
                    return 0;
                case 7:
                    c23421oc.vTK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89038);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89038);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89038);
            return -1;
        }
    }
}
