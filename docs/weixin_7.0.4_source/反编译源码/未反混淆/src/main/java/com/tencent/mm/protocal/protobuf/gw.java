package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class gw extends a {
    public String cFl;
    public String twT;
    public String twV;
    public String twY;
    public String twZ;
    public String vJj;
    public String vJk;
    public String vJl;
    public String vJm;
    public String vJn;
    public String vJo;
    public String vJp;
    public String vJq;
    public String vJr;
    public long vJs;
    public int vJt;
    public String vJu;
    public String vJv;
    public String vJw;
    public String vJx;
    public gx vJy;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56704);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vJj != null) {
                aVar.e(1, this.vJj);
            }
            if (this.vJk != null) {
                aVar.e(2, this.vJk);
            }
            if (this.vJl != null) {
                aVar.e(3, this.vJl);
            }
            if (this.vJm != null) {
                aVar.e(4, this.vJm);
            }
            if (this.vJn != null) {
                aVar.e(5, this.vJn);
            }
            if (this.vJo != null) {
                aVar.e(6, this.vJo);
            }
            if (this.vJp != null) {
                aVar.e(7, this.vJp);
            }
            if (this.vJq != null) {
                aVar.e(8, this.vJq);
            }
            if (this.cFl != null) {
                aVar.e(9, this.cFl);
            }
            if (this.vJr != null) {
                aVar.e(10, this.vJr);
            }
            if (this.twV != null) {
                aVar.e(11, this.twV);
            }
            if (this.twZ != null) {
                aVar.e(12, this.twZ);
            }
            if (this.twY != null) {
                aVar.e(13, this.twY);
            }
            aVar.ai(14, this.vJs);
            aVar.iz(15, this.vJt);
            if (this.vJu != null) {
                aVar.e(16, this.vJu);
            }
            if (this.vJv != null) {
                aVar.e(17, this.vJv);
            }
            if (this.vJw != null) {
                aVar.e(18, this.vJw);
            }
            if (this.twT != null) {
                aVar.e(19, this.twT);
            }
            if (this.vJx != null) {
                aVar.e(20, this.vJx);
            }
            if (this.vJy != null) {
                aVar.iy(21, this.vJy.computeSize());
                this.vJy.writeFields(aVar);
            }
            AppMethodBeat.o(56704);
            return 0;
        } else if (i == 1) {
            if (this.vJj != null) {
                f = e.a.a.b.b.a.f(1, this.vJj) + 0;
            } else {
                f = 0;
            }
            if (this.vJk != null) {
                f += e.a.a.b.b.a.f(2, this.vJk);
            }
            if (this.vJl != null) {
                f += e.a.a.b.b.a.f(3, this.vJl);
            }
            if (this.vJm != null) {
                f += e.a.a.b.b.a.f(4, this.vJm);
            }
            if (this.vJn != null) {
                f += e.a.a.b.b.a.f(5, this.vJn);
            }
            if (this.vJo != null) {
                f += e.a.a.b.b.a.f(6, this.vJo);
            }
            if (this.vJp != null) {
                f += e.a.a.b.b.a.f(7, this.vJp);
            }
            if (this.vJq != null) {
                f += e.a.a.b.b.a.f(8, this.vJq);
            }
            if (this.cFl != null) {
                f += e.a.a.b.b.a.f(9, this.cFl);
            }
            if (this.vJr != null) {
                f += e.a.a.b.b.a.f(10, this.vJr);
            }
            if (this.twV != null) {
                f += e.a.a.b.b.a.f(11, this.twV);
            }
            if (this.twZ != null) {
                f += e.a.a.b.b.a.f(12, this.twZ);
            }
            if (this.twY != null) {
                f += e.a.a.b.b.a.f(13, this.twY);
            }
            f = (f + e.a.a.b.b.a.o(14, this.vJs)) + e.a.a.b.b.a.bs(15, this.vJt);
            if (this.vJu != null) {
                f += e.a.a.b.b.a.f(16, this.vJu);
            }
            if (this.vJv != null) {
                f += e.a.a.b.b.a.f(17, this.vJv);
            }
            if (this.vJw != null) {
                f += e.a.a.b.b.a.f(18, this.vJw);
            }
            if (this.twT != null) {
                f += e.a.a.b.b.a.f(19, this.twT);
            }
            if (this.vJx != null) {
                f += e.a.a.b.b.a.f(20, this.vJx);
            }
            if (this.vJy != null) {
                f += e.a.a.a.ix(21, this.vJy.computeSize());
            }
            AppMethodBeat.o(56704);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56704);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            gw gwVar = (gw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    gwVar.vJj = aVar3.BTU.readString();
                    AppMethodBeat.o(56704);
                    return 0;
                case 2:
                    gwVar.vJk = aVar3.BTU.readString();
                    AppMethodBeat.o(56704);
                    return 0;
                case 3:
                    gwVar.vJl = aVar3.BTU.readString();
                    AppMethodBeat.o(56704);
                    return 0;
                case 4:
                    gwVar.vJm = aVar3.BTU.readString();
                    AppMethodBeat.o(56704);
                    return 0;
                case 5:
                    gwVar.vJn = aVar3.BTU.readString();
                    AppMethodBeat.o(56704);
                    return 0;
                case 6:
                    gwVar.vJo = aVar3.BTU.readString();
                    AppMethodBeat.o(56704);
                    return 0;
                case 7:
                    gwVar.vJp = aVar3.BTU.readString();
                    AppMethodBeat.o(56704);
                    return 0;
                case 8:
                    gwVar.vJq = aVar3.BTU.readString();
                    AppMethodBeat.o(56704);
                    return 0;
                case 9:
                    gwVar.cFl = aVar3.BTU.readString();
                    AppMethodBeat.o(56704);
                    return 0;
                case 10:
                    gwVar.vJr = aVar3.BTU.readString();
                    AppMethodBeat.o(56704);
                    return 0;
                case 11:
                    gwVar.twV = aVar3.BTU.readString();
                    AppMethodBeat.o(56704);
                    return 0;
                case 12:
                    gwVar.twZ = aVar3.BTU.readString();
                    AppMethodBeat.o(56704);
                    return 0;
                case 13:
                    gwVar.twY = aVar3.BTU.readString();
                    AppMethodBeat.o(56704);
                    return 0;
                case 14:
                    gwVar.vJs = aVar3.BTU.ve();
                    AppMethodBeat.o(56704);
                    return 0;
                case 15:
                    gwVar.vJt = aVar3.BTU.vd();
                    AppMethodBeat.o(56704);
                    return 0;
                case 16:
                    gwVar.vJu = aVar3.BTU.readString();
                    AppMethodBeat.o(56704);
                    return 0;
                case 17:
                    gwVar.vJv = aVar3.BTU.readString();
                    AppMethodBeat.o(56704);
                    return 0;
                case 18:
                    gwVar.vJw = aVar3.BTU.readString();
                    AppMethodBeat.o(56704);
                    return 0;
                case 19:
                    gwVar.twT = aVar3.BTU.readString();
                    AppMethodBeat.o(56704);
                    return 0;
                case 20:
                    gwVar.vJx = aVar3.BTU.readString();
                    AppMethodBeat.o(56704);
                    return 0;
                case 21:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        gx gxVar = new gx();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = gxVar.populateBuilderWithField(aVar4, gxVar, a.getNextFieldNumber(aVar4))) {
                        }
                        gwVar.vJy = gxVar;
                    }
                    AppMethodBeat.o(56704);
                    return 0;
                default:
                    AppMethodBeat.o(56704);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56704);
            return -1;
        }
    }
}
