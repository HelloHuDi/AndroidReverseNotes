package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class mf extends a {
    public String Desc;
    public String ThumbUrl;
    public String Title;
    public mi vPY;
    public mj vPZ;
    public mc vQa;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124292);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(124292);
                throw bVar;
            } else if (this.Desc == null) {
                bVar = new b("Not all required fields were included: Desc");
                AppMethodBeat.o(124292);
                throw bVar;
            } else if (this.ThumbUrl == null) {
                bVar = new b("Not all required fields were included: ThumbUrl");
                AppMethodBeat.o(124292);
                throw bVar;
            } else if (this.vPY == null) {
                bVar = new b("Not all required fields were included: DetailInfo");
                AppMethodBeat.o(124292);
                throw bVar;
            } else if (this.vQa == null) {
                bVar = new b("Not all required fields were included: ActionInfo");
                AppMethodBeat.o(124292);
                throw bVar;
            } else {
                if (this.Title != null) {
                    aVar.e(1, this.Title);
                }
                if (this.Desc != null) {
                    aVar.e(2, this.Desc);
                }
                if (this.ThumbUrl != null) {
                    aVar.e(3, this.ThumbUrl);
                }
                if (this.vPY != null) {
                    aVar.iy(4, this.vPY.computeSize());
                    this.vPY.writeFields(aVar);
                }
                if (this.vPZ != null) {
                    aVar.iy(5, this.vPZ.computeSize());
                    this.vPZ.writeFields(aVar);
                }
                if (this.vQa != null) {
                    aVar.iy(6, this.vQa.computeSize());
                    this.vQa.writeFields(aVar);
                }
                AppMethodBeat.o(124292);
                return 0;
            }
        } else if (i == 1) {
            if (this.Title != null) {
                f = e.a.a.b.b.a.f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            if (this.Desc != null) {
                f += e.a.a.b.b.a.f(2, this.Desc);
            }
            if (this.ThumbUrl != null) {
                f += e.a.a.b.b.a.f(3, this.ThumbUrl);
            }
            if (this.vPY != null) {
                f += e.a.a.a.ix(4, this.vPY.computeSize());
            }
            if (this.vPZ != null) {
                f += e.a.a.a.ix(5, this.vPZ.computeSize());
            }
            if (this.vQa != null) {
                f += e.a.a.a.ix(6, this.vQa.computeSize());
            }
            AppMethodBeat.o(124292);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(124292);
                throw bVar;
            } else if (this.Desc == null) {
                bVar = new b("Not all required fields were included: Desc");
                AppMethodBeat.o(124292);
                throw bVar;
            } else if (this.ThumbUrl == null) {
                bVar = new b("Not all required fields were included: ThumbUrl");
                AppMethodBeat.o(124292);
                throw bVar;
            } else if (this.vPY == null) {
                bVar = new b("Not all required fields were included: DetailInfo");
                AppMethodBeat.o(124292);
                throw bVar;
            } else if (this.vQa == null) {
                bVar = new b("Not all required fields were included: ActionInfo");
                AppMethodBeat.o(124292);
                throw bVar;
            } else {
                AppMethodBeat.o(124292);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            mf mfVar = (mf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    mfVar.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(124292);
                    return 0;
                case 2:
                    mfVar.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(124292);
                    return 0;
                case 3:
                    mfVar.ThumbUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(124292);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mi miVar = new mi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = miVar.populateBuilderWithField(aVar4, miVar, a.getNextFieldNumber(aVar4))) {
                        }
                        mfVar.vPY = miVar;
                    }
                    AppMethodBeat.o(124292);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mj mjVar = new mj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mjVar.populateBuilderWithField(aVar4, mjVar, a.getNextFieldNumber(aVar4))) {
                        }
                        mfVar.vPZ = mjVar;
                    }
                    AppMethodBeat.o(124292);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mc mcVar = new mc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mcVar.populateBuilderWithField(aVar4, mcVar, a.getNextFieldNumber(aVar4))) {
                        }
                        mfVar.vQa = mcVar;
                    }
                    AppMethodBeat.o(124292);
                    return 0;
                default:
                    AppMethodBeat.o(124292);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124292);
            return -1;
        }
    }
}
