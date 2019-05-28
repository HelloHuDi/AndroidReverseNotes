package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class avj extends bsr {
    public String csB;
    public int kCo;
    public int scene;
    public String url;
    public String wzn;
    public String wzo;
    public int wzp;
    public int wzq;
    public String wzr;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96250);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.csB != null) {
                aVar.e(2, this.csB);
            }
            if (this.wzn != null) {
                aVar.e(3, this.wzn);
            }
            aVar.iz(4, this.scene);
            if (this.url != null) {
                aVar.e(5, this.url);
            }
            if (this.wzo != null) {
                aVar.e(6, this.wzo);
            }
            aVar.iz(7, this.kCo);
            aVar.iz(8, this.wzp);
            aVar.iz(9, this.wzq);
            if (this.wzr != null) {
                aVar.e(10, this.wzr);
            }
            AppMethodBeat.o(96250);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.csB != null) {
                ix += e.a.a.b.b.a.f(2, this.csB);
            }
            if (this.wzn != null) {
                ix += e.a.a.b.b.a.f(3, this.wzn);
            }
            ix += e.a.a.b.b.a.bs(4, this.scene);
            if (this.url != null) {
                ix += e.a.a.b.b.a.f(5, this.url);
            }
            if (this.wzo != null) {
                ix += e.a.a.b.b.a.f(6, this.wzo);
            }
            ix = ((ix + e.a.a.b.b.a.bs(7, this.kCo)) + e.a.a.b.b.a.bs(8, this.wzp)) + e.a.a.b.b.a.bs(9, this.wzq);
            if (this.wzr != null) {
                ix += e.a.a.b.b.a.f(10, this.wzr);
            }
            AppMethodBeat.o(96250);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96250);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            avj avj = (avj) objArr[1];
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
                        avj.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(96250);
                    return 0;
                case 2:
                    avj.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(96250);
                    return 0;
                case 3:
                    avj.wzn = aVar3.BTU.readString();
                    AppMethodBeat.o(96250);
                    return 0;
                case 4:
                    avj.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(96250);
                    return 0;
                case 5:
                    avj.url = aVar3.BTU.readString();
                    AppMethodBeat.o(96250);
                    return 0;
                case 6:
                    avj.wzo = aVar3.BTU.readString();
                    AppMethodBeat.o(96250);
                    return 0;
                case 7:
                    avj.kCo = aVar3.BTU.vd();
                    AppMethodBeat.o(96250);
                    return 0;
                case 8:
                    avj.wzp = aVar3.BTU.vd();
                    AppMethodBeat.o(96250);
                    return 0;
                case 9:
                    avj.wzq = aVar3.BTU.vd();
                    AppMethodBeat.o(96250);
                    return 0;
                case 10:
                    avj.wzr = aVar3.BTU.readString();
                    AppMethodBeat.o(96250);
                    return 0;
                default:
                    AppMethodBeat.o(96250);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96250);
            return -1;
        }
    }
}
