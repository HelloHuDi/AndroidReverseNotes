package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.btd;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class be extends btd {
    public ae ncb;
    public ah ncc;
    public ai ncd;
    public by nce;
    public di ncf;
    public am ncg;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111602);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(111602);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.ncb != null) {
                aVar.iy(3, this.ncb.computeSize());
                this.ncb.writeFields(aVar);
            }
            if (this.ncc != null) {
                aVar.iy(4, this.ncc.computeSize());
                this.ncc.writeFields(aVar);
            }
            if (this.ncd != null) {
                aVar.iy(5, this.ncd.computeSize());
                this.ncd.writeFields(aVar);
            }
            if (this.nce != null) {
                aVar.iy(6, this.nce.computeSize());
                this.nce.writeFields(aVar);
            }
            if (this.ncf != null) {
                aVar.iy(8, this.ncf.computeSize());
                this.ncf.writeFields(aVar);
            }
            if (this.ncg != null) {
                aVar.iy(9, this.ncg.computeSize());
                this.ncg.writeFields(aVar);
            }
            AppMethodBeat.o(111602);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ncb != null) {
                ix += e.a.a.a.ix(3, this.ncb.computeSize());
            }
            if (this.ncc != null) {
                ix += e.a.a.a.ix(4, this.ncc.computeSize());
            }
            if (this.ncd != null) {
                ix += e.a.a.a.ix(5, this.ncd.computeSize());
            }
            if (this.nce != null) {
                ix += e.a.a.a.ix(6, this.nce.computeSize());
            }
            if (this.ncf != null) {
                ix += e.a.a.a.ix(8, this.ncf.computeSize());
            }
            if (this.ncg != null) {
                ix += e.a.a.a.ix(9, this.ncg.computeSize());
            }
            AppMethodBeat.o(111602);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(111602);
                throw bVar;
            }
            AppMethodBeat.o(111602);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            be beVar = (be) objArr[1];
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
                        BaseResponse baseResponse = new BaseResponse();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        beVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(111602);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ae aeVar = new ae();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aeVar.populateBuilderWithField(aVar4, aeVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        beVar.ncb = aeVar;
                    }
                    AppMethodBeat.o(111602);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ah ahVar = new ah();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ahVar.populateBuilderWithField(aVar4, ahVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        beVar.ncc = ahVar;
                    }
                    AppMethodBeat.o(111602);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ai aiVar = new ai();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aiVar.populateBuilderWithField(aVar4, aiVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        beVar.ncd = aiVar;
                    }
                    AppMethodBeat.o(111602);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        by byVar = new by();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = byVar.populateBuilderWithField(aVar4, byVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        beVar.nce = byVar;
                    }
                    AppMethodBeat.o(111602);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        di diVar = new di();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = diVar.populateBuilderWithField(aVar4, diVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        beVar.ncf = diVar;
                    }
                    AppMethodBeat.o(111602);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        am amVar = new am();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = amVar.populateBuilderWithField(aVar4, amVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        beVar.ncg = amVar;
                    }
                    AppMethodBeat.o(111602);
                    return 0;
                default:
                    AppMethodBeat.o(111602);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111602);
            return -1;
        }
    }
}
