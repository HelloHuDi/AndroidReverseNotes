package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class aui extends a {
    public int cIf;
    public String wym;
    public String wyq;
    public String wyr;
    public String wys;
    public bid wyt;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48874);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wym == null) {
                bVar = new b("Not all required fields were included: session_data");
                AppMethodBeat.o(48874);
                throw bVar;
            }
            aVar.iz(1, this.cIf);
            if (this.wym != null) {
                aVar.e(2, this.wym);
            }
            if (this.wyq != null) {
                aVar.e(3, this.wyq);
            }
            if (this.wyr != null) {
                aVar.e(4, this.wyr);
            }
            if (this.wys != null) {
                aVar.e(5, this.wys);
            }
            if (this.wyt != null) {
                aVar.iy(6, this.wyt.computeSize());
                this.wyt.writeFields(aVar);
            }
            AppMethodBeat.o(48874);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.cIf) + 0;
            if (this.wym != null) {
                bs += e.a.a.b.b.a.f(2, this.wym);
            }
            if (this.wyq != null) {
                bs += e.a.a.b.b.a.f(3, this.wyq);
            }
            if (this.wyr != null) {
                bs += e.a.a.b.b.a.f(4, this.wyr);
            }
            if (this.wys != null) {
                bs += e.a.a.b.b.a.f(5, this.wys);
            }
            if (this.wyt != null) {
                bs += e.a.a.a.ix(6, this.wyt.computeSize());
            }
            AppMethodBeat.o(48874);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.wym == null) {
                bVar = new b("Not all required fields were included: session_data");
                AppMethodBeat.o(48874);
                throw bVar;
            }
            AppMethodBeat.o(48874);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aui aui = (aui) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aui.cIf = aVar3.BTU.vd();
                    AppMethodBeat.o(48874);
                    return 0;
                case 2:
                    aui.wym = aVar3.BTU.readString();
                    AppMethodBeat.o(48874);
                    return 0;
                case 3:
                    aui.wyq = aVar3.BTU.readString();
                    AppMethodBeat.o(48874);
                    return 0;
                case 4:
                    aui.wyr = aVar3.BTU.readString();
                    AppMethodBeat.o(48874);
                    return 0;
                case 5:
                    aui.wys = aVar3.BTU.readString();
                    AppMethodBeat.o(48874);
                    return 0;
                case 6:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bid bid = new bid();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bid.populateBuilderWithField(aVar4, bid, a.getNextFieldNumber(aVar4))) {
                        }
                        aui.wyt = bid;
                    }
                    AppMethodBeat.o(48874);
                    return 0;
                default:
                    AppMethodBeat.o(48874);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48874);
            return -1;
        }
    }
}
