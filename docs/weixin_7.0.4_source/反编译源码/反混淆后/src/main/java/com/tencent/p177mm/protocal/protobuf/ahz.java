package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ahz */
public final class ahz extends C1331a {
    public int DesignerUin;
    public int OpCode;
    public int wdI;
    public SKBuiltinBuffer_t wok;
    public String wol;
    public int wom;
    public long won;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(62548);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.OpCode);
            c6093a.mo13480iz(2, this.DesignerUin);
            if (this.wok != null) {
                c6093a.mo13479iy(3, this.wok.computeSize());
                this.wok.writeFields(c6093a);
            }
            c6093a.mo13480iz(4, this.wdI);
            if (this.wol != null) {
                c6093a.mo13475e(5, this.wol);
            }
            c6093a.mo13480iz(6, this.wom);
            c6093a.mo13472ai(7, this.won);
            AppMethodBeat.m2505o(62548);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.OpCode) + 0) + C6091a.m9572bs(2, this.DesignerUin);
            if (this.wok != null) {
                bs += C6087a.m9557ix(3, this.wok.computeSize());
            }
            bs += C6091a.m9572bs(4, this.wdI);
            if (this.wol != null) {
                bs += C6091a.m9575f(5, this.wol);
            }
            bs = (bs + C6091a.m9572bs(6, this.wom)) + C6091a.m9578o(7, this.won);
            AppMethodBeat.m2505o(62548);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(62548);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ahz ahz = (ahz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ahz.OpCode = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62548);
                    return 0;
                case 2:
                    ahz.DesignerUin = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62548);
                    return 0;
                case 3:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ahz.wok = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(62548);
                    return 0;
                case 4:
                    ahz.wdI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62548);
                    return 0;
                case 5:
                    ahz.wol = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62548);
                    return 0;
                case 6:
                    ahz.wom = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62548);
                    return 0;
                case 7:
                    ahz.won = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(62548);
                    return 0;
                default:
                    AppMethodBeat.m2505o(62548);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(62548);
            return -1;
        }
    }
}
