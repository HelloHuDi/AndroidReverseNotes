package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bck */
public final class bck extends C1331a {
    public String wGA;
    public bkg wGw;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28555);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wGA == null) {
                c6092b = new C6092b("Not all required fields were included: ContactUsername");
                AppMethodBeat.m2505o(28555);
                throw c6092b;
            } else if (this.wGw == null) {
                c6092b = new C6092b("Not all required fields were included: PhoneNumListInfo");
                AppMethodBeat.m2505o(28555);
                throw c6092b;
            } else {
                if (this.wGA != null) {
                    c6093a.mo13475e(1, this.wGA);
                }
                if (this.wGw != null) {
                    c6093a.mo13479iy(2, this.wGw.computeSize());
                    this.wGw.writeFields(c6093a);
                }
                AppMethodBeat.m2505o(28555);
                return 0;
            }
        } else if (i == 1) {
            if (this.wGA != null) {
                f = C6091a.m9575f(1, this.wGA) + 0;
            } else {
                f = 0;
            }
            if (this.wGw != null) {
                f += C6087a.m9557ix(2, this.wGw.computeSize());
            }
            AppMethodBeat.m2505o(28555);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.wGA == null) {
                c6092b = new C6092b("Not all required fields were included: ContactUsername");
                AppMethodBeat.m2505o(28555);
                throw c6092b;
            } else if (this.wGw == null) {
                c6092b = new C6092b("Not all required fields were included: PhoneNumListInfo");
                AppMethodBeat.m2505o(28555);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(28555);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bck bck = (bck) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bck.wGA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28555);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bkg bkg = new bkg();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bkg.populateBuilderWithField(c6086a3, bkg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bck.wGw = bkg;
                    }
                    AppMethodBeat.m2505o(28555);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28555);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28555);
            return -1;
        }
    }
}
