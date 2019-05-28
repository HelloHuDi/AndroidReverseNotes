package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class bzz extends a {
    public int Scene;
    public String Title;
    public String Url;
    public String wYV;
    public String wYW;
    public String wYX;
    public int wYY;
    public String wYZ;
    public String wZa;
    public String wZb;
    public int wZc;
    public int wZd;
    public int wZe;
    public int wZf;
    public int wZg;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124363);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wYV == null) {
                bVar = new b("Not all required fields were included: PickedWord");
                AppMethodBeat.o(124363);
                throw bVar;
            }
            if (this.wYV != null) {
                aVar.e(1, this.wYV);
            }
            if (this.wYW != null) {
                aVar.e(2, this.wYW);
            }
            if (this.wYX != null) {
                aVar.e(3, this.wYX);
            }
            aVar.iz(4, this.Scene);
            aVar.iz(5, this.wYY);
            if (this.Url != null) {
                aVar.e(6, this.Url);
            }
            if (this.Title != null) {
                aVar.e(7, this.Title);
            }
            if (this.wYZ != null) {
                aVar.e(8, this.wYZ);
            }
            if (this.wZa != null) {
                aVar.e(9, this.wZa);
            }
            if (this.wZb != null) {
                aVar.e(10, this.wZb);
            }
            aVar.iz(11, this.wZc);
            aVar.iz(12, this.wZd);
            aVar.iz(13, this.wZe);
            aVar.iz(14, this.wZf);
            aVar.iz(15, this.wZg);
            AppMethodBeat.o(124363);
            return 0;
        } else if (i == 1) {
            if (this.wYV != null) {
                f = e.a.a.b.b.a.f(1, this.wYV) + 0;
            } else {
                f = 0;
            }
            if (this.wYW != null) {
                f += e.a.a.b.b.a.f(2, this.wYW);
            }
            if (this.wYX != null) {
                f += e.a.a.b.b.a.f(3, this.wYX);
            }
            f = (f + e.a.a.b.b.a.bs(4, this.Scene)) + e.a.a.b.b.a.bs(5, this.wYY);
            if (this.Url != null) {
                f += e.a.a.b.b.a.f(6, this.Url);
            }
            if (this.Title != null) {
                f += e.a.a.b.b.a.f(7, this.Title);
            }
            if (this.wYZ != null) {
                f += e.a.a.b.b.a.f(8, this.wYZ);
            }
            if (this.wZa != null) {
                f += e.a.a.b.b.a.f(9, this.wZa);
            }
            if (this.wZb != null) {
                f += e.a.a.b.b.a.f(10, this.wZb);
            }
            int bs = ((((f + e.a.a.b.b.a.bs(11, this.wZc)) + e.a.a.b.b.a.bs(12, this.wZd)) + e.a.a.b.b.a.bs(13, this.wZe)) + e.a.a.b.b.a.bs(14, this.wZf)) + e.a.a.b.b.a.bs(15, this.wZg);
            AppMethodBeat.o(124363);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.wYV == null) {
                bVar = new b("Not all required fields were included: PickedWord");
                AppMethodBeat.o(124363);
                throw bVar;
            }
            AppMethodBeat.o(124363);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzz bzz = (bzz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzz.wYV = aVar3.BTU.readString();
                    AppMethodBeat.o(124363);
                    return 0;
                case 2:
                    bzz.wYW = aVar3.BTU.readString();
                    AppMethodBeat.o(124363);
                    return 0;
                case 3:
                    bzz.wYX = aVar3.BTU.readString();
                    AppMethodBeat.o(124363);
                    return 0;
                case 4:
                    bzz.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(124363);
                    return 0;
                case 5:
                    bzz.wYY = aVar3.BTU.vd();
                    AppMethodBeat.o(124363);
                    return 0;
                case 6:
                    bzz.Url = aVar3.BTU.readString();
                    AppMethodBeat.o(124363);
                    return 0;
                case 7:
                    bzz.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(124363);
                    return 0;
                case 8:
                    bzz.wYZ = aVar3.BTU.readString();
                    AppMethodBeat.o(124363);
                    return 0;
                case 9:
                    bzz.wZa = aVar3.BTU.readString();
                    AppMethodBeat.o(124363);
                    return 0;
                case 10:
                    bzz.wZb = aVar3.BTU.readString();
                    AppMethodBeat.o(124363);
                    return 0;
                case 11:
                    bzz.wZc = aVar3.BTU.vd();
                    AppMethodBeat.o(124363);
                    return 0;
                case 12:
                    bzz.wZd = aVar3.BTU.vd();
                    AppMethodBeat.o(124363);
                    return 0;
                case 13:
                    bzz.wZe = aVar3.BTU.vd();
                    AppMethodBeat.o(124363);
                    return 0;
                case 14:
                    bzz.wZf = aVar3.BTU.vd();
                    AppMethodBeat.o(124363);
                    return 0;
                case 15:
                    bzz.wZg = aVar3.BTU.vd();
                    AppMethodBeat.o(124363);
                    return 0;
                default:
                    AppMethodBeat.o(124363);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124363);
            return -1;
        }
    }
}
