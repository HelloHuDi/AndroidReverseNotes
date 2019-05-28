package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;
import com.tencent.smtt.utils.TbsLog;

final class j extends Handler {
    final /* synthetic */ PreInitCallback a;
    final /* synthetic */ Context b;

    j(Looper looper, PreInitCallback preInitCallback, Context context) {
        this.a = preInitCallback;
        this.b = context;
        super(looper);
    }

    public final void handleMessage(Message message) {
        AppMethodBeat.i(63987);
        switch (message.what) {
            case 1:
                QbSdk.B = TbsExtensionFunctionManager.getInstance().canUseFunction(this.b, TbsExtensionFunctionManager.DISABLE_UNPREINIT);
                if (QbSdk.j) {
                    bw c = bv.a().c();
                    if (c != null) {
                        c.a(this.b);
                    }
                }
                if (this.a != null) {
                    this.a.onViewInitFinished(true);
                }
                TbsLog.writeLogToDisk();
                AppMethodBeat.o(63987);
                return;
            case 2:
                if (this.a != null) {
                    this.a.onViewInitFinished(false);
                }
                TbsLog.writeLogToDisk();
                AppMethodBeat.o(63987);
                return;
            case 3:
                if (this.a != null) {
                    this.a.onCoreInitFinished();
                    break;
                }
                break;
        }
        AppMethodBeat.o(63987);
    }
}
