package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bic */
public final class bic extends C1331a {
    public String Md5;
    public String Name;
    public String PackName;
    public int Version;
    public int jCo;
    public int ndE;
    public SKBuiltinBuffer_t vFG;
    public SKBuiltinBuffer_t wLt;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80153);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.ndE);
            c6093a.mo13480iz(2, this.Version);
            if (this.Name != null) {
                c6093a.mo13475e(3, this.Name);
            }
            c6093a.mo13480iz(4, this.jCo);
            if (this.vFG != null) {
                c6093a.mo13479iy(5, this.vFG.computeSize());
                this.vFG.writeFields(c6093a);
            }
            if (this.PackName != null) {
                c6093a.mo13475e(6, this.PackName);
            }
            if (this.wLt != null) {
                c6093a.mo13479iy(7, this.wLt.computeSize());
                this.wLt.writeFields(c6093a);
            }
            if (this.Md5 != null) {
                c6093a.mo13475e(8, this.Md5);
            }
            AppMethodBeat.m2505o(80153);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.ndE) + 0) + C6091a.m9572bs(2, this.Version);
            if (this.Name != null) {
                bs += C6091a.m9575f(3, this.Name);
            }
            bs += C6091a.m9572bs(4, this.jCo);
            if (this.vFG != null) {
                bs += C6087a.m9557ix(5, this.vFG.computeSize());
            }
            if (this.PackName != null) {
                bs += C6091a.m9575f(6, this.PackName);
            }
            if (this.wLt != null) {
                bs += C6087a.m9557ix(7, this.wLt.computeSize());
            }
            if (this.Md5 != null) {
                bs += C6091a.m9575f(8, this.Md5);
            }
            AppMethodBeat.m2505o(80153);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(80153);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bic bic = (bic) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    bic.ndE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80153);
                    return 0;
                case 2:
                    bic.Version = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80153);
                    return 0;
                case 3:
                    bic.Name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80153);
                    return 0;
                case 4:
                    bic.jCo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80153);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bic.vFG = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(80153);
                    return 0;
                case 6:
                    bic.PackName = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80153);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bic.wLt = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(80153);
                    return 0;
                case 8:
                    bic.Md5 = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80153);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80153);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80153);
            return -1;
        }
    }
}
