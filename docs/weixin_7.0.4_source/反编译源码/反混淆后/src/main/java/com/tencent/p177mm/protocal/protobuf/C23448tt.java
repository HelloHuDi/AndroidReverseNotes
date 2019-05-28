package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.tt */
public final class C23448tt extends C1331a {
    public String app_id;
    public String waU;
    public String waV;
    public String waW;
    public int waX;
    public int waY;
    public int waZ;
    public int wba;
    public int wbb;
    public int wbc;
    public String wbd;
    public String wbe;
    public String wbf;
    public C1332b wbg;
    public String wbh;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(135599);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.app_id != null) {
                c6093a.mo13475e(1, this.app_id);
            }
            if (this.waU != null) {
                c6093a.mo13475e(2, this.waU);
            }
            if (this.waV != null) {
                c6093a.mo13475e(3, this.waV);
            }
            if (this.waW != null) {
                c6093a.mo13475e(4, this.waW);
            }
            c6093a.mo13480iz(5, this.waX);
            c6093a.mo13480iz(6, this.waY);
            c6093a.mo13480iz(7, this.waZ);
            c6093a.mo13480iz(10, this.wba);
            c6093a.mo13480iz(11, this.wbb);
            c6093a.mo13480iz(12, this.wbc);
            if (this.wbd != null) {
                c6093a.mo13475e(15, this.wbd);
            }
            if (this.wbe != null) {
                c6093a.mo13475e(16, this.wbe);
            }
            if (this.wbf != null) {
                c6093a.mo13475e(17, this.wbf);
            }
            if (this.wbg != null) {
                c6093a.mo13473c(18, this.wbg);
            }
            if (this.wbh != null) {
                c6093a.mo13475e(19, this.wbh);
            }
            AppMethodBeat.m2505o(135599);
            return 0;
        } else if (i == 1) {
            if (this.app_id != null) {
                f = C6091a.m9575f(1, this.app_id) + 0;
            } else {
                f = 0;
            }
            if (this.waU != null) {
                f += C6091a.m9575f(2, this.waU);
            }
            if (this.waV != null) {
                f += C6091a.m9575f(3, this.waV);
            }
            if (this.waW != null) {
                f += C6091a.m9575f(4, this.waW);
            }
            f = (((((f + C6091a.m9572bs(5, this.waX)) + C6091a.m9572bs(6, this.waY)) + C6091a.m9572bs(7, this.waZ)) + C6091a.m9572bs(10, this.wba)) + C6091a.m9572bs(11, this.wbb)) + C6091a.m9572bs(12, this.wbc);
            if (this.wbd != null) {
                f += C6091a.m9575f(15, this.wbd);
            }
            if (this.wbe != null) {
                f += C6091a.m9575f(16, this.wbe);
            }
            if (this.wbf != null) {
                f += C6091a.m9575f(17, this.wbf);
            }
            if (this.wbg != null) {
                f += C6091a.m9571b(18, this.wbg);
            }
            if (this.wbh != null) {
                f += C6091a.m9575f(19, this.wbh);
            }
            AppMethodBeat.m2505o(135599);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(135599);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23448tt c23448tt = (C23448tt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c23448tt.app_id = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(135599);
                    return 0;
                case 2:
                    c23448tt.waU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(135599);
                    return 0;
                case 3:
                    c23448tt.waV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(135599);
                    return 0;
                case 4:
                    c23448tt.waW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(135599);
                    return 0;
                case 5:
                    c23448tt.waX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135599);
                    return 0;
                case 6:
                    c23448tt.waY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135599);
                    return 0;
                case 7:
                    c23448tt.waZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135599);
                    return 0;
                case 10:
                    c23448tt.wba = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135599);
                    return 0;
                case 11:
                    c23448tt.wbb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135599);
                    return 0;
                case 12:
                    c23448tt.wbc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135599);
                    return 0;
                case 15:
                    c23448tt.wbd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(135599);
                    return 0;
                case 16:
                    c23448tt.wbe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(135599);
                    return 0;
                case 17:
                    c23448tt.wbf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(135599);
                    return 0;
                case 18:
                    c23448tt.wbg = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(135599);
                    return 0;
                case 19:
                    c23448tt.wbh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(135599);
                    return 0;
                default:
                    AppMethodBeat.m2505o(135599);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(135599);
            return -1;
        }
    }
}
