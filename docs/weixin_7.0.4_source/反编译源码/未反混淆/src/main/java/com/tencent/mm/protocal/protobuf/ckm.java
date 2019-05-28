package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ckm extends bsr {
    public int boZ;
    public int scene;
    public String session_id;
    public String username;
    public int vOO;
    public int xiq;
    public int xir;
    public int xis;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96304);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.scene);
            aVar.iz(3, this.xiq);
            aVar.iz(4, this.vOO);
            aVar.iz(5, this.xir);
            aVar.iz(6, this.xis);
            if (this.username != null) {
                aVar.e(7, this.username);
            }
            aVar.iz(8, this.boZ);
            if (this.session_id != null) {
                aVar.e(9, this.session_id);
            }
            AppMethodBeat.o(96304);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((((ix + e.a.a.b.b.a.bs(2, this.scene)) + e.a.a.b.b.a.bs(3, this.xiq)) + e.a.a.b.b.a.bs(4, this.vOO)) + e.a.a.b.b.a.bs(5, this.xir)) + e.a.a.b.b.a.bs(6, this.xis);
            if (this.username != null) {
                ix += e.a.a.b.b.a.f(7, this.username);
            }
            ix += e.a.a.b.b.a.bs(8, this.boZ);
            if (this.session_id != null) {
                ix += e.a.a.b.b.a.f(9, this.session_id);
            }
            AppMethodBeat.o(96304);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96304);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ckm ckm = (ckm) objArr[1];
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
                        ckm.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(96304);
                    return 0;
                case 2:
                    ckm.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(96304);
                    return 0;
                case 3:
                    ckm.xiq = aVar3.BTU.vd();
                    AppMethodBeat.o(96304);
                    return 0;
                case 4:
                    ckm.vOO = aVar3.BTU.vd();
                    AppMethodBeat.o(96304);
                    return 0;
                case 5:
                    ckm.xir = aVar3.BTU.vd();
                    AppMethodBeat.o(96304);
                    return 0;
                case 6:
                    ckm.xis = aVar3.BTU.vd();
                    AppMethodBeat.o(96304);
                    return 0;
                case 7:
                    ckm.username = aVar3.BTU.readString();
                    AppMethodBeat.o(96304);
                    return 0;
                case 8:
                    ckm.boZ = aVar3.BTU.vd();
                    AppMethodBeat.o(96304);
                    return 0;
                case 9:
                    ckm.session_id = aVar3.BTU.readString();
                    AppMethodBeat.o(96304);
                    return 0;
                default:
                    AppMethodBeat.o(96304);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96304);
            return -1;
        }
    }
}
