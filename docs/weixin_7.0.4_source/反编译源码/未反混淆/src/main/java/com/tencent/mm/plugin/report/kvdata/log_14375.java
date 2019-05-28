package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public class log_14375 extends a {
    public int clientVersion_;
    public BDStatusInfo dbStatusInfo_;
    public int device_;
    public int ds_;
    public HeavyDetailInfo heavyDetailInfo_;
    public int import_ds_;
    public SDStatusInfo sdStatusInfo_;
    public long time_stamp_;
    public int type_;
    public long uin_;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(79163);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.import_ds_);
            aVar.iz(2, this.ds_);
            aVar.ai(3, this.uin_);
            aVar.iz(4, this.device_);
            aVar.iz(5, this.clientVersion_);
            aVar.ai(6, this.time_stamp_);
            aVar.iz(7, this.type_);
            if (this.dbStatusInfo_ != null) {
                aVar.iy(8, this.dbStatusInfo_.computeSize());
                this.dbStatusInfo_.writeFields(aVar);
            }
            if (this.sdStatusInfo_ != null) {
                aVar.iy(9, this.sdStatusInfo_.computeSize());
                this.sdStatusInfo_.writeFields(aVar);
            }
            if (this.heavyDetailInfo_ != null) {
                aVar.iy(10, this.heavyDetailInfo_.computeSize());
                this.heavyDetailInfo_.writeFields(aVar);
            }
            AppMethodBeat.o(79163);
            return 0;
        } else if (i == 1) {
            bs = ((((((e.a.a.b.b.a.bs(1, this.import_ds_) + 0) + e.a.a.b.b.a.bs(2, this.ds_)) + e.a.a.b.b.a.o(3, this.uin_)) + e.a.a.b.b.a.bs(4, this.device_)) + e.a.a.b.b.a.bs(5, this.clientVersion_)) + e.a.a.b.b.a.o(6, this.time_stamp_)) + e.a.a.b.b.a.bs(7, this.type_);
            if (this.dbStatusInfo_ != null) {
                bs += e.a.a.a.ix(8, this.dbStatusInfo_.computeSize());
            }
            if (this.sdStatusInfo_ != null) {
                bs += e.a.a.a.ix(9, this.sdStatusInfo_.computeSize());
            }
            if (this.heavyDetailInfo_ != null) {
                bs += e.a.a.a.ix(10, this.heavyDetailInfo_.computeSize());
            }
            AppMethodBeat.o(79163);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(79163);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            log_14375 log_14375 = (log_14375) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    log_14375.import_ds_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79163);
                    return 0;
                case 2:
                    log_14375.ds_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79163);
                    return 0;
                case 3:
                    log_14375.uin_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79163);
                    return 0;
                case 4:
                    log_14375.device_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79163);
                    return 0;
                case 5:
                    log_14375.clientVersion_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79163);
                    return 0;
                case 6:
                    log_14375.time_stamp_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79163);
                    return 0;
                case 7:
                    log_14375.type_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79163);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BDStatusInfo bDStatusInfo = new BDStatusInfo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bDStatusInfo.populateBuilderWithField(aVar4, bDStatusInfo, a.getNextFieldNumber(aVar4))) {
                        }
                        log_14375.dbStatusInfo_ = bDStatusInfo;
                    }
                    AppMethodBeat.o(79163);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SDStatusInfo sDStatusInfo = new SDStatusInfo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sDStatusInfo.populateBuilderWithField(aVar4, sDStatusInfo, a.getNextFieldNumber(aVar4))) {
                        }
                        log_14375.sdStatusInfo_ = sDStatusInfo;
                    }
                    AppMethodBeat.o(79163);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        HeavyDetailInfo heavyDetailInfo = new HeavyDetailInfo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = heavyDetailInfo.populateBuilderWithField(aVar4, heavyDetailInfo, a.getNextFieldNumber(aVar4))) {
                        }
                        log_14375.heavyDetailInfo_ = heavyDetailInfo;
                    }
                    AppMethodBeat.o(79163);
                    return 0;
                default:
                    AppMethodBeat.o(79163);
                    return -1;
            }
        } else {
            AppMethodBeat.o(79163);
            return -1;
        }
    }
}
