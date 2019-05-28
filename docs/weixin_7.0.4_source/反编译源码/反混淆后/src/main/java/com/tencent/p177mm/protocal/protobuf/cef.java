package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cef */
public final class cef extends C1331a {
    public long vQE;
    public cer xdJ;
    public String xdK;
    public int xds;
    public LinkedList<Integer> xeb = new LinkedList();

    public cef() {
        AppMethodBeat.m2504i(56519);
        AppMethodBeat.m2505o(56519);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56520);
        int o;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13472ai(1, this.vQE);
            if (this.xdK != null) {
                c6093a.mo13475e(2, this.xdK);
            }
            if (this.xdJ != null) {
                c6093a.mo13479iy(3, this.xdJ.computeSize());
                this.xdJ.writeFields(c6093a);
            }
            c6093a.mo13480iz(4, this.xds);
            c6093a.mo13477f(5, 2, this.xeb);
            AppMethodBeat.m2505o(56520);
            return 0;
        } else if (i == 1) {
            o = C6091a.m9578o(1, this.vQE) + 0;
            if (this.xdK != null) {
                o += C6091a.m9575f(2, this.xdK);
            }
            if (this.xdJ != null) {
                o += C6087a.m9557ix(3, this.xdJ.computeSize());
            }
            o = (o + C6091a.m9572bs(4, this.xds)) + C6087a.m9553d(5, 2, this.xeb);
            AppMethodBeat.m2505o(56520);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xeb.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56520);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cef cef = (cef) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cef.vQE = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56520);
                    return 0;
                case 2:
                    cef.xdK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56520);
                    return 0;
                case 3:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cer cer = new cer();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cer.populateBuilderWithField(c6086a3, cer, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cef.xdJ = cer;
                    }
                    AppMethodBeat.m2505o(56520);
                    return 0;
                case 4:
                    cef.xds = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56520);
                    return 0;
                case 5:
                    cef.xeb = new C6086a(c6086a2.BTU.emu().f1226wR, unknownTagHandler).BTU.emt();
                    AppMethodBeat.m2505o(56520);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56520);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56520);
            return -1;
        }
    }
}
