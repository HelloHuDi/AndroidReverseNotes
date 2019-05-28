package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public class log_13913 extends a {
    public int clientVersion_;
    public int device_;
    public int ds_;
    public String error_;
    public int import_ds_;
    public int scene_;
    public long time_stamp_;
    public long uin_;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(79162);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.import_ds_);
            aVar.iz(2, this.ds_);
            aVar.ai(3, this.uin_);
            aVar.iz(4, this.device_);
            aVar.iz(5, this.clientVersion_);
            aVar.ai(6, this.time_stamp_);
            aVar.iz(7, this.scene_);
            if (this.error_ != null) {
                aVar.e(8, this.error_);
            }
            AppMethodBeat.o(79162);
            return 0;
        } else if (i == 1) {
            bs = ((((((e.a.a.b.b.a.bs(1, this.import_ds_) + 0) + e.a.a.b.b.a.bs(2, this.ds_)) + e.a.a.b.b.a.o(3, this.uin_)) + e.a.a.b.b.a.bs(4, this.device_)) + e.a.a.b.b.a.bs(5, this.clientVersion_)) + e.a.a.b.b.a.o(6, this.time_stamp_)) + e.a.a.b.b.a.bs(7, this.scene_);
            if (this.error_ != null) {
                bs += e.a.a.b.b.a.f(8, this.error_);
            }
            AppMethodBeat.o(79162);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(79162);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            log_13913 log_13913 = (log_13913) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    log_13913.import_ds_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79162);
                    return 0;
                case 2:
                    log_13913.ds_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79162);
                    return 0;
                case 3:
                    log_13913.uin_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79162);
                    return 0;
                case 4:
                    log_13913.device_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79162);
                    return 0;
                case 5:
                    log_13913.clientVersion_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79162);
                    return 0;
                case 6:
                    log_13913.time_stamp_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79162);
                    return 0;
                case 7:
                    log_13913.scene_ = aVar3.BTU.vd();
                    AppMethodBeat.o(79162);
                    return 0;
                case 8:
                    log_13913.error_ = aVar3.BTU.readString();
                    AppMethodBeat.o(79162);
                    return 0;
                default:
                    AppMethodBeat.o(79162);
                    return -1;
            }
        } else {
            AppMethodBeat.o(79162);
            return -1;
        }
    }
}
