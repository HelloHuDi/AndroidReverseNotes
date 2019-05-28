package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public class BaseResponse extends a {
    public bts ErrMsg;
    public int Ret;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58893);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ErrMsg == null) {
                bVar = new b("Not all required fields were included: ErrMsg");
                AppMethodBeat.o(58893);
                throw bVar;
            }
            aVar.iz(1, this.Ret);
            if (this.ErrMsg != null) {
                aVar.iy(2, this.ErrMsg.computeSize());
                this.ErrMsg.writeFields(aVar);
            }
            AppMethodBeat.o(58893);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.Ret) + 0;
            if (this.ErrMsg != null) {
                bs += e.a.a.a.ix(2, this.ErrMsg.computeSize());
            }
            AppMethodBeat.o(58893);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.ErrMsg == null) {
                bVar = new b("Not all required fields were included: ErrMsg");
                AppMethodBeat.o(58893);
                throw bVar;
            }
            AppMethodBeat.o(58893);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            BaseResponse baseResponse = (BaseResponse) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    baseResponse.Ret = aVar3.BTU.vd();
                    AppMethodBeat.o(58893);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        baseResponse.ErrMsg = bts;
                    }
                    AppMethodBeat.o(58893);
                    return 0;
                default:
                    AppMethodBeat.o(58893);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58893);
            return -1;
        }
    }
}
