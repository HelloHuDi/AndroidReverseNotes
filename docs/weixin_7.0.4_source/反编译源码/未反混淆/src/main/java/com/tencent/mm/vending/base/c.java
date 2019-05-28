package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    private Looper b;
    private Handler c;
    private Handler d;
    byte[] e = new byte[0];
    a zXA;
    private Looper zXz;

    public interface a {
        void dMc();

        void dMd();

        void synchronizing(int i, Object obj);
    }

    public c(Looper looper, Looper looper2) {
        AppMethodBeat.i(126148);
        this.zXz = looper;
        this.b = looper2;
        this.c = new Handler(this.zXz) {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(126162);
                c.this.s(message.what, message.obj);
                AppMethodBeat.o(126162);
            }
        };
        this.d = new Handler(this.b) {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(126153);
                synchronized (c.this.e) {
                    try {
                        if (c.this.zXA != null) {
                            c.this.zXA.synchronizing(message.what, message.obj);
                        }
                        c.this.e.notify();
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(126153);
                    }
                }
            }
        };
        AppMethodBeat.o(126148);
    }

    public final void s(int i, Object obj) {
        AppMethodBeat.i(126149);
        if (Looper.myLooper() == this.zXz) {
            if (this.zXA == null) {
                com.tencent.mm.vending.f.a.w("Vending.VendingSync", "This call is pointless.", new Object[0]);
                AppMethodBeat.o(126149);
                return;
            }
            this.zXA.dMc();
            synchronized (this.e) {
                try {
                    this.d.sendMessageAtFrontOfQueue(this.d.obtainMessage(i, obj));
                    try {
                        this.e.wait();
                    } catch (InterruptedException e) {
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(126149);
                }
            }
            this.zXA.dMd();
        } else if (Looper.myLooper() == this.b) {
            this.c.sendMessageAtFrontOfQueue(this.c.obtainMessage(i, obj));
            AppMethodBeat.o(126149);
        } else {
            AppMethodBeat.o(126149);
        }
    }
}
