package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.atr */
public final class atr extends C1331a {
    public int wxH;
    public atu wxI;
    public att wxJ;
    public ats wxK;
    public atq wxL;
    public atv wxM;
    public atw wxN;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28524);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.wxH);
            if (this.wxI != null) {
                c6093a.mo13479iy(2, this.wxI.computeSize());
                this.wxI.writeFields(c6093a);
            }
            if (this.wxJ != null) {
                c6093a.mo13479iy(3, this.wxJ.computeSize());
                this.wxJ.writeFields(c6093a);
            }
            if (this.wxK != null) {
                c6093a.mo13479iy(4, this.wxK.computeSize());
                this.wxK.writeFields(c6093a);
            }
            if (this.wxL != null) {
                c6093a.mo13479iy(5, this.wxL.computeSize());
                this.wxL.writeFields(c6093a);
            }
            if (this.wxM != null) {
                c6093a.mo13479iy(6, this.wxM.computeSize());
                this.wxM.writeFields(c6093a);
            }
            if (this.wxN != null) {
                c6093a.mo13479iy(7, this.wxN.computeSize());
                this.wxN.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(28524);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.wxH) + 0;
            if (this.wxI != null) {
                bs += C6087a.m9557ix(2, this.wxI.computeSize());
            }
            if (this.wxJ != null) {
                bs += C6087a.m9557ix(3, this.wxJ.computeSize());
            }
            if (this.wxK != null) {
                bs += C6087a.m9557ix(4, this.wxK.computeSize());
            }
            if (this.wxL != null) {
                bs += C6087a.m9557ix(5, this.wxL.computeSize());
            }
            if (this.wxM != null) {
                bs += C6087a.m9557ix(6, this.wxM.computeSize());
            }
            if (this.wxN != null) {
                bs += C6087a.m9557ix(7, this.wxN.computeSize());
            }
            AppMethodBeat.m2505o(28524);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28524);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            atr atr = (atr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    atr.wxH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28524);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        atu atu = new atu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = atu.populateBuilderWithField(c6086a3, atu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        atr.wxI = atu;
                    }
                    AppMethodBeat.m2505o(28524);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        att att = new att();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = att.populateBuilderWithField(c6086a3, att, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        atr.wxJ = att;
                    }
                    AppMethodBeat.m2505o(28524);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ats ats = new ats();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ats.populateBuilderWithField(c6086a3, ats, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        atr.wxK = ats;
                    }
                    AppMethodBeat.m2505o(28524);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        atq atq = new atq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = atq.populateBuilderWithField(c6086a3, atq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        atr.wxL = atq;
                    }
                    AppMethodBeat.m2505o(28524);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        atv atv = new atv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = atv.populateBuilderWithField(c6086a3, atv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        atr.wxM = atv;
                    }
                    AppMethodBeat.m2505o(28524);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        atw atw = new atw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = atw.populateBuilderWithField(c6086a3, atw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        atr.wxN = atw;
                    }
                    AppMethodBeat.m2505o(28524);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28524);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28524);
            return -1;
        }
    }
}
