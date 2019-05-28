package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class xr extends bsr {
    public String csB;
    public String key;
    public String query;
    public int scene;
    public String url;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96218);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.key != null) {
                aVar.e(2, this.key);
            }
            if (this.csB != null) {
                aVar.e(3, this.csB);
            }
            if (this.query != null) {
                aVar.e(4, this.query);
            }
            aVar.iz(5, this.scene);
            if (this.url != null) {
                aVar.e(6, this.url);
            }
            AppMethodBeat.o(96218);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.key != null) {
                ix += e.a.a.b.b.a.f(2, this.key);
            }
            if (this.csB != null) {
                ix += e.a.a.b.b.a.f(3, this.csB);
            }
            if (this.query != null) {
                ix += e.a.a.b.b.a.f(4, this.query);
            }
            ix += e.a.a.b.b.a.bs(5, this.scene);
            if (this.url != null) {
                ix += e.a.a.b.b.a.f(6, this.url);
            }
            AppMethodBeat.o(96218);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96218);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            xr xrVar = (xr) objArr[1];
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
                        xrVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(96218);
                    return 0;
                case 2:
                    xrVar.key = aVar3.BTU.readString();
                    AppMethodBeat.o(96218);
                    return 0;
                case 3:
                    xrVar.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(96218);
                    return 0;
                case 4:
                    xrVar.query = aVar3.BTU.readString();
                    AppMethodBeat.o(96218);
                    return 0;
                case 5:
                    xrVar.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(96218);
                    return 0;
                case 6:
                    xrVar.url = aVar3.BTU.readString();
                    AppMethodBeat.o(96218);
                    return 0;
                default:
                    AppMethodBeat.o(96218);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96218);
            return -1;
        }
    }
}
