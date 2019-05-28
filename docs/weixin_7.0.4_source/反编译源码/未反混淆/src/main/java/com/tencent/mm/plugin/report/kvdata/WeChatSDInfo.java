package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public class WeChatSDInfo extends a {
    public int depth_;
    public long dirCount_;
    public long fileCount_;
    public long fileLenInvalidCount_;
    public LinkedList<SubDirInfo> subDirList_ = new LinkedList();
    public int subDirResultsSize_;
    public long tempAccDirCount_;
    public int tempAccDirResultsSize_;
    public long tempAccFileCount_;
    public long tempAccFileLenInvalidCount_;
    public long tempAccTotalSize_;
    public long totalSize_;
    public long totalTime_;

    public WeChatSDInfo() {
        AppMethodBeat.i(79156);
        AppMethodBeat.o(79156);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(79157);
        int o;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.totalSize_);
            aVar.ai(2, this.dirCount_);
            aVar.ai(3, this.fileCount_);
            aVar.ai(4, this.fileLenInvalidCount_);
            aVar.iz(5, this.subDirResultsSize_);
            aVar.ai(6, this.totalTime_);
            aVar.iz(7, this.depth_);
            aVar.ai(8, this.tempAccTotalSize_);
            aVar.iz(9, this.tempAccDirResultsSize_);
            aVar.ai(10, this.tempAccDirCount_);
            aVar.ai(11, this.tempAccFileCount_);
            aVar.ai(12, this.tempAccFileLenInvalidCount_);
            aVar.e(13, 8, this.subDirList_);
            AppMethodBeat.o(79157);
            return 0;
        } else if (i == 1) {
            o = ((((((((((((e.a.a.b.b.a.o(1, this.totalSize_) + 0) + e.a.a.b.b.a.o(2, this.dirCount_)) + e.a.a.b.b.a.o(3, this.fileCount_)) + e.a.a.b.b.a.o(4, this.fileLenInvalidCount_)) + e.a.a.b.b.a.bs(5, this.subDirResultsSize_)) + e.a.a.b.b.a.o(6, this.totalTime_)) + e.a.a.b.b.a.bs(7, this.depth_)) + e.a.a.b.b.a.o(8, this.tempAccTotalSize_)) + e.a.a.b.b.a.bs(9, this.tempAccDirResultsSize_)) + e.a.a.b.b.a.o(10, this.tempAccDirCount_)) + e.a.a.b.b.a.o(11, this.tempAccFileCount_)) + e.a.a.b.b.a.o(12, this.tempAccFileLenInvalidCount_)) + e.a.a.a.c(13, 8, this.subDirList_);
            AppMethodBeat.o(79157);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.subDirList_.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(79157);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            WeChatSDInfo weChatSDInfo = (WeChatSDInfo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    weChatSDInfo.totalSize_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79157);
                    return 0;
                case 2:
                    weChatSDInfo.dirCount_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79157);
                    return 0;
                case 3:
                    weChatSDInfo.fileCount_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79157);
                    return 0;
                case 4:
                    weChatSDInfo.fileLenInvalidCount_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79157);
                    return 0;
                case 5:
                    weChatSDInfo.subDirResultsSize_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79157);
                    return 0;
                case 6:
                    weChatSDInfo.totalTime_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79157);
                    return 0;
                case 7:
                    weChatSDInfo.depth_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79157);
                    return 0;
                case 8:
                    weChatSDInfo.tempAccTotalSize_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79157);
                    return 0;
                case 9:
                    weChatSDInfo.tempAccDirResultsSize_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79157);
                    return 0;
                case 10:
                    weChatSDInfo.tempAccDirCount_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79157);
                    return 0;
                case 11:
                    weChatSDInfo.tempAccFileCount_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79157);
                    return 0;
                case 12:
                    weChatSDInfo.tempAccFileLenInvalidCount_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79157);
                    return 0;
                case 13:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SubDirInfo subDirInfo = new SubDirInfo();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = subDirInfo.populateBuilderWithField(aVar4, subDirInfo, a.getNextFieldNumber(aVar4))) {
                        }
                        weChatSDInfo.subDirList_.add(subDirInfo);
                    }
                    AppMethodBeat.o(79157);
                    return 0;
                default:
                    AppMethodBeat.o(79157);
                    return -1;
            }
        } else {
            AppMethodBeat.o(79157);
            return -1;
        }
    }
}
