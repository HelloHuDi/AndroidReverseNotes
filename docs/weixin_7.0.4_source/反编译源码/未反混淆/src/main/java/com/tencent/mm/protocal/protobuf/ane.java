package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ane extends bsr {
    public int Height;
    public String URL;
    public int Width;
    public String wrL;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10184);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.URL == null) {
                bVar = new b("Not all required fields were included: URL");
                AppMethodBeat.o(10184);
                throw bVar;
            } else if (this.wrL == null) {
                bVar = new b("Not all required fields were included: UserAgent");
                AppMethodBeat.o(10184);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.URL != null) {
                    aVar.e(2, this.URL);
                }
                if (this.wrL != null) {
                    aVar.e(3, this.wrL);
                }
                aVar.iz(4, this.Width);
                aVar.iz(5, this.Height);
                AppMethodBeat.o(10184);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.URL != null) {
                ix += e.a.a.b.b.a.f(2, this.URL);
            }
            if (this.wrL != null) {
                ix += e.a.a.b.b.a.f(3, this.wrL);
            }
            int bs = (ix + e.a.a.b.b.a.bs(4, this.Width)) + e.a.a.b.b.a.bs(5, this.Height);
            AppMethodBeat.o(10184);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.URL == null) {
                bVar = new b("Not all required fields were included: URL");
                AppMethodBeat.o(10184);
                throw bVar;
            } else if (this.wrL == null) {
                bVar = new b("Not all required fields were included: UserAgent");
                AppMethodBeat.o(10184);
                throw bVar;
            } else {
                AppMethodBeat.o(10184);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ane ane = (ane) objArr[1];
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
                        ane.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(10184);
                    return 0;
                case 2:
                    ane.URL = aVar3.BTU.readString();
                    AppMethodBeat.o(10184);
                    return 0;
                case 3:
                    ane.wrL = aVar3.BTU.readString();
                    AppMethodBeat.o(10184);
                    return 0;
                case 4:
                    ane.Width = aVar3.BTU.vd();
                    AppMethodBeat.o(10184);
                    return 0;
                case 5:
                    ane.Height = aVar3.BTU.vd();
                    AppMethodBeat.o(10184);
                    return 0;
                default:
                    AppMethodBeat.o(10184);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10184);
            return -1;
        }
    }
}
