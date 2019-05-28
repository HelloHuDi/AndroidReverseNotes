package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class tm extends a {
    public String kKZ;
    public String kbW;
    public String kbX;
    public String title;
    public String url;
    public String vTL;
    public String vTM;
    public long vUW;
    public String vUX;
    public String vUY;
    public arp waC;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89052);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.kbW != null) {
                aVar.e(2, this.kbW);
            }
            if (this.kbX != null) {
                aVar.e(3, this.kbX);
            }
            if (this.url != null) {
                aVar.e(4, this.url);
            }
            aVar.ai(5, this.vUW);
            if (this.vUX != null) {
                aVar.e(6, this.vUX);
            }
            if (this.vUY != null) {
                aVar.e(7, this.vUY);
            }
            if (this.kKZ != null) {
                aVar.e(8, this.kKZ);
            }
            if (this.waC != null) {
                aVar.iy(9, this.waC.computeSize());
                this.waC.writeFields(aVar);
            }
            if (this.vTL != null) {
                aVar.e(10, this.vTL);
            }
            if (this.vTM != null) {
                aVar.e(11, this.vTM);
            }
            AppMethodBeat.o(89052);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = e.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.kbW != null) {
                f += e.a.a.b.b.a.f(2, this.kbW);
            }
            if (this.kbX != null) {
                f += e.a.a.b.b.a.f(3, this.kbX);
            }
            if (this.url != null) {
                f += e.a.a.b.b.a.f(4, this.url);
            }
            f += e.a.a.b.b.a.o(5, this.vUW);
            if (this.vUX != null) {
                f += e.a.a.b.b.a.f(6, this.vUX);
            }
            if (this.vUY != null) {
                f += e.a.a.b.b.a.f(7, this.vUY);
            }
            if (this.kKZ != null) {
                f += e.a.a.b.b.a.f(8, this.kKZ);
            }
            if (this.waC != null) {
                f += e.a.a.a.ix(9, this.waC.computeSize());
            }
            if (this.vTL != null) {
                f += e.a.a.b.b.a.f(10, this.vTL);
            }
            if (this.vTM != null) {
                f += e.a.a.b.b.a.f(11, this.vTM);
            }
            AppMethodBeat.o(89052);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89052);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            tm tmVar = (tm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    tmVar.title = aVar3.BTU.readString();
                    AppMethodBeat.o(89052);
                    return 0;
                case 2:
                    tmVar.kbW = aVar3.BTU.readString();
                    AppMethodBeat.o(89052);
                    return 0;
                case 3:
                    tmVar.kbX = aVar3.BTU.readString();
                    AppMethodBeat.o(89052);
                    return 0;
                case 4:
                    tmVar.url = aVar3.BTU.readString();
                    AppMethodBeat.o(89052);
                    return 0;
                case 5:
                    tmVar.vUW = aVar3.BTU.ve();
                    AppMethodBeat.o(89052);
                    return 0;
                case 6:
                    tmVar.vUX = aVar3.BTU.readString();
                    AppMethodBeat.o(89052);
                    return 0;
                case 7:
                    tmVar.vUY = aVar3.BTU.readString();
                    AppMethodBeat.o(89052);
                    return 0;
                case 8:
                    tmVar.kKZ = aVar3.BTU.readString();
                    AppMethodBeat.o(89052);
                    return 0;
                case 9:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        arp arp = new arp();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = arp.populateBuilderWithField(aVar4, arp, a.getNextFieldNumber(aVar4))) {
                        }
                        tmVar.waC = arp;
                    }
                    AppMethodBeat.o(89052);
                    return 0;
                case 10:
                    tmVar.vTL = aVar3.BTU.readString();
                    AppMethodBeat.o(89052);
                    return 0;
                case 11:
                    tmVar.vTM = aVar3.BTU.readString();
                    AppMethodBeat.o(89052);
                    return 0;
                default:
                    AppMethodBeat.o(89052);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89052);
            return -1;
        }
    }
}
