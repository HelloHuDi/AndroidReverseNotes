package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public class BDStatusInfo extends a {
    public long favDBSize_;
    public long mmDBSize_;
    public int mmDBTableCount_;
    public long snsDBSize_;
    public LinkedList<TableInfo> tableList_ = new LinkedList();

    public BDStatusInfo() {
        AppMethodBeat.i(79146);
        AppMethodBeat.o(79146);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(79147);
        int o;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.mmDBSize_);
            aVar.ai(2, this.snsDBSize_);
            aVar.iz(3, this.mmDBTableCount_);
            aVar.e(4, 8, this.tableList_);
            aVar.ai(5, this.favDBSize_);
            AppMethodBeat.o(79147);
            return 0;
        } else if (i == 1) {
            o = ((((e.a.a.b.b.a.o(1, this.mmDBSize_) + 0) + e.a.a.b.b.a.o(2, this.snsDBSize_)) + e.a.a.b.b.a.bs(3, this.mmDBTableCount_)) + e.a.a.a.c(4, 8, this.tableList_)) + e.a.a.b.b.a.o(5, this.favDBSize_);
            AppMethodBeat.o(79147);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.tableList_.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(79147);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            BDStatusInfo bDStatusInfo = (BDStatusInfo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bDStatusInfo.mmDBSize_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79147);
                    return 0;
                case 2:
                    bDStatusInfo.snsDBSize_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79147);
                    return 0;
                case 3:
                    bDStatusInfo.mmDBTableCount_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79147);
                    return 0;
                case 4:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        TableInfo tableInfo = new TableInfo();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = tableInfo.populateBuilderWithField(aVar4, tableInfo, a.getNextFieldNumber(aVar4))) {
                        }
                        bDStatusInfo.tableList_.add(tableInfo);
                    }
                    AppMethodBeat.o(79147);
                    return 0;
                case 5:
                    bDStatusInfo.favDBSize_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79147);
                    return 0;
                default:
                    AppMethodBeat.o(79147);
                    return -1;
            }
        } else {
            AppMethodBeat.o(79147);
            return -1;
        }
    }
}
