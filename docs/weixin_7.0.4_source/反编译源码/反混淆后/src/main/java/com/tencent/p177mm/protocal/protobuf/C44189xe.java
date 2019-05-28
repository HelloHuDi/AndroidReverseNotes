package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.xe */
public final class C44189xe extends C1331a {
    public int wcX;
    public C44190xf wcY;
    public int wcZ;
    public C44190xf wda;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(60034);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wcY == null) {
                c6092b = new C6092b("Not all required fields were included: NightTime");
                AppMethodBeat.m2505o(60034);
                throw c6092b;
            } else if (this.wda == null) {
                c6092b = new C6092b("Not all required fields were included: AllDayTime");
                AppMethodBeat.m2505o(60034);
                throw c6092b;
            } else {
                c6093a.mo13480iz(1, this.wcX);
                if (this.wcY != null) {
                    c6093a.mo13479iy(2, this.wcY.computeSize());
                    this.wcY.writeFields(c6093a);
                }
                c6093a.mo13480iz(3, this.wcZ);
                if (this.wda != null) {
                    c6093a.mo13479iy(4, this.wda.computeSize());
                    this.wda.writeFields(c6093a);
                }
                AppMethodBeat.m2505o(60034);
                return 0;
            }
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.wcX) + 0;
            if (this.wcY != null) {
                bs += C6087a.m9557ix(2, this.wcY.computeSize());
            }
            bs += C6091a.m9572bs(3, this.wcZ);
            if (this.wda != null) {
                bs += C6087a.m9557ix(4, this.wda.computeSize());
            }
            AppMethodBeat.m2505o(60034);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.wcY == null) {
                c6092b = new C6092b("Not all required fields were included: NightTime");
                AppMethodBeat.m2505o(60034);
                throw c6092b;
            } else if (this.wda == null) {
                c6092b = new C6092b("Not all required fields were included: AllDayTime");
                AppMethodBeat.m2505o(60034);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(60034);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44189xe c44189xe = (C44189xe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C44190xf c44190xf;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c44189xe.wcX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60034);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c44190xf = new C44190xf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44190xf.populateBuilderWithField(c6086a3, c44190xf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44189xe.wcY = c44190xf;
                    }
                    AppMethodBeat.m2505o(60034);
                    return 0;
                case 3:
                    c44189xe.wcZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60034);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c44190xf = new C44190xf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44190xf.populateBuilderWithField(c6086a3, c44190xf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44189xe.wda = c44190xf;
                    }
                    AppMethodBeat.m2505o(60034);
                    return 0;
                default:
                    AppMethodBeat.m2505o(60034);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(60034);
            return -1;
        }
    }
}
