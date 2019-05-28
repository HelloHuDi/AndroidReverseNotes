package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.afd */
public final class afd extends C1331a {
    public C15319aw vRP;
    public String vWV;
    public LinkedList<String> wmD = new LinkedList();

    public afd() {
        AppMethodBeat.m2504i(56807);
        AppMethodBeat.m2505o(56807);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56808);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 1, this.wmD);
            if (this.vRP != null) {
                c6093a.mo13479iy(2, this.vRP.computeSize());
                this.vRP.writeFields(c6093a);
            }
            if (this.vWV != null) {
                c6093a.mo13475e(3, this.vWV);
            }
            AppMethodBeat.m2505o(56808);
            return 0;
        } else if (i == 1) {
            c = C6087a.m9552c(1, 1, this.wmD) + 0;
            if (this.vRP != null) {
                c += C6087a.m9557ix(2, this.vRP.computeSize());
            }
            if (this.vWV != null) {
                c += C6091a.m9575f(3, this.vWV);
            }
            AppMethodBeat.m2505o(56808);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wmD.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56808);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            afd afd = (afd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    afd.wmD.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(56808);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15319aw c15319aw = new C15319aw();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c15319aw.populateBuilderWithField(c6086a3, c15319aw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        afd.vRP = c15319aw;
                    }
                    AppMethodBeat.m2505o(56808);
                    return 0;
                case 3:
                    afd.vWV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56808);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56808);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56808);
            return -1;
        }
    }
}
