package com.tencent.mm.plugin.music.model.notification;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import junit.framework.Assert;

public final class b {
    public c hAA;
    public MMMusicPlayerService oMK;
    volatile boolean oMQ = false;

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void bUr() {
        AppMethodBeat.i(104990);
        if (this.oMK == null || !this.oMQ) {
            this.oMQ = true;
            Intent intent = new Intent();
            intent.setClass(ah.getContext(), MMMusicPlayerService.class);
            boolean bindService = ah.getContext().bindService(intent, new ServiceConnection() {
                public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    AppMethodBeat.i(104988);
                    ab.i("MicroMsg.Music.MMMusicNotificationHelper", "onServiceConnected");
                    if (iBinder instanceof a) {
                        b.this.oMQ = false;
                        b.this.oMK = MMMusicPlayerService.this;
                        AppMethodBeat.o(104988);
                        return;
                    }
                    ab.e("MicroMsg.Music.MMMusicNotificationHelper", "service %s isn't MMMusicPlayerService, err, return", iBinder.getClass().getName());
                    Assert.assertTrue(false);
                    AppMethodBeat.o(104988);
                }

                public final void onServiceDisconnected(ComponentName componentName) {
                    AppMethodBeat.i(104989);
                    ab.i("MicroMsg.Music.MMMusicNotificationHelper", "onServiceDisconnected");
                    b.this.oMQ = false;
                    b.this.oMK = null;
                    AppMethodBeat.o(104989);
                }
            }, 1);
            ab.i("MicroMsg.Music.MMMusicNotificationHelper", "isOk:%b", Boolean.valueOf(bindService));
            AppMethodBeat.o(104990);
        } else {
            AppMethodBeat.o(104990);
        }
    }
}
