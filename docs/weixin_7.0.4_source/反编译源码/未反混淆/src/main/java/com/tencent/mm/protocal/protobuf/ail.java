package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ail extends a {
    public String ProductID;
    public SKBuiltinBuffer_t ReqBuf;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62560);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ProductID == null) {
                bVar = new b("Not all required fields were included: ProductID");
                AppMethodBeat.o(62560);
                throw bVar;
            } else if (this.ReqBuf == null) {
                bVar = new b("Not all required fields were included: ReqBuf");
                AppMethodBeat.o(62560);
                throw bVar;
            } else {
                if (this.ProductID != null) {
                    aVar.e(1, this.ProductID);
                }
                if (this.ReqBuf != null) {
                    aVar.iy(2, this.ReqBuf.computeSize());
                    this.ReqBuf.writeFields(aVar);
                }
                AppMethodBeat.o(62560);
                return 0;
            }
        } else if (i == 1) {
            if (this.ProductID != null) {
                f = e.a.a.b.b.a.f(1, this.ProductID) + 0;
            } else {
                f = 0;
            }
            if (this.ReqBuf != null) {
                f += e.a.a.a.ix(2, this.ReqBuf.computeSize());
            }
            AppMethodBeat.o(62560);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.ProductID == null) {
                bVar = new b("Not all required fields were included: ProductID");
                AppMethodBeat.o(62560);
                throw bVar;
            } else if (this.ReqBuf == null) {
                bVar = new b("Not all required fields were included: ReqBuf");
                AppMethodBeat.o(62560);
                throw bVar;
            } else {
                AppMethodBeat.o(62560);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ail ail = (ail) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ail.ProductID = aVar3.BTU.readString();
                    AppMethodBeat.o(62560);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        ail.ReqBuf = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(62560);
                    return 0;
                default:
                    AppMethodBeat.o(62560);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62560);
            return -1;
        }
    }
}
