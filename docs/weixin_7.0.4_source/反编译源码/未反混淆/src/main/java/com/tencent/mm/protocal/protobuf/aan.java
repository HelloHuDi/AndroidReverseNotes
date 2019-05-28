package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class aan extends a {
    public String SmallImgUrl;
    public String jBB;
    public int jBT;
    public String jCH;
    public String wfK;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28406);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jBB != null) {
                aVar.e(1, this.jBB);
            }
            if (this.wfK != null) {
                aVar.e(2, this.wfK);
            }
            if (this.jCH != null) {
                aVar.e(3, this.jCH);
            }
            if (this.SmallImgUrl != null) {
                aVar.e(4, this.SmallImgUrl);
            }
            aVar.iz(5, this.jBT);
            AppMethodBeat.o(28406);
            return 0;
        } else if (i == 1) {
            if (this.jBB != null) {
                f = e.a.a.b.b.a.f(1, this.jBB) + 0;
            } else {
                f = 0;
            }
            if (this.wfK != null) {
                f += e.a.a.b.b.a.f(2, this.wfK);
            }
            if (this.jCH != null) {
                f += e.a.a.b.b.a.f(3, this.jCH);
            }
            if (this.SmallImgUrl != null) {
                f += e.a.a.b.b.a.f(4, this.SmallImgUrl);
            }
            int bs = f + e.a.a.b.b.a.bs(5, this.jBT);
            AppMethodBeat.o(28406);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28406);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aan aan = (aan) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aan.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(28406);
                    return 0;
                case 2:
                    aan.wfK = aVar3.BTU.readString();
                    AppMethodBeat.o(28406);
                    return 0;
                case 3:
                    aan.jCH = aVar3.BTU.readString();
                    AppMethodBeat.o(28406);
                    return 0;
                case 4:
                    aan.SmallImgUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(28406);
                    return 0;
                case 5:
                    aan.jBT = aVar3.BTU.vd();
                    AppMethodBeat.o(28406);
                    return 0;
                default:
                    AppMethodBeat.o(28406);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28406);
            return -1;
        }
    }
}
