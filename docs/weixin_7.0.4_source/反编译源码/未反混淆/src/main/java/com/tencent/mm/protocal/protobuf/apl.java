package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class apl extends btd {
    public cmd wcK;
    public b wtt;
    public LinkedList<cmb> wtu = new LinkedList();
    public int wtv;

    public apl() {
        AppMethodBeat.i(127725);
        AppMethodBeat.o(127725);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(127726);
        e.a.a.b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(127726);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wcK != null) {
                aVar.iy(2, this.wcK.computeSize());
                this.wcK.writeFields(aVar);
            }
            aVar.e(3, 8, this.wtu);
            if (this.wtt != null) {
                aVar.c(4, this.wtt);
            }
            aVar.iz(5, this.wtv);
            AppMethodBeat.o(127726);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wcK != null) {
                ix += e.a.a.a.ix(2, this.wcK.computeSize());
            }
            ix += e.a.a.a.c(3, 8, this.wtu);
            if (this.wtt != null) {
                ix += e.a.a.b.b.a.b(4, this.wtt);
            }
            int bs = ix + e.a.a.b.b.a.bs(5, this.wtv);
            AppMethodBeat.o(127726);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wtu.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(127726);
                throw bVar;
            }
            AppMethodBeat.o(127726);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            apl apl = (apl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        apl.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(127726);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cmd cmd = new cmd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cmd.populateBuilderWithField(aVar4, cmd, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        apl.wcK = cmd;
                    }
                    AppMethodBeat.o(127726);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cmb cmb = new cmb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cmb.populateBuilderWithField(aVar4, cmb, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        apl.wtu.add(cmb);
                    }
                    AppMethodBeat.o(127726);
                    return 0;
                case 4:
                    apl.wtt = aVar3.BTU.emu();
                    AppMethodBeat.o(127726);
                    return 0;
                case 5:
                    apl.wtv = aVar3.BTU.vd();
                    AppMethodBeat.o(127726);
                    return 0;
                default:
                    AppMethodBeat.o(127726);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127726);
            return -1;
        }
    }
}
