package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ath extends btd {
    public int kdT;
    public String kdU;
    public LinkedList<ati> wxk = new LinkedList();
    public bke wxl;
    public btn wxm;
    public boolean wxn;
    public he wxo;

    public ath() {
        AppMethodBeat.i(48868);
        AppMethodBeat.o(48868);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48869);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48869);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.kdT);
            if (this.kdU != null) {
                aVar.e(3, this.kdU);
            }
            aVar.e(4, 8, this.wxk);
            if (this.wxl != null) {
                aVar.iy(5, this.wxl.computeSize());
                this.wxl.writeFields(aVar);
            }
            if (this.wxm != null) {
                aVar.iy(6, this.wxm.computeSize());
                this.wxm.writeFields(aVar);
            }
            aVar.aO(7, this.wxn);
            if (this.wxo != null) {
                aVar.iy(8, this.wxo.computeSize());
                this.wxo.writeFields(aVar);
            }
            AppMethodBeat.o(48869);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.kdT);
            if (this.kdU != null) {
                ix += e.a.a.b.b.a.f(3, this.kdU);
            }
            ix += e.a.a.a.c(4, 8, this.wxk);
            if (this.wxl != null) {
                ix += e.a.a.a.ix(5, this.wxl.computeSize());
            }
            if (this.wxm != null) {
                ix += e.a.a.a.ix(6, this.wxm.computeSize());
            }
            ix += e.a.a.b.b.a.fv(7) + 1;
            if (this.wxo != null) {
                ix += e.a.a.a.ix(8, this.wxo.computeSize());
            }
            AppMethodBeat.o(48869);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wxk.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48869);
                throw bVar;
            }
            AppMethodBeat.o(48869);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ath ath = (ath) objArr[1];
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
                        ath.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(48869);
                    return 0;
                case 2:
                    ath.kdT = aVar3.BTU.vd();
                    AppMethodBeat.o(48869);
                    return 0;
                case 3:
                    ath.kdU = aVar3.BTU.readString();
                    AppMethodBeat.o(48869);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ati ati = new ati();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ati.populateBuilderWithField(aVar4, ati, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ath.wxk.add(ati);
                    }
                    AppMethodBeat.o(48869);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bke bke = new bke();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bke.populateBuilderWithField(aVar4, bke, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ath.wxl = bke;
                    }
                    AppMethodBeat.o(48869);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btn btn = new btn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btn.populateBuilderWithField(aVar4, btn, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ath.wxm = btn;
                    }
                    AppMethodBeat.o(48869);
                    return 0;
                case 7:
                    ath.wxn = aVar3.BTU.ehX();
                    AppMethodBeat.o(48869);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        he heVar = new he();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = heVar.populateBuilderWithField(aVar4, heVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ath.wxo = heVar;
                    }
                    AppMethodBeat.o(48869);
                    return 0;
                default:
                    AppMethodBeat.o(48869);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48869);
            return -1;
        }
    }
}
