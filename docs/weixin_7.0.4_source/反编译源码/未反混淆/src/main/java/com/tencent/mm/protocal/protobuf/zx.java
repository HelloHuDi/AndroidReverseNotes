package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class zx extends bsr {
    public String duc;
    public String dud;
    public String lvz;
    public String wfd;
    public String wfe;
    public long wff;
    public double wfg;
    public double wfh;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56784);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.lvz != null) {
                aVar.e(2, this.lvz);
            }
            if (this.dud != null) {
                aVar.e(3, this.dud);
            }
            if (this.duc != null) {
                aVar.e(4, this.duc);
            }
            if (this.wfd != null) {
                aVar.e(5, this.wfd);
            }
            if (this.wfe != null) {
                aVar.e(6, this.wfe);
            }
            aVar.ai(7, this.wff);
            aVar.f(8, this.wfg);
            aVar.f(9, this.wfh);
            AppMethodBeat.o(56784);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.lvz != null) {
                ix += e.a.a.b.b.a.f(2, this.lvz);
            }
            if (this.dud != null) {
                ix += e.a.a.b.b.a.f(3, this.dud);
            }
            if (this.duc != null) {
                ix += e.a.a.b.b.a.f(4, this.duc);
            }
            if (this.wfd != null) {
                ix += e.a.a.b.b.a.f(5, this.wfd);
            }
            if (this.wfe != null) {
                ix += e.a.a.b.b.a.f(6, this.wfe);
            }
            int o = ((ix + e.a.a.b.b.a.o(7, this.wff)) + (e.a.a.b.b.a.fv(8) + 8)) + (e.a.a.b.b.a.fv(9) + 8);
            AppMethodBeat.o(56784);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56784);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            zx zxVar = (zx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        zxVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56784);
                    return 0;
                case 2:
                    zxVar.lvz = aVar3.BTU.readString();
                    AppMethodBeat.o(56784);
                    return 0;
                case 3:
                    zxVar.dud = aVar3.BTU.readString();
                    AppMethodBeat.o(56784);
                    return 0;
                case 4:
                    zxVar.duc = aVar3.BTU.readString();
                    AppMethodBeat.o(56784);
                    return 0;
                case 5:
                    zxVar.wfd = aVar3.BTU.readString();
                    AppMethodBeat.o(56784);
                    return 0;
                case 6:
                    zxVar.wfe = aVar3.BTU.readString();
                    AppMethodBeat.o(56784);
                    return 0;
                case 7:
                    zxVar.wff = aVar3.BTU.ve();
                    AppMethodBeat.o(56784);
                    return 0;
                case 8:
                    zxVar.wfg = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(56784);
                    return 0;
                case 9:
                    zxVar.wfh = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(56784);
                    return 0;
                default:
                    AppMethodBeat.o(56784);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56784);
            return -1;
        }
    }
}
