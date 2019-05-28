package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public class SubDirInfo extends a {
    public long dirCount_;
    public long fileCount_;
    public long fileLenInvalidCount;
    public int tag_;
    public long totalSize_;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(79153);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.tag_);
            aVar.ai(2, this.totalSize_);
            aVar.ai(3, this.dirCount_);
            aVar.ai(4, this.fileCount_);
            aVar.ai(5, this.fileLenInvalidCount);
            AppMethodBeat.o(79153);
            return 0;
        } else if (i == 1) {
            bs = ((((e.a.a.b.b.a.bs(1, this.tag_) + 0) + e.a.a.b.b.a.o(2, this.totalSize_)) + e.a.a.b.b.a.o(3, this.dirCount_)) + e.a.a.b.b.a.o(4, this.fileCount_)) + e.a.a.b.b.a.o(5, this.fileLenInvalidCount);
            AppMethodBeat.o(79153);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(79153);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            SubDirInfo subDirInfo = (SubDirInfo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    subDirInfo.tag_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79153);
                    return 0;
                case 2:
                    subDirInfo.totalSize_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79153);
                    return 0;
                case 3:
                    subDirInfo.dirCount_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79153);
                    return 0;
                case 4:
                    subDirInfo.fileCount_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79153);
                    return 0;
                case 5:
                    subDirInfo.fileLenInvalidCount = aVar3.BTU.ve();
                    AppMethodBeat.o(79153);
                    return 0;
                default:
                    AppMethodBeat.o(79153);
                    return -1;
            }
        } else {
            AppMethodBeat.o(79153);
            return -1;
        }
    }
}
