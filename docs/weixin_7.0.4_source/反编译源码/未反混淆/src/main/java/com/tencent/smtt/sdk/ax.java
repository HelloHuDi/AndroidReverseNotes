package com.tencent.smtt.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo;

class ax extends Handler {
    final /* synthetic */ TbsLogReport a;

    ax(TbsLogReport tbsLogReport, Looper looper) {
        this.a = tbsLogReport;
        super(looper);
    }

    public void handleMessage(Message message) {
        AppMethodBeat.i(64478);
        if (message.what == 600) {
            if (message.obj instanceof TbsLogInfo) {
                try {
                    TbsLogInfo tbsLogInfo = (TbsLogInfo) message.obj;
                    TbsLogReport.a(this.a, message.arg1, tbsLogInfo);
                    AppMethodBeat.o(64478);
                    return;
                } catch (Exception e) {
                }
            }
            AppMethodBeat.o(64478);
            return;
        }
        if (message.what == 601) {
            TbsLogReport.a(this.a);
        }
        AppMethodBeat.o(64478);
    }
}
