package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public class SDStatusInfo extends a {
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

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(79152);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.weChatSDInfo_ == null) {
                bVar = new b("Not all required fields were included: weChatSDInfo_");
                AppMethodBeat.o(79152);
                throw bVar;
            }
            if (this.weChatSDInfo_ != null) {
                aVar.iy(1, this.weChatSDInfo_.computeSize());
                this.weChatSDInfo_.writeFields(aVar);
            }
            aVar.iz(2, this.weChatPer_);
            aVar.iz(3, this.sizeHeavy_);
            aVar.iz(4, this.ratioHeavy_);
            aVar.iz(5, this.useExternal_);
            aVar.iz(6, this.hasUnRemovable_);
            aVar.ai(7, this.sBlockSize_);
            aVar.ai(8, this.sBlockCount_);
            aVar.ai(9, this.sTotalSize_);
            aVar.ai(10, this.sAvailableBlockCount_);
            aVar.ai(11, this.sAvailableSize_);
            aVar.iz(12, this.sAvailablePer_);
            aVar.ai(13, this.eBlockSize_);
            aVar.ai(14, this.eBlockCount_);
            aVar.ai(15, this.eTotalSize_);
            aVar.ai(16, this.eAvailableBlockCount_);
            aVar.ai(17, this.eAvailableSize_);
            aVar.iz(18, this.eAvailablePer_);
            if (this.ePath_ != null) {
                aVar.e(19, this.ePath_);
            }
            if (this.root_ != null) {
                aVar.e(20, this.root_);
            }
            if (this.fSystem_ != null) {
                aVar.e(21, this.fSystem_);
            }
            AppMethodBeat.o(79152);
            return 0;
        } else if (i == 1) {
            if (this.weChatSDInfo_ != null) {
                ix = e.a.a.a.ix(1, this.weChatSDInfo_.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((((((((((((((((ix + e.a.a.b.b.a.bs(2, this.weChatPer_)) + e.a.a.b.b.a.bs(3, this.sizeHeavy_)) + e.a.a.b.b.a.bs(4, this.ratioHeavy_)) + e.a.a.b.b.a.bs(5, this.useExternal_)) + e.a.a.b.b.a.bs(6, this.hasUnRemovable_)) + e.a.a.b.b.a.o(7, this.sBlockSize_)) + e.a.a.b.b.a.o(8, this.sBlockCount_)) + e.a.a.b.b.a.o(9, this.sTotalSize_)) + e.a.a.b.b.a.o(10, this.sAvailableBlockCount_)) + e.a.a.b.b.a.o(11, this.sAvailableSize_)) + e.a.a.b.b.a.bs(12, this.sAvailablePer_)) + e.a.a.b.b.a.o(13, this.eBlockSize_)) + e.a.a.b.b.a.o(14, this.eBlockCount_)) + e.a.a.b.b.a.o(15, this.eTotalSize_)) + e.a.a.b.b.a.o(16, this.eAvailableBlockCount_)) + e.a.a.b.b.a.o(17, this.eAvailableSize_)) + e.a.a.b.b.a.bs(18, this.eAvailablePer_);
            if (this.ePath_ != null) {
                ix += e.a.a.b.b.a.f(19, this.ePath_);
            }
            if (this.root_ != null) {
                ix += e.a.a.b.b.a.f(20, this.root_);
            }
            if (this.fSystem_ != null) {
                ix += e.a.a.b.b.a.f(21, this.fSystem_);
            }
            AppMethodBeat.o(79152);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.weChatSDInfo_ == null) {
                bVar = new b("Not all required fields were included: weChatSDInfo_");
                AppMethodBeat.o(79152);
                throw bVar;
            }
            AppMethodBeat.o(79152);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            SDStatusInfo sDStatusInfo = (SDStatusInfo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        WeChatSDInfo weChatSDInfo = new WeChatSDInfo();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = weChatSDInfo.populateBuilderWithField(aVar4, weChatSDInfo, a.getNextFieldNumber(aVar4))) {
                        }
                        sDStatusInfo.weChatSDInfo_ = weChatSDInfo;
                    }
                    AppMethodBeat.o(79152);
                    return 0;
                case 2:
                    sDStatusInfo.weChatPer_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79152);
                    return 0;
                case 3:
                    sDStatusInfo.sizeHeavy_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79152);
                    return 0;
                case 4:
                    sDStatusInfo.ratioHeavy_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79152);
                    return 0;
                case 5:
                    sDStatusInfo.useExternal_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79152);
                    return 0;
                case 6:
                    sDStatusInfo.hasUnRemovable_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79152);
                    return 0;
                case 7:
                    sDStatusInfo.sBlockSize_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79152);
                    return 0;
                case 8:
                    sDStatusInfo.sBlockCount_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79152);
                    return 0;
                case 9:
                    sDStatusInfo.sTotalSize_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79152);
                    return 0;
                case 10:
                    sDStatusInfo.sAvailableBlockCount_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79152);
                    return 0;
                case 11:
                    sDStatusInfo.sAvailableSize_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79152);
                    return 0;
                case 12:
                    sDStatusInfo.sAvailablePer_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79152);
                    return 0;
                case 13:
                    sDStatusInfo.eBlockSize_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79152);
                    return 0;
                case 14:
                    sDStatusInfo.eBlockCount_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79152);
                    return 0;
                case 15:
                    sDStatusInfo.eTotalSize_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79152);
                    return 0;
                case 16:
                    sDStatusInfo.eAvailableBlockCount_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79152);
                    return 0;
                case 17:
                    sDStatusInfo.eAvailableSize_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79152);
                    return 0;
                case 18:
                    sDStatusInfo.eAvailablePer_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79152);
                    return 0;
                case 19:
                    sDStatusInfo.ePath_ = aVar3.BTU.readString();
                    AppMethodBeat.o(79152);
                    return 0;
                case 20:
                    sDStatusInfo.root_ = aVar3.BTU.readString();
                    AppMethodBeat.o(79152);
                    return 0;
                case 21:
                    sDStatusInfo.fSystem_ = aVar3.BTU.readString();
                    AppMethodBeat.o(79152);
                    return 0;
                default:
                    AppMethodBeat.o(79152);
                    return -1;
            }
        } else {
            AppMethodBeat.o(79152);
            return -1;
        }
    }
}
