package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class avh extends btd {
    public avi wzj;
    public LinkedList<avf> wzk = new LinkedList();
    public String wzl;
    public LinkedList<awg> wzm = new LinkedList();

    public avh() {
        AppMethodBeat.i(10199);
        AppMethodBeat.o(10199);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10200);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(10200);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wzj != null) {
                aVar.iy(2, this.wzj.computeSize());
                this.wzj.writeFields(aVar);
            }
            aVar.e(3, 8, this.wzk);
            if (this.wzl != null) {
                aVar.e(4, this.wzl);
            }
            aVar.e(5, 8, this.wzm);
            AppMethodBeat.o(10200);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wzj != null) {
                ix += e.a.a.a.ix(2, this.wzj.computeSize());
            }
            ix += e.a.a.a.c(3, 8, this.wzk);
            if (this.wzl != null) {
                ix += e.a.a.b.b.a.f(4, this.wzl);
            }
            int c = ix + e.a.a.a.c(5, 8, this.wzm);
            AppMethodBeat.o(10200);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wzk.clear();
            this.wzm.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(10200);
                throw bVar;
            }
            AppMethodBeat.o(10200);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            avh avh = (avh) objArr[1];
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
                        avh.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(10200);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        avi avi = new avi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = avi.populateBuilderWithField(aVar4, avi, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        avh.wzj = avi;
                    }
                    AppMethodBeat.o(10200);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        avf avf = new avf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = avf.populateBuilderWithField(aVar4, avf, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        avh.wzk.add(avf);
                    }
                    AppMethodBeat.o(10200);
                    return 0;
                case 4:
                    avh.wzl = aVar3.BTU.readString();
                    AppMethodBeat.o(10200);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        awg awg = new awg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = awg.populateBuilderWithField(aVar4, awg, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        avh.wzm.add(awg);
                    }
                    AppMethodBeat.o(10200);
                    return 0;
                default:
                    AppMethodBeat.o(10200);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10200);
            return -1;
        }
    }
}
