package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.fh */
public final class C30183fh extends C1331a {
    public C40519fi vHg;
    public C46541fj vHm;
    public C1332b vHn;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28320);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vHm == null) {
                c6092b = new C6092b("Not all required fields were included: VoiceAttr");
                AppMethodBeat.m2505o(28320);
                throw c6092b;
            } else if (this.vHg == null) {
                c6092b = new C6092b("Not all required fields were included: UploadCtx");
                AppMethodBeat.m2505o(28320);
                throw c6092b;
            } else if (this.vHn == null) {
                c6092b = new C6092b("Not all required fields were included: VoiceData");
                AppMethodBeat.m2505o(28320);
                throw c6092b;
            } else {
                if (this.vHm != null) {
                    c6093a.mo13479iy(1, this.vHm.computeSize());
                    this.vHm.writeFields(c6093a);
                }
                if (this.vHg != null) {
                    c6093a.mo13479iy(2, this.vHg.computeSize());
                    this.vHg.writeFields(c6093a);
                }
                if (this.vHn != null) {
                    c6093a.mo13473c(3, this.vHn);
                }
                AppMethodBeat.m2505o(28320);
                return 0;
            }
        } else if (i == 1) {
            if (this.vHm != null) {
                ix = C6087a.m9557ix(1, this.vHm.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vHg != null) {
                ix += C6087a.m9557ix(2, this.vHg.computeSize());
            }
            if (this.vHn != null) {
                ix += C6091a.m9571b(3, this.vHn);
            }
            AppMethodBeat.m2505o(28320);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.vHm == null) {
                c6092b = new C6092b("Not all required fields were included: VoiceAttr");
                AppMethodBeat.m2505o(28320);
                throw c6092b;
            } else if (this.vHg == null) {
                c6092b = new C6092b("Not all required fields were included: UploadCtx");
                AppMethodBeat.m2505o(28320);
                throw c6092b;
            } else if (this.vHn == null) {
                c6092b = new C6092b("Not all required fields were included: VoiceData");
                AppMethodBeat.m2505o(28320);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(28320);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30183fh c30183fh = (C30183fh) objArr[1];
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
                        C46541fj c46541fj = new C46541fj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c46541fj.populateBuilderWithField(c6086a3, c46541fj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30183fh.vHm = c46541fj;
                    }
                    AppMethodBeat.m2505o(28320);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40519fi c40519fi = new C40519fi();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40519fi.populateBuilderWithField(c6086a3, c40519fi, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30183fh.vHg = c40519fi;
                    }
                    AppMethodBeat.m2505o(28320);
                    return 0;
                case 3:
                    c30183fh.vHn = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(28320);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28320);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28320);
            return -1;
        }
    }
}
