package com.tencent.p177mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.report.kvdata.WeChatSDInfo */
public class WeChatSDInfo extends C1331a {
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
        AppMethodBeat.m2504i(79156);
        AppMethodBeat.m2505o(79156);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(79157);
        int o;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13472ai(1, this.totalSize_);
            c6093a.mo13472ai(2, this.dirCount_);
            c6093a.mo13472ai(3, this.fileCount_);
            c6093a.mo13472ai(4, this.fileLenInvalidCount_);
            c6093a.mo13480iz(5, this.subDirResultsSize_);
            c6093a.mo13472ai(6, this.totalTime_);
            c6093a.mo13480iz(7, this.depth_);
            c6093a.mo13472ai(8, this.tempAccTotalSize_);
            c6093a.mo13480iz(9, this.tempAccDirResultsSize_);
            c6093a.mo13472ai(10, this.tempAccDirCount_);
            c6093a.mo13472ai(11, this.tempAccFileCount_);
            c6093a.mo13472ai(12, this.tempAccFileLenInvalidCount_);
            c6093a.mo13474e(13, 8, this.subDirList_);
            AppMethodBeat.m2505o(79157);
            return 0;
        } else if (i == 1) {
            o = ((((((((((((C6091a.m9578o(1, this.totalSize_) + 0) + C6091a.m9578o(2, this.dirCount_)) + C6091a.m9578o(3, this.fileCount_)) + C6091a.m9578o(4, this.fileLenInvalidCount_)) + C6091a.m9572bs(5, this.subDirResultsSize_)) + C6091a.m9578o(6, this.totalTime_)) + C6091a.m9572bs(7, this.depth_)) + C6091a.m9578o(8, this.tempAccTotalSize_)) + C6091a.m9572bs(9, this.tempAccDirResultsSize_)) + C6091a.m9578o(10, this.tempAccDirCount_)) + C6091a.m9578o(11, this.tempAccFileCount_)) + C6091a.m9578o(12, this.tempAccFileLenInvalidCount_)) + C6087a.m9552c(13, 8, this.subDirList_);
            AppMethodBeat.m2505o(79157);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.subDirList_.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(79157);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            WeChatSDInfo weChatSDInfo = (WeChatSDInfo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    weChatSDInfo.totalSize_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79157);
                    return 0;
                case 2:
                    weChatSDInfo.dirCount_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79157);
                    return 0;
                case 3:
                    weChatSDInfo.fileCount_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79157);
                    return 0;
                case 4:
                    weChatSDInfo.fileLenInvalidCount_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79157);
                    return 0;
                case 5:
                    weChatSDInfo.subDirResultsSize_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79157);
                    return 0;
                case 6:
                    weChatSDInfo.totalTime_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79157);
                    return 0;
                case 7:
                    weChatSDInfo.depth_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79157);
                    return 0;
                case 8:
                    weChatSDInfo.tempAccTotalSize_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79157);
                    return 0;
                case 9:
                    weChatSDInfo.tempAccDirResultsSize_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79157);
                    return 0;
                case 10:
                    weChatSDInfo.tempAccDirCount_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79157);
                    return 0;
                case 11:
                    weChatSDInfo.tempAccFileCount_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79157);
                    return 0;
                case 12:
                    weChatSDInfo.tempAccFileLenInvalidCount_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79157);
                    return 0;
                case 13:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SubDirInfo subDirInfo = new SubDirInfo();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = subDirInfo.populateBuilderWithField(c6086a3, subDirInfo, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        weChatSDInfo.subDirList_.add(subDirInfo);
                    }
                    AppMethodBeat.m2505o(79157);
                    return 0;
                default:
                    AppMethodBeat.m2505o(79157);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(79157);
            return -1;
        }
    }
}
