package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public class TableInfo extends a {
    public long count_;
    public String name_;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(79154);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.name_ == null) {
                bVar = new b("Not all required fields were included: name_");
                AppMethodBeat.o(79154);
                throw bVar;
            }
            if (this.name_ != null) {
                aVar.e(1, this.name_);
            }
            aVar.ai(2, this.count_);
            AppMethodBeat.o(79154);
            return 0;
        } else if (i == 1) {
            if (this.name_ != null) {
                f = e.a.a.b.b.a.f(1, this.name_) + 0;
            } else {
                f = 0;
            }
            int o = f + e.a.a.b.b.a.o(2, this.count_);
            AppMethodBeat.o(79154);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.name_ == null) {
                bVar = new b("Not all required fields were included: name_");
                AppMethodBeat.o(79154);
                throw bVar;
            }
            AppMethodBeat.o(79154);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            TableInfo tableInfo = (TableInfo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tableInfo.name_ = aVar3.BTU.readString();
                    AppMethodBeat.o(79154);
                    return 0;
                case 2:
                    tableInfo.count_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79154);
                    return 0;
                default:
                    AppMethodBeat.o(79154);
                    return -1;
            }
        } else {
            AppMethodBeat.o(79154);
            return -1;
        }
    }
}
