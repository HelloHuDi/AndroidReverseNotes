package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.protocal.protobuf.C7267hl;
import com.tencent.p177mm.protocal.protobuf.bsr;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.bd */
public final class C43161bd extends bsr {
    public String guW;
    public LinkedList<String> nbX = new LinkedList();
    public C39203t nbY;
    public int nbZ;
    public String nbs;
    public int nbt;
    public boolean nca;

    public C43161bd() {
        AppMethodBeat.m2504i(111600);
        AppMethodBeat.m2505o(111600);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111601);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.nbs == null) {
                c6092b = new C6092b("Not all required fields were included: Lang");
                AppMethodBeat.m2505o(111601);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.nbs != null) {
                c6093a.mo13475e(2, this.nbs);
            }
            c6093a.mo13474e(3, 1, this.nbX);
            if (this.guW != null) {
                c6093a.mo13475e(4, this.guW);
            }
            if (this.nbY != null) {
                c6093a.mo13479iy(5, this.nbY.computeSize());
                this.nbY.writeFields(c6093a);
            }
            c6093a.mo13480iz(6, this.nbZ);
            c6093a.mo13471aO(7, this.nca);
            c6093a.mo13480iz(8, this.nbt);
            AppMethodBeat.m2505o(111601);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.nbs != null) {
                ix += C6091a.m9575f(2, this.nbs);
            }
            ix += C6087a.m9552c(3, 1, this.nbX);
            if (this.guW != null) {
                ix += C6091a.m9575f(4, this.guW);
            }
            if (this.nbY != null) {
                ix += C6087a.m9557ix(5, this.nbY.computeSize());
            }
            int bs = ((ix + C6091a.m9572bs(6, this.nbZ)) + (C6091a.m9576fv(7) + 1)) + C6091a.m9572bs(8, this.nbt);
            AppMethodBeat.m2505o(111601);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nbX.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.nbs == null) {
                c6092b = new C6092b("Not all required fields were included: Lang");
                AppMethodBeat.m2505o(111601);
                throw c6092b;
            }
            AppMethodBeat.m2505o(111601);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C43161bd c43161bd = (C43161bd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c43161bd.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(111601);
                    return 0;
                case 2:
                    c43161bd.nbs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111601);
                    return 0;
                case 3:
                    c43161bd.nbX.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(111601);
                    return 0;
                case 4:
                    c43161bd.guW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111601);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C39203t c39203t = new C39203t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c39203t.populateBuilderWithField(c6086a3, c39203t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c43161bd.nbY = c39203t;
                    }
                    AppMethodBeat.m2505o(111601);
                    return 0;
                case 6:
                    c43161bd.nbZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111601);
                    return 0;
                case 7:
                    c43161bd.nca = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(111601);
                    return 0;
                case 8:
                    c43161bd.nbt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111601);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111601);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111601);
            return -1;
        }
    }
}
