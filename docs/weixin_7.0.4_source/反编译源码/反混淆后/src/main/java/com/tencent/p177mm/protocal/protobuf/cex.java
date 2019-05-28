package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cex */
public final class cex extends C1331a {
    public int jCt;
    public long vQE;
    public cey xex;
    public cey xey;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56543);
        C6092b c6092b;
        int o;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xex == null) {
                c6092b = new C6092b("Not all required fields were included: SyncMsgDetail");
                AppMethodBeat.m2505o(56543);
                throw c6092b;
            }
            c6093a.mo13472ai(1, this.vQE);
            c6093a.mo13480iz(2, this.jCt);
            if (this.xex != null) {
                c6093a.mo13479iy(3, this.xex.computeSize());
                this.xex.writeFields(c6093a);
            }
            if (this.xey != null) {
                c6093a.mo13479iy(4, this.xey.computeSize());
                this.xey.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(56543);
            return 0;
        } else if (i == 1) {
            o = (C6091a.m9578o(1, this.vQE) + 0) + C6091a.m9572bs(2, this.jCt);
            if (this.xex != null) {
                o += C6087a.m9557ix(3, this.xex.computeSize());
            }
            if (this.xey != null) {
                o += C6087a.m9557ix(4, this.xey.computeSize());
            }
            AppMethodBeat.m2505o(56543);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            if (this.xex == null) {
                c6092b = new C6092b("Not all required fields were included: SyncMsgDetail");
                AppMethodBeat.m2505o(56543);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56543);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cex cex = (cex) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            cey cey;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    cex.vQE = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56543);
                    return 0;
                case 2:
                    cex.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56543);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cey = new cey();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cey.populateBuilderWithField(c6086a3, cey, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cex.xex = cey;
                    }
                    AppMethodBeat.m2505o(56543);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cey = new cey();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cey.populateBuilderWithField(c6086a3, cey, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cex.xey = cey;
                    }
                    AppMethodBeat.m2505o(56543);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56543);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56543);
            return -1;
        }
    }
}
