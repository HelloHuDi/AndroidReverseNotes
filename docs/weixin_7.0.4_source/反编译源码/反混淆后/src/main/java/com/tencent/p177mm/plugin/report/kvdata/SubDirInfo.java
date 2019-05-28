package com.tencent.p177mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.report.kvdata.SubDirInfo */
public class SubDirInfo extends C1331a {
    public long dirCount_;
    public long fileCount_;
    public long fileLenInvalidCount;
    public int tag_;
    public long totalSize_;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(79153);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.tag_);
            c6093a.mo13472ai(2, this.totalSize_);
            c6093a.mo13472ai(3, this.dirCount_);
            c6093a.mo13472ai(4, this.fileCount_);
            c6093a.mo13472ai(5, this.fileLenInvalidCount);
            AppMethodBeat.m2505o(79153);
            return 0;
        } else if (i == 1) {
            bs = ((((C6091a.m9572bs(1, this.tag_) + 0) + C6091a.m9578o(2, this.totalSize_)) + C6091a.m9578o(3, this.dirCount_)) + C6091a.m9578o(4, this.fileCount_)) + C6091a.m9578o(5, this.fileLenInvalidCount);
            AppMethodBeat.m2505o(79153);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(79153);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            SubDirInfo subDirInfo = (SubDirInfo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    subDirInfo.tag_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79153);
                    return 0;
                case 2:
                    subDirInfo.totalSize_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79153);
                    return 0;
                case 3:
                    subDirInfo.dirCount_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79153);
                    return 0;
                case 4:
                    subDirInfo.fileCount_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79153);
                    return 0;
                case 5:
                    subDirInfo.fileLenInvalidCount = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79153);
                    return 0;
                default:
                    AppMethodBeat.m2505o(79153);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(79153);
            return -1;
        }
    }
}
