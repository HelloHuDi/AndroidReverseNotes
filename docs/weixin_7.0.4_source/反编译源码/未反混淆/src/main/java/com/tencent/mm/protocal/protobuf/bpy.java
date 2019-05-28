package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bpy extends a {
    public String wSh;
    public String wSi;
    public int wSj;
    public int wSk = 0;
    public String wSl;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124336);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wSh != null) {
                aVar.e(1, this.wSh);
            }
            if (this.wSi != null) {
                aVar.e(2, this.wSi);
            }
            aVar.iz(3, this.wSj);
            aVar.iz(4, this.wSk);
            if (this.wSl != null) {
                aVar.e(5, this.wSl);
            }
            AppMethodBeat.o(124336);
            return 0;
        } else if (i == 1) {
            if (this.wSh != null) {
                f = e.a.a.b.b.a.f(1, this.wSh) + 0;
            } else {
                f = 0;
            }
            if (this.wSi != null) {
                f += e.a.a.b.b.a.f(2, this.wSi);
            }
            f = (f + e.a.a.b.b.a.bs(3, this.wSj)) + e.a.a.b.b.a.bs(4, this.wSk);
            if (this.wSl != null) {
                f += e.a.a.b.b.a.f(5, this.wSl);
            }
            AppMethodBeat.o(124336);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124336);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bpy bpy = (bpy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bpy.wSh = aVar3.BTU.readString();
                    AppMethodBeat.o(124336);
                    return 0;
                case 2:
                    bpy.wSi = aVar3.BTU.readString();
                    AppMethodBeat.o(124336);
                    return 0;
                case 3:
                    bpy.wSj = aVar3.BTU.vd();
                    AppMethodBeat.o(124336);
                    return 0;
                case 4:
                    bpy.wSk = aVar3.BTU.vd();
                    AppMethodBeat.o(124336);
                    return 0;
                case 5:
                    bpy.wSl = aVar3.BTU.readString();
                    AppMethodBeat.o(124336);
                    return 0;
                default:
                    AppMethodBeat.o(124336);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124336);
            return -1;
        }
    }
}
