package com.tencent.mm.plugin.notification.a;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;

public final class a implements b {
    private final int DELAY_TIME = 50;
    private final String TAG = "MicroMsg.NotificationObserver";
    private ak mHandler = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(23094);
            super.handleMessage(message);
            final String string = message.getData().getString("com.tencent.mm.notification.observer");
            aw.RS().m(new Runnable() {
                public final void run() {
                    int i = 0;
                    AppMethodBeat.i(23093);
                    if (g.RN().QY()) {
                        final int Nr = f.Nr();
                        aw.ZK();
                        ad aoO = c.XM().aoO(string);
                        final boolean DX = aoO == null ? false : aoO.DX();
                        if (!DX) {
                            i = f.kF(string);
                        }
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(23092);
                                aw.getNotification().ik(Nr);
                                if (!DX) {
                                    aw.getNotification().y(string, i);
                                }
                                ab.i("MicroMsg.NotificationObserver", "NotificationObserver refresh total badge count: %d, and talker badge count: %d, talker is mute: %b", Integer.valueOf(Nr), Integer.valueOf(i), Boolean.valueOf(DX));
                                d.post(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(23091);
                                        aw.getNotification().k(Nr, string);
                                        if (a.this.oVn) {
                                            a.this.oVn = false;
                                            aw.getNotification().bw(false);
                                        }
                                        AppMethodBeat.o(23091);
                                    }
                                }, "NotificationObserver");
                                AppMethodBeat.o(23092);
                            }
                        });
                        AppMethodBeat.o(23093);
                        return;
                    }
                    ab.w("MicroMsg.NotificationObserver", "account not init.");
                    AppMethodBeat.o(23093);
                }
            }, 500);
            AppMethodBeat.o(23094);
        }
    };
    public boolean oVn = false;

    public a() {
        AppMethodBeat.i(23095);
        AppMethodBeat.o(23095);
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(23096);
        ab.i("MicroMsg.NotificationObserver", "event: %d", Integer.valueOf(i));
        if (!(obj instanceof String) || bo.isNullOrNil((String) obj)) {
            ab.d("MicroMsg.NotificationObserver", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), nVar, obj);
            AppMethodBeat.o(23096);
            return;
        }
        int i2;
        if (aw.ZD()) {
            i2 = 0;
        } else {
            aw.ZK();
            i2 = (int) c.XM().aoM((String) obj).ewQ;
        }
        this.mHandler.removeMessages(i2);
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putString("com.tencent.mm.notification.observer", (String) obj);
        obtain.setData(bundle);
        obtain.what = i2;
        this.mHandler.sendMessageDelayed(obtain, 50);
        AppMethodBeat.o(23096);
    }
}
