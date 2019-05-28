package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.yk */
public final class C40591yk extends C1331a {
    public C30246yl wej;
    public C46601yj wek;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80051);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wej == null) {
                c6092b = new C6092b("Not all required fields were included: RsaReqData");
                AppMethodBeat.m2505o(80051);
                throw c6092b;
            } else if (this.wek == null) {
                c6092b = new C6092b("Not all required fields were included: AesReqData");
                AppMethodBeat.m2505o(80051);
                throw c6092b;
            } else {
                if (this.wej != null) {
                    c6093a.mo13479iy(1, this.wej.computeSize());
                    this.wej.writeFields(c6093a);
                }
                if (this.wek != null) {
                    c6093a.mo13479iy(2, this.wek.computeSize());
                    this.wek.writeFields(c6093a);
                }
                AppMethodBeat.m2505o(80051);
                return 0;
            }
        } else if (i == 1) {
            if (this.wej != null) {
                ix = C6087a.m9557ix(1, this.wej.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wek != null) {
                ix += C6087a.m9557ix(2, this.wek.computeSize());
            }
            AppMethodBeat.m2505o(80051);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.wej == null) {
                c6092b = new C6092b("Not all required fields were included: RsaReqData");
                AppMethodBeat.m2505o(80051);
                throw c6092b;
            } else if (this.wek == null) {
                c6092b = new C6092b("Not all required fields were included: AesReqData");
                AppMethodBeat.m2505o(80051);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(80051);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40591yk c40591yk = (C40591yk) objArr[1];
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
                        C30246yl c30246yl = new C30246yl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c30246yl.populateBuilderWithField(c6086a3, c30246yl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40591yk.wej = c30246yl;
                    }
                    AppMethodBeat.m2505o(80051);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46601yj c46601yj = new C46601yj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c46601yj.populateBuilderWithField(c6086a3, c46601yj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40591yk.wek = c46601yj;
                    }
                    AppMethodBeat.m2505o(80051);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80051);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80051);
            return -1;
        }
    }
}
