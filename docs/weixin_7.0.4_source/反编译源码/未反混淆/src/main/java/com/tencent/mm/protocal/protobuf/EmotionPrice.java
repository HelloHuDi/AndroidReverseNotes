package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public class EmotionPrice extends a {
    public String IapProductId;
    public String Label;
    public String Number;
    public String Type;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62543);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Label == null) {
                bVar = new b("Not all required fields were included: Label");
                AppMethodBeat.o(62543);
                throw bVar;
            } else if (this.Number == null) {
                bVar = new b("Not all required fields were included: Number");
                AppMethodBeat.o(62543);
                throw bVar;
            } else if (this.Type == null) {
                bVar = new b("Not all required fields were included: Type");
                AppMethodBeat.o(62543);
                throw bVar;
            } else {
                if (this.Label != null) {
                    aVar.e(1, this.Label);
                }
                if (this.Number != null) {
                    aVar.e(2, this.Number);
                }
                if (this.Type != null) {
                    aVar.e(3, this.Type);
                }
                if (this.IapProductId != null) {
                    aVar.e(4, this.IapProductId);
                }
                AppMethodBeat.o(62543);
                return 0;
            }
        } else if (i == 1) {
            if (this.Label != null) {
                f = e.a.a.b.b.a.f(1, this.Label) + 0;
            } else {
                f = 0;
            }
            if (this.Number != null) {
                f += e.a.a.b.b.a.f(2, this.Number);
            }
            if (this.Type != null) {
                f += e.a.a.b.b.a.f(3, this.Type);
            }
            if (this.IapProductId != null) {
                f += e.a.a.b.b.a.f(4, this.IapProductId);
            }
            AppMethodBeat.o(62543);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.Label == null) {
                bVar = new b("Not all required fields were included: Label");
                AppMethodBeat.o(62543);
                throw bVar;
            } else if (this.Number == null) {
                bVar = new b("Not all required fields were included: Number");
                AppMethodBeat.o(62543);
                throw bVar;
            } else if (this.Type == null) {
                bVar = new b("Not all required fields were included: Type");
                AppMethodBeat.o(62543);
                throw bVar;
            } else {
                AppMethodBeat.o(62543);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            EmotionPrice emotionPrice = (EmotionPrice) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    emotionPrice.Label = aVar3.BTU.readString();
                    AppMethodBeat.o(62543);
                    return 0;
                case 2:
                    emotionPrice.Number = aVar3.BTU.readString();
                    AppMethodBeat.o(62543);
                    return 0;
                case 3:
                    emotionPrice.Type = aVar3.BTU.readString();
                    AppMethodBeat.o(62543);
                    return 0;
                case 4:
                    emotionPrice.IapProductId = aVar3.BTU.readString();
                    AppMethodBeat.o(62543);
                    return 0;
                default:
                    AppMethodBeat.o(62543);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62543);
            return -1;
        }
    }
}
