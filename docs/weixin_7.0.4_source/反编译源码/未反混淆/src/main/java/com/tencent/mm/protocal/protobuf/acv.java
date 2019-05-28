package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class acv extends a {
    public String IconUrl;
    public String Name;
    public String fKh;
    public String mZt;
    public String wbw;
    public ade wkA;
    public int wkB;
    public String wkC;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(112420);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fKh == null) {
                bVar = new b("Not all required fields were included: AppId");
                AppMethodBeat.o(112420);
                throw bVar;
            } else if (this.Name == null) {
                bVar = new b("Not all required fields were included: Name");
                AppMethodBeat.o(112420);
                throw bVar;
            } else if (this.wbw == null) {
                bVar = new b("Not all required fields were included: Remark");
                AppMethodBeat.o(112420);
                throw bVar;
            } else if (this.IconUrl == null) {
                bVar = new b("Not all required fields were included: IconUrl");
                AppMethodBeat.o(112420);
                throw bVar;
            } else if (this.wkA == null) {
                bVar = new b("Not all required fields were included: DownloadInfo");
                AppMethodBeat.o(112420);
                throw bVar;
            } else {
                if (this.fKh != null) {
                    aVar.e(1, this.fKh);
                }
                if (this.Name != null) {
                    aVar.e(2, this.Name);
                }
                if (this.wbw != null) {
                    aVar.e(3, this.wbw);
                }
                if (this.IconUrl != null) {
                    aVar.e(4, this.IconUrl);
                }
                if (this.mZt != null) {
                    aVar.e(5, this.mZt);
                }
                if (this.wkA != null) {
                    aVar.iy(6, this.wkA.computeSize());
                    this.wkA.writeFields(aVar);
                }
                aVar.iz(7, this.wkB);
                if (this.wkC != null) {
                    aVar.e(8, this.wkC);
                }
                AppMethodBeat.o(112420);
                return 0;
            }
        } else if (i == 1) {
            if (this.fKh != null) {
                f = e.a.a.b.b.a.f(1, this.fKh) + 0;
            } else {
                f = 0;
            }
            if (this.Name != null) {
                f += e.a.a.b.b.a.f(2, this.Name);
            }
            if (this.wbw != null) {
                f += e.a.a.b.b.a.f(3, this.wbw);
            }
            if (this.IconUrl != null) {
                f += e.a.a.b.b.a.f(4, this.IconUrl);
            }
            if (this.mZt != null) {
                f += e.a.a.b.b.a.f(5, this.mZt);
            }
            if (this.wkA != null) {
                f += e.a.a.a.ix(6, this.wkA.computeSize());
            }
            f += e.a.a.b.b.a.bs(7, this.wkB);
            if (this.wkC != null) {
                f += e.a.a.b.b.a.f(8, this.wkC);
            }
            AppMethodBeat.o(112420);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.fKh == null) {
                bVar = new b("Not all required fields were included: AppId");
                AppMethodBeat.o(112420);
                throw bVar;
            } else if (this.Name == null) {
                bVar = new b("Not all required fields were included: Name");
                AppMethodBeat.o(112420);
                throw bVar;
            } else if (this.wbw == null) {
                bVar = new b("Not all required fields were included: Remark");
                AppMethodBeat.o(112420);
                throw bVar;
            } else if (this.IconUrl == null) {
                bVar = new b("Not all required fields were included: IconUrl");
                AppMethodBeat.o(112420);
                throw bVar;
            } else if (this.wkA == null) {
                bVar = new b("Not all required fields were included: DownloadInfo");
                AppMethodBeat.o(112420);
                throw bVar;
            } else {
                AppMethodBeat.o(112420);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            acv acv = (acv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    acv.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(112420);
                    return 0;
                case 2:
                    acv.Name = aVar3.BTU.readString();
                    AppMethodBeat.o(112420);
                    return 0;
                case 3:
                    acv.wbw = aVar3.BTU.readString();
                    AppMethodBeat.o(112420);
                    return 0;
                case 4:
                    acv.IconUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(112420);
                    return 0;
                case 5:
                    acv.mZt = aVar3.BTU.readString();
                    AppMethodBeat.o(112420);
                    return 0;
                case 6:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        ade ade = new ade();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ade.populateBuilderWithField(aVar4, ade, a.getNextFieldNumber(aVar4))) {
                        }
                        acv.wkA = ade;
                    }
                    AppMethodBeat.o(112420);
                    return 0;
                case 7:
                    acv.wkB = aVar3.BTU.vd();
                    AppMethodBeat.o(112420);
                    return 0;
                case 8:
                    acv.wkC = aVar3.BTU.readString();
                    AppMethodBeat.o(112420);
                    return 0;
                default:
                    AppMethodBeat.o(112420);
                    return -1;
            }
        } else {
            AppMethodBeat.o(112420);
            return -1;
        }
    }
}
