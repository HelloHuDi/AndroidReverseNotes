package com.tinkerboots.sdk.tinker.b;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.facebook.internal.NativeProtocol;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.lib.e.d;
import com.tencent.tinker.lib.util.c;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public final class a extends com.tencent.tinker.lib.d.a {
    public a(Context context) {
        super(context);
    }

    public final void a(File file, int i, long j) {
        AppMethodBeat.i(65536);
        super.a(file, i, j);
        Looper.getMainLooper();
        Looper.myQueue().addIdleHandler(new IdleHandler() {
            public final boolean queueIdle() {
                AppMethodBeat.i(CdnLogic.kBizGeneric);
                c.jc(a.this.context).dSj();
                AppMethodBeat.o(CdnLogic.kBizGeneric);
                return false;
            }
        });
        AppMethodBeat.o(65536);
    }

    public final void a(Throwable th, int i) {
        AppMethodBeat.i(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY);
        super.a(th, i);
        AppMethodBeat.o(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY);
    }

    public final void a(String str, String str2, File file, String str3) {
        AppMethodBeat.i(65538);
        super.a(str, str2, file, str3);
        AppMethodBeat.o(65538);
    }

    public final void a(File file, int i, boolean z) {
        AppMethodBeat.i(65539);
        super.a(file, i, z);
        if (i == 1) {
            d dVar = com.tencent.tinker.lib.e.a.iX(this.context).ABJ;
            if (dVar.ABO != null && "00000000000000000000000000000000".equals(dVar.ABO)) {
                com.tencent.tinker.lib.util.a.e("Tinker.ServerLoadReporter", "Roll back patch when restarting main process, restart all other process also!", new Object[0]);
                ShareTinkerInternals.jr(this.context);
            }
        }
        AppMethodBeat.o(65539);
    }
}
