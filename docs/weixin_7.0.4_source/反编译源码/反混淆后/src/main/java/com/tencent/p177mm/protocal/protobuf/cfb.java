package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cfb */
public final class cfb extends C1331a {
    /* renamed from: Id */
    public String f16206Id;
    public String jBB;
    public int pcX;
    public long timeStamp;
    public cea xeA;
    public String xeB;
    public int xeC;
    public int xeD;
    public cei xez;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56547);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.f16206Id != null) {
                c6093a.mo13475e(1, this.f16206Id);
            }
            if (this.jBB != null) {
                c6093a.mo13475e(2, this.jBB);
            }
            c6093a.mo13480iz(3, this.pcX);
            if (this.xez != null) {
                c6093a.mo13479iy(4, this.xez.computeSize());
                this.xez.writeFields(c6093a);
            }
            if (this.xeA != null) {
                c6093a.mo13479iy(5, this.xeA.computeSize());
                this.xeA.writeFields(c6093a);
            }
            c6093a.mo13472ai(6, this.timeStamp);
            if (this.xeB != null) {
                c6093a.mo13475e(7, this.xeB);
            }
            c6093a.mo13480iz(8, this.xeC);
            c6093a.mo13480iz(9, this.xeD);
            AppMethodBeat.m2505o(56547);
            return 0;
        } else if (i == 1) {
            if (this.f16206Id != null) {
                f = C6091a.m9575f(1, this.f16206Id) + 0;
            } else {
                f = 0;
            }
            if (this.jBB != null) {
                f += C6091a.m9575f(2, this.jBB);
            }
            f += C6091a.m9572bs(3, this.pcX);
            if (this.xez != null) {
                f += C6087a.m9557ix(4, this.xez.computeSize());
            }
            if (this.xeA != null) {
                f += C6087a.m9557ix(5, this.xeA.computeSize());
            }
            f += C6091a.m9578o(6, this.timeStamp);
            if (this.xeB != null) {
                f += C6091a.m9575f(7, this.xeB);
            }
            int bs = (f + C6091a.m9572bs(8, this.xeC)) + C6091a.m9572bs(9, this.xeD);
            AppMethodBeat.m2505o(56547);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56547);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cfb cfb = (cfb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    cfb.f16206Id = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56547);
                    return 0;
                case 2:
                    cfb.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56547);
                    return 0;
                case 3:
                    cfb.pcX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56547);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cei cei = new cei();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cei.populateBuilderWithField(c6086a3, cei, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cfb.xez = cei;
                    }
                    AppMethodBeat.m2505o(56547);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cea cea = new cea();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cea.populateBuilderWithField(c6086a3, cea, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cfb.xeA = cea;
                    }
                    AppMethodBeat.m2505o(56547);
                    return 0;
                case 6:
                    cfb.timeStamp = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56547);
                    return 0;
                case 7:
                    cfb.xeB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56547);
                    return 0;
                case 8:
                    cfb.xeC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56547);
                    return 0;
                case 9:
                    cfb.xeD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56547);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56547);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56547);
            return -1;
        }
    }
}
