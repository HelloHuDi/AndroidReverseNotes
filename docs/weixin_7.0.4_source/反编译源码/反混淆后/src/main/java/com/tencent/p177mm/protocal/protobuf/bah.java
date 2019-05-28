package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bah */
public final class bah extends C1331a {
    public String jBB;
    public C7287xu vIr;
    public String vLJ;
    public String vLW;
    public SKBuiltinBuffer_t vLz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(58914);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vLz == null) {
                c6092b = new C6092b("Not all required fields were included: RandomEncryKey");
                AppMethodBeat.m2505o(58914);
                throw c6092b;
            } else if (this.vIr == null) {
                c6092b = new C6092b("Not all required fields were included: CliPubECDHKey");
                AppMethodBeat.m2505o(58914);
                throw c6092b;
            } else {
                if (this.vLz != null) {
                    c6093a.mo13479iy(1, this.vLz.computeSize());
                    this.vLz.writeFields(c6093a);
                }
                if (this.vIr != null) {
                    c6093a.mo13479iy(2, this.vIr.computeSize());
                    this.vIr.writeFields(c6093a);
                }
                if (this.jBB != null) {
                    c6093a.mo13475e(3, this.jBB);
                }
                if (this.vLJ != null) {
                    c6093a.mo13475e(4, this.vLJ);
                }
                if (this.vLW != null) {
                    c6093a.mo13475e(5, this.vLW);
                }
                AppMethodBeat.m2505o(58914);
                return 0;
            }
        } else if (i == 1) {
            if (this.vLz != null) {
                ix = C6087a.m9557ix(1, this.vLz.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vIr != null) {
                ix += C6087a.m9557ix(2, this.vIr.computeSize());
            }
            if (this.jBB != null) {
                ix += C6091a.m9575f(3, this.jBB);
            }
            if (this.vLJ != null) {
                ix += C6091a.m9575f(4, this.vLJ);
            }
            if (this.vLW != null) {
                ix += C6091a.m9575f(5, this.vLW);
            }
            AppMethodBeat.m2505o(58914);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.vLz == null) {
                c6092b = new C6092b("Not all required fields were included: RandomEncryKey");
                AppMethodBeat.m2505o(58914);
                throw c6092b;
            } else if (this.vIr == null) {
                c6092b = new C6092b("Not all required fields were included: CliPubECDHKey");
                AppMethodBeat.m2505o(58914);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(58914);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bah bah = (bah) objArr[1];
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
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bah.vLz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58914);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7287xu c7287xu = new C7287xu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7287xu.populateBuilderWithField(c6086a3, c7287xu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bah.vIr = c7287xu;
                    }
                    AppMethodBeat.m2505o(58914);
                    return 0;
                case 3:
                    bah.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58914);
                    return 0;
                case 4:
                    bah.vLJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58914);
                    return 0;
                case 5:
                    bah.vLW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58914);
                    return 0;
                default:
                    AppMethodBeat.m2505o(58914);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(58914);
            return -1;
        }
    }
}
