package com.tencent.smtt.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo;

/* renamed from: com.tencent.smtt.sdk.ax */
class C44450ax extends Handler {
    /* renamed from: a */
    final /* synthetic */ TbsLogReport f17292a;

    C44450ax(TbsLogReport tbsLogReport, Looper looper) {
        this.f17292a = tbsLogReport;
        super(looper);
    }

    public void handleMessage(Message message) {
        AppMethodBeat.m2504i(64478);
        if (message.what == 600) {
            if (message.obj instanceof TbsLogInfo) {
                try {
                    TbsLogInfo tbsLogInfo = (TbsLogInfo) message.obj;
                    TbsLogReport.m49454a(this.f17292a, message.arg1, tbsLogInfo);
                    AppMethodBeat.m2505o(64478);
                    return;
                } catch (Exception e) {
                }
            }
            AppMethodBeat.m2505o(64478);
            return;
        }
        if (message.what == 601) {
            TbsLogReport.m49453a(this.f17292a);
        }
        AppMethodBeat.m2505o(64478);
    }
}
