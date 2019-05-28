package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aea extends bsr {
    public int count;
    public String csB;
    public String desc;
    public int scene;
    public String sign;
    public int wlY;
    public int wlZ;
    public String wma;
    public String wmb;
    public String wmc;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48843);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.csB == null) {
                bVar = new b("Not all required fields were included: appid");
                AppMethodBeat.o(48843);
                throw bVar;
            } else if (this.wmb == null) {
                bVar = new b("Not all required fields were included: busi_id");
                AppMethodBeat.o(48843);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                aVar.iz(2, this.wlY);
                if (this.csB != null) {
                    aVar.e(3, this.csB);
                }
                if (this.desc != null) {
                    aVar.e(4, this.desc);
                }
                aVar.iz(5, this.wlZ);
                if (this.wma != null) {
                    aVar.e(6, this.wma);
                }
                aVar.iz(7, this.count);
                aVar.iz(8, this.scene);
                if (this.wmb != null) {
                    aVar.e(9, this.wmb);
                }
                if (this.sign != null) {
                    aVar.e(10, this.sign);
                }
                if (this.wmc != null) {
                    aVar.e(11, this.wmc);
                }
                AppMethodBeat.o(48843);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.wlY);
            if (this.csB != null) {
                ix += e.a.a.b.b.a.f(3, this.csB);
            }
            if (this.desc != null) {
                ix += e.a.a.b.b.a.f(4, this.desc);
            }
            ix += e.a.a.b.b.a.bs(5, this.wlZ);
            if (this.wma != null) {
                ix += e.a.a.b.b.a.f(6, this.wma);
            }
            ix = (ix + e.a.a.b.b.a.bs(7, this.count)) + e.a.a.b.b.a.bs(8, this.scene);
            if (this.wmb != null) {
                ix += e.a.a.b.b.a.f(9, this.wmb);
            }
            if (this.sign != null) {
                ix += e.a.a.b.b.a.f(10, this.sign);
            }
            if (this.wmc != null) {
                ix += e.a.a.b.b.a.f(11, this.wmc);
            }
            AppMethodBeat.o(48843);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.csB == null) {
                bVar = new b("Not all required fields were included: appid");
                AppMethodBeat.o(48843);
                throw bVar;
            } else if (this.wmb == null) {
                bVar = new b("Not all required fields were included: busi_id");
                AppMethodBeat.o(48843);
                throw bVar;
            } else {
                AppMethodBeat.o(48843);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aea aea = (aea) objArr[1];
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
                        aea.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(48843);
                    return 0;
                case 2:
                    aea.wlY = aVar3.BTU.vd();
                    AppMethodBeat.o(48843);
                    return 0;
                case 3:
                    aea.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(48843);
                    return 0;
                case 4:
                    aea.desc = aVar3.BTU.readString();
                    AppMethodBeat.o(48843);
                    return 0;
                case 5:
                    aea.wlZ = aVar3.BTU.vd();
                    AppMethodBeat.o(48843);
                    return 0;
                case 6:
                    aea.wma = aVar3.BTU.readString();
                    AppMethodBeat.o(48843);
                    return 0;
                case 7:
                    aea.count = aVar3.BTU.vd();
                    AppMethodBeat.o(48843);
                    return 0;
                case 8:
                    aea.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(48843);
                    return 0;
                case 9:
                    aea.wmb = aVar3.BTU.readString();
                    AppMethodBeat.o(48843);
                    return 0;
                case 10:
                    aea.sign = aVar3.BTU.readString();
                    AppMethodBeat.o(48843);
                    return 0;
                case 11:
                    aea.wmc = aVar3.BTU.readString();
                    AppMethodBeat.o(48843);
                    return 0;
                default:
                    AppMethodBeat.o(48843);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48843);
            return -1;
        }
    }
}
