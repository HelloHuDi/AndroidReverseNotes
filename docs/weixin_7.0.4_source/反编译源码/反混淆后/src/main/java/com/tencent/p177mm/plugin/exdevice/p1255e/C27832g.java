package com.tencent.p177mm.plugin.exdevice.p1255e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.exdevice.e.g */
public final class C27832g extends C42987j {
    public String jBG;
    public int luX;
    public int luY;
    public int luZ;
    public int lva;
    public int lvb;
    public String lvc;
    public int lvd;
    public String lve;
    public int lvf;
    public int lvg;
    public String lvh;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(19424);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.lvk == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(19424);
                throw c6092b;
            }
            if (this.lvk != null) {
                c6093a.mo13479iy(1, this.lvk.computeSize());
                this.lvk.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.luX);
            c6093a.mo13480iz(3, this.luY);
            c6093a.mo13480iz(4, this.luZ);
            c6093a.mo13480iz(5, this.lva);
            c6093a.mo13480iz(6, this.lvb);
            if (this.lvc != null) {
                c6093a.mo13475e(11, this.lvc);
            }
            c6093a.mo13480iz(12, this.lvd);
            if (this.jBG != null) {
                c6093a.mo13475e(13, this.jBG);
            }
            if (this.lve != null) {
                c6093a.mo13475e(14, this.lve);
            }
            c6093a.mo13480iz(15, this.lvf);
            c6093a.mo13480iz(16, this.lvg);
            if (this.lvh != null) {
                c6093a.mo13475e(17, this.lvh);
            }
            AppMethodBeat.m2505o(19424);
            return 0;
        } else if (i == 1) {
            if (this.lvk != null) {
                ix = C6087a.m9557ix(1, this.lvk.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((((ix + C6091a.m9572bs(2, this.luX)) + C6091a.m9572bs(3, this.luY)) + C6091a.m9572bs(4, this.luZ)) + C6091a.m9572bs(5, this.lva)) + C6091a.m9572bs(6, this.lvb);
            if (this.lvc != null) {
                ix += C6091a.m9575f(11, this.lvc);
            }
            ix += C6091a.m9572bs(12, this.lvd);
            if (this.jBG != null) {
                ix += C6091a.m9575f(13, this.jBG);
            }
            if (this.lve != null) {
                ix += C6091a.m9575f(14, this.lve);
            }
            ix = (ix + C6091a.m9572bs(15, this.lvf)) + C6091a.m9572bs(16, this.lvg);
            if (this.lvh != null) {
                ix += C6091a.m9575f(17, this.lvh);
            }
            AppMethodBeat.m2505o(19424);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.lvk == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(19424);
                throw c6092b;
            }
            AppMethodBeat.m2505o(19424);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C27832g c27832g = (C27832g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C27831e c27831e = new C27831e();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c27831e.populateBuilderWithField(c6086a3, c27831e, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c27832g.lvk = c27831e;
                    }
                    AppMethodBeat.m2505o(19424);
                    return 0;
                case 2:
                    c27832g.luX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(19424);
                    return 0;
                case 3:
                    c27832g.luY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(19424);
                    return 0;
                case 4:
                    c27832g.luZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(19424);
                    return 0;
                case 5:
                    c27832g.lva = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(19424);
                    return 0;
                case 6:
                    c27832g.lvb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(19424);
                    return 0;
                case 11:
                    c27832g.lvc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(19424);
                    return 0;
                case 12:
                    c27832g.lvd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(19424);
                    return 0;
                case 13:
                    c27832g.jBG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(19424);
                    return 0;
                case 14:
                    c27832g.lve = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(19424);
                    return 0;
                case 15:
                    c27832g.lvf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(19424);
                    return 0;
                case 16:
                    c27832g.lvg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(19424);
                    return 0;
                case 17:
                    c27832g.lvh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(19424);
                    return 0;
                default:
                    AppMethodBeat.m2505o(19424);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(19424);
            return -1;
        }
    }
}
