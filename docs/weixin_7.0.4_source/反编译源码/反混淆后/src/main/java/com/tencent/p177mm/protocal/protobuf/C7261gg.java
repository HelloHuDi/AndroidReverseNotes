package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.gg */
public final class C7261gg extends C1331a {
    public C7262gh vIo;
    public C7540ge vIp;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(58889);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vIo == null) {
                c6092b = new C6092b("Not all required fields were included: RsaReqData");
                AppMethodBeat.m2505o(58889);
                throw c6092b;
            } else if (this.vIp == null) {
                c6092b = new C6092b("Not all required fields were included: AesReqData");
                AppMethodBeat.m2505o(58889);
                throw c6092b;
            } else {
                if (this.vIo != null) {
                    c6093a.mo13479iy(1, this.vIo.computeSize());
                    this.vIo.writeFields(c6093a);
                }
                if (this.vIp != null) {
                    c6093a.mo13479iy(2, this.vIp.computeSize());
                    this.vIp.writeFields(c6093a);
                }
                AppMethodBeat.m2505o(58889);
                return 0;
            }
        } else if (i == 1) {
            if (this.vIo != null) {
                ix = C6087a.m9557ix(1, this.vIo.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vIp != null) {
                ix += C6087a.m9557ix(2, this.vIp.computeSize());
            }
            AppMethodBeat.m2505o(58889);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.vIo == null) {
                c6092b = new C6092b("Not all required fields were included: RsaReqData");
                AppMethodBeat.m2505o(58889);
                throw c6092b;
            } else if (this.vIp == null) {
                c6092b = new C6092b("Not all required fields were included: AesReqData");
                AppMethodBeat.m2505o(58889);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(58889);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7261gg c7261gg = (C7261gg) objArr[1];
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
                        C7262gh c7262gh = new C7262gh();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7262gh.populateBuilderWithField(c6086a3, c7262gh, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7261gg.vIo = c7262gh;
                    }
                    AppMethodBeat.m2505o(58889);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7540ge c7540ge = new C7540ge();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7540ge.populateBuilderWithField(c6086a3, c7540ge, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7261gg.vIp = c7540ge;
                    }
                    AppMethodBeat.m2505o(58889);
                    return 0;
                default:
                    AppMethodBeat.m2505o(58889);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(58889);
            return -1;
        }
    }
}
