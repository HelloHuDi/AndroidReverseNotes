package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class gk extends a {
    public String csB;
    public String username;
    public int vIG;
    public ble vIH;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(114949);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            aVar.iz(2, this.vIG);
            if (this.vIH != null) {
                aVar.iy(3, this.vIH.computeSize());
                this.vIH.writeFields(aVar);
            }
            if (this.csB != null) {
                aVar.e(10, this.csB);
            }
            AppMethodBeat.o(114949);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                f = e.a.a.b.b.a.f(1, this.username) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.vIG);
            if (this.vIH != null) {
                f += e.a.a.a.ix(3, this.vIH.computeSize());
            }
            if (this.csB != null) {
                f += e.a.a.b.b.a.f(10, this.csB);
            }
            AppMethodBeat.o(114949);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(114949);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            gk gkVar = (gk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    gkVar.username = aVar3.BTU.readString();
                    AppMethodBeat.o(114949);
                    return 0;
                case 2:
                    gkVar.vIG = aVar3.BTU.vd();
                    AppMethodBeat.o(114949);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        ble ble = new ble();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ble.populateBuilderWithField(aVar4, ble, a.getNextFieldNumber(aVar4))) {
                        }
                        gkVar.vIH = ble;
                    }
                    AppMethodBeat.o(114949);
                    return 0;
                case 10:
                    gkVar.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(114949);
                    return 0;
                default:
                    AppMethodBeat.o(114949);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114949);
            return -1;
        }
    }
}
