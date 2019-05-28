package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cy extends a {
    public cai vEX;
    public bts vEY;
    public int vEZ;
    public brf vFa;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94503);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vEX == null) {
                bVar = new b("Not all required fields were included: SnsADObject");
                AppMethodBeat.o(94503);
                throw bVar;
            }
            if (this.vEX != null) {
                aVar.iy(1, this.vEX.computeSize());
                this.vEX.writeFields(aVar);
            }
            if (this.vEY != null) {
                aVar.iy(2, this.vEY.computeSize());
                this.vEY.writeFields(aVar);
            }
            aVar.iz(3, this.vEZ);
            if (this.vFa != null) {
                aVar.iy(4, this.vFa.computeSize());
                this.vFa.writeFields(aVar);
            }
            AppMethodBeat.o(94503);
            return 0;
        } else if (i == 1) {
            if (this.vEX != null) {
                ix = e.a.a.a.ix(1, this.vEX.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vEY != null) {
                ix += e.a.a.a.ix(2, this.vEY.computeSize());
            }
            ix += e.a.a.b.b.a.bs(3, this.vEZ);
            if (this.vFa != null) {
                ix += e.a.a.a.ix(4, this.vFa.computeSize());
            }
            AppMethodBeat.o(94503);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vEX == null) {
                bVar = new b("Not all required fields were included: SnsADObject");
                AppMethodBeat.o(94503);
                throw bVar;
            }
            AppMethodBeat.o(94503);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cy cyVar = (cy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cai cai = new cai();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cai.populateBuilderWithField(aVar4, cai, a.getNextFieldNumber(aVar4))) {
                        }
                        cyVar.vEX = cai;
                    }
                    AppMethodBeat.o(94503);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        cyVar.vEY = bts;
                    }
                    AppMethodBeat.o(94503);
                    return 0;
                case 3:
                    cyVar.vEZ = aVar3.BTU.vd();
                    AppMethodBeat.o(94503);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        brf brf = new brf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = brf.populateBuilderWithField(aVar4, brf, a.getNextFieldNumber(aVar4))) {
                        }
                        cyVar.vFa = brf;
                    }
                    AppMethodBeat.o(94503);
                    return 0;
                default:
                    AppMethodBeat.o(94503);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94503);
            return -1;
        }
    }
}
