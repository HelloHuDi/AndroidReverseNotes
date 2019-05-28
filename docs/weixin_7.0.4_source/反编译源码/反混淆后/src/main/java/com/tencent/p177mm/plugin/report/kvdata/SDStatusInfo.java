package com.tencent.p177mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.report.kvdata.SDStatusInfo */
public class SDStatusInfo extends C1331a {
    public long eAvailableBlockCount_;
    public int eAvailablePer_;
    public long eAvailableSize_;
    public long eBlockCount_;
    public long eBlockSize_;
    public String ePath_;
    public long eTotalSize_;
    public String fSystem_;
    public int hasUnRemovable_;
    public int ratioHeavy_;
    public String root_;
    public long sAvailableBlockCount_;
    public int sAvailablePer_;
    public long sAvailableSize_;
    public long sBlockCount_;
    public long sBlockSize_;
    public long sTotalSize_;
    public int sizeHeavy_;
    public int useExternal_;
    public int weChatPer_;
    public WeChatSDInfo weChatSDInfo_;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(79152);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.weChatSDInfo_ == null) {
                c6092b = new C6092b("Not all required fields were included: weChatSDInfo_");
                AppMethodBeat.m2505o(79152);
                throw c6092b;
            }
            if (this.weChatSDInfo_ != null) {
                c6093a.mo13479iy(1, this.weChatSDInfo_.computeSize());
                this.weChatSDInfo_.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.weChatPer_);
            c6093a.mo13480iz(3, this.sizeHeavy_);
            c6093a.mo13480iz(4, this.ratioHeavy_);
            c6093a.mo13480iz(5, this.useExternal_);
            c6093a.mo13480iz(6, this.hasUnRemovable_);
            c6093a.mo13472ai(7, this.sBlockSize_);
            c6093a.mo13472ai(8, this.sBlockCount_);
            c6093a.mo13472ai(9, this.sTotalSize_);
            c6093a.mo13472ai(10, this.sAvailableBlockCount_);
            c6093a.mo13472ai(11, this.sAvailableSize_);
            c6093a.mo13480iz(12, this.sAvailablePer_);
            c6093a.mo13472ai(13, this.eBlockSize_);
            c6093a.mo13472ai(14, this.eBlockCount_);
            c6093a.mo13472ai(15, this.eTotalSize_);
            c6093a.mo13472ai(16, this.eAvailableBlockCount_);
            c6093a.mo13472ai(17, this.eAvailableSize_);
            c6093a.mo13480iz(18, this.eAvailablePer_);
            if (this.ePath_ != null) {
                c6093a.mo13475e(19, this.ePath_);
            }
            if (this.root_ != null) {
                c6093a.mo13475e(20, this.root_);
            }
            if (this.fSystem_ != null) {
                c6093a.mo13475e(21, this.fSystem_);
            }
            AppMethodBeat.m2505o(79152);
            return 0;
        } else if (i == 1) {
            if (this.weChatSDInfo_ != null) {
                ix = C6087a.m9557ix(1, this.weChatSDInfo_.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((((((((((((((((ix + C6091a.m9572bs(2, this.weChatPer_)) + C6091a.m9572bs(3, this.sizeHeavy_)) + C6091a.m9572bs(4, this.ratioHeavy_)) + C6091a.m9572bs(5, this.useExternal_)) + C6091a.m9572bs(6, this.hasUnRemovable_)) + C6091a.m9578o(7, this.sBlockSize_)) + C6091a.m9578o(8, this.sBlockCount_)) + C6091a.m9578o(9, this.sTotalSize_)) + C6091a.m9578o(10, this.sAvailableBlockCount_)) + C6091a.m9578o(11, this.sAvailableSize_)) + C6091a.m9572bs(12, this.sAvailablePer_)) + C6091a.m9578o(13, this.eBlockSize_)) + C6091a.m9578o(14, this.eBlockCount_)) + C6091a.m9578o(15, this.eTotalSize_)) + C6091a.m9578o(16, this.eAvailableBlockCount_)) + C6091a.m9578o(17, this.eAvailableSize_)) + C6091a.m9572bs(18, this.eAvailablePer_);
            if (this.ePath_ != null) {
                ix += C6091a.m9575f(19, this.ePath_);
            }
            if (this.root_ != null) {
                ix += C6091a.m9575f(20, this.root_);
            }
            if (this.fSystem_ != null) {
                ix += C6091a.m9575f(21, this.fSystem_);
            }
            AppMethodBeat.m2505o(79152);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.weChatSDInfo_ == null) {
                c6092b = new C6092b("Not all required fields were included: weChatSDInfo_");
                AppMethodBeat.m2505o(79152);
                throw c6092b;
            }
            AppMethodBeat.m2505o(79152);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            SDStatusInfo sDStatusInfo = (SDStatusInfo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        WeChatSDInfo weChatSDInfo = new WeChatSDInfo();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = weChatSDInfo.populateBuilderWithField(c6086a3, weChatSDInfo, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        sDStatusInfo.weChatSDInfo_ = weChatSDInfo;
                    }
                    AppMethodBeat.m2505o(79152);
                    return 0;
                case 2:
                    sDStatusInfo.weChatPer_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79152);
                    return 0;
                case 3:
                    sDStatusInfo.sizeHeavy_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79152);
                    return 0;
                case 4:
                    sDStatusInfo.ratioHeavy_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79152);
                    return 0;
                case 5:
                    sDStatusInfo.useExternal_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79152);
                    return 0;
                case 6:
                    sDStatusInfo.hasUnRemovable_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79152);
                    return 0;
                case 7:
                    sDStatusInfo.sBlockSize_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79152);
                    return 0;
                case 8:
                    sDStatusInfo.sBlockCount_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79152);
                    return 0;
                case 9:
                    sDStatusInfo.sTotalSize_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79152);
                    return 0;
                case 10:
                    sDStatusInfo.sAvailableBlockCount_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79152);
                    return 0;
                case 11:
                    sDStatusInfo.sAvailableSize_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79152);
                    return 0;
                case 12:
                    sDStatusInfo.sAvailablePer_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79152);
                    return 0;
                case 13:
                    sDStatusInfo.eBlockSize_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79152);
                    return 0;
                case 14:
                    sDStatusInfo.eBlockCount_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79152);
                    return 0;
                case 15:
                    sDStatusInfo.eTotalSize_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79152);
                    return 0;
                case 16:
                    sDStatusInfo.eAvailableBlockCount_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79152);
                    return 0;
                case 17:
                    sDStatusInfo.eAvailableSize_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79152);
                    return 0;
                case 18:
                    sDStatusInfo.eAvailablePer_ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79152);
                    return 0;
                case 19:
                    sDStatusInfo.ePath_ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(79152);
                    return 0;
                case 20:
                    sDStatusInfo.root_ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(79152);
                    return 0;
                case 21:
                    sDStatusInfo.fSystem_ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(79152);
                    return 0;
                default:
                    AppMethodBeat.m2505o(79152);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(79152);
            return -1;
        }
    }
}
