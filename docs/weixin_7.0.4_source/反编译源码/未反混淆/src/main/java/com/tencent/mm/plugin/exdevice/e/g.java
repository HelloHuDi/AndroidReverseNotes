package com.tencent.mm.plugin.exdevice.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class g extends j {
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

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(19424);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.lvk == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(19424);
                throw bVar;
            }
            if (this.lvk != null) {
                aVar.iy(1, this.lvk.computeSize());
                this.lvk.writeFields(aVar);
            }
            aVar.iz(2, this.luX);
            aVar.iz(3, this.luY);
            aVar.iz(4, this.luZ);
            aVar.iz(5, this.lva);
            aVar.iz(6, this.lvb);
            if (this.lvc != null) {
                aVar.e(11, this.lvc);
            }
            aVar.iz(12, this.lvd);
            if (this.jBG != null) {
                aVar.e(13, this.jBG);
            }
            if (this.lve != null) {
                aVar.e(14, this.lve);
            }
            aVar.iz(15, this.lvf);
            aVar.iz(16, this.lvg);
            if (this.lvh != null) {
                aVar.e(17, this.lvh);
            }
            AppMethodBeat.o(19424);
            return 0;
        } else if (i == 1) {
            if (this.lvk != null) {
                ix = e.a.a.a.ix(1, this.lvk.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((((ix + e.a.a.b.b.a.bs(2, this.luX)) + e.a.a.b.b.a.bs(3, this.luY)) + e.a.a.b.b.a.bs(4, this.luZ)) + e.a.a.b.b.a.bs(5, this.lva)) + e.a.a.b.b.a.bs(6, this.lvb);
            if (this.lvc != null) {
                ix += e.a.a.b.b.a.f(11, this.lvc);
            }
            ix += e.a.a.b.b.a.bs(12, this.lvd);
            if (this.jBG != null) {
                ix += e.a.a.b.b.a.f(13, this.jBG);
            }
            if (this.lve != null) {
                ix += e.a.a.b.b.a.f(14, this.lve);
            }
            ix = (ix + e.a.a.b.b.a.bs(15, this.lvf)) + e.a.a.b.b.a.bs(16, this.lvg);
            if (this.lvh != null) {
                ix += e.a.a.b.b.a.f(17, this.lvh);
            }
            AppMethodBeat.o(19424);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.lvk == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(19424);
                throw bVar;
            }
            AppMethodBeat.o(19424);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        e eVar = new e();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        gVar.lvk = eVar;
                    }
                    AppMethodBeat.o(19424);
                    return 0;
                case 2:
                    gVar.luX = aVar3.BTU.vd();
                    AppMethodBeat.o(19424);
                    return 0;
                case 3:
                    gVar.luY = aVar3.BTU.vd();
                    AppMethodBeat.o(19424);
                    return 0;
                case 4:
                    gVar.luZ = aVar3.BTU.vd();
                    AppMethodBeat.o(19424);
                    return 0;
                case 5:
                    gVar.lva = aVar3.BTU.vd();
                    AppMethodBeat.o(19424);
                    return 0;
                case 6:
                    gVar.lvb = aVar3.BTU.vd();
                    AppMethodBeat.o(19424);
                    return 0;
                case 11:
                    gVar.lvc = aVar3.BTU.readString();
                    AppMethodBeat.o(19424);
                    return 0;
                case 12:
                    gVar.lvd = aVar3.BTU.vd();
                    AppMethodBeat.o(19424);
                    return 0;
                case 13:
                    gVar.jBG = aVar3.BTU.readString();
                    AppMethodBeat.o(19424);
                    return 0;
                case 14:
                    gVar.lve = aVar3.BTU.readString();
                    AppMethodBeat.o(19424);
                    return 0;
                case 15:
                    gVar.lvf = aVar3.BTU.vd();
                    AppMethodBeat.o(19424);
                    return 0;
                case 16:
                    gVar.lvg = aVar3.BTU.vd();
                    AppMethodBeat.o(19424);
                    return 0;
                case 17:
                    gVar.lvh = aVar3.BTU.readString();
                    AppMethodBeat.o(19424);
                    return 0;
                default:
                    AppMethodBeat.o(19424);
                    return -1;
            }
        } else {
            AppMethodBeat.o(19424);
            return -1;
        }
    }
}
