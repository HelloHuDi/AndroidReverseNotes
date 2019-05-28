package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bpb extends a {
    public String SmallImgUrl;
    public String jBB;
    public String jCH;
    public int wRw;
    public String wfK;
    public String wlF;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102516);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jBB != null) {
                aVar.e(1, this.jBB);
            }
            aVar.iz(2, this.wRw);
            if (this.jCH != null) {
                aVar.e(3, this.jCH);
            }
            if (this.SmallImgUrl != null) {
                aVar.e(4, this.SmallImgUrl);
            }
            if (this.wfK != null) {
                aVar.e(5, this.wfK);
            }
            if (this.wlF != null) {
                aVar.e(6, this.wlF);
            }
            AppMethodBeat.o(102516);
            return 0;
        } else if (i == 1) {
            if (this.jBB != null) {
                f = e.a.a.b.b.a.f(1, this.jBB) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.wRw);
            if (this.jCH != null) {
                f += e.a.a.b.b.a.f(3, this.jCH);
            }
            if (this.SmallImgUrl != null) {
                f += e.a.a.b.b.a.f(4, this.SmallImgUrl);
            }
            if (this.wfK != null) {
                f += e.a.a.b.b.a.f(5, this.wfK);
            }
            if (this.wlF != null) {
                f += e.a.a.b.b.a.f(6, this.wlF);
            }
            AppMethodBeat.o(102516);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(102516);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bpb bpb = (bpb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bpb.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(102516);
                    return 0;
                case 2:
                    bpb.wRw = aVar3.BTU.vd();
                    AppMethodBeat.o(102516);
                    return 0;
                case 3:
                    bpb.jCH = aVar3.BTU.readString();
                    AppMethodBeat.o(102516);
                    return 0;
                case 4:
                    bpb.SmallImgUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(102516);
                    return 0;
                case 5:
                    bpb.wfK = aVar3.BTU.readString();
                    AppMethodBeat.o(102516);
                    return 0;
                case 6:
                    bpb.wlF = aVar3.BTU.readString();
                    AppMethodBeat.o(102516);
                    return 0;
                default:
                    AppMethodBeat.o(102516);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102516);
            return -1;
        }
    }
}
