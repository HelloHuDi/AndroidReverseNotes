package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;
import com.tencent.smtt.utils.TbsLog;

/* renamed from: com.tencent.smtt.sdk.j */
final class C40980j extends Handler {
    /* renamed from: a */
    final /* synthetic */ PreInitCallback f16305a;
    /* renamed from: b */
    final /* synthetic */ Context f16306b;

    C40980j(Looper looper, PreInitCallback preInitCallback, Context context) {
        this.f16305a = preInitCallback;
        this.f16306b = context;
        super(looper);
    }

    public final void handleMessage(Message message) {
        AppMethodBeat.m2504i(63987);
        switch (message.what) {
            case 1:
                QbSdk.f16233B = TbsExtensionFunctionManager.getInstance().canUseFunction(this.f16306b, TbsExtensionFunctionManager.DISABLE_UNPREINIT);
                if (QbSdk.f16248j) {
                    C36438bw c = C40978bv.m71073a().mo64922c();
                    if (c != null) {
                        c.mo57558a(this.f16306b);
                    }
                }
                if (this.f16305a != null) {
                    this.f16305a.onViewInitFinished(true);
                }
                TbsLog.writeLogToDisk();
                AppMethodBeat.m2505o(63987);
                return;
            case 2:
                if (this.f16305a != null) {
                    this.f16305a.onViewInitFinished(false);
                }
                TbsLog.writeLogToDisk();
                AppMethodBeat.m2505o(63987);
                return;
            case 3:
                if (this.f16305a != null) {
                    this.f16305a.onCoreInitFinished();
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(63987);
    }
}
